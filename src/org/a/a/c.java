// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a;

import org.a.a.a.b;

// Referenced classes of package org.a.a:
//            d, a

public final class c
{

    public d a;
    public boolean b;
    public boolean c;
    public boolean d;
    public byte e;
    public String f;
    public b g[];
    public b h;
    public a i;

    public c()
    {
        i = null;
        h = null;
        g = new b[3];
        for (int j = 0; j < g.length; j++)
        {
            g[j] = null;
        }

        a();
    }

    public final void a()
    {
        b = false;
        c = true;
        f = null;
        d = false;
        a = d.a;
        e = 0;
        b b1 = h;
        int j = 0;
        if (b1 != null)
        {
            h.d();
        }
        for (; j < g.length; j++)
        {
            if (g[j] != null)
            {
                g[j].d();
            }
        }

    }
}
