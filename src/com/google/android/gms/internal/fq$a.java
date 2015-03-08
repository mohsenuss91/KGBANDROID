// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            fq, fn

public final class yh
{

    private final String mName;
    private String yf;
    private boolean yg;
    private int yh;
    private boolean yi;
    private String yj;
    private final List yk = new ArrayList();
    private BitSet yl;
    private String ym;

    public final yh I(int i)
    {
        if (yl == null)
        {
            yl = new BitSet();
        }
        yl.set(i);
        return this;
    }

    public final yl Z(String s)
    {
        yf = s;
        return this;
    }

    public final yf aa(String s)
    {
        ym = s;
        return this;
    }

    public final fq dL()
    {
        int i = 0;
        BitSet bitset = yl;
        int ai[] = null;
        if (bitset != null)
        {
            ai = new int[yl.cardinality()];
            for (int j = yl.nextSetBit(0); j >= 0;)
            {
                int k = i + 1;
                ai[i] = j;
                j = yl.nextSetBit(j + 1);
                i = k;
            }

        }
        return new fq(mName, yf, yg, yh, yi, yj, (fn[])yk.toArray(new fn[yk.size()]), ai, ym);
    }

    public final ym w(boolean flag)
    {
        yg = flag;
        return this;
    }

    public final yg x(boolean flag)
    {
        yi = flag;
        return this;
    }

    public (String s)
    {
        mName = s;
        yh = 1;
    }
}
