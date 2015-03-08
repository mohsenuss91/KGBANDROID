// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.util.Base64OutputStream;
import android.util.DisplayMetrics;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public class AnalyticsUtils
{

    public static final String ANALYTICS_LOGGING_TAG = "[InMobi]-[Analytics]-4.4.1";
    public static final String INITIALIZE_NOT_CALLED = "Please call InMobi.initialize or startSession before calling any events API";
    private static String a;
    private static boolean b;

    public AnalyticsUtils()
    {
    }

    public static void asyncPingInternal(String s)
    {
        HttpURLConnection httpurlconnection = null;
        HttpURLConnection httpurlconnection1;
        String s1 = s.replaceAll("%25", "%");
        Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Pinging URL: ")).append(s1).toString());
        httpurlconnection1 = (HttpURLConnection)(new URL(s1)).openConnection();
        httpurlconnection1.setConnectTimeout(20000);
        httpurlconnection1.setRequestMethod("GET");
        InternalSDKUtil.addCommonPropertiesToConnection(httpurlconnection1);
        Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Async Ping Connection Response Code: ")).append(httpurlconnection1.getResponseCode()).toString());
        if (httpurlconnection1 != null)
        {
            httpurlconnection1.disconnect();
        }
_L2:
        return;
        Exception exception1;
        exception1;
_L5:
        Log.debug("[InMobi]-[Analytics]-4.4.1", "Error doing async Ping. ", exception1);
        if (httpurlconnection == null) goto _L2; else goto _L1
_L1:
        httpurlconnection.disconnect();
        return;
        Exception exception;
        exception;
_L4:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw exception;
        Exception exception3;
        exception3;
        httpurlconnection = httpurlconnection1;
        exception = exception3;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception2;
        exception2;
        httpurlconnection = httpurlconnection1;
        exception1 = exception2;
          goto _L5
    }

    public static String compressPayload(String s)
    {
        String s1;
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            Base64OutputStream base64outputstream = new Base64OutputStream(bytearrayoutputstream, 0);
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(base64outputstream);
            gzipoutputstream.write(s.getBytes("UTF-8"));
            gzipoutputstream.close();
            base64outputstream.close();
            s1 = bytearrayoutputstream.toString();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Exception compress sdk payload.", exception);
            return null;
        }
        return s1;
    }

    public static String convertItemType(com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType imitemtype)
    {
        String s;
        if (imitemtype == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType.CONSUMABLE)
        {
            s = "1";
        } else
        {
            if (imitemtype == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType.DURABLE)
            {
                return "2";
            }
            com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType imitemtype1 = com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMItemType.PERSONALIZATION;
            s = null;
            if (imitemtype == imitemtype1)
            {
                return "3";
            }
        }
        return s;
    }

    public static String convertLevelStatus(com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus imsectionstatus)
    {
        String s;
        if (imsectionstatus == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus.COMPLETED)
        {
            s = "1";
        } else
        {
            if (imsectionstatus == com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus.FAILED)
            {
                return "2";
            }
            com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus imsectionstatus1 = com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus.CANCELED;
            s = null;
            if (imsectionstatus == imsectionstatus1)
            {
                return "3";
            }
        }
        return s;
    }

    public static String convertToJSON(Map map)
    {
        if (map.size() > getExtraParamsLimit())
        {
            Log.verbose("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Analytics events - number of key-value pairs in attribute map exceeds ")).append(getExtraParamsLimit()).toString());
            return null;
        }
        JSONObject jsonobject;
        Iterator iterator;
        jsonobject = new JSONObject();
        iterator = map.keySet().iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s2 = (String)iterator.next();
        if (s2.length() <= 0 || s2.length() > getMaxparamskey()) goto _L4; else goto _L3
_L3:
        String s3 = (String)map.get(s2);
        if (s3.length() > getMaxstring()) goto _L6; else goto _L5
_L5:
        jsonobject.put(s2, map.get(s2));
          goto _L7
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Unable to convert map to JSON");
_L9:
        String s = null;
_L10:
        return s;
_L6:
        Log.verbose("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Analytics events - value : ")).append(s3).append(" ,exceeds inmobi's limitation of ").append(getMaxstring()).append(" characters.").toString());
        return null;
_L4:
        Log.verbose("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Analytics events - key : ")).append(s2).append(" ,exceeds inmobi's limitation of ").append(getMaxparamskey()).append(" characters.").toString());
        return null;
_L2:
        if (jsonobject.length() <= 0) goto _L9; else goto _L8
_L8:
        String s1 = jsonobject.toString();
        s = s1;
          goto _L10
    }

    public static String getAppVersion(Context context)
    {
        String s;
        try
        {
            s = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Error retrieving application version");
            return null;
        }
        return s;
    }

    public static String getApplicationName(Context context)
    {
        String s;
        try
        {
            PackageManager packagemanager = context.getPackageManager();
            s = (String)packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(context.getPackageName(), 0));
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Error retrieving application name");
            return null;
        }
        return s;
    }

    public static Object getCountryISO(Context context)
    {
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager.getNetworkCountryIso().equals(""))
        {
            return context.getResources().getConfiguration().locale.getISO3Country();
        } else
        {
            return telephonymanager.getNetworkCountryIso();
        }
    }

    public static float getDeviceDensity(Context context)
    {
        return context.getResources().getDisplayMetrics().density;
    }

    public static String getEventUrl()
    {
        return AnalyticsInitializer.getConfigParams().getEndPoints().getEventsUrl();
    }

    public static int getExtraParamsLimit()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getExtraParamsLimit();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static int getMaxRetryBeforeDiscard()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxRetryBeforeCacheDiscard();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static long getMaxdbcount()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxDbEvents();
        long l = i;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getMaxevents()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        String s = (new StringBuilder()).append(AnalyticsInitializer.getConfigParams().getGetParamsLimit()).toString();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static int getMaxparamskey()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxKeyLength();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static int getMaxstring()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getMaxValLength();
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getScreenHeight(Context context)
    {
        int i = context.getResources().getDisplayMetrics().heightPixels;
        return (new StringBuilder()).append(i).toString();
    }

    public static String getScreenWidth(Context context)
    {
        int i = context.getResources().getDisplayMetrics().widthPixels;
        return (new StringBuilder()).append(i).toString();
    }

    public static boolean getStartHandle()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        boolean flag = b;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static long getTimeinterval()
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        int i = AnalyticsInitializer.getConfigParams().getPingInterval();
        long l = i;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getWebviewUserAgent()
    {
        return a;
    }

    public static void setStartHandle(boolean flag)
    {
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorenter ;
        b = flag;
        com/inmobi/commons/analytics/util/AnalyticsUtils;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setWebviewUserAgent(String s)
    {
        a = s;
    }
}
