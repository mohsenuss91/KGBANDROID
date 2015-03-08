// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class n
    implements Callable
{

    final d a;

    n(d d1)
    {
        a = d1;
        super();
    }

    public final Object call()
    {
        a.b.getFileCacheDao().updateRaw("DELETE FROM FileCache WHERE CacheGuid NOT IN (SELECT CacheGuid FROM FeedItem WHERE IsDeleted = 0 AND CacheGuid IS NOT NULL UNION ALL SELECT CacheGuid FROM Feed WHERE CacheGuid IS NOT NULL)", new String[0]);
        return null;
    }
}
