// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import com.appyet.context.ApplicationContext;
import com.appyet.context.d;
import com.appyet.context.f;
import com.appyet.f.a;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            a, e

final class i extends a
{

    final com.appyet.c.a a;
    private List b;

    public i(com.appyet.c.a a1)
    {
        a = a1;
        super();
    }

    private transient Void f()
    {
        f f1 = com.appyet.c.a.a(a).n;
        f1.i = 1 + f1.i;
        if (com.appyet.c.a.b(a) == null || com.appyet.c.a.a(a).n.j) goto _L2; else goto _L1
_L1:
        com.appyet.c.e.a[com.appyet.c.a.a(a).n.g.ordinal()];
        JVM INSTR tableswitch 1 4: default 285
    //                   1 96
    //                   2 152
    //                   3 193
    //                   4 247;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        Exception exception;
        b = com.appyet.c.a.a(a).h.a(com.appyet.c.a.e(a), 100L, 100L * (long)com.appyet.c.a.a(a).n.i);
        break; /* Loop/switch isn't completed */
_L5:
        try
        {
            b = com.appyet.c.a.a(a).h.a(100L, 100L * (long)com.appyet.c.a.a(a).n.i);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            break; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
_L6:
        b = com.appyet.c.a.a(a).h.a(com.appyet.c.a.a(a).n.h, 100L, 100L * (long)com.appyet.c.a.a(a).n.i);
        break; /* Loop/switch isn't completed */
_L7:
        b = com.appyet.c.a.a(a).n.a(100L, 100L * (long)com.appyet.c.a.a(a).n.i);
_L2:
        return null;
    }

    protected final void a()
    {
        super.a();
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        if (b != null && b.size() != 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        com.appyet.c.a.a(a).n.j = true;
_L1:
        com.appyet.c.a.f(a);
        return;
        try
        {
            com.appyet.c.a.a(a).n.b.addAll(b);
            if ((long)b.size() < 100L)
            {
                com.appyet.c.a.a(a).n.j = true;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
          goto _L1
    }

    protected final Object b()
    {
        return f();
    }
}
