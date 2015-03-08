// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import java.util.Arrays;
import org.a.a.a.a.d;
import org.a.a.a.b.h;
import org.a.a.a.d.b;
import org.a.a.a.d.l;

// Referenced classes of package org.a.a.a:
//            b, c

public final class m extends org.a.a.a.b
{

    private static final org.a.a.a.d.m f = new l();
    private b a;
    private c b;
    private d c;
    private h d;
    private byte e[];

    public m()
    {
        a = new b(f);
        c = new d();
        d = new h();
        e = new byte[2];
        d();
    }

    public final String a()
    {
        return org.a.a.b.l;
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
        int i1 = a.a(abyte0[k]);
        if (i1 != 1) goto _L4; else goto _L3
_L3:
        b = c.c;
_L2:
        e[0] = abyte0[j - 1];
        if (b == c.a && c.c() && b() > 0.95F)
        {
            b = org.a.a.a.c.b;
        }
        return b;
_L4:
        if (i1 != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        b = org.a.a.a.c.b;
        if (true) goto _L2; else goto _L5
_L5:
        if (i1 == 0)
        {
            int j1 = a.a();
            if (k == 0)
            {
                e[1] = abyte0[0];
                c.a(e, 2 - j1, j1);
                d.a(e, 0, j1);
            } else
            {
                c.a(abyte0, (k + 1) - j1, j1);
                d.a(abyte0, k - 1, j1);
            }
        }
        k++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final float b()
    {
        return Math.max(c.a(), d.a());
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
        d.b();
        Arrays.fill(e, (byte)0);
    }

}
