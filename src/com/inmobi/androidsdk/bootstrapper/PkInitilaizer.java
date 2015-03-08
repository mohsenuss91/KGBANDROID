// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk.bootstrapper:
//            PkParams, b

public class PkInitilaizer
{

    public static final String PRODUCT_PK = "pk";
    private static Context a = null;
    private static Map b = new HashMap();
    private static PkParams c = new PkParams();
    private static com.inmobi.commons.cache.CacheController.Validator d = new b();

    public PkInitilaizer()
    {
    }

    private static void a(Context context)
    {
        b(context);
        try
        {
            CacheController.getConfig("pk", context, b, d);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    static boolean a(Map map)
    {
        Log.internal("SK", "Saving config to map");
        b = getUidMap(a);
        try
        {
            PkParams pkparams = new PkParams();
            pkparams.setFromMap(map);
            c = pkparams;
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
            if (CacheController.getConfig("pk", context, b, d).getData() != null)
            {
                a(CacheController.getConfig("pk", context, b, d).getData());
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

    public static PkParams getConfigParams()
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
