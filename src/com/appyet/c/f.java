// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import com.appyet.manager.d;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            a, g

final class f extends a
{

    final com.appyet.c.a a;
    private FeedItem b;

    public f(com.appyet.c.a a1, FeedItem feeditem)
    {
        a = a1;
        super();
        b = feeditem;
    }

    private transient Void f()
    {
        try
        {
            com.appyet.c.a.a(a).h.b(b);
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
        com.appyet.c.a.a(a).n.b.remove(b);
        if (com.appyet.c.a.a(a).n.b.size() == 0)
        {
            a.getSherlockActivity().getSupportFragmentManager().beginTransaction().remove(a).commit();
            a.getSherlockActivity().getSupportFragmentManager().popBackStack();
            return;
        }
        try
        {
            com.appyet.c.a.b(a).notifyDataSetChanged();
            if (com.appyet.c.a.c(a) >= com.appyet.c.a.a(a).n.b.size())
            {
                com.appyet.c.a.a(a, -1 + com.appyet.c.a.a(a).n.b.size());
            }
            if (com.appyet.c.a.c(a) < 0)
            {
                com.appyet.c.a.a(a, 0);
            }
            com.appyet.c.a.d(a).setCurrentItem(com.appyet.c.a.c(a));
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
    }

    protected final volatile void a(Object obj)
    {
        super.a((Void)obj);
    }

    protected final Object b()
    {
        return f();
    }
}
