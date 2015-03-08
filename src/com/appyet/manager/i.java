// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.appyet.data.FeedItem;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class i
    implements Callable
{

    final String a;
    final FeedItem b;
    final d c;

    i(d d1, String s, FeedItem feeditem)
    {
        c = d1;
        a = s;
        b = feeditem;
        super();
    }

    public final Object call()
    {
        Dao dao = c.b.getFeedItemDao();
        String as[] = new String[3];
        as[0] = a;
        as[1] = com.appyet.data.FeedItem.ArticleStatusEnum.DownloadCompleted.toString();
        as[2] = String.valueOf(b.getFeedItemId());
        dao.updateRaw("UPDATE FeedItem SET Article = ?, ArticleStatus = ? WHERE FeedItemId = ?", as);
        return null;
    }
}
