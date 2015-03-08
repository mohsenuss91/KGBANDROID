// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


public final class a extends Enum
{

    public static final b FAILED;
    public static final b INVALID;
    public static final b PURCHASED;
    public static final b REFUNDED;
    public static final b RESTORED;
    private static final b b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    public final int getValue()
    {
        return a;
    }

    static 
    {
        INVALID = new <init>("INVALID", 0, -1);
        PURCHASED = new <init>("PURCHASED", 1, 1);
        FAILED = new <init>("FAILED", 2, 2);
        RESTORED = new <init>("RESTORED", 3, 3);
        REFUNDED = new <init>("REFUNDED", 4, 4);
        a aa[] = new <init>[5];
        aa[0] = INVALID;
        aa[1] = PURCHASED;
        aa[2] = FAILED;
        aa[3] = RESTORED;
        aa[4] = REFUNDED;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
