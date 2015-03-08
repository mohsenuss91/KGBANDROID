// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.f.a;
import com.appyet.manager.d;

// Referenced classes of package com.appyet.c:
//            r

final class ah extends a
{

    final r a;

    ah(r r1)
    {
        a = r1;
        super();
    }

    private transient Void f()
    {
        try
        {
            a.a.h.d(a.a.n.b);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return null;
    }

    protected final void a()
    {
        super.a();
        r.c(a);
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        a.c();
        r.b(a);
        ((MainActivity)a.getSherlockActivity()).c();
    }

    protected final Object b()
    {
        return f();
    }
}
