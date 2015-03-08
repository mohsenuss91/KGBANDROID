// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;


// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAdManager, NativeAdListener, NativeAd

class val.ad
    implements Runnable
{

    final NativeAdManager this$0;
    private final NativeAd val$ad;

    public void run()
    {
        NativeAdManager.access$7(NativeAdManager.this).adLoaded(val$ad);
    }

    ()
    {
        this$0 = final_nativeadmanager;
        val$ad = NativeAd.this;
        super();
    }
}
