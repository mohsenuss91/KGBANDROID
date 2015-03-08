// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.internal.Log;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.androidsdk.impl.net:
//            WebviewLoader

class a
    implements Runnable
{

    final Context a;
    final WebviewLoader b;

    public void run()
    {
        try
        {
            WebviewLoader.a(b, new WebView(a));
            WebviewLoader.b = new AtomicBoolean(false);
            WebviewLoader.a(b).setWebViewClient(new WebViewClient());
            WebviewLoader.a(b).getSettings().setJavaScriptEnabled(true);
            WebviewLoader.a(b).getSettings().setPluginState(android.webkit.inState.ON);
            WebviewLoader.a(b).getSettings().setCacheMode(2);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Exception init webview", exception);
        }
    }

    WebViewClient(WebviewLoader webviewloader, Context context)
    {
        b = webviewloader;
        a = context;
        super();
    }
}
