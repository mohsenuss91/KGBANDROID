// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.d;

import android.util.Log;

public final class d
{

    public static void a(Error error)
    {
        if (error != null && error.getMessage() != null)
        {
            Log.e("pixel", error.getMessage());
        }
        error.printStackTrace();
    }

    public static void a(Exception exception)
    {
        if (exception != null && exception.getMessage() != null)
        {
            Log.e("pixel", exception.getMessage());
        }
        exception.printStackTrace();
    }
}
