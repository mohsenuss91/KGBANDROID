// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appyet.d.d;
import com.appyet.f.w;
import com.mobeta.android.dslv.DragSortListView;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.appyet.activity:
//            CustomizeActivity, c, e

public final class b extends ArrayAdapter
{

    final CustomizeActivity a;
    private Context b;

    public b(CustomizeActivity customizeactivity, Context context)
    {
        a = customizeactivity;
        super(context, 0);
        b = context;
    }

    public final int getItemViewType(int i)
    {
        return !((c)a.g.getItemAtPosition(i)).f ? 1 : 0;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        InputStream inputstream;
        e e1;
        inputstream = null;
        c c1 = (c)getItem(i);
        android.graphics.Bitmap bitmap;
        if (view == null)
        {
            if (c1.f)
            {
                view = LayoutInflater.from(getContext()).inflate(0x7f030035, null);
                e e3 = new e();
                e3.b = (TextView)view.findViewById(0x7f0a0074);
                e3.c = view.findViewById(0x7f0a0075);
                view.setTag(e3);
                e1 = e3;
            } else
            {
                view = LayoutInflater.from(getContext()).inflate(0x7f030036, null);
                e e2 = new e();
                e2.d = (RelativeLayout)view.findViewById(0x7f0a0076);
                e2.b = (TextView)view.findViewById(0x7f0a0074);
                e2.c = view.findViewById(0x7f0a0075);
                e2.a = (ImageView)view.findViewById(0x7f0a0077);
                view.setTag(e2);
                e1 = e2;
            }
        } else
        {
            e1 = (e)view.getTag();
        }
        if (c1.f) goto _L2; else goto _L1
_L1:
        if (e1.a == null) goto _L4; else goto _L3
_L3:
        if (c1.e == null) goto _L6; else goto _L5
_L5:
        inputstream = a.getResources().getAssets().open((new StringBuilder("module/")).append(c1.e).toString());
        bitmap = BitmapFactory.decodeStream(inputstream);
        e1.a.setImageBitmap(bitmap);
        if (inputstream == null) goto _L4; else goto _L7
_L7:
        inputstream.close();
_L4:
        e1.c.setVisibility(0);
_L2:
        e1.b.setText(w.b(a, c1.a));
        if (c1.g)
        {
            e1.c.setVisibility(8);
        }
        return view;
        IOException ioexception1;
        ioexception1;
        d.a(ioexception1);
        e1.a.setImageResource(0x7f0200dc);
        if (inputstream == null) goto _L4; else goto _L8
_L8:
        inputstream.close();
          goto _L4
        IOException ioexception2;
        ioexception2;
        ImageView imageview;
        d.a(ioexception2);
        imageview = e1.a;
_L9:
        imageview.setImageResource(0x7f0200dc);
          goto _L4
        Exception exception;
        exception;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception)
            {
                d.a(ioexception);
                e1.a.setImageResource(0x7f0200dc);
            }
        }
        throw exception;
_L6:
        e1.a.setImageResource(0x7f0200dc);
          goto _L4
        IOException ioexception3;
        ioexception3;
        d.a(ioexception3);
        imageview = e1.a;
          goto _L9
    }

    public final int getViewTypeCount()
    {
        return 2;
    }

    public final boolean isEnabled(int i)
    {
        return !((c)a.g.getItemAtPosition(i)).f;
    }
}
