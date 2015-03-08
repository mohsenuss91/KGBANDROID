// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.imai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.IMAIConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.imai.db.ClickDatabaseManager;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;
import java.util.Random;

public class IMAICore
{

    static Random a = new Random();

    public IMAICore()
    {
    }

    public static void fireErrorEvent(WeakReference weakreference, String s, String s1, String s2)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Fire error event IMAI for action: ")).append(s1).append(" ").append(s).toString());
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder("window._im_imai.broadcastEvent('error','")).append(s).append("','").append(s1).append("','").append(s2).append("')").toString());
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception);
        return;
    }

    public static void fireOpenEmbeddedSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "fireOpenEmbeddedSuccessful");
            if (!((IMWebView)weakreference.get()).mWebViewIsBrowserActivity && !((IMWebView)weakreference.get()).mIsInterstitialAd)
            {
                IMBrowserActivity.requestOnAdDismiss(((IMWebView)weakreference.get()).getWebviewHandler().obtainMessage(((IMWebView)weakreference.get()).getDismissMessage()));
                ((IMWebView)weakreference.get()).fireOnShowAdScreen();
            }
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder("window._im_imai.broadcastEvent('openEmbeddedSuccessful','")).append(s).append("')").toString());
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception);
        return;
    }

    public static void fireOpenExternalSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "fireOpenExternalSuccessful");
            ((IMWebView)weakreference.get()).fireOnLeaveApplication();
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder("window._im_imai.broadcastEvent('openExternalSuccessful','")).append(s).append("')").toString());
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception);
        return;
    }

    public static void firePingInWebViewSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "firePingInWebViewSuccessful");
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder("window._im_imai.broadcastEvent('pingInWebViewSuccessful','")).append(s).append("')").toString());
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception);
        return;
    }

    public static void firePingSuccessful(WeakReference weakreference, String s)
    {
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (weakreference.get() != null)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "firePingSuccessful");
            injectJavaScript((IMWebView)weakreference.get(), (new StringBuilder("window._im_imai.broadcastEvent('pingSuccessful','")).append(s).append("')").toString());
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception);
        return;
    }

    public static int getRandomNumber()
    {
        return a.nextInt();
    }

    public static void initialize()
    {
        (new RequestResponseManager()).init();
        ClickDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getImai().getmMaxDb());
    }

    public static void injectJavaScript(IMWebView imwebview, String s)
    {
        try
        {
            imwebview.getActivity().runOnUiThread(new c(imwebview, s));
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Error injecting javascript ", exception);
        }
    }

    public static void launchEmbeddedBrowser(WeakReference weakreference, String s)
    {
        Intent intent = new Intent(((IMWebView)weakreference.get()).getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
        intent.putExtra("extra_url", s);
        intent.putExtra("extra_browser_type", 100);
        intent.setFlags(0x10000000);
        IMBrowserActivity.setWebViewListener(((IMWebView)weakreference.get()).mListener);
        if (!((IMWebView)weakreference.get()).mWebViewIsBrowserActivity && !((IMWebView)weakreference.get()).mIsInterstitialAd && ((IMWebView)weakreference.get()).getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.DEFAULT)
        {
            intent.putExtra("FIRST_INSTANCE", true);
            intent.putExtra("QAMODE", SDKUtil.getQAMode());
        }
        ((IMWebView)weakreference.get()).getActivity().getApplicationContext().startActivity(intent);
    }

    public static void launchExternalApp(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s));
        intent.setFlags(0x10000000);
        InternalSDKUtil.getContext().startActivity(intent);
    }

    public static void ping(WeakReference weakreference, String s, boolean flag)
    {
        try
        {
            ((IMWebView)weakreference.get()).getActivity().runOnUiThread(new a(s, flag, weakreference));
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Failed to ping", exception);
        }
    }

    public static void pingInWebview(WeakReference weakreference, String s, boolean flag)
    {
        try
        {
            ((IMWebView)weakreference.get()).getActivity().runOnUiThread(new b(s, flag, weakreference));
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Failed to ping in webview", exception);
        }
    }

    public static boolean validateURL(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Null url passed");
            return false;
        } else
        {
            return true;
        }
    }


    private class c
        implements Runnable
    {

        final IMWebView a;
        final String b;

        public final void run()
        {
            a.injectJavaScript(b);
        }

        c(IMWebView imwebview, String s)
        {
            a = imwebview;
            b = s;
            super();
        }
    }


    private class a
        implements Runnable
    {

        final String a;
        final boolean b;
        final WeakReference c;

        public final void run()
        {
            try
            {
                int i = Initializer.getConfigParams().getImai().getMaxRetry();
                ClickData clickdata = new ClickData(a, b, false, i);
                RequestResponseManager requestresponsemanager = new RequestResponseManager();
                requestresponsemanager.init();
                RequestResponseManager.mNetworkQueue.add(0, clickdata);
                class a
                    implements HttpRequestCallback
                {

                    final a a;

                    public void notifyResult(int j, Object obj)
                    {
                        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Got PING callback. Status: ")).append(j).toString());
                        if (j == 0)
                        {
                            try
                            {
                                IMAICore.firePingSuccessful(a.c, a.a);
                                return;
                            }
                            catch (Exception exception1)
                            {
                                Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception1);
                            }
                            break MISSING_BLOCK_LABEL_74;
                        }
                        IMAICore.fireErrorEvent(a.c, "IMAI Ping in http client failed", "ping", a.a);
                        return;
                    }

                a()
                {
                    a = a.this;
                    super();
                }
                }

                requestresponsemanager.processClick(InternalSDKUtil.getContext(), new a());
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception ping in background", exception);
            }
        }

        a(String s, boolean flag, WeakReference weakreference)
        {
            a = s;
            b = flag;
            c = weakreference;
            super();
        }
    }


    private class b
        implements Runnable
    {

        final String a;
        final boolean b;
        final WeakReference c;

        public final void run()
        {
            try
            {
                int i = Initializer.getConfigParams().getImai().getMaxRetry();
                ClickData clickdata = new ClickData(a, b, true, i);
                RequestResponseManager requestresponsemanager = new RequestResponseManager();
                requestresponsemanager.init();
                RequestResponseManager.mNetworkQueue.add(0, clickdata);
                class a
                    implements HttpRequestCallback
                {

                    final b a;

                    public void notifyResult(int j, Object obj)
                    {
                        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Got PING IN WEBVIEW callback. Status: ")).append(j).toString());
                        if (j == 0)
                        {
                            try
                            {
                                IMAICore.firePingInWebViewSuccessful(a.c, a.a);
                                return;
                            }
                            catch (Exception exception1)
                            {
                                Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception1);
                            }
                            break MISSING_BLOCK_LABEL_74;
                        }
                        IMAICore.fireErrorEvent(a.c, "IMAI Ping in webview failed", "pingInWebview", a.a);
                        return;
                    }

                a()
                {
                    a = b.this;
                    super();
                }
                }

                requestresponsemanager.processClick(InternalSDKUtil.getContext(), new a());
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception ping in background", exception);
            }
        }

        b(String s, boolean flag, WeakReference weakreference)
        {
            a = s;
            b = flag;
            c = weakreference;
            super();
        }
    }

}
