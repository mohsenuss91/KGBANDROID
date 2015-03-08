// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.data.FeedItem;
import com.appyet.data.Module;
import com.appyet.f.a;
import com.appyet.manager.bp;
import com.appyet.manager.bw;
import com.appyet.manager.d;

// Referenced classes of package com.appyet.c:
//            r

final class aq extends a
{

    final r a;
    private int b;
    private FeedItem c;

    public aq(r r1, int i)
    {
        a = r1;
        super();
        b = i;
    }

    private transient Void f()
    {
        if (c == null)
        {
            return null;
        }
        if (!c.getIsStar())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        c.setIsStar(false);
        a.a.h.a(c.getFeedItemId().longValue(), false);
        Exception exception;
        return null;
        try
        {
            c.setIsStar(true);
            a.a.h.a(c.getFeedItemId().longValue(), true);
            if (a.a.d.b())
            {
                c.setIsRead(false);
                a.a.h.a(c, false);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return null;
        }
        return null;
    }

    protected final void a()
    {
        ImageView imageview;
        TextView textview;
        super.a();
        r.c(a);
        View view;
        try
        {
            c = r.b(a, b);
            if (c == null)
            {
                return;
            }
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
        view = r.c(a, b);
        imageview = (ImageView)view.findViewById(0x7f0a0093);
        if (!c.getIsStar())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        imageview.setVisibility(8);
_L1:
        if (!c.getIsRead() || !a.a.d.b())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        textview = (TextView)view.findViewById(0x7f0a008b);
        if (a.a.n.a != null && a.a.n.a.getLayout() != null && a.a.n.a.getLayout().equals("GRID"))
        {
            a.a.m.a(false, null, null, null, null, null, textview);
            return;
        }
        break MISSING_BLOCK_LABEL_204;
        imageview.setVisibility(0);
          goto _L1
        a.a.m.a(false, textview, null, null, null, null, null);
    }

    protected final void a(Object obj)
    {
        super.a((Void)obj);
        a.d();
        r.b(a);
    }

    protected final Object b()
    {
        return f();
    }
}
