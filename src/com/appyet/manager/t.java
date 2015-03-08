// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.d.d;
import com.appyet.data.DatabaseHelper;
import com.appyet.data.FeedItem;
import com.j256.ormlite.dao.Dao;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class t
    implements Callable
{

    final List a;
    final com.appyet.manager.d b;

    t(com.appyet.manager.d d1, List list)
    {
        b = d1;
        a = list;
        super();
    }

    private Void a()
    {
        Dao dao = b.b.getFeedItemDao();
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FeedItem feeditem = (FeedItem)iterator.next();
            if (feeditem.getCacheGuid() == null)
            {
                feeditem.setCacheGuid(UUID.randomUUID().toString().replace("-", ""));
            }
            try
            {
                if (dao.create(feeditem) != 1)
                {
                    throw new Exception("Failed on: feedItemDao.create(feedItem) != 1");
                }
            }
            catch (Exception exception)
            {
                d.a(exception);
            }
        } while (true);
        return null;
    }

    public final Object call()
    {
        return a();
    }
}
