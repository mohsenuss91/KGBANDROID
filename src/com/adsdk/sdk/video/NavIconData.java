// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import java.io.Serializable;

public class NavIconData
    implements Serializable
{

    public static final int TYPE_EXTERNAL = 1;
    public static final int TYPE_INAPP = 0;
    private static final long serialVersionUID = 0xa1738b98884f1c25L;
    String clickUrl;
    String iconUrl;
    int openType;
    String title;

    public NavIconData()
    {
    }

    public String toString()
    {
        return (new StringBuilder("NavIconData [title=")).append(title).append(", iconUrl=").append(iconUrl).append(", openType=").append(openType).append(", clickUrl=").append(clickUrl).append("]").toString();
    }
}
