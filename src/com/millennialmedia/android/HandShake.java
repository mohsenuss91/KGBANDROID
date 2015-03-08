// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.millennialmedia.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, MRaid, PreCacheWorker, MMSDK, 
//            DTOCachedVideo

class HandShake
{

    static final String BASE_URL = "http://androidsdk.ads.mp.mydas.mobi/";
    static final String BASE_URL_PATH = "getAd.php5?";
    private static final String HANDSHAKE_FALLBACK_URL = "http://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static final String HANDSHAKE_HTTPS_SCHEME = "https://";
    private static final String HANDSHAKE_HTTP_SCHEME = "http://";
    private static final String HANDSHAKE_URL_HOST = "ads.mp.mydas.mobi/";
    private static final String HANDSHAKE_URL_OVERRIDE_PARMS = "?apid=";
    private static final String HANDSHAKE_URL_PARMS = "appConfigServlet?apid=";
    private static final String KEY_CACHED_VIDEOS = "handshake_cachedvideos5.0";
    private static String adUrl = "http://androidsdk.ads.mp.mydas.mobi/getAd.php5?";
    static String apid = "28913";
    private static boolean forceRefresh;
    private static String handShakeURL = "https://ads.mp.mydas.mobi/appConfigServlet?apid=";
    private static HandShake sharedInstance;
    long adRefreshSecs;
    private LinkedHashMap adTypeHandShakes;
    private WeakReference appContextRef;
    DTOCachedVideo cachedVideos[];
    private WeakReference contextRef;
    long creativeCacheTimeout;
    private long deferredViewTimeout;
    String endSessionURL;
    private long handShakeCallback;
    private final Handler handler;
    boolean hardwareAccelerationEnabled;
    boolean kill;
    private long lastHandShake;
    String mmdid;
    String mmjsUrl;
    private String noVideosToCacheURL;
    private ArrayList schemes;
    private String schemesList;
    String startSessionURL;
    private Runnable updateHandShakeRunnable;

    private HandShake()
    {
        handler = new Handler(Looper.getMainLooper());
        adTypeHandShakes = new LinkedHashMap();
        schemes = new ArrayList();
        deferredViewTimeout = 0x36ee80L;
        kill = false;
        handShakeCallback = 0x5265c00L;
        creativeCacheTimeout = 0xf731400L;
        updateHandShakeRunnable = new _cls2();
    }

    private HandShake(Context context)
    {
        handler = new Handler(Looper.getMainLooper());
        adTypeHandShakes = new LinkedHashMap();
        schemes = new ArrayList();
        deferredViewTimeout = 0x36ee80L;
        kill = false;
        handShakeCallback = 0x5265c00L;
        creativeCacheTimeout = 0xf731400L;
        updateHandShakeRunnable = new _cls2();
        contextRef = new WeakReference(context);
        appContextRef = new WeakReference(context.getApplicationContext());
        if (forceRefresh || !loadHandShake(context) || System.currentTimeMillis() - lastHandShake > handShakeCallback)
        {
            forceRefresh = false;
            lastHandShake = System.currentTimeMillis();
            requestHandshake(false);
        }
    }

