// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.imai;

import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.androidsdk.impl.imai:
//            IMAICore

class a
    implements HttpRequestCallback
{

    final a a;

    public void notifyResult(int i, Object obj)
    {
        Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Got PING callback. Status: ")).append(i).toString());
        if (i == 0)
        {
            try
            {
                IMAICore.firePingSuccessful(a.a, a.a);
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception", exception);
            }
            break MISSING_BLOCK_LABEL_74;
        }
        IMAICore.fireErrorEvent(a.a, "IMAI Ping in http client failed", "ping", a.a);
        return;
    }

    lback(lback lback)
    {
        a = lback;
        super();
    }
}
