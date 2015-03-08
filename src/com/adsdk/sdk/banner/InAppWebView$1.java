// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.banner:
//            InAppWebView

class this._cls0 extends WebViewClient
{

    final InAppWebView this$0;

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Toast.makeText((Activity)webview.getContext(), (new StringBuilder("MRAID error: ")).append(s).toString(), 0).show();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s == null)
        {
            return false;
        }
        String s1 = Uri.parse(s).getHost();
        if ((s.startsWith("http:") || s.startsWith("https:")) && !"play.google.com".equals(s1) && !"market.android.com".equals(s1) && !s.endsWith(".apk"))
        {
            webview.loadUrl(s);
            return true;
        }
        try
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.w("MoPub", (new StringBuilder("Unable to start activity for ")).append(s).append(". Ensure that your phone can handle this intent.").toString());
        }
        finish();
        return true;
    }

    ption()
    {
        this$0 = InAppWebView.this;
        super();
    }
}
