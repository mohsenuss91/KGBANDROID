// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import com.appyet.manager.d;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            a

final class h extends a
{

    final com.appyet.c.a a;

    h(com.appyet.c.a a1)
    {
        a = a1;
        super();
    }

    private transient Void f()
    {
        if (com.appyet.c.a.a(a).n.b == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = new ArrayList();
        int i = 0;
_L7:
        if (i >= com.appyet.c.a.a(a).n.b.size()) goto _L4; else goto _L3
_L3:
        FeedItem feeditem = (FeedItem)com.appyet.c.a.a(a).n.b.get(i);
        if (feeditem.getFlag() == com.appyet.data.FeedItem.FlagEnum.Update && !feeditem.getIsDeleted())
        {
            arraylist.add(feeditem);
            feeditem.setFlag(com.appyet.data.FeedItem.FlagEnum.None);
        }
          goto _L5
_L4:
        try
        {
            if (arraylist.size() > 0)
            {
                com.appyet.c.a.a(a).h.d(arraylist);
                ((MainActivity)a.getSherlockActivity()).c();
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
_L2:
        return null;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
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
