// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.j256.ormlite.dao.Dao;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class w
    implements Callable
{

    final List a;
    final d b;

    w(d d1, List list)
    {
        b = d1;
        a = list;
        super();
    }

    public final Object call()
    {
        Dao dao = b.b.getWidgetDao();
        String as[];
        for (Iterator iterator = a.iterator(); iterator.hasNext(); dao.executeRaw("DELETE FROM Widget WHERE WidgetId = ?", as))
        {
            long l = ((Long)iterator.next()).longValue();
            as = new String[1];
            as[0] = String.valueOf(l);
        }

        return null;
    }
}
