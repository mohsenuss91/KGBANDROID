// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import org.a.a.a.c.l;

// Referenced classes of package org.a.a.a:
//            b, c

public final class n extends b
{

    private c a;
    private l b;
    private boolean c;
    private short d;
    private int e;
    private int f[];
    private int g;
    private int h;
    private b i;

    public n(l l1)
    {
        b = l1;
        c = false;
        i = null;
        f = new int[4];
        d();
    }

    public n(l l1, boolean flag, b b1)
    {
        b = l1;
        c = flag;
        i = b1;
        f = new int[4];
        d();
    }

    public final String a()
    {
        if (i == null)
        {
            return b.b();
        } else
        {
            return i.a();
        }
    }

    public final c a(byte abyte0[], int j)
    {
        int k = j + 0;
        int i1 = 0;
        while (i1 < k) 
        {
            short word0 = b.a(abyte0[i1]);
            if (word0 < 250)
            {
                g = 1 + g;
            }
            if (word0 < 64)
            {
                h = 1 + h;
                if (d < 64)
                {
                    e = 1 + e;
                    if (!c)
                    {
                        int ai1[] = f;
                        byte byte1 = b.a(word0 + 64 * d);
                        ai1[byte1] = 1 + ai1[byte1];
                    } else
                    {
                        int ai[] = f;
                        byte byte0 = b.a(word0 * 64 + d);
                        ai[byte0] = 1 + ai[byte0];
                    }
                }
            }
            d = word0;
            i1++;
        }
        if (a != c.a || e <= 1024) goto _L2; else goto _L1
_L1:
        float f1 = b();
        if (f1 <= 0.95F) goto _L4; else goto _L3
_L3:
        a = c.b;
_L2:
        return a;
_L4:
        if (f1 < 0.05F)
        {
            a = c.c;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final float b()
    {
        if (e > 0)
        {
            float f1 = (((1.0F * (float)f[3]) / (float)e / b.a()) * (float)h) / (float)g;
            if (f1 >= 1.0F)
            {
                f1 = 0.99F;
            }
            return f1;
        } else
        {
            return 0.01F;
        }
    }

    public final c c()
    {
        return a;
    }

    public final void d()
    {
        a = c.a;
        d = 255;
        for (int j = 0; j < 4; j++)
        {
            f[j] = 0;
        }

        e = 0;
        g = 0;
        h = 0;
    }
}
