// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.e;
import com.google.android.gms.plus.model.people.Person;
import java.util.Collection;

public final class kn
    implements People
{

    public kn()
    {
    }

    public final Person getCurrentPerson(GoogleApiClient googleapiclient)
    {
        return Plus.a(googleapiclient, Plus.yE).getCurrentPerson();
    }

    public final PendingResult load(GoogleApiClient googleapiclient, Collection collection)
    {
        return googleapiclient.a(new _cls4(collection));
    }

    public final transient PendingResult load(GoogleApiClient googleapiclient, String as[])
    {
        return googleapiclient.a(new _cls5(as));
    }

    public final PendingResult loadConnected(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new _cls3());
    }

    public final PendingResult loadVisible(GoogleApiClient googleapiclient, int i, String s)
    {
        return googleapiclient.a(new _cls1(i, s));
    }

    public final PendingResult loadVisible(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.a(new _cls2(s));
    }

    private class _cls4 extends a
    {
        private class a extends com.google.android.gms.plus.Plus.a
        {

            public com.google.android.gms.plus.People.LoadPeopleResult ao(Status status)
            {
                class _cls1
                    implements com.google.android.gms.plus.People.LoadPeopleResult
                {

                    final a acn;
                    final Status yG;

                    public String getNextPageToken()
                    {
                        return null;
                    }

                    public PersonBuffer getPersonBuffer()
                    {
                        return null;
                    }

                    public Status getStatus()
                    {
                        return yG;
                    }

                    public void release()
                    {
                    }

                    _cls1(Status status)
                    {
                        acn = a.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return ao(status);
            }

            private a()
            {
            }

            a(_cls1 _pcls1)
            {
                this();
            }
        }


        final kn ack;
        final Collection acl;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            e1.a(this, acl);
        }

        _cls4(Collection collection)
        {
            ack = kn.this;
            acl = collection;
            super(null);
        }
    }


    private class _cls5 extends a
    {

        final kn ack;
        final String acm[];

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            e1.d(this, acm);
        }

        _cls5(String as[])
        {
            ack = kn.this;
            acm = as;
            super(null);
        }
    }


    private class _cls3 extends a
    {

        final kn ack;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            e1.l(this);
        }

        _cls3()
        {
            ack = kn.this;
            super(null);
        }
    }


    private class _cls1 extends a
    {

        final String acc;
        final int acj;
        final kn ack;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            a(e1.a(this, acj, acc));
        }

        _cls1(int i, String s)
        {
            ack = kn.this;
            acj = i;
            acc = s;
            super(null);
        }
    }


    private class _cls2 extends a
    {

        final String acc;
        final kn ack;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((e)a1);
        }

        protected void a(e e1)
        {
            a(e1.r(this, acc));
        }

        _cls2(String s)
        {
            ack = kn.this;
            acc = s;
            super(null);
        }
    }

}
