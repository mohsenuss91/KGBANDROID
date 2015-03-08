// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d, ad

final class e
    implements Callable
{

    final int a;
    final boolean b;
    final ad c;
    final int d;
    final d e;

    e(d d1, int i, boolean flag, ad ad1, int j)
    {
        e = d1;
        a = i;
        b = flag;
        c = ad1;
        d = j;
        super();
    }

    public final Object call()
    {
        Dao dao = e.b.getFeedItemDao();
        if (a > 0)
        {
            long l1 = (new Date()).getTime() - 0x5265c00L * (long)a;
            String as1[];
            if (b)
            {
                String as3[] = (String[])dao.queryRaw((new StringBuilder("SELECT COUNT(1) FROM FeedItem WHERE IsDeleted = 0 AND IsRead = 0 AND IsStar = 0 AND PubDate < ")).append(l1).toString(), new String[0]).getResults().get(0);
                c.a = Integer.parseInt(as3[0]);
                dao.updateRaw((new StringBuilder("UPDATE FeedItem SET IsDeleted = 1, Author = NULL, CommentsLink = NULL, Description = NULL, EnclosureCurrentPosition = NULL, EnclosureDuration = NULL, EnclosureLength = NULL, EnclosureLink = NULL, EnclosureType = NULL, Title = '', Thumbnail = NULL, Snippet = NULL, Link = NULL, Article = NULL WHERE IsDeleted <> 1 AND IsRead = 0 AND IsStar = 0 AND PubDate < ")).append(l1).toString(), new String[0]);
            } else
            {
                String as2[] = (String[])dao.queryRaw((new StringBuilder("SELECT COUNT(1) FROM FeedItem WHERE IsDeleted = 0 AND IsRead = 0 AND PubDate < ")).append(l1).toString(), new String[0]).getResults().get(0);
                c.a = Integer.parseInt(as2[0]);
                dao.updateRaw((new StringBuilder("UPDATE FeedItem SET IsDeleted = 1, Author = NULL, CommentsLink = NULL, Description = NULL, EnclosureCurrentPosition = NULL, EnclosureDuration = NULL, EnclosureLength = NULL, EnclosureLink = NULL, EnclosureType = NULL, Title = '', Thumbnail = NULL, Snippet = NULL, Link = NULL, Article = NULL WHERE IsDeleted <> 1 AND IsRead = 0 AND PubDate < ")).append(l1).toString(), new String[0]);
            }
        }
        if (d > 0)
        {
            long l = (new Date()).getTime() - 0x5265c00L * (long)d;
            if (b)
            {
                as1 = (String[])dao.queryRaw((new StringBuilder("SELECT COUNT(1) FROM FeedItem WHERE IsDeleted = 0 AND IsRead = 1 AND IsStar = 0 AND PubDate < ")).append(l).toString(), new String[0]).getResults().get(0);
                c.a = Integer.parseInt(as1[0]);
                dao.updateRaw((new StringBuilder("UPDATE FeedItem SET IsDeleted = 1, Author = NULL, CommentsLink = NULL, Description = NULL, EnclosureCurrentPosition = NULL, EnclosureDuration = NULL, EnclosureLength = NULL, EnclosureLink = NULL, EnclosureType = NULL, Title = '', Thumbnail = NULL, Snippet = NULL, Link = NULL, Article = NULL WHERE IsDeleted <> 1 AND IsRead = 1 AND IsStar = 0 AND PubDate < ")).append(l).toString(), new String[0]);
            } else
            {
                String as[] = (String[])dao.queryRaw((new StringBuilder("SELECT COUNT(1) FROM FeedItem WHERE IsDeleted = 0 AND IsRead = 1 AND PubDate < ")).append(l).toString(), new String[0]).getResults().get(0);
                c.a = Integer.parseInt(as[0]);
                dao.updateRaw((new StringBuilder("UPDATE FeedItem SET IsDeleted = 1, Author = NULL, CommentsLink = NULL, Description = NULL, EnclosureCurrentPosition = NULL, EnclosureDuration = NULL, EnclosureLength = NULL, EnclosureLink = NULL, EnclosureType = NULL, Title = '', Thumbnail = NULL, Snippet = NULL, Link = NULL, Article = NULL WHERE IsDeleted <> 1 AND IsRead = 1 AND PubDate < ")).append(l).toString(), new String[0]);
            }
        }
        com.appyet.manager.d.a(e);
        e.a();
        return null;
    }
}
