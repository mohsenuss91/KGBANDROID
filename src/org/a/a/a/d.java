// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import java.util.Arrays;
import org.a.a.a.a.a;
import org.a.a.a.d.b;
import org.a.a.a.d.c;
import org.a.a.a.d.m;

// Referenced classes of package org.a.a.a:
//            b, c

public final class d extends org.a.a.a.b
{

    private static final m f = new c();
    private b a;
    private org.a.a.a.c b;
    private a c;
    private org.a.a.a.b.c d;
    private byte e[];

    public d()
    {
        a = new b(f);
        c = new a();
        d = new org.a.a.a.b.c();
        e = new byte[2];
        d();
    }

    public final String a()
    {
        return org.a.a.b.i;
    }

    public final org.a.a.a.c a(byte abyte0[], int i)
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
        b = org.a.a.a.c.c;
_L2:
        e[0] = abyte0[j - 1];
        if (b == org.a.a.a.c.a && c.c() && b() > 0.95F)
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
                e[1] = abyte0[0];
                c.a(e, 0, i1);
                d.a(e, 0, i1);
            } else
            {
                c.a(abyte0, k - 1, i1);
                d.a(abyte0, k - 1, i1);
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

    public final org.a.a.a.c c()
    {
        return b;
    }

    public final void d()
    {
        a.b();
        b = org.a.a.a.c.a;
        c.b();
        d.b();
        Arrays.fill(e, (byte)0);
    }

}
