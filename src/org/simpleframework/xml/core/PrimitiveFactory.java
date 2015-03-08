// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Factory, Support, Context, ObjectInstance, 
//            Instance

class PrimitiveFactory extends Factory
{

    public PrimitiveFactory(Context context, Type type)
    {
        super(context, type);
    }

    public PrimitiveFactory(Context context, Type type, Class class1)
    {
        super(context, type, class1);
    }

    public Object getInstance(String s, Class class1)
    {
        return support.read(s, class1);
    }

    public Instance getInstance(InputNode inputnode)
    {
        org.simpleframework.xml.strategy.Value value = getOverride(inputnode);
        Class class1 = getType();
        if (value == null)
        {
            return context.getInstance(class1);
        } else
        {
            return new ObjectInstance(context, value);
        }
    }

    public String getText(Object obj)
    {
        Class class1 = obj.getClass();
        if (class1.isEnum())
        {
            return support.write(obj, class1);
        } else
        {
            return support.write(obj, class1);
        }
    }
}
