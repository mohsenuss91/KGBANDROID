// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.carb;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public class CarbConfigParams
{

    boolean a;
    String b;
    String c;
    long d;
    int e;
    long f;
    long g;
    UID h;

    public CarbConfigParams()
    {
        a = false;
        b = "http://dock.inmobi.com/carb/v1/i";
        c = "http://dock.inmobi.com/carb/v1/o";
        d = 0x15180L;
        e = 3;
        f = 60L;
        g = 60L;
        h = new UID();
    }

    public String getCarbEndpoint()
    {
        return b;
    }

    public String getCarbPostpoint()
    {
        return c;
    }

    public long getRetreiveFrequncy()
    {
        return 1000L * d;
    }

    public int getRetryCount()
    {
        return e;
    }

    public long getRetryInterval()
    {
        return f;
    }

    public long getTimeoutInterval()
    {
        return g;
    }

    public UID getUID()
    {
        return h;
    }

    public boolean isCarbEnabled()
    {
        return a;
    }

    public void setFromMap(Map map)
    {
        try
        {
            h.setFromMap((Map)map.get("ids"));
            a = InternalSDKUtil.getBooleanFromMap(map, "enabled");
            b = InternalSDKUtil.getStringFromMap(map, "gep");
            if (!b.startsWith("http") && !b.startsWith("https"))
            {
                throw new IllegalArgumentException("URL wrong");
            }
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.internal("CarbConfigParams", "Invalid value");
            h = new UID();
            a = false;
            b = "http://dock.inmobi.com/carb/v1/i";
            c = "http://dock.inmobi.com/carb/v1/o";
            d = 0x15180L;
            e = 3;
            f = 60L;
            g = 60L;
            throw new IllegalArgumentException();
        }
        c = InternalSDKUtil.getStringFromMap(map, "pep");
        if (!c.startsWith("http") && !c.startsWith("https"))
        {
            throw new IllegalArgumentException("URL wrong");
        } else
        {
            d = InternalSDKUtil.getLongFromMap(map, "fq_s", 1L, 0x7fffffffffffffffL);
            e = InternalSDKUtil.getIntFromMap(map, "mr", 0, 0x7fffffffL);
            f = InternalSDKUtil.getLongFromMap(map, "ri", 1L, 0x7fffffffffffffffL);
            g = InternalSDKUtil.getLongFromMap(map, "to", 1L, 0x7fffffffffffffffL);
            return;
        }
    }
}
