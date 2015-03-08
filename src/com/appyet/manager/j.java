// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class j
    implements Callable
{

    final com.appyet.data.FeedItem.ArticleStatusEnum a;
    final Long b;
    final d c;

    j(d d1, com.appyet.data.FeedItem.ArticleStatusEnum articlestatusenum, Long long1)
    {
        c = d1;
        a = articlestatusenum;
        b = long1;
        super();
    }

    public final Object call()
    {
        Dao dao = c.b.getFeedItemDao();
        String as[] = new String[2];
        as[0] = a.toString();
        as[1] = String.valueOf(b);
        dao.updateRaw("UPDATE FeedItem SET ArticleStatus = ? WHERE FeedItemId = ?", as);
        return null;
    }
}
