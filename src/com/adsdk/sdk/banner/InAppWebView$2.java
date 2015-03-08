// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.adsdk.sdk.banner:
//            InAppWebView

class > extends WebChromeClient
{

    final InAppWebView this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        Activity activity = (Activity)webview.getContext();
        activity.setTitle("Loading...");
        activity.setProgress(i * 100);
        if (i == 100)
        {
            activity.setTitle(webview.getUrl());
        }
    }

    ()
    {
        this$0 = InAppWebView.this;
        super();
    }
}
