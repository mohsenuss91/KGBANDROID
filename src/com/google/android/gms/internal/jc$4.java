// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;

// Referenced classes of package com.google.android.gms.internal:
//            jh, jc

class <init> extends <init>
{

    final LocationListener Vu;
    final jc Vv;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((jh));
    }

    protected void a(jh jh1)
    {
        jh1.removeLocationUpdates(Vu);
        b(Status.Ek);
    }

    ionListener(jc jc, LocationListener locationlistener)
    {
        Vv = jc;
        Vu = locationlistener;
        super(null);
    }
}
