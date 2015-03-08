// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.t;
import com.google.android.gms.drive.internal.w;

// Referenced classes of package com.google.android.gms.drive:
//            DriveApi, b, d

public final class Drive
{

    public static final Api API;
    public static final DriveApi DriveApi = new p();
    public static final Scope HE = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope HF = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api HG;
    public static final b HH = new t();
    public static final d HI = new w();
    public static final Scope SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
    public static final com.google.android.gms.common.api.Api.c yE;

    private Drive()
    {
    }

    static 
    {
        yE = new com.google.android.gms.common.api.Api.c();
        API = new Api(new _cls1(), yE, new Scope[0]);
        HG = new Api(new _cls2(), yE, new Scope[0]);
    }

    private class _cls1 extends a
    {
        private class a
            implements com.google.android.gms.common.api.Api.b
        {

            protected abstract Bundle a(com.google.android.gms.common.api.Api.ApiOptions apioptions);

            public volatile com.google.android.gms.common.api.Api.a a(Context context, Looper looper, gz gz1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return a(context, looper, gz1, (com.google.android.gms.common.api.Api.ApiOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public r a(Context context, Looper looper, gz gz1, com.google.android.gms.common.api.Api.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                List list = gz1.fg();
                return new r(context, looper, gz1, connectioncallbacks, onconnectionfailedlistener, (String[])list.toArray(new String[list.size()]), a(apioptions));
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

            public a()
            {
            }
        }


        protected final Bundle a(com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions)
        {
            return new Bundle();
        }

        protected final volatile Bundle a(com.google.android.gms.common.api.Api.ApiOptions apioptions)
        {
            return a((com.google.android.gms.common.api.Api.ApiOptions.NoOptions)apioptions);
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends a
    {

        protected final volatile Bundle a(com.google.android.gms.common.api.Api.ApiOptions apioptions)
        {
            return a((b)apioptions);
        }

        protected final Bundle a(b b1)
        {
            if (b1 == null)
            {
                return new Bundle();
            } else
            {
                return b1.ge();
            }
        }

        _cls2()
        {
        }

        private class b
            implements com.google.android.gms.common.api.Api.ApiOptions.Optional
        {

            private final Bundle HJ;

            public Bundle ge()
            {
                return HJ;
            }

            private b()
            {
                this(new Bundle());
            }

            private b(Bundle bundle)
            {
                HJ = bundle;
            }
        }

    }

}
