// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class br
    implements ThreadFactory
{

    private final AtomicInteger a = new AtomicInteger(1);

    br()
    {
    }

    public final Thread newThread(Runnable runnable)
    {
        Thread thread = new Thread(runnable, (new StringBuilder("SyncThread #")).append(a.getAndIncrement()).toString());
        thread.setPriority(4);
        return thread;
    }
}
