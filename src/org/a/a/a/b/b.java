// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.b;


public abstract class b
{

    protected int a[];
    protected float b;
    protected boolean c;
    private int d;
    private int e;

    public b()
    {
        b();
    }

    public final float a()
    {
        if (e > 0 && d > 4) goto _L2; else goto _L1
_L1:
        float f = 0.01F;
_L4:
        return f;
_L2:
        if (e == d)
        {
            break; /* Loop/switch isn't completed */
        }
        f = (float)(d / (e - d)) * b;
        if (f < 0.99F) goto _L4; else goto _L3
_L3:
        return 0.99F;
    }

    protected abstract int a(byte abyte0[], int i);

    public final void a(byte abyte0[], int i, int j)
    {
        int k = -1;
        if (j == 2)
        {
            k = a(abyte0, i);
        }
        if (k >= 0)
        {
            e = 1 + e;
            if (k < a.length && 512 > a[k])
            {
                d = 1 + d;
            }
        }
    }

    public final void b()
    {
        c = false;
        e = 0;
        d = 0;
    }

    public final boolean c()
    {
        return e > 1024;
    }
}
