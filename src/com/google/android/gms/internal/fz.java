// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            fu, fg, fy, fs

public final class fz
    implements AppIndexApi, fu
{

    public fz()
    {
    }

    static Uri a(String s, Uri uri)
    {
        if (!"android-app".equals(uri.getScheme()))
        {
            throw new IllegalArgumentException((new StringBuilder("Uri scheme must be android-app: ")).append(uri).toString());
        }
        if (!s.equals(uri.getHost()))
        {
            throw new IllegalArgumentException((new StringBuilder("Uri host must match package name: ")).append(uri).toString());
        }
        List list = uri.getPathSegments();
        if (list.isEmpty() || ((String)list.get(0)).isEmpty())
        {
            throw new IllegalArgumentException((new StringBuilder("Uri path must exist: ")).append(uri).toString());
        }
        String s1 = (String)list.get(0);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme(s1);
        if (list.size() > 1)
        {
            builder.authority((String)list.get(1));
            for (int i = 2; i < list.size(); i++)
            {
                builder.appendPath((String)list.get(i));
            }

        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return builder.build();
    }

    public final transient PendingResult a(GoogleApiClient googleapiclient, fs afs[])
    {
        return googleapiclient.a(new _cls2(((fy)googleapiclient.a(fg.xF)).getContext().getPackageName(), afs));
    }

    public final PendingResult view(GoogleApiClient googleapiclient, Activity activity, Intent intent, String s, Uri uri, List list)
    {
        String s1 = ((fy)googleapiclient.a(fg.xF)).getContext().getPackageName();
        fs afs[] = new fs[1];
        afs[0] = new fs(s1, intent, s, uri, null, list);
        return a(googleapiclient, afs);
    }

    public final PendingResult view(GoogleApiClient googleapiclient, Activity activity, Uri uri, String s, Uri uri1, List list)
    {
        return view(googleapiclient, activity, new Intent("android.intent.action.VIEW", a(((fy)googleapiclient.a(fg.xF)).getContext().getPackageName(), uri)), s, uri1, list);
    }

    public final PendingResult viewEnd(GoogleApiClient googleapiclient, Activity activity, Intent intent)
    {
        return a(googleapiclient, new fs[] {
            new fs(fs.a(((fy)googleapiclient.a(fg.xF)).getContext().getPackageName(), intent), System.currentTimeMillis(), 3)
        });
    }

    public final PendingResult viewEnd(GoogleApiClient googleapiclient, Activity activity, Uri uri)
    {
        return viewEnd(googleapiclient, activity, new Intent("android.intent.action.VIEW", a(((fy)googleapiclient.a(fg.xF)).getContext().getPackageName(), uri)));
    }

    private class _cls2 extends d
    {
        private class d extends c
        {
            private class c extends com.google.android.gms.common.api.a.b
            {

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((fy)a1);
                }

                protected abstract void a(fv fv1);

                protected final void a(fy fy1)
                {
                    a(fy1.dM());
                }

                public c()
                {
                    super(fg.xF);
                }
            }


            protected Result c(Status status)
            {
                return d(status);
            }

            protected Status d(Status status)
            {
                return status;
            }

            private d()
            {
            }

            d(_cls1 _pcls1)
            {
                this();
            }
        }


        final String yt;
        final fs yu[];
        final fz yv;

        protected void a(fv fv1)
        {
            fv1.a(new e(this), yt, yu);
        }

        _cls2(String s, fs afs[])
        {
            yv = fz.this;
            yt = s;
            yu = afs;
            super(null);
        }

        private class e extends fx
        {

            public final void a(Status status)
            {
                yr.a(status);
            }

            public e(com.google.android.gms.common.api.a.d d1)
            {
                super(d1);
            }
        }

    }

}
