// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsFunctions

public class AnalyticsEventsQueue extends Vector
{

    private static AnalyticsEventsQueue a;
    private static final long serialVersionUID = 0xee121cca029b929aL;
    private AtomicBoolean b;

    public AnalyticsEventsQueue()
    {
        b = new AtomicBoolean(false);
    }

    static void a(AnalyticsEventsQueue analyticseventsqueue, AnalyticsFunctions analyticsfunctions)
    {
        analyticsfunctions.processFunction();
    }

    private void a(AnalyticsFunctions analyticsfunctions)
    {
        analyticsfunctions.processFunction();
    }

    public static AnalyticsEventsQueue getInstance()
    {
        com/inmobi/commons/analytics/db/AnalyticsEventsQueue;
        JVM INSTR monitorenter ;
        AnalyticsEventsQueue analyticseventsqueue;
        if (a == null)
        {
            a = new AnalyticsEventsQueue();
        }
        analyticseventsqueue = a;
        com/inmobi/commons/analytics/db/AnalyticsEventsQueue;
        JVM INSTR monitorexit ;
        return analyticseventsqueue;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isEmpty()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = super.isEmpty();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        b.set(false);
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void processFunctions()
    {
        this;
        JVM INSTR monitorenter ;
        if (!b.get())
        {
            b.set(true);
            (new a()).start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private class a extends Thread
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

        a()
        {
            a = AnalyticsEventsQueue.this;
            super();
        }
    }

}
