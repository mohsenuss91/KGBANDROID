// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.model.moments.Moment;

public final class km
    implements Moments
{

    public km()
    {
    }

    public final PendingResult load(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new _cls1());
    }

    public final PendingResult load(GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        return googleapiclient.a(new _cls2(i, s, uri, s1, s2));
    }

    public final PendingResult remove(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new _cls4(s));
    }

    public final PendingResult write(GoogleApiClient googleapiclient, Moment moment)
    {
        return googleapiclient.b(new _cls3(moment));
    }

    private class _cls1 extends a
    {
        private class a extends com.google.android.gms.plus.Plus.a
        {

            public com.google.android.gms.plus.Moments.LoadMomentsResult an(Status status)
            {
                class _cls1
                    implements com.google.android.gms.plus.Moments.LoadMomentsResult
                {

                    final a aci;
                    final Status yG;

                    public MomentBuffer getMomentBuffer()
                    {
                        return null;
                    }

                    public String getNextPageToken()
                    {
                        return null;
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    public String getUpdated()
                    {
                        return null;
                    }

                    public void release()
                    {
                    }

                    _cls1(Status status)
                    {
                        aci = a.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return an(status);
            }

            private a()
            {
            }

            a(_cls1 _pcls1)
            {
                this();
            }
        }


        final km acb;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            e1.k(this);
        }

        _cls1()
        {
            acb = km.this;
            super(null);
        }
    }


    private class _cls2 extends a
    {

        final int PJ;
        final km acb;
        final String acc;
        final Uri acd;
        final String ace;
        final String acf;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            e1.a(this, PJ, acc, acd, ace, acf);
        }

        _cls2(int i, String s, Uri uri, String s1, String s2)
        {
            acb = km.this;
            PJ = i;
            acc = s;
            acd = uri;
            ace = s1;
            acf = s2;
            super(null);
        }
    }


    private class _cls4 extends b
    {
        private class b extends com.google.android.gms.plus.Plus.a
        {

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            private b()
            {
            }

            b(_cls1 _pcls1)
            {
                this();
            }
        }


        final km acb;
        final String ach;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            e1.removeMoment(ach);
            b(Status.Ek);
        }

        _cls4(String s)
        {
            acb = km.this;
            ach = s;
            super(null);
        }
    }


    private class _cls3 extends c
    {
        private class c extends com.google.android.gms.plus.Plus.a
        {

            public Result c(Status status)
            {
                return d(status);
            }

            public Status d(Status status)
            {
                return status;
            }

            private c()
            {
            }

            c(_cls1 _pcls1)
            {
                this();
            }
        }


        final km acb;
        final Moment acg;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            e1.a(this, acg);
        }

        _cls3(Moment moment)
        {
            acb = km.this;
            acg = moment;
            super(null);
        }
    }

}
