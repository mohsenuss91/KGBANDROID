// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.cache:
//            ProductConfig, RetryMechanism

public class ProductCacheConfig extends ProductConfig
{

    public static final int DEFAULT_EXPIRY = 0x69780;
    public static final int DEFAULT_INTERVAL = 60;
    public static final int DEFAULT_MAX_RETRY = 3;
    private static Timer a = new Timer();
    private AtomicBoolean b;
    private Map c;
    private CacheController.Validator d;
    private RetryMechanism e;
    private CacheController.Committer f;
    private long g;

    public ProductCacheConfig(JSONObject jsonobject)
    {
        b = new AtomicBoolean(false);
        c = new HashMap();
        d = null;
        e = new RetryMechanism(3, 60000, a);
        try
        {
            loadFromJSON(jsonobject);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "JSON retrieved is invalid.");
        }
    }

    public ProductCacheConfig(JSONObject jsonobject, CacheController.Committer committer)
    {
        this(jsonobject);
        f = committer;
    }

    private void a()
    {
        b b1;
        String s;
        try
        {
            b1 = c();
            s = b.a(b1);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", (new StringBuilder("Error connecting to url, or ")).append(getUrl()).append(" did not return 200. Purge cache update.").toString(), exception);
            throw exception;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        if (d != null && !d.validate(a(s)))
        {
            throw new IOException("Invalid config.");
        }
        setData(s);
        setTimestamp((int)(System.currentTimeMillis() / 1000L));
        g = b.b(b1);
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Product with url ")).append(getUrl()).append(" accepted data ").append(getRawData()).toString());
        f.onCommit();
        return;
        setTimestamp((int)(System.currentTimeMillis() / 1000L));
        g = b.b(b1);
        f.onCommit();
        return;
    }

    static void a(ProductCacheConfig productcacheconfig)
    {
        productcacheconfig.a();
    }

    static AtomicBoolean b(ProductCacheConfig productcacheconfig)
    {
        return productcacheconfig.b;
    }

    private void b()
    {
        if (!b.compareAndSet(false, true))
        {
            return;
        } else
        {
            e.rescheduleTimer(new a());
            return;
        }
    }

    private b c()
    {
        String s = "";
        String s1 = UIDUtil.bindToGetParam(c);
        String s2;
        URL url;
        HttpURLConnection httpurlconnection;
        int i;
        if (s1 != null && !"".equals(s1))
        {
            if (getUrl().endsWith("?"))
            {
                s2 = (new StringBuilder()).append(getUrl()).append(s1).toString();
            } else
            if (getUrl().contains("?"))
            {
                s2 = (new StringBuilder()).append(getUrl()).append("&").append(s1).toString();
            } else
            {
                s2 = (new StringBuilder()).append(getUrl()).append("?").append(s1).toString();
            }
        } else
        {
            s2 = getUrl();
        }
        url = new URL(s2);
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Sending request to ")).append(s2).append(" to retreive cache..").toString());
        httpurlconnection = (HttpURLConnection)url.openConnection();
        InternalSDKUtil.addCommonPropertiesToConnection(httpurlconnection);
        httpurlconnection.setIfModifiedSince(g);
        httpurlconnection.setRequestMethod("GET");
        i = httpurlconnection.getResponseCode();
        if (i == 304)
        {
            b b1 = new b(null);
            b.a(b1, null);
            b.a(b1, httpurlconnection.getLastModified());
            return b1;
        }
        if (i != 200)
        {
            throw new IOException("Server did not return 200. ");
        }
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
        do
        {
            String s3 = bufferedreader.readLine();
            if (s3 != null)
            {
                s = (new StringBuilder()).append(s).append(s3).toString();
            } else
            {
                bufferedreader.close();
                b b2 = new b(null);
                b.a(b2, s);
                b.a(b2, httpurlconnection.getLastModified());
                return b2;
            }
        } while (true);
    }

    public ProductConfig getConfig()
    {
        return this;
    }

    public String getData(CacheController.Validator validator)
    {
        if (validator != null)
        {
            d = validator;
        }
        setRetryNumber(0);
        int i = (int)(System.currentTimeMillis() / 1000L);
        if ((getTimestamp() + getExpiry()) - i <= 0)
        {
            b();
        }
        return getRawData();
    }

    public String getData(Map map, CacheController.Validator validator)
    {
        if (map != null)
        {
            c = map;
        }
        return getData(validator);
    }

    public Map getMap()
    {
        return c;
    }

    public CacheController.Validator getValidator()
    {
        return d;
    }

    public final void loadFromJSON(JSONObject jsonobject)
    {
        setExpiry(InternalSDKUtil.getIntFromJSON(jsonobject, "expiry", 0x69780));
        setMaxRetry(InternalSDKUtil.getIntFromJSON(jsonobject, "maxRetry", 3));
        setRetryInterval(InternalSDKUtil.getIntFromJSON(jsonobject, "retryInterval", 60));
        g = InternalSDKUtil.getLongFromJSON(jsonobject, "lastModified", 0L);
        setUrl(InternalSDKUtil.getStringFromJSON(jsonobject, "url", ""));
        setProtocol(InternalSDKUtil.getStringFromJSON(jsonobject, "protocol", "json"));
        e = new RetryMechanism(getMaxRetry(), 1000 * getRetryInterval(), a);
        setTimestamp(InternalSDKUtil.getIntFromJSON(jsonobject, "timestamp", 0));
        setData(InternalSDKUtil.getStringFromJSON(jsonobject, "data", null));
    }

    protected void reset()
    {
        setExpiry(0);
        setRetryInterval(0);
        setMaxRetry(0);
        setTimestamp(0);
        setUrl(null);
        setProtocol(null);
        setData(null);
    }

    public void setMap(Map map)
    {
        c = map;
    }

    public void setValidator(CacheController.Validator validator)
    {
        d = validator;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject((new StringBuilder("{expiry:")).append(getExpiry()).append(",maxRetry:").append(getMaxRetry()).append(",retryInterval:").append(getRetryInterval()).append(",protocol:").append(getProtocol()).append(",timestamp:").append(getTimestamp()).append("}").toString());
        jsonobject1.put("url", getUrl());
        jsonobject1.put("data", getRawData());
        jsonobject1.put("lastModified", g);
        return jsonobject1;
        JSONException jsonexception1;
        jsonexception1;
        JSONException jsonexception;
        jsonobject1 = jsonobject;
        jsonexception = jsonexception1;
_L2:
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Ill formed JSON product(")).append(getUrl()).append(") toString").toString(), jsonexception);
        return jsonobject1;
        jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String toString()
    {
        return toJSON().toString();
    }


    private class b
    {

        final ProductCacheConfig a;
        private String b;
        private long c;

        static long a(b b1, long l)
        {
            b1.c = l;
            return l;
        }

        static String a(b b1)
        {
            return b1.b;
        }

        static String a(b b1, String s)
        {
            b1.b = s;
            return s;
        }

        static long b(b b1)
        {
            return b1.c;
        }

        private b()
        {
            a = ProductCacheConfig.this;
            super();
        }

        b(a a1)
        {
            this();
        }
    }


    private class a
        implements RetryMechanism.RetryRunnable
    {

        final ProductCacheConfig a;

        public void completed()
        {
            ProductCacheConfig.b(a).set(false);
        }

        public void run()
        {
            try
            {
                if (InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
                {
                    ProductCacheConfig.a(a);
                    return;
                }
            }
            catch (Exception exception)
            {
                throw exception;
            }
            throw new IOException("Network unavailable");
        }

        a()
        {
            a = ProductCacheConfig.this;
            super();
        }
    }

}
