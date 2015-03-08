// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk.bootstrapper:
//            PkInitilaizer

final class b
    implements com.inmobi.commons.cache.CacheController.Validator
{

    b()
    {
    }

    public final boolean validate(Map map)
    {
        return PkInitilaizer.a(map);
    }
}
