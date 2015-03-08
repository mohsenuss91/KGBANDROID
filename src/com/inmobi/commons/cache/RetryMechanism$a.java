// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import com.inmobi.commons.internal.Log;
import java.util.TimerTask;

// Referenced classes of package com.inmobi.commons.cache:
//            RetryMechanism

class a extends TimerTask
{

    final tryRunnable a;
    final RetryMechanism b;

    public void run()
    {
        try
        {
            a.run();
            a.completed();
            return;
        }
        catch (Exception exception)
        {
            RetryMechanism.a(b);
        }
        if (RetryMechanism.b(b) > RetryMechanism.c(b))
        {
            Log.internal("[InMobi]-4.4.1", "Exception occured while running retry mechanism and will the limit for retrying has been reached.");
            a.completed();
            return;
        } else
        {
            Log.internal("[InMobi]-4.4.1", (new StringBuilder("Exception occured while running retry mechanism and will retry in ")).append(RetryMechanism.b(b) * RetryMechanism.d(b)).append(" ms").toString());
            RetryMechanism.a(b, a, RetryMechanism.b(b) * RetryMechanism.d(b));
            return;
        }
    }

    tryRunnable(RetryMechanism retrymechanism, tryRunnable tryrunnable)
    {
        b = retrymechanism;
        a = tryrunnable;
        super();
    }
}
