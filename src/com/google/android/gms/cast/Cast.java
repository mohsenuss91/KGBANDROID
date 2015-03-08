// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

public final class Cast
{

    public static final Api API;
    public static final CastApi CastApi = new CastApi.a();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 0x10000;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final com.google.android.gms.common.api.Api.c yE;
    private static final com.google.android.gms.common.api.Api.b yF;

    private Cast()
    {
    }

    static 
    {
        yE = new com.google.android.gms.common.api.Api.c();
        yF = new _cls1();
        API = new Api(yF, yE, new Scope[0]);
        class CastApi.a
            implements CastApi
        {

            public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
            {
                return ((gi)googleapiclient.a(Cast.yE)).getApplicationMetadata();
            }

            public final String getApplicationStatus(GoogleApiClient googleapiclient)
            {
                return ((gi)googleapiclient.a(Cast.yE)).getApplicationStatus();
            }

            public final double getVolume(GoogleApiClient googleapiclient)
            {
                return ((gi)googleapiclient.a(Cast.yE)).ec();
            }

            public final boolean isMute(GoogleApiClient googleapiclient)
            {
                return ((gi)googleapiclient.a(Cast.yE)).isMute();
            }

            public final PendingResult joinApplication(GoogleApiClient googleapiclient)
            {
                class _cls6 extends c
                {
                        private class c extends a
                        {
                            private class a extends com.google.android.gms.common.api.a.b
                            {

                                public void N(int i)
                                {
                                    b(c(new Status(i)));
                                }

                                public void c(int i, String s)
                                {
                                    b(c(new Status(i, s, null)));
                                }

                                public a()
                                {
                                    super(Cast.yE);
                                }
                            }


                            public Result c(Status status)
                            {
                                return j(status);
                            }

                            public ApplicationConnectionResult j(Status status)
                            {
                                class _cls1
                                    implements ApplicationConnectionResult
                                {

                                    final c Ad;
                                    final Status yG;

                                    public ApplicationMetadata getApplicationMetadata()
                                    {
                                        return null;
                                    }

                                    public String getApplicationStatus()
                                    {
                                        return null;
                                    }

                                    public String getSessionId()
                                    {
                                        return null;
                                    }

                                    public Status getStatus()
                                    {
                                        return yG;
                                    }

                                    public boolean getWasLaunched()
                                    {
                                        return false;
                                    }

                                    _cls1(Status status)
                                    {
                                        Ad = c.this;
                                        yG = status;
                                        super();
                                    }
                                }

                                return new _cls1(status);
                            }

                            private c()
                            {
                            }

                            c(_cls1 _pcls1)
                            {
                                this();
                            }
                        }


                    final CastApi.a zT;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.b(null, null, this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls6()
                        {
                            zT = CastApi.a.this;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls6());
            }

            public final PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
            {
                class _cls5 extends c
                {

                    final CastApi.a zT;
                    final String zU;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.b(zU, null, this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls5(String s)
                        {
                            zT = CastApi.a.this;
                            zU = s;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls5(s));
            }

            public final PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
            {
                class _cls4 extends c
                {

                    final CastApi.a zT;
                    final String zU;
                    final String zW;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.b(zU, zW, this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls4(String s, String s1)
                        {
                            zT = CastApi.a.this;
                            zU = s;
                            zW = s1;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls4(s, s1));
            }

            public final PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
            {
                class _cls2 extends c
                {

                    final CastApi.a zT;
                    final String zU;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.a(zU, false, this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls2(String s)
                        {
                            zT = CastApi.a.this;
                            zU = s;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls2(s));
            }

            public final PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions)
            {
                class _cls3 extends c
                {

                    final CastApi.a zT;
                    final String zU;
                    final LaunchOptions zV;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.a(zU, zV, this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls3(String s, LaunchOptions launchoptions)
                        {
                            zT = CastApi.a.this;
                            zU = s;
                            zV = launchoptions;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls3(s, launchoptions));
            }

            public final PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
            {
                return launchApplication(googleapiclient, s, (new LaunchOptions.Builder()).setRelaunchIfRunning(flag).build());
            }

            public final PendingResult leaveApplication(GoogleApiClient googleapiclient)
            {
                class _cls7 extends b
                {
                        private class b extends a
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


                    final CastApi.a zT;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.d(this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls7()
                        {
                            zT = CastApi.a.this;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls7());
            }

            public final void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
            {
                try
                {
                    ((gi)googleapiclient.a(Cast.yE)).aj(s);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new IOException("service error");
                }
            }

            public final void requestStatus(GoogleApiClient googleapiclient)
            {
                try
                {
                    ((gi)googleapiclient.a(Cast.yE)).eb();
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new IOException("service error");
                }
            }

            public final PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1)
            {
                class _cls1 extends b
                {

                    final String zR;
                    final String zS;
                    final CastApi.a zT;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.a(zR, zS, this);
                            return;
                        }
                        catch (IllegalArgumentException illegalargumentexception)
                        {
                            N(2001);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls1(String s, String s1)
                        {
                            zT = CastApi.a.this;
                            zR = s;
                            zS = s1;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls1(s, s1));
            }

            public final void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, MessageReceivedCallback messagereceivedcallback)
            {
                try
                {
                    ((gi)googleapiclient.a(Cast.yE)).a(s, messagereceivedcallback);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new IOException("service error");
                }
            }

            public final void setMute(GoogleApiClient googleapiclient, boolean flag)
            {
                try
                {
                    ((gi)googleapiclient.a(Cast.yE)).y(flag);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new IOException("service error");
                }
            }

            public final void setVolume(GoogleApiClient googleapiclient, double d)
            {
                try
                {
                    ((gi)googleapiclient.a(Cast.yE)).a(d);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    throw new IOException("service error");
                }
            }

            public final PendingResult stopApplication(GoogleApiClient googleapiclient)
            {
                class _cls8 extends b
                {

                    final CastApi.a zT;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        try
                        {
                            gi1.a("", this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls8()
                        {
                            zT = CastApi.a.this;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls8());
            }

            public final PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
            {
                class _cls9 extends b
                {

                    final CastApi.a zT;
                    final String zW;

                    protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    {
                        a((gi)a1);
                    }

                    protected void a(gi gi1)
                    {
                        if (TextUtils.isEmpty(zW))
                        {
                            c(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try
                        {
                            gi1.a(zW, this);
                            return;
                        }
                        catch (IllegalStateException illegalstateexception)
                        {
                            N(2001);
                        }
                    }

                        _cls9(String s)
                        {
                            zT = CastApi.a.this;
                            zW = s;
                            super(null);
                        }
                }

                return googleapiclient.b(new _cls9(s));
            }

            public CastApi.a()
            {
            }
        }

    }

    private class _cls1
        implements com.google.android.gms.common.api.Api.b
    {

        public final volatile com.google.android.gms.common.api.Api.a a(Context context, Looper looper, gz gz, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return a(context, looper, gz, (CastOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public final gi a(Context context, Looper looper, gz gz, CastOptions castoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            hn.b(castoptions, "Setting the API options is required.");
            return new gi(context, looper, castoptions.zX, CastOptions.a(castoptions), castoptions.zY, connectioncallbacks, onconnectionfailedlistener);
        }

        public final int getPriority()
        {
            return 0x7fffffff;
        }

        _cls1()
        {
        }

        private class CastOptions
            implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
        {

            final CastDevice zX;
            final Listener zY;
            private final int zZ;

            static int a(CastOptions castoptions)
            {
                return castoptions.zZ;
            }

            public static Builder builder(CastDevice castdevice, Listener listener)
            {
                return new Builder(castdevice, listener, null);
            }

            private CastOptions(Builder builder1)
            {
                class Builder
                {

                    CastDevice Aa;
                    Listener Ab;
                    private int Ac;

                    static int a(Builder builder2)
                    {
                        return builder2.Ac;
                    }

                    public final CastOptions build()
                    {
                        return new CastOptions(this, null);
                    }

                    public final Builder setVerboseLoggingEnabled(boolean flag)
                    {
                        if (flag)
                        {
                            Ac = 1 | Ac;
                            return this;
                        } else
                        {
                            Ac = -2 & Ac;
                            return this;
                        }
                    }

                    private Builder(CastDevice castdevice, Listener listener)
                    {
                        hn.b(castdevice, "CastDevice parameter cannot be null");
                        hn.b(listener, "CastListener parameter cannot be null");
                        Aa = castdevice;
                        Ab = listener;
                        Ac = 0;
                    }

                    Builder(CastDevice castdevice, Listener listener, _cls1 _pcls1)
                    {
                        this(castdevice, listener);
                    }
                }

                zX = builder1.Aa;
                zY = builder1.Ab;
                zZ = Builder.a(builder1);
            }

            CastOptions(Builder builder1, _cls1 _pcls1)
            {
                this(builder1);
            }
        }

    }

}
