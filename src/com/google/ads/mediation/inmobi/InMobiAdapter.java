// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.inmobi;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
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
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.GenderType;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMInterstitial;
import java.util.Calendar;
import java.util.HashMap;

// Referenced classes of package com.google.ads.mediation.inmobi:
//            InMobiAdapterExtras, InMobiAdapterServerParameters

public final class InMobiAdapter
    implements c, e
{

    private static int $SWITCH_TABLE$com$google$ads$AdRequest$Gender[];
    private static final d ADSIZE_INMOBI_AD_UNIT_120X600 = new d(120, 600);
    private static final d ADSIZE_INMOBI_AD_UNIT_300X250 = new d(300, 250);
    private static final d ADSIZE_INMOBI_AD_UNIT_320X48 = new d(320, 48);
    private static final d ADSIZE_INMOBI_AD_UNIT_320X50 = new d(320, 50);
    private static final d ADSIZE_INMOBI_AD_UNIT_468X60 = new d(468, 60);
    private static final d ADSIZE_INMOBI_AD_UNIT_728X90 = new d(728, 90);
    private static Boolean disableHardwareFlag = Boolean.valueOf(false);
    private static Boolean isAppInitialize = Boolean.valueOf(false);
    private IMInterstitial adInterstitial;
    private IMBanner adView;
    private com.google.ads.mediation.d bannerListener;
    private f interstitialListener;
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

    public InMobiAdapter()
    {
    }

    private void buildAdRequest(a a1, InMobiAdapterExtras inmobiadapterextras)
    {
        if (inmobiadapterextras == null)
        {
            inmobiadapterextras = new InMobiAdapterExtras();
        }
        if (inmobiadapterextras.getAreaCode() != null)
        {
            InMobi.setAreaCode(inmobiadapterextras.getAreaCode());
        }
        if (a1.d() != null)
        {
            InMobi.setLocationInquiryAllowed(true);
            InMobi.setCurrentLocation(a1.d());
        }
        if (a1.a() != null)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(a1.a());
            InMobi.setDateOfBirth(calendar);
        }
        if (inmobiadapterextras.getEducation() != null)
        {
            InMobi.setEducation(inmobiadapterextras.getEducation());
        }
        if (inmobiadapterextras.getEthnicity() != null)
        {
            InMobi.setEthnicity(inmobiadapterextras.getEthnicity());
        }
        if (a1.b() == null) goto _L2; else goto _L1
_L1:
        $SWITCH_TABLE$com$google$ads$AdRequest$Gender()[a1.b().ordinal()];
        JVM INSTR tableswitch 2 3: default 136
    //                   2 292
    //                   3 301;
           goto _L3 _L4 _L5
_L3:
        InMobi.setGender(GenderType.UNKNOWN);
_L2:
        if (inmobiadapterextras.getIncome() != null)
        {
            InMobi.setIncome(inmobiadapterextras.getIncome().intValue());
        }
        if (inmobiadapterextras.getInterests() != null)
        {
            InMobi.setInterests(TextUtils.join(", ", inmobiadapterextras.getInterests()));
        }
        if (inmobiadapterextras.getPostalCode() != null)
        {
            InMobi.setPostalCode(inmobiadapterextras.getPostalCode());
        }
        InMobi.setDeviceIDMask(inmobiadapterextras.getDeviceIdMask());
        if (inmobiadapterextras.getSexualOrientations() != null)
        {
            InMobi.setSexualOrientation(inmobiadapterextras.getSexualOrientations());
        }
        if (inmobiadapterextras.getMartialStatus() != null)
        {
            InMobi.setMaritalStatus(inmobiadapterextras.getMartialStatus());
        }
        if (inmobiadapterextras.getLangauge() != null)
        {
            InMobi.setLanguage(inmobiadapterextras.getLangauge());
        }
        if (inmobiadapterextras.getHasChildren() != null)
        {
            InMobi.setHasChildren(inmobiadapterextras.getHasChildren());
        }
        if (inmobiadapterextras.getCity() != null && inmobiadapterextras.getState() != null && inmobiadapterextras.getCountry() != null)
        {
            InMobi.setLocationWithCityStateCountry(inmobiadapterextras.getCity(), inmobiadapterextras.getState(), inmobiadapterextras.getCountry());
        }
        return;
_L4:
        InMobi.setGender(GenderType.MALE);
        continue; /* Loop/switch isn't completed */
_L5:
        InMobi.setGender(GenderType.FEMALE);
        if (true) goto _L2; else goto _L6
_L6:
    }

    public static void disableHardwareAcceleration()
    {
        disableHardwareFlag = Boolean.valueOf(true);
    }

    public final void destroy()
    {
    }

    public final Class getAdditionalParametersType()
    {
        return com/google/ads/mediation/inmobi/InMobiAdapterExtras;
    }

    public final View getBannerView()
    {
        return wrappedAdView;
    }

    public final Class getServerParametersType()
    {
        return com/google/ads/mediation/inmobi/InMobiAdapterServerParameters;
    }

    public final volatile void requestBannerAd(com.google.ads.mediation.d d1, Activity activity, g g, d d2, a a1, j j)
    {
        requestBannerAd(d1, activity, (InMobiAdapterServerParameters)g, d2, a1, (InMobiAdapterExtras)j);
    }

    public final void requestBannerAd(com.google.ads.mediation.d d1, Activity activity, InMobiAdapterServerParameters inmobiadapterserverparameters, d d2, a a1, InMobiAdapterExtras inmobiadapterextras)
    {
        byte byte0 = 12;
        if (!isAppInitialize.booleanValue())
        {
            InMobi.initialize(activity, inmobiadapterserverparameters.appId);
            isAppInitialize = Boolean.valueOf(true);
        }
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            d1.onFailedToReceiveAd(this, b.a);
            return;
        }
        if (!InMobi.getVersion().substring(0, 1).equals("4"))
        {
            d1.onFailedToReceiveAd(this, b.a);
            Log.e("Invalid SDK VERSION", (new StringBuilder("Please integrate with new sdk")).append(InMobi.getVersion()).toString());
            return;
        }
        bannerListener = d1;
        d ad[] = new d[6];
        ad[0] = ADSIZE_INMOBI_AD_UNIT_320X48;
        ad[1] = ADSIZE_INMOBI_AD_UNIT_320X50;
        ad[2] = ADSIZE_INMOBI_AD_UNIT_468X60;
        ad[3] = ADSIZE_INMOBI_AD_UNIT_728X90;
        ad[4] = ADSIZE_INMOBI_AD_UNIT_300X250;
        ad[5] = ADSIZE_INMOBI_AD_UNIT_120X600;
        d d3 = d2.a(ad);
        android.widget.FrameLayout.LayoutParams layoutparams;
        HashMap hashmap;
        if (d3 == ADSIZE_INMOBI_AD_UNIT_320X48)
        {
            byte0 = 9;
        } else
        if (d3 == ADSIZE_INMOBI_AD_UNIT_320X50)
        {
            byte0 = 15;
        } else
        if (d3 == ADSIZE_INMOBI_AD_UNIT_468X60)
        {
            Log.e("ADSIZE_INMOBI_AD_UNIT_468x60", (new StringBuilder(String.valueOf(byte0))).toString());
        } else
        if (d3 == ADSIZE_INMOBI_AD_UNIT_728X90)
        {
            Log.e("INMOBI_AD_UNIT_728X90", (new StringBuilder(String.valueOf(11))).toString());
            byte0 = 11;
        } else
        if (d3 == ADSIZE_INMOBI_AD_UNIT_300X250)
        {
            Log.e("INMOBI_AD_UNIT_300X250", (new StringBuilder(String.valueOf(10))).toString());
            byte0 = 10;
        } else
        if (d3 == ADSIZE_INMOBI_AD_UNIT_120X600)
        {
            byte0 = 13;
            Log.e("INMOBI_AD_UNIT_120X600", (new StringBuilder(String.valueOf(13))).toString());
        } else
        {
            d1.onFailedToReceiveAd(this, b.a);
            return;
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(d3.a(activity), d3.b(activity));
        adView = new IMBanner(activity, inmobiadapterserverparameters.appId, byte0);
        adView.setRefreshInterval(-1);
        adView.setAnimationType(AnimationType.ANIMATION_OFF);
        if (a1.c() != null)
        {
            adView.setKeywords(TextUtils.join(", ", a1.c()));
        }
        hashmap = new HashMap();
        hashmap.put("tp", "c_admob");
        hashmap.put("tp-ver", "6.2.1");
        adView.setRequestParams(hashmap);
        if (inmobiadapterextras == null)
        {
            inmobiadapterextras = new InMobiAdapterExtras();
        }
        if (inmobiadapterextras.getRefTagKey() != null && inmobiadapterextras.getRefTagValue() != null && !inmobiadapterextras.getRefTagKey().trim().equals("") && !inmobiadapterextras.getRefTagValue().trim().equals(""))
        {
            adView.setRefTagParam(inmobiadapterextras.getRefTagKey(), inmobiadapterextras.getRefTagValue());
        }
        adView.setIMBannerListener(new BannerListener(null));
        if (disableHardwareFlag.booleanValue())
        {
            adView.disableHardwareAcceleration();
        }
        wrappedAdView = new FrameLayout(activity);
        wrappedAdView.setLayoutParams(layoutparams);
        wrappedAdView.addView(adView);
        buildAdRequest(a1, inmobiadapterextras);
        adView.loadBanner();
    }

    public final volatile void requestInterstitialAd(f f1, Activity activity, g g, a a1, j j)
    {
        requestInterstitialAd(f1, activity, (InMobiAdapterServerParameters)g, a1, (InMobiAdapterExtras)j);
    }

    public final void requestInterstitialAd(f f1, Activity activity, InMobiAdapterServerParameters inmobiadapterserverparameters, a a1, InMobiAdapterExtras inmobiadapterextras)
    {
        if (!isAppInitialize.booleanValue())
        {
            InMobi.initialize(activity, inmobiadapterserverparameters.appId);
            isAppInitialize = Boolean.valueOf(true);
        }
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            f1.onFailedToReceiveAd(this, b.a);
            return;
        }
        if (!InMobi.getVersion().substring(0, 1).equals("4"))
        {
            f1.onFailedToReceiveAd(this, b.a);
            Log.e("Invalid SDK VERSION", (new StringBuilder("Please integrate with new sdk")).append(InMobi.getVersion()).toString());
            return;
        }
        interstitialListener = f1;
        adInterstitial = new IMInterstitial(activity, inmobiadapterserverparameters.appId);
        if (a1.c() != null)
        {
            adInterstitial.setKeywords(TextUtils.join(", ", a1.c()));
        }
        HashMap hashmap = new HashMap();
        hashmap.put("tp", "c_admob");
        hashmap.put("tp-ver", "6.2.1");
        adInterstitial.setRequestParams(hashmap);
        adInterstitial.setIMInterstitialListener(new InterstitialListener(null));
        if (disableHardwareFlag.booleanValue())
        {
            adInterstitial.disableHardwareAcceleration();
        }
        buildAdRequest(a1, inmobiadapterextras);
        adInterstitial.loadInterstitial();
    }

    public final void showInterstitial()
    {
        if (adInterstitial.getState() == com.inmobi.monetization.IMInterstitial.State.READY)
        {
            adInterstitial.show();
        }
    }




    private class BannerListener
        implements IMBannerListener
    {

        private static int $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode[];
        final InMobiAdapter this$0;

        static int[] $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode()
        {
            int ai[] = $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode;
            if (ai != null)
            {
                return ai;
            }
            int ai1[] = new int[IMErrorCode.values().length];
            try
            {
                ai1[IMErrorCode.DO_MONETIZE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                ai1[IMErrorCode.DO_NOTHING.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai1[IMErrorCode.INTERNAL_ERROR.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai1[IMErrorCode.INVALID_REQUEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai1[IMErrorCode.NETWORK_ERROR.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai1[IMErrorCode.NO_FILL.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode = ai1;
            return ai1;
        }

        public void onBannerInteraction(IMBanner imbanner, Map map)
        {
            Log.d("onBannerInteraction", "onBannerInteraction called");
            bannerListener.onClick(InMobiAdapter.this);
        }

        public void onBannerRequestFailed(IMBanner imbanner, IMErrorCode imerrorcode)
        {
            switch ($SWITCH_TABLE$com$inmobi$monetization$IMErrorCode()[imerrorcode.ordinal()])
            {
            case 4: // '\004'
            case 5: // '\005'
            default:
                bannerListener.onFailedToReceiveAd(InMobiAdapter.this, b.a);
                return;

            case 2: // '\002'
                bannerListener.onFailedToReceiveAd(InMobiAdapter.this, b.d);
                return;

            case 1: // '\001'
                bannerListener.onFailedToReceiveAd(InMobiAdapter.this, b.a);
                return;

            case 6: // '\006'
                bannerListener.onFailedToReceiveAd(InMobiAdapter.this, b.c);
                return;

            case 3: // '\003'
                bannerListener.onFailedToReceiveAd(InMobiAdapter.this, b.b);
                return;
            }
        }

        public void onBannerRequestSucceeded(IMBanner imbanner)
        {
            bannerListener.onReceivedAd(InMobiAdapter.this);
        }

        public void onDismissBannerScreen(IMBanner imbanner)
        {
            bannerListener.onDismissScreen(InMobiAdapter.this);
        }

        public void onLeaveApplication(IMBanner imbanner)
        {
            bannerListener.onLeaveApplication(InMobiAdapter.this);
        }

        public void onShowBannerScreen(IMBanner imbanner)
        {
            bannerListener.onPresentScreen(InMobiAdapter.this);
        }

        private BannerListener()
        {
            this$0 = InMobiAdapter.this;
            super();
        }

        BannerListener(BannerListener bannerlistener)
        {
            this();
        }
    }


    private class InterstitialListener
        implements IMInterstitialListener
    {

        private static int $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode[];
        final InMobiAdapter this$0;

        static int[] $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode()
        {
            int ai[] = $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode;
            if (ai != null)
            {
                return ai;
            }
            int ai1[] = new int[IMErrorCode.values().length];
            try
            {
                ai1[IMErrorCode.DO_MONETIZE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                ai1[IMErrorCode.DO_NOTHING.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai1[IMErrorCode.INTERNAL_ERROR.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai1[IMErrorCode.INVALID_REQUEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai1[IMErrorCode.NETWORK_ERROR.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai1[IMErrorCode.NO_FILL.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            $SWITCH_TABLE$com$inmobi$monetization$IMErrorCode = ai1;
            return ai1;
        }

        public void onDismissInterstitialScreen(IMInterstitial iminterstitial)
        {
            interstitialListener.onDismissScreen(InMobiAdapter.this);
        }

        public void onInterstitialFailed(IMInterstitial iminterstitial, IMErrorCode imerrorcode)
        {
            switch ($SWITCH_TABLE$com$inmobi$monetization$IMErrorCode()[imerrorcode.ordinal()])
            {
            case 4: // '\004'
            case 5: // '\005'
            default:
                interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, b.a);
                return;

            case 2: // '\002'
                interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, b.d);
                return;

            case 1: // '\001'
                interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, b.a);
                return;

            case 6: // '\006'
                interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, b.c);
                return;

            case 3: // '\003'
                interstitialListener.onFailedToReceiveAd(InMobiAdapter.this, b.b);
                return;
            }
        }

        public void onInterstitialInteraction(IMInterstitial iminterstitial, Map map)
        {
            Log.d("onInterstitialInteraction", "onInterstitialInteraction called");
        }

        public void onInterstitialLoaded(IMInterstitial iminterstitial)
        {
            interstitialListener.onReceivedAd(InMobiAdapter.this);
        }

        public void onLeaveApplication(IMInterstitial iminterstitial)
        {
            interstitialListener.onLeaveApplication(InMobiAdapter.this);
        }

        public void onShowInterstitialScreen(IMInterstitial iminterstitial)
        {
            interstitialListener.onPresentScreen(InMobiAdapter.this);
        }

        private InterstitialListener()
        {
            this$0 = InMobiAdapter.this;
            super();
        }

        InterstitialListener(InterstitialListener interstitiallistener)
        {
            this();
        }
    }

}
