// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import uk.co.senab.a.b.c;

// Referenced classes of package uk.co.senab.a.a.a:
//            h, j, g, b, 
//            i

public final class a extends c
{

    Animation a;
    private Animation c;

    public a()
    {
    }

    protected final Drawable a(Context context)
    {
        TypedArray typedarray;
        if (android.os.Build.VERSION.SDK_INT >= super.d())
        {
            return super.a(context);
        }
        typedarray = a(context, h.actionBarStyle, j.SherlockActionBar);
        Drawable drawable = typedarray.getDrawable(2);
        typedarray.recycle();
        return drawable;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public final void a(Activity activity, View view)
    {
        super.a(activity, view);
        c = AnimationUtils.loadAnimation(activity, g.fade_in);
        a = AnimationUtils.loadAnimation(activity, g.fade_out);
        if (a != null || c != null)
        {
            b b1 = new b(this);
            if (a != null)
            {
                a.setAnimationListener(b1);
            }
        }
    }

    public final boolean a()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= super.d())
        {
            flag = super.a();
        } else
        {
            View view = super.b;
            if (view != null && view.getVisibility() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (c != null)
                {
                    view.startAnimation(c);
                }
                view.setVisibility(0);
                return flag;
            }
        }
        return flag;
    }

    protected final int b(Context context)
    {
        TypedArray typedarray;
        if (android.os.Build.VERSION.SDK_INT >= super.d())
        {
            return super.b(context);
        }
        typedarray = context.obtainStyledAttributes(j.SherlockTheme);
        int k = typedarray.getDimensionPixelSize(7, 0);
        typedarray.recycle();
        return k;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public final boolean b()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= super.d())
        {
            flag = super.b();
        } else
        {
            View view = super.b;
            if (view != null && view.getVisibility() != 8)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (a != null)
                {
                    view.startAnimation(a);
                    return flag;
                } else
                {
                    view.setVisibility(8);
                    e();
                    return flag;
                }
            }
        }
        return flag;
    }

    protected final int c(Context context)
    {
        TypedArray typedarray;
        if (android.os.Build.VERSION.SDK_INT >= super.d())
        {
            return super.c(context);
        }
        typedarray = a(context, h.actionBarStyle, j.SherlockActionBar);
        int k = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        return k;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    public final void c()
    {
        if (android.os.Build.VERSION.SDK_INT >= super.d())
        {
            super.c();
        } else
        {
            View view = super.b.findViewById(i.ptr_content);
            if (view != null)
            {
                view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), g.fade_out));
                view.setVisibility(4);
                return;
            }
        }
    }

    protected final int d()
    {
        return 7;
    }
}
