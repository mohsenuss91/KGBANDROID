// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

final class ad
{

    private static final float t = (float)(Math.log(0.75D) / Math.log(0.90000000000000002D));
    private static final float u[];
    private static float x = 8F;
    private static float y = 1.0F;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private int m;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private Interpolator r;
    private boolean s;
    private float v;
    private final float w;

    public ad(Context context, Interpolator interpolator)
    {
        boolean flag;
        if (context.getApplicationInfo().targetSdkVersion >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this(context, interpolator, flag);
    }

    private ad(Context context, Interpolator interpolator, boolean flag)
    {
        q = true;
        r = interpolator;
        w = 160F * context.getResources().getDisplayMetrics().density;
        v = ViewConfiguration.getScrollFriction() * (386.0878F * w);
        s = flag;
    }

    private static float a(float f1)
    {
        float f2 = f1 * x;
        float f3;
        if (f2 < 1.0F)
        {
            f3 = f2 - (1.0F - (float)Math.exp(-f2));
        } else
        {
            f3 = 0.3678795F + 0.6321205F * (1.0F - (float)Math.exp(1.0F - f2));
        }
        return f3 * y;
    }

    public final void a(int i1, int j1, int k1)
    {
        a = 0;
        q = false;
        m = k1;
        l = AnimationUtils.currentAnimationTimeMillis();
        b = i1;
        c = 0;
        d = i1 + j1;
        e = 0;
        o = j1;
        p = 0.0F;
        n = 1.0F / (float)m;
    }

    public final boolean a()
    {
        return q;
    }

    public final int b()
    {
        return j;
    }

    public final int c()
    {
        return d;
    }

    public final boolean d()
    {
        int i1;
        if (q)
        {
            return false;
        }
        i1 = (int)(AnimationUtils.currentAnimationTimeMillis() - l);
        if (i1 >= m) goto _L2; else goto _L1
_L1:
        a;
        JVM INSTR tableswitch 0 1: default 52
    //                   0 54
    //                   1 134;
           goto _L3 _L4 _L5
_L3:
        return true;
_L4:
        float f7 = (float)i1 * n;
        float f8;
        if (r == null)
        {
            f8 = a(f7);
        } else
        {
            f8 = r.getInterpolation(f7);
        }
        j = b + Math.round(f8 * o);
        k = c + Math.round(f8 * p);
        continue; /* Loop/switch isn't completed */
_L5:
        float f1 = (float)i1 / (float)m;
        int j1 = (int)(100F * f1);
        float f2 = (float)j1 / 100F;
        float f3 = (float)(j1 + 1) / 100F;
        float f4 = u[j1];
        float f5 = u[j1 + 1];
        float f6 = f4 + ((f1 - f2) / (f3 - f2)) * (f5 - f4);
        j = b + Math.round(f6 * (float)(d - b));
        j = Math.min(j, g);
        j = Math.max(j, f);
        k = c + Math.round(f6 * (float)(e - c));
        k = Math.min(k, i);
        k = Math.max(k, h);
        if (j == d && k == e)
        {
            q = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        j = d;
        k = e;
        q = true;
        if (true) goto _L3; else goto _L6
_L6:
    }

    public final void e()
    {
        j = d;
        k = e;
        q = true;
    }

    static 
    {
        u = new float[101];
        float f1 = 0.0F;
        for (int i1 = 0; i1 <= 100;)
        {
            float f2 = (float)i1 / 100F;
            float f3 = 1.0F;
            float f4 = f1;
            float f5;
            float f6;
            do
            {
                f5 = f4 + (f3 - f4) / 2.0F;
                f6 = 3F * f5 * (1.0F - f5);
                float f7 = f6 * (0.4F * (1.0F - f5) + 0.6F * f5) + f5 * (f5 * f5);
                if ((double)Math.abs(f7 - f2) < 1.0000000000000001E-05D)
                {
                    break;
                }
                if (f7 > f2)
                {
                    f3 = f5;
                } else
                {
                    f4 = f5;
                }
            } while (true);
            float f8 = f6 + f5 * (f5 * f5);
            u[i1] = f8;
            i1++;
            f1 = f4;
        }

        u[100] = 1.0F;
        y = 1.0F / a(1.0F);
    }
}
