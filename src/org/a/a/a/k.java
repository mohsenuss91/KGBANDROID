// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;


// Referenced classes of package org.a.a.a:
//            b, o, m, d, 
//            h, e, a, f, 
//            c

public final class k extends b
{

    private c a;
    private b b[];
    private boolean c[];
    private int d;
    private int e;

    public k()
    {
        b = new b[7];
        c = new boolean[7];
        b[0] = new o();
        b[1] = new m();
        b[2] = new d();
        b[3] = new h();
        b[4] = new e();
        b[5] = new a();
        b[6] = new f();
        d();
    }

    public final String a()
    {
        if (d == -1)
        {
            b();
            if (d == -1)
            {
                d = 0;
            }
        }
        return b[d].a();
    }

    public final c a(byte abyte0[], int i)
    {
        byte abyte1[] = new byte[i];
        int j = i + 0;
        int l = 0;
        boolean flag = true;
        int i1 = 0;
        while (i1 < j) 
        {
            int j1;
            c c1;
            boolean flag1;
            int l1;
            int i2;
            if ((0x80 & abyte0[i1]) != 0)
            {
                l1 = l + 1;
                abyte1[l] = abyte0[i1];
                flag1 = true;
            } else
            if (flag)
            {
                l1 = l + 1;
                abyte1[l] = abyte0[i1];
                flag1 = false;
            } else
            {
                int k1 = l;
                flag1 = flag;
                l1 = k1;
            }
            i1++;
            i2 = l1;
            flag = flag1;
            l = i2;
        }
        j1 = 0;
        if (j1 >= b.length) goto _L2; else goto _L1
_L1:
        if (!c[j1]) goto _L4; else goto _L3
_L3:
        c1 = b[j1].a(abyte1, l);
        if (c1 != c.b) goto _L6; else goto _L5
_L5:
        d = j1;
        a = c.b;
_L2:
        return a;
_L6:
        if (c1 != c.c)
        {
            break; /* Loop/switch isn't completed */
        }
        c[j1] = false;
        e = -1 + e;
        if (e > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        a = c.c;
        if (true) goto _L2; else goto _L4
_L4:
        j1++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_99;
        }
    }

    public final float b()
    {
        float f1 = 0.0F;
        if (a == c.b)
        {
            f1 = 0.99F;
        } else
        {
            if (a == c.c)
            {
                return 0.01F;
            }
            int i = 0;
            while (i < b.length) 
            {
                if (c[i])
                {
                    float f2 = b[i].b();
                    if (f1 < f2)
                    {
                        d = i;
                        f1 = f2;
                    }
                }
                i++;
            }
        }
        return f1;
    }

    public final c c()
    {
        return a;
    }

    public final void d()
    {
        int i = 0;
        e = 0;
        for (; i < b.length; i++)
        {
            b[i].d();
            c[i] = true;
            e = 1 + e;
        }

        d = -1;
        a = c.a;
    }
}
