// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.carb;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk.carb:
//            CarbConfigParams, a

public class CarbInitializer
{

    public static final String PRODUCT_CARB = "carb";
    private static Context a = null;
    private static Map b = new HashMap();
    private static CarbConfigParams c = new CarbConfigParams();
    private static com.inmobi.commons.cache.CacheController.Validator d = new a();

    public CarbInitializer()
    {
    }

    private static void a(Context context)
    {
        b(context);
        try
        {
            CacheController.getConfig("carb", context, b, d);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    static boolean a(Map map)
    {
        Log.internal("CARB", "Saving config to map");
        b = getUidMap(a);
        try
        {
            Map map1 = InternalSDKUtil.populateToNewMap((Map)map.get("AND"), (Map)map.get("common"), true);
            CarbConfigParams carbconfigparams = new CarbConfigParams();
            carbconfigparams.setFromMap(map1);
            c = carbconfigparams;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Config couldn't be parsed", exception);
            return false;
        }
        return true;
    }

    private static void b(Context context)
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
            if (CacheController.getConfig("carb", context, b, d).getData() != null)
            {
                a(CacheController.getConfig("carb", context, b, d).getData());
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (a == null && context == null)
        {
            throw new NullPointerException();
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static CarbConfigParams getConfigParams()
    {
        if (InternalSDKUtil.getContext() != null && InMobi.getAppId() != null)
        {
            a(InternalSDKUtil.getContext());
        }
        return c;
    }

    public static Map getUidMap(Context context)
    {
        return UIDUtil.getMap(context, c.getUID());
    }

    public static void initialize()
    {
        getConfigParams();
    }

}
