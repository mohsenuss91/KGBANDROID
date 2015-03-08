// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package org.simpleframework.xml.util:
//            Cache

public class ConcurrentCache extends ConcurrentHashMap
    implements Cache
{

    public ConcurrentCache()
    {
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

    public Object take(Object obj)
    {
        return remove(obj);
    }
}
