// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, PrimitiveFactory, Primitive, Context, 
//            Entry, PersistenceException

class PrimitiveValue
    implements Converter
{

    private final Context context;
    private final Entry entry;
    private final PrimitiveFactory factory;
    private final Primitive root;
    private final Style style;
    private final Type type;

    public PrimitiveValue(Context context1, Entry entry1, Type type1)
    {
        factory = new PrimitiveFactory(context1, type1);
        root = new Primitive(context1, type1);
        style = context1.getStyle();
        context = context1;
        entry = entry1;
        type = type1;
    }

    private boolean isOverridden(OutputNode outputnode, Object obj)
    {
        return factory.setOverride(type, obj, outputnode);
    }

    private Object readAttribute(InputNode inputnode, String s)
    {
        if (s != null)
        {
            inputnode = inputnode.getAttribute(style.getAttribute(s));
        }
        if (inputnode == null)
        {
            return null;
        } else
        {
            return root.read(inputnode);
        }
    }

    private Object readElement(InputNode inputnode, String s)
    {
        InputNode inputnode1 = inputnode.getNext(style.getAttribute(s));
        if (inputnode1 == null)
        {
            return null;
        } else
        {
            return root.read(inputnode1);
        }
    }

    private boolean validateAttribute(InputNode inputnode, String s)
    {
        if (s != null)
        {
            inputnode = inputnode.getNext(style.getAttribute(s));
        }
        if (inputnode == null)
        {
            return true;
        } else
        {
            return root.validate(inputnode);
        }
    }

    private boolean validateElement(InputNode inputnode, String s)
    {
        if (inputnode.getNext(style.getAttribute(s)) == null)
        {
            return true;
        } else
        {
            return root.validate(inputnode);
        }
    }

    private void writeAttribute(OutputNode outputnode, Object obj, String s)
    {
        if (obj != null)
        {
            if (s != null)
            {
                outputnode = outputnode.setAttribute(style.getAttribute(s), null);
            }
            root.write(outputnode, obj);
        }
    }

    private void writeElement(OutputNode outputnode, Object obj, String s)
    {
        OutputNode outputnode1 = outputnode.getChild(style.getAttribute(s));
        if (obj != null && !isOverridden(outputnode1, obj))
        {
            root.write(outputnode1, obj);
        }
    }

    public Object read(InputNode inputnode)
    {
        Class class1 = type.getType();
        String s = entry.getValue();
        if (!entry.isInline())
        {
            if (s == null)
            {
                s = context.getName(class1);
            }
            return readElement(inputnode, s);
        } else
        {
            return readAttribute(inputnode, s);
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        Class class1 = type.getType();
        if (obj != null)
        {
            Object aobj[] = new Object[2];
            aobj[0] = class1;
            aobj[1] = entry;
            throw new PersistenceException("Can not read value of %s for %s", aobj);
        } else
        {
            return read(inputnode);
        }
    }

    public boolean validate(InputNode inputnode)
    {
        Class class1 = type.getType();
        String s = entry.getValue();
        if (!entry.isInline())
        {
            if (s == null)
            {
                s = context.getName(class1);
            }
            return validateElement(inputnode, s);
        } else
        {
            return validateAttribute(inputnode, s);
        }
    }

    public void write(OutputNode outputnode, Object obj)
    {
        Class class1 = type.getType();
        String s = entry.getValue();
        if (!entry.isInline())
        {
            if (s == null)
            {
                s = context.getName(class1);
            }
            writeElement(outputnode, obj, s);
            return;
        } else
        {
            writeAttribute(outputnode, obj, s);
            return;
        }
    }
}
