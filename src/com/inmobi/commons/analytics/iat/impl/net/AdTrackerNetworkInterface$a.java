// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.internal.Log;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface

final class a
    implements Runnable
{

    final String a;

    public final void run()
    {
_L1:
        if (AdTrackerNetworkInterface.c().get())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        AdTrackerNetworkInterface.d().saveGoals();
        AdTrackerNetworkInterface.c().set(true);
        if (AdTrackerNetworkInterface.d() == null || AdTrackerNetworkInterface.d().isEmpty())
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "GoalList Empty");
            AdTrackerNetworkInterface.deinit();
            return;
        }
        try
        {
            for (; !AdTrackerNetworkInterface.d().isEmpty(); AdTrackerNetworkInterface.a(a)) { }
        }
        catch (Exception exception1)
        {
            try
            {
                AdTrackerNetworkInterface.deinit();
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Exception reporting goals", exception);
            }
            return;
        }
        AdTrackerNetworkInterface.e().set(false);
          goto _L1
        AdTrackerNetworkInterface.deinit();
        return;
    }

    (String s)
    {
        a = s;
        super();
    }
}
