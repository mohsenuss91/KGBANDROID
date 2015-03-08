// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import java.io.IOException;
import java.net.SocketTimeoutException;

// Referenced classes of package com.inmobi.androidsdk.impl.net:
//            HttpRequestBuilder, RequestResponseManager, HttpRequestCallback

class d extends Thread
{

    final UserInfo a;
    final String b;
    final tionType c;
    final HttpRequestCallback d;
    final RequestResponseManager e;

    public void run()
    {
        com.inmobi.commons.thinICE.wifi.WifiInfo wifiinfo1 = IceDataCollector.getConnectedWifiInfo(a.getApplicationContext());
        com.inmobi.commons.thinICE.wifi.WifiInfo wifiinfo = wifiinfo1;
_L1:
        Exception exception;
        try
        {
            Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Ad Serving URL: ")).append(b).toString());
            String s = HttpRequestBuilder.buildPostBody(a, wifiinfo, c);
            Log.debug("[InMobi]-[Network]-4.4.1", s);
            RequestResponseManager.a(e, RequestResponseManager.a(e, b, a));
            RequestResponseManager.a(e, s);
            Response response = RequestResponseManager.a(e, a);
            RequestResponseManager.a(e, 0, response, d);
            return;
        }
        catch (AdException adexception)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Exception retrieving ad ", adexception);
            RequestResponseManager.a(e, 1, adexception, d);
            return;
        }
        catch (IOException ioexception)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Exception retrieving ad ", ioexception);
            if (ioexception instanceof SocketTimeoutException)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Server Timeout");
                RequestResponseManager.a(e, 1, com.inmobi.androidsdk.TCH_TIMEOUT, d);
                return;
            } else
            {
                RequestResponseManager.a(e, 1, com.inmobi.androidsdk.RK_ERROR, d);
                return;
            }
        }
        catch (Exception exception1)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Exception retrieving ad ", exception1);
        }
        break MISSING_BLOCK_LABEL_225;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "No wifi permissions set, unable to send wifi data");
        wifiinfo = null;
          goto _L1
        RequestResponseManager.a(e, 1, com.inmobi.androidsdk.NAL_ERROR, d);
        return;
    }

    tionType(RequestResponseManager requestresponsemanager, UserInfo userinfo, String s, tionType tiontype, HttpRequestCallback httprequestcallback)
    {
        e = requestresponsemanager;
        a = userinfo;
        b = s;
        c = tiontype;
        d = httprequestcallback;
        super();
    }
}
