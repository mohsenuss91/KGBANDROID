// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.a.a.b.f;
import com.appyet.a.a.a;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.util.List;

// Referenced classes of package com.appyet.c.a:
//            d, a

public final class c extends ArrayAdapter
{

    final com.appyet.c.a.a a;
    private ApplicationContext b;
    private int c;
    private LayoutInflater d;
    private List e;

    public c(com.appyet.c.a.a a1, Context context, List list)
    {
        a = a1;
        super(context, 0x7f030045, list);
        b = (ApplicationContext)context.getApplicationContext();
        e = list;
        c = 0x7f030046;
        d = (LayoutInflater)b.getSystemService("layout_inflater");
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        View view3 = d.inflate(c, null, false);
        View view2 = view3;
        com.appyet.c.a.d d2;
        d2 = new com.appyet.c.a.d(a);
        d2.b = (ImageView)view2.findViewById(0x7f0a0077);
        d2.a = (TextView)view2.findViewById(0x7f0a0074);
        view2.setTag(d2);
_L11:
        a a1;
        a1 = (a)e.get(i);
        d2.a.setText(a1.b);
        if (!b.m.a.PrimaryBgColor.equals("DARK")) goto _L4; else goto _L3
_L3:
        d2.a.setTextColor(b.getResources().getColor(0x7f090041));
_L7:
        if (a1.e == null || a1.e.length() <= 0) goto _L6; else goto _L5
_L5:
        com.appyet.c.a.a.k(a).a(a1.e, d2.b, com.appyet.c.a.a.j(a));
        return view2;
_L2:
        com.appyet.c.a.d d1 = (com.appyet.c.a.d)view.getTag();
        d2 = d1;
        view2 = view;
        continue; /* Loop/switch isn't completed */
_L4:
        d2.a.setTextColor(b.getResources().getColor(0x7f090043));
          goto _L7
        Exception exception2;
        exception2;
        Exception exception1;
        View view1;
        view1 = view2;
        exception1 = exception2;
_L9:
        com.appyet.d.d.a(exception1);
        return view1;
_L6:
        d2.b.setImageResource(0x7f0200b5);
        return view2;
        Exception exception;
        exception;
        exception1 = exception;
        view1 = view;
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }
}
