// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.w;
import com.appyet.manager.ar;
import com.appyet.manager.bw;
import com.appyet.metadata.MetadataTheme;
import com.appyet.view.BadgeView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

// Referenced classes of package com.appyet.c:
//            bb, bd, ay

public final class ba extends ArrayAdapter
{

    final ay a;
    private Context b;

    public ba(ay ay1, Context context)
    {
        a = ay1;
        super(context, 0);
        b = context;
    }

    public final int getItemViewType(int i)
    {
        return !((bb)getItem(i)).f ? 1 : 0;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        InputStream inputstream;
        bd bd1;
        inputstream = null;
        bb bb1 = (bb)getItem(i);
        android.graphics.Bitmap bitmap;
        if (view == null)
        {
            if (bb1.f)
            {
                view = LayoutInflater.from(getContext()).inflate(0x7f030056, null);
                bd bd3 = new bd();
                bd3.b = (TextView)view.findViewById(0x7f0a0074);
                bd3.d = view.findViewById(0x7f0a0075);
                bd3.d.setBackgroundColor(Color.parseColor(a.a.m.a.LeftMenuDividerColor));
                bd3.b.setTextColor(Color.parseColor(a.a.m.a.LeftMenuGroupTextColor));
                bd3.b.setTextSize(2, a.a.m.a.LeftMenuGroupTextSize);
                view.setTag(bd3);
                bd1 = bd3;
            } else
            {
                view = LayoutInflater.from(getContext()).inflate(0x7f030057, null);
                bd bd2 = new bd();
                bd2.e = (RelativeLayout)view.findViewById(0x7f0a0076);
                int j = (int)TypedValue.applyDimension(1, a.a.m.a.LeftMenuItemVerticalPadding, a.getResources().getDisplayMetrics());
                int k = (int)TypedValue.applyDimension(1, 1 + a.a.m.a.LeftMenuItemVerticalPadding, a.getResources().getDisplayMetrics());
                bd2.e.setPadding(0, k, 0, j);
                bd2.b = (TextView)view.findViewById(0x7f0a0074);
                bd2.d = view.findViewById(0x7f0a0075);
                bd2.c = new BadgeView(b, bd2.b);
                int l;
                if (ar.b(a.a).getLanguage().equalsIgnoreCase("ar"))
                {
                    bd2.c.setBadgePosition(6);
                } else
                {
                    bd2.c.setBadgePosition(7);
                }
                bd2.c.setBadgeMargin(0, 10);
                bd2.c.setBadgeBackgroundColor(Color.parseColor(a.a.m.a.LeftMenuBadgeBgColor));
                bd2.c.setTextColor(Color.parseColor(a.a.m.a.LeftMenuBadgeTextColor));
                bd2.c.setTextSize(2, a.a.m.a.LeftMenuBadgeTextSize);
                bd2.d.setBackgroundColor(Color.parseColor(a.a.m.a.LeftMenuDividerColor));
                bd2.b.setTextColor(Color.parseColor(a.a.m.a.LeftMenuItemTextColor));
                bd2.b.setTextSize(2, a.a.m.a.LeftMenuItemTextSize);
                bd2.a = (ImageView)view.findViewById(0x7f0a0077);
                l = (int)TypedValue.applyDimension(1, a.a.m.a.LeftMenuIconSize, a.getResources().getDisplayMetrics());
                bd2.a.getLayoutParams().height = l;
                bd2.a.getLayoutParams().width = l;
                view.setTag(bd2);
                bd1 = bd2;
            }
        } else
        {
            bd1 = (bd)view.getTag();
        }
        if (!bb1.f && (bb1.c.equals("Feed") || bb1.c.equals("FeedQuery")) && bb1.b != null && bb1.b.trim().length() > 0)
        {
            bd1.c.setText(w.b(a.a, bb1.b));
            bd1.c.show();
        } else
        if (bd1.c != null)
        {
            bd1.c.hide();
        }
        if (bb1.f) goto _L2; else goto _L1
_L1:
        if (bd1.a == null) goto _L4; else goto _L3
_L3:
        if (bb1.e == null) goto _L6; else goto _L5
_L5:
        inputstream = a.getResources().getAssets().open((new StringBuilder("module/")).append(bb1.e).toString());
        bitmap = BitmapFactory.decodeStream(inputstream);
        bd1.a.setImageBitmap(bitmap);
        if (inputstream == null) goto _L4; else goto _L7
_L7:
        inputstream.close();
_L4:
        bd1.d.setVisibility(0);
_L2:
        bd1.b.setText(w.b(a.a, bb1.a));
        if (bb1.g)
        {
            bd1.d.setVisibility(8);
        }
        return view;
        IOException ioexception1;
        ioexception1;
        d.a(ioexception1);
        bd1.a.setImageResource(0x7f0200dc);
        if (inputstream == null) goto _L4; else goto _L8
_L8:
        inputstream.close();
          goto _L4
        IOException ioexception2;
        ioexception2;
        ImageView imageview;
        d.a(ioexception2);
        imageview = bd1.a;
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
                bd1.a.setImageResource(0x7f0200dc);
            }
        }
        throw exception;
_L6:
        bd1.a.setImageResource(0x7f0200dc);
          goto _L4
        IOException ioexception3;
        ioexception3;
        d.a(ioexception3);
        imageview = bd1.a;
          goto _L9
    }

    public final int getViewTypeCount()
    {
        return 2;
    }

    public final boolean isEnabled(int i)
    {
        return !((bb)getItem(i)).f;
    }
}
