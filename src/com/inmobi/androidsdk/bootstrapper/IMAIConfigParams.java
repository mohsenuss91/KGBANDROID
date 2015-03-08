// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class IMAIConfigParams
{

    int a;
    int b;
    int c;
    int d;
    int e;

    public IMAIConfigParams()
    {
        a = 3;
        b = 10;
        c = 120;
        d = 10;
        e = 1000;
    }

    public int getMaxRetry()
    {
        return a;
    }

    public int getPingTimeOut()
    {
        return 1000 * c;
    }

    public int getRetryInterval()
    {
        return 1000 * b;
    }

    public int getmDefaultEventsBatch()
    {
        return d;
    }

    public int getmMaxDb()
    {
        return e;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getIntFromMap(map, "mr", 0, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "pint", 1, 0x7fffffffL);
        c = InternalSDKUtil.getIntFromMap(map, "pto", 1, 0x7fffffffL);
        d = InternalSDKUtil.getIntFromMap(map, "eb", 1, 0x7fffffffL);
        e = InternalSDKUtil.getIntFromMap(map, "mdb", 1, 0x7fffffffL);
    }

    public void setmDefaultEventsBatch(int i)
    {
        d = i;
    }

    public void setmMaxDb(int i)
    {
        e = i;
    }
}
