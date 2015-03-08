// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import java.util.ArrayList;

// Referenced classes of package com.google.android.youtube.player.internal:
//            r

public abstract class b
{

    final r a;
    private Object b;

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = b;
        this;
        JVM INSTR monitorexit ;
        a(obj);
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract void a(Object obj);

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        b = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (r r1, Object obj)
    {
        a = r1;
        super();
        b = obj;
        synchronized (r.c(r1))
        {
            r.c(r1).add(this);
        }
    }
}
