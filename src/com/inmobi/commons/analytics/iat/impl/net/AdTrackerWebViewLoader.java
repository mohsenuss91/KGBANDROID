// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import android.webkit.WebView;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.URLDecoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface

public class AdTrackerWebViewLoader
{

    private static WebView a = null;
    private static AtomicBoolean b;
    private long c;
    private long d;
    private Goal e;

    public AdTrackerWebViewLoader()
    {
        c = 0L;
        d = 0L;
        AdTrackerNetworkInterface.getUIHandler().post(new d());
    }

    static long a(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        return adtrackerwebviewloader.c;
    }

    static long a(AdTrackerWebViewLoader adtrackerwebviewloader, long l)
    {
        adtrackerwebviewloader.d = l;
        return l;
    }

    static WebView a()
    {
        return a;
    }

    static WebView a(WebView webview)
    {
        a = webview;
        return webview;
    }

    static e a(AdTrackerWebViewLoader adtrackerwebviewloader, String s)
    {
        return adtrackerwebviewloader.a(s);
    }

    private e a(String s)
    {
        e e1 = new e();
        String as[] = s.split("&");
        int j;
        String s1;
        int k;
        j = 0;
        s1 = null;
        k = 0;
_L14:
        if (j >= as.length) goto _L2; else goto _L1
_L1:
        String as1[] = as[j].split("=");
        int l = 0;
_L12:
        if (l >= as1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!"err".equals(as1[l])) goto _L4; else goto _L3
_L3:
        k = Integer.parseInt(as1[l + 1]);
          goto _L5
_L4:
        if ("res".equals(as1[l]))
        {
            s1 = as1[l + 1];
        }
          goto _L5
_L2:
        e.a(e1, k);
        e.a(e1, s1);
        if (5003 != k)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Webview Timeout ")).append(s1).toString());
        break; /* Loop/switch isn't completed */
        if (5001 != k) goto _L7; else goto _L6
_L6:
        Exception exception1;
        int i;
        Exception exception2;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Invalid params passed ")).append(s1).toString());
        break; /* Loop/switch isn't completed */
_L9:
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, e, 0, 0L, i, null);
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Check content Exception", exception1);
        return null;
_L7:
        if (5002 != k)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("XMLHTTP request not supported ")).append(s1).toString());
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2)
        {
            exception1 = exception2;
            i = k;
        }
        if (true) goto _L9; else goto _L8
_L8:
        if (5005 != k)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Invalid JSON Response ")).append(s1).toString());
        break; /* Loop/switch isn't completed */
        if (5004 != k)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Webview Server Error ")).append(s1).toString());
        break; /* Loop/switch isn't completed */
        if (5000 != k)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Webview response ")).append(URLDecoder.decode(s1, "utf-8")).toString());
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        exception1 = exception;
        i = 0;
        if (true) goto _L9; else goto _L10
_L10:
        break; /* Loop/switch isn't completed */
_L5:
        l++;
        if (true) goto _L12; else goto _L11
_L11:
        j++;
        if (true) goto _L14; else goto _L13
