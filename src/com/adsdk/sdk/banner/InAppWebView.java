// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class InAppWebView extends Activity
{

    public static final String URL_EXTRA = "extra_url";

    public InAppWebView()
    {
    }

    private void initializeWebView(Intent intent)
    {
        WebView webview = new WebView(this);
        setContentView(webview);
        WebSettings websettings = webview.getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setUseWideViewPort(true);
        webview.setWebViewClient(new _cls1());
        webview.setWebChromeClient(new _cls2());
        webview.loadUrl(intent.getStringExtra("REDIRECT_URI"));
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        initializeWebView(getIntent());
    }

    private class _cls1 extends WebViewClient
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

        _cls1()
        {
            this$0 = InAppWebView.this;
            super();
        }
    }


    private class _cls2 extends WebChromeClient
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

        _cls2()
        {
            this$0 = InAppWebView.this;
            super();
        }
    }

}
