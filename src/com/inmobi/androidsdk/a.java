// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.graphics.Bitmap;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.re.container.CustomView;

// Referenced classes of package com.inmobi.androidsdk:
//            IMBrowserActivity

class a extends WebViewClient
{

    final IMBrowserActivity a;

    a(IMBrowserActivity imbrowseractivity)
    {
        a = imbrowseractivity;
        super();
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (IMBrowserActivity.b(a) != null)
        {
            if (webview.canGoForward())
            {
                IMBrowserActivity.b(a).setSwitchInt(com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_ACTIVE);
                IMBrowserActivity.b(a).invalidate();
            } else
            {
                IMBrowserActivity.b(a).setSwitchInt(com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_INACTIVE);
                IMBrowserActivity.b(a).invalidate();
            }
        }
        CookieSyncManager.getInstance().sync();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if (IMBrowserActivity.b(a) != null)
        {
            IMBrowserActivity.b(a).setSwitchInt(com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_INACTIVE);
            IMBrowserActivity.b(a).invalidate();
        }
    }
}
