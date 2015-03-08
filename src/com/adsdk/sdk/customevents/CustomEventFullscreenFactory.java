// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.customevents;

import java.lang.reflect.Constructor;

// Referenced classes of package com.adsdk.sdk.customevents:
//            CustomEventFullscreen

public class CustomEventFullscreenFactory
{

    private static CustomEventFullscreenFactory instance = new CustomEventFullscreenFactory();

    public CustomEventFullscreenFactory()
    {
    }

    public static CustomEventFullscreen create(String s)
    {
        return instance.internalCreate(s);
    }

    protected CustomEventFullscreen internalCreate(String s)
    {
        Constructor constructor = Class.forName((new StringBuilder("com.adsdk.sdk.customevents.")).append(s).append("Fullscreen").toString()).asSubclass(com/adsdk/sdk/customevents/CustomEventFullscreen).getDeclaredConstructor(null);
        constructor.setAccessible(true);
        return (CustomEventFullscreen)constructor.newInstance(new Object[0]);
    }

}
