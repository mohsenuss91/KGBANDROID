// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.configs;

import java.util.Map;

// Referenced classes of package com.inmobi.re.configs:
//            Initializer

final class a
    implements com.inmobi.commons.cache.CacheController.Validator
{

    a()
    {
    }

    public final boolean validate(Map map)
    {
        return Initializer.a(map);
    }
}
