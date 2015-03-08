// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;

import com.inmobi.commons.internal.Log;
import java.net.HttpURLConnection;

// Referenced classes of package com.inmobi.androidsdk.impl.net:
//            RequestResponseManager

class a extends Thread
{

    final RequestResponseManager a;

    public void run()
    {
        try
        {
            RequestResponseManager.a(a).disconnect();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Exception in closing connection ", exception);
        }
    }

    (RequestResponseManager requestresponsemanager)
    {
        a = requestresponsemanager;
        super();
    }
}
