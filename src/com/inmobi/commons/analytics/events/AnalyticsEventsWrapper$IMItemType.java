// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.events;


public final class  extends Enum
{

    public static final a CONSUMABLE;
    public static final a DURABLE;
    public static final a PERSONALIZATION;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/analytics/events/AnalyticsEventsWrapper$IMItemType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        CONSUMABLE = new <init>("CONSUMABLE", 0);
        DURABLE = new <init>("DURABLE", 1);
        PERSONALIZATION = new <init>("PERSONALIZATION", 2);
        e_3B_.clone aclone[] = new <init>[3];
        aclone[0] = CONSUMABLE;
        aclone[1] = DURABLE;
        aclone[2] = PERSONALIZATION;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
