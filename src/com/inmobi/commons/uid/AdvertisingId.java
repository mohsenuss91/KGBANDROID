// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.uid;


public class AdvertisingId
{

    private String a;
    private boolean b;

    public AdvertisingId()
    {
    }

    void a(String s)
    {
        a = s;
    }

    void a(boolean flag)
    {
        b = flag;
    }

    public String getAdId()
    {
        return a;
    }

    public boolean isLimitAdTracking()
    {
        return b;
    }
}
