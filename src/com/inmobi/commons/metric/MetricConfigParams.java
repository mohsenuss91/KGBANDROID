// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class MetricConfigParams
{

    private int a;
    private int b;
    private int c;
    private int d;
    private String e;

    public MetricConfigParams()
    {
        a = 0x69780;
        b = 1000;
        c = 1000;
        d = 10;
        e = "https://sdkm.w.inmobi.com/metrics/e.asm";
    }

    public int getDumpThreshhold()
    {
        return d;
    }

    public int getMaxInQueue()
    {
        return b;
    }

    public int getNextRetryInterval()
    {
        return a;
    }

    public int getSamplingFactor()
    {
        return c;
    }

    public String getUrl()
    {
        return e;
    }

    public void setFromMap(Map map)
    {
        c = InternalSDKUtil.getIntFromMap(map, "sf", 1, 0x7fffffffL);
        d = InternalSDKUtil.getIntFromMap(map, "dt", 1, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "max", 1, 0x7fffffffL);
        a = InternalSDKUtil.getIntFromMap(map, "nri", 1, 0x7fffffffL);
        e = InternalSDKUtil.getStringFromMap(map, "url");
    }
}
