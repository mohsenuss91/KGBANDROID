// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.appyet.d.d;
import com.appyet.data.Module;
import com.appyet.f.w;
import java.util.List;

// Referenced classes of package com.appyet.activity:
//            WidgetConfigureActivity

final class at extends ArrayAdapter
{

    final WidgetConfigureActivity a;
    private Context b;

    public at(WidgetConfigureActivity widgetconfigureactivity, Context context, List list)
    {
        a = widgetconfigureactivity;
        super(context, 0x7f030029, list);
        b = context;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view1 = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(0x7f030029, null);
        } else
        {
            view1 = view;
        }
        try
        {
            Module module = (Module)getItem(i);
            ((TextView)view1).setText(w.b(WidgetConfigureActivity.b(a), module.getName()));
        }
        catch (Exception exception)
        {
            d.a(exception);
            return view1;
        }
        return view1;
    }
}
