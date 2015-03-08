// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.millennialmedia.android:
//            HandShake, AdCache, MMRequest, MMAdImpl, 
//            MMAdImplController, MMConversionTracker

public final class MMSDK
{

    private static final String BASE_URL_TRACK_EVENT = "http://ads.mp.mydas.mobi/pixel?id=";
    static final int CACHE_REQUEST_TIMEOUT = 30000;
    static final int CLOSE_ACTIVITY_DURATION = 400;
    static String COMMA = ",";
    public static final String DEFAULT_APID = "28911";
    public static final String DEFAULT_BANNER_APID = "28913";
    public static final String DEFAULT_RECT_APID = "28914";
    static final String EMPTY = "";
    static final String JSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss ZZZZ";
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 0;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_INTERNAL = 4;
    public static final int LOG_LEVEL_PRIVATE_VERBOSE = 5;
    public static final int LOG_LEVEL_VERBOSE = 3;
    static final int LOG_REQUEST_TIMEOUT = 10000;
    static final int MIN_REFRESH = 15;
    static final int OPEN_ACTIVITY_DURATION = 600;
    static final String PREFS_NAME = "MillennialMediaSettings";
    static final int REQUEST_TIMEOUT = 3000;
    public static final String SDKLOG = "MillennialMediaSDK";
    public static final String VERSION = "5.0.1-13.05.14.a";
    public static boolean debugMode;
    static boolean disableAdMinRefresh = false;
    private static String getMMdidValue = null;
    private static boolean isBroadcastingEvents;
    static int logLevel;
    static String macId;
    static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static int nextDefaultId = 0x711e41a1;

    private MMSDK()
    {
    }

    static String byteArrayToString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
        for (int i = 0; i < abyte0.length; i++)
        {
            Object aobj[] = new Object[1];
            aobj[0] = Byte.valueOf(abyte0[i]);
            stringbuilder.append(String.format("%02X", aobj));
        }

