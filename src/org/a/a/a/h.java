// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import java.util.Arrays;
import org.a.a.a.d.b;
import org.a.a.a.d.f;
import org.a.a.a.d.m;

// Referenced classes of package org.a.a.a:
//            b, c

public final class h extends org.a.a.a.b
{

    private static final m e = new f();
    private b a;
    private c b;
    private org.a.a.a.b.f c;
    private byte d[];

    public h()
    {
        a = new b(e);
        c = new org.a.a.a.b.f();
        d = new byte[2];
        d();
    }

    public final String a()
    {
        return org.a.a.b.h;
    }

    public final c a(byte abyte0[], int i)
    {
        int j;
        int k;
        j = i + 0;
        k = 0;
_L7:
        if (k >= j) goto _L2; else goto _L1
_L1:
        int l = a.a(abyte0[k]);
        if (l != 1) goto _L4; else goto _L3
_L3:
        b = c.c;
_L2:
        d[0] = abyte0[j - 1];
        if (b == c.a && c.c() && c.a() > 0.95F)
        {
            b = org.a.a.a.c.b;
        }
        return b;
_L4:
        if (l != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        b = org.a.a.a.c.b;
        if (true) goto _L2; else goto _L5
_L5:
        if (l == 0)
        {
            int i1 = a.a();
            if (k == 0)
            {
                d[1] = abyte0[0];
                c.a(d, 0, i1);
            } else
            {
                c.a(abyte0, k - 1, i1);
            }
        }
        k++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final float b()
    {
        return c.a();
    }

    public final c c()
    {
        return b;
    }

    public final void d()
    {
        a.b();
        b = c.a;
        c.b();
        Arrays.fill(d, (byte)0);
    }

}
