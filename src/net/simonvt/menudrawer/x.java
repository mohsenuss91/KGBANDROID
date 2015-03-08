// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.util.SparseArray;

public final class x extends Enum
{

    public static final x a;
    public static final x b;
    public static final x c;
    public static final x d;
    public static final x e;
    public static final x f;
    private static final SparseArray h;
    private static final x i[];
    final int g;

    private x(String s, int j, int k)
    {
        super(s, j);
        g = k;
    }

    public static x a(int j)
    {
        return (x)h.get(j);
    }

    public static x valueOf(String s)
    {
        return (x)Enum.valueOf(net/simonvt/menudrawer/x, s);
    }

    public static x[] values()
    {
        return (x[])i.clone();
    }

    static 
    {
        int j = 0;
        a = new x("LEFT", 0, 0);
        b = new x("TOP", 1, 1);
        c = new x("RIGHT", 2, 2);
        d = new x("BOTTOM", 3, 3);
        e = new x("START", 4, 4);
        f = new x("END", 5, 5);
        x ax[] = new x[6];
        ax[0] = a;
        ax[1] = b;
        ax[2] = c;
        ax[3] = d;
        ax[4] = e;
        ax[5] = f;
        i = ax;
        h = new SparseArray();
        x ax1[] = values();
        for (int k = ax1.length; j < k; j++)
        {
            x x1 = ax1[j];
            h.put(x1.g, x1);
        }

    }
}
