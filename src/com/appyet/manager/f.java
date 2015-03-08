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

public final class f
    implements Callable
{

    final List a;
    final d b;

    public f(d d1, List list)
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
            if (!feeditem.getIsDeleted() && !feeditem.getIsStar())
            {
                dao.updateRaw((new StringBuilder("UPDATE FeedItem SET IsDeleted = 1, Author = NULL, CommentsLink = NULL, Description = NULL, EnclosureCurrentPosition = NULL, EnclosureDuration = NULL, EnclosureLength = NULL, EnclosureLink = NULL, EnclosureType = NULL, Title = '', Thumbnail = NULL, Snippet = NULL, Link = NULL, Article = NULL WHERE IsDeleted <> 1 AND FeedItemId = ")).append(feeditem.getFeedItemId()).toString(), new String[0]);
            }
        } while (true);
        d.a(b);
        return null;
    }
}
