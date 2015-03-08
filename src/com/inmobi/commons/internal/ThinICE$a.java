// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;

// Referenced classes of package com.inmobi.commons.internal:
//            Log, InternalSDKUtil, ThinICE

final class a
    implements com.inmobi.commons.cache.nism.RetryRunnable
{

    final String a;

    public final void completed()
    {
    }

    public final void run()
    {
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Sending ThinICE data to server ")).append(AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl()).toString());
        if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
            ThinICE.a(a);
            return;
        } else
        {
            throw new Exception("Device not connected.");
        }
    }

    KUtil(String s)
    {
        a = s;
        super();
    }
}
