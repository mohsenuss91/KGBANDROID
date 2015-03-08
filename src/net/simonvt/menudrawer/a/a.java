// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer.a;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package net.simonvt.menudrawer.a:
//            c, d

public final class a
{

    public Activity a;
    public Object b;
    public boolean c;

    public a(Activity activity)
    {
        a = activity;
        Object obj;
        try
        {
            activity.getClass().getMethod("getSupportActionBar", new Class[0]);
            c = true;
        }
        catch (NoSuchMethodException nosuchmethodexception) { }
        if (c && android.os.Build.VERSION.SDK_INT < 14)
        {
            obj = new c(a);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            obj = d.b(a);
        } else
        {
            obj = null;
        }
        b = obj;
    }

    public final void a(Drawable drawable, int i)
    {
        if (c && android.os.Build.VERSION.SDK_INT < 14)
        {
            Object obj = b;
            Activity activity = a;
            c c1 = (c)obj;
            if (c1.a != null)
            {
                c1.a.setImageDrawable(drawable);
                Object obj1;
                if (i == 0)
                {
                    obj1 = null;
                } else
                {
                    obj1 = activity.getString(i);
                }
                c1.a.setContentDescription(((CharSequence) (obj1)));
            }
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            d.a(b, a, drawable, i);
            return;
        }
    }
}
