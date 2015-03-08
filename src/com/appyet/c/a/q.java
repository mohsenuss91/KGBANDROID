// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;

// Referenced classes of package com.appyet.c.a:
//            l

final class q extends WebViewClient
{

    final l a;
    private ApplicationContext b;
    private MainActivity c;

    public q(l l1, MainActivity mainactivity)
    {
        a = l1;
        super();
        c = mainactivity;
        b = (ApplicationContext)c.getApplicationContext();
    }

    public final void onPageFinished(WebView webview, String s)
    {
        l.f(a).setVisibility(8);
        super.onPageFinished(webview, s);
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        Toast.makeText(b, s, 1).show();
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        return super.shouldInterceptRequest(webview, s);
        WebResourceResponse webresourceresponse = super.shouldInterceptRequest(webview, s);
        return webresourceresponse;
        Exception exception;
        exception;
        return super.shouldInterceptRequest(webview, s);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            c.startActivity(intent);
        }
        catch (Exception exception)
        {
            d.a(exception);
            return false;
        }
        return true;
    }
}
