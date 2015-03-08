// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.a.a.b.a.g;
import com.a.a.b.a.l;
import com.a.a.b.c.c;
import com.a.a.c.a;
import com.a.a.c.d;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.a.a.b:
//            g, i, d, k, 
//            o, l, j

public class f
{

    public static final String a = com/a/a/b/f.getSimpleName();
    private static volatile f f;
    private com.a.a.b.g b;
    private i c;
    private final com.a.a.b.a.d d = new l();
    private final com.a.a.b.c.a e = new c();

    protected f()
    {
    }

    public static f a()
    {
        if (f != null) goto _L2; else goto _L1
_L1:
        com/a/a/b/f;
        JVM INSTR monitorenter ;
        if (f == null)
        {
            f = new f();
        }
        com/a/a/b/f;
        JVM INSTR monitorexit ;
_L2:
        return f;
        Exception exception;
        exception;
        throw exception;
    }

    private void e()
    {
        if (b == null)
        {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        } else
        {
            return;
        }
    }

    public final void a(com.a.a.b.g g1)
    {
        this;
        JVM INSTR monitorenter ;
        if (g1 != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (g1.u)
        {
            com.a.a.c.d.a("Initialize ImageLoader with configuration", new Object[0]);
        }
        c = new i(g1);
        b = g1;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        com.a.a.c.d.c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
          goto _L1
    }

    public final void a(String s, ImageView imageview, com.a.a.b.d d1)
    {
        a(s, imageview, d1, null);
    }

    public final void a(String s, ImageView imageview, com.a.a.b.d d1, com.a.a.b.a.d d2)
    {
        int i1 = 1;
        e();
        if (imageview == null)
        {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        com.a.a.b.a.d d3;
        com.a.a.b.d d4;
        int j1;
        int k1;
        DisplayMetrics displaymetrics;
        android.view.ViewGroup.LayoutParams layoutparams;
        int l1;
        int i2;
        int j2;
        com.a.a.b.a.f f1;
        String s1;
        Bitmap bitmap;
        int k2;
        k k3;
        com.a.a.b.l l2;
        i i3;
        if (d2 == null)
        {
            d3 = d;
        } else
        {
            d3 = d2;
        }
        if (d1 == null)
        {
            d4 = b.t;
        } else
        {
            d4 = d1;
        }
        if (TextUtils.isEmpty(s))
        {
            c.b(imageview);
            d3.a();
            if (d4.b == 0)
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                imageview.setImageResource(d4.b);
            } else
            {
                imageview.setImageDrawable(null);
            }
            d3.a(s, imageview, null);
            return;
        }
        j1 = b.b;
        k1 = b.c;
        displaymetrics = imageview.getContext().getResources().getDisplayMetrics();
        layoutparams = imageview.getLayoutParams();
        if (layoutparams != null && layoutparams.width == -2)
        {
            l1 = 0;
        } else
        {
            l1 = imageview.getWidth();
        }
        if (l1 <= 0 && layoutparams != null)
        {
            l1 = layoutparams.width;
        }
        if (l1 <= 0)
        {
            l1 = com.a.a.c.a.a(imageview, "mMaxWidth");
        }
        if (l1 > 0)
        {
            j1 = l1;
        }
        if (j1 <= 0)
        {
            i2 = displaymetrics.widthPixels;
        } else
        {
            i2 = j1;
        }
        if (layoutparams != null && layoutparams.height == -2)
        {
            j2 = 0;
        } else
        {
            j2 = imageview.getHeight();
        }
        if (j2 <= 0 && layoutparams != null)
        {
            j2 = layoutparams.height;
        }
        if (j2 <= 0)
        {
            j2 = com.a.a.c.a.a(imageview, "mMaxHeight");
        }
        if (j2 > 0)
        {
            k1 = j2;
        }
        if (k1 <= 0)
        {
            k1 = displaymetrics.heightPixels;
        }
        f1 = new com.a.a.b.a.f(i2, k1);
        s1 = (new StringBuilder(s)).append("_").append(f1.a).append("x").append(f1.b).toString();
        c.e.put(Integer.valueOf(imageview.hashCode()), s1);
        d3.a();
        bitmap = (Bitmap)b.p.a(s1);
        if (bitmap != null && !bitmap.isRecycled())
        {
            if (b.u)
            {
                Object aobj[] = new Object[i1];
                aobj[0] = s1;
                com.a.a.c.d.a("Load image from memory cache [%s]", aobj);
            }
            if (d4.a())
            {
                k k4 = new k(s, imageview, f1, s1, d4, d3, c.a(s));
                o o1 = new o(c, bitmap, k4, d4.b());
                i j3 = c;
                j3.a();
                j3.c.execute(o1);
                return;
            } else
            {
                com.a.a.b.c.a a1 = d4.m;
                g.c;
                a1.a(bitmap, imageview);
                d3.a(s, imageview, bitmap);
                return;
            }
        }
        if (d4.a != 0)
        {
            k2 = i1;
        } else
        {
            k2 = 0;
        }
        if (k2 == 0) goto _L2; else goto _L1
_L1:
        imageview.setImageResource(d4.a);
_L4:
        k3 = new k(s, imageview, f1, s1, d4, d3, c.a(s));
        l2 = new com.a.a.b.l(c, k3, d4.b());
        i3 = c;
        i3.d.execute(new j(i3, l2));
        return;
_L2:
        if (d4.d)
        {
            imageview.setImageDrawable(null);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void b()
    {
        e();
        b.p.b();
    }

    public final void c()
    {
        c.f.set(true);
    }

    public final void d()
    {
        i i1 = c;
        synchronized (i1.f)
        {
            i1.f.set(false);
            i1.f.notifyAll();
        }
    }

}
