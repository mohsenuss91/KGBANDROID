// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.commons.cache:
//            ProductCacheConfig

class a
    implements unnable
{

    final ProductCacheConfig a;

    public void completed()
    {
        ProductCacheConfig.b(a).set(false);
    }

    public void run()
    {
        try
        {
            if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
            {
                ProductCacheConfig.a(a);
                return;
            }
        }
        catch (Exception exception)
        {
            throw exception;
        }
        throw new IOException("Network unavailable");
    }

    unnable(ProductCacheConfig productcacheconfig)
    {
        a = productcacheconfig;
        super();
    }
}
