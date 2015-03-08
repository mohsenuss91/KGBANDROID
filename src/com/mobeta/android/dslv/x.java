// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

// Referenced classes of package com.mobeta.android.dslv:
//            p

public class x
    implements p
{

    int a;
    private Bitmap b;
    private ImageView c;
    private ListView d;

    public x(ListView listview)
    {
        a = 0xff000000;
        d = listview;
    }

    public final View a(int i)
    {
        View view = d.getChildAt((i + d.getHeaderViewsCount()) - d.getFirstVisiblePosition());
        if (view == null)
        {
            return null;
        }
        view.setPressed(false);
        view.setDrawingCacheEnabled(true);
        b = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        if (c == null)
        {
            c = new ImageView(d.getContext());
        }
        c.setBackgroundColor(a);
        c.setPadding(0, 0, 0, 0);
        c.setImageBitmap(b);
        c.setLayoutParams(new android.view.ViewGroup.LayoutParams(view.getWidth(), view.getHeight()));
        return c;
    }

    public void a(Point point)
    {
    }

    public final void a(View view)
    {
        ((ImageView)view).setImageDrawable(null);
        b.recycle();
        b = null;
    }
}
