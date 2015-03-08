// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.b.ag;
import com.google.a.c.a;
import com.google.a.d.d;

// Referenced classes of package com.google.a:
//            ak, k, aj, w, 
//            v, ad, al

final class ai extends ak
{

    private final ad a;
    private final v b;
    private final k c;
    private final a d;
    private final al e;
    private ak f;

    private ai(ad ad1, v v1, k k1, a a1, al al)
    {
        a = ad1;
        b = v1;
        c = k1;
        d = a1;
        e = al;
    }

    ai(ad ad1, v v1, k k1, a a1, al al, byte byte0)
    {
        this(ad1, v1, k1, a1, al);
    }

    private ak a()
    {
        ak ak1 = f;
        if (ak1 != null)
        {
            return ak1;
        } else
        {
            ak ak2 = c.a(e, d);
            f = ak2;
            return ak2;
        }
    }

    public static al a(a a1, Object obj)
    {
        return new aj(obj, a1, (byte)0);
    }

    public final Object a(com.google.a.d.a a1)
    {
        if (b == null)
        {
            return a().a(a1);
        }
        w w1 = ag.a(a1);
        if (w1.j())
        {
            return null;
        } else
        {
            v v1 = b;
            java.lang.reflect.Type type = d.b;
            u _tmp = c.a;
            return v1.a(w1, type);
        }
    }

    public final void a(d d1, Object obj)
    {
        if (a == null)
        {
            a().a(d1, obj);
            return;
        }
        if (obj == null)
        {
            d1.f();
            return;
        } else
        {
            ad ad1 = a;
            java.lang.reflect.Type _tmp = d.b;
            ac _tmp1 = c.b;
            ag.a(ad1.a(obj), d1);
            return;
        }
    }
}
