// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;


// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAdView, NativeAdListener

class this._cls0
    implements Runnable
{

    final NativeAdView this$0;

    public void run()
    {
        NativeAdView.access$0(NativeAdView.this).impression();
    }

    r()
    {
        this$0 = NativeAdView.this;
        super();
    }
}
