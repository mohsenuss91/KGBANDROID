// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.appyet.data.FileCache;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class z
    implements Callable
{

    final FileCache a;
    final d b;

    z(d d1, FileCache filecache)
    {
        b = d1;
        a = filecache;
        super();
    }

    public final Object call()
    {
        if (b.b.getFileCacheDao().create(a) != 1)
        {
            throw new Exception();
        } else
        {
            return null;
        }
    }
}
