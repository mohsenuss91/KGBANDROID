// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.view.View;

// Referenced classes of package net.simonvt.menudrawer:
//            MenuDrawer

final class al
{

    public static int a(View view)
    {
        if (MenuDrawer.q)
        {
            return (int)((float)view.getLeft() + view.getTranslationX());
        } else
        {
            return view.getLeft();
        }
    }

    public static int b(View view)
    {
        if (MenuDrawer.q)
        {
            return (int)((float)view.getTop() + view.getTranslationY());
        } else
        {
            return view.getTop();
        }
    }

    public static int c(View view)
    {
        if (MenuDrawer.q)
        {
            return (int)((float)view.getRight() + view.getTranslationX());
        } else
        {
            return view.getRight();
        }
    }

    public static int d(View view)
    {
        if (MenuDrawer.q)
        {
            return (int)((float)view.getBottom() + view.getTranslationY());
        } else
        {
            return view.getBottom();
        }
    }

    public static int e(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            return view.getLayoutDirection();
        } else
        {
            return 0;
        }
    }
}
