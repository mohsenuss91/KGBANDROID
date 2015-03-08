// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.config;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.config:
//            AdTrackerConfigParams, a

public class AdTrackerInitializer
{

    public static final String PRODUCT_IAT = "iat";
    private static Context a = null;
    private static Map b = new HashMap();
    private static AdTrackerConfigParams c = new AdTrackerConfigParams();
    private static Logger d = new Logger(2, "iat");
    private static com.inmobi.commons.cache.CacheController.Validator e = new a();

    public AdTrackerInitializer()
    {
    }

    private static void a(Context context)
    {
        if (context == null || a != null) goto _L2; else goto _L1
_L1:
        if (a == null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        a = context.getApplicationContext();
        b = getUidMap(context);
        try
        {
            b(CacheController.getConfig("iat", context, b, e).getData());
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Exception while retreiving configs.");
        }
        return;
_L2:
        if (a == null && context == null)
        {
            a.getApplicationContext();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    static boolean a(Map map)
    {
        return b(map);
    }

    private static void b(Context context)
    {
        a(context);
        try
        {
            CacheController.getConfig("iat", context, b, e);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private static boolean b(Map map)
    {
        b = getUidMap(a);
        Map map1 = InternalSDKUtil.populateToNewMap((Map)map.get("AND"), (Map)map.get("common"), true);
        try
        {
            AdTrackerConfigParams adtrackerconfigparams = new AdTrackerConfigParams();
            adtrackerconfigparams.setFromMap(map1);
            c = adtrackerconfigparams;
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public static AdTrackerConfigParams getConfigParams()
    {
        if (InternalSDKUtil.getContext() != null && InMobi.getAppId() != null)
        {
            b(InternalSDKUtil.getContext());
        }
        d.setMetricConfigParams(c.getMetric());
        return c;
    }

    public static Logger getLogger()
    {
        return d;
    }

    public static Map getUidMap(Context context)
    {
        return UIDUtil.getMap(a, c.getUID());
    }

}
