// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.os.Handler;
import com.a.a.b.a.e;
import com.a.a.b.e.a;

// Referenced classes of package com.a.a.b:
//            e

public final class d
{

    final int a;
    final int b;
    final int c;
    final boolean d;
    final boolean e;
    final boolean f;
    public final e g;
    public final android.graphics.BitmapFactory.Options h;
    final int i;
    public final Object j;
    final a k;
    final a l;
    final com.a.a.b.c.a m;
    final Handler n;

    private d(com.a.a.b.e e1)
    {
        a = e1.;
        b = e1.b;
        c = e1.c;
        d = e1.d;
        e = e1.e;
        f = e1.f;
        g = e1.g;
        h = e1.h;
        i = e1.i;
        j = e1.j;
        k = e1.k;
        l = e1.l;
        m = e1.m;
        n = e1.n;
    }

    d(com.a.a.b.e e1, byte byte0)
    {
        this(e1);
    }

    public final boolean a()
    {
        return l != null;
    }

    public final Handler b()
    {
        if (n == null)
        {
            return new Handler();
        } else
        {
            return n;
        }
    }
}
