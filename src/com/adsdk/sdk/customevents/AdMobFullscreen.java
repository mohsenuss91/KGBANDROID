// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.customevents;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

// Referenced classes of package com.adsdk.sdk.customevents:
//            CustomEventFullscreen

public class AdMobFullscreen extends CustomEventFullscreen
{

    private AdListener adListener;
    private InterstitialAd interstitial;

    public AdMobFullscreen()
    {
    }

    private AdListener createAdListener()
    {
        return new _cls1();
    }

    public void loadFullscreen(Context context, CustomEventFullscreen.CustomEventFullscreenListener customeventfullscreenlistener, String s, String s1)
    {
        listener = customeventfullscreenlistener;
        trackingPixel = s1;
        Class.forName("com.google.android.gms.ads.AdListener");
        Class.forName("com.google.android.gms.ads.AdRequest");
        Class.forName("com.google.android.gms.ads.InterstitialAd");
        adListener = createAdListener();
        interstitial = new InterstitialAd(context);
        interstitial.setAdUnitId(s);
        interstitial.setAdListener(adListener);
        com.google.android.gms.ads.AdRequest adrequest = (new com.google.android.gms.ads.AdRequest.Builder()).build();
        interstitial.loadAd(adrequest);
_L2:
        return;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        if (listener != null)
        {
            listener.onFullscreenFailed();
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void showFullscreen()
    {
        if (interstitial.isLoaded())
        {
            interstitial.show();
        }
    }

    private class _cls1 extends AdListener
    {

        final AdMobFullscreen this$0;

        public void onAdClosed()
        {
            if (listener != null)
            {
                listener.onFullscreenClosed();
            }
        }

        public void onAdFailedToLoad(int i)
        {
            if (listener != null)
            {
                listener.onFullscreenFailed();
            }
        }

        public void onAdLeftApplication()
        {
            if (listener != null)
            {
                listener.onFullscreenLeftApplication();
            }
        }

        public void onAdLoaded()
        {
            if (listener != null)
            {
                listener.onFullscreenLoaded(AdMobFullscreen.this);
            }
        }

        public void onAdOpened()
        {
            if (listener != null)
            {
                reportImpression();
                listener.onFullscreenOpened();
            }
        }

        _cls1()
        {
            this$0 = AdMobFullscreen.this;
            super();
        }
    }

}
