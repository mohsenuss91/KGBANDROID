// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NativeConfigParams;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.abstraction.INativeAdController;
import com.inmobi.monetization.internal.abstraction.INativeAdListener;
import com.inmobi.monetization.internal.objects.NativeAdsCache;

// Referenced classes of package com.inmobi.monetization.internal:
//            ServiceProvider, NativeAdRequest, NativeAdResponse

public class NativeAdsController
    implements INativeAdController
{

    private static NativeAdsController d = null;
    private ServiceProvider a;
    private INativeAdListener b;
    private boolean c;

    private NativeAdsController()
    {
        c = false;
        a = ServiceProvider.getInstance();
    }

    private void a(String s, NativeAdRequest nativeadrequest)
    {
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
            Log.internal("[InMobi]-[Monetization]", "Fetching Native Ads");
            a.getNativeAd(nativeadrequest, this);
            return;
        } else
        {
            onAdRequestFailed(nativeadrequest, IMErrorCode.NETWORK_ERROR);
            return;
        }
    }

    public static NativeAdsController getInstance()
    {
        if (d == null)
        {
            d = new NativeAdsController();
        }
        return d;
    }

    public void getAd(String s, NativeAdRequest nativeadrequest, INativeAdListener inativeadlistener)
    {
        com.inmobi.monetization.IMNative imnative;
        int i;
        int j;
        c = false;
        b = inativeadlistener;
        imnative = NativeAdsCache.getInstance().getCachedAd(s);
        i = NativeAdsCache.getInstance().getNumCachedAds(s);
        j = Initializer.getConfigParams().getNativeSdkConfigParams().getmMinLimit();
        if (imnative != null) goto _L2; else goto _L1
_L1:
        a(s, nativeadrequest);
_L4:
        return;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        c = true;
        a(s, nativeadrequest);
        if (b != null)
        {
            b.onNativeRequestSucceeded(imnative);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        c = true;
        if (b != null)
        {
            b.onNativeRequestSucceeded(imnative);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void onAdRequestFailed(NativeAdRequest nativeadrequest, IMErrorCode imerrorcode)
    {
        Log.debug("[InMobi]-[Monetization]", "Native ad failed: ");
        if (!c && b != null)
        {
            c = true;
            b.onNativeRequestFailed(imerrorcode);
        }
    }

    public void onAdRequestSucceded(NativeAdRequest nativeadrequest, NativeAdResponse nativeadresponse)
    {
label0:
        {
            Log.debug("[InMobi]-[Monetization]", "Native ad received: ");
            NativeAdsCache.getInstance().saveNativeAds(nativeadrequest.getAppId(), nativeadresponse.a());
            if (!c && b != null)
            {
                c = true;
                com.inmobi.monetization.IMNative imnative = NativeAdsCache.getInstance().getCachedAd(nativeadrequest.getAppId());
                if (imnative == null)
                {
                    break label0;
                }
                b.onNativeRequestSucceeded(imnative);
            }
            return;
        }
        b.onNativeRequestFailed(IMErrorCode.INTERNAL_ERROR);
    }

}
