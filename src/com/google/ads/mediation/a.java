// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.c;
import java.util.Date;
import java.util.Set;

public final class a
{

    private final Date a;
    private final c b;
    private final Set c;
    private final boolean d;
    private final Location e;

    public a(Date date, c c1, Set set, boolean flag, Location location)
    {
        a = date;
        b = c1;
        c = set;
        d = flag;
        e = location;
    }

    public final Date a()
    {
        return a;
    }

    public final c b()
    {
        return b;
    }

    public final Set c()
    {
        return c;
    }

    public final Location d()
    {
        return e;
    }
}
