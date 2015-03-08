// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            f, d, g, c, 
//            e, i

public final class k
{

    Interpolator a;
    int b;
    int c[];
    float d;
    boolean e;
    boolean f;
    int g;
    private float h;

    public k(Context context)
    {
        Resources resources = context.getResources();
        a = new AccelerateInterpolator();
        b = resources.getInteger(f.spb_default_sections_count);
        int ai[] = new int[1];
        ai[0] = resources.getColor(d.spb_default_color);
        c = ai;
        d = Float.parseFloat(resources.getString(g.spb_default_speed));
        e = resources.getBoolean(c.spb_default_reversed);
        g = resources.getDimensionPixelSize(e.spb_default_stroke_separator_length);
        h = resources.getDimensionPixelOffset(e.spb_default_stroke_width);
    }

    public final i a()
    {
        return new i(a, b, g, c, h, d, e, f, (byte)0);
    }

    public final k a(float f1)
    {
        if (f1 < 0.0F)
        {
            throw new IllegalArgumentException("The width must be >= 0");
        } else
        {
            h = f1;
            return this;
        }
    }

    public final k a(int j)
    {
        c = (new int[] {
            j
        });
        return this;
    }
}
