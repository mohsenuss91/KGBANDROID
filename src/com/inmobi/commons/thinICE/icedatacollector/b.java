// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;

import android.util.Log;

// Referenced classes of package com.inmobi.commons.thinICE.icedatacollector:
//            IceDataCollector, BuildSettings

final class b
    implements Runnable
{

    b()
    {
    }

    public final void run()
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "** stop runnable");
        }
        if (IceDataCollector.a())
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "ignoring, stop not requested");
        }
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "terminating sampling and flushing");
        }
        IceDataCollector.b();
        IceDataCollector.flush();
        IceDataCollector.a(null);
        IceDataCollector.a(null);
        IceDataCollector.a(null);
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