_L13:
        return e1;
    }

    static AtomicBoolean a(AtomicBoolean atomicboolean)
    {
        b = atomicboolean;
        return atomicboolean;
    }

    static long b(AdTrackerWebViewLoader adtrackerwebviewloader, long l)
    {
        adtrackerwebviewloader.c = l;
        return l;
    }

    static Goal b(AdTrackerWebViewLoader adtrackerwebviewloader)
    {
        return adtrackerwebviewloader.e;
    }

    static AtomicBoolean b()
    {
        return b;
    }

    static boolean b(AdTrackerWebViewLoader adtrackerwebviewloader, String s)
    {
        return adtrackerwebviewloader.b(s);
    }

    private boolean b(String s)
    {
        JSONObject jsonobject1;
        String s1;
        int i;
        int j;
        String s2;
        try
        {
            JSONObject jsonobject = new JSONObject(URLDecoder.decode(s, "utf-8"));
            jsonobject1 = jsonobject.getJSONObject("iat_ids");
            s1 = jsonobject.getString("errmsg");
            i = jsonobject.getInt("timetoLive");
            j = jsonobject.getInt("errcode");
        }
        catch (Exception exception)
        {
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, e, 0, 0L, 424, exception.getMessage());
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to upload goal in webview", exception);
            return false;
        }
        if (j == 6000)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, e, 0, 0L, j, null);
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Failed to upload goal in webview")).append(s1).toString());
        return false;
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, e, 0, d, 0, null);
        s2 = jsonobject1.toString();
        if (j == 6001)
        {
            s2 = null;
        }
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", s2);
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive", Integer.toString(i));
        return true;
    }

    public static WebView getWebview()
    {
        return a;
    }

    public static boolean isWebviewLoading()
    {
        return b.get();
    }

    public void deinit(int i)
    {
        AdTrackerNetworkInterface.getUIHandler().postDelayed(new a(), i);
    }

    public boolean loadWebview(Goal goal)
    {
        e = goal;
        try
        {
            AdTrackerNetworkInterface.getUIHandler().post(new c());
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", exception.toString());
            return false;
        }
        return true;
    }

    public void stopLoading()
    {
        AdTrackerNetworkInterface.getUIHandler().post(new b());
    }


    private class d
        implements Runnable
    {

        final AdTrackerWebViewLoader a;

        public void run()
        {
            AdTrackerWebViewLoader.a(new AtomicBoolean(false));
            AdTrackerWebViewLoader.a(new WebView(InternalSDKUtil.getContext()));
            AdTrackerWebViewLoader.a().setWebViewClient(a. new MyWebViewClient());
            AdTrackerWebViewLoader.a().getSettings().setJavaScriptEnabled(true);
            AdTrackerWebViewLoader.a().getSettings().setCacheMode(2);
            AdTrackerWebViewLoader.a().addJavascriptInterface(new JSInterface(), "iatsdk");
        }

        d()
        {
            a = AdTrackerWebViewLoader.this;
            super();
        }

        private class MyWebViewClient extends WebViewClient
        {

            final AdTrackerWebViewLoader a;

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                if (!AdTrackerWebViewLoader.b().compareAndSet(true, false))
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                AdTrackerNetworkInterface.setWebviewUploadStatus(false);
                synchronized (AdTrackerNetworkInterface.getNetworkThread())
                {
                    AdTrackerNetworkInterface.getNetworkThread().notify();
                }
                try
                {
                    AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, AdTrackerWebViewLoader.b(a), 0, 0L, i, null);
                    Log.internal("[InMobi]-[AdTracker]-4.4.1", "Webview Received Error");
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[AdTracker]-4.4.1", "Exception onReceived Error", exception);
                }
                super.onReceivedError(webview, i, s, s1);
                return;
                exception1;
                thread;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("SSL Error. Proceeding")).append(sslerror).toString());
                if (!AdTrackerWebViewLoader.b().compareAndSet(true, false))
                {
                    break MISSING_BLOCK_LABEL_80;
                }
                AdTrackerNetworkInterface.setWebviewUploadStatus(false);
                synchronized (AdTrackerNetworkInterface.getNetworkThread())
                {
                    AdTrackerNetworkInterface.getNetworkThread().notify();
                }
                try
                {
                    AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, AdTrackerWebViewLoader.b(a), 0, 0L, sslerror.getPrimaryError(), null);
                    Log.internal("[InMobi]-[AdTracker]-4.4.1", "Webview Received SSL Error");
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[AdTracker]-4.4.1", "Exception onReceived SSL Error", exception);
                }
                sslerrorhandler.proceed();
                return;
                exception1;
                thread;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (!AdTrackerWebViewLoader.b().compareAndSet(true, false)) goto _L2; else goto _L1
