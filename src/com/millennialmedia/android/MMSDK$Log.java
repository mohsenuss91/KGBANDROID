// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.util.Log;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK

class 
{

    static void d(String s)
    {
        if (MMSDK.logLevel > 0)
        {
            Log.i("MillennialMediaSDK", (new StringBuilder("Diagnostic - ")).append(s).toString());
        }
    }

    static transient void d(String s, Object aobj[])
    {
        if (MMSDK.logLevel > 0)
        {
            Log.i("MillennialMediaSDK", (new StringBuilder("Diagnostic - ")).append(String.format(s, aobj)).toString());
        }
    }

    static void d(Throwable throwable)
    {
        if (MMSDK.logLevel > 0)
        {
            d(Log.getStackTraceString(throwable));
        }
    }

    static void e(String s)
    {
        Log.e("MillennialMediaSDK", s);
    }

    static transient void e(String s, Object aobj[])
    {
        Log.e("MillennialMediaSDK", String.format(s, aobj));
    }

    static void e(Throwable throwable)
    {
        Log.e("MillennialMediaSDK", Log.getStackTraceString(throwable));
    }

    static void i(String s)
    {
        Log.i("MillennialMediaSDK", s);
    }

    static transient void i(String s, Object aobj[])
    {
        Log.i("MillennialMediaSDK", String.format(s, aobj));
    }

    static void i(Throwable throwable)
    {
        Log.i("MillennialMediaSDK", Log.getStackTraceString(throwable));
    }

    static void p(String s)
    {
        if (MMSDK.logLevel > 3)
        {
            Log.i("MillennialMediaSDK", (new StringBuilder("Private - ")).append(s).toString());
        }
    }

    static transient void p(String s, Object aobj[])
    {
        if (MMSDK.logLevel > 3)
        {
            Log.i("MillennialMediaSDK", (new StringBuilder("Private - ")).append(String.format(s, aobj)).toString());
        }
    }

    static void p(Throwable throwable)
    {
        if (MMSDK.logLevel > 3)
        {
            p(Log.getStackTraceString(throwable));
        }
    }

    static void v(String s)
    {
        if (MMSDK.logLevel >= 3)
        {
            Log.i("MillennialMediaSDK", (new StringBuilder("Verbose - ")).append(s).toString());
        }
    }

    static transient void v(String s, Object aobj[])
    {
        if (MMSDK.logLevel >= 3)
        {
            Log.i("MillennialMediaSDK", (new StringBuilder("Verbose - ")).append(String.format(s, aobj)).toString());
        }
    }

    static void v(Throwable throwable)
    {
        if (MMSDK.logLevel >= 3)
        {
            v(Log.getStackTraceString(throwable));
        }
    }

    static void w(String s)
    {
        Log.w("MillennialMediaSDK", s);
    }

    static transient void w(String s, Object aobj[])
    {
        Log.w("MillennialMediaSDK", String.format(s, aobj));
    }

    static void w(Throwable throwable)
    {
        Log.w("MillennialMediaSDK", Log.getStackTraceString(throwable));
    }

    ()
    {
    }
}
