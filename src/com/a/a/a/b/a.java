// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.a.a.a.b:
//            c

public abstract class a
    implements c
{

    private final Map a = Collections.synchronizedMap(new HashMap());

    public a()
    {
    }

    public Object a(Object obj)
    {
        Reference reference = (Reference)a.get(obj);
        if (reference != null)
        {
            return reference.get();
        } else
        {
            return null;
        }
    }

    public final Collection a()
    {
        HashSet hashset;
        synchronized (a)
        {
            hashset = new HashSet(a.keySet());
        }
        return hashset;
    }

    public boolean a(Object obj, Object obj1)
    {
        a.put(obj, c(obj1));
        return true;
    }

    public void b()
    {
        a.clear();
    }

    public void b(Object obj)
    {
        a.remove(obj);
    }

    protected abstract Reference c(Object obj);
}
