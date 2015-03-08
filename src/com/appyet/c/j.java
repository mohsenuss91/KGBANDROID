// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import com.appyet.context.ApplicationContext;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import com.appyet.manager.bp;
import com.appyet.manager.d;

// Referenced classes of package com.appyet.c:
//            a

final class j extends a
{

    FeedItem a;
    final com.appyet.c.a b;

    public j(com.appyet.c.a a1, FeedItem feeditem)
    {
        b = a1;
        super();
        a = feeditem;
    }

    private transient Void f()
    {
        if (a == null)
        {
            return null;
        }
        if (!a.getIsStar())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        a.setIsStar(false);
        com.appyet.c.a.a(b).h.a(a.getFeedItemId().longValue(), false);
        if (a.getIsRead())
        {
            break MISSING_BLOCK_LABEL_170;
        }
        a.setIsRead(true);
        com.appyet.c.a.a(b).h.a(a, true);
        Exception exception;
        return null;
        try
        {
            a.setIsStar(true);
            com.appyet.c.a.a(b).h.a(a.getFeedItemId().longValue(), true);
            if (com.appyet.c.a.a(b).d.b())
            {
                a.setIsRead(false);
                com.appyet.c.a.a(b).h.a(a, false);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return null;
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
