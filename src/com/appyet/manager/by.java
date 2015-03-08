// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import com.appyet.d.d;
import com.appyet.f.a;
import com.appyet.provider.WidgetProvider;

// Referenced classes of package com.appyet.manager:
//            bx

final class by extends a
{

    final bx a;

    by(bx bx1)
    {
        a = bx1;
        super();
    }

    private transient Void f()
    {
        int i = 0;
        AppWidgetManager appwidgetmanager;
        int ai[];
        int j;
        ComponentName componentname = new ComponentName(a.a, com/appyet/provider/WidgetProvider);
        appwidgetmanager = AppWidgetManager.getInstance(a.a);
        ai = appwidgetmanager.getAppWidgetIds(componentname);
        j = ai.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = ai[i];
        WidgetProvider.a(a.a, appwidgetmanager, k, 0);
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        d.a(exception);
_L1:
        return null;
    }

    protected final void a()
    {
        super.a();
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
