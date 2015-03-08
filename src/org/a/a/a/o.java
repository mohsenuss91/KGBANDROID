// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import org.a.a.a.d.b;
import org.a.a.a.d.m;
import org.a.a.a.d.n;

// Referenced classes of package org.a.a.a:
//            b, c

public final class o extends org.a.a.a.b
{

    private static final m d = new n();
    private b a;
    private c b;
    private int c;

    public o()
    {
        c = 0;
        a = new b(d);
        d();
    }

    public final String a()
    {
        return org.a.a.b.u;
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
        if (b == c.a && b() > 0.95F)
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
        if (l == 0 && a.a() >= 2)
        {
            c = 1 + c;
        }
        k++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final float b()
    {
        float f = 0.99F;
        if (c < 6)
        {
            for (int i = 0; i < c; i++)
            {
                f *= 0.5F;
            }

            f = 1.0F - f;
        }
        return f;
    }

    public final c c()
    {
        return b;
    }

    public final void d()
    {
        a.b();
        c = 0;
        b = c.a;
    }

}
