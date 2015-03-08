// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import java.util.List;

public class NativeAdResponse
{

    public static final String KEY_ADS = "ads";
    public static final String KEY_CONTEXTCODE = "contextCode";
    public static final String KEY_NAMESPACE = "namespace";
    public static final String KEY_PUBCONTENT = "pubContent";
    private List a;

    NativeAdResponse(List list)
    {
        if (list != null)
        {
            a = list;
        }
    }

    List a()
    {
        return a;
    }
}
