// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thirdparty;

import com.inmobi.commons.internal.Log;

public class Base62
{

    public static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int BASE = 62;

    private Base62()
    {
    }

    private static int a(int i, int j)
    {
        return i * (int)Math.pow(BASE, j);
    }

    private static int a(char ac[])
    {
        int i = 0;
        for (int j = -1 + ac.length; j >= 0; j--)
        {
            i += a("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ac[j]), j);
        }

        return i;
    }

    private static long a(long l, StringBuilder stringbuilder)
    {
        stringbuilder.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int)(l % (long)BASE)));
        return l / (long)BASE;
    }

    public static String fromBase10(long l)
    {
        StringBuilder stringbuilder;
        String s;
        try
        {
            stringbuilder = new StringBuilder("");
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Failed to convert to base 62", exception);
            return null;
        }
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        l = a(l, stringbuilder);
        break MISSING_BLOCK_LABEL_10;
        s = stringbuilder.reverse().toString();
        return s;
    }

    public static int toBase10(String s)
    {
        return a((new StringBuilder(s)).reverse().toString().toCharArray());
    }

}
