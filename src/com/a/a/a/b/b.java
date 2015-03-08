// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.c.d;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.a.a.a.b:
//            a

public abstract class b extends a
{

    private final int a;
    private final AtomicInteger b = new AtomicInteger();
    private final List c = Collections.synchronizedList(new LinkedList());

    public b(int i)
    {
        a = i;
        if (i > 0x1000000)
        {
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(16);
            com.a.a.c.d.c("You set too large memory cache size (more than %1$d Mb)", aobj);
        }
    }

    public boolean a(Object obj, Object obj1)
    {
        int i = d(obj1);
        int j = a;
        int k = b.get();
        boolean flag = false;
        if (i < j)
        {
            int l = k;
            do
            {
                if (l + i <= j)
                {
                    break;
                }
                Object obj2 = c();
                if (c.remove(obj2))
                {
                    l = b.addAndGet(-d(obj2));
                }
            } while (true);
            c.add(obj1);
            b.addAndGet(i);
            flag = true;
        }
        super.a(obj, obj1);
        return flag;
    }

    public void b()
    {
        c.clear();
        b.set(0);
        super.b();
    }

    public void b(Object obj)
    {
        Object obj1 = super.a(obj);
        if (obj1 != null && c.remove(obj1))
        {
            b.addAndGet(-d(obj1));
        }
        super.b(obj);
    }

    protected abstract Object c();

    protected abstract int d(Object obj);
}
