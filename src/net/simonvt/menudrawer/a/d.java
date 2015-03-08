// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer.a;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.reflect.Method;

// Referenced classes of package net.simonvt.menudrawer.a:
//            e

public final class d
{

    private static final int a[] = {
        0x101030b
    };

    public static Drawable a(Activity activity)
    {
        TypedArray typedarray = activity.obtainStyledAttributes(a);
        Drawable drawable = typedarray.getDrawable(0);
        typedarray.recycle();
        return drawable;
    }

    public static void a(Object obj, Activity activity, int i)
    {
        e e1;
        e1 = (e)obj;
        if (e1.a == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        ActionBar actionbar = activity.getActionBar();
        Method method = e1.b;
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        method.invoke(actionbar, aobj);
        return;
        Throwable throwable;
        throwable;
    }

    public static void a(Object obj, Activity activity, Drawable drawable, int i)
    {
        e e1;
        e1 = (e)obj;
        if (e1.a == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        ActionBar actionbar = activity.getActionBar();
        e1.a.invoke(actionbar, new Object[] {
            drawable
        });
        Method method = e1.b;
        Object aobj[] = new Object[1];
        aobj[0] = Integer.valueOf(i);
        method.invoke(actionbar, aobj);
_L1:
        return;
        if (e1.c != null)
        {
            e1.c.setImageDrawable(drawable);
            return;
        }
          goto _L1
        Throwable throwable;
        throwable;
    }

    public static Object b(Activity activity)
    {
        return new e(activity);
    }

    public static void c(Activity activity)
    {
        ActionBar actionbar = activity.getActionBar();
        if (actionbar != null)
        {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
