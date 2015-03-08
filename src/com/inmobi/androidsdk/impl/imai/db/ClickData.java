// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.imai.db;

import com.inmobi.androidsdk.impl.imai.IMAICore;

public class ClickData
{

    private long a;
    private String b;
    private boolean c;
    private int d;
    private boolean e;
    private long f;

    public ClickData()
    {
    }

    public ClickData(String s, boolean flag, boolean flag1, int i)
    {
        setClickId(IMAICore.getRandomNumber());
        setClickUrl(s);
        setFollowRedirect(flag);
        setPingWv(flag1);
        setRetryCount(i);
        setTimestamp(System.currentTimeMillis());
    }

    public long getClickId()
    {
        return a;
    }

    public String getClickUrl()
    {
        return b;
    }

    public int getRetryCount()
    {
        return d;
    }

    public long getTimestamp()
    {
        return f;
    }

    public boolean isFollowRedirects()
    {
        return e;
    }

    public boolean isPingWv()
    {
        return c;
    }

    public void setClickId(long l)
    {
        a = l;
    }

    public void setClickUrl(String s)
    {
        b = s;
    }

    public void setFollowRedirect(boolean flag)
    {
        e = flag;
    }

    public void setPingWv(boolean flag)
    {
        c = flag;
    }

    public void setRetryCount(int i)
    {
        d = i;
    }

    public void setTimestamp(long l)
    {
        f = l;
    }
}
