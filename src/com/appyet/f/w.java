// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.f;

import android.content.Context;
import android.content.res.Resources;

public final class w
{

    public static String a(Context context, String s)
    {
        String s1;
label0:
        {
            if (s.startsWith("[") && s.endsWith("]") && s.length() > 2)
            {
                s1 = c(context, s.substring(1, -1 + s.length()));
                if (s1 != null)
                {
                    break label0;
                }
            }
            return s;
        }
        return s1;
    }

    public static String b(Context context, String s)
    {
        String s1;
label0:
        {
            if (s.startsWith("[") && s.endsWith("]") && s.length() > 2)
            {
                s1 = c(context, s.substring(1, -1 + s.length()));
                if (s1 != null)
                {
                    break label0;
                }
            }
            return s;
        }
        return s1;
    }

    private static String c(Context context, String s)
    {
        int i = context.getResources().getIdentifier(s, "string", context.getPackageName());
        if (i == 0)
        {
            return null;
        } else
        {
            return context.getString(i);
        }
    }
}