    private void deserializeFromObj(JSONObject jsonobject)
    {
        final Context context = (Context)contextRef.get();
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONArray jsonarray;
        int l;
        JSONObject jsonobject4;
        final String message;
        String s;
        try
        {
            jsonarray = jsonobject.optJSONArray("errors");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        if (jsonarray == null) goto _L4; else goto _L3
_L3:
        l = 0;
_L20:
        if (l >= jsonarray.length()) goto _L4; else goto _L5
_L5:
        jsonobject4 = jsonarray.optJSONObject(l);
        if (jsonobject4 == null) goto _L7; else goto _L6
_L6:
        message = jsonobject4.optString("message", null);
        s = jsonobject4.optString("type", null);
        if (message == null || s == null) goto _L7; else goto _L8
_L8:
        if (!s.equalsIgnoreCase("log")) goto _L10; else goto _L9
_L9:
        MMSDK.Log.e(message);
          goto _L7
_L10:
        if (s.equalsIgnoreCase("prompt"))
        {
            handler.post(new _cls3());
        }
          goto _L7
_L4:
        JSONObject jsonobject1 = jsonobject.optJSONObject("adtypes");
        if (jsonobject1 == null) goto _L12; else goto _L11
_L11:
        String as[] = MMAdImpl.getAdTypes();
        int i = 0;
_L21:
        if (i >= as.length) goto _L12; else goto _L13
_L13:
        JSONObject jsonobject3 = jsonobject1.optJSONObject(as[i]);
        if (jsonobject3 == null) goto _L15; else goto _L14
_L14:
        AdTypeHandShake adtypehandshake = new AdTypeHandShake();
        adtypehandshake.deserializeFromObj(jsonobject3);
        adtypehandshake.loadLastVideo(context, as[i]);
        adTypeHandShakes.put(as[i], adtypehandshake);
          goto _L15
_L12:
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray1 = jsonobject.optJSONArray("schemes");
        if (jsonarray1 == null) goto _L17; else goto _L16
_L16:
        ArrayList arraylist = schemes;
        int j;
        j = 0;
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        int k = schemes.size();
        j = 0;
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        schemes.removeAll(schemes);
_L22:
        if (j >= jsonarray1.length()) goto _L17; else goto _L18
_L18:
        JSONObject jsonobject2 = jsonarray1.optJSONObject(j);
        if (jsonobject2 == null)
        {
            break MISSING_BLOCK_LABEL_546;
        }
        Scheme scheme = new Scheme();
        scheme.deserializeFromObj(jsonobject2);
        schemes.add(scheme);
        break MISSING_BLOCK_LABEL_546;
_L17:
        this;
        JVM INSTR monitorexit ;
        adRefreshSecs = jsonobject.optLong("adrefresh", 0L);
        deferredViewTimeout = 1000L * jsonobject.optLong("deferredviewtimeout", 3600L);
        kill = jsonobject.optBoolean("kill");
        setAdUrl(context, jsonobject.optString("baseURL"));
        handShakeCallback = 1000L * jsonobject.optLong("handshakecallback", 0x15180L);
        creativeCacheTimeout = 1000L * jsonobject.optLong("creativeCacheTimeout", 0x3f480L);
        hardwareAccelerationEnabled = jsonobject.optBoolean("hardwareAccelerationEnabled");
        startSessionURL = jsonobject.optString("startSessionURL");
        endSessionURL = jsonobject.optString("endSessionURL");
        mmjsUrl = jsonobject.optString("mmjs");
        handleCachedVideos(jsonobject, context);
        if (TextUtils.isEmpty(mmjsUrl) || MRaid.isMRaidUpdated(context, mmjsUrl)) goto _L1; else goto _L19
_L19:
        MRaid.downloadMraidJs((Context)appContextRef.get(), mmjsUrl);
        return;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
_L7:
        l++;
          goto _L20
_L15:
        i++;
          goto _L21
        j++;
          goto _L22
    }

    static String getAdUrl()
    {
        return adUrl;
    }

    private void handleCachedVideos(JSONObject jsonobject, Context context)
    {
        JSONArray jsonarray = jsonobject.optJSONArray("cachedVideos");
        if (jsonarray != null)
        {
            cachedVideos = (DTOCachedVideo[])(new Gson()).fromJson(jsonarray.toString(), [Lcom/millennialmedia/android/DTOCachedVideo;);
            MMSDK.Log.d(cachedVideos.toString());
        }
        noVideosToCacheURL = jsonobject.optString("noVideosToCacheURL");
        if (cachedVideos != null)
        {
            PreCacheWorker.preCacheVideos(cachedVideos, context, noVideosToCacheURL);
        }
    }

    private boolean isFirstLaunch(Context context)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return context.getSharedPreferences("MillennialMediaSettings", 0).getBoolean("firstlaunchHandshake", true);
        }
    }

