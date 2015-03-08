// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;


// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAdManager, NativeAdListener

class this._cls0
    implements Runnable
{

    final NativeAdManager this$0;

    public void run()
    {
        NativeAdManager.access$7(NativeAdManager.this).adFailedToLoad();
    }

    ()
    {
        this$0 = NativeAdManager.this;
        super();
    }
}
