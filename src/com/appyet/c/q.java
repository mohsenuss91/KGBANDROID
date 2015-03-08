// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.appyet.activity.DisqusCommentActivity;
import com.appyet.activity.MainActivity;
import com.appyet.activity.MediaPlayerActivity;
import com.appyet.activity.PodcastActionActivity;
import com.appyet.activity.VideoPlayerActivity;
import com.appyet.activity.WebActionActivity;
import com.appyet.activity.WebBrowserActivity;
import com.appyet.activity.YouTubePlayerActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.d.d;
import com.appyet.d.e;
import com.appyet.data.FeedItem;
import com.appyet.f.v;
import com.appyet.f.z;
import com.appyet.manager.af;
import com.appyet.manager.al;
import com.appyet.manager.as;
import com.appyet.manager.bp;
import com.appyet.metadata.MetadataModuleFeed;
import java.net.URISyntaxException;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            k, n

final class q extends WebViewClient
{

    final k a;
    private ApplicationContext b;
    private MainActivity c;

    public q(k k1, MainActivity mainactivity)
    {
        a = k1;
        super();
        c = mainactivity;
        b = (ApplicationContext)c.getApplicationContext();
    }

    private WebResourceResponse a()
    {
        return new WebResourceResponse("image/png", "", b.getResources().openRawResource(0x7f0200fe));
    }

    public final void onPageFinished(WebView webview, String s)
    {
        k.i(a).setVisibility(8);
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
        if (s.startsWith("http://APPYET_BASE"))
        {
            s = s.replace("http://APPYET_BASE", "http://");
        }
        if (s.startsWith("http://") || s.startsWith("https://")) goto _L2; else goto _L1
_L1:
        if (!s.startsWith("//")) goto _L4; else goto _L3
_L3:
        s = (new StringBuilder("http:")).append(s).toString();
_L2:
        String s1 = e.a(z.a(s));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_377;
        }
        break MISSING_BLOCK_LABEL_86;
_L7:
        boolean flag;
        if (!flag) goto _L6; else goto _L5
_L5:
        return a();
_L4:
        s = (new StringBuilder("http://")).append(s).toString();
          goto _L2
_L6:
        if (!b.j.g(s1))
        {
            break MISSING_BLOCK_LABEL_360;
        }
        android.graphics.BitmapFactory.Options options = b.j.e(s1);
        if (options.outWidth < com.appyet.c.k.d(a).MinImageWidth || options.outHeight < com.appyet.c.k.d(a).MinImageHeight)
        {
            return a();
        }
        webresourceresponse1 = new WebResourceResponse("image/jpeg", "", b.j.f(s1));
        return webresourceresponse1;
        WebResourceResponse webresourceresponse;
        try
        {
            webresourceresponse = super.shouldInterceptRequest(webview, s);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            return super.shouldInterceptRequest(webview, s);
        }
        return webresourceresponse;
        Exception exception;
        WebResourceResponse webresourceresponse1;
        if (!s.contains("feeds.feedburner.com") && !s.contains("doubleclick.net") && !s.contains("feedsportal.com") && !s.contains("api.tweetmeme.com/imagebutton.gif") && !s.contains("share-buttons/fb.jpg") && !s.contains("share-buttons/diggme.png") && !s.contains("share-buttons/stumbleupon.png") && !s.contains("wordpress.com/1.0") && !s.contains("wordpress.com/b.gif") && !s.contains("blogger.googleusercontent.com") && !s.contains("feeds.feedburner.com") && !s.contains("www.assoc-amazon.com") && !s.contains("doubleclick.net") && !s.contains("statcounter.com") && !s.contains("pheedo.com"))
        {
            break MISSING_BLOCK_LABEL_377;
        }
        flag = true;
          goto _L7
        flag = false;
          goto _L7
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        if (!s.startsWith("market://"))
        {
            break MISSING_BLOCK_LABEL_39;
        }
        Intent intent13 = new Intent("android.intent.action.VIEW", Uri.parse(s));
        a.startActivity(intent13);
        return true;
        if (!s.startsWith("appyet.youtube:"))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        Intent intent12 = new Intent(c, com/appyet/activity/YouTubePlayerActivity);
        intent12.setData(Uri.parse(s));
        intent12.putExtra("TITLE", ((FeedItem)b.n.b.get(k.j(a))).getTitle());
        c.startActivity(intent12);
        return true;
        Exception exception;
        exception;
        d.a(exception);
        String s5;
        if (!s.startsWith("appyet.video:"))
        {
            break MISSING_BLOCK_LABEL_201;
        }
        s5 = s.replace("appyet.video:", "");
        Intent intent11 = new Intent(b, com/appyet/activity/VideoPlayerActivity);
        intent11.putExtra("URL", s5);
        b.startActivity(intent11);
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
            break MISSING_BLOCK_LABEL_294;
        }
        s4 = s.replace("appyet.audio:", "");
        b.c.a(s4, s4);
        b.c.a(false);
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
        if (!s.startsWith("appyet.podcast:"))
        {
            break MISSING_BLOCK_LABEL_357;
        }
        Intent intent9 = new Intent(a.getActivity(), com/appyet/activity/PodcastActionActivity);
        intent9.putExtra("POSITION", k.j(a));
        a.startActivity(intent9);
        return true;
        Exception exception5;
        exception5;
        d.a(exception5);
        if (!s.startsWith((new StringBuilder()).append(k.h(a)).append("/").append(com.appyet.c.k.f(a)).toString()))
        {
            break MISSING_BLOCK_LABEL_429;
        }
        (new n(a, s)).a(new Void[0]);
        return true;
        Exception exception6;
        exception6;
        d.a(exception6);
        if (!s.toLowerCase().startsWith((new StringBuilder()).append(k.h(a).toLowerCase()).append("/").append(k.g(a).toLowerCase()).toString()))
        {
            break MISSING_BLOCK_LABEL_572;
        }
        Intent intent8 = new Intent(b, com/appyet/activity/DisqusCommentActivity);
        intent8.putExtra("ArticleUrl", k.b(a).getLink());
        intent8.putExtra("ArticleTitle", k.b(a).getTitle());
        intent8.putExtra("DisQusShortName", com.appyet.c.k.d(a).DisQusShortName);
        b.startActivity(intent8);
        return true;
        Exception exception7;
        exception7;
        d.a(exception7);
        if (!s.startsWith("http://APPYET_BASE"))
        {
            break MISSING_BLOCK_LABEL_632;
        }
        Intent intent7 = new Intent(c, com/appyet/activity/WebBrowserActivity);
        intent7.putExtra("URL", s.replace("http://APPYET_BASE", "http://"));
        c.startActivity(intent7);
        return true;
        Exception exception8;
        exception8;
        d.a(exception8);
        if (!s.startsWith("wtai://wp/") || !s.startsWith("wtai://wp/mc;"))
        {
            break MISSING_BLOCK_LABEL_699;
        }
        Intent intent6 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("tel:")).append(s.substring(13)).toString()));
        b.startActivity(intent6);
        return true;
        if (!s.startsWith("http://") && !s.startsWith("file://")) goto _L6; else goto _L5
