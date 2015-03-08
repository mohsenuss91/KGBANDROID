// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.panorama.PanoramaApi;

// Referenced classes of package com.google.android.gms.internal:
//            kf, ke

public class kg
    implements PanoramaApi
{

    public kg()
    {
    }

    private static void a(Context context, Uri uri)
    {
        context.revokeUriPermission(uri, 1);
    }

    private static void a(Context context, kf kf1, ke ke, Uri uri, Bundle bundle)
    {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        _cls4 _lcls4 = new _cls4(context, uri, ke);
        try
        {
            kf1.a(_lcls4, uri, bundle, true);
            return;
        }
        catch (RemoteException remoteexception)
        {
            context.revokeUriPermission(uri, 1);
            throw remoteexception;
        }
        catch (RuntimeException runtimeexception)
        {
            context.revokeUriPermission(uri, 1);
            throw runtimeexception;
        }
    }

    static void b(Context context, Uri uri)
    {
        context.revokeUriPermission(uri, 1);
    }

    static void b(Context context, kf kf1, ke ke, Uri uri, Bundle bundle)
    {
        a(context, kf1, ke, uri, bundle);
    }

    public PendingResult loadPanoramaInfo(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.a(new _cls2(uri));
    }

    public PendingResult loadPanoramaInfoAndGrantAccess(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.a(new _cls3(uri));
    }

    private class _cls4 extends ke.a
    {

        final Uri abh;
        final ke abk;
        final Context qr;

        public final void a(int i, Bundle bundle, int j, Intent intent)
        {
            kg.b(qr, abh);
            abk.a(i, bundle, j, intent);
        }

        _cls4(Context context, Uri uri, ke ke1)
        {
            qr = context;
            abh = uri;
            abk = ke1;
            super();
        }
    }


    private class _cls2 extends b
    {
        private class b extends d
        {
            private class d extends com.google.android.gms.common.api.a.b
            {

                protected abstract void a(Context context, kf kf1);

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((kh)a1);
                }

                protected final void a(kh kh1)
                {
                    a(kh1.getContext(), (kf)kh1.fo());
                }

                protected d()
                {
                    super(Panorama.yE);
                }
            }


            protected com.google.android.gms.panorama.PanoramaApi.PanoramaResult ak(Status status)
            {
                return new ki(status, null);
            }

            protected Result c(Status status)
            {
                return ak(status);
            }

            private b()
            {
            }

            b(_cls1 _pcls1)
            {
                this();
            }
        }


        final Uri abh;
        final kg abj;

        protected void a(Context context, kf kf1)
        {
            kf1.a(new c(this), abh, null, false);
        }

        _cls2(Uri uri)
        {
            abj = kg.this;
            abh = uri;
            super(null);
        }

        private class c extends ke.a
        {

            private final com.google.android.gms.common.api.a.d yO;

            public final void a(int i, Bundle bundle, int j, Intent intent)
            {
                PendingIntent pendingintent;
                Status status;
                if (bundle != null)
                {
                    pendingintent = (PendingIntent)bundle.getParcelable("pendingIntent");
                } else
                {
                    pendingintent = null;
                }
                status = new Status(i, null, pendingintent);
                yO.a(new ki(status, intent));
            }

            public c(com.google.android.gms.common.api.a.d d)
            {
                yO = d;
            }
        }

    }


    private class _cls3 extends b
    {

        final Uri abh;
        final kg abj;

        protected void a(Context context, kf kf1)
        {
            kg.b(context, kf1, new c(this), abh, null);
        }

        _cls3(Uri uri)
        {
            abj = kg.this;
            abh = uri;
            super(null);
        }
    }

}