        return stringbuilder.toString();
    }

    static void checkActivity(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            packagemanager.getActivityInfo(new ComponentName(context, "com.millennialmedia.android.MMActivity"), 128);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.e("Activity MMActivity not declared in AndroidManifest.xml");
            namenotfoundexception.printStackTrace();
            createMissingPermissionDialog(context, "MMActivity class").show();
        }
        try
        {
            packagemanager.getActivityInfo(new ComponentName(context, "com.millennialmedia.android.VideoPlayer"), 128);
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
        {
            Log.e("Activity VideoPlayer not declared in AndroidManifest.xml");
            namenotfoundexception1.printStackTrace();
            createMissingPermissionDialog(context, "VideoPlayer class").show();
            return;
        }
    }

    static void checkPermissions(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
        {
            createMissingPermissionDialog(context, "INTERNET permission").show();
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            createMissingPermissionDialog(context, "ACCESS_NETWORK_STATE permission").show();
        }
    }

    private static AlertDialog createMissingPermissionDialog(Context context, String s)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(context)).create();
        alertdialog.setTitle("Whoops!");
        alertdialog.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", new Object[] {
            s
        }));
        alertdialog.setButton(-3, "OK", new _cls1());
        alertdialog.show();
        return alertdialog;
    }

    public static boolean getBroadcastEvents()
    {
        return isBroadcastingEvents;
    }

    static Configuration getConfiguration(Context context)
    {
        return context.getResources().getConfiguration();
    }

    static String getConnectionType(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return "unknown";
        }
        if (connectivitymanager.getActiveNetworkInfo() != null && connectivitymanager.getActiveNetworkInfo().isConnected())
        {
            int i = connectivitymanager.getActiveNetworkInfo().getType();
            int j = connectivitymanager.getActiveNetworkInfo().getSubtype();
            if (i == 1)
            {
                return "wifi";
            }
            if (i == 0)
            {
                switch (j)
                {
                default:
                    return "unknown";

                case 7: // '\007'
                    return "1xrtt";

                case 4: // '\004'
                    return "cdma";

                case 2: // '\002'
                    return "edge";

                case 14: // '\016'
                    return "ehrpd";

                case 5: // '\005'
                    return "evdo_0";

                case 6: // '\006'
                    return "evdo_a";

                case 12: // '\f'
                    return "evdo_b";

                case 1: // '\001'
                    return "gprs";

                case 8: // '\b'
                    return "hsdpa";

                case 10: // '\n'
                    return "hspa";

                case 15: // '\017'
                    return "hspap";

                case 9: // '\t'
                    return "hsupa";

                case 11: // '\013'
                    return "iden";

                case 13: // '\r'
                    return "lte";

                case 3: // '\003'
                    return "umts";
                }
            } else
            {
                return "unknown";
            }
        } else
        {
            return "offline";
        }
    }

    public static int getDefaultAdId()
    {
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        int i;
        i = 1 + nextDefaultId;
        nextDefaultId = i;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    static float getDensity(Context context)
    {
        return context.getResources().getDisplayMetrics().density;
    }

    static String getDpiHeight(Context context)
    {
        DisplayMetrics displaymetrics = getMetrics(context);
        if (needsRealDisplayMethod())
        {
            try
            {
                android/view/Display.getMethod("getRealMetrics", new Class[0]).invoke(displaymetrics, new Object[0]);
            }
            catch (Exception exception1) { }
        }
        if (needsRawDisplayMethod() && (context instanceof Activity))
        {
            Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
            String s;
            try
            {
                s = String.valueOf(((Integer)android/view/Display.getMethod("getRawHeight", new Class[0]).invoke(display, new Object[0])).intValue());
            }
            catch (Exception exception)
            {
                return Integer.toString(displaymetrics.heightPixels);
            }
            return s;
        } else
        {
            return Integer.toString(displaymetrics.heightPixels);
        }
    }

    static String getDpiWidth(Context context)
    {
        DisplayMetrics displaymetrics = getMetrics(context);
        if (needsRealDisplayMethod())
        {
            try
            {
                android/view/Display.getMethod("getRealMetrics", new Class[0]).invoke(displaymetrics, new Object[0]);
            }
            catch (Exception exception1) { }
        }
        if (needsRawDisplayMethod() && (context instanceof Activity))
        {
            Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
            String s;
            try
            {
                s = String.valueOf(((Integer)android/view/Display.getMethod("getRawWidth", new Class[0]).invoke(display, new Object[0])).intValue());
            }
            catch (Exception exception)
            {
                return Integer.toString(displaymetrics.widthPixels);
            }
            return s;
        } else
        {
            return Integer.toString(displaymetrics.widthPixels);
        }
    }

    static String getIpAddress(Context context)
    {
        StringBuilder stringbuilder;
        Enumeration enumeration;
        stringbuilder = new StringBuilder();
        enumeration = NetworkInterface.getNetworkInterfaces();
_L6:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_152;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L3:
        String s1;
        InetAddress inetaddress;
        do
        {
            if (!enumeration1.hasMoreElements())
            {
                continue; /* Loop/switch isn't completed */
            }
            inetaddress = (InetAddress)enumeration1.nextElement();
        } while (inetaddress.isLoopbackAddress());
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append(',');
        }
        s1 = inetaddress.getHostAddress().toUpperCase();
        if (!InetAddressUtils.isIPv4Address(s1)) goto _L2; else goto _L1
_L1:
        Exception exception;
        stringbuilder.append(s1);
          goto _L3
_L2:
        int i;
        try
        {
            i = s1.indexOf('%');
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            Log.e(exception);
            return "";
        }
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_139;
        }
