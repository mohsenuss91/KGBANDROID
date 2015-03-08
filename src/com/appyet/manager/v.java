// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.data.DatabaseHelper;
import com.appyet.data.Widget;
import com.j256.ormlite.dao.Dao;
import java.util.concurrent.Callable;

// Referenced classes of package com.appyet.manager:
//            d

final class v
    implements Callable
{

    final Widget a;
    final d b;

    v(d d1, Widget widget)
    {
        b = d1;
        a = widget;
        super();
    }

    public final Object call()
    {
        Dao dao = b.b.getWidgetDao();
        dao.deleteById(a.getWidgetId());
        dao.create(a);
        return null;
    }
}
