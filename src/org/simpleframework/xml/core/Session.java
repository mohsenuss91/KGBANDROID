// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class Session
    implements Map
{

    private final Map map;
    private final boolean strict;

    public Session()
    {
        this(true);
    }

    public Session(boolean flag)
    {
        map = new HashMap();
        strict = flag;
    }

    public final void clear()
    {
        map.clear();
    }

    public final boolean containsKey(Object obj)
    {
        return map.containsKey(obj);
    }

    public final boolean containsValue(Object obj)
    {
        return map.containsValue(obj);
    }

    public final Set entrySet()
    {
        return map.entrySet();
    }

    public final Object get(Object obj)
    {
        return map.get(obj);
    }

    public final Map getMap()
    {
        return map;
    }

    public final boolean isEmpty()
    {
        return map.isEmpty();
    }

    public final boolean isStrict()
    {
        return strict;
    }

    public final Set keySet()
    {
        return map.keySet();
    }

    public final Object put(Object obj, Object obj1)
    {
        return map.put(obj, obj1);
    }

    public final void putAll(Map map1)
    {
        map.putAll(map1);
    }

    public final Object remove(Object obj)
    {
        return map.remove(obj);
    }

    public final int size()
    {
        return map.size();
    }

    public final Collection values()
    {
        return map.values();
    }
}
