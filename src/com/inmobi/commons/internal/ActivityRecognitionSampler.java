// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.inmobi.commons.internal:
//            a

public class ActivityRecognitionSampler
{

    static HandlerThread a;
    static Looper b;
    static Handler c;
    static List d = new ArrayList();

    public ActivityRecognitionSampler()
    {
    }

    static void a()
    {
        b();
    }

    private static void b()
    {
        if (AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled())
        {
            android.os.Message message = c.obtainMessage(1);
            c.sendMessageDelayed(message, AnalyticsInitializer.getConfigParams().getThinIceConfig().getActivityDetectionInterval());
        }
    }

    public static List getCollectedList()
    {
        if (AnalyticsInitializer.getConfigParams().getThinIceConfig().isActivityDetectionEnabled())
        {
            return d;
        } else
        {
            return Collections.emptyList();
        }
    }

    public static void start()
    {
        if (c.hasMessages(1))
        {
            return;
        } else
        {
            c.sendEmptyMessage(1);
            return;
        }
    }

    public static void stop()
    {
        c.removeMessages(1);
        d.clear();
    }

    static 
    {
        HandlerThread handlerthread = new HandlerThread("ActivityDetectionSampler");
        a = handlerthread;
        handlerthread.start();
        b = a.getLooper();
        c = new a(b);
    }
}
