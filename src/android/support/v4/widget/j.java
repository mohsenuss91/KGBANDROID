// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            ab, DrawerLayout, z, h

final class j extends ab
{

    final DrawerLayout a;
    private final int b;
    private z c;
    private final Runnable d;

    public final void a()
    {
        a.removeCallbacks(d);
    }

    public final void a(int i)
    {
        DrawerLayout drawerlayout = a;
        int _tmp = b;
        drawerlayout.a(i, c.c());
    }

    public final void a(int i, int k)
    {
        View view;
        if ((i & 1) == 1)
        {
            view = a.a(3);
        } else
        {
            view = a.a(5);
        }
        if (view != null && a.a(view) == 0)
        {
            c.a(view, k);
        }
    }

    public final void a(View view, float f)
    {
        float f1;
        int i;
        a;
        f1 = DrawerLayout.b(view);
        i = view.getWidth();
        if (!a.a(view, 3)) goto _L2; else goto _L1
_L1:
        int k;
        if (f > 0.0F || f == 0.0F && f1 > 0.5F)
        {
            k = 0;
        } else
        {
            k = -i;
        }
_L4:
        c.a(k, view.getTop());
        a.invalidate();
        return;
_L2:
        k = a.getWidth();
        if (f < 0.0F || f == 0.0F && f1 > 0.5F)
        {
            k -= i;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(View view, int i)
    {
        int k = view.getWidth();
        float f;
        byte byte0;
        if (a.a(view, 3))
        {
            f = (float)(k + i) / (float)k;
        } else
        {
            f = (float)(a.getWidth() - i) / (float)k;
        }
        a.a(view, f);
        if (f == 0.0F)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        a.invalidate();
    }

    public final boolean a(View view)
    {
        DrawerLayout _tmp = a;
        return DrawerLayout.c(view) && a.a(view, b) && a.a(view) == 0;
    }

    public final int b(View view, int i)
    {
        if (a.a(view, 3))
        {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        } else
        {
            int k = a.getWidth();
            return Math.max(k - view.getWidth(), Math.min(i, k));
        }
    }

    public final void b()
    {
        a.postDelayed(d, 160L);
    }

    public final void b(View view)
    {
        ((h)view.getLayoutParams()).c = false;
        byte byte0;
        View view1;
        if (b == 3)
        {
            byte0 = 5;
        } else
        {
            byte0 = 3;
        }
        view1 = a.a(byte0);
        if (view1 != null)
        {
            a.d(view1);
        }
    }

    public final int c(View view)
    {
        return view.getWidth();
    }

    public final int d(View view)
    {
        return view.getTop();
    }
}
