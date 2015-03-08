// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.events;


public final class  extends Enum
{

    public static final a CANCELED;
    public static final a COMPLETED;
    public static final a FAILED;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/commons/analytics/events/AnalyticsEventsWrapper$IMSectionStatus, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        COMPLETED = new <init>("COMPLETED", 0);
        FAILED = new <init>("FAILED", 1);
        CANCELED = new <init>("CANCELED", 2);
        s_3B_.clone aclone[] = new <init>[3];
        aclone[0] = COMPLETED;
        aclone[1] = FAILED;
        aclone[2] = CANCELED;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
