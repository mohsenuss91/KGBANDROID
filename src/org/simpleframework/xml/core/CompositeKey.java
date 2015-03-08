// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, Traverser, Context, Entry, 
//            AttributeException, PersistenceException, ElementException

class CompositeKey
    implements Converter
{

    private final Context context;
    private final Entry entry;
    private final Traverser root;
    private final Style style;
    private final Type type;

    public CompositeKey(Context context1, Entry entry1, Type type1)
    {
        root = new Traverser(context1);
        style = context1.getStyle();
        context = context1;
        entry = entry1;
        type = type1;
    }

    private Object read(InputNode inputnode, String s)
    {
        String s1 = style.getElement(s);
        Class class1 = type.getType();
        if (s1 != null)
        {
            inputnode = inputnode.getNext(s1);
        }
        while (inputnode == null || inputnode.isEmpty()) 
        {
            return null;
        }
        return root.read(inputnode, class1);
    }

    private boolean validate(InputNode inputnode, String s)
    {
        InputNode inputnode1 = inputnode.getNext(style.getElement(s));
        Class class1;
        for (class1 = type.getType(); inputnode1 == null || inputnode1.isEmpty();)
        {
            return true;
        }

        return root.validate(inputnode1, class1);
    }

    public Object read(InputNode inputnode)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        Class class1 = type.getType();
        String s = entry.getKey();
        if (s == null)
        {
            s = context.getName(class1);
        }
        if (entry.isAttribute())
        {
            Object aobj[] = new Object[3];
            aobj[0] = class1;
            aobj[1] = entry;
            aobj[2] = position;
            throw new AttributeException("Can not have %s as an attribute for %s at %s", aobj);
        } else
        {
            return read(inputnode, s);
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        Class class1 = type.getType();
        if (obj != null)
        {
            Object aobj[] = new Object[3];
            aobj[0] = class1;
            aobj[1] = entry;
            aobj[2] = position;
            throw new PersistenceException("Can not read key of %s for %s at %s", aobj);
        } else
        {
            return read(inputnode);
        }
    }

    public boolean validate(InputNode inputnode)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        Class class1 = type.getType();
        String s = entry.getKey();
        if (s == null)
        {
            s = context.getName(class1);
        }
        if (entry.isAttribute())
        {
            Object aobj[] = new Object[3];
            aobj[0] = class1;
            aobj[1] = entry;
            aobj[2] = position;
            throw new ElementException("Can not have %s as an attribute for %s at %s", aobj);
        } else
        {
            return validate(inputnode, s);
        }
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Class class1 = type.getType();
        String s = entry.getKey();
        if (entry.isAttribute())
        {
            Object aobj[] = new Object[2];
            aobj[0] = class1;
            aobj[1] = entry;
            throw new ElementException("Can not have %s as an attribute for %s", aobj);
        }
        if (s == null)
        {
            s = context.getName(class1);
        }
        String s1 = style.getElement(s);
        root.write(outputnode, obj, class1, s1);
    }
}
