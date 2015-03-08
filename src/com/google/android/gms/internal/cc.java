// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.ads.b;
import com.google.ads.c;
import com.google.ads.d;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            am, aj

public final class cc
{

    public static int a(b b1)
    {
        switch (_cls1.nX[b1.ordinal()])
        {
        default:
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;
        }
    }

    public static d b(am am1)
    {
        int i = 0;
        d ad[] = new d[6];
        ad[0] = d.a;
        ad[1] = d.b;
        ad[2] = d.c;
        ad[3] = d.d;
        ad[4] = d.e;
        ad[5] = d.f;
        for (; i < ad.length; i++)
        {
            if (ad[i].a() == am1.width && ad[i].b() == am1.height)
            {
                return ad[i];
            }
        }

        return new d(com.google.android.gms.ads.a.a(am1.width, am1.height, am1.mc));
    }

    public static com.google.ads.mediation.a e(aj aj1)
    {
        HashSet hashset;
        if (aj1.lS != null)
        {
            hashset = new HashSet(aj1.lS);
        } else
        {
            hashset = null;
        }
        return new com.google.ads.mediation.a(new Date(aj1.lQ), h(aj1.lR), hashset, aj1.lT, aj1.lY);
    }

    public static c h(int i)
    {
        switch (i)
        {
        default:
            return c.a;

        case 2: // '\002'
            return c.c;

        case 1: // '\001'
            return c.b;
        }
    }

    private class _cls1
    {

        static final int nW[];
        static final int nX[];

        static 
        {
            nX = new int[com.google.ads.b.values().length];
            try
            {
                nX[b.d.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                nX[b.a.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                nX[b.c.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                nX[b.b.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            nW = new int[c.values().length];
            try
            {
                nW[c.c.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                nW[c.b.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                nW[c.a.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror6)
            {
                return;
            }
        }
    }

}
