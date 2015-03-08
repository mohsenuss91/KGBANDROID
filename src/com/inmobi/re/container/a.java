// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.re.container:
//            IMWebView

class a extends WebChromeClient
{

    final IMWebView a;

    a(IMWebView imwebview)
    {
        a = imwebview;
        super();
    }

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
    {
        try
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(IMWebView.h(a));
            builder.setTitle("Locations access");
            builder.setMessage("Allow location access").setCancelable(true).setPositiveButton("Accept", new g(callback, s)).setNegativeButton("Decline", new f(callback, s));
            builder.create().show();
            super.onGeolocationPermissionsShowPrompt(s, callback);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Exception while accessing location from creative ", exception);
        }
        callback.invoke(s, false, false);
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> onJsAlert, ")).append(s1).toString());
        if (!a.isExpanded() && !a.mIsInterstitialAd) goto _L2; else goto _L1
_L1:
        Object obj = a.getExpandedActivity();
_L4:
        (new android.app.AlertDialog.Builder(((android.content.Context) (obj)))).setTitle(s).setMessage(s1).setPositiveButton(0x104000a, new c(jsresult)).setCancelable(false).create().show();
        break MISSING_BLOCK_LABEL_119;
_L2:
        android.content.Context context = webview.getContext();
        obj = context;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.4.1", "webchrome client exception onJSAlert ", exception);
        return true;
    }

    public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        IMWebView.a(a, view);
        IMWebView.a(a, customviewcallback);
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("onShowCustomView ******************************")).append(view).toString());
        FrameLayout framelayout;
        Object obj;
        IMWebView.a(a, IMWebView.g(a), new b());
        IMWebView.g(a).setOnTouchListener(new e());
        if (!(view instanceof FrameLayout))
        {
            break MISSING_BLOCK_LABEL_396;
        }
        IMWebView.a(a, (FrameLayout)view);
        framelayout = (FrameLayout)IMWebView.h(a).findViewById(0x1020002);
        if (!(IMWebView.i(a).getFocusedChild() instanceof VideoView))
        {
            break MISSING_BLOCK_LABEL_309;
        }
        IMWebView.a(a, (VideoView)IMWebView.i(a).getFocusedChild());
        if (!a.isExpanded() && !a.mIsInterstitialAd)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        obj = a.getExpandedActivity();
_L2:
        IMWebView.j(a).setMediaController(new MediaController(((android.content.Context) (obj))));
        IMWebView.i(a).setBackgroundColor(0xff000000);
        IMWebView.j(a).setOnCompletionListener(IMWebView.k(a));
        IMWebView.j(a).setOnFocusChangeListener(new d());
        framelayout.addView(IMWebView.g(a), new android.widget.AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        Log.debug("[InMobi]-[RE]-4.4.1", "Registering");
        IMWebView.a(a, IMWebView.g(a), new h());
        return;
        obj = view.getContext();
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            IMWebView.a(a, view);
            view.setBackgroundColor(0xff000000);
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("adding ")).append(view).toString());
            framelayout.addView(view, new android.widget.AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
            IMWebView.a(a, IMWebView.g(a), new a());
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "IMWebview onShowCustomView exception ", exception);
        }
    }

    private class g
        implements android.content.DialogInterface.OnClickListener
    {

        final android.webkit.GeolocationPermissions.Callback a;
        final String b;
        final com.inmobi.re.container.a c;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            a.invoke(b, true, false);
        }

        g(android.webkit.GeolocationPermissions.Callback callback, String s)
        {
            c = a.this;
            a = callback;
            b = s;
            super();
        }
    }


    private class f
        implements android.content.DialogInterface.OnClickListener
    {

        final android.webkit.GeolocationPermissions.Callback a;
        final String b;
        final com.inmobi.re.container.a c;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            a.invoke(b, false, false);
        }

        f(android.webkit.GeolocationPermissions.Callback callback, String s)
        {
            c = a.this;
            a = callback;
            b = s;
            super();
        }
    }


    private class c
        implements android.content.DialogInterface.OnClickListener
    {

        final JsResult a;
        final com.inmobi.re.container.a b;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            a.confirm();
        }

        c(JsResult jsresult)
        {
            b = a.this;
            a = jsresult;
            super();
        }
    }


    private class b
        implements android.view.View.OnTouchListener
    {

        final com.inmobi.re.container.a a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return false;
        }

        b()
        {
            a = a.this;
            super();
        }
    }


    private class e
        implements android.view.View.OnTouchListener
    {

        final com.inmobi.re.container.a a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return true;
        }

        e()
        {
            a = a.this;
            super();
        }
    }


    private class d
        implements android.view.View.OnFocusChangeListener
    {

        final com.inmobi.re.container.a a;

        public void onFocusChange(View view, boolean flag)
        {
            IMWebView.j(a.a).requestFocus();
        }

        d()
        {
            a = a.this;
            super();
        }
    }


    private class h
        implements android.view.View.OnKeyListener
    {

        final com.inmobi.re.container.a a;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "Back Button pressed when html5 video is playing");
                IMWebView.j(a.a).stopPlayback();
                IMWebView.l(a.a);
            }
            return false;
        }

        h()
        {
            a = a.this;
            super();
        }
    }


    private class a
        implements android.view.View.OnKeyListener
    {

        final com.inmobi.re.container.a a;

        public boolean onKey(View view, int i, KeyEvent keyevent)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Back Button pressed when html5 video is playing");
            IMWebView.l(a.a);
            return false;
        }

        a()
        {
            a = com.inmobi.re.container.a.this;
            super();
        }
    }

}
