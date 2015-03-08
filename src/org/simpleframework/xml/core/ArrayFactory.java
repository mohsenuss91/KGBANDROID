// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Factory, InstantiationException, ArrayInstance, ElementException, 
//            Context, Instance

class ArrayFactory extends Factory
{

    public ArrayFactory(Context context, Type type)
    {
        super(context, type);
    }

    private Class getComponentType()
    {
        Class class1 = getType();
        if (!class1.isArray())
        {
            Object aobj[] = new Object[2];
            aobj[0] = class1;
            aobj[1] = type;
            throw new InstantiationException("The %s not an array for %s", aobj);
        } else
        {
            return class1.getComponentType();
        }
    }

    private Instance getInstance(Value value, Class class1)
    {
        Class class2 = getComponentType();
        if (!class2.isAssignableFrom(class1))
        {
            Object aobj[] = new Object[3];
            aobj[0] = class2;
            aobj[1] = class1;
            aobj[2] = type;
            throw new InstantiationException("Array of type %s cannot hold %s for %s", aobj);
        } else
        {
            return new ArrayInstance(value);
        }
    }

    public Object getInstance()
    {
        Class class1 = getComponentType();
        if (class1 != null)
        {
            return Array.newInstance(class1, 0);
        } else
        {
            return null;
        }
    }

    public Instance getInstance(InputNode inputnode)
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        Value value = getOverride(inputnode);
        if (value == null)
        {
            Object aobj[] = new Object[2];
            aobj[0] = type;
            aobj[1] = position;
            throw new ElementException("Array length required for %s at %s", aobj);
        } else
        {
            return getInstance(value, value.getType());
        }
    }
}
