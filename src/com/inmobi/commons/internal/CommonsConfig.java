// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.internal:
//            InternalSDKUtil, Log

public class CommonsConfig
{

    private static Log.INTERNAL_LOG_LEVEL a;
    private static Log.INTERNAL_LOG_LEVEL b;
    private MetricConfigParams c;

    public CommonsConfig()
    {
        c = new MetricConfigParams();
    }

    protected static int getLogLevelConfig()
    {
        return b.getValue();
    }

    public MetricConfigParams getApiStatsConfig()
    {
        return c;
    }

    public final void setFromMap(Map map)
    {
        Map map1 = InternalSDKUtil.populateToNewMap((Map)map.get("AND"), (Map)map.get("common"), true);
        (new UID()).setFromMap((Map)map1.get("ids"));
        UID.getCommonsUid().setFromMap((Map)map1.get("ids"));
        b = Log.getLogLevelValue(InternalSDKUtil.getIntFromMap(map1, "ll", 0, 2L));
        c.setFromMap((Map)map1.get("api"));
    }

    static 
    {
        Log.INTERNAL_LOG_LEVEL internal_log_level = Log.INTERNAL_LOG_LEVEL.NONE;
        a = internal_log_level;
        b = internal_log_level;
    }
}
