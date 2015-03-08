// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.appyet.data.FeedItem;
import com.j256.ormlite.dao.Dao;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class s
    implements Callable
{

    final List a;
    final d b;

    s(d d1, List list)
    {
        b = d1;
        a = list;
        super();
    }

    public final Object call()
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
            if (feeditem.getThumbnail() != null)
            {
                String as[] = new String[2];
                as[0] = feeditem.getThumbnail();
                as[1] = String.valueOf(feeditem.getFeedItemId());
                dao.updateRaw("UPDATE FeedItem SET Thumbnail = ? WHERE FeedItemId = ?", as);
            }
        } while (true);
        return null;
    }
}
