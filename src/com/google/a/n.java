// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

// Referenced classes of package com.google.a:
//            ak, k

final class n extends ak
{

    final k a;

    n(k k1)
    {
        a = k1;
        super();
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        } else
        {
            return Double.valueOf(a1.k());
        }
    }

    public final void a(d d1, Object obj)
    {
        Number number = (Number)obj;
        if (number == null)
        {
            d1.f();
            return;
        } else
        {
            double d2 = number.doubleValue();
            k _tmp = a;
            com.google.a.k.a(d2);
            d1.a(number);
            return;
        }
    }
}
