// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.gi;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, ApplicationMetadata, LaunchOptions

public final class sult
    implements sult
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
        class _cls6 extends Cast.c
        {

            final Cast.CastApi.a zT;

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
                zT = Cast.CastApi.a.this;
                super(null);
            }
        }

        return googleapiclient.b(new _cls6());
    }

    public final PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
    {
        class _cls5 extends Cast.c
        {

            final Cast.CastApi.a zT;
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
                zT = Cast.CastApi.a.this;
                zU = s;
                super(null);
            }
        }

        return googleapiclient.b(new _cls5(s));
    }

    public final PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
    {
        class _cls4 extends Cast.c
        {

            final Cast.CastApi.a zT;
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
                zT = Cast.CastApi.a.this;
                zU = s;
                zW = s1;
                super(null);
            }
        }

        return googleapiclient.b(new _cls4(s, s1));
    }

    public final PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
    {
        class _cls2 extends Cast.c
        {

            final Cast.CastApi.a zT;
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
                zT = Cast.CastApi.a.this;
                zU = s;
                super(null);
            }
        }

        return googleapiclient.b(new _cls2(s));
    }

    public final PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions)
    {
        class _cls3 extends Cast.c
        {

            final Cast.CastApi.a zT;
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
                zT = Cast.CastApi.a.this;
                zU = s;
                zV = launchoptions;
                super(null);
            }
        }

        return googleapiclient.b(new _cls3(s, launchoptions));
    }

    public final PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return launchApplication(googleapiclient, s, (new uilder()).setRelaunchIfRunning(flag).build());
    }

    public final PendingResult leaveApplication(GoogleApiClient googleapiclient)
    {
        class _cls7 extends Cast.b
        {

            final Cast.CastApi.a zT;

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
                zT = Cast.CastApi.a.this;
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
        class _cls1 extends Cast.b
        {

            final String zR;
            final String zS;
            final Cast.CastApi.a zT;

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
                zT = Cast.CastApi.a.this;
                zR = s;
                zS = s1;
                super(null);
            }
        }

        return googleapiclient.b(new _cls1(s, s1));
    }

    public final void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, eivedCallback eivedcallback)
    {
        try
        {
            ((gi)googleapiclient.a(Cast.yE)).a(s, eivedcallback);
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
        class _cls8 extends Cast.b
        {

            final Cast.CastApi.a zT;

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
                zT = Cast.CastApi.a.this;
                super(null);
            }
        }

        return googleapiclient.b(new _cls8());
    }

    public final PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
    {
        class _cls9 extends Cast.b
        {

            final Cast.CastApi.a zT;
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
                zT = Cast.CastApi.a.this;
                zW = s;
                super(null);
            }
        }

        return googleapiclient.b(new _cls9(s));
    }

    public sult()
    {
    }
}
