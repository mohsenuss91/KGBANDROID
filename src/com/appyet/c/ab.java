// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.data.DatabaseHelper;
import com.appyet.f.a;
import com.appyet.manager.d;
import com.appyet.manager.h;
import com.j256.ormlite.misc.TransactionManager;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            r

final class ab extends a
{

    final r a;

    ab(r r1)
    {
        a = r1;
        super();
    }

    private transient Void f()
    {
        d d1;
        List list;
        d1 = a.a.h;
        list = a.a.n.b;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        int i = list.size();
        if (i != 0)
        {
            try
            {
                TransactionManager.callInTransaction(d1.b.getConnectionSource(), new h(d1, list));
            }
            catch (Exception exception1)
            {
                try
                {
                    com.appyet.d.d.a(exception1);
                }
                catch (Exception exception)
                {
                    com.appyet.d.d.a(exception);
                }
            }
        }
        return null;
    }

    protected final void a()
    {
        super.a();
        try
        {
            r.c(a);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        try
        {
            a.c();
            r.b(a);
            ((MainActivity)a.getSherlockActivity()).c();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    protected final Object b()
    {
        return f();
    }
}
