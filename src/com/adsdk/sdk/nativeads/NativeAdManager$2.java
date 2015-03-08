// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAdManager

class this._cls0
    implements eptionHandler
{

    final NativeAdManager this$0;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Log.e("ADSDK", "Exception in request thread", throwable);
    }

    ()
    {
        this$0 = NativeAdManager.this;
        super();
    }
}
