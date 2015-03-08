// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.d;
import com.google.a.k;

// Referenced classes of package com.google.a.b:
//            s

final class t extends ak
{

    final boolean a;
    final boolean b;
    final k c;
    final com.google.a.c.a d;
    final s e;
    private ak f;

    t(s s, boolean flag, boolean flag1, k k1, com.google.a.c.a a1)
    {
        e = s;
        a = flag;
        b = flag1;
        c = k1;
        d = a1;
        super();
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

    public final Object a(a a1)
    {
        if (a)
        {
            a1.n();
            return null;
        } else
        {
            return a().a(a1);
        }
    }

    public final void a(d d1, Object obj)
    {
        if (b)
        {
            d1.f();
            return;
        } else
        {
            a().a(d1, obj);
            return;
        }
    }
}
