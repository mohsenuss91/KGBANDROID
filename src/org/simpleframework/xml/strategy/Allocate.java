// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import java.util.Map;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Value

class Allocate
    implements Value
{

    private String key;
    private Map map;
    private Value value;

    public Allocate(Value value1, Map map1, String s)
    {
        value = value1;
        map = map1;
        key = s;
    }

    public int getLength()
    {
        return value.getLength();
    }

    public Class getType()
    {
        return value.getType();
    }

    public Object getValue()
    {
        return map.get(key);
    }

    public boolean isReference()
    {
        return false;
    }

    public void setValue(Object obj)
    {
        if (key != null)
        {
            map.put(key, obj);
        }
        value.setValue(obj);
    }
}
