// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import java.util.HashMap;

public class GetLtvpRulesResponse
{

    private String a;
    private long b;
    private HashMap c;
    private long d;
    private long e;

    public GetLtvpRulesResponse()
    {
    }

    public long getHardExpiry()
    {
        return e;
    }

    public String getRuleId()
    {
        return a;
    }

    public HashMap getRules()
    {
        return c;
    }

    public long getSoftExpiry()
    {
        return d;
    }

    public long getTimeStamp()
    {
        return b;
    }

    public void setHardExpiry(long l)
    {
        e = l;
    }

    public void setRuleId(String s)
    {
        a = s;
    }

    public void setRules(HashMap hashmap)
    {
        c = hashmap;
    }

    public void setSoftExpiry(long l)
    {
        d = l;
    }

    public void setTimeStamp(long l)
    {
        b = l;
    }
}
