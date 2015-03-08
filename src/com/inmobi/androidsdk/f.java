// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.os.Message;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NetworkEventType;
import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.Response;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.androidsdk:
//            InterstitialView

class f
    implements HttpRequestCallback
{

    final InterstitialView a;

    f(InterstitialView interstitialview)
    {
        a = interstitialview;
        super();
    }

    public void notifyResult(int i, Object obj)
    {
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder(">>> Got HTTP REQUEST callback. Status: ")).append(i).toString());
        if (i != 0) goto _L2; else goto _L1
_L1:
        InterstitialView.a(a, ((Response)obj).getAdResponse());
        InterstitialView.b(a, ((Response)obj).getImpressionId());
        InterstitialView.b(a).sendEmptyMessage(308);
_L4:
        return;
_L2:
        if (i != 1) goto _L4; else goto _L3
_L3:
        long l;
        Message message;
        l = System.currentTimeMillis() - InterstitialView.c(a);
        message = InterstitialView.b(a).obtainMessage(309);
        if (!(obj instanceof AdException)) goto _L6; else goto _L5
_L5:
        AdRequest.ErrorCode errorcode;
        AdException adexception = (AdException)obj;
        AdRequest.ErrorCode errorcode1 = adexception.getErrorCode();
        if (InterstitialView.d(a))
        {
            JSONObject jsonobject1 = new JSONObject();
            try
            {
                jsonobject1.put("ad", adexception.getImpressionId());
                jsonobject1.put("t", l);
                jsonobject1.put("m", adexception.getHttpCode());
            }
            catch (JSONException jsonexception1)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for error at ")).append(System.currentTimeMillis()).toString());
            }
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RESPONSE_ERROR, jsonobject1));
        }
        errorcode = errorcode1;
_L8:
        message.obj = errorcode;
        message.sendToTarget();
        return;
_L6:
        errorcode = (AdRequest.ErrorCode)obj;
        int j = errorcode.getErrorCode();
        if (InterstitialView.d(a))
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("t", l);
                jsonobject.put("m", j);
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for error at ")).append(System.currentTimeMillis()).toString());
            }
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.CONNECT_ERROR, jsonobject));
        }
        if (true) goto _L8; else goto _L7
_L7:
    }
}
