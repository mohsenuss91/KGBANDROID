// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class l
    implements Callable
{

    final Integer a;
    final Long b;
    final d c;

    l(d d1, Integer integer, Long long1)
    {
        c = d1;
        a = integer;
        b = long1;
        super();
    }

    public final Object call()
    {
        Dao dao = c.b.getFeedItemDao();
        String as[] = new String[2];
        as[0] = a.toString();
        as[1] = String.valueOf(b);
        dao.updateRaw("UPDATE FeedItem SET EnclosureDuration = ? WHERE FeedItemId = ?", as);
        return null;
    }
}
