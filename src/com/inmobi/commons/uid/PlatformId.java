// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;

import android.content.Context;
import com.inmobi.commons.internal.Log;

public class PlatformId
{

    public PlatformId()
    {
    }

    public static String getAndroidId(Context context)
    {
        String s2 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        String s = s2;
_L2:
        if (s == null)
        {
            Exception exception;
            String s1;
            try
            {
                s1 = android.provider.Settings.System.getString(context.getContentResolver(), "android_id");
            }
            catch (Exception exception1)
            {
                Log.internal("commons", "Unable to retrieve android id.");
                return s;
            }
            s = s1;
        }
        return s;
        exception;
        Log.internal("commons", "Unable to retrieve android id.");
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
