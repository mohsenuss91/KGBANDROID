// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.cache;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class LocalCache
{

    public static final String FILENAME = "inmobi.cache";
    private static String a = "{url:'https://inmobisdk-a.akamaihd.net/sdk/configs/400/rootConfig.json'}";
    private static JSONObject b = new JSONObject();

    private LocalCache()
    {
    }

    static void a()
    {
        c();
    }

    public static JSONObject addToCache(String s, JSONObject jsonobject)
    {
        synchronized (b)
        {
            if (b.toString().equals("{}"))
            {
                initRoot();
            }
            b.put(s, jsonobject);
        }
        b();
        return null;
    }

    private static void b()
    {
        (new Thread(new a())).start();
    }

    private static void c()
    {
        JSONObject jsonobject = b;
        jsonobject;
        JVM INSTR monitorenter ;
        String s = b.toString();
        FileOperations.writeStringToFile(InternalSDKUtil.getContext(), "inmobi.cache", s, false);
_L1:
        return;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Unable to save all configs to persistent memory", exception1);
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public static JSONObject getCacheForProduct(String s)
    {
        if (b.toString().equals("{}"))
        {
            initRoot();
        }
        JSONObject jsonobject;
        try
        {
            jsonobject = b.getJSONObject(s);
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return jsonobject;
    }

    public static JSONObject getRoot()
    {
        return b;
    }

    public static void initRoot()
    {
        if (b.toString().equals("{}")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject = b;
        jsonobject;
        JVM INSTR monitorenter ;
        String s = FileOperations.readFileAsString(InternalSDKUtil.getContext(), "inmobi.cache");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (!"".equals(s))
        {
            break MISSING_BLOCK_LABEL_58;
        }
        Log.internal("[InMobi]-4.4.1", "Configs not present in persistence. Using default configs.");
        s = a;
        b = new JSONObject(s);
_L3:
        jsonobject;
        JVM INSTR monitorexit ;
        if (b.toString().equals("{}"))
        {
            try
            {
                b = new JSONObject(a);
                return;
            }
            catch (JSONException jsonexception1)
            {
                Log.internal("[InMobi]-4.4.1", "Default JSON root is unable to parse? What sorcery is this?", jsonexception1);
            }
            return;
        }
          goto _L1
        IOException ioexception;
        ioexception;
        Log.internal("[InMobi]-4.4.1", "Unable to read configs from persistent memory", ioexception);
          goto _L3
        Exception exception;
        exception;
        throw exception;
        JSONException jsonexception;
        jsonexception;
        Log.internal("[InMobi]-4.4.1", "Ill formed JSON while parsing from persistent memory", jsonexception);
          goto _L3
    }

    public static void reset()
    {
        b = new JSONObject();
        c();
        initRoot();
    }

    public static void saveRoot(JSONObject jsonobject)
    {
        b = jsonobject;
        b();
    }


    private class a
        implements Runnable
    {

        public final void run()
        {
            LocalCache.a();
        }

        a()
        {
        }
    }

}
