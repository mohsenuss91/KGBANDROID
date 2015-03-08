// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.v;
import com.appyet.manager.af;
import com.appyet.manager.ar;
import com.appyet.manager.bp;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.appyet.activity:
//            WebBrowserActivity, WebActionActivity

final class ao extends WebViewClient
{

    final WebBrowserActivity a;

    ao(WebBrowserActivity webbrowseractivity)
    {
        a = webbrowseractivity;
        super();
    }

    private void a(WebView webview)
    {
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", ar.c(WebBrowserActivity.b(a)));
            webview.loadUrl(WebBrowserActivity.c(a), hashmap);
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
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
        if (s.startsWith("http://disqus.com/logout"))
        {
            CookieManager.getInstance().removeAllCookie();
            a(webview);
            com.appyet.activity.WebBrowserActivity.d(a).clearHistory();
        } else
        if (s.startsWith("http://disqus.com/next/login-success/") || s.startsWith("http://disqus.com/_ax/twitter/complete/"))
        {
            a(webview);
            com.appyet.activity.WebBrowserActivity.d(a).clearHistory();
            return;
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
                a(webview);
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
        if (s.endsWith("simple-loading.html"))
        {
            return true;
        }
        if (s.endsWith("/latest.rss"))
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            a.startActivity(intent);
            return true;
        }
        if (s.contains("//redirect.disqus.com") || s.startsWith("https://www.facebook.com/sharer.php") || s.startsWith("https://twitter.com/intent/tweet?url=") || s.equals("http://disqus.com/") || s.equals("http://disqus.com/account/") || s.startsWith("http://docs.disqus.com/kb"))
        {
            if (s.startsWith("//"))
            {
                s = (new StringBuilder("http:")).append(s).toString();
            }
            Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(s));
            a.startActivity(intent1);
            return true;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.startsWith("market://")) goto _L2; else goto _L3
_L3:
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(s));
        a.startActivity(intent3);
        return true;
        Exception exception;
        exception;
        d.a(exception);
_L5:
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", ar.c(WebBrowserActivity.b(a)));
            webview.loadUrl(s, hashmap);
        }
        catch (Exception exception1)
        {
            d.a(exception1);
            return true;
        }
        return true;
_L2:
        if (!s.startsWith("http://")) goto _L5; else goto _L4
_L4:
        String s1 = v.a(s);
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s1.contains("video") && !s1.contains("audio") && !s1.contains("image"))
        {
            continue; /* Loop/switch isn't completed */
        }
        Intent intent2 = new Intent(a, com/appyet/activity/WebActionActivity);
        intent2.putExtra("URL", s);
        a.startActivity(intent2);
        return true;
        if (s1 == null) goto _L5; else goto _L6
_L6:
        if (!s1.contains("application") || android.os.Build.VERSION.SDK_INT < 9) goto _L5; else goto _L7
_L7:
        DownloadManager downloadmanager;
        android.app.DownloadManager.Request request;
        String s2;
        WebBrowserActivity.b(a).l.a();
        downloadmanager = (DownloadManager)a.getSystemService("download");
        request = new android.app.DownloadManager.Request(Uri.parse(s));
        s2 = WebBrowserActivity.b(a).l.d(s);
        request.setDestinationUri(WebBrowserActivity.b(a).l.b(s2));
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L9; else goto _L8
_L8:
        request.setNotificationVisibility(1);
_L10:
        if (!WebBrowserActivity.b(a).d.s())
        {
            break MISSING_BLOCK_LABEL_535;
        }
        request.setAllowedNetworkTypes(2);
_L11:
        request.setAllowedOverRoaming(false);
        request.setTitle(s2);
        request.setDescription(s);
        downloadmanager.enqueue(request);
        return true;
_L9:
        request.setShowRunningNotification(true);
          goto _L10
        request.setAllowedNetworkTypes(3);
          goto _L11
    }
}
