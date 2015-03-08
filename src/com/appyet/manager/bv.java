// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.a;

// Referenced classes of package com.appyet.manager:
//            bq, d

final class bv extends a
{

    final bq a;
    private Long b;
    private boolean c;
    private boolean d;
    private boolean f;

    public bv(bq bq1, Long long1, boolean flag)
    {
        a = bq1;
        super();
        b = null;
        c = true;
        d = true;
        f = true;
        b = long1;
        f = flag;
    }

    private transient Void f()
    {
        try
        {
            if (d)
            {
                a.c();
            }
            if (c)
            {
                bq.g(a).h.a();
            }
            a.a(b, f);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return null;
    }

    protected final volatile void a(Object obj)
    {
    }

    protected final Object b()
    {
        return f();
    }
}
