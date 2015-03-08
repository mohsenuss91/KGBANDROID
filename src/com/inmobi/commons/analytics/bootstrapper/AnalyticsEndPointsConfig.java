// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AnalyticsEndPointsConfig
{

    private String a;
    private String b;
    private String c;

    public AnalyticsEndPointsConfig()
    {
        a = "http://a.ai.inmobi.com/v2/ad.html";
        b = "https://rules-ltvp.inmobi.com/v2/rules.json";
        c = "https://e-ltvp.inmobi.com/storm/v1/event";
    }

    public String getEventsUrl()
    {
        return c;
    }

    public String getHouseUrl()
    {
        return a;
    }

    public String getRulesUrl()
    {
        return b;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getStringFromMap(map, "house");
        b = InternalSDKUtil.getStringFromMap(map, "rules");
        c = InternalSDKUtil.getStringFromMap(map, "events");
    }
}
