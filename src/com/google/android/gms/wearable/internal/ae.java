// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.MessageApi;

public final class ae
    implements MessageApi
{

    public ae()
    {
    }

    private PendingResult a(GoogleApiClient googleapiclient, com.google.android.gms.wearable.MessageApi.MessageListener messagelistener, IntentFilter aintentfilter[])
    {
        return googleapiclient.a(new _cls2(messagelistener, aintentfilter));
    }

    public final PendingResult addListener(GoogleApiClient googleapiclient, com.google.android.gms.wearable.MessageApi.MessageListener messagelistener)
    {
        return a(googleapiclient, messagelistener, null);
    }

    public final PendingResult removeListener(GoogleApiClient googleapiclient, com.google.android.gms.wearable.MessageApi.MessageListener messagelistener)
    {
        return googleapiclient.a(new _cls3(messagelistener));
    }

    public final PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1, byte abyte0[])
    {
        return googleapiclient.a(new _cls1(s, s1, abyte0));
    }

    private class _cls2 extends d
    {

        final IntentFilter alD[];
        final ae alQ;
        final com.google.android.gms.wearable.MessageApi.MessageListener alR;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alR, alD);
        }

        public Result c(Status status)
        {
            return d(status);
        }

        public Status d(Status status)
        {
            return new Status(13);
        }

        _cls2(com.google.android.gms.wearable.MessageApi.MessageListener messagelistener, IntentFilter aintentfilter[])
        {
            alQ = ae.this;
            alR = messagelistener;
            alD = aintentfilter;
            super();
        }
    }


    private class _cls3 extends d
    {

        final ae alQ;
        final com.google.android.gms.wearable.MessageApi.MessageListener alR;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alR);
        }

        public Result c(Status status)
        {
            return d(status);
        }

        public Status d(Status status)
        {
            return new Status(13);
        }

        _cls3(com.google.android.gms.wearable.MessageApi.MessageListener messagelistener)
        {
            alQ = ae.this;
            alR = messagelistener;
            super();
        }
    }


    private class _cls1 extends d
    {

        final String alO;
        final String alP;
        final ae alQ;
        final byte yI[];

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alO, alP, yI);
        }

        protected com.google.android.gms.wearable.MessageApi.SendMessageResult au(Status status)
        {
            return new a(status, -1);
        }

        protected Result c(Status status)
        {
            return au(status);
        }

        _cls1(String s, String s1, byte abyte0[])
        {
            alQ = ae.this;
            alO = s;
            alP = s1;
            yI = abyte0;
            super();
        }

        private class a
            implements com.google.android.gms.wearable.MessageApi.SendMessageResult
        {

            private final int qX;
            private final Status yw;

            public int getRequestId()
            {
                return qX;
            }

            public Status getStatus()
            {
                return yw;
            }

            public a(Status status, int i)
            {
                yw = status;
                qX = i;
            }
        }

    }

}
