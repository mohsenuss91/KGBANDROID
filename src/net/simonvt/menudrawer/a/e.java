// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer.a;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

final class e
{

    public Method a;
    public Method b;
    public ImageView c;

    e(Activity activity)
    {
        a = android/app/ActionBar.getDeclaredMethod("setHomeAsUpIndicator", new Class[] {
            android/graphics/drawable/Drawable
        });
        Class aclass[] = new Class[1];
        aclass[0] = Integer.TYPE;
        b = android/app/ActionBar.getDeclaredMethod("setHomeActionContentDescription", aclass);
_L1:
        return;
        Throwable throwable;
        throwable;
        View view = activity.findViewById(0x102002c);
        if (view != null)
        {
            ViewGroup viewgroup = (ViewGroup)view.getParent();
            if (viewgroup.getChildCount() == 2)
            {
                View view1 = viewgroup.getChildAt(0);
                View view2 = viewgroup.getChildAt(1);
                if (view1.getId() != 0x102002c)
                {
                    view2 = view1;
                }
                if (view2 instanceof ImageView)
                {
                    c = (ImageView)view2;
                    return;
                }
            }
        }
          goto _L1
    }
}
