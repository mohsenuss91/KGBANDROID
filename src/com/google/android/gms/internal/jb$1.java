// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            jh, jb

class <init> extends <init>
{

    final long Vq;
    final PendingIntent Vr;
    final jb Vs;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((jh));
    }

    protected void a(jh jh1)
    {
        jh1.requestActivityUpdates(Vq, Vr);
        b(Status.Ek);
    }

    .a(jb jb, long l, PendingIntent pendingintent)
    {
        Vs = jb;
        Vq = l;
        Vr = pendingintent;
        super(null);
    }
}
