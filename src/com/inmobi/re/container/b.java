// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.configs.Initializer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class b extends WebViewClient
{

    final IMWebView a;

    b(IMWebView imwebview)
    {
        a = imwebview;
        super();
    }

    public void onLoadResource(WebView webview, String s)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> onLoadResource:")).append(s).toString());
        String s1;
        try
        {
            if (IMWebView.a(a) != null)
            {
                IMWebView.a(a).onLoadResource(webview, s);
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Cannot load resource", exception);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        if (s.contains("/mraid.js") && !a.getUrl().equals("about:blank") && !a.getUrl().startsWith("file:"))
        {
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> onLoadResource:Hippy, Mraid ad alert!...injecting mraid and mraidview object at ")).append(webview.getUrl()).toString());
            s1 = a.getUrl();
            if (!IMWebView.d(a).contains(s1))
            {
                IMWebView.d(a).add(s1);
            }
            if (!a.mraidLoaded)
            {
                a.injectJavaScript(Initializer.getMRAIDString());
            }
            a.mraidLoaded = true;
        }
    }

    public void onPageFinished(WebView webview, String s)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> onPageFinished, url: ")).append(s).toString());
        if (IMWebView.a(a) != null)
        {
            IMWebView.a(a).onPageFinished(webview, s);
        }
        if (IMWebView.d(a).contains(s) && !a.mraidLoaded)
        {
            a.injectJavaScript(Initializer.getMRAIDString());
        }
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> Current State:")).append(IMWebView.b(a)).toString());
        if (IMWebView.b(a) != IMWebView.ViewState.LOADING)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        a.injectJavaScript("window.mraid.broadcastEvent('ready');");
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> Firing ready event at ")).append(webview).toString());
        if (a.mOriginalWebviewForExpandUrl == null)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        a.setState(IMWebView.ViewState.EXPANDED);
_L2:
        if ((!a.mIsInterstitialAd || a.mWebViewIsBrowserActivity) && a.getVisibility() == 4)
        {
            a.setVisibility(0);
        }
        if (IMWebView.e(a) != null && !IMWebView.c(a).get())
        {
            IMWebView.e(a).sendToTarget();
        }
        if (IMWebView.f(a) != null)
        {
            IMWebView.f(a).sendToTarget();
            return;
        }
        break MISSING_BLOCK_LABEL_282;
        a.setState(IMWebView.ViewState.DEFAULT);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        Log.debug("[InMobi]-[RE]-4.4.1", "Exception in onPageFinished ", exception);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        a.setState(IMWebView.ViewState.LOADING);
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> onPageStarted url: ")).append(s).append(" p ").append(a.getParent()).toString());
        if (a.getParent() == null)
        {
            IMWebView.a(a, true);
        }
        if (IMWebView.a(a) != null)
        {
            IMWebView.a(a).onPageStarted(webview, s, bitmap);
        }
        a.mraidLoaded = false;
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> error: ")).append(s).toString());
        if (IMWebView.a(a) != null)
        {
            IMWebView.a(a).onReceivedError(webview, i, s, s1);
        }
        try
        {
            if (IMWebView.b(a) == IMWebView.ViewState.LOADING && a.mListener != null && !IMWebView.c(a).get())
            {
                a.mListener.onError();
            }
            IMWebView.a(a, null);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Exception in webview loading ", exception);
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        IMWebView.a(a, sslerrorhandler, sslerror);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> shouldOverrideUrlLoading, url:")).append(s).append("webview id").append(webview).toString());
        if (!a.mWebViewIsBrowserActivity)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        if (!s.startsWith("http:") && !s.startsWith("https:"))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        a.doHidePlayers();
        return false;
        try
        {
            IMWebView.a(a, s);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Should override exception", exception);
            return false;
        }
        return true;
        IMWebView.a(a, s);
        return true;
    }
}
