// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.eu;
import java.util.Iterator;
import java.util.Set;

public final class AdMobAdapter
    implements MediationBannerAdapter, MediationInterstitialAdapter
{

    private AdView i;
    private InterstitialAd j;

    public AdMobAdapter()
    {
    }

    private static AdRequest a(Context context, MediationAdRequest mediationadrequest, Bundle bundle, Bundle bundle1)
    {
        com.google.android.gms.ads.AdRequest.Builder builder = new com.google.android.gms.ads.AdRequest.Builder();
        java.util.Date date = mediationadrequest.getBirthday();
        if (date != null)
        {
            builder.setBirthday(date);
        }
        int k = mediationadrequest.getGender();
        if (k != 0)
        {
            builder.setGender(k);
        }
        Set set = mediationadrequest.getKeywords();
        if (set != null)
        {
            for (Iterator iterator = set.iterator(); iterator.hasNext(); builder.addKeyword((String)iterator.next())) { }
        }
        if (mediationadrequest.isTesting())
        {
            builder.addTestDevice(eu.o(context));
        }
        if (bundle1.getInt("tagForChildDirectedTreatment") != -1)
        {
            boolean flag;
            if (bundle1.getInt("tagForChildDirectedTreatment") == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            builder.tagForChildDirectedTreatment(flag);
        }
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle1.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle1.getString("adJson")))
        {
            bundle.putString("_ad", bundle1.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(com/google/ads/mediation/admob/AdMobAdapter, bundle);
        return builder.build();
    }

    public final View getBannerView()
    {
        return i;
    }

    public final void onDestroy()
    {
        if (i != null)
        {
            i.destroy();
            i = null;
        }
        if (j != null)
        {
            j = null;
        }
    }

    public final void onPause()
    {
        if (i != null)
        {
            i.pause();
        }
    }

    public final void onResume()
    {
        if (i != null)
        {
            i.resume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationbannerlistener, Bundle bundle, AdSize adsize, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        i = new AdView(context);
        i.setAdSize(new AdSize(adsize.getWidth(), adsize.getHeight()));
        i.setAdUnitId(bundle.getString("pubid"));
        i.setAdListener(new a(mediationbannerlistener));
        i.loadAd(a(context, mediationadrequest, bundle1, bundle));
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationinterstitiallistener, Bundle bundle, MediationAdRequest mediationadrequest, Bundle bundle1)
    {
        j = new InterstitialAd(context);
        j.setAdUnitId(bundle.getString("pubid"));
        j.setAdListener(new b(mediationinterstitiallistener));
        j.loadAd(a(context, mediationadrequest, bundle1, bundle));
    }

    public final void showInterstitial()
    {
        j.show();
    }

    private class a extends AdListener
    {

        private final AdMobAdapter k;
        private final MediationBannerListener l;

        public final void onAdClosed()
        {
            l.onAdClosed(k);
        }

        public final void onAdFailedToLoad(int i1)
        {
            l.onAdFailedToLoad(k, i1);
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

        public a(MediationBannerListener mediationbannerlistener)
        {
            k = AdMobAdapter.this;
            l = mediationbannerlistener;
        }
    }


    private class b extends AdListener
    {

        private final AdMobAdapter k;
        private final MediationInterstitialListener m;

        public final void onAdClosed()
        {
            m.onAdClosed(k);
        }

        public final void onAdFailedToLoad(int l)
        {
            m.onAdFailedToLoad(k, l);
        }

        public final void onAdLeftApplication()
        {
            m.onAdLeftApplication(k);
        }

        public final void onAdLoaded()
        {
            m.onAdLoaded(k);
        }

        public final void onAdOpened()
        {
            m.onAdOpened(k);
        }

        public b(MediationInterstitialListener mediationinterstitiallistener)
        {
            k = AdMobAdapter.this;
            m = mediationinterstitiallistener;
        }
    }

}
