// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, PrimitiveFactory, Instance, Context, 
//            PersistenceException

class Primitive
    implements Converter
{

    private final Context context;
    private final String empty;
    private final Class expect;
    private final PrimitiveFactory factory;
    private final Type type;

    public Primitive(Context context1, Type type1)
    {
        this(context1, type1, null);
    }

    public Primitive(Context context1, Type type1, String s)
    {
        factory = new PrimitiveFactory(context1, type1);
        expect = type1.getType();
        context = context1;
        empty = s;
        type = type1;
    }

    private Object readElement(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        if (!instance.isReference())
        {
            return readElement(inputnode, instance);
        } else
        {
            return instance.getInstance();
        }
    }

    private Object readElement(InputNode inputnode, Instance instance)
    {
        Object obj = read(inputnode, expect);
        if (instance != null)
        {
            instance.setInstance(obj);
        }
        return obj;
    }

    private Object readTemplate(String s, Class class1)
    {
        String s1 = context.getProperty(s);
        if (s1 != null)
        {
            return factory.getInstance(s1, class1);
        } else
        {
            return null;
        }
    }

    private boolean validateElement(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        if (!instance.isReference())
        {
            instance.setInstance(null);
        }
        return true;
    }

    public Object read(InputNode inputnode)
    {
        if (inputnode.isElement())
        {
            return readElement(inputnode);
        } else
        {
            return read(inputnode, expect);
        }
    }

    public Object read(InputNode inputnode, Class class1)
    {
        String s = inputnode.getValue();
        if (s == null)
        {
            return null;
        }
        if (empty != null && s.equals(empty))
        {
            return empty;
        } else
        {
            return readTemplate(s, class1);
        }
    }

    public Object read(InputNode inputnode, Object obj)
    {
        if (obj != null)
        {
            Object aobj[] = new Object[2];
            aobj[0] = expect;
            aobj[1] = type;
            throw new PersistenceException("Can not read existing %s for %s", aobj);
        } else
        {
            return read(inputnode);
        }
    }

    public boolean validate(InputNode inputnode)
    {
        if (inputnode.isElement())
        {
            validateElement(inputnode);
        } else
        {
            inputnode.getValue();
        }
        return true;
    }

    public void write(OutputNode outputnode, Object obj)
    {
        String s = factory.getText(obj);
        if (s != null)
        {
            outputnode.setValue(s);
        }
    }
}
