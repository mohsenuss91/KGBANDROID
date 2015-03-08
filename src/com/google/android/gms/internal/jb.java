// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.ActivityRecognitionApi;

public class jb
    implements ActivityRecognitionApi
{

    public jb()
    {
    }

    public PendingResult removeActivityUpdates(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.b(new _cls2(pendingintent));
    }

    public PendingResult requestActivityUpdates(GoogleApiClient googleapiclient, long l, PendingIntent pendingintent)
    {
        return googleapiclient.b(new _cls1(l, pendingintent));
    }

    private class _cls2 extends a
    {
        private class a extends com.google.android.gms.location.ActivityRecognition.a
        {

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            private a()
            {
            }

            a(_cls1 _pcls1)
            {
                this();
            }
        }


        final PendingIntent Vr;
        final jb Vs;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.removeActivityUpdates(Vr);
            b(Status.Ek);
        }

        _cls2(PendingIntent pendingintent)
        {
            Vs = jb.this;
            Vr = pendingintent;
            super(null);
        }
    }


    private class _cls1 extends a
    {

        final long Vq;
        final PendingIntent Vr;
        final jb Vs;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((jh)a1);
        }

        protected void a(jh jh1)
        {
            jh1.requestActivityUpdates(Vq, Vr);
            b(Status.Ek);
        }

        _cls1(long l, PendingIntent pendingintent)
        {
            Vs = jb.this;
            Vq = l;
            Vr = pendingintent;
            super(null);
        }
    }

}
