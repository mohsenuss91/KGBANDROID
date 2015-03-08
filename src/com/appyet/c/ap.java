// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.View;
import android.widget.TextView;
import com.appyet.activity.MainActivity;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.data.FeedItem;
import com.appyet.data.Module;
import com.appyet.f.a;
import com.appyet.manager.bw;
import com.appyet.manager.d;

// Referenced classes of package com.appyet.c:
//            r

final class ap extends a
{

    final r a;
    private FeedItem b;
    private int c;

    public ap(r r1, int i)
    {
        a = r1;
        super();
        c = i;
    }

    private transient Void f()
    {
label0:
        {
            if (b.getIsRead())
            {
                b.setIsRead(false);
                a.a.h.a(b, false);
                break label0;
            }
            try
            {
                b.setIsRead(true);
                a.a.h.a(b, true);
            }
            catch (Exception exception)
            {
                com.appyet.d.d.a(exception);
            }
        }
        return null;
    }

    protected final void a()
    {
        boolean flag;
        flag = true;
        super.a();
        r.c(a);
        b = r.b(a, c);
        if (b == null)
        {
            return;
        }
        TextView textview;
        bw bw2;
        boolean flag1;
        textview = (TextView)r.c(a, c).findViewById(0x7f0a008b);
        if (a.a.n.a == null || a.a.n.a.getLayout() == null || !a.a.n.a.getLayout().equals("GRID"))
        {
            break MISSING_BLOCK_LABEL_167;
        }
        bw2 = a.a.m;
        flag1 = b.getIsRead();
        boolean flag2 = false;
        if (!flag1)
        {
            flag2 = flag;
        }
        try
        {
            bw2.a(flag2, null, null, null, null, null, textview);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        return;
        bw bw1 = a.a.m;
        if (b.getIsRead())
        {
            flag = false;
        }
        bw1.a(flag, textview, null, null, null, null, null);
        return;
    }

    protected final void a(Object obj)
    {
        a.d();
        r.b(a);
        ((MainActivity)a.getSherlockActivity()).c();
    }

    protected final Object b()
    {
        return f();
    }
}
