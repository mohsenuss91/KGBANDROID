// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidView, MraidDisplayController, MraidPlacementTypeProperty

class <init> extends WebViewClient
{

    final MraidView this$0;

    public void onLoadResource(WebView webview, String s)
    {
        Log.d("MraidView", (new StringBuilder("Loaded resource: ")).append(s).toString());
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (!MraidView.access$1(MraidView.this))
        {
            MraidView.access$2(MraidView.this).initializeJavaScriptState();
            fireChangeEventForProperty(MraidPlacementTypeProperty.createWithType(MraidView.access$3(MraidView.this)));
            fireReadyEvent();
            if (getMraidListener() != null)
            {
                getMraidListener().dy(MraidView.this);
            }
            MraidView.access$4(MraidView.this, true);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Log.d("MraidView", (new StringBuilder("Error: ")).append(s).toString());
        super.onReceivedError(webview, i, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        String s1 = Uri.parse(s).getScheme();
        if (s1.equals("mopub"))
        {
            return true;
        }
        if (s1.equals("mraid"))
        {
            MraidView.access$0(MraidView.this, URI.create(s));
            return true;
        }
        if (wasClicked())
        {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            intent.addFlags(0x10000000);
            try
            {
                getContext().startActivity(intent);
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

    private ()
    {
        this$0 = MraidView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
