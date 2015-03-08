// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.RemoteException;
import com.google.ads.b;
import com.google.ads.mediation.c;
import com.google.ads.mediation.d;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;

// Referenced classes of package com.google.android.gms.internal:
//            ev, eu, bw, cc

public final class cb
    implements d, f
{

    private final bw nR;

    public cb(bw bw1)
    {
        nR = bw1;
    }

    static bw a(cb cb1)
    {
        return cb1.nR;
    }

    public final void onClick(c c)
    {
        ev.z("Adapter called onClick.");
        if (!eu.bR())
        {
            ev.D("onClick must be called on the main UI thread.");
            eu.ss.post(new _cls1());
            return;
        }
        try
        {
            nR.onAdClicked();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdClicked.", remoteexception);
        }
    }

    public final void onDismissScreen(c c)
    {
        ev.z("Adapter called onDismissScreen.");
        if (!eu.bR())
        {
            ev.D("onDismissScreen must be called on the main UI thread.");
            eu.ss.post(new _cls4());
            return;
        }
        try
        {
            nR.onAdClosed();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdClosed.", remoteexception);
        }
    }

    public final void onDismissScreen(e e)
    {
        ev.z("Adapter called onDismissScreen.");
        if (!eu.bR())
        {
            ev.D("onDismissScreen must be called on the main UI thread.");
            eu.ss.post(new _cls9());
            return;
        }
        try
        {
            nR.onAdClosed();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdClosed.", remoteexception);
        }
    }

    public final void onFailedToReceiveAd(c c, b b)
    {
        ev.z((new StringBuilder("Adapter called onFailedToReceiveAd with error. ")).append(b).toString());
        if (!eu.bR())
        {
            ev.D("onFailedToReceiveAd must be called on the main UI thread.");
            eu.ss.post(new _cls5(b));
            return;
        }
        try
        {
            nR.onAdFailedToLoad(cc.a(b));
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdFailedToLoad.", remoteexception);
        }
    }

    public final void onFailedToReceiveAd(e e, b b)
    {
        ev.z((new StringBuilder("Adapter called onFailedToReceiveAd with error ")).append(b).append(".").toString());
        if (!eu.bR())
        {
            ev.D("onFailedToReceiveAd must be called on the main UI thread.");
            eu.ss.post(new _cls10(b));
            return;
        }
        try
        {
            nR.onAdFailedToLoad(cc.a(b));
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdFailedToLoad.", remoteexception);
        }
    }

    public final void onLeaveApplication(c c)
    {
        ev.z("Adapter called onLeaveApplication.");
        if (!eu.bR())
        {
            ev.D("onLeaveApplication must be called on the main UI thread.");
            eu.ss.post(new _cls6());
            return;
        }
        try
        {
            nR.onAdLeftApplication();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdLeftApplication.", remoteexception);
        }
    }

    public final void onLeaveApplication(e e)
    {
        ev.z("Adapter called onLeaveApplication.");
        if (!eu.bR())
        {
            ev.D("onLeaveApplication must be called on the main UI thread.");
            eu.ss.post(new _cls11());
            return;
        }
        try
        {
            nR.onAdLeftApplication();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdLeftApplication.", remoteexception);
        }
    }

    public final void onPresentScreen(c c)
    {
        ev.z("Adapter called onPresentScreen.");
        if (!eu.bR())
        {
            ev.D("onPresentScreen must be called on the main UI thread.");
            eu.ss.post(new _cls7());
            return;
        }
        try
        {
            nR.onAdOpened();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdOpened.", remoteexception);
        }
    }

    public final void onPresentScreen(e e)
    {
        ev.z("Adapter called onPresentScreen.");
        if (!eu.bR())
        {
            ev.D("onPresentScreen must be called on the main UI thread.");
            eu.ss.post(new _cls2());
            return;
        }
        try
        {
            nR.onAdOpened();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdOpened.", remoteexception);
        }
    }

    public final void onReceivedAd(c c)
    {
        ev.z("Adapter called onReceivedAd.");
        if (!eu.bR())
        {
            ev.D("onReceivedAd must be called on the main UI thread.");
            eu.ss.post(new _cls8());
            return;
        }
        try
        {
            nR.onAdLoaded();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdLoaded.", remoteexception);
        }
    }

    public final void onReceivedAd(e e)
    {
        ev.z("Adapter called onReceivedAd.");
        if (!eu.bR())
        {
            ev.D("onReceivedAd must be called on the main UI thread.");
            eu.ss.post(new _cls3());
            return;
        }
        try
        {
            nR.onAdLoaded();
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.internal.ev.c("Could not call onAdLoaded.", remoteexception);
        }
    }

    private class _cls1
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdClicked();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdClicked.", remoteexception);
            }
        }

        _cls1()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdClosed();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdClosed.", remoteexception);
            }
        }

        _cls4()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdClosed();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdClosed.", remoteexception);
            }
        }

        _cls9()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final cb nU;
        final b nV;

        public void run()
        {
            try
            {
                cb.a(nU).onAdFailedToLoad(cc.a(nV));
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdFailedToLoad.", remoteexception);
            }
        }

        _cls5(b b)
        {
            nU = cb.this;
            nV = b;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final cb nU;
        final b nV;

        public void run()
        {
            try
            {
                cb.a(nU).onAdFailedToLoad(cc.a(nV));
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdFailedToLoad.", remoteexception);
            }
        }

        _cls10(b b)
        {
            nU = cb.this;
            nV = b;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdLeftApplication();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdLeftApplication.", remoteexception);
            }
        }

        _cls6()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls11
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdLeftApplication();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdLeftApplication.", remoteexception);
            }
        }

        _cls11()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdOpened();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdOpened.", remoteexception);
            }
        }

        _cls7()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdOpened();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdOpened.", remoteexception);
            }
        }

        _cls2()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdLoaded();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdLoaded.", remoteexception);
            }
        }

        _cls8()
        {
            nU = cb.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final cb nU;

        public void run()
        {
            try
            {
                cb.a(nU).onAdLoaded();
                return;
            }
            catch (RemoteException remoteexception)
            {
                com.google.android.gms.internal.ev.c("Could not call onAdLoaded.", remoteexception);
            }
        }

        _cls3()
        {
            nU = cb.this;
            super();
        }
    }

}
