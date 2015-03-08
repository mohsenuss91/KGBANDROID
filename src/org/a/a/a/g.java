// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import org.a.a.a.d.b;
import org.a.a.a.d.h;
import org.a.a.a.d.i;
import org.a.a.a.d.j;

// Referenced classes of package org.a.a.a:
//            b, c

public final class g extends org.a.a.a.b
{

    private static final org.a.a.a.d.g e = new org.a.a.a.d.g();
    private static final h f = new h();
    private static final i g = new i();
    private static final j h = new j();
    private b a[];
    private int b;
    private c c;
    private String d;

    public g()
    {
        a = new b[4];
        a[0] = new b(e);
        a[1] = new b(f);
        a[2] = new b(g);
        a[3] = new b(h);
        d();
    }

    public final String a()
    {
        return d;
    }

    public final c a(byte abyte0[], int k)
    {
        int l;
        int i1;
        l = k + 0;
        i1 = 0;
_L6:
        int j1;
        if (i1 >= l || c != c.a)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = -1 + b;
_L2:
        int k1;
        if (j1 < 0)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        k1 = a[j1].a(abyte0[i1]);
        if (k1 != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        b = -1 + b;
        if (b <= 0)
        {
            c = c.c;
            return c;
        }
        if (j1 != b)
        {
            b b1 = a[b];
            a[b] = a[j1];
            a[j1] = b1;
        }
_L4:
        j1--;
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 != 2) goto _L4; else goto _L3
_L3:
        c = org.a.a.a.c.b;
        d = a[j1].c();
        return c;
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        return c;
    }

    public final float b()
    {
        return 0.99F;
    }

    public final c c()
    {
        return c;
    }

    public final void d()
    {
        c = c.a;
        for (int k = 0; k < a.length; k++)
        {
            a[k].b();
        }

        b = a.length;
        d = null;
    }

}
