// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk.bootstrapper:
//            IMAIConfigParams, AppGalleryConfigParams, NativeConfigParams

public class ConfigParams
{

    int a;
    int b;
    int c;
    int d;
    IMAIConfigParams e;
    MetricConfigParams f;
    UID g;
    AppGalleryConfigParams h;
    NativeConfigParams i;

    public ConfigParams()
    {
        a = 20;
        b = 60;
        c = 60;
        d = 60;
        e = new IMAIConfigParams();
        f = new MetricConfigParams();
        g = new UID();
        h = new AppGalleryConfigParams();
        i = new NativeConfigParams();
    }

    public AppGalleryConfigParams getAppAppGalleryConfigParams()
    {
        return h;
    }

    public int getDefaultRefreshRate()
    {
        return b;
    }

    public int getFetchTimeOut()
    {
        return 1000 * c;
    }

    public IMAIConfigParams getImai()
    {
        return e;
    }

    public MetricConfigParams getMetric()
    {
        return f;
    }

    public int getMinimumRefreshRate()
    {
        return a;
    }

    public NativeConfigParams getNativeSdkConfigParams()
    {
        return i;
    }

    public int getRenderTimeOut()
    {
        return 1000 * d;
    }

    public UID getUID()
    {
        return g;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getIntFromMap(map, "mrr", 1, 0x7fffffffL);
        b = InternalSDKUtil.getIntFromMap(map, "drr", -1, 0x7fffffffL);
        c = InternalSDKUtil.getIntFromMap(map, "fto", 1, 0x7fffffffL);
        d = InternalSDKUtil.getIntFromMap(map, "rto", 1, 0x7fffffffL);
        e.setFromMap((Map)map.get("imai"));
        f.setFromMap((Map)map.get("metric"));
        g.setFromMap((Map)map.get("ids"));
        h.setFromMap((Map)map.get("ag"));
        i.setFromMap((Map)map.get("native"));
    }
}
