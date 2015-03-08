// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class NativeConfigParams
{

    int a;
    int b;
    int c;

    public NativeConfigParams()
    {
        a = 100;
        b = 3;
        c = 10;
    }

    public int getmFetchLimit()
    {
        return c;
    }

    public int getmMaxCacheSize()
    {
        return a;
    }

    public int getmMinLimit()
    {
        return b;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getIntFromMap(map, "mcl", 1, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "mt", 1, 0x7fffffffL);
        c = InternalSDKUtil.getIntFromMap(map, "fl", 1, 0x7fffffffL);
    }
}
