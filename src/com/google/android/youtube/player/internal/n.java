// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package com.google.android.youtube.player.internal:
//            z, m

public final class n extends FrameLayout
{

    private final ProgressBar a;
    private final TextView b;

    public n(Context context)
    {
        super(context, null, z.c(context));
        m m1 = new m(context);
        setBackgroundColor(0xff000000);
        a = new ProgressBar(context);
        a.setVisibility(8);
        addView(a, new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
        int i = (int)(0.5F + 10F * context.getResources().getDisplayMetrics().density);
        b = new TextView(context);
        b.setTextAppearance(context, 0x1030046);
        b.setTextColor(-1);
        b.setVisibility(8);
        b.setPadding(i, i, i, i);
        b.setGravity(17);
        b.setText(m1.a);
        addView(b, new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
    }

    public final void a()
    {
        a.setVisibility(8);
        b.setVisibility(8);
    }

    public final void b()
    {
        a.setVisibility(0);
        b.setVisibility(8);
    }

    public final void c()
    {
        a.setVisibility(8);
        b.setVisibility(0);
    }

    protected final void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getSize(i);
        int j1 = android.view.View.MeasureSpec.getSize(j);
        int k1;
        int l1;
        int i2;
        if (k == 0x40000000 && l == 0x40000000)
        {
            k1 = i1;
        } else
        if (k == 0x40000000 || k == 0x80000000 && l == 0)
        {
            j1 = (int)((float)i1 / 1.777F);
            k1 = i1;
        } else
        if (l == 0x40000000 || l == 0x80000000 && k == 0)
        {
            k1 = (int)(1.777F * (float)j1);
        } else
        if (k == 0x80000000 && l == 0x80000000)
        {
            if ((float)j1 < (float)i1 / 1.777F)
            {
                k1 = (int)(1.777F * (float)j1);
            } else
            {
                j1 = (int)((float)i1 / 1.777F);
                k1 = i1;
            }
        } else
        {
            j1 = 0;
            k1 = 0;
        }
        l1 = resolveSize(k1, i);
        i2 = resolveSize(j1, j);
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(i2, 0x40000000));
    }
}
