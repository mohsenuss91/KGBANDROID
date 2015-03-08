// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsEventsQueue, AnalyticsFunctions

class a extends Thread
{

    final AnalyticsEventsQueue a;

    public void run()
    {
        try
        {
            for (; !a.isEmpty(); AnalyticsEventsQueue.a(a, (AnalyticsFunctions)a.remove(0))) { }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Exception processing function", exception);
        }
    }

    (AnalyticsEventsQueue analyticseventsqueue)
    {
        a = analyticseventsqueue;
        super();
    }
}
