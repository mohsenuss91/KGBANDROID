// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;


public final class a extends Enum
{

    public static final b INAPP;
    public static final b INVALID;
    public static final b SUBSCRIPTION;
    private static final b b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/analytics/db/AnalyticsEvent$TRANSACTION_ITEM_TYPE, s);
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
        INAPP = new <init>("INAPP", 1, 1);
        SUBSCRIPTION = new <init>("SUBSCRIPTION", 2, 2);
        a aa[] = new <init>[3];
        aa[0] = INVALID;
        aa[1] = INAPP;
        aa[2] = SUBSCRIPTION;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
