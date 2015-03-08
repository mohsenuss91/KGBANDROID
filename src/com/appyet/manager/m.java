// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.appyet.data.Feed;
import com.appyet.data.FeedItem;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class m
    implements Callable
{

    final boolean a = true;
    final FeedItem b;
    final d c;

    m(d d1, FeedItem feeditem)
    {
        c = d1;
        b = feeditem;
        super();
    }

    public final Object call()
    {
        Dao dao = c.b.getFeedItemDao();
        String s = "1";
        if (!a)
        {
            s = "0";
        }
        String as[] = new String[3];
        as[0] = s;
        as[1] = s;
        as[2] = String.valueOf(b.getFeedItemId());
        dao.updateRaw("UPDATE FeedItem SET IsDeleted = ? WHERE IsDeleted <> ? AND FeedItemId = ?", as);
        d.a(c, b.getFeed().getFeedId().longValue());
        return null;
    }
}
