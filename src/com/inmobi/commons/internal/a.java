// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import java.util.List;

// Referenced classes of package com.inmobi.commons.internal:
//            ActivityRecognitionManager, ActivityRecognitionSampler

final class a extends Handler
{

    a(Looper looper)
    {
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        int i = ActivityRecognitionManager.getDetectedActivity();
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((long)ActivityRecognitionSampler.d.size() > AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionMaxSize())
        {
            continue; /* Loop/switch isn't completed */
        }
        ActivityRecognitionSampler.d.add(new ActivityRecognitionSampler.ActivitySample(i, System.currentTimeMillis()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        ActivityRecognitionSampler.a();
        return;
    }
}
