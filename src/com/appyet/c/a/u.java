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
import com.appyet.a.a.e;
import com.appyet.context.ApplicationContext;
import com.appyet.d.a;
import com.appyet.d.d;
import com.appyet.manager.an;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.appyet.c.a:
//            v, r

public final class u extends ArrayAdapter
{

    final r a;
    private ApplicationContext b;
    private int c;
    private LayoutInflater d;

    public u(r r1, Context context, List list)
    {
        a = r1;
        super(context, 0x7f03004b, list);
        b = (ApplicationContext)context.getApplicationContext();
        c = 0x7f03004c;
        d = (LayoutInflater)b.getSystemService("layout_inflater");
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        View view3 = d.inflate(c, null, false);
        View view2 = view3;
        v v2;
        v2 = new v(a);
        v2.a = (TextView)view2.findViewById(0x7f0a00b7);
        v2.c = (TextView)view2.findViewById(0x7f0a00b0);
        v2.d = (TextView)view2.findViewById(0x7f0a00ad);
        v2.b = (TextView)view2.findViewById(0x7f0a00b6);
        v2.f = (TextView)view2.findViewById(0x7f0a00b8);
        v2.g = (TextView)view2.findViewById(0x7f0a00ab);
        v2.e = (ImageView)view2.findViewById(0x7f0a00a9);
        v2.h = (ImageView)view2.findViewById(0x7f0a00b4);
        v2.i = (ImageView)view2.findViewById(0x7f0a00b5);
        v2.j = (ImageView)view2.findViewById(0x7f0a00b3);
        view2.setTag(v2);
_L19:
        e e1;
        b.p.a(a.b);
        e1 = (e)r.h(a).getItem(i);
        if (!b.m.a.PrimaryBgColor.equals("DARK")) goto _L4; else goto _L3
_L3:
        v2.a.setTextColor(b.getResources().getColor(0x7f090041));
_L20:
        v2.a.setText(e1.c);
        if (!b.m.a.PrimaryBgColor.equals("DARK")) goto _L6; else goto _L5
_L5:
        v2.b.setTextColor(b.getResources().getColor(0x7f090042));
        v2.c.setTextColor(b.getResources().getColor(0x7f090042));
        v2.d.setTextColor(b.getResources().getColor(0x7f090042));
        v2.g.setTextColor(b.getResources().getColor(0x7f090042));
        v2.f.setTextColor(b.getResources().getColor(0x7f090044));
_L21:
        v2.b.setText(e1.d);
        v2.c.setText(String.valueOf(e1.h));
        v2.d.setText(String.valueOf(e1.i));
        if (!com.appyet.d.a.a(e1.g, new Date())) goto _L8; else goto _L7
_L7:
        v2.g.setText(com.appyet.d.a.d(b, e1.g));
_L22:
        if (e1.j == null || e1.j.length() <= 0) goto _L10; else goto _L9
_L9:
        v2.f.setText(String.valueOf(e1.j));
        v2.f.setVisibility(0);
_L23:
        if (e1.f == null || e1.f.length() <= 0) goto _L12; else goto _L11
_L11:
        r.p(a).a(e1.f, v2.e, r.o(a));
_L24:
        if (!e1.e) goto _L14; else goto _L13
_L13:
        v2.j.setVisibility(0);
_L25:
        if (!e1.l) goto _L16; else goto _L15
_L15:
        v2.h.setVisibility(0);
_L26:
        if (!e1.m) goto _L18; else goto _L17
_L17:
        v2.i.setVisibility(0);
        return view2;
_L2:
        v v1 = (v)view.getTag();
        v2 = v1;
        view2 = view;
          goto _L19
_L4:
        v2.a.setTextColor(b.getResources().getColor(0x7f090043));
          goto _L20
        Exception exception2;
        exception2;
        Exception exception1;
        View view1;
        view1 = view2;
        exception1 = exception2;
_L27:
        com.appyet.d.d.a(exception1);
        return view1;
_L6:
        v2.b.setTextColor(b.getResources().getColor(0x7f090044));
        v2.c.setTextColor(b.getResources().getColor(0x7f090044));
        v2.d.setTextColor(b.getResources().getColor(0x7f090044));
        v2.g.setTextColor(b.getResources().getColor(0x7f090044));
        v2.f.setTextColor(b.getResources().getColor(0x7f090044));
          goto _L21
_L8:
        v2.g.setText(com.appyet.d.a.c(b, e1.g));
          goto _L22
_L10:
        v2.f.setVisibility(8);
          goto _L23
_L12:
label0:
        {
            if (!b.m.a.PrimaryBgColor.equals("DARK"))
            {
                break label0;
            }
            v2.e.setImageResource(0x7f0200ab);
        }
          goto _L24
        v2.e.setImageResource(0x7f0200ac);
          goto _L24
_L14:
        v2.j.setVisibility(8);
          goto _L25
_L16:
        v2.h.setVisibility(8);
          goto _L26
_L18:
        v2.i.setVisibility(8);
        return view2;
        Exception exception;
        exception;
        exception1 = exception;
        view1 = view;
          goto _L27
    }
}
