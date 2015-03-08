// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.content.Context;
import com.a.a.a.a.b.b;
import com.a.a.a.b.a.a;
import com.a.a.a.b.a.c;
import com.a.a.b.a.i;
import com.a.a.b.a.k;
import com.a.a.c.d;
import com.a.a.c.e;
import java.util.concurrent.Executor;

// Referenced classes of package com.a.a.b:
//            a, e, g, d

public final class h
{

    public static final k a;
    private boolean A;
    private Context b;
    private int c;
    private int d;
    private int e;
    private int f;
    private android.graphics.Bitmap.CompressFormat g;
    private int h;
    private com.a.a.b.e.a i;
    private Executor j;
    private Executor k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private boolean p;
    private k q;
    private int r;
    private int s;
    private int t;
    private com.a.a.a.b.c u;
    private com.a.a.a.a.b v;
    private com.a.a.a.a.b.a w;
    private com.a.a.b.d.c x;
    private com.a.a.b.b.d y;
    private com.a.a.b.d z;

    public h(Context context)
    {
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = null;
        h = 0;
        i = null;
        j = null;
        k = null;
        l = false;
        m = false;
        n = 3;
        o = 4;
        p = false;
        q = a;
        r = 0;
        s = 0;
        t = 0;
        u = null;
        v = null;
        w = null;
        x = null;
        z = null;
        A = false;
        b = context.getApplicationContext();
    }

    static Context a(h h1)
    {
        return h1.b;
    }

    static int b(h h1)
    {
        return h1.c;
    }

    static int c(h h1)
    {
        return h1.d;
    }

    static int d(h h1)
    {
        return h1.e;
    }

    static int e(h h1)
    {
        return h1.f;
    }

    static android.graphics.Bitmap.CompressFormat f(h h1)
    {
        return h1.g;
    }

    static int g(h h1)
    {
        return h1.h;
    }

    static com.a.a.b.e.a h(h h1)
    {
        return h1.i;
    }

    static Executor i(h h1)
    {
        return h1.j;
    }

    static Executor j(h h1)
    {
        return h1.k;
    }

    static int k(h h1)
    {
        return h1.n;
    }

    static int l(h h1)
    {
        return h1.o;
    }

    static k m(h h1)
    {
        return h1.q;
    }

    static com.a.a.a.a.b n(h h1)
    {
        return h1.v;
    }

    static com.a.a.a.b.c o(h h1)
    {
        return h1.u;
    }

    static com.a.a.b.d p(h h1)
    {
        return h1.z;
    }

    static boolean q(h h1)
    {
        return h1.A;
    }

    static com.a.a.b.d.c r(h h1)
    {
        return h1.x;
    }

    static com.a.a.b.b.d s(h h1)
    {
        return h1.y;
    }

    static boolean t(h h1)
    {
        return h1.l;
    }

    static boolean u(h h1)
    {
        return h1.m;
    }

    public final h a()
    {
        if (j != null || k != null)
        {
            com.a.a.c.d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        o = 3;
        return this;
    }

    public final h a(com.a.a.a.a.b b1)
    {
        if (s > 0 || t > 0)
        {
            com.a.a.c.d.c("discCache(), discCacheSize() and discCacheFileCount calls overlap each other", new Object[0]);
        }
        if (w != null)
        {
            com.a.a.c.d.c("discCache() and discCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        v = b1;
        return this;
    }

    public final h a(com.a.a.a.b.c c1)
    {
        if (r != 0)
        {
            com.a.a.c.d.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        u = c1;
        return this;
    }

    public final h a(k k1)
    {
        if (j != null || k != null)
        {
            com.a.a.c.d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        q = k1;
        return this;
    }

    public final h b()
    {
        p = true;
        return this;
    }

    public final g c()
    {
        if (j == null)
        {
            j = com.a.a.b.a.a(n, o, q);
        } else
        {
            l = true;
        }
        if (k == null)
        {
            k = com.a.a.b.a.a(n, o, q);
        } else
        {
            m = true;
        }
        if (v == null)
        {
            if (w == null)
            {
                w = new b();
            }
            Context context = b;
            com.a.a.a.a.b.a a1 = w;
            int j1 = s;
            int k1 = t;
            Object obj1;
            if (j1 > 0)
            {
                obj1 = new com.a.a.a.a.a.b(com.a.a.c.e.b(context), a1, j1);
            } else
            if (k1 > 0)
            {
                obj1 = new com.a.a.a.a.a.a(com.a.a.c.e.b(context), a1, k1);
            } else
            {
                obj1 = new com.a.a.a.a.a.c(com.a.a.c.e.a(context), a1);
            }
            v = ((com.a.a.a.a.b) (obj1));
        }
        if (u == null)
        {
            int i1 = r;
            if (i1 == 0)
            {
                i1 = (int)(Runtime.getRuntime().maxMemory() / 8L);
            }
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                obj = new c(i1);
            } else
            {
                obj = new com.a.a.a.b.a.b(i1);
            }
            u = ((com.a.a.a.b.c) (obj));
        }
        if (p)
        {
            u = new a(u, new i());
        }
        if (x == null)
        {
            x = new com.a.a.b.d.a(b);
        }
        if (y == null)
        {
            y = new com.a.a.b.b.a(A);
        }
        if (z == null)
        {
            z = (new com.a.a.b.e()).f();
        }
        return new g(this, (byte)0);
    }

    static 
    {
        a = k.a;
    }
}
