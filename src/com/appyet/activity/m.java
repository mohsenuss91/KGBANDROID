// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.a;
import com.appyet.manager.af;
import com.appyet.manager.ak;
import com.appyet.manager.bp;
import java.util.List;

// Referenced classes of package com.appyet.activity:
//            DownloadActivity, l

final class m extends a
{

    final DownloadActivity a;

    m(DownloadActivity downloadactivity)
    {
        a = downloadactivity;
        super();
    }

    private transient List f()
    {
        java.util.ArrayList arraylist;
        if (a.a.d.R() == 0)
        {
            return a.a.l.a(ak.a);
        }
        if (a.a.d.R() == 1)
        {
            return a.a.l.a(ak.b);
        }
        if (a.a.d.R() != 2)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        arraylist = a.a.l.a(ak.c);
        return arraylist;
        Exception exception;
        exception;
        d.a(exception);
        return null;
    }

    protected final void a()
    {
        super.a();
        DownloadActivity.b(a).setVisibility(0);
    }

    protected final void a(Object obj)
    {
        List list = (List)obj;
        super.a(list);
        DownloadActivity.b(a).setVisibility(8);
        if (list != null && list.size() > 0)
        {
            com.appyet.activity.DownloadActivity.a(a, new l(a, a, list));
            DownloadActivity.c(a).setAdapter(com.appyet.activity.DownloadActivity.a(a));
            DownloadActivity.c(a).setVisibility(0);
            com.appyet.activity.DownloadActivity.d(a).setVisibility(8);
            return;
        } else
        {
            DownloadActivity.c(a).setVisibility(8);
            com.appyet.activity.DownloadActivity.d(a).setVisibility(0);
            return;
        }
    }

    protected final Object b()
    {
        return f();
    }
}
