// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.data.DatabaseHelper;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import com.j256.ormlite.misc.TransactionManager;

// Referenced classes of package com.appyet.manager:
//            as, d, k

final class bi extends a
{

    final as a;
    private int b;

    public bi(as as1, int i)
    {
        a = as1;
        super();
        b = i;
    }

    private transient Void f()
    {
        com.appyet.manager.d d1;
        Long long1;
        Integer integer;
        if (as.f(a) == null || as.h(a) == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        d1 = as.g(a).h;
        long1 = as.h(a).getFeedItemId();
        integer = Integer.valueOf(b);
        TransactionManager.callInTransaction(d1.b.getConnectionSource(), new k(d1, integer, long1));
_L2:
        return null;
        Exception exception2;
        exception2;
        d.a(exception2);
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        try
        {
            throw exception1;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void a()
    {
        super.a();
    }

    protected final volatile void a(Object obj)
    {
        super.a((Void)obj);
    }

    protected final Object b()
    {
        return f();
    }
}
