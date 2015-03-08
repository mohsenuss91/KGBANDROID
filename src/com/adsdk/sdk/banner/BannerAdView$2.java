// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.banner:
//            BannerAdView

class this._cls0 extends WebViewClient
{

    final BannerAdView this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (BannerAdView.access$1(BannerAdView.this))
        {
            if (BannerAdView.access$2(BannerAdView.this).getSkipOverlay() == 1)
            {
                BannerAdView.access$3(BannerAdView.this, s);
                Log.i("TouchListener", "false");
                return true;
            } else
            {
                Log.i("TouchListener", "default");
                BannerAdView.access$4(BannerAdView.this);
                return true;
            }
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = BannerAdView.this;
        super();
    }
}