_L5:
        String s1 = v.a(s);
        if (s1 == null) goto _L8; else goto _L7
_L7:
        if (!s1.contains("video") && !s1.contains("audio") && !s1.contains("image")) goto _L8; else goto _L9
_L9:
        Intent intent1 = new Intent(c, com/appyet/activity/WebActionActivity);
        intent1.putExtra("URL", s);
        c.startActivity(intent1);
          goto _L10
_L8:
        if (s1 == null) goto _L12; else goto _L11
_L11:
        if (!s1.contains("application") || android.os.Build.VERSION.SDK_INT < 9) goto _L12; else goto _L13
_L13:
        DownloadManager downloadmanager;
        android.app.DownloadManager.Request request;
        String s2;
        b.l.a();
        downloadmanager = (DownloadManager)a.getSherlockActivity().getSystemService("download");
        request = new android.app.DownloadManager.Request(Uri.parse(s));
        s2 = b.l.d(s);
        request.setDestinationUri(b.l.b(s2));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            request.setNotificationVisibility(1);
        }
        request.setShowRunningNotification(true);
        if (!b.d.s()) goto _L15; else goto _L14
_L14:
        request.setAllowedNetworkTypes(2);
_L22:
        Exception exception1;
        request.setAllowedOverRoaming(false);
        request.setTitle(s2);
        request.setDescription(s);
        downloadmanager.enqueue(request);
          goto _L10
_L20:
        Intent intent2;
        Exception exception9;
        Intent intent3;
        boolean flag;
        URISyntaxException urisyntaxexception;
        Intent intent4;
        ActivityNotFoundException activitynotfoundexception;
        boolean flag1;
        String s3;
        Intent intent5;
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            c.startActivity(intent);
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
        if (s == null) goto _L17; else goto _L16
_L16:
        if (!s.startsWith("http://www.youtube.com/watch") && !s.startsWith("https://www.youtube.com/watch")) goto _L17; else goto _L18
_L18:
        a;
        if (!k.a(c, s)) goto _L17; else goto _L19
_L19:
        c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
          goto _L10
_L17:
        intent2 = new Intent(c, com/appyet/activity/WebBrowserActivity);
        intent2.putExtra("URL", s);
        c.startActivity(intent2);
          goto _L10
_L6:
        if (!s.startsWith("tel:"))
        {
            break MISSING_BLOCK_LABEL_1162;
        }
        intent3 = new Intent("android.intent.action.DIAL", Uri.parse(s));
        a.startActivity(intent3);
        return true;
        exception9;
        d.a(exception9);
        return false;
        flag = s.startsWith("about:");
        if (flag)
        {
            return false;
        }
        intent4 = Intent.parseUri(s, 1);
        if (b.getPackageManager().resolveActivity(intent4, 0) != null)
        {
            break MISSING_BLOCK_LABEL_1307;
        }
        s3 = intent4.getPackage();
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_1307;
        }
        intent5 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://search?q=pname:")).append(s3).toString()));
        intent5.addCategory("android.intent.category.BROWSABLE");
        b.startActivity(intent5);
        return true;
        urisyntaxexception;
        Log.w("Browser", (new StringBuilder("Bad URI ")).append(s).append(": ").append(urisyntaxexception.getMessage()).toString());
        return false;
        intent4.addCategory("android.intent.category.BROWSABLE");
        intent4.setComponent(null);
        flag1 = c.startActivityIfNeeded(intent4, -1);
        if (flag1)
        {
            return true;
        }
          goto _L20
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
          goto _L20
_L10:
        return true;
        if (true) goto _L22; else goto _L21
_L21:
    }
}
