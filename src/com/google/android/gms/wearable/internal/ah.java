// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.NodeApi;

public final class ah
    implements NodeApi
{

    public ah()
    {
    }

    public final PendingResult addListener(GoogleApiClient googleapiclient, com.google.android.gms.wearable.NodeApi.NodeListener nodelistener)
    {
        return googleapiclient.a(new _cls3(nodelistener));
    }

    public final PendingResult getConnectedNodes(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new _cls2());
    }

    public final PendingResult getLocalNode(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new _cls1());
    }

    public final PendingResult removeListener(GoogleApiClient googleapiclient, com.google.android.gms.wearable.NodeApi.NodeListener nodelistener)
    {
        return googleapiclient.a(new _cls4(nodelistener));
    }

    private class _cls3 extends d
    {

        final ah alU;
        final com.google.android.gms.wearable.NodeApi.NodeListener alV;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alV);
        }

        public Result c(Status status)
        {
            return d(status);
        }

        public Status d(Status status)
        {
            return new Status(13);
        }

        _cls3(com.google.android.gms.wearable.NodeApi.NodeListener nodelistener)
        {
            alU = ah.this;
            alV = nodelistener;
            super();
        }
    }


    private class _cls2 extends d
    {

        final ah alU;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.q(this);
        }

        protected com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult aw(Status status)
        {
            return new a(status, null);
        }

        protected Result c(Status status)
        {
            return aw(status);
        }

        _cls2()
        {
            alU = ah.this;
            super();
        }

        private class a
            implements com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
        {

            private final List alW;
            private final Status yw;

            public List getNodes()
            {
                return alW;
            }

            public Status getStatus()
            {
                return yw;
            }

            public a(Status status, List list)
            {
                yw = status;
                alW = list;
            }
        }

    }


    private class _cls1 extends d
    {

        final ah alU;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.p(this);
        }

        protected com.google.android.gms.wearable.NodeApi.GetLocalNodeResult av(Status status)
        {
            return new b(status, null);
        }

        protected Result c(Status status)
        {
            return av(status);
        }

        _cls1()
        {
            alU = ah.this;
            super();
        }

        private class b
            implements com.google.android.gms.wearable.NodeApi.GetLocalNodeResult
        {

            private final Node alX;
            private final Status yw;

            public Node getNode()
            {
                return alX;
            }

            public Status getStatus()
            {
                return yw;
            }

            public b(Status status, Node node)
            {
                yw = status;
                alX = node;
            }
        }

    }


    private class _cls4 extends d
    {

        final ah alU;
        final com.google.android.gms.wearable.NodeApi.NodeListener alV;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.b(this, alV);
        }

        public Result c(Status status)
        {
            return d(status);
        }

        public Status d(Status status)
        {
            return new Status(13);
        }

        _cls4(com.google.android.gms.wearable.NodeApi.NodeListener nodelistener)
        {
            alU = ah.this;
            alV = nodelistener;
            super();
        }
    }

}
