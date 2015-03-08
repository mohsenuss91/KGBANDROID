// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import android.content.Context;
import android.content.IntentFilter;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.cache:
//            ProductCacheConfig, LocalCache, ProductConfig

public final class CacheController
{

    private static Map a = new HashMap();
    private static ProductCacheConfig b = null;
    private static boolean c = true;
    private static Map d = new HashMap();
    private static Map e = new HashMap();

    private CacheController()
    {
    }

    static void a()
    {
        Map map = d;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = d.keySet().iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        s = (String)iterator.next();
        if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) goto _L2; else goto _L1
_L1:
        Map map2;
        synchronized (e)
        {
            map2 = (Map)e.get(s);
        }
        getConfig(s, null, map2, (Validator)d.get(s));
          goto _L2
        CommonsException commonsexception;
        commonsexception;
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Unable to reinitialize product ")).append(s).toString());
          goto _L2
        Exception exception;
        exception;
        throw exception;
        exception1;
        map1;
        JVM INSTR monitorexit ;
        throw exception1;
        map;
        JVM INSTR monitorexit ;
        if (b != null)
        {
            b.getData(null);
        }
        return;
    }

    static boolean a(Map map)
    {
        return b(map);
    }

    static Map b()
    {
        return a;
    }

    private static boolean b(Map map)
    {
        try
        {
            Map map1 = InternalSDKUtil.populateToNewMap((Map)map.get("AND"), (Map)map.get("common"), true);
            c(map1);
            Iterator iterator = map1.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = map1.get((String)iterator.next());
                if (obj instanceof Map)
                {
                    c((Map)obj);
                }
            } while (true);
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    static void c()
    {
        f();
    }

    private static void c(Map map)
    {
        InternalSDKUtil.getIntFromMap(map, "expiry", 1, 0x7fffffffL);
        InternalSDKUtil.getIntFromMap(map, "maxRetry", 0, 0x7fffffffL);
        InternalSDKUtil.getIntFromMap(map, "retryInterval", 1, 0x7fffffffL);
        InternalSDKUtil.getStringFromMap(map, "url");
        InternalSDKUtil.getStringFromMap(map, "protocol");
    }

    private static void d()
    {
        InternalSDKUtil.getContext().registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private static void e()
    {
        Iterator iterator;
        Log.internal("[InMobi]-4.4.1", "Bootstrapping cache.");
        LocalCache.initRoot();
        iterator = LocalCache.getRoot().keys();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        ProductCacheConfig productcacheconfig1;
        ProductCacheConfig productcacheconfig2;
        Object obj = LocalCache.getRoot().get(s);
        if (!(obj instanceof JSONObject))
        {
            continue; /* Loop/switch isn't completed */
        }
        productcacheconfig1 = new ProductCacheConfig((JSONObject)obj, new b(s));
        productcacheconfig2 = (ProductCacheConfig)a.get(s);
        if (productcacheconfig2 == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        productcacheconfig1.setValidator(productcacheconfig2.getValidator());
        productcacheconfig1.setMap(productcacheconfig2.getMap());
        a.put(s, productcacheconfig1);
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        Log.internal("[InMobi]-4.4.1", "Unable to dump config from persistent memory to products in memory", jsonexception);
        if (true) goto _L2; else goto _L1
_L1:
        if (b == null)
        {
            ProductCacheConfig productcacheconfig = new ProductCacheConfig(LocalCache.getRoot(), new c());
            b = productcacheconfig;
            productcacheconfig.getData(UIDUtil.getMap(InternalSDKUtil.getContext(), null), new d());
        } else
        {
            b.loadFromJSON(LocalCache.getRoot());
        }
        InternalSDKUtil.initialize(InternalSDKUtil.getContext());
        return;
    }

    private static void f()
    {
        JSONObject jsonobject1;
        Iterator iterator;
        String s;
        JSONException jsonexception2;
        Exception exception;
        Object obj;
        ProductCacheConfig productcacheconfig;
        try
        {
            JSONObject jsonobject = new JSONObject(b.getRawData());
            jsonobject1 = InternalSDKUtil.populateToNewJSON(jsonobject.getJSONObject("AND"), jsonobject.getJSONObject("common"), true);
        }
        catch (JSONException jsonexception)
        {
            return;
        }
        try
        {
            jsonobject1.put("timestamp", (int)(System.currentTimeMillis() / 1000L));
        }
        catch (JSONException jsonexception1)
        {
            Log.internal("[InMobi]-4.4.1", "Unable to add timestamp to JSON");
        }
        iterator = jsonobject1.keys();
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_187;
        }
        s = (String)iterator.next();
        obj = LocalCache.getRoot().get(s);
        if (!(obj instanceof JSONObject))
        {
            continue; /* Loop/switch isn't completed */
        }
        productcacheconfig = (ProductCacheConfig)a.get(s);
        if (productcacheconfig != null)
        {
            try
            {
                ((JSONObject)obj).put("timestamp", 0);
                ((JSONObject)obj).put("data", productcacheconfig.getRawData());
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.4.1", (new StringBuilder("Error while merging data -> ")).append(exception.getMessage()).toString());
            }
        }
        continue; /* Loop/switch isn't completed */
        LocalCache.saveRoot(jsonobject1);
        e();
        a();
        return;
        jsonexception2;
        if (true) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_202;
_L2:
        break MISSING_BLOCK_LABEL_52;
    }

    public static ProductConfig getConfig(String s, Context context, Map map, Validator validator)
    {
        if (validator != null)
        {
            synchronized (d)
            {
                d.put(s, validator);
            }
        }
        if (map != null)
        {
            synchronized (e)
            {
                e.put(s, map);
            }
        }
        if (c)
        {
            if (InternalSDKUtil.getContext() == null)
            {
                if (context == null)
                {
                    throw new CommonsException(1);
                }
                InternalSDKUtil.setContext(context);
            }
            c = false;
            e();
            d();
        }
        b.getData(null);
        ProductCacheConfig productcacheconfig = (ProductCacheConfig)a.get(s);
        if (productcacheconfig == null)
        {
            throw new CommonsException(2);
        } else
        {
            productcacheconfig.getData(map, validator);
            return productcacheconfig;
        }
    }


    private class Validator
    {

        public abstract boolean validate(Map map);
    }


    private class a extends BroadcastReceiver
    {

        public final void onReceive(Context context, Intent intent)
        {
            CacheController.a();
        }

        a()
        {
        }
    }


    private class b
        implements Committer
    {

        final String a;

        public final void onCommit()
        {
            ProductCacheConfig productcacheconfig = (ProductCacheConfig)CacheController.b().get(a);
            if (productcacheconfig == null)
            {
                return;
            }
            try
            {
                LocalCache.addToCache(a, productcacheconfig.toJSON());
                return;
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-4.4.1", "Unable to add json to persistent memory", jsonexception);
            }
            return;
        }

        b(String s)
        {
            a = s;
            super();
        }
    }


    private class c
        implements Committer
    {

        public final void onCommit()
        {
            CacheController.c();
        }

        c()
        {
        }
    }


    private class d
        implements Validator
    {

        public final boolean validate(Map map)
        {
            return CacheController.a(map);
        }

        d()
        {
        }
    }

}
