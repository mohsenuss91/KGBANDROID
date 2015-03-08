// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.appyet.activity.MediaPlayerActivity;
import com.appyet.activity.VideoPlayerActivity;
import com.appyet.activity.WebActionActivity;
import com.appyet.activity.WebBrowserActivity;
import com.appyet.activity.YouTubePlayerActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.Web;
import com.appyet.f.v;
import com.appyet.manager.af;
import com.appyet.manager.ar;
import com.appyet.manager.as;
import com.appyet.manager.bp;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.appyet.c:
//            be

final class bi extends WebViewClient
{

    final be a;

    bi(be be1)
    {
        a = be1;
        super();
    }

    private void a(WebView webview)
    {
        if (com.appyet.c.be.d(a).getType().equals("Link"))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", ar.c(be.b(a)));
            webview.loadUrl(com.appyet.c.be.d(a).getData(), hashmap);
            return;
        }
        try
        {
            webview.loadDataWithBaseURL(be.e(a), com.appyet.c.be.d(a).getData(), "text/html", "UTF-8", "");
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        return;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        if (!a.b)
        {
            a.a = true;
        }
        if (a.a && !a.b)
        {
            if (a.getSherlockActivity() != null)
            {
                a.getSherlockActivity().supportInvalidateOptionsMenu();
            }
        } else
        {
            a.b = false;
        }
        if (s.startsWith("http://disqus.com/logout"))
        {
            CookieManager.getInstance().removeAllCookie();
            a(webview);
            be.f(a).clearHistory();
        } else
        if (s.startsWith("http://disqus.com/next/login-success/") || s.startsWith("http://disqus.com/_ax/twitter/complete/"))
        {
            a(webview);
            be.f(a).clearHistory();
            return;
        }
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        a.a = false;
        if (a.getSherlockActivity() != null)
        {
            a.getSherlockActivity().supportInvalidateOptionsMenu();
        }
        if (!s.equals("http://APPYET_BASE"))
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
        Toast.makeText(be.b(a), s, 0).show();
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
        if (s == null)
        {
            return false;
        }
        if (be.c(a) != null && be.c(a).equals(s))
        {
            return true;
        }
        be.a(a, s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        if (!s.startsWith("market://"))
        {
            break MISSING_BLOCK_LABEL_256;
        }
        Intent intent13 = new Intent("android.intent.action.VIEW", Uri.parse(s));
        a.startActivity(intent13);
        return true;
        if (!s.startsWith("appyet.youtube:"))
        {
            break MISSING_BLOCK_LABEL_314;
        }
        Intent intent12 = new Intent(a.getSherlockActivity(), com/appyet/activity/YouTubePlayerActivity);
        intent12.setData(Uri.parse(s));
        a.getSherlockActivity().startActivity(intent12);
        return true;
        Exception exception;
        exception;
        d.a(exception);
        String s5;
        if (!s.startsWith("appyet.video:"))
        {
            break MISSING_BLOCK_LABEL_392;
        }
        s5 = s.replace("appyet.video:", "");
        Intent intent11 = new Intent(be.b(a), com/appyet/activity/VideoPlayerActivity);
        intent11.putExtra("URL", s5);
        be.b(a).startActivity(intent11);
_L2:
        return true;
        Exception exception11;
        exception11;
        d.a(exception11);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception3;
        exception3;
        d.a(exception3);
        String s4;
        if (!s.startsWith("appyet.audio:"))
        {
            break MISSING_BLOCK_LABEL_489;
        }
        s4 = s.replace("appyet.audio:", "");
        be.b(a).c.a(s4, s4);
        be.b(a).c.a(false);
        Intent intent10 = new Intent(a.getSherlockActivity(), com/appyet/activity/MediaPlayerActivity);
        a.startActivity(intent10);
_L4:
        return true;
        Exception exception10;
        exception10;
        d.a(exception10);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception4;
        exception4;
        d.a(exception4);
        if (!s.startsWith("http://APPYET_BASE"))
        {
            break MISSING_BLOCK_LABEL_555;
        }
        Intent intent9 = new Intent(a.getSherlockActivity(), com/appyet/activity/WebBrowserActivity);
        intent9.putExtra("URL", s.replace("http://APPYET_BASE", "http://"));
        a.getSherlockActivity().startActivity(intent9);
        return true;
        Exception exception5;
        exception5;
        d.a(exception5);
        if (!s.startsWith("wtai://wp/") || !s.startsWith("wtai://wp/mc;"))
        {
            break MISSING_BLOCK_LABEL_634;
        }
        Intent intent8 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("tel:")).append(s.substring(13)).toString()));
        be.b(a).startActivity(intent8);
        return true;
        Exception exception6;
        exception6;
        d.a(exception6);
        return false;
        if (!s.startsWith("tel:"))
        {
            break MISSING_BLOCK_LABEL_680;
        }
        Intent intent3 = new Intent("android.intent.action.DIAL", Uri.parse(s));
        a.startActivity(intent3);
        return true;
        Exception exception7;
        exception7;
        d.a(exception7);
        return false;
        if (s.startsWith("about:"))
        {
            return false;
        }
        boolean flag = a.b;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_751;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("Accept-Language", ar.c(be.b(a)));
        webview.loadUrl(s, hashmap);
        return true;
        Exception exception9;
        exception9;
        d.a(exception9);
        if (!s.startsWith("http://") && !s.startsWith("https://")) goto _L6; else goto _L5
