// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.metric.EventType;

public final class NetworkEventType extends Enum
    implements EventType
{

    public static final NetworkEventType CONNECT_ERROR;
    public static final NetworkEventType FETCH_COMPLETE;
    public static final NetworkEventType RENDER_COMPLETE;
    public static final NetworkEventType RENDER_TIMEOUT;
    public static final NetworkEventType RESPONSE_ERROR;
    private static final NetworkEventType b[];
    private int a;

    private NetworkEventType(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public static NetworkEventType valueOf(String s)
    {
        return (NetworkEventType)Enum.valueOf(com/inmobi/androidsdk/bootstrapper/NetworkEventType, s);
    }

    public static NetworkEventType[] values()
    {
        return (NetworkEventType[])b.clone();
    }

    public final int getValue()
    {
        return a;
    }

    static 
    {
        FETCH_COMPLETE = new NetworkEventType("FETCH_COMPLETE", 0, 0);
        RENDER_COMPLETE = new NetworkEventType("RENDER_COMPLETE", 1, 1);
        CONNECT_ERROR = new NetworkEventType("CONNECT_ERROR", 2, 2);
        RESPONSE_ERROR = new NetworkEventType("RESPONSE_ERROR", 3, 3);
        RENDER_TIMEOUT = new NetworkEventType("RENDER_TIMEOUT", 4, 4);
        NetworkEventType anetworkeventtype[] = new NetworkEventType[5];
        anetworkeventtype[0] = FETCH_COMPLETE;
        anetworkeventtype[1] = RENDER_COMPLETE;
        anetworkeventtype[2] = CONNECT_ERROR;
        anetworkeventtype[3] = RESPONSE_ERROR;
        anetworkeventtype[4] = RENDER_TIMEOUT;
        b = anetworkeventtype;
    }
}
