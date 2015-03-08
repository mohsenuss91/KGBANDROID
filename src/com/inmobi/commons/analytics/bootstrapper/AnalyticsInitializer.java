// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.bootstrapper;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.bootstrapper:
//            AnalyticsConfigParams, a

public class AnalyticsInitializer
{

    public static final String PRODUCT_ANALYTICS = "ltvp";
    private static Context a = null;
    private static Map b = new HashMap();
    private static AnalyticsConfigParams c = new AnalyticsConfigParams();
    private static com.inmobi.commons.cache.CacheController.Validator d = new a();

    public AnalyticsInitializer()
    {
    }

    private static void a(Context context)
    {
        if (context != null && a == null)
        {
            if (a == null)
            {
                a = context.getApplicationContext();
                b = getUidMap(context);
                try
                {
                    ProductConfig productconfig = CacheController.getConfig("ltvp", context, b, d);
                    if (productconfig.getRawData() != null)
                    {
                        b(productconfig.getData());
                        return;
                    }
                }
                catch (CommonsException commonsexception)
                {
                    Log.internal("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Exception while retreiving configs due to commons Exception with code ")).append(commonsexception.getCode()).toString());
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[Analytics]-4.4.1", "Exception while retreiving configs.", exception);
                    return;
                }
            }
        } else
        if (a == null && context == null)
        {
            a.getApplicationContext();
            return;
        }
    }

    static boolean a(Map map)
    {
        return b(map);
    }

    private static void b(Context context)
    {
        a(context);
        b = getUidMap(a);
        try
        {
            CacheController.getConfig("ltvp", context, b, d);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private static boolean b(Map map)
    {
        AnalyticsConfigParams analyticsconfigparams = new AnalyticsConfigParams();
        try
        {
            analyticsconfigparams.setFromMap((Map)map.get("common"));
            c = analyticsconfigparams;
            ThinICE.setConfig(analyticsconfigparams.getThinIceConfig());
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Exception while saving configs.", exception);
            return false;
        }
        return true;
    }

    public static AnalyticsConfigParams getConfigParams()
    {
        if (InternalSDKUtil.getContext() != null && InMobi.getAppId() != null)
        {
            b(InternalSDKUtil.getContext());
        }
        return c;
    }

    public static AnalyticsConfigParams getRawConfigParams()
    {
        return c;
    }

    public static Map getUidMap(Context context)
    {
        return UIDUtil.getMap(a, c.getUID());
    }

}
