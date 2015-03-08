// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.os.Handler;
import android.os.Message;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NetworkEventType;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.androidsdk:
//            BannerView, g

class a extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        BannerView bannerview = (BannerView)a.get();
        if (bannerview == null) goto _L2; else goto _L1
_L1:
        int i = message.what;
        i;
        JVM INSTR tableswitch 101 111: default 80
    //                   101 595
    //                   102 746
    //                   103 80
    //                   104 754
    //                   105 764
    //                   106 774
    //                   107 468
    //                   108 296
    //                   109 86
    //                   110 245
    //                   111 272;
           goto _L3 _L4 _L5 _L3 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L3:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_774;
_L2:
        super.handleMessage(message);
        return;
_L11:
        long l3 = System.currentTimeMillis() - BannerView.b(bannerview);
        if (!BannerView.c(bannerview)) goto _L15; else goto _L14
_L14:
        JSONObject jsonobject3 = new JSONObject();
        jsonobject3.put("ad", BannerView.d(bannerview));
        jsonobject3.put("t", l3);
_L16:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.FETCH_COMPLETE, jsonobject3));
_L15:
        Exception exception;
        removeMessages(107);
        if (BannerView.e(bannerview) != null)
        {
            BannerView.a(bannerview, BannerView.e(bannerview).replace("@__imm_aft@", (new StringBuilder()).append(l3).toString()));
        }
        BannerView.b(bannerview, BannerView.e(bannerview));
          goto _L2
        JSONException jsonexception3;
        jsonexception3;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
          goto _L16
_L12:
        try
        {
            removeMessages(107);
            BannerView.a(bannerview, 101, (orCode)message.obj);
            BannerView.a(bannerview, false);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Exception hanlde message adview", exception);
        }
          goto _L2
_L13:
        removeMessages(108);
        removeMessages(101);
        BannerView.a(bannerview, 101, orCode.INTERNAL_ERROR);
          goto _L2
_L10:
        if (!BannerView.c(bannerview)) goto _L18; else goto _L17
_L17:
        long l2;
        JSONObject jsonobject2;
        l2 = System.currentTimeMillis() - BannerView.f(bannerview);
        jsonobject2 = new JSONObject();
        jsonobject2.put("ad", BannerView.d(bannerview));
        jsonobject2.put("t", l2);
_L19:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_TIMEOUT, jsonobject2));
_L18:
        IMWebView imwebview;
        removeMessages(111);
        removeMessages(101);
        BannerView.a(bannerview, false);
        if (!BannerView.g(bannerview))
        {
            break MISSING_BLOCK_LABEL_453;
        }
        imwebview = BannerView.h(bannerview);
        BannerView.a(bannerview, null);
_L20:
        imwebview.cancelLoad();
        imwebview.stopLoading();
        imwebview.deinit();
        BannerView.a(bannerview, 101, orCode.AD_RENDERING_TIMEOUT);
          goto _L2
        JSONException jsonexception2;
        jsonexception2;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
          goto _L19
        imwebview = BannerView.i(bannerview);
        BannerView.b(bannerview, null);
          goto _L20
_L9:
        long l1;
        removeMessages(109);
        removeMessages(110);
        BannerView.j(bannerview).doCancel();
        l1 = System.currentTimeMillis() - BannerView.b(bannerview);
        if (!BannerView.c(bannerview)) goto _L22; else goto _L21
_L21:
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("t", l1);
        jsonobject1.put("m", 1);
_L23:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.CONNECT_ERROR, jsonobject1));
_L22:
        BannerView.a(bannerview, false);
        BannerView.a(bannerview, 101, orCode.AD_FETCH_TIMEOUT);
          goto _L2
        JSONException jsonexception1;
        jsonexception1;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for error at ")).append(System.currentTimeMillis()).toString());
          goto _L23
_L4:
        if (!BannerView.c(bannerview)) goto _L25; else goto _L24
_L24:
        long l;
        JSONObject jsonobject;
        l = System.currentTimeMillis() - BannerView.b(bannerview);
        jsonobject = new JSONObject();
        jsonobject.put("ad", BannerView.d(bannerview));
        jsonobject.put("t", l);
_L26:
        Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_COMPLETE, jsonobject));
_L25:
        removeMessages(108);
        if (!BannerView.k(bannerview))
        {
            break MISSING_BLOCK_LABEL_715;
        }
        BannerView.l(bannerview);
        BannerView.b(bannerview, false);
          goto _L2
        JSONException jsonexception;
        jsonexception;
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
          goto _L26
label0:
        {
            if (BannerView.m(bannerview) != AnimationType.ANIMATION_OFF)
            {
                break label0;
            }
            BannerView.l(bannerview);
        }
          goto _L2
        BannerView.n(bannerview).a(BannerView.m(bannerview));
          goto _L2
_L5:
        BannerView.c(bannerview, false);
          goto _L2
_L6:
        BannerView.a(bannerview, 103, null);
          goto _L2
_L7:
        BannerView.a(bannerview, 102, null);
          goto _L2
        BannerView.a(bannerview, 104, null);
          goto _L2
    }

    public estResponseManager(BannerView bannerview)
    {
        a = new WeakReference(bannerview);
    }
}
