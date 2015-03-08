// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, ArrayFactory, Primitive, Instance, 
//            ElementException, Context

class PrimitiveArray
    implements Converter
{

    private final Type entry;
    private final ArrayFactory factory;
    private final String parent;
    private final Primitive root;
    private final Type type;

    public PrimitiveArray(Context context, Type type1, Type type2, String s)
    {
        factory = new ArrayFactory(context, type1);
        root = new Primitive(context, type2);
        parent = s;
        entry = type2;
        type = type1;
    }

    private boolean isOverridden(OutputNode outputnode, Object obj)
    {
        return factory.setOverride(entry, obj, outputnode);
    }

    private boolean validate(InputNode inputnode, Class class1)
    {
        do
        {
            InputNode inputnode1 = inputnode.getNext();
            if (inputnode1 == null)
            {
                return true;
            }
            root.validate(inputnode1);
        } while (true);
    }

    private void write(OutputNode outputnode, Object obj, int i)
    {
        Object obj1 = Array.get(obj, i);
        if (obj1 != null && !isOverridden(outputnode, obj1))
        {
            root.write(outputnode, obj1);
        }
    }

    public Object read(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        Object obj = instance.getInstance();
        if (!instance.isReference())
        {
            obj = read(inputnode, obj);
        }
        return obj;
    }

    public Object read(InputNode inputnode, Object obj)
    {
        int i = Array.getLength(obj);
        int j = 0;
        do
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            InputNode inputnode1 = inputnode.getNext();
            if (inputnode1 == null)
            {
                return obj;
            }
            if (j >= i)
            {
                Object aobj[] = new Object[2];
                aobj[0] = type;
                aobj[1] = position;
                throw new ElementException("Array length missing or incorrect for %s at %s", aobj);
            }
            Array.set(obj, j, root.read(inputnode1));
            j++;
        } while (true);
    }

    public boolean validate(InputNode inputnode)
    {
        Instance instance = factory.getInstance(inputnode);
        if (!instance.isReference())
        {
            instance.setInstance(null);
            return validate(inputnode, instance.getType());
        } else
        {
            return true;
        }
    }

    public void write(OutputNode outputnode, Object obj)
    {
        int i = Array.getLength(obj);
        int j = 0;
        do
        {
            if (j >= i)
            {
                break;
            }
            OutputNode outputnode1 = outputnode.getChild(parent);
            if (outputnode1 == null)
            {
                break;
            }
            write(outputnode1, obj, j);
            j++;
        } while (true);
    }
}
