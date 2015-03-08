// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.webkit.URLUtil;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class MRAIDBasic
{

    private IMWebView a;
    private Activity b;

    public MRAIDBasic(IMWebView imwebview, Activity activity)
    {
        a = imwebview;
        b = activity;
    }

    static Activity a(MRAIDBasic mraidbasic)
    {
        return mraidbasic.b;
    }

    static IMWebView b(MRAIDBasic mraidbasic)
    {
        return mraidbasic.a;
    }

    public void getCurrentPosition()
    {
        float f;
        JSONObject jsonobject;
        f = 0.0F;
        Log.debug("[InMobi]-[RE]-4.4.1", "IMWebView-> getCurrentPosition");
        jsonobject = new JSONObject();
        if (!a.isViewable()) goto _L2; else goto _L1
_L1:
        int l;
        int ai[];
        ai = new int[2];
        a.getLocationOnScreen(ai);
        l = ai[0];
        int k = ai[1];
        float f4;
        float f5;
        float f3 = a.getWidth();
        f = a.getDensity();
        f = (int)(f3 / f);
        f4 = a.getHeight();
        f5 = a.getDensity();
        int i1;
        float f2;
        int j1;
        int k1;
        int l1 = (int)(f4 / f5);
        k1 = l;
        j1 = k;
        f2 = f;
        i1 = l1;
_L8:
        Exception exception;
        int i;
        int j;
        float f1;
        Exception exception1;
        Exception exception2;
        Exception exception3;
        Exception exception5;
        Exception exception6;
        Exception exception7;
        try
        {
            jsonobject.put("x", k1);
            jsonobject.put("y", j1);
            jsonobject.put("width", f2);
            jsonobject.put("height", i1);
        }
        catch (JSONException jsonexception2) { }
_L3:
        synchronized (a.mutexcPos)
        {
            a.curPosition = jsonobject;
            a.acqMutexcPos.set(false);
            a.mutexcPos.notifyAll();
        }
        return;
        exception2;
        k = 0;
        l = 0;
_L6:
        Log.debug("[InMobi]-[RE]-4.4.1", "Failed to get current position");
        try
        {
            jsonobject.put("x", l);
            jsonobject.put("y", k);
            jsonobject.put("width", f);
            jsonobject.put("height", 0);
        }
        catch (JSONException jsonexception1) { }
          goto _L3
        exception;
        i = 0;
        j = 0;
        f1 = 0.0F;
        exception1 = exception;
_L5:
        try
        {
            jsonobject.put("x", j);
            jsonobject.put("y", i);
            jsonobject.put("width", f1);
            jsonobject.put("height", 0);
        }
        catch (JSONException jsonexception) { }
        throw exception1;
        exception6;
        j = l;
        exception1 = exception6;
        f1 = 0.0F;
        i = 0;
        continue; /* Loop/switch isn't completed */
        exception3;
        j = l;
        i = k;
        f1 = f;
        exception1 = exception3;
        if (true) goto _L5; else goto _L4
_L4:
        exception5;
        f = 0.0F;
        k = 0;
          goto _L6
        exception7;
          goto _L6
_L2:
        i1 = 0;
        f2 = 0.0F;
        j1 = 0;
        k1 = 0;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void getDefaultPosition()
    {
        float f;
        JSONObject jsonobject;
        f = 0.0F;
        Log.debug("[InMobi]-[RE]-4.4.1", "IMWebView-> getDefaultPosition");
        jsonobject = new JSONObject();
        if (!a.isViewable()) goto _L2; else goto _L1
_L1:
        int j;
        int ai[];
        ai = new int[2];
        ((View)a.getOriginalParent()).getLocationOnScreen(ai);
        j = ai[0];
        int i = ai[1];
        float f3;
        float f4;
        float f2 = ((View)a.getOriginalParent()).getWidth();
        f = a.getDensity();
        f = (int)(f2 / f);
        f3 = ((View)a.getOriginalParent()).getHeight();
        f4 = a.getDensity();
        float f1;
        int k;
        int l = (int)(f3 / f4);
        f1 = f;
        k = l;
_L8:
        Exception exception;
        Exception exception1;
        try
        {
            jsonobject.put("x", j);
            jsonobject.put("y", i);
            jsonobject.put("width", f1);
            jsonobject.put("height", k);
        }
        catch (JSONException jsonexception2) { }
_L3:
        synchronized (a.mutexdPos)
        {
            a.defPosition = jsonobject;
            a.acqMutexdPos.set(false);
            a.mutexdPos.notifyAll();
        }
        return;
        exception1;
        i = 0;
        j = 0;
_L6:
        exception1.printStackTrace();
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Failed to get default position")).append(exception1.getMessage()).toString());
        try
        {
            jsonobject.put("x", j);
            jsonobject.put("y", i);
            jsonobject.put("width", f);
            jsonobject.put("height", 0);
        }
        catch (JSONException jsonexception1) { }
          goto _L3
        exception;
        i = 0;
        j = 0;
_L5:
        try
        {
            jsonobject.put("x", j);
            jsonobject.put("y", i);
            jsonobject.put("width", f);
            jsonobject.put("height", 0);
        }
        catch (JSONException jsonexception) { }
        throw exception;
        exception;
        f = 0.0F;
        i = 0;
        continue; /* Loop/switch isn't completed */
        exception;
        if (true) goto _L5; else goto _L4
_L4:
        exception1;
        f = 0.0F;
        i = 0;
          goto _L6
        exception1;
          goto _L6
_L2:
        f1 = 0.0F;
        k = 0;
        i = 0;
        j = 0;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void open(String s)
    {
        if (!s.startsWith("http://") && (!s.contains("https") || s.contains("play.google.com") || s.contains("market.android.com") || s.contains("market%3A%2F%2F")))
        {
            break MISSING_BLOCK_LABEL_234;
        }
        if (!URLUtil.isValidUrl(s))
        {
            a.raiseError("Invalid url", "open");
            return;
        }
        Intent intent;
        intent = new Intent(b, com/inmobi/androidsdk/IMBrowserActivity);
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView-> open:")).append(s).toString());
        intent.putExtra("extra_url", s);
        intent.putExtra("extra_browser_type", 100);
        if (a.getStateVariable() == com.inmobi.re.container.IMWebView.ViewState.DEFAULT && !a.mIsInterstitialAd && !a.mWebViewIsBrowserActivity)
        {
            intent.putExtra("FIRST_INSTANCE", true);
        }
        IMBrowserActivity.setWebViewListener(a.mListener);
        ActivityNotFoundException activitynotfoundexception;
        try
        {
            b.startActivity(intent);
        }
        catch (Exception exception1)
        {
            try
            {
                a.raiseError("Invalid url", "open");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "Failed to perform mraid Open");
                return;
            }
            catch (Exception exception)
            {
                a.raiseError("Invalid url", "open");
            }
            return;
        }
        if (!a.mWebViewIsBrowserActivity)
        {
            a.fireOnShowAdScreen();
            return;
        }
        break MISSING_BLOCK_LABEL_253;
        (new Thread(new a(s))).start();
    }

    private class a
        implements Runnable
    {

        final String a;
        final MRAIDBasic b;

        public void run()
        {
            String s = InternalSDKUtil.getFinalRedirectedUrl(a);
            if (s != null)
            {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(s));
                intent.addFlags(0x10000000);
                try
                {
                    MRAIDBasic.a(b).startActivity(intent);
                }
                catch (Exception exception)
                {
                    MRAIDBasic.b(b).raiseError("Invalid url", "open");
                    return;
                }
                if (MRAIDBasic.b(b).mListener != null)
                {
                    MRAIDBasic.b(b).mListener.onLeaveApplication();
                }
            }
        }

        a(String s)
        {
            b = MRAIDBasic.this;
            a = s;
            super();
        }
    }

}
