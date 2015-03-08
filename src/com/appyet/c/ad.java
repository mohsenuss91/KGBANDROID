// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import com.appyet.manager.d;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            r, ae

final class ad extends a
{

    final r a;
    private FeedItem b;

    public ad(r r1, FeedItem feeditem)
    {
        a = r1;
        super();
        b = feeditem;
    }

    private transient Void f()
    {
        try
        {
            a.a.h.b(b);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return null;
    }

    protected final void a()
    {
        super.a();
        r.c(a);
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        try
        {
            com.appyet.c.r.a(a).remove(b);
            a.a.n.b.remove(b);
            if (com.appyet.c.r.a(a).getCount() == 0)
            {
                com.appyet.c.r.d(a).setVisibility(0);
                com.appyet.c.r.d(a).setText(a.getString(0x7f08005b));
                r.e(a).setVisibility(8);
                com.appyet.c.r.f(a).setVisibility(8);
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        a.d();
        r.b(a);
        ((MainActivity)a.getSherlockActivity()).c();
    }

    protected final Object b()
    {
        return f();
    }
}
