// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;


class 
{

    static final int a[];

    static 
    {
        a = new int[.values().length];
        try
        {
            a[.AD_CLICK_IN_PROGRESS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[.AD_DOWNLOAD_IN_PROGRESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