_L4:
        stringbuilder.append(s1);
          goto _L3
        continue; /* Loop/switch isn't completed */
        s1 = s1.substring(0, i);
          goto _L4
        String s = stringbuilder.toString();
        return s;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int getLogLevel()
    {
        return logLevel;
    }

    static String getMMdid(Context context)
    {
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        if (getMMdidValue == null) goto _L2; else goto _L1
_L1:
        String s1 = getMMdidValue;
_L4:
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        s1 = null;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        StringBuilder stringbuilder = new StringBuilder("mmh_");
        stringbuilder.append(byteArrayToString(MessageDigest.getInstance("MD5").digest(s.getBytes())));
        stringbuilder.append("_");
        stringbuilder.append(byteArrayToString(MessageDigest.getInstance("SHA1").digest(s.getBytes())));
        s1 = stringbuilder.toString();
        getMMdidValue = s1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        Log.v(exception1.getMessage());
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static String getMcc(Context context)
    {
        Configuration configuration = getConfiguration(context);
        if (configuration.mcc == 0)
        {
            String s = getNetworkOperator(context);
            if (s != null && s.length() >= 6)
            {
                return s.substring(0, 3);
            }
        }
        return String.valueOf(configuration.mcc);
    }

    static DisplayMetrics getMetrics(Context context)
    {
        return context.getResources().getDisplayMetrics();
    }

    static String getMnc(Context context)
    {
        Configuration configuration = getConfiguration(context);
        if (configuration.mnc == 0)
        {
            String s = getNetworkOperator(context);
            if (s != null && s.length() >= 6)
            {
                return s.substring(3);
            }
        }
        return String.valueOf(configuration.mnc);
    }

    static String getNetworkOperator(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperator();
    }

    static String getOrientation(Context context)
    {
        switch (context.getResources().getConfiguration().orientation)
        {
        default:
            return "default";

        case 1: // '\001'
            return "portrait";

        case 2: // '\002'
            return "landscape";

        case 3: // '\003'
            return "square";
        }
    }

    static final String getOrientationLocked(Context context)
    {
        if (android.provider.Settings.System.getString(context.getContentResolver(), "accelerometer_rotation").equals("1"))
        {
            return "false";
        } else
        {
            return "true";
        }
    }

    static String getSupportsSms(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String getSupportsTel(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    public static String hasAccelerometer(Context context)
    {
        if (context == null)
        {
            return "false";
        }
        Iterator iterator = ((SensorManager)context.getSystemService("sensor")).getSensorList(1).iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            boolean flag1;
            if (((Sensor)iterator.next()).getType() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = flag;
            }
            flag = flag1;
        }
        if (flag)
        {
            return "true";
        } else
        {
            return "false";
        }
    }

    static boolean hasSetTranslationMethod()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 11;
    }

    public static void initialize(Context context)
    {
        HandShake handshake = HandShake.sharedHandShake(context);
        handshake.sendInitRequest();
        handshake.startSession();
    }

    static void insertUrlCommonValues(Context context, Map map)
    {
        String s5;
        String s6;
        map.put("accelerometer", hasAccelerometer(context));
        map.put("density", Float.toString(getMetrics(context).density));
        map.put("hpx", getDpiHeight(context));
        map.put("wpx", getDpiWidth(context));
        String s;
        Locale locale;
        String s1;
        String s2;
        String s3;
        StatFs statfs;
        String s4;
        Intent intent;
        String s7;
        if (isCachedVideoSupportedOnDevice(context))
        {
            map.put("cachedvideo", "true");
        } else
        {
            map.put("cachedvideo", "false");
        }
        if (Build.MODEL != null)
        {
            map.put("dm", Build.MODEL);
        }
        if (android.os.Build.VERSION.RELEASE != null)
        {
            map.put("dv", (new StringBuilder("Android")).append(android.os.Build.VERSION.RELEASE).toString());
        }
        s = getMMdid(context);
        if (s != null)
        {
            map.put("mmdid", s);
        }
        map.put("sdkversion", "5.0.1-13.05.14.a");
        map.put("mmisdk", "5.0.1-13.05.14.a");
        map.put("mcc", getMcc(context));
        map.put("mnc", getMnc(context));
        locale = Locale.getDefault();
        if (locale != null)
        {
            map.put("language", locale.getLanguage());
            map.put("country", locale.getCountry());
        }
        Exception exception1;
        try
        {
            String s8 = context.getPackageName();
            map.put("pkid", s8);
            PackageManager packagemanager = context.getPackageManager();
            map.put("pknm", packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(s8, 0)).toString());
        }
        catch (Exception exception) { }
        if (debugMode)
        {
            map.put("debug", "true");
        }
        s1 = HandShake.sharedHandShake(context).getSchemesList(context);
        if (s1 != null)
        {
            map.put("appsids", s1);
        }
        s2 = AdCache.getCachedVideoList(context);
        if (s2 != null)
        {
            map.put("vid", s2);
        }
        s3 = getConnectionType(context);
        if (!AdCache.isExternalStorageAvailable(context)) goto _L2; else goto _L1
_L1:
        statfs = new StatFs(AdCache.getCacheDirectory(context).getAbsolutePath());
_L3:
        s4 = Long.toString((long)statfs.getAvailableBlocks() * (long)statfs.getBlockSize());
        intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_670;
        }
        if (intent.getIntExtra("plugged", 0) == 0)
        {
            s5 = "false";
        } else
        {
            s5 = "true";
        }
        s6 = Integer.toString((int)((100F / (float)intent.getIntExtra("scale", 100)) * (float)intent.getIntExtra("level", 0)));
_L5:
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_513;
        }
        if (s6.length() > 0)
        {
            map.put("bl", s6);
        }
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_538;
        }
        if (s5.length() > 0)
        {
            map.put("plugged", s5);
        }
        if (s4.length() > 0)
        {
            map.put("space", s4);
        }
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_575;
        }
        map.put("conn", s3);
        s7 = URLEncoder.encode(getIpAddress(context), "UTF-8");
        if (!TextUtils.isEmpty(s7))
        {
            map.put("pip", s7);
        }
