// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            jh, jc

class <init> extends <init>
{

    final jc Vv;
    final Location Vy;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((jh));
    }

    protected void a(jh jh1)
    {
        jh1.setMockLocation(Vy);
        b(Status.Ek);
    }

    .a(jc jc, Location location)
    {
        Vv = jc;
        Vy = location;
        super(null);
    }
}
