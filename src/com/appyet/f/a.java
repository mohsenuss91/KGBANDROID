// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.appyet.f:
//            b, g, h, c, 
//            d, f, e, i

public abstract class a
{

    private static final ThreadFactory a;
    private static final BlockingQueue b;
    private static final g c = new g((byte)0);
    private static volatile Executor d;
    public static final Executor e;
    private final i f = new c(this);
    private final FutureTask g;
    private volatile h h;
    private final AtomicBoolean i = new AtomicBoolean();

    public a()
    {
        h = h.a;
        g = new d(this, f);
    }

    static Object a(a a1, Object obj)
    {
        return a1.b(obj);
    }

    static AtomicBoolean a(a a1)
    {
        return a1.i;
    }

    private Object b(Object obj)
    {
        c.obtainMessage(1, new f(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    static void b(a a1, Object obj)
    {
        if (!a1.i.get())
        {
            a1.b(obj);
        }
    }

    static void c(a a1, Object obj)
    {
        if (!a1.g.isCancelled())
        {
            a1.a(obj);
        }
        a1.h = h.c;
    }

    public final transient a a(Object aobj[])
    {
        Executor executor = d;
        if (h == h.a) goto _L2; else goto _L1
_L1:
        e.a[h.ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 79
    //                   2 89;
           goto _L2 _L3 _L4
_L2:
        h = h.b;
        a();
        f.b = aobj;
        executor.execute(g);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public void a()
    {
    }

    public void a(Object obj)
    {
    }

    protected transient abstract Object b();

    protected transient void c()
    {
    }

    public final h d()
    {
        return h;
    }

    public final boolean e()
    {
        return g.cancel(true);
    }

    static 
    {
        a = new b();
        b = new LinkedBlockingQueue(10);
        e = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, a);
        d = e;
    }
}
