// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

// Referenced classes of package net.simonvt.menudrawer:
//            MenuDrawer, ak, x, a

public final class aj extends MenuDrawer
{

    public aj(Context context)
    {
        super(context);
    }

    public final void a()
    {
    }

    protected final void a(Context context, AttributeSet attributeset, int i)
    {
        super.a(context, attributeset, i);
        super.addView(C, -1, new android.view.ViewGroup.LayoutParams(-1, -1));
        super.addView(D, -1, new android.view.ViewGroup.LayoutParams(-1, -1));
        U = true;
    }

    protected final void a(Canvas canvas)
    {
    }

    public final void a(boolean flag)
    {
    }

    protected final void b(int i)
    {
    }

    public final boolean b()
    {
        return true;
    }

    public final boolean getOffsetMenuEnabled()
    {
        return false;
    }

    public final int getTouchBezelSize()
    {
        return 0;
    }

    public final int getTouchMode()
    {
        return 0;
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1 = k - i;
        int j1 = l - j;
        switch (ak.a[getPosition().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            C.layout(0, 0, E, j1);
            D.layout(E, 0, i1, j1);
            return;

        case 2: // '\002'
            C.layout(i1 - E, 0, i1, j1);
            D.layout(0, 0, i1 - E, j1);
            return;

        case 3: // '\003'
            C.layout(0, 0, i1, E);
            D.layout(0, E, i1, j1);
            return;

        case 4: // '\004'
            C.layout(0, j1 - E, i1, j1);
            break;
        }
        D.layout(0, 0, i1, j1 - E);
    }

    protected final void onMeasure(int i, int j)
    {
        int i1;
        int j1;
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getMode(j);
        if (k == 0 || l == 0)
        {
            throw new IllegalStateException("Must measure with an exact size");
        }
        i1 = android.view.View.MeasureSpec.getSize(i);
        j1 = android.view.View.MeasureSpec.getSize(j);
        ak.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 84
    //                   1 93
    //                   2 93
    //                   3 154
    //                   4 154;
           goto _L1 _L2 _L2 _L3 _L3
_L1:
        setMeasuredDimension(i1, j1);
        return;
_L2:
        int k2 = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
        int l2 = E;
        int i3 = android.view.View.MeasureSpec.makeMeasureSpec(l2, 0x40000000);
        int j3 = android.view.View.MeasureSpec.makeMeasureSpec(i1 - l2, 0x40000000);
        D.measure(j3, k2);
        C.measure(i3, k2);
        continue; /* Loop/switch isn't completed */
_L3:
        int k1 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
        int l1 = E;
        int i2 = android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000);
        int j2 = android.view.View.MeasureSpec.makeMeasureSpec(j1 - l1, 0x40000000);
        D.measure(k1, j2);
        C.measure(k1, i2);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void p()
    {
    }

    public final void setDrawerIndicatorEnabled(boolean flag)
    {
    }

    public final void setHardwareLayerEnabled(boolean flag)
    {
    }

    public final void setMenuSize(int i)
    {
        E = i;
        requestLayout();
        invalidate();
    }

    public final void setOffsetMenuEnabled(boolean flag)
    {
    }

    public final void setSlideDrawable(int i)
    {
    }

    public final void setSlideDrawable(Drawable drawable)
    {
    }

    public final void setTouchBezelSize(int i)
    {
    }

    public final void setTouchMode(int i)
    {
    }

    public final void setupUpIndicator(Activity activity)
    {
    }
}
