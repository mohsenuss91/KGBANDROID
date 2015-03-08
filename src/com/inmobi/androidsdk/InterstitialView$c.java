// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.os.Handler;
import android.os.Message;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NetworkEventType;
import com.inmobi.androidsdk.impl.imai.IMAIController;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.androidsdk:
//            InterstitialView

class a extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        InterstitialView interstitialview = (InterstitialView)a.get();
        if (interstitialview == null) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR tableswitch 303 310: default 816
    //                   303 662
    //                   304 779
    //                   305 801
    //                   306 532
    //                   307 379
    //                   308 64
    //                   309 312
    //                   310 341;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        break; /* Loop/switch isn't completed */
_L9:
        long l3 = System.currentTimeMillis() - InterstitialView.c(interstitialview);
        if (!InterstitialView.d(interstitialview)) goto _L13; else goto _L12
_L12:
        JSONObject jsonobject3 = new JSONObject();
        jsonobject3.put("ad", InterstitialView.e(interstitialview));
        jsonobject3.put("t", l3);
_L14:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.FETCH_COMPLETE, jsonobject3));
_L13:
        removeMessages(306);
        try
        {
            if (InterstitialView.f(interstitialview) == null)
            {
                InterstitialView.a(interstitialview, new IMWebView(InterstitialView.g(interstitialview), InterstitialView.h(interstitialview), true, false));
                if (!interstitialview.b)
                {
                    InterstitialView.f(interstitialview).disableHardwareAcceleration();
                }
                InterstitialView.f(interstitialview).addJavascriptInterface(new IMAIController(InterstitialView.f(interstitialview)), "imaiController");
            }
            if (InterstitialView.i(interstitialview) != null)
            {
                InterstitialView.a(interstitialview, InterstitialView.i(interstitialview).replace("@__imm_aft@", (new StringBuilder()).append(l3).toString()));
            }
            InterstitialView.c(interstitialview, InterstitialView.i(interstitialview));
            return;
        }
        catch (Exception exception1)
        {
            try
            {
                Log.debug("[InMobi]-[Network]-4.4.1", "Error retrieving ad ", exception1);
                InterstitialView.a(interstitialview, ate.INIT);
                InterstitialView.a(interstitialview, 101, .INTERNAL_ERROR);
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception handling message in Interstitial", exception);
            }
        }
        return;
        JSONException jsonexception3;
        jsonexception3;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
          goto _L14
_L10:
        removeMessages(306);
        InterstitialView.a(interstitialview, ate.INIT);
        InterstitialView.a(interstitialview, 101, ()message.obj);
        return;
_L11:
        removeMessages(307);
        removeMessages(303);
        InterstitialView.a(interstitialview, ate.INIT);
        InterstitialView.a(interstitialview, null);
        InterstitialView.a(interstitialview, 101, .INTERNAL_ERROR);
        return;
_L8:
        removeMessages(310);
        removeMessages(303);
        InterstitialView.a(interstitialview, ate.INIT);
        InterstitialView.f(interstitialview).cancelLoad();
        InterstitialView.f(interstitialview).stopLoading();
        InterstitialView.f(interstitialview).deinit();
        InterstitialView.a(interstitialview, null);
        if (!InterstitialView.d(interstitialview)) goto _L16; else goto _L15
_L15:
        long l2;
        JSONObject jsonobject2;
        l2 = System.currentTimeMillis() - InterstitialView.j(interstitialview);
        jsonobject2 = new JSONObject();
        jsonobject2.put("ad", InterstitialView.e(interstitialview));
        jsonobject2.put("t", l2);
_L17:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_TIMEOUT, jsonobject2));
_L16:
        InterstitialView.a(interstitialview, 101, .AD_RENDERING_TIMEOUT);
        return;
        JSONException jsonexception2;
        jsonexception2;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
          goto _L17
_L7:
        long l1;
        removeMessages(308);
        removeMessages(309);
        InterstitialView.a(interstitialview, ate.INIT);
        l1 = System.currentTimeMillis() - InterstitialView.c(interstitialview);
        if (!InterstitialView.d(interstitialview)) goto _L19; else goto _L18
_L18:
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("t", l1);
        jsonobject1.put("m", 1);
_L20:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.CONNECT_ERROR, jsonobject1));
_L19:
        InterstitialView.k(interstitialview).doCancel();
        InterstitialView.a(interstitialview, 101, .AD_FETCH_TIMEOUT);
        return;
        JSONException jsonexception1;
        jsonexception1;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for error at ")).append(System.currentTimeMillis()).toString());
          goto _L20
_L4:
        if (!InterstitialView.d(interstitialview)) goto _L22; else goto _L21
_L21:
        long l;
        JSONObject jsonobject;
        l = System.currentTimeMillis() - InterstitialView.j(interstitialview);
        jsonobject = new JSONObject();
        jsonobject.put("ad", InterstitialView.e(interstitialview));
        jsonobject.put("t", l);
_L23:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_COMPLETE, jsonobject));
_L22:
        removeMessages(307);
        InterstitialView.a(interstitialview, ate.READY);
        InterstitialView.a(interstitialview, 100, null);
        return;
        JSONException jsonexception;
        jsonexception;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for RENDER_COMPLETE at ")).append(System.currentTimeMillis()).toString());
          goto _L23
_L5:
        InterstitialView.a(interstitialview, ate.INIT);
        InterstitialView.a(interstitialview, 103, null);
        InterstitialView.a(interstitialview, null);
        return;
_L6:
        InterstitialView.a(interstitialview, ate.ACTIVE);
        InterstitialView.a(interstitialview, 102, null);
_L2:
    }

    public ponseManager(InterstitialView interstitialview)
    {
        a = new WeakReference(interstitialview);
    }
}
