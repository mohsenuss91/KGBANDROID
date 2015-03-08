// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.e;
import com.google.android.gms.wearable.internal.f;

// Referenced classes of package com.google.android.gms.wearable:
//            DataApi, MessageApi, NodeApi, b

public class Wearable
{

    public static final Api API;
    public static final DataApi DataApi = new f();
    public static final MessageApi MessageApi = new ae();
    public static final NodeApi NodeApi = new ah();
    public static final b alm = new e();
    public static final com.google.android.gms.common.api.Api.c yE;
    private static final com.google.android.gms.common.api.Api.b yF;

    private Wearable()
    {
    }

    static 
    {
        yE = new com.google.android.gms.common.api.Api.c();
        yF = new _cls1();
        API = new Api(yF, yE, new Scope[0]);
    }

    private class _cls1
        implements com.google.android.gms.common.api.Api.b
    {

        public final volatile com.google.android.gms.common.api.Api.a a(Context context, Looper looper, gz gz, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return a(context, looper, gz, (WearableOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final au a(Context context, Looper looper, gz gz, WearableOptions wearableoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            class WearableOptions.Builder
            {

                public WearableOptions build()
                {
                    return new WearableOptions(this, null);
                }

                public WearableOptions.Builder()
                {
                }
            }

            if (wearableoptions == null)
            {
                new WearableOptions(new WearableOptions.Builder(), null);
            }
            return new au(context, looper, connectioncallbacks, onconnectionfailedlistener);
        }

        public final int getPriority()
        {
            return 0x7fffffff;
        }

        _cls1()
        {
        }

        private class WearableOptions
            implements com.google.android.gms.common.api.Api.ApiOptions.Optional
        {

            private WearableOptions(Builder builder)
            {
            }

            WearableOptions(Builder builder, _cls1 _pcls1)
            {
                this(builder);
            }
        }

    }

}
