// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a extends Thread
{

    final String a;
    final JSUtilityController b;

    public void run()
    {
        HttpURLConnection httpurlconnection = null;
        HttpURLConnection httpurlconnection1;
        String s = a.replaceAll("%25", "%");
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Pinging URL: ")).append(s).toString());
        httpurlconnection1 = (HttpURLConnection)(new URL(s)).openConnection();
        httpurlconnection1.setConnectTimeout(20000);
        httpurlconnection1.setRequestMethod("GET");
        InternalSDKUtil.addCommonPropertiesToConnection(httpurlconnection1);
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Async Ping Connection Response Code: ")).append(httpurlconnection1.getResponseCode()).toString());
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
        }
_L2:
        return;
        Exception exception1;
        exception1;
_L5:
        Log.debug("[InMobi]-[RE]-4.4.1", "Error doing async Ping. ", exception1);
        if (httpurlconnection == null) goto _L2; else goto _L1
_L1:
        httpurlconnection.disconnect();
        return;
        Exception exception;
        exception;
_L4:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw exception;
        Exception exception3;
        exception3;
        httpurlconnection = httpurlconnection1;
        exception = exception3;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception2;
        exception2;
        httpurlconnection = httpurlconnection1;
        exception1 = exception2;
          goto _L5
    }

    (JSUtilityController jsutilitycontroller, String s)
    {
        b = jsutilitycontroller;
        a = s;
        super();
    }
}
