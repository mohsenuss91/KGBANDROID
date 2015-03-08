// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.a;
import com.appyet.manager.an;

// Referenced classes of package com.appyet.c.a:
//            a

final class h extends a
{

    final com.appyet.c.a.a a;
    private ProgressDialog b;
    private boolean c;

    private h(com.appyet.c.a.a a1)
    {
        a = a1;
        super();
    }

    h(com.appyet.c.a.a a1, byte byte0)
    {
        this(a1);
    }

    protected final void a()
    {
        try
        {
            b = new ProgressDialog(a.getActivity());
            b.setProgressStyle(0);
            b.setCancelable(true);
            b.setIndeterminate(true);
            b.setCanceledOnTouchOutside(false);
            b.setMessage(a.getString(0x7f080085));
            b.show();
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }

    protected final void a(Object obj)
    {
        try
        {
            if (b != null)
            {
                b.dismiss();
            }
            if (!c)
            {
                Toast.makeText(a.getActivity(), a.getString(0x7f080046), 1).show();
            }
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }

    protected final Object b()
    {
        c = a.a.p.c(a.b);
        return null;
    }

    protected final volatile void c()
    {
    }
}
