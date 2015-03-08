// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Repeater, Group, Context, Expression, 
//            LabelMap, Label, Converter, UnionException

class CompositeListUnion
    implements Repeater
{

    private final Context context;
    private final LabelMap elements;
    private final Group group;
    private final Expression path;
    private final Style style;
    private final Type type;

    public CompositeListUnion(Context context1, Group group1, Expression expression, Type type1)
    {
        elements = group1.getElements();
        style = context1.getStyle();
        context = context1;
        group = group1;
        type = type1;
        path = expression;
    }

    private Object readElement(InputNode inputnode)
    {
        String s = inputnode.getName();
        String s1 = path.getElement(s);
        return ((Label)elements.get(s1)).getConverter(context).read(inputnode);
    }

    private Object readElement(InputNode inputnode, Object obj)
    {
        String s = inputnode.getName();
        String s1 = path.getElement(s);
        return ((Label)elements.get(s1)).getConverter(context).read(inputnode, obj);
    }

    private Object readText(InputNode inputnode)
    {
        return group.getText().getConverter(context).read(inputnode);
    }

    private Object readText(InputNode inputnode, Object obj)
    {
        return group.getText().getConverter(context).read(inputnode.getParent(), obj);
    }

    private void write(OutputNode outputnode, Object obj, Label label)
    {
        Converter converter = label.getConverter(context);
        java.util.Set set = Collections.singleton(obj);
        if (!label.isInline())
        {
            String s = label.getName();
            String s1 = style.getElement(s);
            if (!outputnode.isCommitted())
            {
                outputnode.setName(s1);
            }
        }
        converter.write(outputnode, set);
    }

    private void write(OutputNode outputnode, Collection collection)
    {
        Iterator iterator = collection.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj != null)
            {
                Class class1 = obj.getClass();
                Label label = group.getLabel(class1);
                if (label == null)
                {
                    Object aobj[] = new Object[3];
                    aobj[0] = class1;
                    aobj[1] = type;
                    aobj[2] = group;
                    throw new UnionException("Entry of %s not declared in %s with annotation %s", aobj);
                }
                write(outputnode, obj, label);
            }
        } while (true);
    }

    public Object read(InputNode inputnode)
    {
        if (group.getText() == null)
        {
            return readElement(inputnode);
        } else
        {
            return readText(inputnode);
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Object obj1 = readElement(inputnode, obj);
        if (group.getText() != null)
        {
            obj1 = readText(inputnode, obj);
        }
        return obj1;
    }

    public boolean validate(InputNode inputnode)
    {
        String s = inputnode.getName();
        String s1 = path.getElement(s);
        return ((Label)elements.get(s1)).getConverter(context).validate(inputnode);
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Collection collection = (Collection)obj;
        if (group.isInline() && collection.isEmpty())
        {
            if (!outputnode.isCommitted())
            {
                outputnode.remove();
            }
            return;
        } else
        {
            write(outputnode, collection);
            return;
        }
    }
}
