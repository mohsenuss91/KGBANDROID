// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.metric.EventType;

public final class AdTrackerEventType extends Enum
    implements EventType
{

    public static final AdTrackerEventType GOAL_DUMPED;
    public static final AdTrackerEventType GOAL_FAILURE;
    public static final AdTrackerEventType GOAL_SUCCESS;
    private static final AdTrackerEventType b[];
    private int a;

    private AdTrackerEventType(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public static AdTrackerEventType valueOf(String s)
    {
        return (AdTrackerEventType)Enum.valueOf(com/inmobi/commons/analytics/iat/impl/config/AdTrackerEventType, s);
    }

    public static AdTrackerEventType[] values()
    {
        return (AdTrackerEventType[])b.clone();
    }

    public final int getValue()
    {
        return a;
    }

    static 
    {
        GOAL_SUCCESS = new AdTrackerEventType("GOAL_SUCCESS", 0, 0);
        GOAL_FAILURE = new AdTrackerEventType("GOAL_FAILURE", 1, 1);
        GOAL_DUMPED = new AdTrackerEventType("GOAL_DUMPED", 2, 2);
        AdTrackerEventType aadtrackereventtype[] = new AdTrackerEventType[3];
        aadtrackereventtype[0] = GOAL_SUCCESS;
        aadtrackereventtype[1] = GOAL_FAILURE;
        aadtrackereventtype[2] = GOAL_DUMPED;
        b = aadtrackereventtype;
    }
}
