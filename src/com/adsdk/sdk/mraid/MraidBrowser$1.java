// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

// Referenced classes of package com.adsdk.sdk.mraid:
//            Drawables, MraidBrowser

class  extends WebViewClient
{

    final MraidBrowser this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        android.graphics.drawable.BitmapDrawable bitmapdrawable;
        android.graphics.drawable.BitmapDrawable bitmapdrawable1;
        if (webview.canGoBack())
        {
            bitmapdrawable = Drawables.LEFT_ARROW.decodeImage(MraidBrowser.this);
        } else
        {
            bitmapdrawable = Drawables.UNLEFT_ARROW.decodeImage(MraidBrowser.this);
        }
        MraidBrowser.access$1(MraidBrowser.this).setImageDrawable(bitmapdrawable);
        if (webview.canGoForward())
        {
            bitmapdrawable1 = Drawables.RIGHT_ARROW.decodeImage(MraidBrowser.this);
        } else
        {
            bitmapdrawable1 = Drawables.UNRIGHT_ARROW.decodeImage(MraidBrowser.this);
        }
        MraidBrowser.access$0(MraidBrowser.this).setImageDrawable(bitmapdrawable1);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        MraidBrowser.access$0(MraidBrowser.this).setImageDrawable(Drawables.UNRIGHT_ARROW.decodeImage(MraidBrowser.this));
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Toast.makeText((Activity)webview.getContext(), (new StringBuilder("MRAID error: ")).append(s).toString(), 0).show();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s != null)
        {
            String s1 = Uri.parse(s).getHost();
            if (!s.startsWith("http:") && !s.startsWith("https:") || "play.google.com".equals(s1) || "market.android.com".equals(s1))
            {
                try
                {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                }
                catch (ActivityNotFoundException activitynotfoundexception)
                {
                    Log.w("MoPub", (new StringBuilder("Unable to start activity for ")).append(s).append(". Ensure that your phone can handle this intent.").toString());
                }
                finish();
                return true;
            }
        }
        return false;
    }

    eption()
    {
        this$0 = MraidBrowser.this;
        super();
    }
}
