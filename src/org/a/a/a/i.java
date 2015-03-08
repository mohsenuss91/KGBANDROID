// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import org.a.a.b;

// Referenced classes of package org.a.a.a:
//            b, c

public final class i extends org.a.a.a.b
{

    org.a.a.a.b a;
    org.a.a.a.b b;
    private int c;
    private int d;
    private byte e;
    private byte f;

    public i()
    {
        a = null;
        b = null;
        d();
    }

    private static boolean c(byte byte0)
    {
        int j = byte0 & 0xff;
        return j == 234 || j == 237 || j == 239 || j == 243 || j == 245;
    }

    public final String a()
    {
        int j = c - d;
        if (j >= 5)
        {
            return b.t;
        }
        if (j <= -5)
        {
            return b.f;
        }
        float f1 = a.b() - b.b();
        if (f1 > 0.01F)
        {
            return b.t;
        }
        if (f1 < -0.01F)
        {
            return b.f;
        }
        if (j < 0)
        {
            return b.f;
        } else
        {
            return b.t;
        }
    }

    public final c a(byte abyte0[], int j)
    {
        if (c() == c.c)
        {
            return c.c;
        }
        int k = j + 0;
        int l = 0;
        while (l < k) 
        {
            byte byte0 = abyte0[l];
            if (byte0 == 32)
            {
                if (f != 32)
                {
                    if (c(e))
                    {
                        c = 1 + c;
                    } else
                    {
                        int i1 = 0xff & e;
                        boolean flag;
                        if (i1 == 235 || i1 == 238 || i1 == 240 || i1 == 244)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag)
                        {
                            d = 1 + d;
                        }
                    }
                }
            } else
            if (f == 32 && c(e) && byte0 != 32)
            {
                d = 1 + d;
            }
            f = e;
            e = byte0;
            l++;
        }
        return c.a;
    }

    public final float b()
    {
        return 0.0F;
    }

    public final c c()
    {
        if (a.c() == c.c && b.c() == c.c)
        {
            return c.c;
        } else
        {
            return c.a;
        }
    }

    public final void d()
    {
        c = 0;
        d = 0;
        e = 32;
        f = 32;
    }
}
