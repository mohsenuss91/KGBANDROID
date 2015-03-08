// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a;

import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

// Referenced classes of package com.google.a:
//            ak, k

final class p extends ak
{

    final k a;

    p(k k)
    {
        a = k;
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
            return Long.valueOf(a1.l());
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
            d1.b(number.toString());
            return;
        }
    }
}
