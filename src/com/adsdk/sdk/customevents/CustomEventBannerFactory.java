// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.customevents;

import java.lang.reflect.Constructor;

// Referenced classes of package com.adsdk.sdk.customevents:
//            CustomEventBanner

public class CustomEventBannerFactory
{

    private static CustomEventBannerFactory instance = new CustomEventBannerFactory();

    public CustomEventBannerFactory()
    {
    }

    public static CustomEventBanner create(String s)
    {
        return instance.internalCreate(s);
    }

    protected CustomEventBanner internalCreate(String s)
    {
        Constructor constructor = Class.forName((new StringBuilder("com.adsdk.sdk.customevents.")).append(s).append("Banner").toString()).asSubclass(com/adsdk/sdk/customevents/CustomEventBanner).getDeclaredConstructor(null);
        constructor.setAccessible(true);
        return (CustomEventBanner)constructor.newInstance(new Object[0]);
    }

}
