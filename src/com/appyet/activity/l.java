// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.a;
import com.appyet.d.d;
import com.appyet.f.v;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.appyet.activity:
//            DownloadActivity

final class l extends ArrayAdapter
{

    final DownloadActivity a;
    private ApplicationContext b;

    public l(DownloadActivity downloadactivity, Context context, List list)
    {
        a = downloadactivity;
        super(context, 0x7f03003a, list);
        b = (ApplicationContext)context.getApplicationContext();
    }

    public final int getCount()
    {
        return super.getCount();
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        View view3 = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(0x7f03003a, null);
        View view1 = view3;
_L5:
        ImageView imageview;
        String s;
        File file = (File)getItem(i);
        imageview = (ImageView)view1.findViewById(0x7f0a0077);
        TextView textview = (TextView)view1.findViewById(0x7f0a0074);
        TextView textview1 = (TextView)view1.findViewById(0x7f0a0079);
        TextView textview2 = (TextView)view1.findViewById(0x7f0a007a);
        textview.setText(file.getName());
        textview1.setText(com.appyet.d.a.b(b, new Date(file.lastModified())));
        DecimalFormat decimalformat = new DecimalFormat("#.#");
        StringBuilder stringbuilder = new StringBuilder();
        Object aobj[] = new Object[1];
        aobj[0] = decimalformat.format((double)file.length() / 1048576D);
        textview2.setText(stringbuilder.append(String.format("%s", aobj)).append(" ").append(a.getString(0x7f08008b)).toString());
        s = v.a(file.getPath());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        if (!s.contains("video"))
        {
            break MISSING_BLOCK_LABEL_237;
        }
        imageview.setImageResource(0x7f0200b3);
        return view1;
        if (!s.contains("audio"))
        {
            break MISSING_BLOCK_LABEL_257;
        }
        imageview.setImageResource(0x7f0200b1);
        return view1;
        if (s.contains("image"))
        {
            imageview.setImageResource(0x7f0200b2);
        }
        return view1;
        Exception exception2;
        exception2;
        Exception exception1;
        View view2;
        exception1 = exception2;
        view2 = view;
_L3:
        d.a(exception1);
        return view2;
        Exception exception;
        exception;
        exception1 = exception;
        view2 = view1;
        if (true) goto _L3; else goto _L2
_L2:
        view1 = view;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
