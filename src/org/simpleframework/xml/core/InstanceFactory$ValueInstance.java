// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Value;

// Referenced classes of package org.simpleframework.xml.core:
//            Instance, InstanceFactory

class value
    implements Instance
{

    final InstanceFactory this$0;
    private final Class type;
    private final Value value;

    public Object getInstance()
    {
        Object obj;
        if (value.isReference())
        {
            obj = value.getValue();
        } else
        {
            obj = getObject(type);
            if (value != null)
            {
                value.setValue(obj);
                return obj;
            }
        }
        return obj;
    }

    public Class getType()
    {
        return type;
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

    public (Value value1)
    {
        this$0 = InstanceFactory.this;
        super();
        type = value1.getType();
        value = value1;
    }
}
