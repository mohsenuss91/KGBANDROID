// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Repeater, Group, Context, Label, 
//            Converter, UnionException, Expression, LabelMap

class CompositeMapUnion
    implements Repeater
{

    private final Context context;
    private final LabelMap elements;
    private final Group group;
    private final Expression path;
    private final Style style;
    private final Type type;

    public CompositeMapUnion(Context context1, Group group1, Expression expression, Type type1)
    {
        elements = group1.getElements();
        style = context1.getStyle();
        context = context1;
        group = group1;
        type = type1;
        path = expression;
    }

    private void write(OutputNode outputnode, Object obj, Object obj1, Label label)
    {
        Converter converter = label.getConverter(context);
        Map map = Collections.singletonMap(obj, obj1);
        if (!label.isInline())
        {
            String s = label.getName();
            String s1 = style.getElement(s);
            if (!outputnode.isCommitted())
            {
                outputnode.setName(s1);
            }
        }
        converter.write(outputnode, map);
    }

    private void write(OutputNode outputnode, Map map)
    {
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            Object obj1 = map.get(obj);
            if (obj1 != null)
            {
                Class class1 = obj1.getClass();
                Label label = group.getLabel(class1);
                if (label == null)
                {
                    Object aobj[] = new Object[3];
                    aobj[0] = class1;
                    aobj[1] = type;
                    aobj[2] = group;
                    throw new UnionException("Value of %s not declared in %s with annotation %s", aobj);
                }
                write(outputnode, obj, obj1, label);
            }
        } while (true);
    }

    public Object read(InputNode inputnode)
    {
        String s = inputnode.getName();
        String s1 = path.getElement(s);
        return ((Label)elements.get(s1)).getConverter(context).read(inputnode);
    }

    public Object read(InputNode inputnode, Object obj)
    {
        String s = inputnode.getName();
        String s1 = path.getElement(s);
        return ((Label)elements.get(s1)).getConverter(context).read(inputnode, obj);
    }

    public boolean validate(InputNode inputnode)
    {
        String s = inputnode.getName();
        String s1 = path.getElement(s);
        return ((Label)elements.get(s1)).getConverter(context).validate(inputnode);
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Map map = (Map)obj;
        if (group.isInline() && map.isEmpty())
        {
            if (!outputnode.isCommitted())
            {
                outputnode.remove();
            }
            return;
        } else
        {
            write(outputnode, map);
            return;
        }
    }
}
