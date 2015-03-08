// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AutomaticCaptureConfig
{

    private boolean a;
    private boolean b;

    public AutomaticCaptureConfig()
    {
        a = true;
        b = false;
    }

    public boolean getAutoPurchaseCapture()
    {
        return b;
    }

    public boolean getAutoSessionCapture()
    {
        return a;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getBooleanFromMap(map, "session");
        b = InternalSDKUtil.getBooleanFromMap(map, "purchase");
    }
}
