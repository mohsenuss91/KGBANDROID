// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            b, h, d, f, 
//            e, g, c, k, 
//            i

public class SmoothProgressBar extends ProgressBar
{

    public SmoothProgressBar(Context context)
    {
        this(context, null);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, b.spbStyle);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeset, int j)
    {
        Resources resources;
        int l;
        int i1;
        int j1;
        float f1;
        float f2;
        int k1;
        boolean flag;
        boolean flag1;
        int l1;
        super(context, attributeset, j);
        resources = context.getResources();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, h.SmoothProgressBar, j, 0);
        l = typedarray.getColor(1, resources.getColor(d.spb_default_color));
        i1 = typedarray.getInteger(4, resources.getInteger(f.spb_default_sections_count));
        j1 = typedarray.getDimensionPixelSize(3, resources.getDimensionPixelSize(e.spb_default_stroke_separator_length));
        f1 = typedarray.getDimension(2, resources.getDimension(e.spb_default_stroke_width));
        f2 = typedarray.getFloat(5, Float.parseFloat(resources.getString(g.spb_default_speed)));
        k1 = typedarray.getInteger(6, resources.getInteger(f.spb_default_interpolator));
        flag = typedarray.getBoolean(7, resources.getBoolean(c.spb_default_reversed));
        flag1 = typedarray.getBoolean(8, resources.getBoolean(c.spb_default_mirror_mode));
        l1 = typedarray.getResourceId(9, 0);
        typedarray.recycle();
        k1;
        JVM INSTR tableswitch 1 3: default 204
    //                   1 281
    //                   2 257
    //                   3 269;
           goto _L1 _L2 _L3 _L4
_L1:
        Object obj = new AccelerateInterpolator();
_L6:
        int ai[];
        k k2;
        ai = null;
        if (l1 != 0)
        {
            ai = resources.getIntArray(l1);
        }
        k2 = new k(context);
        if (f2 < 0.0F)
        {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        break; /* Loop/switch isn't completed */
_L3:
        obj = new AccelerateDecelerateInterpolator();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new DecelerateInterpolator();
        continue; /* Loop/switch isn't completed */
_L2:
        obj = new LinearInterpolator();
        if (true) goto _L6; else goto _L5
_L5:
        k2.d = f2;
        k2.a = ((Interpolator) (obj));
        if (i1 <= 0)
        {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        k2.b = i1;
        if (j1 < 0)
        {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        k2.g = j1;
        k k3 = k2.a(f1);
        k3.e = flag;
        k3.f = flag1;
        if (ai != null && ai.length > 0)
        {
            if (ai == null || ai.length == 0)
            {
                throw new IllegalArgumentException("Your color array must not be empty");
            }
            k3.c = ai;
        } else
        {
            k3.a(l);
        }
        setIndeterminateDrawable(k3.a());
        return;
    }

    private i a()
    {
        android.graphics.drawable.Drawable drawable = getIndeterminateDrawable();
        if (drawable == null || !(drawable instanceof i))
        {
            throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
        } else
        {
            return (i)drawable;
        }
    }

    public void setInterpolator(Interpolator interpolator)
    {
        super.setInterpolator(interpolator);
        android.graphics.drawable.Drawable drawable = getIndeterminateDrawable();
        if (drawable != null && (drawable instanceof i))
        {
            ((i)drawable).a(interpolator);
        }
    }

    public void setSmoothProgressDrawableColor(int j)
    {
        a().a(j);
    }

    public void setSmoothProgressDrawableColors(int ai[])
    {
        a().a(ai);
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator)
    {
        a().a(interpolator);
    }

    public void setSmoothProgressDrawableMirrorMode(boolean flag)
    {
        a().b(flag);
    }

    public void setSmoothProgressDrawableReversed(boolean flag)
    {
        a().a(flag);
    }

    public void setSmoothProgressDrawableSectionsCount(int j)
    {
        a().b(j);
    }

    public void setSmoothProgressDrawableSeparatorLength(int j)
    {
        a().c(j);
    }

    public void setSmoothProgressDrawableSpeed(float f1)
    {
        a().a(f1);
    }

    public void setSmoothProgressDrawableStrokeWidth(float f1)
    {
        a().b(f1);
    }
}
