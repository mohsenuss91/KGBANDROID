// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMCommand, HttpRedirection

abstract class MMWebViewClient extends WebViewClient
{

    private ExecutorService cachedExecutor;
    boolean isLastMMCommandResize;
    MMWebViewClientListener mmWebViewClientListener;
    HttpRedirection.RedirectionListenerImpl redirectListenerImpl;

    MMWebViewClient(MMWebViewClientListener mmwebviewclientlistener, HttpRedirection.RedirectionListenerImpl redirectionlistenerimpl)
    {
        cachedExecutor = Executors.newCachedThreadPool();
        mmWebViewClientListener = mmwebviewclientlistener;
        redirectListenerImpl = redirectionlistenerimpl;
    }

    public void onPageFinished(WebView webview, String s)
    {
        MMWebView mmwebview = (MMWebView)webview;
        if (!mmwebview.isOriginalUrl(s))
        {
            mmWebViewClientListener.onPageFinished(s);
            MMSDK.Log.d((new StringBuilder("onPageFinished webview: ")).append(mmwebview.toString()).append("url is ").append(s).toString());
            mmwebview.setAdProperties(redirectListenerImpl.getAdProperties());
            setMraidState(mmwebview);
        }
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        MMSDK.Log.d("onPageStarted: %s", new Object[] {
            s
        });
        mmWebViewClientListener.onPageStarted(s);
        MMWebView mmwebview = (MMWebView)webview;
        mmwebview.mraidState = "loading";
        mmwebview.requiresPreAdSizeFix = false;
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Object aobj[] = new Object[3];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = s;
        aobj[2] = s1;
        MMSDK.Log.e("Error: %s %s %s", aobj);
    }

    abstract void setMraidState(MMWebView mmwebview);

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        MMWebView mmwebview = (MMWebView)webview;
        if (!mmwebview.isOriginalUrl(s))
        {
            MMSDK.Log.v((new StringBuilder("@@@@@@@@@@SHOULDOVERRIDELOADING@@@@@@@@@@@@@ Url is ")).append(s).append(" for ").append(webview).toString());
            if (s.substring(0, 6).equalsIgnoreCase("mmsdk:"))
            {
                MMSDK.Log.v((new StringBuilder("Running JS bridge command: ")).append(s).toString());
                MMCommand mmcommand = new MMCommand((MMWebView)webview, s);
                isLastMMCommandResize = mmcommand.isResizeCommand();
                cachedExecutor.execute(mmcommand);
                return true;
            }
            if (redirectListenerImpl.isExpandingToUrl())
            {
                return false;
            }
            redirectListenerImpl.url = s;
            redirectListenerImpl.weakContext = new WeakReference(webview.getContext());
            redirectListenerImpl.creatorAdImplInternalId = mmwebview.creatorAdImplId;
            HttpRedirection.startActivityFromUri(redirectListenerImpl);
        }
        return true;
    }

    private class MMWebViewClientListener
    {

        void onPageFinished(String s)
        {
        }

        void onPageStarted(String s)
        {
        }

        MMWebViewClientListener()
        {
        }
    }

}
