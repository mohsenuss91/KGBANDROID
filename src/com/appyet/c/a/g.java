// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.appyet.a.a.d;
import com.appyet.context.ApplicationContext;
import com.appyet.f.a;
import com.appyet.manager.an;
import com.appyet.manager.bp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.c.a:
//            a, c

final class g extends a
{

    final com.appyet.c.a.a a;

    private g(com.appyet.c.a.a a1)
    {
        a = a1;
        super();
    }

    g(com.appyet.c.a.a a1, byte byte0)
    {
        this(a1);
    }

    private transient Boolean f()
    {
        String s;
        String s1;
        try
        {
            if (com.appyet.c.a.a.a(a).b != null && com.appyet.c.a.a.a(a).b.size() != 0)
            {
                break MISSING_BLOCK_LABEL_157;
            }
            a.a.p.b(a.b);
            if (com.appyet.c.a.a.a(a).e != null)
            {
                break MISSING_BLOCK_LABEL_137;
            }
            s = a.a.d.a(com.appyet.c.a.a.a(a));
            s1 = a.a.d.b(com.appyet.c.a.a.a(a));
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return Boolean.valueOf(false);
        }
        if (s == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        a.a.p.a(a.b, s, s1);
        a.a.p.d(a.b);
        return Boolean.valueOf(true);
    }

    protected final void a()
    {
        com.appyet.c.a.a.g(a).setVisibility(8);
        com.appyet.c.a.a.i(a);
    }

    protected final void a(Object obj)
    {
        Boolean boolean1;
        boolean1 = (Boolean)obj;
        com.appyet.c.a.a.b(a);
        if (boolean1 == null || !boolean1.booleanValue()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        if (a.c == null)
        {
            a.c = new ArrayList();
        } else
        {
            a.c.clear();
        }
        if (com.appyet.c.a.a.c(a) != null && !com.appyet.c.a.a.c(a).k)
        {
            a.c.add(com.appyet.c.a.a.c(a));
        }
        iterator = com.appyet.c.a.a.a(a).b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.appyet.a.a.a a4 = (com.appyet.a.a.a)iterator.next();
            if (a4.d.equals(com.appyet.c.a.a.d(a)))
            {
                a.c.add(a4);
            }
        } while (true);
        if (!com.appyet.c.a.a.d(a).equals("-1") || com.appyet.c.a.a.a(a).b.size() <= 0 || a.c.size() != 0) goto _L4; else goto _L3
_L3:
        Iterator iterator1 = com.appyet.c.a.a.a(a).b.iterator();
_L17:
        if (!iterator1.hasNext()) goto _L4; else goto _L5
_L5:
        com.appyet.a.a.a a1;
        Iterator iterator2;
        a1 = (com.appyet.a.a.a)iterator1.next();
        iterator2 = com.appyet.c.a.a.a(a).b.iterator();
_L9:
        if (!iterator2.hasNext()) goto _L7; else goto _L6
_L6:
        com.appyet.a.a.a a3 = (com.appyet.a.a.a)iterator2.next();
        if (!a1.d.equals(a3.a)) goto _L9; else goto _L8
_L8:
        boolean flag = true;
_L15:
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        com.appyet.c.a.a.a(a, a1.d);
        Iterator iterator3 = com.appyet.c.a.a.a(a).b.iterator();
        do
        {
            if (!iterator3.hasNext())
            {
                break;
            }
            com.appyet.a.a.a a2 = (com.appyet.a.a.a)iterator3.next();
            if (a2.d.equals(com.appyet.c.a.a.d(a)))
            {
                a.c.add(a2);
            }
        } while (true);
_L4:
        com.appyet.c.a.a.a(a, new c(a, a.a, a.c));
        com.appyet.c.a.a.f(a).setAdapter(com.appyet.c.a.a.e(a));
        if (com.appyet.c.a.a.e(a) != null && com.appyet.c.a.a.e(a).getCount() != 0) goto _L11; else goto _L10
_L10:
        com.appyet.c.a.a.g(a).setVisibility(0);
        com.appyet.c.a.a.f(a).setVisibility(8);
_L13:
        return;
_L11:
        com.appyet.c.a.a.g(a).setVisibility(8);
        com.appyet.c.a.a.f(a).setVisibility(0);
        if (com.appyet.c.a.a.h(a) <= 0) goto _L13; else goto _L12
_L12:
        com.appyet.c.a.a.f(a).setSelection(com.appyet.c.a.a.h(a));
        return;
_L2:
        Toast.makeText(a.getActivity(), a.getString(0x7f080046), 1).show();
        return;
_L7:
        flag = false;
        if (true) goto _L15; else goto _L14
_L14:
        if (true) goto _L17; else goto _L16
_L16:
    }

    protected final Object b()
    {
        return f();
    }

    protected final volatile void c()
    {
    }
}
