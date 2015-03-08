// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AdTrackerGoalRetryParams
{

    private int a;
    private int b;

    public AdTrackerGoalRetryParams()
    {
        a = 1000;
        b = 900;
    }

    public int getMaxRetry()
    {
        return a;
    }

    public int getMaxWaitTime()
    {
        return 1000 * b;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getIntFromMap(map, "mr", 0, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "mw", 0, 0x7fffffffL);
    }
}
