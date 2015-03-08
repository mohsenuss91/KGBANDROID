// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.appyet.d.d;
import com.appyet.manager.ar;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.appyet.activity:
//            DisqusCommentActivity

final class h extends WebViewClient
{

    final DisqusCommentActivity a;

    h(DisqusCommentActivity disquscommentactivity)
    {
        a = disquscommentactivity;
        super();
    }

    public final void doUpdateVisitedHistory(WebView webview, String s, boolean flag)
    {
        if (s.startsWith("https://www.surveymonkey.com"))
        {
            return;
        } else
        {
            super.doUpdateVisitedHistory(webview, s, flag);
            return;
        }
    }

    public final void onLoadResource(WebView webview, String s)
    {
        if (s.contains("&per_page"))
        {
            webview.pageUp(true);
        }
    }

    public final void onPageFinished(WebView webview, String s)
    {
        if (!a.b)
        {
            a.a = true;
        }
        if (a.a && !a.b)
        {
            a.supportInvalidateOptionsMenu();
        } else
        {
            a.b = false;
        }
        if (s.startsWith("http://comment"))
        {
            com.appyet.activity.DisqusCommentActivity.d(a).clearHistory();
        } else
        {
            if (s.startsWith("http://disqus.com/logout"))
            {
                CookieManager.getInstance().removeAllCookie();
                DisqusCommentActivity.b(a);
                com.appyet.activity.DisqusCommentActivity.d(a).clearHistory();
                return;
            }
            if (s.startsWith("http://disqus.com/next/login-success/") || s.startsWith("http://disqus.com/_ax/twitter/complete/"))
            {
                DisqusCommentActivity.b(a);
                com.appyet.activity.DisqusCommentActivity.d(a).clearHistory();
                return;
            }
        }
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        a.a = false;
        a.supportInvalidateOptionsMenu();
        if (!s.equals("http://base/"))
        {
            if (s.startsWith("http://comment"))
            {
                DisqusCommentActivity.b(a);
                return;
            }
            if (s.startsWith("http://disqus.com/_ax/google/complete/") || s.startsWith("http://disqus.com/_ax/facebook/complete/"))
            {
                super.onPageStarted(webview, s, bitmap);
                return;
            }
        }
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Toast.makeText(a, s, 0).show();
    }

    public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.proceed();
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (!a.a)
        {
            a.b = true;
        }
        a.a = false;
        if (s.startsWith("http://base/#comment"))
        {
            return true;
        }
        if (!s.startsWith("comment:"))
        {
            break MISSING_BLOCK_LABEL_62;
        }
        DisqusCommentActivity.b(a);
        Exception exception;
        return true;
        if (s.endsWith("simple-loading.html"))
        {
            break MISSING_BLOCK_LABEL_248;
        }
        if (!s.endsWith("/latest.rss"))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        a.startActivity(intent);
        return true;
        if (!s.contains("//redirect.disqus.com") && !s.startsWith("https://www.facebook.com/sharer.php") && !s.startsWith("https://twitter.com/intent/tweet?url=") && !s.equals("http://disqus.com/") && !s.equals("http://disqus.com/account/") && !s.startsWith("http://docs.disqus.com/kb"))
        {
            break MISSING_BLOCK_LABEL_212;
        }
        if (s.startsWith("//"))
        {
            s = (new StringBuilder("http:")).append(s).toString();
        }
        Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(s));
        a.startActivity(intent1);
        return true;
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", ar.c(DisqusCommentActivity.c(a)));
            webview.loadUrl(s, hashmap);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            d.a(exception);
            return true;
        }
        return true;
    }
}
