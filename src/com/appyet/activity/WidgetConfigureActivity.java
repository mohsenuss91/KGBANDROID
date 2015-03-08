// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ListView;
import com.appyet.context.ApplicationContext;
import com.appyet.data.Module;
import com.appyet.manager.ar;
import com.appyet.manager.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.appyet.activity:
//            as, at

public class WidgetConfigureActivity extends ListActivity
{

    int a;
    private at b;
    private ApplicationContext c;

    public WidgetConfigureActivity()
    {
        a = 0;
    }

    static at a(WidgetConfigureActivity widgetconfigureactivity)
    {
        return widgetconfigureactivity.b;
    }

    static ApplicationContext b(WidgetConfigureActivity widgetconfigureactivity)
    {
        return widgetconfigureactivity.c;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        ar.a(this);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(5);
        setContentView(0x7f030028);
        c = (ApplicationContext)getApplication();
        Bundle bundle1 = getIntent().getExtras();
        if (bundle1 != null)
        {
            a = bundle1.getInt("appWidgetId", 0);
        }
        if (a == 0)
        {
            finish();
        }
        List list = c.h.g();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Module module = (Module)iterator.next();
            if ((module.getType().equals("Feed") || module.getType().equals("FeedQuery")) && !module.getIsHidden())
            {
                arraylist.add(module);
            }
        } while (true);
        getListView().setOnItemClickListener(new as(this));
        b = new at(this, this, arraylist);
        setListAdapter(b);
    }

    protected void onResume()
    {
        ar.a(this);
        super.onResume();
    }
}
