// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import com.appyet.context.ApplicationContext;
import com.appyet.context.d;
import com.appyet.context.f;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            r, z, ae

final class al extends a
{

    final r a;
    private List b;

    public al(r r1)
    {
        a = r1;
        super();
    }

    private transient Void f()
    {
        f f1 = a.a.n;
        f1.i = 1 + f1.i;
        if (com.appyet.c.r.a(a) == null || a.a.n.j) goto _L2; else goto _L1
_L1:
        com.appyet.c.z.a[a.a.n.g.ordinal()];
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
        b = a.a.h.a(a.c, 100L, 100L * (long)a.a.n.i);
        break; /* Loop/switch isn't completed */
_L5:
        try
        {
            b = a.a.h.a(100L, 100L * (long)a.a.n.i);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            break; /* Loop/switch isn't completed */
        }
        break; /* Loop/switch isn't completed */
_L6:
        b = a.a.h.a(a.a.n.h, 100L, 100L * (long)a.a.n.i);
        break; /* Loop/switch isn't completed */
_L7:
        b = a.a.n.a(100L, 100L * (long)a.a.n.i);
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
        if (b != null && b.size() != 0) goto _L2; else goto _L1
_L1:
        a.a.n.j = true;
_L3:
        a.d();
        return;
_L2:
        try
        {
            FeedItem feeditem;
            for (Iterator iterator = b.iterator(); iterator.hasNext(); com.appyet.c.r.a(a).add(feeditem))
            {
                feeditem = (FeedItem)iterator.next();
            }

        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        a.a.n.b.addAll(b);
        com.appyet.c.r.d(a, a.a.n.b.size());
        if ((long)b.size() < 100L)
        {
            a.a.n.j = true;
        }
          goto _L3
    }

    protected final Object b()
    {
        return f();
    }
}
