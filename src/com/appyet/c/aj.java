// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.View;
import android.widget.TextView;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.data.FeedItem;
import com.appyet.f.a;
import com.appyet.manager.bw;
import com.appyet.manager.d;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            r

final class aj extends a
{

    final r a;
    private int b;
    private List c;

    public aj(r r1, int i)
    {
        a = r1;
        super();
        b = i;
    }

    private transient Void f()
    {
        try
        {
            if (c != null && c.size() > 0)
            {
                a.a.h.d(c);
            }
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
        int i;
        c = new ArrayList();
        i = b;
_L2:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        FeedItem feeditem = r.b(a, i);
        if (feeditem == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        View view;
        if (feeditem.getIsRead())
        {
            break MISSING_BLOCK_LABEL_110;
        }
        c.add(feeditem);
        view = r.c(a, i);
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        TextView textview = (TextView)view.findViewById(0x7f0a008b);
        a.a.m.a(true, textview, null, null, null, null, null);
        i--;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        com.appyet.d.d.a(exception);
_L1:
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        if (c != null && c.size() > 0)
        {
            a.d();
        }
        r.b(a);
        ((MainActivity)a.getSherlockActivity()).c();
    }

    protected final Object b()
    {
        return f();
    }
}
