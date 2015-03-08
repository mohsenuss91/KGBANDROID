// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.nativeads:
//            RequestNativeAd, NativeAdManager

class this._cls0
    implements Runnable
{

    final NativeAdManager this$0;

    public void run()
    {
        RequestNativeAd requestnativead;
        Log.d("ADSDK", "starting request thread");
        requestnativead = new RequestNativeAd();
        NativeAdManager.access$1(NativeAdManager.this, requestnativead.sendRequest(NativeAdManager.access$0(NativeAdManager.this)));
        if (NativeAdManager.access$2(NativeAdManager.this) == null) goto _L2; else goto _L1
_L1:
        NativeAdManager.access$3(NativeAdManager.this, NativeAdManager.access$2(NativeAdManager.this));
_L4:
        Log.d("ADSDK", "finishing request thread");
        return;
_L2:
        try
        {
            NativeAdManager.access$4(NativeAdManager.this);
        }
        catch (Throwable throwable)
        {
            NativeAdManager.access$4(NativeAdManager.this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = NativeAdManager.this;
        super();
    }
}
