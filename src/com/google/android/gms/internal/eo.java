// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.internal:
//            ev

public final class eo
{

    private static final ThreadFactory se;
    private static final ThreadPoolExecutor sf;

    public static void execute(Runnable runnable)
    {
        try
        {
            sf.execute(new _cls1(runnable));
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            ev.c((new StringBuilder("Too many background threads already running. Aborting task.  Current pool size: ")).append(getPoolSize()).toString(), rejectedexecutionexception);
        }
    }

    public static int getPoolSize()
    {
        return sf.getPoolSize();
    }

    static 
    {
        se = new _cls2();
        sf = new ThreadPoolExecutor(0, 10, 65L, TimeUnit.SECONDS, new SynchronousQueue(true), se);
    }

    private class _cls1
        implements Runnable
    {

        final Runnable sg;

        public final void run()
        {
            Process.setThreadPriority(10);
            sg.run();
        }

        _cls1(Runnable runnable)
        {
            sg = runnable;
            super();
        }
    }


    private class _cls2
        implements ThreadFactory
    {

        private final AtomicInteger sh = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable)
        {
            return new Thread(runnable, (new StringBuilder("AdWorker #")).append(sh.getAndIncrement()).toString());
        }

        _cls2()
        {
        }
    }

}
