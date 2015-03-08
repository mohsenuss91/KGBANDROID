// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.bootstrapper.NativeConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.data.AppInfo;
import com.inmobi.commons.data.UserInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.RequestBuilder;
import com.inmobi.commons.uid.UID;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class NativeAdRequest extends RequestBuilder
{

    private String a;
    private String b;
    private String c;
    private String d;
    private HashMap e;

    public NativeAdRequest(String s)
    {
        b = null;
        c = null;
        d = null;
        e = null;
        try
        {
            AppInfo.setAppId(s);
            a = s;
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Monetization]", "Failed to init Native Ad request", exception);
        }
    }

    public String buildPostBody()
    {
        return super.buildPostBody();
    }

    public String getAdFormatPostBody()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("format=native");
        stringbuilder.append((new StringBuilder("&mk-ads=")).append(Initializer.getConfigParams().getNativeSdkConfigParams().getmFetchLimit()).toString());
        return stringbuilder.toString();
    }

    public String getAppId()
    {
        return a;
    }

    protected String getPublisherPostBody()
    {
label0:
        {
            StringBuilder stringbuilder = new StringBuilder();
            if (e != null)
            {
                java.util.Map.Entry entry;
                for (Iterator iterator = e.entrySet().iterator(); iterator.hasNext(); stringbuilder.append("&").append(getURLEncoded(((String)entry.getKey()).toString())).append("=").append(getURLEncoded(((String)entry.getValue()).toString())))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            if (c != null && d != null)
            {
                stringbuilder.append("&").append(getURLEncoded(c)).append("=").append(getURLEncoded(d));
            }
            if (b != null)
            {
                stringbuilder.append("&p-keywords=");
                stringbuilder.append(getURLEncoded(b));
            }
            String s = stringbuilder.toString();
            String s1;
            try
            {
                if (s.charAt(0) != '&')
                {
                    break label0;
                }
                s1 = s.substring(1);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception);
                return s;
            }
            s = s1;
        }
        return s;
    }

    public String getUidMapPostBody()
    {
        HashMap hashmap = new HashMap();
        Long long2 = AnalyticsInitializer.getConfigParams().getLTVId();
        Long long1 = long2;
_L1:
label0:
        {
            if (long1 != null)
            {
                hashmap.put("LTVID", (new StringBuilder()).append(long1).toString());
            }
            String s = Integer.toString((new Random()).nextInt());
            String s1 = Initializer.getConfigParams().getUID().getUidMapWitoutXOR(UserInfo.getInstance().getDeviceIDMask(), s, hashmap);
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("u-id-adt=");
            Exception exception;
            String s2;
            String s3;
            if (InternalSDKUtil.isLimitAdTrackingEnabled())
            {
                stringbuilder.append(1);
            } else
            {
                stringbuilder.append(0);
            }
            s2 = null;
            if (s1 == null)
            {
                break label0;
            }
            stringbuilder.append("&u-id-map=");
            stringbuilder.append(getURLEncoded(s1));
            s2 = stringbuilder.toString();
            try
            {
                if (s2.charAt(0) != '&')
                {
                    break label0;
                }
                s3 = s2.substring(1);
            }
            catch (Exception exception1)
            {
                Log.internal("[InMobi]-4.4.1", "Couldn't build post string in Request Builder", exception1);
                return s2;
            }
            s2 = s3;
        }
        return s2;
        exception;
        Log.internal("[InMobi]-4.4.1", "LTVID not available yet in configs");
        long1 = null;
          goto _L1
    }

    public void setKeywords(String s)
    {
        if (s != null && !"".equals(s))
        {
            b = s;
        }
    }

    public void setRefTagParam(String s, String s1)
    {
        if (s != null && !"".equals(s) && s1 != null && !"".equals(s1))
        {
            c = s;
            d = s1;
        }
    }

    public void setRequestParams(Map map)
    {
        if (map != null && !map.isEmpty())
        {
            if (e == null)
            {
                e = new HashMap();
            }
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); e.put(s, map.get(s)))
            {
                s = (String)iterator.next();
            }

        }
    }
}
