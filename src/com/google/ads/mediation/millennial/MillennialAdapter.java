// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import com.google.ads.b;
import com.google.ads.d;
import com.google.ads.mediation.a;
import com.google.ads.mediation.c;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;
import com.google.ads.mediation.g;
import com.google.ads.mediation.j;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import java.util.Hashtable;

// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras, MillennialAdapterServerParameters

public final class MillennialAdapter
    implements c, e
{

    private static int $SWITCH_TABLE$com$google$ads$AdRequest$Gender[];
    private MMAdView adView;
    private com.google.ads.mediation.d bannerListener;
    private f interstitialListener;
    private MMInterstitial interstitialView;
    private FrameLayout wrappedAdView;

    static int[] $SWITCH_TABLE$com$google$ads$AdRequest$Gender()
    {
        int ai[] = $SWITCH_TABLE$com$google$ads$AdRequest$Gender;
        if (ai != null)
        {
            return ai;
        }
        int ai1[] = new int[com.google.ads.c.values().length];
        try
        {
            ai1[com.google.ads.c.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            ai1[com.google.ads.c.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai1[com.google.ads.c.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SWITCH_TABLE$com$google$ads$AdRequest$Gender = ai1;
        return ai1;
    }

    public MillennialAdapter()
    {
    }

    private void populateAdViewParameters(MMAd mmad, Hashtable hashtable, a a1, MillennialAdapterExtras millennialadapterextras)
    {
        MMRequest mmrequest;
        if (millennialadapterextras == null)
        {
            millennialadapterextras = new MillennialAdapterExtras();
        }
        if (a1.c() != null)
        {
            hashtable.put("keywords", TextUtils.join(",", a1.c()));
        }
        if (millennialadapterextras.getChildren() != null)
        {
            String s;
            if (millennialadapterextras.getChildren().booleanValue())
            {
                s = "true";
            } else
            {
                s = "false";
            }
            hashtable.put("children", s);
        }
        mmrequest = new MMRequest();
        if (a1.b() == null) goto _L2; else goto _L1
_L1:
        $SWITCH_TABLE$com$google$ads$AdRequest$Gender()[a1.b().ordinal()];
        JVM INSTR tableswitch 2 3: default 120
    //                   2 304
    //                   3 314;
           goto _L2 _L3 _L4
_L2:
        if (millennialadapterextras.getIncomeInUsDollars() != null)
        {
            mmrequest.setIncome(millennialadapterextras.getIncomeInUsDollars().toString());
        }
        if (a1.d() != null)
        {
            MMRequest.setUserLocation(a1.d());
        }
        if (millennialadapterextras.getPostalCode() != null)
        {
            mmrequest.setZip(millennialadapterextras.getPostalCode());
        }
        if (millennialadapterextras.getMaritalStatus() != null)
        {
            mmrequest.setMarital(millennialadapterextras.getMaritalStatus().getDescription());
        }
        if (millennialadapterextras.getEthnicity() != null)
        {
            mmrequest.setEthnicity(millennialadapterextras.getEthnicity().getDescription());
        }
        if (millennialadapterextras.getOrientation() != null)
        {
            mmrequest.setOrientation(millennialadapterextras.getOrientation().getDescription());
        }
        if (millennialadapterextras.getPolitics() != null)
        {
            mmrequest.setPolitics(millennialadapterextras.getPolitics().getDescription());
        }
        if (millennialadapterextras.getEducation() != null)
        {
            mmrequest.setEducation(millennialadapterextras.getEducation().getDescription());
        }
        if (hashtable != null)
        {
            mmrequest.setMetaValues(hashtable);
        }
        mmad.setMMRequest(mmrequest);
        return;
_L3:
        mmrequest.setGender("male");
        continue; /* Loop/switch isn't completed */
_L4:
        mmrequest.setGender("female");
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void destroy()
    {
    }

    public final Class getAdditionalParametersType()
    {
        return com/google/ads/mediation/millennial/MillennialAdapterExtras;
    }

    public final View getBannerView()
    {
        return wrappedAdView;
    }

    public final Class getServerParametersType()
    {
        return com/google/ads/mediation/millennial/MillennialAdapterServerParameters;
    }

    public final volatile void requestBannerAd(com.google.ads.mediation.d d1, Activity activity, g g, d d2, a a1, j j)
    {
        requestBannerAd(d1, activity, (MillennialAdapterServerParameters)g, d2, a1, (MillennialAdapterExtras)j);
    }

    public final void requestBannerAd(com.google.ads.mediation.d d1, Activity activity, MillennialAdapterServerParameters millennialadapterserverparameters, d d2, a a1, MillennialAdapterExtras millennialadapterextras)
    {
        bannerListener = d1;
        Hashtable hashtable = new Hashtable();
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(d2.a(activity), d2.b(activity));
        adView = new MMAdView(activity);
        adView.setApid(millennialadapterserverparameters.apid);
        adView.setHeight(d2.b());
        adView.setWidth(d2.a());
        adView.setId(MMSDK.getDefaultAdId());
        populateAdViewParameters(adView, hashtable, a1, millennialadapterextras);
        adView.setListener(new BannerListener(null));
        wrappedAdView = new FrameLayout(activity);
        wrappedAdView.setLayoutParams(layoutparams);
        wrappedAdView.addView(adView);
        if (d2.a(activity) <= activity.getResources().getDisplayMetrics().widthPixels)
        {
            adView.getAd();
            return;
        } else
        {
            bannerListener.onFailedToReceiveAd(this, b.b);
            return;
        }
    }

    public final volatile void requestInterstitialAd(f f, Activity activity, g g, a a1, j j)
    {
        requestInterstitialAd(f, activity, (MillennialAdapterServerParameters)g, a1, (MillennialAdapterExtras)j);
    }

    public final void requestInterstitialAd(f f, Activity activity, MillennialAdapterServerParameters millennialadapterserverparameters, a a1, MillennialAdapterExtras millennialadapterextras)
    {
        interstitialListener = f;
        Hashtable hashtable = new Hashtable();
        interstitialView = new MMInterstitial(activity);
        interstitialView.setApid(millennialadapterserverparameters.apid);
        populateAdViewParameters(interstitialView, hashtable, a1, millennialadapterextras);
        interstitialView.setListener(new InterstitialListener(null));
        interstitialView.fetch();
    }

    public final void showInterstitial()
    {
        interstitialView.display();
    }



    private class BannerListener
        implements RequestListener
    {

        final MillennialAdapter this$0;

        public void MMAdOverlayLaunched(MMAd mmad)
        {
            bannerListener.onPresentScreen(MillennialAdapter.this);
        }

        public void MMAdRequestIsCaching(MMAd mmad)
        {
        }

        public void requestCompleted(MMAd mmad)
        {
            bannerListener.onReceivedAd(MillennialAdapter.this);
        }

        public void requestFailed(MMAd mmad, MMException mmexception)
        {
            if (11 == mmexception.getCode())
            {
                bannerListener.onFailedToReceiveAd(MillennialAdapter.this, b.c);
                return;
            } else
            {
                bannerListener.onFailedToReceiveAd(MillennialAdapter.this, b.b);
                return;
            }
        }

        private BannerListener()
        {
            this$0 = MillennialAdapter.this;
            super();
        }

        BannerListener(BannerListener bannerlistener)
        {
            this();
        }
    }


    private class InterstitialListener
        implements RequestListener
    {

        final MillennialAdapter this$0;

        public void MMAdOverlayLaunched(MMAd mmad)
        {
            interstitialListener.onPresentScreen(MillennialAdapter.this);
        }

        public void MMAdRequestIsCaching(MMAd mmad)
        {
        }

        public void requestCompleted(MMAd mmad)
        {
            interstitialListener.onReceivedAd(MillennialAdapter.this);
        }

        public void requestFailed(MMAd mmad, MMException mmexception)
        {
            if (11 == mmexception.getCode())
            {
                interstitialListener.onFailedToReceiveAd(MillennialAdapter.this, b.c);
                return;
            } else
            {
                interstitialListener.onFailedToReceiveAd(MillennialAdapter.this, b.b);
                return;
            }
        }

        private InterstitialListener()
        {
            this$0 = MillennialAdapter.this;
            super();
        }

        InterstitialListener(InterstitialListener interstitiallistener)
        {
            this();
        }
    }

}
