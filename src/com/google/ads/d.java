// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;

public final class d
{

    public static final d a = new d(-1, -2, (byte)0);
    public static final d b = new d(320, 50, (byte)0);
    public static final d c = new d(300, 250, (byte)0);
    public static final d d = new d(468, 60, (byte)0);
    public static final d e = new d(728, 90, (byte)0);
    public static final d f = new d(160, 600, (byte)0);
    private final AdSize g;

    public d(int i, int j)
    {
        this(new AdSize(i, j));
    }

    private d(int i, int j, byte byte0)
    {
        this(new AdSize(i, j));
    }

    public d(AdSize adsize)
    {
        g = adsize;
    }

    public final int a()
    {
        return g.getWidth();
    }

    public final int a(Context context)
    {
        return g.getWidthInPixels(context);
    }

    public final transient d a(d ad[])
    {
        if (ad != null) goto _L2; else goto _L1
_L1:
        d d1 = null;
_L4:
        return d1;
_L2:
        float f1;
        int i;
        int j;
        int k;
        int l;
        d1 = null;
        f1 = 0.0F;
        i = g.getWidth();
        j = g.getHeight();
        k = ad.length;
        l = 0;
_L5:
        if (l >= k) goto _L4; else goto _L3
_L3:
        float f2;
        d d3;
        d d2 = ad[l];
        int i1 = d2.g.getWidth();
        int j1 = d2.g.getHeight();
        int k1 = g.getWidth();
        int l1 = g.getHeight();
        boolean flag;
        if ((float)i1 <= 1.25F * (float)k1 && (float)i1 >= 0.8F * (float)k1 && (float)j1 <= 1.25F * (float)l1 && (float)j1 >= 0.8F * (float)l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        f2 = (float)(i1 * j1) / (float)(i * j);
        if (f2 > 1.0F)
        {
            f2 = 1.0F / f2;
        }
        if (f2 <= f1)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        d3 = d2;
_L6:
        l++;
        d1 = d3;
        f1 = f2;
          goto _L5
          goto _L4
        f2 = f1;
        d3 = d1;
          goto _L6
    }

    public final int b()
    {
        return g.getHeight();
    }

    public final int b(Context context)
    {
        return g.getHeightInPixels(context);
    }

    public final boolean equals(Object obj)
    {
        if (!(obj instanceof d))
        {
            return false;
        } else
        {
            d d1 = (d)obj;
            return g.equals(d1.g);
        }
    }

    public final int hashCode()
    {
        return g.hashCode();
    }

    public final String toString()
    {
        return g.toString();
    }

}
