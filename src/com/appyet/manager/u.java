// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.appyet.data.Module;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class u
    implements Callable
{

    final long a;
    final String b;
    final d c;

    u(d d1, long l, String s)
    {
        c = d1;
        a = l;
        b = s;
        super();
    }

    public final Object call()
    {
        Dao dao = c.b.getModuleDao();
        Module module = (Module)dao.queryForId(Long.valueOf(a));
        module.setLayout(b);
        dao.update(module);
        return null;
    }
}
