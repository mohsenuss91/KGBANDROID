// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            hn

public final class hg
{

    private final String GF;

    public hg(String s)
    {
        GF = (String)hn.f(s);
    }

    public final void a(String s, String s1, Throwable throwable)
    {
        if (ap(4))
        {
            Log.i(s, s1, throwable);
        }
    }

    public final boolean ap(int l)
    {
        return Log.isLoggable(GF, l);
    }

    public final void b(String s, String s1, Throwable throwable)
    {
        if (ap(6))
        {
            Log.e(s, s1, throwable);
        }
    }

    public final void i(String s, String s1)
    {
        if (ap(2))
        {
            Log.v(s, s1);
        }
    }

    public final void j(String s, String s1)
    {
        if (ap(5))
        {
            Log.w(s, s1);
        }
    }

    public final void k(String s, String s1)
    {
        if (ap(6))
        {
            Log.e(s, s1);
        }
    }
}
