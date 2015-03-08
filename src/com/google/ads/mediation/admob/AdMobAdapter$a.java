// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.mediation.MediationBannerListener;

// Referenced classes of package com.google.ads.mediation.admob:
//            AdMobAdapter

final class l extends AdListener
{

    private final AdMobAdapter k;
    private final MediationBannerListener l;

    public final void onAdClosed()
    {
        l.onAdClosed(k);
    }

    public final void onAdFailedToLoad(int i)
    {
        l.onAdFailedToLoad(k, i);
    }

    public final void onAdLeftApplication()
    {
        l.onAdLeftApplication(k);
    }

    public final void onAdLoaded()
    {
        l.onAdLoaded(k);
    }

    public final void onAdOpened()
    {
        l.onAdClicked(k);
        l.onAdOpened(k);
    }

    public BannerListener(AdMobAdapter admobadapter, MediationBannerListener mediationbannerlistener)
    {
        k = admobadapter;
        l = mediationbannerlistener;
    }
}
