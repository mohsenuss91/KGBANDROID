// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import android.content.Context;
import android.content.res.Resources;

public final class Log
{

    public static boolean LOGGING_ENABLED = false;

    public Log()
    {
    }

    public static void d(String s)
    {
        d("ADSDK", s);
    }

    public static void d(String s, String s1)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.d(s, s1, null);
        }
    }

    public static void d(String s, String s1, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.d(s, s1, throwable);
        }
    }

    public static void d(String s, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.d("ADSDK", s, throwable);
        }
    }

    public static void e(String s)
    {
        e("ADSDK", s);
    }

    public static void e(String s, String s1)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.w(s, s1, null);
        }
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.w(s, s1, throwable);
        }
    }

    public static void e(String s, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.w("ADSDK", s, throwable);
        }
    }

    public static void i(String s)
    {
        i("ADSDK", s);
    }

    public static void i(String s, String s1)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.i(s, s1, null);
        }
    }

    public static void i(String s, String s1, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.i(s, s1, throwable);
        }
    }

    public static void i(String s, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.i("ADSDK", s, throwable);
        }
    }

    private static boolean isLoggingEnabled()
    {
        return LOGGING_ENABLED;
    }

    public static boolean isLoggingEnabled(Context context)
    {
        int j = context.getResources().getIdentifier("adsdk_debug_enabled", "string", context.getPackageName());
        return j != 0 && context.getResources().getString(j).equalsIgnoreCase("true");
    }

    public static void v(String s)
    {
        v("ADSDK", s);
    }

    public static void v(String s, String s1)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.v(s, s1, null);
        }
    }

    public static void v(String s, String s1, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.v(s, s1, throwable);
        }
    }

    public static void v(String s, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.v("ADSDK", s, throwable);
        }
    }

    public static void w(String s)
    {
        w("ADSDK", s);
    }

    public static void w(String s, String s1)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.w(s, s1, null);
        }
    }

    public static void w(String s, String s1, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.w(s, s1, throwable);
        }
    }

    public static void w(String s, Throwable throwable)
    {
        if (isLoggingEnabled())
        {
            android.util.Log.w("ADSDK", s, throwable);
        }
    }

}
