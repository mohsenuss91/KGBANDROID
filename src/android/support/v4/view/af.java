// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            an, am, al, ak, 
//            aj, ai, ag, ao, 
//            a

public final class af
{

    static final ao a;

    public static int a(View view)
    {
        return a.a(view);
    }

    public static void a(View view, int i, int j, int k, int l)
    {
        a.a(view, i, j, k, l);
    }

    public static void a(View view, int i, Paint paint)
    {
        a.a(view, i, paint);
    }

    public static void a(View view, Paint paint)
    {
        a.a(view, paint);
    }

    public static void a(View view, a a1)
    {
        a.a(view, a1);
    }

    public static void a(View view, Runnable runnable)
    {
        a.a(view, runnable);
    }

    public static boolean a(View view, int i)
    {
        return a.a(view, i);
    }

    public static void b(View view)
    {
        a.b(view);
    }

    public static void b(View view, int i)
    {
        a.b(view, i);
    }

    public static int c(View view)
    {
        return a.c(view);
    }

    public static int d(View view)
    {
        return a.d(view);
    }

    public static int e(View view)
    {
        return a.e(view);
    }

    public static boolean f(View view)
    {
        return a.f(view);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 19)
        {
            a = new an();
        } else
        if (i >= 17)
        {
            a = new am();
        } else
        if (i >= 16)
        {
            a = new al();
        } else
        if (i >= 14)
        {
            a = new ak();
        } else
        if (i >= 11)
        {
            a = new aj();
        } else
        if (i >= 9)
        {
            a = new ai();
        } else
        {
            a = new ag();
        }
    }
}
