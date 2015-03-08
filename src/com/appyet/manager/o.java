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

final class o
    implements Callable
{

    final boolean a;
    final FeedItem b;
    final d c;

    o(d d1, boolean flag, FeedItem feeditem)
    {
        c = d1;
        a = flag;
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
        String as[] = new String[2];
        as[0] = s;
        as[1] = String.valueOf(b.getFeedItemId());
        dao.updateRaw("UPDATE FeedItem SET IsRead = ? WHERE FeedItemId = ?", as);
        d.a(c, b.getFeed().getFeedId().longValue());
        return null;
    }
}
