// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.uid.UID;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.bootstrapper:
//            AnalyticsEndPointsConfig, ThinICEConfig, AutomaticCaptureConfig

public class AnalyticsConfigParams
{

    private static final Long a = null;
    private UID b;
    private AnalyticsEndPointsConfig c;
    private ThinICEConfig d;
    private Long e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private AutomaticCaptureConfig n;
    private int o;

    public AnalyticsConfigParams()
    {
        b = new UID();
        c = new AnalyticsEndPointsConfig();
        d = new ThinICEConfig();
        e = a;
        f = 5;
        g = 1000;
        h = 100;
        i = 3;
        j = 20;
        k = 50;
        l = 100;
        m = 5;
        n = new AutomaticCaptureConfig();
        o = 100;
    }

    public AutomaticCaptureConfig getAutomaticCapture()
    {
        return n;
    }

    public AnalyticsEndPointsConfig getEndPoints()
    {
        return c;
    }

    public int getExtraParamsLimit()
    {
        return l;
    }

    public int getGetParamsLimit()
    {
        return h;
    }

    public Long getLTVId()
    {
        return e;
    }

    public int getMaxAppIdLength()
    {
        return o;
    }

    public int getMaxDbEvents()
    {
        return g;
    }

    public int getMaxKeyLength()
    {
        return j;
    }

    public int getMaxRetryBeforeCacheDiscard()
    {
        return m;
    }

    public int getMaxValLength()
    {
        return k;
    }

    public int getMinEventsToCompress()
    {
        return f;
    }

    public int getPingInterval()
    {
        return 1000 * i;
    }

    public ThinICEConfig getThinIceConfig()
    {
        return d;
    }

    public UID getUID()
    {
        return b;
    }

    public void setFromMap(Map map)
    {
        h = InternalSDKUtil.getIntFromMap(map, "elim", 1, 0x7fffffffL);
        g = InternalSDKUtil.getIntFromMap(map, "mdb", 1, 0x7fffffffL);
        j = InternalSDKUtil.getIntFromMap(map, "mkey", 1, 0x7fffffffL);
        k = InternalSDKUtil.getIntFromMap(map, "mval", 1, 0x7fffffffL);
        i = InternalSDKUtil.getIntFromMap(map, "pint", 1, 0x7fffffffL);
        l = InternalSDKUtil.getIntFromMap(map, "plim", 1, 0x7fffffffL);
        e = Long.valueOf(InternalSDKUtil.getLongFromMap(map, "ltvid", 0x8000000000000000L, 0x7fffffffffffffffL));
        f = InternalSDKUtil.getIntFromMap(map, "mec", 1, 0x7fffffffL);
        m = InternalSDKUtil.getIntFromMap(map, "mr", 0, 0x7fffffffL);
        o = InternalSDKUtil.getIntFromMap(map, "aidl", 1, 0x7fffffffL);
        b.setFromMap((Map)map.get("ids"));
        c.setFromMap((Map)map.get("endpoints"));
        d.setFromMap((Map)map.get("tic"));
        n.setFromMap((Map)map.get("at"));
    }

}
