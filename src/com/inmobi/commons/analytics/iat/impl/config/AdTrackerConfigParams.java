// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.config;

import android.content.Context;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.config:
//            AdTrackerGoalRetryParams

public class AdTrackerConfigParams
{

    private static final String a = (new StringBuilder("Starting.*: Intent.*(?:http://market.android.com/details|market://details|play.google.com).*(?:id=")).append(InternalSDKUtil.getContext().getPackageName()).append(").*referrer=([^&\\s]+)").toString();
    private int b;
    private int c;
    private String d;
    private AdTrackerGoalRetryParams e;
    private MetricConfigParams f;
    private UID g;

    public AdTrackerConfigParams()
    {
        b = 60;
        c = 300;
        d = a;
        e = new AdTrackerGoalRetryParams();
        f = new MetricConfigParams();
        g = new UID();
    }

    public int getConnectionTimeout()
    {
        return 1000 * b;
    }

    public String getLogcatPattern()
    {
        return d;
    }

    public MetricConfigParams getMetric()
    {
        return f;
    }

    public int getReferrerWaitTime()
    {
        return 0x493e0;
    }

    public int getReferrerWaitTimeRetryCount()
    {
        return 3;
    }

    public int getReferrerWaitTimeRetryInterval()
    {
        return 5000;
    }

    public AdTrackerGoalRetryParams getRetryParams()
    {
        return e;
    }

    public UID getUID()
    {
        return g;
    }

    public int getWebviewTimeout()
    {
        return 1000 * c;
    }

    public void setFromMap(Map map)
    {
        b = InternalSDKUtil.getIntFromMap(map, "cto", 1, 0x7fffffffL);
        c = InternalSDKUtil.getIntFromMap(map, "wto", 1, 0x7fffffffL);
        d = InternalSDKUtil.getStringFromMap(map, "rlp").replace("$PKG", InternalSDKUtil.getContext().getPackageName());
        e.setFromMap((Map)map.get("rp"));
        f.setFromMap((Map)map.get("metric"));
        g.setFromMap((Map)map.get("ids"));
    }

}
