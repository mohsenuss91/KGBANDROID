// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AppGalleryConfigParams
{

    String a;

    public AppGalleryConfigParams()
    {
        a = "http://appgalleries.inmobi.com/inmobi_sdk";
    }

    public String getUrl()
    {
        return a;
    }

    public void setFromMap(Map map)
    {
        a = InternalSDKUtil.getStringFromMap(map, "url");
    }
}
