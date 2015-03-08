// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.b;
import com.google.ads.mediation.c;
import com.google.ads.mediation.e;
import com.google.ads.mediation.g;
import com.google.ads.mediation.j;
import com.google.android.gms.dynamic.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            ev, cb, aj, cc, 
//            bw, am

public final class ca extends bv.a
{

    private final b nS;
    private final j nT;

    public ca(b b1, j j)
    {
        nS = b1;
        nT = j;
    }

    private g b(String s, int i, String s1)
    {
        HashMap hashmap;
        if (s != null)
        {
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                hashmap = new HashMap(jsonobject.length());
                String s2;
                for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s2, jsonobject.getString(s2)))
                {
                    s2 = (String)iterator.next();
                }

            }
            catch (Throwable throwable)
            {
                com.google.android.gms.internal.ev.c("Could not get MediationServerParameters.", throwable);
                throw new RemoteException();
            }
            break MISSING_BLOCK_LABEL_104;
        }
        hashmap = new HashMap(0);
        Class class1 = nS.getServerParametersType();
        g g1;
        g1 = null;
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        g1 = (g)class1.newInstance();
        g1.load(hashmap);
        return g1;
    }

    public final void a(d d, aj aj1, String s, bw bw)
    {
        a(d, aj1, s, null, bw);
    }

    public final void a(d d, aj aj1, String s, String s1, bw bw)
    {
        if (!(nS instanceof e))
        {
            ev.D((new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(nS.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ev.z("Requesting interstitial ad from adapter.");
        try
        {
            ((e)nS).requestInterstitialAd(new cb(bw), (Activity)com.google.android.gms.dynamic.e.e(d), b(s, aj1.lU, s1), com.google.android.gms.internal.cc.e(aj1), nT);
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ev.c("Could not request interstitial ad from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final void a(d d, am am, aj aj1, String s, bw bw)
    {
        a(d, am, aj1, s, null, bw);
    }

    public final void a(d d, am am, aj aj1, String s, String s1, bw bw)
    {
        if (!(nS instanceof c))
        {
            ev.D((new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(nS.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ev.z("Requesting banner ad from adapter.");
        try
        {
            ((c)nS).requestBannerAd(new cb(bw), (Activity)com.google.android.gms.dynamic.e.e(d), b(s, aj1.lU, s1), com.google.android.gms.internal.cc.b(am), com.google.android.gms.internal.cc.e(aj1), nT);
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ev.c("Could not request banner ad from adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final void destroy()
    {
        try
        {
            nS.destroy();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ev.c("Could not destroy adapter.", throwable);
        }
        throw new RemoteException();
    }

    public final d getView()
    {
        if (!(nS instanceof c))
        {
            ev.D((new StringBuilder("MediationAdapter is not a MediationBannerAdapter: ")).append(nS.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        d d;
        try
        {
            d = com.google.android.gms.dynamic.e.h(((c)nS).getBannerView());
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ev.c("Could not get banner view from adapter.", throwable);
            throw new RemoteException();
        }
        return d;
    }

    public final void pause()
    {
        throw new RemoteException();
    }

    public final void resume()
    {
        throw new RemoteException();
    }

    public final void showInterstitial()
    {
        if (!(nS instanceof e))
        {
            ev.D((new StringBuilder("MediationAdapter is not a MediationInterstitialAdapter: ")).append(nS.getClass().getCanonicalName()).toString());
            throw new RemoteException();
        }
        ev.z("Showing interstitial from adapter.");
        try
        {
            ((e)nS).showInterstitial();
            return;
        }
        catch (Throwable throwable)
        {
            com.google.android.gms.internal.ev.c("Could not show interstitial from adapter.", throwable);
        }
        throw new RemoteException();
    }
}
