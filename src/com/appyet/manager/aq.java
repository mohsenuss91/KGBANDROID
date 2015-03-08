// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import com.appyet.d.d;
import com.appyet.f.a;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

// Referenced classes of package com.appyet.manager:
//            ap

final class aq extends a
{

    String a;
    final ap b;

    public aq(ap ap1, String s)
    {
        b = ap1;
        super();
        a = s;
    }

    private transient Void f()
    {
        try
        {
            if (b.a != null)
            {
                b.a.set("&cd", a);
                b.a.send(MapBuilder.createAppView().build());
            }
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
        try
        {
            if (b.b != null)
            {
                b.b.set("&cd", a);
                b.b.send(MapBuilder.createAppView().build());
            }
        }
        catch (Exception exception1)
        {
            d.a(exception1);
        }
        return null;
    }

    protected final Object b()
    {
        return f();
    }
}
