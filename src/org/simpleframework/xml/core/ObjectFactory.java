// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            PrimitiveFactory, InstantiationException, Context, ObjectInstance, 
//            Instance

class ObjectFactory extends PrimitiveFactory
{

    public ObjectFactory(Context context, Type type, Class class1)
    {
        super(context, type, class1);
    }

    public Instance getInstance(InputNode inputnode)
    {
        org.simpleframework.xml.strategy.Value value = getOverride(inputnode);
        Class class1 = getType();
        if (value == null)
        {
            if (!isInstantiable(class1))
            {
                Object aobj[] = new Object[2];
                aobj[0] = class1;
                aobj[1] = type;
                throw new InstantiationException("Cannot instantiate %s for %s", aobj);
            } else
            {
                return context.getInstance(class1);
            }
        } else
        {
            return new ObjectInstance(context, value);
        }
    }
}
