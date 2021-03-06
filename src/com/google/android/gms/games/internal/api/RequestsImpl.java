// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;

public final class RequestsImpl
    implements Requests
{

    public RequestsImpl()
    {
    }

    public final PendingResult acceptRequest(GoogleApiClient googleapiclient, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        return acceptRequests(googleapiclient, arraylist);
    }

    public final PendingResult acceptRequests(GoogleApiClient googleapiclient, List list)
    {
        String as[];
        if (list == null)
        {
            as = null;
        } else
        {
            as = (String[])list.toArray(new String[list.size()]);
        }
        return googleapiclient.b(new _cls1(as));
    }

    public final PendingResult dismissRequest(GoogleApiClient googleapiclient, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        return dismissRequests(googleapiclient, arraylist);
    }

    public final PendingResult dismissRequests(GoogleApiClient googleapiclient, List list)
    {
        String as[];
        if (list == null)
        {
            as = null;
        } else
        {
            as = (String[])list.toArray(new String[list.size()]);
        }
        return googleapiclient.b(new _cls2(as));
    }

    public final ArrayList getGameRequestsFromBundle(Bundle bundle)
    {
        if (bundle == null || !bundle.containsKey("requests"))
        {
            return new ArrayList();
        }
        ArrayList arraylist = (ArrayList)bundle.get("requests");
        ArrayList arraylist1 = new ArrayList();
        int i = arraylist.size();
        for (int j = 0; j < i; j++)
        {
            arraylist1.add((GameRequest)arraylist.get(j));
        }

        return arraylist1;
    }

    public final ArrayList getGameRequestsFromInboxResponse(Intent intent)
    {
        if (intent == null)
        {
            return new ArrayList();
        } else
        {
            return getGameRequestsFromBundle(intent.getExtras());
        }
    }

    public final Intent getInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).hl();
    }

    public final int getMaxLifetimeDays(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).hn();
    }

    public final int getMaxPayloadSize(GoogleApiClient googleapiclient)
    {
        return Games.c(googleapiclient).hm();
    }

    public final Intent getSendIntent(GoogleApiClient googleapiclient, int i, byte abyte0[], int j, Bitmap bitmap, String s)
    {
        return Games.c(googleapiclient).a(i, abyte0, j, bitmap, s);
    }

    public final PendingResult loadRequests(GoogleApiClient googleapiclient, int i, int j, int k)
    {
        return googleapiclient.a(new _cls3(i, j, k));
    }

    public final void registerRequestListener(GoogleApiClient googleapiclient, OnRequestReceivedListener onrequestreceivedlistener)
    {
        Games.c(googleapiclient).a(onrequestreceivedlistener);
    }

    public final void unregisterRequestListener(GoogleApiClient googleapiclient)
    {
        Games.c(googleapiclient).hf();
    }

    private class _cls1 extends UpdateRequestsImpl
    {
        private class UpdateRequestsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.request.Requests.UpdateRequestsResult Y(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.request.Requests.UpdateRequestsResult
                {

                    final UpdateRequestsImpl QE;
                    final Status yG;

                    public Set getRequestIds()
                    {
                        return null;
                    }

                    public int getRequestOutcome(String s)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Unknown request ID ")).append(s).toString());
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
                        QE = UpdateRequestsImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return Y(status);
            }

            private UpdateRequestsImpl()
            {
            }

            UpdateRequestsImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final String Qt[];
        final RequestsImpl Qu;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.b(this, Qt);
        }

        _cls1(String as[])
        {
            Qu = RequestsImpl.this;
            Qt = as;
            super(null);
        }
    }


    private class _cls2 extends UpdateRequestsImpl
    {

        final String Qt[];
        final RequestsImpl Qu;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.c(this, Qt);
        }

        _cls2(String as[])
        {
            Qu = RequestsImpl.this;
            Qt = as;
            super(null);
        }
    }


    private class _cls3 extends LoadRequestsImpl
    {
        private class LoadRequestsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
        {

            public com.google.android.gms.games.request.Requests.LoadRequestsResult W(Status status)
            {
                class _cls1
                    implements com.google.android.gms.games.request.Requests.LoadRequestsResult
                {

                    final LoadRequestsImpl QC;
                    final Status yG;

                    public GameRequestBuffer getRequests(int i)
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
                        QC = LoadRequestsImpl.this;
                        yG = status;
                        super();
                    }
                }

                return new _cls1(status);
            }

            public Result c(Status status)
            {
                return W(status);
            }

            private LoadRequestsImpl()
            {
            }

            LoadRequestsImpl(_cls1 _pcls1)
            {
                this();
            }
        }


        final int PB;
        final RequestsImpl Qu;
        final int Qv;
        final int Qw;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.a(this, Qv, Qw, PB);
        }

        _cls3(int i, int j, int k)
        {
            Qu = RequestsImpl.this;
            Qv = i;
            Qw = j;
            PB = k;
            super(null);
        }
    }

}
