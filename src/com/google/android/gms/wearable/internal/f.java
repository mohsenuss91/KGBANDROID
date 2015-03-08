// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.PutDataRequest;

public final class f
    implements DataApi
{

    public f()
    {
    }

    private PendingResult a(GoogleApiClient googleapiclient, com.google.android.gms.wearable.DataApi.DataListener datalistener, IntentFilter aintentfilter[])
    {
        return googleapiclient.a(new _cls8(datalistener, aintentfilter));
    }

    private void a(Asset asset)
    {
        if (asset == null)
        {
            throw new IllegalArgumentException("asset is null");
        }
        if (asset.getDigest() == null)
        {
            throw new IllegalArgumentException("invalid asset");
        }
        if (asset.getData() != null)
        {
            throw new IllegalArgumentException("invalid asset");
        } else
        {
            return;
        }
    }

    public final PendingResult addListener(GoogleApiClient googleapiclient, com.google.android.gms.wearable.DataApi.DataListener datalistener)
    {
        return a(googleapiclient, datalistener, null);
    }

    public final PendingResult deleteDataItems(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.a(new _cls5(uri));
    }

    public final PendingResult getDataItem(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.a(new _cls2(uri));
    }

    public final PendingResult getDataItems(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new _cls3());
    }

    public final PendingResult getDataItems(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.a(new _cls4(uri));
    }

    public final PendingResult getFdForAsset(GoogleApiClient googleapiclient, Asset asset)
    {
        a(asset);
        return googleapiclient.a(new _cls6(asset));
    }

    public final PendingResult getFdForAsset(GoogleApiClient googleapiclient, DataItemAsset dataitemasset)
    {
        return googleapiclient.a(new _cls7(dataitemasset));
    }

    public final PendingResult putDataItem(GoogleApiClient googleapiclient, PutDataRequest putdatarequest)
    {
        return googleapiclient.a(new _cls1(putdatarequest));
    }

    public final PendingResult removeListener(GoogleApiClient googleapiclient, com.google.android.gms.wearable.DataApi.DataListener datalistener)
    {
        return googleapiclient.a(new _cls9(datalistener));
    }

    private class _cls8 extends d
    {

        final com.google.android.gms.wearable.DataApi.DataListener alC;
        final IntentFilter alD[];
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alC, alD);
        }

        public Result c(Status status)
        {
            return d(status);
        }

        public Status d(Status status)
        {
            return new Status(13);
        }

        _cls8(com.google.android.gms.wearable.DataApi.DataListener datalistener, IntentFilter aintentfilter[])
        {
            alz = f.this;
            alC = datalistener;
            alD = aintentfilter;
            super();
        }
    }


    private class _cls5 extends d
    {

        final Uri abh;
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.c(this, abh);
        }

        protected com.google.android.gms.wearable.DataApi.DeleteDataItemsResult as(Status status)
        {
            return new b(status, 0);
        }

        protected Result c(Status status)
        {
            return as(status);
        }

        _cls5(Uri uri)
        {
            alz = f.this;
            abh = uri;
            super();
        }

        private class b
            implements com.google.android.gms.wearable.DataApi.DeleteDataItemsResult
        {

            private final int alF;
            private final Status yw;

            public int getNumDeleted()
            {
                return alF;
            }

            public Status getStatus()
            {
                return yw;
            }

            public b(Status status, int i)
            {
                yw = status;
                alF = i;
            }
        }

    }


    private class _cls2 extends d
    {

        final Uri abh;
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, abh);
        }

        protected com.google.android.gms.wearable.DataApi.DataItemResult aq(Status status)
        {
            return new a(status, null);
        }

        protected Result c(Status status)
        {
            return aq(status);
        }

        _cls2(Uri uri)
        {
            alz = f.this;
            abh = uri;
            super();
        }

        private class a
            implements com.google.android.gms.wearable.DataApi.DataItemResult
        {

            private final DataItem alE;
            private final Status yw;

            public DataItem getDataItem()
            {
                return alE;
            }

            public Status getStatus()
            {
                return yw;
            }

            public a(Status status, DataItem dataitem)
            {
                yw = status;
                alE = dataitem;
            }
        }

    }


    private class _cls3 extends d
    {

        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.o(this);
        }

        protected DataItemBuffer ar(Status status)
        {
            return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
        }

        protected Result c(Status status)
        {
            return ar(status);
        }

        _cls3()
        {
            alz = f.this;
            super();
        }
    }


    private class _cls4 extends d
    {

        final Uri abh;
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.b(this, abh);
        }

        protected DataItemBuffer ar(Status status)
        {
            return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
        }

        protected Result c(Status status)
        {
            return ar(status);
        }

        _cls4(Uri uri)
        {
            alz = f.this;
            abh = uri;
            super();
        }
    }


    private class _cls6 extends d
    {

        final Asset alA;
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alA);
        }

        protected com.google.android.gms.wearable.DataApi.GetFdForAssetResult at(Status status)
        {
            return new c(status, null);
        }

        protected Result c(Status status)
        {
            return at(status);
        }

        _cls6(Asset asset)
        {
            alz = f.this;
            alA = asset;
            super();
        }

        private class c
            implements com.google.android.gms.wearable.DataApi.GetFdForAssetResult
        {

            private final ParcelFileDescriptor alG;
            private final Status yw;

            public ParcelFileDescriptor getFd()
            {
                return alG;
            }

            public InputStream getInputStream()
            {
                return new android.os.ParcelFileDescriptor.AutoCloseInputStream(alG);
            }

            public Status getStatus()
            {
                return yw;
            }

            public void release()
            {
                try
                {
                    alG.close();
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            public c(Status status, ParcelFileDescriptor parcelfiledescriptor)
            {
                yw = status;
                alG = parcelfiledescriptor;
            }
        }

    }


    private class _cls7 extends d
    {

        final DataItemAsset alB;
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alB);
        }

        protected com.google.android.gms.wearable.DataApi.GetFdForAssetResult at(Status status)
        {
            return new c(status, null);
        }

        protected Result c(Status status)
        {
            return at(status);
        }

        _cls7(DataItemAsset dataitemasset)
        {
            alz = f.this;
            alB = dataitemasset;
            super();
        }
    }


    private class _cls1 extends d
    {

        final PutDataRequest aly;
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, aly);
        }

        public com.google.android.gms.wearable.DataApi.DataItemResult aq(Status status)
        {
            return new a(status, null);
        }

        public Result c(Status status)
        {
            return aq(status);
        }

        _cls1(PutDataRequest putdatarequest)
        {
            alz = f.this;
            aly = putdatarequest;
            super();
        }
    }


    private class _cls9 extends d
    {

        final com.google.android.gms.wearable.DataApi.DataListener alC;
        final f alz;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
        {
            a((au)a1);
        }

        protected void a(au au1)
        {
            au1.a(this, alC);
        }

        public Result c(Status status)
        {
            return d(status);
        }

        public Status d(Status status)
        {
            return new Status(13);
        }

        _cls9(com.google.android.gms.wearable.DataApi.DataListener datalistener)
        {
            alz = f.this;
            alC = datalistener;
            super();
        }
    }

}
