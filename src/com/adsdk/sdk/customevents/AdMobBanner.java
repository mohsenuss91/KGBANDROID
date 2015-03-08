// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.customevents;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

// Referenced classes of package com.adsdk.sdk.customevents:
//            CustomEventBanner

public class AdMobBanner extends CustomEventBanner
{

    private AdView adView;

    public AdMobBanner()
    {
    }

    private AdListener createAdListener()
    {
        return new _cls1();
    }

    public void loadBanner(Context context, CustomEventBanner.CustomEventBannerListener customeventbannerlistener, String s, String s1, int i, int j)
    {
        listener = customeventbannerlistener;
        Class.forName("com.google.android.gms.ads.AdView");
        Class.forName("com.google.android.gms.ads.AdListener");
        Class.forName("com.google.android.gms.ads.AdRequest");
        Class.forName("com.google.android.gms.ads.AdSize");
        trackingPixel = s1;
        adView = new AdView(context);
        adView.setAdUnitId(s);
        adView.setAdSize(new AdSize(i, j));
        adView.setAdListener(createAdListener());
        AdRequest adrequest = (new com.google.android.gms.ads.AdRequest.Builder()).addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adrequest);
_L2:
        return;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        if (listener != null)
        {
            listener.onBannerFailed();
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }


    private class _cls1 extends AdListener
    {

        final AdMobBanner this$0;

        public void onAdClosed()
        {
            if (listener != null)
            {
                listener.onBannerClosed();
            }
        }

        public void onAdFailedToLoad(int i)
        {
            if (listener != null)
            {
                listener.onBannerFailed();
            }
        }

        public void onAdLoaded()
        {
            reportImpression();
            if (listener != null)
            {
                listener.onBannerLoaded(adView);
            }
        }

        public void onAdOpened()
        {
            if (listener != null)
            {
                listener.onBannerExpanded();
            }
        }

        _cls1()
        {
            this$0 = AdMobBanner.this;
            super();
        }
    }

}
