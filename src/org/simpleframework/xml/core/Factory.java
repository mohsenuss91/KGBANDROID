// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Modifier;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Context, Support, OverrideType, OverrideValue, 
//            InstantiationException

abstract class Factory
{

    protected Context context;
    protected Class override;
    protected Support support;
    protected Type type;

    protected Factory(Context context1, Type type1)
    {
        this(context1, type1, null);
    }

    protected Factory(Context context1, Type type1, Class class1)
    {
        support = context1.getSupport();
        override = class1;
        context = context1;
        type = type1;
    }

    private Type getPrimitive(Type type1, Class class1)
    {
        Support _tmp = support;
        Class class2 = Support.getPrimitive(class1);
        if (class2 != class1)
        {
            type1 = new OverrideType(type1, class2);
        }
        return type1;
    }

    public static boolean isCompatible(Class class1, Class class2)
    {
        if (class1.isArray())
        {
            class1 = class1.getComponentType();
        }
        return class1.isAssignableFrom(class2);
    }

    public static boolean isInstantiable(Class class1)
    {
        for (int i = class1.getModifiers(); Modifier.isAbstract(i) || Modifier.isInterface(i);)
        {
            return false;
        }

        return true;
    }

    public Value getConversion(InputNode inputnode)
    {
        Value value = context.getOverride(type, inputnode);
        if (value != null && override != null)
        {
            Class class1 = value.getType();
            if (!isCompatible(override, class1))
            {
                return new OverrideValue(value, override);
            }
        }
        return value;
    }

    public Object getInstance()
    {
        Class class1 = getType();
        if (!isInstantiable(class1))
        {
            throw new InstantiationException("Type %s can not be instantiated", new Object[] {
                class1
            });
        } else
        {
            return class1.newInstance();
        }
    }

    protected Value getOverride(InputNode inputnode)
    {
        Value value = getConversion(inputnode);
        if (value != null)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            Class class1 = value.getType();
            if (!isCompatible(getType(), class1))
            {
                Object aobj[] = new Object[3];
                aobj[0] = class1;
                aobj[1] = type;
                aobj[2] = position;
                throw new InstantiationException("Incompatible %s for %s at %s", aobj);
            }
        }
        return value;
    }

    public Class getType()
    {
        if (override != null)
        {
            return override;
        } else
        {
            return type.getType();
        }
    }

    public boolean setOverride(Type type1, Object obj, OutputNode outputnode)
    {
        Class class1 = type1.getType();
        if (class1.isPrimitive())
        {
            type1 = getPrimitive(type1, class1);
        }
        return context.setOverride(type1, obj, outputnode);
    }
}
