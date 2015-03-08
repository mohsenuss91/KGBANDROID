// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import java.util.Timer;

public class RetryMechanism
{

    private Timer a;
    private int b;
    private int c;
    private int d;

    public RetryMechanism(int i, int j, Timer timer)
    {
        b = 0;
        c = 0;
        d = 1000;
        c = i;
        d = j;
        a = timer;
    }

    static int a(RetryMechanism retrymechanism)
    {
        int i = retrymechanism.b;
        retrymechanism.b = i + 1;
        return i;
    }

    private void a(RetryRunnable retryrunnable, int i)
    {
        a.schedule(new a(retryrunnable), i);
    }

    static void a(RetryMechanism retrymechanism, RetryRunnable retryrunnable, int i)
    {
        retrymechanism.a(retryrunnable, i);
    }

    static int b(RetryMechanism retrymechanism)
    {
        return retrymechanism.b;
    }

    static int c(RetryMechanism retrymechanism)
    {
        return retrymechanism.c;
    }

    static int d(RetryMechanism retrymechanism)
    {
        return retrymechanism.d;
    }

    public void rescheduleTimer(RetryRunnable retryrunnable)
    {
        b = 0;
        a(retryrunnable, 0);
    }

    private class a extends TimerTask
    {

        final RetryRunnable a;
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

        a(RetryRunnable retryrunnable)
        {
            b = RetryMechanism.this;
            a = retryrunnable;
            super();
        }

        private class RetryRunnable
        {

            public abstract void completed();

            public abstract void run();
        }

    }

}
