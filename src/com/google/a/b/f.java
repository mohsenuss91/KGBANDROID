// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.c.a;
import com.google.a.s;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

// Referenced classes of package com.google.a.b:
//            l, g, k, m, 
//            j, n, o, p, 
//            q, r, h, i, 
//            ae

public final class f
{

    private final Map a;

    public f(Map map)
    {
        a = map;
    }

    private ae a(Class class1)
    {
        l l1;
        try
        {
            Constructor constructor = class1.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible())
            {
                constructor.setAccessible(true);
            }
            l1 = new l(this, constructor);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return null;
        }
        return l1;
    }

    public final ae a(a a1)
    {
        java.lang.reflect.Type type = a1.b;
        Class class1 = a1.a;
        s s1 = (s)a.get(type);
        Object obj;
        if (s1 != null)
        {
            obj = new g(this, s1, type);
        } else
        {
            s s2 = (s)a.get(class1);
            if (s2 != null)
            {
                return new k(this, s2, type);
            }
            obj = a(class1);
            if (obj == null)
            {
                if (java/util/Collection.isAssignableFrom(class1))
                {
                    if (java/util/SortedSet.isAssignableFrom(class1))
                    {
                        obj = new m(this);
                    } else
                    if (java/util/EnumSet.isAssignableFrom(class1))
                    {
                        obj = new n(this, type);
                    } else
                    if (java/util/Set.isAssignableFrom(class1))
                    {
                        obj = new o(this);
                    } else
                    if (java/util/Queue.isAssignableFrom(class1))
                    {
                        obj = new p(this);
                    } else
                    {
                        obj = new q(this);
                    }
                } else
                if (java/util/Map.isAssignableFrom(class1))
                {
                    if (java/util/SortedMap.isAssignableFrom(class1))
                    {
                        obj = new r(this);
                    } else
                    if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom(com.google.a.c.a.a(((ParameterizedType)type).getActualTypeArguments()[0]).a))
                    {
                        obj = new h(this);
                    } else
                    {
                        obj = new i(this);
                    }
                } else
                {
                    obj = null;
                }
                if (obj == null)
                {
                    return new j(this, class1, type);
                }
            }
        }
        return ((ae) (obj));
    }

    public final String toString()
    {
        return a.toString();
    }
}
