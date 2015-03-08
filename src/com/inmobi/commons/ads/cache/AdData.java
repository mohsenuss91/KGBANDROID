// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.ads.cache;


public class AdData
{

    private long a;
    private String b;
    private long c;
    private String d;
    private String e;

    public AdData()
    {
    }

    public long getAdId()
    {
        return a;
    }

    public String getAdType()
    {
        return e;
    }

    public String getAppId()
    {
        return b;
    }

    public String getContent()
    {
        return d;
    }

    public long getTimestamp()
    {
        return c;
    }

    public void setAdId(long l)
    {
        a = l;
    }

    public void setAdType(String s)
    {
        e = s;
    }

    public void setAppId(String s)
    {
        b = s;
    }

    public void setContent(String s)
    {
        d = s;
    }

    public void setTimestamp(long l)
    {
        c = l;
    }
}
