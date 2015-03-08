// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b;

import android.widget.ImageView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.a.a.b:
//            g, a

final class i
{

    final g a;
    Executor b;
    Executor c;
    ExecutorService d;
    final Map e = Collections.synchronizedMap(new HashMap());
    final AtomicBoolean f = new AtomicBoolean(false);
    final AtomicBoolean g = new AtomicBoolean(false);
    final AtomicBoolean h = new AtomicBoolean(false);
    private final Map i = new WeakHashMap();

    i(g g1)
    {
        a = g1;
        b = g1.i;
        c = g1.j;
        d = Executors.newCachedThreadPool();
    }

    private Executor b()
    {
        return com.a.a.b.a.a(a.m, a.n, a.o);
    }

    final String a(ImageView imageview)
    {
        return (String)e.get(Integer.valueOf(imageview.hashCode()));
    }

    final ReentrantLock a(String s)
    {
        ReentrantLock reentrantlock = (ReentrantLock)i.get(s);
        if (reentrantlock == null)
        {
            reentrantlock = new ReentrantLock();
            i.put(s, reentrantlock);
        }
        return reentrantlock;
    }

    final void a()
    {
        if (!a.k && ((ExecutorService)b).isShutdown())
        {
            b = b();
        }
        if (!a.l && ((ExecutorService)c).isShutdown())
        {
            c = b();
        }
    }

    final void b(ImageView imageview)
    {
        e.remove(Integer.valueOf(imageview.hashCode()));
    }
}
