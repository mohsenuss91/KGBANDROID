// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.c;

import android.util.Log;
import com.a.a.b.f;

public final class d
{

    private static volatile boolean a = false;

    private static transient void a(int i, Throwable throwable, String s, Object aobj[])
    {
        if (a)
        {
            return;
        }
        String s1;
        if (aobj.length > 0)
        {
            s1 = String.format(s, aobj);
        } else
        {
            s1 = s;
        }
        if (throwable != null)
        {
            if (s1 == null)
            {
                s1 = throwable.getMessage();
            }
            s1 = String.format("%1$s\n%2$s", new Object[] {
                s1, Log.getStackTraceString(throwable)
            });
        }
        Log.println(i, f.a, s1);
    }

    public static transient void a(String s, Object aobj[])
    {
        a(3, null, s, aobj);
    }

    public static void a(Throwable throwable)
    {
        a(6, throwable, null, new Object[0]);
    }

    public static transient void b(String s, Object aobj[])
    {
        a(4, null, s, aobj);
    }

    public static transient void c(String s, Object aobj[])
    {
        a(5, null, s, aobj);
    }

    public static transient void d(String s, Object aobj[])
    {
        a(6, null, s, aobj);
    }

}
