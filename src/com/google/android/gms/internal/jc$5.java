// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            jh, jc

class <init> extends <init>
{

    final PendingIntent Vr;
    final jc Vv;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((jh));
    }

    protected void a(jh jh1)
    {
        jh1.removeLocationUpdates(Vr);
        b(Status.Ek);
    }

    .a(jc jc, PendingIntent pendingintent)
    {
        Vv = jc;
        Vr = pendingintent;
        super(null);
    }
}
