// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Value;

// Referenced classes of package org.simpleframework.xml.core:
//            Instance

class ArrayInstance
    implements Instance
{

    private final int length;
    private final Class type;
    private final Value value;

    public ArrayInstance(Value value1)
    {
        length = value1.getLength();
        type = value1.getType();
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
            obj = Array.newInstance(type, length);
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
}
