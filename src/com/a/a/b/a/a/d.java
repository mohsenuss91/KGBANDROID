// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a.a;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.a.a.b.a.a:
//            a, g, f

public class d extends AbstractQueue
    implements a, Serializable
{

    transient g a;
    transient g b;
    final ReentrantLock c;
    private transient int d;
    private final int e;
    private final Condition f;
    private final Condition g;

    public d()
    {
        this((byte)0);
    }

    private d(byte byte0)
    {
        c = new ReentrantLock();
        f = c.newCondition();
        g = c.newCondition();
        e = 0x7fffffff;
    }

    private Object a(long l, TimeUnit timeunit)
    {
        ReentrantLock reentrantlock;
        long l2;
        long l1 = timeunit.toNanos(l);
        reentrantlock = c;
        reentrantlock.lockInterruptibly();
        l2 = l1;
_L2:
        Object obj = b();
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l2 <= 0L)
        {
            reentrantlock.unlock();
            return null;
        }
        long l3 = f.awaitNanos(l2);
        l2 = l3;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return obj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    private boolean a(Object obj, long l, TimeUnit timeunit)
    {
        g g1;
        long l1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        g1 = new g(obj);
        l1 = timeunit.toNanos(l);
        reentrantlock = c;
        reentrantlock.lockInterruptibly();
_L2:
        boolean flag = b(g1);
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (l1 <= 0L)
        {
            reentrantlock.unlock();
            return false;
        }
        long l2 = g.awaitNanos(l1);
        l1 = l2;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return true;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    private Object b()
    {
        g g1 = a;
        if (g1 == null)
        {
            return null;
        }
        g g2 = g1.c;
        Object obj = g1.a;
        g1.a = null;
        g1.c = g1;
        a = g2;
        if (g2 == null)
        {
            b = null;
        } else
        {
            g2.b = null;
        }
        d = -1 + d;
        g.signal();
        return obj;
    }

    private boolean b(g g1)
    {
        if (d >= e)
        {
            return false;
        }
        g g2 = b;
        g1.b = g2;
        b = g1;
        if (a == null)
        {
            a = g1;
        } else
        {
            g2.c = g1;
        }
        d = 1 + d;
        f.signal();
        return true;
    }

    private boolean b(Object obj)
    {
        g g1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        g1 = new g(obj);
        reentrantlock = c;
        reentrantlock.lock();
        boolean flag = b(g1);
        reentrantlock.unlock();
        return flag;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    private Object c()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object obj = b();
        reentrantlock.unlock();
        return obj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    private boolean c(Object obj)
    {
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            return false;
        }
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
_L2:
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!obj.equals(g1.a))
        {
            break MISSING_BLOCK_LABEL_50;
        }
        a(g1);
        reentrantlock.unlock();
        return true;
        g1 = g1.c;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return false;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    private Object d()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
_L1:
        Object obj = b();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        f.await();
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        reentrantlock.unlock();
        return obj;
    }

    private Object e()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
        if (g1 != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        reentrantlock.unlock();
        return obj;
_L2:
        obj = a.a;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public final Object a()
    {
        Object obj = c();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    final void a(g g1)
    {
        g g2 = g1.b;
        g g3 = g1.c;
        if (g2 == null)
        {
            b();
        } else
        if (g3 == null)
        {
            g g4 = b;
            if (g4 != null)
            {
                g g5 = g4.b;
                Object _tmp = g4.a;
                g4.a = null;
                g4.b = g4;
                b = g5;
                if (g5 == null)
                {
                    a = null;
                } else
                {
                    g5.c = null;
                }
                d = -1 + d;
                g.signal();
                return;
            }
        } else
        {
            g2.c = g3;
            g3.b = g2;
            g1.a = null;
            d = -1 + d;
            g.signal();
            return;
        }
    }

    public final boolean a(Object obj)
    {
        g g1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        g1 = new g(obj);
        reentrantlock = c;
        reentrantlock.lock();
        int i;
        int j;
        i = d;
        j = e;
        if (i < j) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L5:
        reentrantlock.unlock();
        return flag;
_L2:
        g g2;
        g2 = a;
        g1.c = g2;
        a = g1;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        b = g1;
_L3:
        d = 1 + d;
        f.signal();
        flag = true;
        continue; /* Loop/switch isn't completed */
        g2.b = g1;
          goto _L3
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean add(Object obj)
    {
        if (!b(obj))
        {
            throw new IllegalStateException("Deque full");
        } else
        {
            return true;
        }
    }

    public void clear()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
_L2:
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        g g2;
        g1.a = null;
        g2 = g1.c;
        g1.b = null;
        g1.c = null;
        g1 = g2;
        if (true) goto _L2; else goto _L1
_L1:
        b = null;
        a = null;
        d = 0;
        g.signalAll();
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean contains(Object obj)
    {
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            return false;
        }
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
_L2:
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = obj.equals(g1.a);
        if (flag)
        {
            reentrantlock.unlock();
            return true;
        }
        g1 = g1.c;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return false;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public int drainTo(Collection collection)
    {
        return drainTo(collection, 0x7fffffff);
    }

    public int drainTo(Collection collection, int i)
    {
        ReentrantLock reentrantlock;
        if (collection == null)
        {
            throw new NullPointerException();
        }
        if (collection == this)
        {
            throw new IllegalArgumentException();
        }
        reentrantlock = c;
        reentrantlock.lock();
        int j = Math.min(i, d);
        int k = 0;
_L2:
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        collection.add(a.a);
        b();
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return j;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object element()
    {
        Object obj = e();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public Iterator iterator()
    {
        return new f(this, (byte)0);
    }

    public boolean offer(Object obj)
    {
        return b(obj);
    }

    public boolean offer(Object obj, long l, TimeUnit timeunit)
    {
        return a(obj, l, timeunit);
    }

    public Object peek()
    {
        return e();
    }

    public Object poll()
    {
        return c();
    }

    public Object poll(long l, TimeUnit timeunit)
    {
        return a(l, timeunit);
    }

    public void put(Object obj)
    {
        g g1;
        ReentrantLock reentrantlock;
        if (obj == null)
        {
            throw new NullPointerException();
        }
        g1 = new g(obj);
        reentrantlock = c;
        reentrantlock.lock();
        for (; !b(g1); g.await()) { }
        break MISSING_BLOCK_LABEL_59;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
        reentrantlock.unlock();
        return;
    }

    public int remainingCapacity()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        int i;
        int j;
        i = e;
        j = d;
        int k = i - j;
        reentrantlock.unlock();
        return k;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object remove()
    {
        return a();
    }

    public boolean remove(Object obj)
    {
        return c(obj);
    }

    public int size()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        int i = d;
        reentrantlock.unlock();
        return i;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object take()
    {
        return d();
    }

    public Object[] toArray()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        Object aobj[] = new Object[d];
        int i = 0;
        g g1 = a;
_L2:
        int j;
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i + 1;
        aobj[i] = g1.a;
        g1 = g1.c;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        reentrantlock.unlock();
        return aobj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public Object[] toArray(Object aobj[])
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        if (aobj.length < d)
        {
            aobj = (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), d);
        }
        int i = 0;
        g g1 = a;
_L2:
        int j;
        if (g1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i + 1;
        aobj[i] = g1.a;
        g1 = g1.c;
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        if (aobj.length > i)
        {
            aobj[i] = null;
        }
        reentrantlock.unlock();
        return aobj;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public String toString()
    {
        ReentrantLock reentrantlock;
        reentrantlock = c;
        reentrantlock.lock();
        g g1 = a;
        if (g1 == null)
        {
            reentrantlock.unlock();
            return "[]";
        }
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        stringbuilder.append('[');
        g g2 = g1;
_L1:
        Object obj = g2.a;
        if (obj == this)
        {
            obj = "(this Collection)";
        }
        g g3;
        stringbuilder.append(obj);
        g3 = g2.c;
        if (g3 != null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        String s = stringbuilder.append(']').toString();
        reentrantlock.unlock();
        return s;
        stringbuilder.append(',').append(' ');
        g2 = g3;
          goto _L1
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }
}
