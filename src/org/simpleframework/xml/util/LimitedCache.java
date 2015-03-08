// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.LinkedHashMap;

// Referenced classes of package org.simpleframework.xml.util:
//            Cache

public class LimitedCache extends LinkedHashMap
    implements Cache
{

    private final int capacity;

    public LimitedCache()
    {
        this(50000);
    }

    public LimitedCache(int i)
    {
        capacity = i;
    }

    public void cache(Object obj, Object obj1)
    {
        put(obj, obj1);
    }

    public boolean contains(Object obj)
    {
        return containsKey(obj);
    }

    public Object fetch(Object obj)
    {
        return get(obj);
    }

    protected boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        return size() > capacity;
    }

    public Object take(Object obj)
    {
        return remove(obj);
    }
}
