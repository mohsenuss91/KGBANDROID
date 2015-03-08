// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import java.util.List;

public class AnalyticsPayload
{

    private String a;
    private List b;
    private String c;
    private int d;

    public AnalyticsPayload(String s, List list)
    {
        a = s;
        b = list;
    }

    public String getCompletePayload()
    {
        return c;
    }

    public String getOnlyEvent()
    {
        return a;
    }

    public int getPayloadSize()
    {
        return d;
    }

    public List getTableIdList()
    {
        return b;
    }

    public void setCompletePayload(String s)
    {
        c = s;
    }

    public void setPayloadSize(int i)
    {
        d = i;
    }
}
