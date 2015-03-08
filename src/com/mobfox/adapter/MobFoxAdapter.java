// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobfox.adapter;

import android.app.Activity;
import android.view.View;
import com.adsdk.sdk.AdManager;
import com.adsdk.sdk.banner.AdView;
import com.google.ads.d;
import com.google.ads.mediation.a;
import com.google.ads.mediation.c;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;
import com.google.ads.mediation.g;
import com.google.ads.mediation.j;

// Referenced classes of package com.mobfox.adapter:
//            MobFoxExtras, MobFoxServerParameters

public final class MobFoxAdapter
    implements c, e
{

    private static final String REQUEST_URL = "http://my.mobfox.com/request.php";
    private AdView adView;
    private com.google.ads.mediation.d bannerListener;
    private f interstitialListener;
    private AdManager mAdManager;

    public MobFoxAdapter()
    {
    }

    public final void destroy()
    {
        if (adView != null)
        {
            adView.release();
        }
        if (mAdManager != null)
        {
            mAdManager.release();
        }
        bannerListener = null;
        interstitialListener = null;
    }

    public final Class getAdditionalParametersType()
    {
        return com/mobfox/adapter/MobFoxExtras;
    }

    public final View getBannerView()
    {
        return adView;
    }

    public final Class getServerParametersType()
    {
        return com/mobfox/adapter/MobFoxServerParameters;
    }

    public final volatile void requestBannerAd(com.google.ads.mediation.d d1, Activity activity, g g, d d2, a a, j j)
    {
        requestBannerAd(d1, activity, (MobFoxServerParameters)g, d2, a, (MobFoxExtras)j);
    }

    public final void requestBannerAd(com.google.ads.mediation.d d1, Activity activity, MobFoxServerParameters mobfoxserverparameters, d d2, a a, MobFoxExtras mobfoxextras)
    {
        bannerListener = d1;
        if (mobfoxextras != null)
        {
            adView = new AdView(activity, "http://my.mobfox.com/request.php", mobfoxserverparameters.pubIdNumber, mobfoxextras.getLocation(), mobfoxextras.getAnimation());
        } else
        {
            adView = new AdView(activity, "http://my.mobfox.com/request.php", mobfoxserverparameters.pubIdNumber, true, true);
        }
        adView.setAdspaceHeight(d2.b());
        adView.setAdspaceWidth(d2.a());
        adView.setAdListener(new _cls1());
        adView.loadNextAd();
        adView.pause();
    }

    public final volatile void requestInterstitialAd(f f, Activity activity, g g, a a, j j)
    {
        requestInterstitialAd(f, activity, (MobFoxServerParameters)g, a, (MobFoxExtras)j);
    }

    public final void requestInterstitialAd(f f, Activity activity, MobFoxServerParameters mobfoxserverparameters, a a, MobFoxExtras mobfoxextras)
    {
        interstitialListener = f;
        if (mobfoxextras != null)
        {
            mAdManager = new AdManager(activity, "http://my.mobfox.com/request.php", mobfoxserverparameters.pubIdNumber, mobfoxextras.getLocation());
        } else
        {
            mAdManager = new AdManager(activity, "http://my.mobfox.com/request.php", mobfoxserverparameters.pubIdNumber, true);
        }
        mAdManager.setVideoAdsEnabled(true);
        mAdManager.setListener(new _cls2());
        mAdManager.requestAd();
    }

    public final void showInterstitial()
    {
        if (mAdManager != null)
        {
            mAdManager.showAd();
        }
    }



    private class _cls1
        implements AdListener
    {

        final MobFoxAdapter this$0;

        public void adClicked()
        {
            if (bannerListener != null)
            {
                bannerListener.onClick(MobFoxAdapter.this);
            }
        }

        public void adClosed(Ad ad, boolean flag)
        {
            if (bannerListener != null)
            {
                bannerListener.onDismissScreen(MobFoxAdapter.this);
            }
        }

        public void adLoadSucceeded(Ad ad)
        {
            if (bannerListener != null)
            {
                bannerListener.onReceivedAd(MobFoxAdapter.this);
            }
        }

        public void adShown(Ad ad, boolean flag)
        {
            if (bannerListener != null)
            {
                bannerListener.onPresentScreen(MobFoxAdapter.this);
            }
        }

        public void noAdFound()
        {
            if (bannerListener != null)
            {
                bannerListener.onFailedToReceiveAd(MobFoxAdapter.this, b.b);
            }
        }

        _cls1()
        {
            this$0 = MobFoxAdapter.this;
            super();
        }
    }


    private class _cls2
        implements AdListener
    {

        final MobFoxAdapter this$0;

        public void adClicked()
        {
        }

        public void adClosed(Ad ad, boolean flag)
        {
            if (interstitialListener != null)
            {
                interstitialListener.onDismissScreen(MobFoxAdapter.this);
            }
        }

        public void adLoadSucceeded(Ad ad)
        {
            if (interstitialListener != null)
            {
                interstitialListener.onReceivedAd(MobFoxAdapter.this);
            }
        }

        public void adShown(Ad ad, boolean flag)
        {
            if (interstitialListener != null)
            {
                interstitialListener.onPresentScreen(MobFoxAdapter.this);
            }
        }

        public void noAdFound()
        {
            if (interstitialListener != null)
            {
                interstitialListener.onFailedToReceiveAd(MobFoxAdapter.this, b.b);
            }
        }

        _cls2()
        {
            this$0 = MobFoxAdapter.this;
            super();
        }
    }

}
