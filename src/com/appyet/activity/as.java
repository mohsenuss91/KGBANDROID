// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import com.appyet.context.ApplicationContext;
import com.appyet.data.Module;
import com.appyet.data.Widget;
import com.appyet.manager.d;
import com.appyet.provider.WidgetProvider;

// Referenced classes of package com.appyet.activity:
//            WidgetConfigureActivity, at

final class as
    implements android.widget.AdapterView.OnItemClickListener
{

    final WidgetConfigureActivity a;

    as(WidgetConfigureActivity widgetconfigureactivity)
    {
        a = widgetconfigureactivity;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        try
        {
            Module module = (Module)WidgetConfigureActivity.a(a).getItem(i);
            Widget widget = new Widget();
            widget.setWidgetId(Long.valueOf(a.a));
            widget.setModuleId(module.getModuleId());
            widget.setPosition(Long.valueOf(0L));
            WidgetConfigureActivity.b(a).h.a(widget);
            Intent intent = new Intent();
            intent.putExtra("appWidgetId", a.a);
            a.setResult(-1, intent);
            AppWidgetManager appwidgetmanager = AppWidgetManager.getInstance(WidgetConfigureActivity.b(a));
            WidgetProvider.a(WidgetConfigureActivity.b(a), appwidgetmanager, a.a, 0);
            a.finish();
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
        Toast.makeText(WidgetConfigureActivity.b(a), 0x7f080046, 1).show();
    }
}
