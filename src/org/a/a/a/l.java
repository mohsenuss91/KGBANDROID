// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import java.nio.ByteBuffer;
import org.a.a.a.c.d;
import org.a.a.a.c.e;
import org.a.a.a.c.f;
import org.a.a.a.c.g;
import org.a.a.a.c.h;
import org.a.a.a.c.i;
import org.a.a.a.c.j;
import org.a.a.a.c.k;
import org.a.a.a.c.m;
import org.a.a.a.c.n;
import org.a.a.a.c.o;

// Referenced classes of package org.a.a.a:
//            b, n, i, c

public final class l extends b
{

    private static final org.a.a.a.c.l f = new n();
    private static final org.a.a.a.c.l g = new g();
    private static final org.a.a.a.c.l h = new i();
    private static final org.a.a.a.c.l i = new k();
    private static final org.a.a.a.c.l j = new f();
    private static final org.a.a.a.c.l k = new e();
    private static final org.a.a.a.c.l l = new j();
    private static final org.a.a.a.c.l m = new o();
    private static final org.a.a.a.c.l n = new h();
    private static final org.a.a.a.c.l o = new m();
    private static final org.a.a.a.c.l p = new d();
    private c a;
    private b b[];
    private boolean c[];
    private int d;
    private int e;

    public l()
    {
        b = new b[13];
        c = new boolean[13];
        b[0] = new org.a.a.a.n(f);
        b[1] = new org.a.a.a.n(g);
        b[2] = new org.a.a.a.n(h);
        b[3] = new org.a.a.a.n(i);
        b[4] = new org.a.a.a.n(j);
        b[5] = new org.a.a.a.n(k);
        b[6] = new org.a.a.a.n(l);
        b[7] = new org.a.a.a.n(m);
        b[8] = new org.a.a.a.n(n);
        b[9] = new org.a.a.a.n(o);
        org.a.a.a.i i1 = new org.a.a.a.i();
        b[10] = i1;
        b[11] = new org.a.a.a.n(p, false, i1);
        b[12] = new org.a.a.a.n(p, true, i1);
        b b1 = b[11];
        b b2 = b[12];
        i1.a = b1;
        i1.b = b2;
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

    public final c a(byte abyte0[], int i1)
    {
        ByteBuffer bytebuffer;
        bytebuffer = ByteBuffer.allocate(i1);
        int j1 = i1 + 0;
        int k1 = 0;
        int l1 = 0;
        boolean flag = false;
        while (k1 < j1) 
        {
            byte byte0 = abyte0[k1];
            if (!org.a.a.a.b.a(byte0))
            {
                flag = true;
            } else
            if (org.a.a.a.b.b(byte0))
            {
                if (flag && k1 > l1)
                {
                    bytebuffer.put(abyte0, l1, k1 - l1);
                    bytebuffer.put((byte)32);
                    l1 = k1 + 1;
                    flag = false;
                } else
                {
                    l1 = k1 + 1;
                }
            }
            k1++;
        }
        if (flag && k1 > l1)
        {
            bytebuffer.put(abyte0, l1, k1 - l1);
        }
        if (bytebuffer.position() == 0) goto _L2; else goto _L1
_L1:
        int i2 = 0;
_L9:
        if (i2 >= b.length) goto _L2; else goto _L3
_L3:
        if (!c[i2]) goto _L5; else goto _L4
_L4:
        c c1 = b[i2].a(bytebuffer.array(), bytebuffer.position());
        if (c1 != c.b) goto _L7; else goto _L6
_L6:
        d = i2;
        a = c.b;
_L2:
        return a;
_L7:
        if (c1 != c.c)
        {
            break; /* Loop/switch isn't completed */
        }
        c[i2] = false;
        e = -1 + e;
        if (e > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        a = c.c;
        if (true) goto _L2; else goto _L5
_L5:
        i2++;
        if (true) goto _L9; else goto _L8
_L8:
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
            int i1 = 0;
            while (i1 < b.length) 
            {
                if (c[i1])
                {
                    float f2 = b[i1].b();
                    if (f1 < f2)
                    {
                        d = i1;
                        f1 = f2;
                    }
                }
                i1++;
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
        int i1 = 0;
        e = 0;
        for (; i1 < b.length; i1++)
        {
            b[i1].d();
            c[i1] = true;
            e = 1 + e;
        }

        d = -1;
        a = c.a;
    }

}
