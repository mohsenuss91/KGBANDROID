// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.cache:
//            JSONMapBuilder

public abstract class ProductConfig
{

    private String a;
    private String b;
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;

    public ProductConfig()
    {
        a = null;
        b = null;
        c = null;
        d = 0;
        e = 3;
        f = 60;
        g = 0;
        h = -1;
        i = true;
    }

    Map a(String s)
    {
        if (getProtocol().equals("json"))
        {
            return (new JSONMapBuilder()).buildMap(s);
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("data", s);
            return hashmap;
        }
    }

    public Map getData()
    {
        return a(c);
    }

    public int getExpiry()
    {
        return d;
    }

    public int getMaxRetry()
    {
        return e;
    }

    public String getProtocol()
    {
        return b;
    }

    public String getRawData()
    {
        return c;
    }

    public int getRetryInterval()
    {
        return f;
    }

    public int getRetryNumber()
    {
        return g;
    }

    public int getTimestamp()
    {
        return h;
    }

    public String getUrl()
    {
        return a;
    }

    public boolean isSendUidMap()
    {
        return i;
    }

    public void setData(String s)
    {
        c = s;
    }

    public void setExpiry(int j)
    {
        d = j;
    }

    public void setMaxRetry(int j)
    {
        e = j;
    }

    public void setProtocol(String s)
    {
        b = s;
    }

    public void setRetryInterval(int j)
    {
        f = j;
    }

    public void setRetryNumber(int j)
    {
        g = j;
    }

    public void setSendUidMap(boolean flag)
    {
        i = flag;
    }

    public void setTimestamp(int j)
    {
        h = j;
    }

    public void setUrl(String s)
    {
        a = s;
    }
}
