// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.content.Context;
import com.a.a.a.a.a.b;
import com.a.a.a.b.c;
import com.a.a.b.a.k;
import com.a.a.b.b.d;
import com.a.a.b.d.e;
import com.a.a.b.e.a;
import java.io.File;
import java.util.concurrent.Executor;

// Referenced classes of package com.a.a.b:
//            h, d

public final class g
{

    final Context a;
    final int b;
    final int c;
    final int d;
    final int e;
    final android.graphics.Bitmap.CompressFormat f;
    final int g;
    final a h;
    final Executor i;
    final Executor j;
    final boolean k;
    final boolean l;
    final int m;
    final int n;
    final k o;
    final c p;
    final com.a.a.a.a.b q;
    final com.a.a.b.d.c r;
    final d s;
    final com.a.a.b.d t;
    final boolean u;
    final com.a.a.a.a.b v;
    final com.a.a.b.d.c w;
    final com.a.a.b.d.c x;

    private g(h h1)
    {
        a = com.a.a.b.h.a(h1);
        b = com.a.a.b.h.b(h1);
        c = com.a.a.b.h.c(h1);
        d = com.a.a.b.h.d(h1);
        e = com.a.a.b.h.e(h1);
        f = com.a.a.b.h.f(h1);
        g = com.a.a.b.h.g(h1);
        h = com.a.a.b.h.h(h1);
        i = com.a.a.b.h.i(h1);
        j = com.a.a.b.h.j(h1);
        m = com.a.a.b.h.k(h1);
        n = com.a.a.b.h.l(h1);
        o = com.a.a.b.h.m(h1);
        q = com.a.a.b.h.n(h1);
        p = com.a.a.b.h.o(h1);
        t = com.a.a.b.h.p(h1);
        u = com.a.a.b.h.q(h1);
        r = com.a.a.b.h.r(h1);
        s = com.a.a.b.h.s(h1);
        k = com.a.a.b.h.t(h1);
        l = com.a.a.b.h.u(h1);
        w = new e(r);
        x = new com.a.a.b.d.g(r);
        File file = a.getCacheDir();
        File file1 = new File(file, "uil-images");
        if (file1.exists() || file1.mkdir())
        {
            file = file1;
        }
        v = new b(file);
    }

    g(h h1, byte byte0)
    {
        this(h1);
    }
}