_L5:
        String s1 = v.a(s);
        if (s1 == null) goto _L8; else goto _L7
_L7:
        if (!s1.contains("video") && !s1.contains("audio") && !s1.contains("image")) goto _L8; else goto _L9
_L9:
        Intent intent4 = new Intent(a.getSherlockActivity(), com/appyet/activity/WebActionActivity);
        intent4.putExtra("URL", s);
        a.getSherlockActivity().startActivity(intent4);
          goto _L10
_L8:
        if (s1 == null) goto _L12; else goto _L11
_L11:
        if (!s1.contains("application") || android.os.Build.VERSION.SDK_INT < 9) goto _L12; else goto _L13
_L13:
        DownloadManager downloadmanager;
        android.app.DownloadManager.Request request;
        String s2;
        be.b(a).l.a();
        downloadmanager = (DownloadManager)a.getSherlockActivity().getSystemService("download");
        request = new android.app.DownloadManager.Request(Uri.parse(s));
        s2 = be.b(a).l.d(s);
        request.setDestinationUri(be.b(a).l.b(s2));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            request.setNotificationVisibility(1);
        }
        request.setShowRunningNotification(true);
        if (!be.b(a).d.s()) goto _L15; else goto _L14
_L14:
        request.setAllowedNetworkTypes(2);
_L18:
        Exception exception1;
        request.setAllowedOverRoaming(false);
        request.setTitle(s2);
        request.setDescription(s);
        downloadmanager.enqueue(request);
          goto _L10
_L16:
        Intent intent5;
        URISyntaxException urisyntaxexception;
        Intent intent6;
        Exception exception8;
        ActivityNotFoundException activitynotfoundexception;
        boolean flag1;
        String s3;
        Intent intent7;
        try
        {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(s));
            a.getSherlockActivity().startActivity(intent2);
        }
        catch (Exception exception2)
        {
            d.a(exception2);
            return false;
        }
        return true;
_L15:
        request.setAllowedNetworkTypes(3);
        continue; /* Loop/switch isn't completed */
_L12:
        intent5 = new Intent(a.getSherlockActivity(), com/appyet/activity/WebBrowserActivity);
        intent5.putExtra("URL", s);
        a.getSherlockActivity().startActivity(intent5);
        return true;
_L6:
        intent6 = Intent.parseUri(s, 1);
        if (be.b(a).getPackageManager().resolveActivity(intent6, 0) != null)
        {
            break MISSING_BLOCK_LABEL_1274;
        }
        s3 = intent6.getPackage();
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_1274;
        }
        intent7 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://search?q=pname:")).append(s3).toString()));
        intent7.addCategory("android.intent.category.BROWSABLE");
        be.b(a).startActivity(intent7);
        return true;
        urisyntaxexception;
        Log.w("Browser", (new StringBuilder("Bad URI ")).append(s).append(": ").append(urisyntaxexception.getMessage()).toString());
        return false;
        exception8;
        d.a(exception8);
        return false;
        if (intent6 == null)
        {
            break MISSING_BLOCK_LABEL_1295;
        }
        intent6.addCategory("android.intent.category.BROWSABLE");
        intent6.setComponent(null);
        flag1 = a.getSherlockActivity().startActivityIfNeeded(intent6, -1);
        if (flag1)
        {
            return true;
        }
          goto _L16
        activitynotfoundexception;
        try
        {
            d.a(activitynotfoundexception);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1)
        {
            d.a(exception1);
        }
          goto _L16
_L10:
        return true;
        if (true) goto _L18; else goto _L17
_L17:
    }
}
