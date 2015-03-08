// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import com.inmobi.commons.internal.Log;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.inmobi.commons.cache:
//            CacheController, ProductCacheConfig, LocalCache

final class a
    implements mmitter
{

    final String a;

    public final void onCommit()
    {
        ProductCacheConfig productcacheconfig = (ProductCacheConfig)CacheController.b().get(a);
        if (productcacheconfig == null)
        {
            return;
        }
        try
        {
            LocalCache.addToCache(a, productcacheconfig.toJSON());
            return;
        }
        catch (JSONException jsonexception)
        {
            Log.internal("[InMobi]-4.4.1", "Unable to add json to persistent memory", jsonexception);
        }
        return;
    }

    (String s)
    {
        a = s;
        super();
    }
}