    private boolean loadHandShake(Context context)
    {
        SharedPreferences sharedpreferences;
        boolean flag;
        sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        flag = false;
        if (sharedpreferences != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1;
        String as[];
        boolean flag2;
        Exception exception;
        String s;
        String s1;
        String as1[];
        int j;
        String as2[];
        Scheme scheme;
        if (sharedpreferences.contains("handshake_deferredviewtimeout"))
        {
            deferredViewTimeout = sharedpreferences.getLong("handshake_deferredviewtimeout", deferredViewTimeout);
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (sharedpreferences.contains("handshake_baseUrl"))
        {
            adUrl = sharedpreferences.getString("handshake_baseUrl", adUrl);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_callback"))
        {
            handShakeCallback = sharedpreferences.getLong("handshake_callback", handShakeCallback);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_hardwareAccelerationEnabled"))
        {
            hardwareAccelerationEnabled = sharedpreferences.getBoolean("handshake_hardwareAccelerationEnabled", false);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_startSessionURL"))
        {
            startSessionURL = sharedpreferences.getString("handshake_startSessionURL", "");
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_endSessionURL"))
        {
            endSessionURL = sharedpreferences.getString("handshake_endSessionURL", "");
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_mmdid"))
        {
            setMMdid(context, sharedpreferences.getString("handshake_mmdid", mmdid), false);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_creativecachetimeout"))
        {
            creativeCacheTimeout = sharedpreferences.getLong("handshake_creativecachetimeout", creativeCacheTimeout);
            flag1 = true;
        }
        if (sharedpreferences.contains("handshake_mmjs"))
        {
            mmjsUrl = sharedpreferences.getString("handshake_mmjs", mmjsUrl);
            flag1 = true;
        }
        as = MMAdImpl.getAdTypes();
        flag2 = flag1;
        for (int i = 0; i < as.length; i++)
        {
            AdTypeHandShake adtypehandshake = new AdTypeHandShake();
            if (adtypehandshake.load(sharedpreferences, as[i]))
            {
                adTypeHandShakes.put(as[i], adtypehandshake);
                flag2 = true;
            }
        }

        this;
        JVM INSTR monitorenter ;
        if (!sharedpreferences.contains("handshake_schemes")) goto _L4; else goto _L3
_L3:
        s1 = sharedpreferences.getString("handshake_schemes", "");
        if (s1.length() <= 0) goto _L4; else goto _L5
_L5:
        as1 = s1.split("\n");
        j = as1.length;
_L12:
        if (flag >= j) goto _L7; else goto _L6
_L6:
        as2 = as1[flag].split("\t");
        if (as2.length >= 2)
        {
            scheme = new Scheme(as2[0], Integer.parseInt(as2[1]));
            schemes.add(scheme);
        }
        continue; /* Loop/switch isn't completed */
_L11:
        this;
        JVM INSTR monitorexit ;
        if (sharedpreferences.contains("handshake_cachedvideos5.0"))
        {
            s = sharedpreferences.getString("handshake_cachedvideos5.0", "");
            if (s.length() > 0)
            {
                cachedVideos = (DTOCachedVideo[])(new Gson()).fromJson(s, [Lcom/millennialmedia/android/DTOCachedVideo;);
            }
        }
        if (sharedpreferences.contains("handshake_lasthandshake"))
        {
            lastHandShake = sharedpreferences.getLong("handshake_lasthandshake", lastHandShake);
            flag = true;
        }
        if (!flag) goto _L1; else goto _L8
_L8:
        MMSDK.Log.d("Handshake successfully loaded from shared preferences.");
        if (System.currentTimeMillis() - lastHandShake < handShakeCallback)
        {
            handler.postDelayed(updateHandShakeRunnable, handShakeCallback - (System.currentTimeMillis() - lastHandShake));
        }
        noVideosToCacheURL = sharedpreferences.getString("handshake_novideostocacheurl", "");
        if (cachedVideos == null) goto _L1; else goto _L9
_L9:
        PreCacheWorker.preCacheVideos(cachedVideos, context, noVideosToCacheURL);
        return flag;
        exception;
        throw exception;
_L4:
        flag = flag2;
        if (true) goto _L11; else goto _L10
_L10:
        flag++;
          goto _L12
_L7:
        flag = true;
          goto _L11
    }

    private JSONObject parseJson(String s)
    {
        MMSDK.Log.d("JSON String: %s", new Object[] {
            s
        });
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        JSONObject jsonobject1;
        JSONObject jsonobject = new JSONObject(s);
        MMSDK.Log.v(jsonobject.toString());
        if (!jsonobject.has("mmishake"))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        jsonobject1 = jsonobject.getJSONObject("mmishake");
        return jsonobject1;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return null;
    }

    private void requestHandshake(final boolean isInitialize)
    {
        Utils.ThreadUtils.execute(new _cls1());
    }

    private void saveHandShake(Context context)
    {
        android.content.SharedPreferences.Editor editor;
        editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        editor.putLong("handshake_deferredviewtimeout", deferredViewTimeout);
        editor.putBoolean("handshake_kill", kill);
        editor.putString("handshake_baseUrl", adUrl);
        editor.putLong("handshake_callback", handShakeCallback);
        editor.putBoolean("handshake_hardwareAccelerationEnabled", hardwareAccelerationEnabled);
        editor.putString("handshake_startSessionURL", startSessionURL);
        editor.putString("handshake_endSessionURL", endSessionURL);
        editor.putLong("handshake_creativecaetimeout", creativeCacheTimeout);
        editor.putString("handshake_mmjs", mmjsUrl);
        String s;
        for (Iterator iterator = adTypeHandShakes.keySet().iterator(); iterator.hasNext(); ((AdTypeHandShake)adTypeHandShakes.get(s)).save(editor, (String)s))
        {
            s = (String)iterator.next();
        }

        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
_L2:
        Scheme scheme;
        if (i >= schemes.size())
        {
            break; /* Loop/switch isn't completed */
        }
        scheme = (Scheme)schemes.get(i);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        stringbuilder.append("\n");
        stringbuilder.append((new StringBuilder()).append(scheme.scheme).append("\t").append(scheme.id).toString());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        editor.putString("handshake_schemes", stringbuilder.toString());
        this;
        JVM INSTR monitorexit ;
        if (cachedVideos != null)
        {
            editor.putString("handshake_cachedvideos5.0", (new Gson()).toJson(cachedVideos));
        }
        editor.putString("handshake_novideostocacheurl", noVideosToCacheURL);
        editor.putLong("handshake_lasthandshake", lastHandShake);
        editor.commit();
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void sentFirstLaunch(Context context)
    {
        if (context != null)
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            editor.putBoolean("firstlaunchHandshake", false);
            editor.commit();
        }
    }

    static void setAdUrl(Context context, String s)
    {
label0:
        {
            if (!TextUtils.isEmpty(s))
            {
                if (s.endsWith("/"))
                {
                    break label0;
                }
                adUrl = (new StringBuilder()).append(s).append("/getAd.php5?").toString();
            }
            return;
        }
        adUrl = (new StringBuilder()).append(s).append("getAd.php5?").toString();
    }

    static void setHandShakeURL(Context context, String s)
    {
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorenter ;
        if (!TextUtils.isEmpty(s))
        {
            if (s.startsWith("http://"))
            {
                s = s.replaceFirst("http://", "https://");
            }
            handShakeURL = (new StringBuilder()).append(s).append("?apid=").toString();
            forceRefresh = true;
            sharedInstance = new HandShake(context);
        }
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static HandShake sharedHandShake(Context context)
    {
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorenter ;
        if (apid != null) goto _L2; else goto _L1
_L1:
        MMSDK.Log.e("No apid set for the handshake.");
        HandShake handshake = null;
_L5:
        com/millennialmedia/android/HandShake;
        JVM INSTR monitorexit ;
        return handshake;
_L2:
        if (sharedInstance != null) goto _L4; else goto _L3
_L3:
        sharedInstance = new HandShake(context);
_L7:
        handshake = sharedInstance;
          goto _L5
_L4:
        if (System.currentTimeMillis() - sharedInstance.lastHandShake <= sharedInstance.handShakeCallback) goto _L7; else goto _L6
_L6:
        MMSDK.Log.d("Handshake expired, requesting new handshake from the server.");
        sharedInstance = new HandShake(context);
          goto _L7
        Exception exception;
        exception;
        throw exception;
    }

    boolean canDisplayCachedAd(String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null) goto _L2; else goto _L1
_L1:
        boolean flag = adtypehandshake.canDisplayCachedAd(l);
        boolean flag1 = flag;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        flag1 = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    boolean canRequestVideo(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null) goto _L2; else goto _L1
_L1:
        boolean flag = adtypehandshake.canRequestVideo(context, s);
        boolean flag1 = flag;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        flag1 = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    void endSession()
    {
        if (!TextUtils.isEmpty(endSessionURL))
        {
            Utils.HttpUtils.executeUrl(endSessionURL);
        }
    }

    JSONArray getSchemesJSONArray(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray;
        Iterator iterator;
        jsonarray = new JSONArray();
        if (schemes.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        iterator = schemes.iterator();
_L1:
        Scheme scheme;
        boolean flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_116;
        }
        scheme = (Scheme)iterator.next();
        flag = scheme.checkAvailability(context);
        Exception exception;
        if (flag)
        {
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("scheme", scheme.scheme);
                jsonobject.put("schemeid", scheme.id);
                jsonarray.put(jsonobject);
            }
            catch (JSONException jsonexception) { }
            finally
            {
                this;
            }
        }
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return jsonarray;
        throw exception;
    }

    String getSchemesList(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        Iterator iterator;
        if (schemesList != null || schemes.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        stringbuilder = new StringBuilder();
        iterator = schemes.iterator();
_L1:
        Scheme scheme;
        do
        {
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_128;
                }
                scheme = (Scheme)iterator.next();
            } while (!scheme.checkAvailability(context));
            if (stringbuilder.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            stringbuilder.append((new StringBuilder(",")).append(scheme.id).toString());
        } while (true);
        Exception exception;
        exception;
        throw exception;
        stringbuilder.append(Integer.toString(scheme.id));
          goto _L1
        if (stringbuilder.length() > 0)
        {
            schemesList = stringbuilder.toString();
        }
        String s = schemesList;
        this;
        JVM INSTR monitorexit ;
        return s;
    }

    boolean isAdTypeDownloading(String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null) goto _L2; else goto _L1
_L1:
        boolean flag = adtypehandshake.downloading;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    void lockAdTypeDownload(String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        adtypehandshake.downloading = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void sendInitRequest()
    {
        requestHandshake(true);
    }

    void setMMdid(Context context, String s)
    {
        setMMdid(context, s, true);
    }

    void setMMdid(Context context, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (s.length() != 0 && !s.equals("NULL"))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        mmdid = null;
_L1:
        MMSDK.setMMdid(mmdid);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
        editor.putString("handshake_mmdid", mmdid);
        editor.commit();
        this;
        JVM INSTR monitorexit ;
        return;
        mmdid = s;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    void startSession()
    {
        if (!TextUtils.isEmpty(startSessionURL))
        {
            Utils.HttpUtils.executeUrl(startSessionURL);
        }
    }

    void unlockAdTypeDownload(String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        adtypehandshake.downloading = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void updateLastVideoViewedTime(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        AdTypeHandShake adtypehandshake = (AdTypeHandShake)adTypeHandShakes.get(s);
        if (adtypehandshake == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        adtypehandshake.updateLastVideoViewedTime(context, s);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }









/*
    static String access$302(String s)
    {
        handShakeURL = s;
        return s;
    }

*/







    private class _cls2
        implements Runnable
    {

        final HandShake this$0;

        public void run()
        {
            Context context = (Context)contextRef.get();
            if (context == null)
            {
                context = (Context)appContextRef.get();
            }
            if (context != null)
            {
                HandShake.sharedHandShake(context);
            }
        }

        _cls2()
        {
            this$0 = HandShake.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final HandShake this$0;
        final Context val$context;
        final String val$message;

        public void run()
        {
            try
            {
                Toast.makeText(context, (new StringBuilder("Error: ")).append(message).toString(), 1).show();
                return;
            }
            catch (android.view.WindowManager.BadTokenException badtokenexception)
            {
                badtokenexception.printStackTrace();
            }
        }

        _cls3()
        {
            this$0 = HandShake.this;
            context = context1;
            message = s;
            super();
        }
    }


    private class AdTypeHandShake
    {

        boolean downloading;
        long lastVideo;
        final HandShake this$0;
        long videoInterval;

        boolean canDisplayCachedAd(long l)
        {
            return System.currentTimeMillis() - l < deferredViewTimeout;
        }

        boolean canRequestVideo(Context context, String s)
        {
            Object aobj[] = new Object[4];
            aobj[0] = Long.valueOf(System.currentTimeMillis());
            aobj[1] = Long.valueOf(lastVideo / 1000L);
            aobj[2] = Long.valueOf((System.currentTimeMillis() - lastVideo) / 1000L);
            aobj[3] = Long.valueOf(videoInterval / 1000L);
            MMSDK.Log.d("canRequestVideo() Current Time: %d Last Video: %d  Diff: %d  Video interval: %d", aobj);
            return System.currentTimeMillis() - lastVideo > videoInterval;
        }

        void deserializeFromObj(JSONObject jsonobject)
        {
            if (jsonobject == null)
            {
                return;
            } else
            {
                videoInterval = 1000L * jsonobject.optLong("videointerval");
                return;
            }
        }

        boolean load(SharedPreferences sharedpreferences, String s)
        {
            boolean flag = sharedpreferences.contains((new StringBuilder("handshake_lastvideo_")).append(s).toString());
            boolean flag1 = false;
            if (flag)
            {
                lastVideo = sharedpreferences.getLong((new StringBuilder("handshake_lastvideo_")).append(s).toString(), lastVideo);
                flag1 = true;
            }
            if (sharedpreferences.contains((new StringBuilder("handshake_videointerval_")).append(s).toString()))
            {
                videoInterval = sharedpreferences.getLong((new StringBuilder("handshake_videointerval_")).append(s).toString(), videoInterval);
                return true;
            } else
            {
                return flag1;
            }
        }

        void loadLastVideo(Context context, String s)
        {
            SharedPreferences sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
            if (sharedpreferences != null && sharedpreferences.contains((new StringBuilder("handshake_lastvideo_")).append(s).toString()))
            {
                lastVideo = sharedpreferences.getLong((new StringBuilder("handshake_lastvideo_")).append(s).toString(), lastVideo);
            }
        }

        void save(Context context, String s)
        {
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            save(editor, s);
            editor.commit();
        }

        void save(android.content.SharedPreferences.Editor editor, String s)
        {
            editor.putLong((new StringBuilder("handshake_lastvideo_")).append(s).toString(), lastVideo);
            editor.putLong((new StringBuilder("handshake_videointerval_")).append(s).toString(), videoInterval);
        }

        void updateLastVideoViewedTime(Context context, String s)
        {
            lastVideo = System.currentTimeMillis();
            save(context, s);
        }

        AdTypeHandShake()
        {
            this$0 = HandShake.this;
            super();
            lastVideo = 0L;
            videoInterval = 0L;
        }
    }


    private class Scheme
    {

        int id;
        String scheme;
        final HandShake this$0;

        boolean checkAvailability(Context context)
        {
            Intent intent;
            if (scheme.contains("://"))
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(scheme));
            } else
            {
                intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(scheme).append("://").toString()));
            }
            return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
        }

        void deserializeFromObj(JSONObject jsonobject)
        {
            if (jsonobject == null)
            {
                return;
            } else
            {
                scheme = jsonobject.optString("scheme", null);
                id = jsonobject.optInt("schemeid");
                return;
            }
        }

        Scheme()
        {
            this$0 = HandShake.this;
            super();
        }

        Scheme(String s, int i)
        {
            this$0 = HandShake.this;
            super();
            scheme = s;
            id = i;
        }
    }


    private class _cls1
        implements Runnable
    {

        final HandShake this$0;
        final boolean val$isInitialize;

        public void run()
        {
            Context context = (Context)contextRef.get();
            Context context1;
            StringBuilder stringbuilder;
            TreeMap treemap;
            IOException ioexception;
            boolean flag;
            Exception exception;
            Object aobj[];
            Exception exception1;
            Object aobj1[];
            boolean flag1;
            Iterator iterator;
            String s;
            IOException ioexception1;
            Object aobj2[];
            HttpResponse httpresponse;
            IOException ioexception2;
            Object aobj3[];
            IOException ioexception3;
            Object aobj4[];
            HttpResponse httpresponse1;
            String s1;
            HttpResponse httpresponse2;
            int i;
            String s2;
            HttpResponse httpresponse3;
            int j;
            HttpResponse httpresponse4;
            java.util.Map.Entry entry;
            Object aobj5[];
            if (context == null)
            {
                context1 = (Context)appContextRef.get();
            } else
            {
                context1 = context;
            }
            if (context1 != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            stringbuilder = new StringBuilder();
            treemap = new TreeMap();
            treemap.put("ua", (new StringBuilder("Android:")).append(Build.MODEL).toString());
            flag1 = isFirstLaunch(context1);
            flag = flag1;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            treemap.put("firstlaunch", "1");
            if (isInitialize)
            {
                treemap.put("init", "1");
            }
            MMSDK.insertUrlCommonValues(context1, treemap);
            for (iterator = treemap.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(String.format("&%s=%s", aobj5)))
            {
                entry = (java.util.Map.Entry)iterator.next();
                aobj5 = new Object[2];
                aobj5[0] = entry.getKey();
                aobj5[1] = URLEncoder.encode((String)entry.getValue(), "UTF-8");
            }

              goto _L3
            ioexception;
_L16:
            aobj = new Object[1];
            aobj[0] = ioexception.getMessage();
            MMSDK.Log.e("Could not get a handshake. %s", aobj);
            return;
            exception;
_L14:
            if (flag)
            {
                sentFirstLaunch(context1);
            }
            throw exception;
_L3:
            s = (new StringBuilder()).append(HandShake.handShakeURL).append(HandShake.apid).append(stringbuilder.toString()).toString();
            MMSDK.Log.v("Performing handshake: %s", new Object[] {
                s
            });
            httpresponse4 = (new HttpGetRequest()).get(s);
            httpresponse = httpresponse4;
_L10:
            if (httpresponse == null)
            {
                break MISSING_BLOCK_LABEL_358;
            }
            j = httpresponse.getStatusLine().getStatusCode();
            if (j == 200)
            {
                break MISSING_BLOCK_LABEL_435;
            }
            HandShake.handShakeURL = HandShake.handShakeURL.replaceFirst("https://", "http://");
            s2 = (new StringBuilder()).append(HandShake.handShakeURL).append(HandShake.apid).append(stringbuilder.toString()).toString();
            MMSDK.Log.v("Performing handshake (HTTP Fallback): %s", new Object[] {
                s2
            });
            httpresponse3 = (new HttpGetRequest()).get(s2);
            httpresponse = httpresponse3;
_L11:
            if (httpresponse == null) goto _L5; else goto _L4
_L4:
            i = httpresponse.getStatusLine().getStatusCode();
            if (i == 200) goto _L6; else goto _L5
_L5:
            s1 = (new StringBuilder("http://ads.mp.mydas.mobi/appConfigServlet?apid=")).append(HandShake.apid).append(stringbuilder.toString()).toString();
            MMSDK.Log.v("Performing handshake (HTTP Fallback Original): %s", new Object[] {
                s1
            });
            httpresponse2 = (new HttpGetRequest()).get(s1);
            httpresponse1 = httpresponse2;
_L12:
            if (httpresponse1 == null) goto _L8; else goto _L7
_L7:
            if (httpresponse1.getStatusLine().getStatusCode() != 200) goto _L8; else goto _L9
_L9:
            deserializeFromObj(parseJson(HttpGetRequest.convertStreamToString(httpresponse1.getEntity().getContent())));
            saveHandShake(context1);
            handler.postDelayed(updateHandShakeRunnable, handShakeCallback);
            MMSDK.Log.v("Obtained a new handshake");
_L13:
            if (flag)
            {
                sentFirstLaunch(context1);
                return;
            }
              goto _L1
            ioexception1;
            aobj2 = new Object[1];
            aobj2[0] = ioexception1.getMessage();
            MMSDK.Log.e("Could not get a handshake. %s", aobj2);
            httpresponse = null;
              goto _L10
            exception1;
_L15:
            aobj1 = new Object[1];
            aobj1[0] = exception1.getMessage();
            MMSDK.Log.e("Could not get a handshake. %s", aobj1);
            return;
            ioexception2;
            aobj3 = new Object[1];
            aobj3[0] = ioexception2.getMessage();
            MMSDK.Log.e("Could not get a handshake. %s", aobj3);
              goto _L11
            ioexception3;
            aobj4 = new Object[1];
            aobj4[0] = ioexception3.getMessage();
            MMSDK.Log.e("Could not get a handshake. %s", aobj4);
_L6:
            httpresponse1 = httpresponse;
              goto _L12
_L8:
            flag = false;
              goto _L13
            exception;
            flag = false;
              goto _L14
            exception1;
            flag = false;
              goto _L15
            ioexception;
            flag = false;
              goto _L16
        }

        _cls1()
        {
            this$0 = HandShake.this;
            isInitialize = flag;
            super();
        }
    }

}
