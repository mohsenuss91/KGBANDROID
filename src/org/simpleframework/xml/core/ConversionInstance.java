// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

// Referenced classes of package org.simpleframework.xml.core:
//            Instance, Context

class ConversionInstance
    implements Instance
{

    private final Context context;
    private final Class convert;
    private final Value value;

    public ConversionInstance(Context context1, Value value1, Class class1)
    {
        context = context1;
        convert = class1;
        value = value1;
    }

    public Object getInstance()
    {
        Object obj;
        if (value.isReference())
        {
            obj = value.getValue();
        } else
        {
            obj = getInstance(convert);
            if (obj != null)
            {
                setInstance(obj);
                return obj;
            }
        }
        return obj;
    }

    public Object getInstance(Class class1)
    {
        return context.getInstance(class1).getInstance();
    }

    public Class getType()
    {
        return convert;
    }

    public boolean isReference()
    {
        return value.isReference();
    }

    public Object setInstance(Object obj)
    {
        if (value != null)
        {
            value.setValue(obj);
        }
        return obj;
    }
}
