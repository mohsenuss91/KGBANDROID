// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


class 
{

    static final int a[];

    static 
    {
        a = new int[com.inmobi.androidsdk.values().length];
        try
        {
            a[com.inmobi.androidsdk.AD_CLICK_IN_PROGRESS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[com.inmobi.androidsdk.AD_DOWNLOAD_IN_PROGRESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.inmobi.androidsdk.AD_FETCH_TIMEOUT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.inmobi.androidsdk.AD_RENDERING_TIMEOUT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.inmobi.androidsdk.INTERNAL_ERROR.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.inmobi.androidsdk.INVALID_APP_ID.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[com.inmobi.androidsdk.INVALID_REQUEST.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[com.inmobi.androidsdk.NETWORK_ERROR.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[com.inmobi.androidsdk.NO_FILL.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror8)
        {
            return;
        }
    }
}
