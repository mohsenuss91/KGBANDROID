// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.internal:
//            jh, jc

class <init> extends <init>
{

    final PendingIntent Vr;
    final LocationRequest Vt;
    final jc Vv;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((jh));
    }

    protected void a(jh jh1)
    {
        jh1.requestLocationUpdates(Vt, Vr);
        b(Status.Ek);
    }

    ionRequest(jc jc, LocationRequest locationrequest, PendingIntent pendingintent)
    {
        Vv = jc;
        Vt = locationrequest;
        Vr = pendingintent;
        super(null);
    }
}
