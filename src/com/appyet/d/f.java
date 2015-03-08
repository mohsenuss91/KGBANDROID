// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.d;

import java.text.DecimalFormat;

public final class f
{

    public static String a(double d)
    {
        DecimalFormat decimalformat = new DecimalFormat("0.00%");
        double d1 = Math.pow(10D, 2D);
        double d2 = Math.floor(d * d1);
        decimalformat.setDecimalSeparatorAlwaysShown(false);
        decimalformat.setMinimumFractionDigits(0);
        decimalformat.setMaximumFractionDigits(0);
        return decimalformat.format(d2 / d1);
    }

    public static StringBuilder a(StringBuilder stringbuilder, String s, String s1)
    {
        int i = 0;
        do
        {
            int j = stringbuilder.indexOf(s, i);
            if (j >= 0)
            {
                stringbuilder = stringbuilder.replace(j, j + s.length(), s1);
                i = 1 + (j + s1.length());
            } else
            {
                return stringbuilder;
            }
        } while (true);
    }
}
