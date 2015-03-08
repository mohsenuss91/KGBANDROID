// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.os.Handler;
import com.a.a.b.c.d;
import com.a.a.b.e.a;

// Referenced classes of package com.a.a.b:
//            d

public final class e
{

    int a;
    int b;
    int c;
    boolean d;
    boolean e;
    boolean f;
    com.a.a.b.a.e g;
    android.graphics.BitmapFactory.Options h;
    int i;
    Object j;
    a k;
    a l;
    com.a.a.b.c.a m;
    Handler n;

    public e()
    {
        a = 0;
        b = 0;
        c = 0;
        d = false;
        e = false;
        f = false;
        g = com.a.a.b.a.e.b;
        h = new android.graphics.BitmapFactory.Options();
        i = 0;
        j = null;
        k = null;
        l = null;
        m = new d();
        n = null;
        h.inPurgeable = true;
        h.inInputShareable = true;
    }

    public final e a()
    {
        a = 0x7f0200f4;
        return this;
    }

    public final e a(int i1)
    {
        b = i1;
        return this;
    }

    public final e a(android.graphics.Bitmap.Config config)
    {
        if (config == null)
        {
            throw new IllegalArgumentException("bitmapConfig can't be null");
        } else
        {
            h.inPreferredConfig = config;
            return this;
        }
    }

    public final e a(com.a.a.b.a.e e1)
    {
        g = e1;
        return this;
    }

    public final e a(com.a.a.b.c.a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("displayer can't be null");
        } else
        {
            m = a1;
            return this;
        }
    }

    public final e b()
    {
        d = true;
        return this;
    }

    public final e b(int i1)
    {
        c = i1;
        return this;
    }

    public final e c()
    {
        e = true;
        return this;
    }

    public final e d()
    {
        f = true;
        return this;
    }

    public final e e()
    {
        f = true;
        return this;
    }

    public final com.a.a.b.d f()
    {
        return new com.a.a.b.d(this, (byte)0);
    }
}
