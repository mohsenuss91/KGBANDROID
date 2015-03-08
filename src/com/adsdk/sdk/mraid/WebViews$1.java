// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class  extends WebChromeClient
{

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        Log.d("MoPub - WebViewsUtil", s1);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        Log.d("MoPub - WebViewsUtil", s1);
        return true;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        Log.d("MoPub - WebViewsUtil", s1);
        return true;
    }

    public boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        Log.d("MoPub - WebViewsUtil", s1);
        return true;
    }

    ()
    {
    }
}
