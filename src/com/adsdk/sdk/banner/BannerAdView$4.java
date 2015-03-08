// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.banner:
//            BannerAdView

class this._cls0
    implements Runnable
{

    final BannerAdView this$0;

    public void run()
    {
        if (BannerAdView.access$5(BannerAdView.this) != null)
        {
            Log.d("ADSDK", (new StringBuilder("notify bannerListener of ad clicked: ")).append(BannerAdView.access$5(BannerAdView.this).getClass().getName()).toString());
            BannerAdView.access$5(BannerAdView.this).adClicked();
        }
    }

    ()
    {
        this$0 = BannerAdView.this;
        super();
    }
}
