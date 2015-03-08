// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.aw;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdListener

public final class InterstitialAd
{

    private final aw kw;

    public InterstitialAd(Context context)
    {
        kw = new aw(context);
    }

    public final AdListener getAdListener()
    {
        return kw.getAdListener();
    }

    public final String getAdUnitId()
    {
        return kw.getAdUnitId();
    }

    public final InAppPurchaseListener getInAppPurchaseListener()
    {
        return kw.getInAppPurchaseListener();
    }

    public final boolean isLoaded()
    {
        return kw.isLoaded();
    }

    public final void loadAd(AdRequest adrequest)
    {
        kw.a(adrequest.O());
    }

    public final void setAdListener(AdListener adlistener)
    {
        kw.setAdListener(adlistener);
    }

    public final void setAdUnitId(String s)
    {
        kw.setAdUnitId(s);
    }

    public final void setInAppPurchaseListener(InAppPurchaseListener inapppurchaselistener)
    {
        kw.setInAppPurchaseListener(inapppurchaselistener);
    }

    public final void setPlayStorePurchaseParams(PlayStorePurchaseListener playstorepurchaselistener, String s)
    {
        kw.setPlayStorePurchaseParams(playstorepurchaselistener, s);
    }

    public final void show()
    {
        kw.show();
    }
}