_L1:
                AdTrackerWebViewLoader.a(a, System.currentTimeMillis() - AdTrackerWebViewLoader.a(a));
                if (!s.contains("iat")) goto _L4; else goto _L3
_L3:
                e e1;
                String s1 = s.substring(7);
                e1 = AdTrackerWebViewLoader.a(a, s1);
                if (e1 == null) goto _L6; else goto _L5
_L5:
                FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "errcode", Integer.toString(e.a(e1)));
                if (5000 == e.a(e1)) goto _L8; else goto _L7
_L7:
                AdTrackerNetworkInterface.setWebviewUploadStatus(false);
                AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, AdTrackerWebViewLoader.b(a), 0, 0L, e.a(e1), null);
_L4:
                synchronized (AdTrackerNetworkInterface.getNetworkThread())
                {
                    AdTrackerNetworkInterface.getNetworkThread().notify();
                }
_L2:
                try
                {
                    webview.loadUrl(s);
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[AdTracker]-4.4.1", "Exception Should Override Error", exception);
                    return true;
                }
                return true;
_L8:
                if (AdTrackerWebViewLoader.b(a, e.b(e1)))
                {
                    AdTrackerNetworkInterface.setWebviewUploadStatus(true);
                    continue; /* Loop/switch isn't completed */
                }
_L6:
                AdTrackerNetworkInterface.setWebviewUploadStatus(false);
                if (true) goto _L4; else goto _L9
_L9:
                exception1;
                thread;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            protected MyWebViewClient()
            {
                a = AdTrackerWebViewLoader.this;
                super();
            }
        }


        private class JSInterface
        {

            public String getParams()
            {
                String s = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
                String s1 = AdTrackerRequestResponseBuilder.getWebViewRequestParam();
                if (s != null)
                {
                    s1 = (new StringBuilder()).append(s1).append("&referrer=").append(s).toString();
                }
                Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Request param for webview")).append(s1).toString());
                return s1;
            }

            protected JSInterface()
            {
            }
        }

    }


    private class e
    {

        private int a;
        private String b;

        static int a(e e1)
        {
            return e1.a;
        }

        static int a(e e1, int i)
        {
            e1.a = i;
            return i;
        }

        static String a(e e1, String s)
        {
            e1.b = s;
            return s;
        }

        static String b(e e1)
        {
            return e1.b;
        }

        public e()
        {
            a = 0;
            b = null;
        }
    }


    private class a
        implements Runnable
    {

        final AdTrackerWebViewLoader a;

        public void run()
        {
            if (AdTrackerWebViewLoader.a() != null)
            {
                AdTrackerWebViewLoader.a().stopLoading();
                AdTrackerWebViewLoader.a().destroy();
                AdTrackerWebViewLoader.a(null);
                AdTrackerWebViewLoader.b().set(false);
            }
        }

        a()
        {
            a = AdTrackerWebViewLoader.this;
            super();
        }
    }


    private class c
        implements Runnable
    {

        final AdTrackerWebViewLoader a;

        public void run()
        {
            AdTrackerWebViewLoader.b(a, System.currentTimeMillis());
            AdTrackerWebViewLoader.b().set(true);
            Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Load Webview: ")).append(AdTrackerNetworkInterface.b()).toString());
            AdTrackerWebViewLoader.a().loadUrl(AdTrackerNetworkInterface.b());
        }

        c()
        {
            a = AdTrackerWebViewLoader.this;
            super();
        }
    }


    private class b
        implements Runnable
    {

        final AdTrackerWebViewLoader a;

        public void run()
        {
            if (AdTrackerWebViewLoader.a() != null)
            {
                AdTrackerWebViewLoader.b().set(false);
            }
            AdTrackerWebViewLoader.a().stopLoading();
        }

        b()
        {
            a = AdTrackerWebViewLoader.this;
            super();
        }
    }

}
