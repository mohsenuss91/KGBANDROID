// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

// Referenced classes of package net.simonvt.menudrawer:
//            MenuDrawer, c, b

class a extends FrameLayout
{

    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public a(Context context)
    {
        super(context);
        b = true;
        d = true;
        if (MenuDrawer.q)
        {
            setLayerType(2, null);
        }
    }

    static boolean a(a a1)
    {
        a1.a = true;
        return true;
    }

    static boolean b(a a1)
    {
        return a1.c;
    }

    static boolean c(a a1)
    {
        return a1.d;
    }

    static boolean d(a a1)
    {
        a1.d = false;
        return false;
    }

    final void a(boolean flag)
    {
        b = flag;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (a && MenuDrawer.q)
        {
            post(new c(this));
            a = false;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        c = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        c = false;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (MenuDrawer.q && b)
        {
            post(new b(this));
        }
    }
}
