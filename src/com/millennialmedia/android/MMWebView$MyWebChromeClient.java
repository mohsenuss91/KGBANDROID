// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView

class <init> extends WebChromeClient
{

    private static final String KEY_USE_GEO = "mm_use_geo_location";
    final MMWebView this$0;

    private String getApplicationName(Context context)
    {
        PackageManager packagemanager = context.getApplicationContext().getPackageManager();
        android.content.pm.ApplicationInfo applicationinfo1 = packagemanager.getApplicationInfo(context.getPackageName(), 0);
        android.content.pm.ApplicationInfo applicationinfo = applicationinfo1;
_L1:
        android.content.pm.xception xception;
        Object obj;
        if (applicationinfo != null)
        {
            obj = packagemanager.getApplicationLabel(applicationinfo);
        } else
        {
            obj = "This app";
        }
        return (String)(String)obj;
        xception;
        applicationinfo = null;
          goto _L1
    }

    private boolean isFirstGeoRequest()
    {
        boolean flag = getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location");
        boolean flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        return flag1;
    }

    private boolean retrieveUseGeo()
    {
        return getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false);
    }

    private void saveUseGeo(boolean flag)
    {
        android.content.hromeClient hromeclient = getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
        hromeclient.Boolean("mm_use_geo_location", flag);
        hromeclient.mit();
    }

    public void onConsoleMessage(String s, int i, String s1)
    {
        <init>((new StringBuilder()).append(s).append(" at ").append(s1).append(" -- line ").append(i).toString());
        super.onConsoleMessage(s, i, s1);
    }

    public void onGeolocationPermissionsShowPrompt(final String origin, final android.webkit.ack callback)
    {
        if (!isFirstGeoRequest())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        if (!retrieveUseGeo()) goto _L2; else goto _L1
_L1:
        callback.invoke(origin, true, true);
_L4:
        return;
_L2:
        android.app.Activity activity = getActivity();
        if (activity == null) goto _L4; else goto _L3
_L3:
        android.app.istener istener = new android.app.tActivity(activity);
        istener.(getApplicationName(activity));
        class _cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final MMWebView.MyWebChromeClient this$1;
            final android.webkit.GeolocationPermissions.Callback val$callback;
            final String val$origin;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                saveUseGeo(true);
                callback.invoke(origin, true, true);
            }

            _cls2()
            {
                this$1 = MMWebView.MyWebChromeClient.this;
                callback = callback1;
                origin = s;
                super();
            }
        }

        class _cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final MMWebView.MyWebChromeClient this$1;
            final android.webkit.GeolocationPermissions.Callback val$callback;
            final String val$origin;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                saveUseGeo(false);
                callback.invoke(origin, false, false);
            }

            _cls1()
            {
                this$1 = MMWebView.MyWebChromeClient.this;
                callback = callback1;
                origin = s;
                super();
            }
        }

        istener.ge("Would like to use your Current Location.").iveButton("Allow", new _cls2()).iveButton("Don't Allow", new _cls1());
        istener.llback().show();
        return;
        callback.invoke(origin, false, false);
        return;
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        if (getContext() != getContext().getApplicationContext())
        {
            return super.onJsAlert(webview, s, s1, jsresult);
        } else
        {
            Toast.makeText(getContext(), s1, 0).show();
            return true;
        }
    }


    private _cls1()
    {
        this$0 = MMWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
