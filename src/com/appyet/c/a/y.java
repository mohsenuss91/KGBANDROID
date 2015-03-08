// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.appyet.a.a.e;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.a;
import com.appyet.manager.an;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.c.a:
//            r, u

final class y extends a
{

    List a;
    List b;
    List c;
    final r d;

    private y(r r1)
    {
        d = r1;
        super();
    }

    y(r r1, byte byte0)
    {
        this(r1);
    }

    private transient Boolean f()
    {
        int i;
        try
        {
            i = 1 + com.appyet.c.a.r.d(d);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return Boolean.valueOf(false);
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        a = d.a.p.a(d.b, com.appyet.c.a.r.e(d), i, r.f(d), "TOP");
        b = d.a.p.a(d.b, com.appyet.c.a.r.e(d), i, r.f(d), "ANN");
        c = d.a.p.a(d.b, com.appyet.c.a.r.e(d), i, r.f(d), "");
        return Boolean.valueOf(true);
    }

    protected final void a()
    {
        com.appyet.c.a.r.a(d, true);
        if (r.h(d) == null || r.h(d).getCount() == 0)
        {
            r.n(d);
        }
    }

    protected final void a(Object obj)
    {
        Boolean boolean1 = (Boolean)obj;
        if (boolean1 != null && boolean1.booleanValue())
        {
            if (c == null || com.appyet.c.a.r.d(d) == -1 && (b == null || a == null))
            {
                return;
            }
            r.g(d);
            if (com.appyet.c.a.r.d(d) == 0)
            {
                if (a != null && a.size() > 0)
                {
                    e e2;
                    for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); c.add(0, e2))
                    {
                        e2 = (e)iterator1.next();
                        e2.l = true;
                    }

                }
                if (b != null && b.size() > 0)
                {
                    e e1;
                    for (Iterator iterator = b.iterator(); iterator.hasNext(); c.add(0, e1))
                    {
                        e1 = (e)iterator.next();
                        e1.m = true;
                    }

                }
            }
            if (r.h(d) == null)
            {
                com.appyet.c.a.r.a(d, new u(d, d.a, c));
                r.i(d).setAdapter(r.h(d));
            } else
            {
                r.h(d).addAll(c);
            }
            r.j(d);
            if (c.size() < r.f(d))
            {
                r.k(d);
                r.i(d).removeFooterView(r.l(d));
            }
            if (r.h(d) == null || r.h(d).getCount() == 0)
            {
                r.i(d).setVisibility(8);
                r.m(d).setVisibility(0);
            } else
            {
                r.i(d).setVisibility(0);
                r.m(d).setVisibility(8);
            }
            if (com.appyet.c.a.r.d(d) == 0)
            {
                r.i(d).setSelectionAfterHeaderView();
            }
            com.appyet.c.a.r.a(d, false);
            return;
        } else
        {
            r.j(d);
            Toast.makeText(d.getActivity(), d.getString(0x7f080046), 1).show();
            return;
        }
    }

    protected final Object b()
    {
        return f();
    }

    protected final volatile void c()
    {
    }
}
