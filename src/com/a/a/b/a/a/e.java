// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.a.a.b.a.a:
//            d, g

abstract class e
    implements Iterator
{

    g a;
    Object b;
    final d c;
    private g d;

    e(d d1)
    {
        ReentrantLock reentrantlock;
        c = d1;
        super();
        reentrantlock = d1.c;
        reentrantlock.lock();
        a = a();
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Object obj = null;
_L1:
        b = obj;
        reentrantlock.unlock();
        return;
        obj = a.a;
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    private void b()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c.c;
        reentrantlock.lock();
        g g1 = a;
_L6:
        g g2 = a(g1);
        if (g2 != null) goto _L2; else goto _L1
_L1:
        g2 = null;
_L4:
        g g3;
        a = g2;
        g3 = a;
        Object obj;
        obj = null;
        if (g3 != null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
_L5:
        b = obj;
        reentrantlock.unlock();
        return;
_L2:
        if (g2.a != null) goto _L4; else goto _L3
_L3:
        if (g2 != g1)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        g2 = a();
          goto _L4
        obj = a.a;
          goto _L5
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        g1 = g2;
          goto _L6
    }

    abstract g a();

    abstract g a(g g1);

    public boolean hasNext()
    {
        return a != null;
    }

    public Object next()
    {
        if (a == null)
        {
            throw new NoSuchElementException();
        } else
        {
            d = a;
            Object obj = b;
            b();
            return obj;
        }
    }

    public void remove()
    {
        g g1;
        ReentrantLock reentrantlock;
        g1 = d;
        if (g1 == null)
        {
            throw new IllegalStateException();
        }
        d = null;
        reentrantlock = c.c;
        reentrantlock.lock();
        if (g1.a != null)
        {
            c.a(g1);
        }
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
