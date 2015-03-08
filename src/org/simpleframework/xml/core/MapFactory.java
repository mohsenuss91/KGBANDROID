// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Factory, InstantiationException, ConversionInstance, Context, 
//            Instance

class MapFactory extends Factory
{

    public MapFactory(Context context, Type type)
    {
        super(context, type);
    }

    private boolean isMap(Class class1)
    {
        return java/util/Map.isAssignableFrom(class1);
    }

    public Class getConversion(Class class1)
    {
        if (class1.isAssignableFrom(java/util/HashMap))
        {
            return java/util/HashMap;
        }
        if (class1.isAssignableFrom(java/util/TreeMap))
        {
            return java/util/TreeMap;
        } else
        {
            Object aobj[] = new Object[2];
            aobj[0] = class1;
            aobj[1] = type;
            throw new InstantiationException("Cannot instantiate %s for %s", aobj);
        }
    }

    public Object getInstance()
    {
        Class class1 = getType();
        Class class2;
        if (!isInstantiable(class1))
        {
            class2 = getConversion(class1);
        } else
        {
            class2 = class1;
        }
        if (!isMap(class2))
        {
            Object aobj[] = new Object[2];
            aobj[0] = class1;
            aobj[1] = type;
            throw new InstantiationException("Invalid map %s for %s", aobj);
        } else
        {
            return class2.newInstance();
        }
    }

    public Instance getInstance(Value value)
    {
        Class class1 = value.getType();
        if (!isInstantiable(class1))
        {
            class1 = getConversion(class1);
        }
        if (!isMap(class1))
        {
            Object aobj[] = new Object[2];
            aobj[0] = class1;
            aobj[1] = type;
            throw new InstantiationException("Invalid map %s for %s", aobj);
        } else
        {
            return new ConversionInstance(context, value, class1);
        }
    }

    public Instance getInstance(InputNode inputnode)
    {
        Value value = getOverride(inputnode);
        Class class1 = getType();
        if (value != null)
        {
            return getInstance(value);
        }
        if (!isInstantiable(class1))
        {
            class1 = getConversion(class1);
        }
        if (!isMap(class1))
        {
            Object aobj[] = new Object[2];
            aobj[0] = class1;
            aobj[1] = type;
            throw new InstantiationException("Invalid map %s for %s", aobj);
        } else
        {
            return context.getInstance(class1);
        }
    }
}