_L4:
        MMRequest.insertLocation(map);
        return;
_L2:
        statfs = new StatFs(context.getFilesDir().getPath());
          goto _L3
        exception1;
        Log.v(exception1);
          goto _L4
        s6 = null;
        s5 = null;
          goto _L5
    }

    static boolean isCachedVideoSupportedOnDevice(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1 && (!android.os.Build.VERSION.SDK.equalsIgnoreCase("8") || Environment.getExternalStorageState().equals("mounted") && AdCache.isExternalEnabled);
    }

    static boolean isConnected(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null)
        {
            return false;
        }
        return connectivitymanager.getActiveNetworkInfo() != null && connectivitymanager.getActiveNetworkInfo().isConnected();
    }

    static boolean isUiThread()
    {
        return mainHandler.getLooper() == Looper.myLooper();
    }

    private static boolean needsRawDisplayMethod()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 13 && Integer.parseInt(android.os.Build.VERSION.SDK) <= 16;
    }

    private static boolean needsRealDisplayMethod()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 17;
    }

    static void printDiagnostics(MMAdImpl mmadimpl)
    {
        final Context context = mmadimpl.getContext();
        Object aobj[] = new Object[1];
        aobj[0] = MMAdImplController.controllersToString();
        Log.i("MMAd Controllers: %s", aobj);
        Object aobj1[] = new Object[1];
        aobj1[0] = Integer.valueOf(mmadimpl.getId());
        Log.i("MMAd External ID: %d", aobj1);
        Object aobj2[] = new Object[1];
        aobj2[0] = Long.valueOf(mmadimpl.internalId);
        Log.i("MMAd Internal ID: %d", aobj2);
        Object aobj3[] = new Object[1];
        aobj3[0] = mmadimpl.apid;
        Log.i("APID: %s", aobj3);
        Object aobj4[] = new Object[1];
        String s;
        if (AdCache.isExternalStorageAvailable(context))
        {
            s = "";
        } else
        {
            s = "not ";
        }
        aobj4[0] = s;
        Log.i("SD card is %savailable.", aobj4);
        if (context != null)
        {
            Object aobj5[] = new Object[1];
            aobj5[0] = context.getPackageName();
            Log.i("Package: %s", aobj5);
            Object aobj6[] = new Object[1];
            aobj6[0] = getMMdid(context);
            Log.i("MMDID: %s", aobj6);
            Log.i("Permissions:");
            Object aobj7[] = new Object[1];
            String s1;
            Object aobj8[];
            String s2;
            Object aobj9[];
            String s3;
            Object aobj10[];
            String s4;
            Object aobj11[];
            String s5;
            Object aobj12[];
            String s6;
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
            {
                s1 = "not ";
            } else
            {
                s1 = "";
            }
            aobj7[0] = s1;
            Log.i("android.permission.ACCESS_NETWORK_STATE is %spresent", aobj7);
            aobj8 = new Object[1];
            if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
            {
                s2 = "not ";
            } else
            {
                s2 = "";
            }
            aobj8[0] = s2;
            Log.i("android.permission.INTERNET is %spresent", aobj8);
            aobj9 = new Object[1];
            if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1)
            {
                s3 = "not ";
            } else
            {
                s3 = "";
            }
            aobj9[0] = s3;
            Log.i("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", aobj9);
            aobj10 = new Object[1];
            if (context.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1)
            {
                s4 = "not ";
            } else
            {
                s4 = "";
            }
            aobj10[0] = s4;
            Log.i("android.permission.VIBRATE is %spresent", aobj10);
            aobj11 = new Object[1];
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1)
            {
                s5 = "not ";
            } else
            {
                s5 = "";
            }
            aobj11[0] = s5;
            Log.i("android.permission.ACCESS_COARSE_LOCATION is %spresent", aobj11);
            aobj12 = new Object[1];
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1)
            {
                s6 = "not ";
            } else
            {
                s6 = "";
            }
            aobj12[0] = s6;
            Log.i("android.permission.ACCESS_FINE_LOCATION is %spresent", aobj12);
            Log.i("Cached Ads:");
            AdCache.iterateCachedAds(context, 2, new _cls2());
        }
    }

    static boolean removeAccelForJira1164()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 14;
    }

    public static void resetCache(Context context)
    {
        AdCache.resetCache(context);
    }

    static void runOnUiThread(Runnable runnable)
    {
        if (isUiThread())
        {
            runnable.run();
            return;
        } else
        {
            mainHandler.post(runnable);
            return;
        }
    }

    static void runOnUiThreadDelayed(Runnable runnable, long l)
    {
        mainHandler.postDelayed(runnable, l);
    }

    public static void setBroadcastEvents(boolean flag)
    {
        isBroadcastingEvents = flag;
    }

    public static void setLogLevel(int i)
    {
        logLevel = i;
    }

    static void setMMdid(String s)
    {
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        getMMdidValue = s;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean supportsFullScreenInline()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 11;
    }

    public static void trackConversion(Context context, String s)
    {
        MMConversionTracker.trackConversion(context, s, null);
    }

    public static void trackConversion(Context context, String s, MMRequest mmrequest)
    {
        MMConversionTracker.trackConversion(context, s, mmrequest);
    }

    public static void trackEvent(Context context, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            String s1 = getMMdid(context);
            if (!TextUtils.isEmpty(s1))
            {
                Utils.HttpUtils.executeUrl((new StringBuilder("http://ads.mp.mydas.mobi/pixel?id=")).append(s).append("&mmdid=").append(s1).toString());
            }
        }
    }



    private class Log
    {

        static void d(String s)
        {
            if (MMSDK.logLevel > 0)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder("Diagnostic - ")).append(s).toString());
            }
        }

        static transient void d(String s, Object aobj[])
        {
            if (MMSDK.logLevel > 0)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder("Diagnostic - ")).append(String.format(s, aobj)).toString());
            }
        }

        static void d(Throwable throwable)
        {
            if (MMSDK.logLevel > 0)
            {
                d(android.util.Log.getStackTraceString(throwable));
            }
        }

        static void e(String s)
        {
            android.util.Log.e("MillennialMediaSDK", s);
        }

        static transient void e(String s, Object aobj[])
        {
            android.util.Log.e("MillennialMediaSDK", String.format(s, aobj));
        }

        static void e(Throwable throwable)
        {
            android.util.Log.e("MillennialMediaSDK", android.util.Log.getStackTraceString(throwable));
        }

        static void i(String s)
        {
            android.util.Log.i("MillennialMediaSDK", s);
        }

        static transient void i(String s, Object aobj[])
        {
            android.util.Log.i("MillennialMediaSDK", String.format(s, aobj));
        }

        static void i(Throwable throwable)
        {
            android.util.Log.i("MillennialMediaSDK", android.util.Log.getStackTraceString(throwable));
        }

        static void p(String s)
        {
            if (MMSDK.logLevel > 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder("Private - ")).append(s).toString());
            }
        }

        static transient void p(String s, Object aobj[])
        {
            if (MMSDK.logLevel > 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder("Private - ")).append(String.format(s, aobj)).toString());
            }
        }

        static void p(Throwable throwable)
        {
            if (MMSDK.logLevel > 3)
            {
                p(android.util.Log.getStackTraceString(throwable));
            }
        }

        static void v(String s)
        {
            if (MMSDK.logLevel >= 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder("Verbose - ")).append(s).toString());
            }
        }

        static transient void v(String s, Object aobj[])
        {
            if (MMSDK.logLevel >= 3)
            {
                android.util.Log.i("MillennialMediaSDK", (new StringBuilder("Verbose - ")).append(String.format(s, aobj)).toString());
            }
        }

        static void v(Throwable throwable)
        {
            if (MMSDK.logLevel >= 3)
            {
                v(android.util.Log.getStackTraceString(throwable));
            }
        }

        static void w(String s)
        {
            android.util.Log.w("MillennialMediaSDK", s);
        }

        static transient void w(String s, Object aobj[])
        {
            android.util.Log.w("MillennialMediaSDK", String.format(s, aobj));
        }

        static void w(Throwable throwable)
        {
            android.util.Log.w("MillennialMediaSDK", android.util.Log.getStackTraceString(throwable));
        }

        Log()
        {
        }
    }


    private class _cls1
        implements android.content.DialogInterface.OnClickListener
    {

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            dialoginterface.cancel();
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends AdCache.Iterator
    {

        final Context val$context;

        final boolean callback(CachedAd cachedad)
        {
            Object aobj[] = new Object[4];
            aobj[0] = cachedad.getTypeString();
            aobj[1] = cachedad.getId();
            String s;
            String s1;
            if (cachedad.isOnDisk(context))
            {
                s = "";
            } else
            {
                s = "not ";
            }
            aobj[2] = s;
            if (cachedad.isExpired())
            {
                s1 = "";
            } else
            {
                s1 = "not ";
            }
            aobj[3] = s1;
            Log.i("%s %s is %son disk. Is %sexpired.", aobj);
            return true;
        }

        _cls2()
        {
            context = context1;
            super();
        }
    }

}
