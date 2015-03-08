// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ab;
import com.google.a.ak;
import com.google.a.b.ae;
import com.google.a.b.ag;
import com.google.a.b.u;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.k;
import com.google.a.w;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.b.a:
//            x, k

final class l extends ak
{

    final com.google.a.b.a.k a;
    private final ak b;
    private final ak c;
    private final ae d;

    public l(com.google.a.b.a.k k1, k k2, Type type, ak ak1, Type type1, ak ak2, ae ae1)
    {
        a = k1;
        super();
        b = new x(k2, ak1, type);
        c = new x(k2, ak2, type1);
        d = ae1;
    }

    public final Object a(a a1)
    {
        c c1 = a1.f();
        if (c1 == c.i)
        {
            a1.j();
            return null;
        }
        Map map = (Map)d.a();
        if (c1 == c.a)
        {
            a1.a();
            for (; a1.e(); a1.b())
            {
                a1.a();
                Object obj1 = b.a(a1);
                if (map.put(obj1, c.a(a1)) != null)
                {
                    throw new com.google.a.ae((new StringBuilder("duplicate key: ")).append(obj1).toString());
                }
            }

            a1.b();
            return map;
        }
        a1.c();
        while (a1.e()) 
        {
            u.a.a(a1);
            Object obj = b.a(a1);
            if (map.put(obj, c.a(a1)) != null)
            {
                throw new com.google.a.ae((new StringBuilder("duplicate key: ")).append(obj).toString());
            }
        }
        a1.d();
        return map;
    }

    public final void a(d d1, Object obj)
    {
        int i = 0;
        Map map = (Map)obj;
        if (map == null)
        {
            d1.f();
            return;
        }
        if (!a.a)
        {
            d1.d();
            java.util.Map.Entry entry1;
            for (Iterator iterator1 = map.entrySet().iterator(); iterator1.hasNext(); c.a(d1, entry1.getValue()))
            {
                entry1 = (java.util.Map.Entry)iterator1.next();
                d1.a(String.valueOf(entry1.getKey()));
            }

            d1.e();
            return;
        }
        ArrayList arraylist = new ArrayList(map.size());
        ArrayList arraylist1 = new ArrayList(map.size());
        Iterator iterator = map.entrySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            w w2 = b.a(entry.getKey());
            arraylist.add(w2);
            arraylist1.add(entry.getValue());
            boolean flag1;
            if (w2.g() || w2.h())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = flag1 | flag;
        }
        if (flag)
        {
            d1.b();
            for (; i < arraylist.size(); i++)
            {
                d1.b();
                ag.a((w)arraylist.get(i), d1);
                c.a(d1, arraylist1.get(i));
                d1.c();
            }

            d1.c();
            return;
        }
        d1.d();
        while (i < arraylist.size()) 
        {
            w w1 = (w)arraylist.get(i);
            String s;
            if (w1.i())
            {
                ab ab1 = w1.m();
                if (ab1.o())
                {
                    s = String.valueOf(ab1.a());
                } else
                if (ab1.n())
                {
                    s = Boolean.toString(ab1.f());
                } else
                if (ab1.p())
                {
                    s = ab1.b();
                } else
                {
                    throw new AssertionError();
                }
            } else
            if (w1.j())
            {
                s = "null";
            } else
            {
                throw new AssertionError();
            }
            d1.a(s);
            c.a(d1, arraylist1.get(i));
            i++;
        }
        d1.e();
    }
}
