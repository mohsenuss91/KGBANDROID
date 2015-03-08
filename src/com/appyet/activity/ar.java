// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.v;
import com.appyet.manager.af;
import com.appyet.manager.bp;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.appyet.activity:
//            WhatsNewActivity, WebActionActivity

final class ar extends WebViewClient
{

    final WhatsNewActivity a;

    ar(WhatsNewActivity whatsnewactivity)
    {
        a = whatsnewactivity;
        super();
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Toast.makeText(a, s, 0).show();
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
        Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(s));
        a.startActivity(intent1);
        return true;
        if (!s.startsWith("http://")) goto _L2; else goto _L1
_L1:
        String s1 = v.a(s);
        if (s1 == null) goto _L4; else goto _L3
_L3:
        if (!s1.contains("video") && !s1.contains("audio") && !s1.contains("image")) goto _L4; else goto _L5
_L5:
        Intent intent = new Intent(a, com/appyet/activity/WebActionActivity);
        intent.putExtra("URL", s);
        a.startActivity(intent);
        return true;
        Exception exception;
        exception;
        d.a(exception);
_L2:
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Accept-Language", com.appyet.manager.ar.c(WhatsNewActivity.a(a)));
            webview.loadUrl(s, hashmap);
        }
        catch (Exception exception1)
        {
            d.a(exception1);
            return true;
        }
        return true;
_L4:
        if (s1 == null) goto _L2; else goto _L6
_L6:
        if (!s1.contains("application") || android.os.Build.VERSION.SDK_INT < 9) goto _L2; else goto _L7
_L7:
        DownloadManager downloadmanager;
        android.app.DownloadManager.Request request;
        String s2;
        WhatsNewActivity.a(a).l.a();
        downloadmanager = (DownloadManager)a.getSystemService("download");
        request = new android.app.DownloadManager.Request(Uri.parse(s));
        s2 = WhatsNewActivity.a(a).l.d(s);
        request.setDestinationUri(WhatsNewActivity.a(a).l.b(s2));
        if (android.os.Build.VERSION.SDK_INT < 11) goto _L9; else goto _L8
_L8:
        request.setNotificationVisibility(1);
_L10:
        if (!WhatsNewActivity.a(a).d.s())
        {
            break MISSING_BLOCK_LABEL_357;
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
