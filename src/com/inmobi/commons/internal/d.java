// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import java.util.Map;

// Referenced classes of package com.inmobi.commons.internal:
//            InternalSDKUtil

final class d
    implements com.inmobi.commons.cache.CacheController.Validator
{

    d()
    {
    }

    public final boolean validate(Map map)
    {
        return InternalSDKUtil.a(map);
    }
}
