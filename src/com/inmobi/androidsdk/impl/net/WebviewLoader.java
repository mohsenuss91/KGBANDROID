// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.androidsdk.impl.net:
//            RequestResponseManager

public class WebviewLoader
{

    static boolean a = false;
    static AtomicBoolean b = null;
    private WebView c;

    public WebviewLoader(Context context)
    {
        c = null;
        RequestResponseManager.b.post(new c(context));
    }

    static WebView a(WebviewLoader webviewloader)
    {
        return webviewloader.c;
    }

    static WebView a(WebviewLoader webviewloader, WebView webview)
    {
        webviewloader.c = webview;
        return webview;
    }

    public void deinit(int i)
    {
        RequestResponseManager.b.postDelayed(new d(), i);
    }

    public void loadInWebview(String s, HashMap hashmap)
    {
        RequestResponseManager.b.post(new b(s, hashmap));
    }

    public void stopLoading()
    {
        RequestResponseManager.b.post(new a());
    }


    private class c
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
                WebviewLoader.a(b).setWebViewClient(new MyWebViewClient());
                WebviewLoader.a(b).getSettings().setJavaScriptEnabled(true);
                WebviewLoader.a(b).getSettings().setPluginState(android.webkit.WebSettings.PluginState.ON);
                WebviewLoader.a(b).getSettings().setCacheMode(2);
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception init webview", exception);
            }
        }

        c(Context context)
        {
            b = WebviewLoader.this;
            a = context;
            super();
        }

        private class MyWebViewClient extends WebViewClient
        {

            public void onPageFinished(WebView webview, String s)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("On page Finished ")).append(s).toString());
                if (!WebviewLoader.b.compareAndSet(true, false))
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                RequestResponseManager.c.set(true);
                synchronized (RequestResponseManager.a)
                {
                    RequestResponseManager.a.notify();
                }
                try
                {
                    super.onPageFinished(webview, s);
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[Network]-4.4.1", "Exception onPageFinished", exception);
                }
                break MISSING_BLOCK_LABEL_80;
                exception1;
                thread;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Processing click in webview error ")).append(i).append(" Failing url: ").append(s1).append("Error description ").append(s).toString());
                WebviewLoader.b.set(false);
                RequestResponseManager.c.set(false);
                super.onReceivedError(webview, i, s, s1);
                synchronized (RequestResponseManager.a)
                {
                    RequestResponseManager.a.notify();
                }
                return;
                exception1;
                thread;
                JVM INSTR monitorexit ;
                throw exception1;
                Exception exception;
                exception;
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception onReceived error callback webview", exception);
                return;
            }

            public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("SSL Error.Webview will proceed ")).append(sslerror).toString());
                sslerrorhandler.proceed();
                super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Should override ")).append(s).toString());
                webview.loadUrl(s);
                return true;
            }

            protected MyWebViewClient()
            {
            }
        }

    }


    private class d
        implements Runnable
    {

        final WebviewLoader a;

        public void run()
        {
            try
            {
                if (WebviewLoader.a(a) != null)
                {
                    WebviewLoader.a(a).stopLoading();
                    WebviewLoader.a(a).destroy();
                    WebviewLoader.a(a, null);
                    WebviewLoader.b.set(false);
                }
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception deinit webview ", exception);
            }
        }

        d()
        {
            a = WebviewLoader.this;
            super();
        }
    }


    private class b
        implements Runnable
    {

        final String a;
        final HashMap b;
        final WebviewLoader c;

        public void run()
        {
            try
            {
                WebviewLoader.b.set(true);
                WebviewLoader.a(c).loadUrl(a, b);
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception load in webview", exception);
            }
        }

        b(String s, HashMap hashmap)
        {
            c = WebviewLoader.this;
            a = s;
            b = hashmap;
            super();
        }
    }


    private class a
        implements Runnable
    {

        final WebviewLoader a;

        public void run()
        {
            try
            {
                if (WebviewLoader.a(a) != null)
                {
                    WebviewLoader.b.set(false);
                }
                WebviewLoader.a(a).stopLoading();
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception stop loading", exception);
            }
        }

        a()
        {
            a = WebviewLoader.this;
            super();
        }
    }

}
