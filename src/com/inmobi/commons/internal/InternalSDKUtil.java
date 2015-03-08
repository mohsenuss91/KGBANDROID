// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.AdvertisingId;
import com.inmobi.commons.uid.UIDHelper;
import com.inmobi.commons.uid.UIDUtil;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.internal:
//            CommonsConfig, d, Base64, ApiStatCollector, 
//            Log, CommonsException

public class InternalSDKUtil
{

    public static final String BASE_LOG_TAG = "[InMobi]";
    public static final String CLASS_PLATFORM_ID = "com.inmobi.commons.uid.PlatformId";
    public static final String CLASS_PLAYSERVICES = "com.google.android.gms.common.GooglePlayServicesUtil";
    public static final String IM_PREF = "impref";
    public static final String INMOBI_SDK_RELEASE_DATE = "20140613";
    public static final String INMOBI_SDK_RELEASE_VERSION = "4.4.1";
    public static final String LOGGING_TAG = "[InMobi]-4.4.1";
    public static final String METHOD_PLAY_AVAILABLE = "isGooglePlayServicesAvailable";
    public static final String PRODUCT_COMMONS = "commons";
    private static CommonsConfig a = new CommonsConfig();
    private static String b;
    private static Context c = null;
    private static Map d = new HashMap();
    private static com.inmobi.commons.cache.CacheController.Validator e = new com.inmobi.commons.internal.d();
    private static boolean f = true;
    private static byte g[] = new byte[16];
    private static String h = "SHA1PRNG";
    private static String i = "Crypto";
    private static String j = "HmacSHA1";
    private static String k = "RSA";
    private static String l = "RSA/ECB/nopadding";
    private static String m = "aeskeygenerate";
    private static String n = "last_key_generate";
    private static String o = "AES/CBC/PKCS7Padding";
    private static String p = "AES";

    public InternalSDKUtil()
    {
    }

    public static byte[] DeAe(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        return a(abyte0, abyte1, abyte2);
    }

    public static String SeMeGe(String s, byte abyte0[], byte abyte1[], byte abyte2[], String s1, String s2)
    {
        return a(s, abyte0, abyte1, abyte2, s1, s2);
    }

    private static String a(String s, byte abyte0[], byte abyte1[], byte abyte2[], String s1, String s2)
    {
        String s3;
        try
        {
            byte abyte3[] = b(s.getBytes("UTF-8"), abyte0, abyte1);
            byte abyte4[] = a(abyte3, abyte2);
            byte abyte5[] = a(abyte3);
            byte abyte6[] = a(abyte4);
            byte abyte7[] = a(abyte1);
            s3 = new String(Base64.encode(b(a(a(b(b(a(abyte0), a(abyte2)), abyte7), s2, s1)), b(abyte5, abyte6)), 8));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return s3;
    }

    private static void a()
    {
        d = UIDUtil.getMap(getContext(), null);
    }

    static boolean a(Map map)
    {
        a();
        try
        {
            CommonsConfig commonsconfig = new CommonsConfig();
            commonsconfig.setFromMap(map);
            a = commonsconfig;
            ApiStatCollector.getLogger().setMetricConfigParams(commonsconfig.getApiStatsConfig());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    private static byte[] a(byte abyte0[])
    {
        long l1 = abyte0.length;
        ByteBuffer bytebuffer = ByteBuffer.allocate(8);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        bytebuffer.putLong(l1);
        byte abyte1[] = bytebuffer.array();
        byte abyte2[] = new byte[abyte1.length + abyte0.length];
        System.arraycopy(abyte1, 0, abyte2, 0, abyte1.length);
        System.arraycopy(abyte0, 0, abyte2, abyte1.length, abyte0.length);
        return abyte2;
    }

    private static byte[] a(byte abyte0[], String s, String s1)
    {
        BigInteger biginteger = new BigInteger(s1, 16);
        BigInteger biginteger1 = new BigInteger(s, 16);
        byte abyte1[];
        try
        {
            RSAPublicKey rsapublickey = (RSAPublicKey)KeyFactory.getInstance(k).generatePublic(new a(biginteger, biginteger1));
            Cipher cipher = Cipher.getInstance(l);
            cipher.init(1, rsapublickey);
            abyte1 = cipher.doFinal(abyte0);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchAlgorithmException");
            return null;
        }
        catch (InvalidKeySpecException invalidkeyspecexception)
        {
            Log.internal("[InMobi]-4.4.1", "InvalidKeySpecException");
            return null;
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchPaddingException");
            return null;
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            Log.internal("[InMobi]-4.4.1", "InvalidKeyException");
            return null;
        }
        catch (IllegalBlockSizeException illegalblocksizeexception)
        {
            Log.internal("[InMobi]-4.4.1", "IllegalBlockSizeException");
            return null;
        }
        catch (BadPaddingException badpaddingexception)
        {
            Log.internal("[InMobi]-4.4.1", "BadPaddingException");
            return null;
        }
        return abyte1;
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
    {
        d d1 = new d(abyte1, 0, abyte1.length, j);
        byte abyte2[];
        try
        {
            Mac mac = Mac.getInstance(j);
            mac.init(d1);
            abyte2 = mac.doFinal(abyte0);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchAlgorithmException");
            return null;
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            Log.internal("[InMobi]-4.4.1", "InvalidKeyException");
            return null;
        }
        return abyte2;
    }

    private static byte[] a(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        d d1 = new d(abyte1, p);
        byte abyte3[];
        try
        {
            Cipher cipher = Cipher.getInstance(o);
            cipher.init(2, d1, new c(abyte2));
            abyte3 = cipher.doFinal(abyte0);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchAlgorithmException");
            return null;
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchPaddingException");
            return null;
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            Log.internal("[InMobi]-4.4.1", "InvalidKeyException");
            return null;
        }
        catch (IllegalBlockSizeException illegalblocksizeexception)
        {
            Log.internal("[InMobi]-4.4.1", "IllegalBlockSizeException");
            return null;
        }
        catch (BadPaddingException badpaddingexception)
        {
            Log.internal("[InMobi]-4.4.1", "BadPaddingException");
            return null;
        }
        catch (InvalidAlgorithmParameterException invalidalgorithmparameterexception)
        {
            Log.internal("[InMobi]-4.4.1", "InvalidAlgorithmParameterException");
            return null;
        }
        return abyte3;
    }

    public static void addCommonPropertiesToConnection(HttpURLConnection httpurlconnection)
    {
        String s = getUserAgent(getContext());
        if (s != null)
        {
            httpurlconnection.setRequestProperty("User-Agent", s);
        }
    }

    private static byte[] b()
    {
        try
        {
            SecureRandom.getInstance(h, i).nextBytes(g);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchAlgorithmException");
        }
        catch (NoSuchProviderException nosuchproviderexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchProviderException");
        }
        return g;
    }

    private static byte[] b(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

    private static byte[] b(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        d d1 = new d(abyte1, p);
        c c1 = new c(abyte2);
        byte abyte3[];
        try
        {
            Cipher cipher = Cipher.getInstance(o);
            cipher.init(1, d1, c1);
            abyte3 = cipher.doFinal(abyte0);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchAlgorithmException");
            return null;
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            Log.internal("[InMobi]-4.4.1", "NoSuchPaddingException");
            return null;
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            Log.internal("[InMobi]-4.4.1", "InvalidKeyException");
            return null;
        }
        catch (IllegalBlockSizeException illegalblocksizeexception)
        {
            Log.internal("[InMobi]-4.4.1", "IllegalBlockSizeException");
            return null;
        }
        catch (BadPaddingException badpaddingexception)
        {
            Log.internal("[InMobi]-4.4.1", "BadPaddingException");
            return null;
        }
        catch (InvalidAlgorithmParameterException invalidalgorithmparameterexception)
        {
            Log.internal("[InMobi]-4.4.1", "InvalidAlgorithmParameterException");
            return null;
        }
        return abyte3;
    }

    private static byte[] c()
    {
        SharedPreferences sharedpreferences = getContext().getSharedPreferences(m, 0);
        long l1 = sharedpreferences.getLong(n, 0L);
        if (0L == l1)
        {
            Log.internal("[InMobi]-4.4.1", "Generating for first time");
            android.content.SharedPreferences.Editor editor1 = sharedpreferences.edit();
            editor1.putLong(n, System.currentTimeMillis());
            editor1.commit();
            return b();
        }
        long l2 = System.currentTimeMillis();
        if ((l1 + 0x5265c00L) - l2 <= 0L)
        {
            Log.internal("[InMobi]-4.4.1", "generated again");
            android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putLong(n, System.currentTimeMillis());
            editor.commit();
            return b();
        } else
        {
            Log.internal("[InMobi]-4.4.1", "already generated");
            return g;
        }
    }

    public static boolean checkNetworkAvailibility(Context context)
    {
        if (context == null)
        {
            return false;
        }
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager.getActiveNetworkInfo() == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = connectivitymanager.getActiveNetworkInfo().isConnected();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot check network state", exception);
            return false;
        }
        return flag;
    }

    public static boolean getBooleanFromJSON(JSONObject jsonobject, String s, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = jsonobject.getBoolean(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.4.1", (new StringBuilder("JSON with property ")).append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(flag).toString());
            }
            catch (JSONException jsonexception)
            {
                return flag;
            }
            return flag;
        }
        return flag1;
    }

    public static boolean getBooleanFromMap(Map map, String s)
    {
        Object obj = map.get(s);
        if (obj instanceof Boolean)
        {
            return ((Boolean)obj).booleanValue();
        } else
        {
            Log.internal("[InMobi]-4.4.1", (new StringBuilder("Key ")).append(s).append(" has illegal value").toString());
            throw new IllegalArgumentException();
        }
    }

    public static CommonsConfig getConfig()
    {
        return a;
    }

    public static String getConnectivityType(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) goto _L2; else goto _L1
_L1:
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        if (connectivitymanager == null) goto _L2; else goto _L3
_L3:
        int j1;
        int i1;
        try
        {
            NetworkInfo networkinfo = connectivitymanager.getActiveNetworkInfo();
            i1 = networkinfo.getType();
            j1 = networkinfo.getSubtype();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Error getting the network info", exception);
            return null;
        }
        if (i1 == 1)
        {
            return "wifi";
        }
        if (i1 != 0) goto _L2; else goto _L4
_L7:
        if (j1 == 0)
        {
            return "carrier";
        }
          goto _L5
_L2:
        s = null;
_L5:
        return s;
_L4:
        String s = "carrier";
        if (j1 == 1)
        {
            return "gprs";
        }
        if (j1 == 2)
        {
            return "edge";
        }
        if (j1 == 3)
        {
            return "umts";
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static Context getContext()
    {
        return c;
    }

    public static int getDisplayRotation(Display display)
    {
        Method method2 = android/view/Display.getMethod("getRotation", null);
        Method method = method2;
_L2:
        if (method == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int i1 = ((Integer)method.invoke(display, null)).intValue();
        return i1;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        Method method1 = android/view/Display.getMethod("getOrientation", null);
        method = method1;
        continue; /* Loop/switch isn't completed */
        NoSuchMethodException nosuchmethodexception1;
        nosuchmethodexception1;
        Log.internal("commons", "Unable to access getOrientation method via reflection");
        method = null;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        Log.internal("commons", "Unable to access display rotation");
_L1:
        return -999;
    }

    public static String getFinalRedirectedUrl(String s)
    {
        int i1;
        String s1;
        i1 = 0;
        s1 = s;
_L5:
        HttpURLConnection httpurlconnection;
        int j1;
        httpurlconnection = (HttpURLConnection)(new URL(s1)).openConnection();
        addCommonPropertiesToConnection(httpurlconnection);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setRequestMethod("GET");
        j1 = httpurlconnection.getResponseCode();
        if (j1 < 300 || j1 >= 400)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        String s4 = httpurlconnection.getHeaderField("Location");
        String s3;
        s3 = s4;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        if (httpurlconnection.getResponseCode() == 200) goto _L2; else goto _L1
_L1:
        int k1 = i1 + 1;
        if (i1 < 5) goto _L3; else goto _L2
_L2:
        httpurlconnection.disconnect();
        return s3;
        Exception exception;
        exception;
        Exception exception1;
        String s2;
        exception1 = exception;
        s2 = s1;
_L4:
        Log.internal("[InMobi]-4.4.1", "Cannot get redirect url", exception1);
        return s2;
        Exception exception2;
        exception2;
        s2 = s3;
        exception1 = exception2;
        if (true) goto _L4; else goto _L3
_L3:
        i1 = k1;
        s1 = s3;
          goto _L5
        s3 = s1;
          goto _L2
    }

    public static String getInMobiInternalVersion(String s)
    {
        String as[] = s.split("[.]");
        StringBuffer stringbuffer = new StringBuffer("");
        int i1 = 0;
        while (i1 < as.length) 
        {
            try
            {
                int j1 = 65 + Integer.valueOf(as[i1]).intValue();
                stringbuffer.append("T").append((char)j1);
            }
            catch (NumberFormatException numberformatexception) { }
            i1++;
        }
        if (stringbuffer.equals(""))
        {
            return "";
        } else
        {
            return stringbuffer.substring(1).toString();
        }
    }

    public static int getIntFromJSON(JSONObject jsonobject, String s, int i1)
    {
        int j1;
        try
        {
            j1 = jsonobject.getInt(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.4.1", (new StringBuilder("JSON with property ")).append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(i1).toString());
            }
            catch (JSONException jsonexception)
            {
                return i1;
            }
            return i1;
        }
        return j1;
    }

    public static int getIntFromMap(Map map, String s, int i1, long l1)
    {
        Object obj = map.get(s);
        if (obj instanceof Integer)
        {
            int j1 = ((Integer)obj).intValue();
            if ((long)j1 <= l1 && j1 >= i1)
            {
                return j1;
            }
        }
        Log.internal("[InMobi]-4.4.1", (new StringBuilder("Key ")).append(s).append(" has illegal value").toString());
        throw new IllegalArgumentException();
    }

    public static long getLongFromJSON(JSONObject jsonobject, String s, long l1)
    {
        long l2;
        try
        {
            l2 = jsonobject.getLong(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.4.1", (new StringBuilder("JSON with property ")).append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(l1).toString());
            }
            catch (JSONException jsonexception)
            {
                return l1;
            }
            return l1;
        }
        return l2;
    }

    public static long getLongFromMap(Map map, String s, long l1, long l2)
    {
        Object obj = map.get(s);
        if (obj instanceof Long)
        {
            long l3 = ((Long)obj).longValue();
            if (l3 <= l2 && l3 >= l1)
            {
                return l3;
            }
        }
        if (l1 < 0xffffffff80000000L)
        {
            l1 = 0xffffffff80000000L;
        }
        int i1 = (int)l1;
        if (l2 > 0x7fffffffL)
        {
            l2 = 0x7fffffffL;
        }
        return (long)getIntFromMap(map, s, i1, (int)l2);
    }

    public static String getSavedUserAgent()
    {
        return b;
    }

    public static String getStringFromJSON(JSONObject jsonobject, String s, String s1)
    {
        String s2;
        try
        {
            s2 = jsonobject.getString(s);
        }
        catch (Exception exception)
        {
            try
            {
                Log.debug("[InMobi]-4.4.1", (new StringBuilder("JSON with property ")).append(s).append(" found but has bad datatype(").append(jsonobject.get(s).getClass()).append("). Reverting to ").append(s1).toString());
            }
            catch (JSONException jsonexception)
            {
                return s1;
            }
            return s1;
        }
        return s2;
    }

    public static String getStringFromMap(Map map, String s)
    {
        Object obj = map.get(s);
        if (obj instanceof String)
        {
            return (String)obj;
        } else
        {
            Log.internal("[InMobi]-4.4.1", (new StringBuilder("Key ")).append(s).append(" has illegal value").toString());
            throw new IllegalArgumentException();
        }
    }

    public static String getUserAgent(Context context)
    {
        try
        {
            if (b == null)
            {
                if (android.os.Build.VERSION.SDK_INT >= 17)
                {
                    b = b.a(context);
                } else
                {
                    b = (new WebView(context)).getSettings().getUserAgentString();
                }
            }
            return b;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get user agent", exception);
        }
        return b;
    }

    public static void initialize(Context context)
    {
        if (getContext() == null)
        {
            if (context == null)
            {
                c.getApplicationContext();
            } else
            {
                c = context.getApplicationContext();
            }
        }
        if (InMobi.getAppId() == null)
        {
            return;
        }
        if (f)
        {
            f = false;
            a();
        }
        try
        {
            a(CacheController.getConfig("commons", context, d, e).getData());
            return;
        }
        catch (CommonsException commonsexception)
        {
            Log.internal("[InMobi]-4.4.1", (new StringBuilder("IMCommons config init: IMCommonsException caught. Reason: ")).append(commonsexception.toString()).toString());
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Exception while getting commons config data.");
        }
    }

    public static boolean isDefOrientationLandscape(int i1, int j1, int k1)
    {
        while (j1 > k1 && (i1 == 0 || i1 == 2) || j1 < k1 && (i1 == 1 || i1 == 3)) 
        {
            return true;
        }
        return false;
    }

    public static boolean isGooglePlayServicesJarIncluded()
    {
        int i1;
        try
        {
            Method method = Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getDeclaredMethod("isGooglePlayServicesAvailable", new Class[] {
                android/content/Context
            });
            Object aobj[] = new Object[1];
            aobj[0] = getContext();
            i1 = ((Integer)method.invoke(null, aobj)).intValue();
        }
        catch (Exception exception)
        {
            return false;
        }
        return i1 == 0;
    }

    public static boolean isHexString(String s)
    {
        return s.matches("[0-9A-F]+");
    }

    public static boolean isInitializedSuccessfully()
    {
        return isInitializedSuccessfully(true);
    }

    public static boolean isInitializedSuccessfully(boolean flag)
    {
        if (getContext() == null || InMobi.getAppId() == null)
        {
            if (flag)
            {
                Log.debug("[InMobi]-4.4.1", "InMobi not initialized. Call InMobi.initialize before using any InMobi API");
            }
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean isLimitAdTrackingEnabled()
    {
        AdvertisingId advertisingid = UIDHelper.getAdvertisingId();
        if (advertisingid != null)
        {
            return advertisingid.isLimitAdTracking();
        } else
        {
            return false;
        }
    }

    public static boolean isPlatformIdEnabled()
    {
        try
        {
            Class.forName("com.inmobi.commons.uid.PlatformId");
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public static boolean isTablet(Context context)
    {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        display.getMetrics(displaymetrics);
        double d1 = (float)displaymetrics.widthPixels / displaymetrics.xdpi;
        double d2 = (float)displaymetrics.heightPixels / displaymetrics.ydpi;
        return Math.sqrt(d1 * d1 + d2 * d2) > 7D;
    }

    public static byte[] keag()
    {
        return c();
    }

    public static void populate(Map map, Map map1, boolean flag)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if (map1.get(s) == null)
            {
                map1.put(s, map.get(s));
            }
            Object obj = map.get(s);
            Object obj1 = map1.get(s);
            if ((obj instanceof Map) && (obj1 instanceof Map))
            {
                if (!flag)
                {
                    map1.put(s, obj);
                } else
                {
                    populate((Map)obj, (Map)obj1, true);
                }
            } else
            {
                map1.put(s, obj);
            }
        }

    }

    public static void populate(JSONObject jsonobject, JSONObject jsonobject1, boolean flag)
    {
        Iterator iterator = jsonobject.keys();
_L2:
        String s;
        Object obj;
        Object obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        JSONException jsonexception1;
        try
        {
            jsonobject1.get(s);
        }
        catch (JSONException jsonexception)
        {
            jsonobject1.put(s, jsonobject.get(s));
            continue; /* Loop/switch isn't completed */
        }
        obj = jsonobject.get(s);
        obj1 = jsonobject1.get(s);
        if (!(obj instanceof JSONObject) || !(obj1 instanceof JSONObject))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        if (!flag)
        {
            try
            {
                jsonobject1.put(s, obj);
            }
            // Misplaced declaration of an exception variable
            catch (JSONException jsonexception1)
            {
                Log.internal("[InMobi]-4.4.1", "Cannot populate to json exception", jsonexception1);
            }
            continue; /* Loop/switch isn't completed */
        }
        populate((JSONObject)obj, (JSONObject)obj1, true);
        continue; /* Loop/switch isn't completed */
        jsonobject1.put(s, obj);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static JSONObject populateToNewJSON(JSONObject jsonobject, JSONObject jsonobject1, boolean flag)
    {
        JSONObject jsonobject2 = new JSONObject();
        populate(jsonobject1, jsonobject2, false);
        populate(jsonobject, jsonobject2, flag);
        return jsonobject2;
    }

    public static Map populateToNewMap(Map map, Map map1, boolean flag)
    {
        HashMap hashmap = new HashMap();
        populate(map1, hashmap, false);
        populate(map, hashmap, flag);
        return hashmap;
    }

    public static void printPublisherTestId()
    {
        AdvertisingId advertisingid;
        if (!isGooglePlayServicesJarIncluded())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        advertisingid = UIDHelper.getAdvertisingId();
        if (advertisingid == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        String s1 = advertisingid.getAdId();
        String s;
        if (s1 != null)
        {
            try
            {
                Log.debug("[InMobi]-4.4.1", (new StringBuilder("Publisher device Id is ")).append(s1).toString());
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-4.4.1", "Cannot get publisher device id", exception);
            }
        }
        break MISSING_BLOCK_LABEL_92;
        if (isPlatformIdEnabled())
        {
            s = UIDHelper.getPlatformId();
            Log.debug("[InMobi]-4.4.1", (new StringBuilder("Publisher device Id is ")).append(UIDHelper.getODIN1(s)).toString());
            return;
        }
    }

    public static void setContext(Context context)
    {
label0:
        {
            if (c == null)
            {
                c = context.getApplicationContext();
                if (InMobi.getAppId() != null)
                {
                    break label0;
                }
            }
            return;
        }
        a();
        try
        {
            CacheController.getConfig("commons", context, d, e);
            return;
        }
        catch (CommonsException commonsexception)
        {
            Log.internal("commons", "Unable retrive config for commons product");
        }
    }

    public static boolean validateAppId(String s)
    {
        if (s == null)
        {
            Log.debug("[InMobi]-4.4.1", "appId is null");
            return false;
        }
        if (s.matches("(x)+"))
        {
            Log.debug("[InMobi]-4.4.1", "appId is all xxxxxxx");
            return false;
        }
        if ("".equals(s.trim()))
        {
            Log.debug("[InMobi]-4.4.1", "appId is all blank");
            return false;
        } else
        {
            return true;
        }
    }


    private class a extends RSAPublicKeySpec
    {

        public a(BigInteger biginteger, BigInteger biginteger1)
        {
            super(biginteger, biginteger1);
        }
    }


    private class d extends SecretKeySpec
    {

        public d(byte abyte0[], int i1, int j1, String s)
        {
            super(abyte0, i1, j1, s);
        }

        public d(byte abyte0[], String s)
        {
            super(abyte0, s);
        }
    }


    private class c extends IvParameterSpec
    {

        public c(byte abyte0[])
        {
            super(abyte0);
        }
    }


    private class b
    {

        static String a(Context context)
        {
            return WebSettings.getDefaultUserAgent(context);
        }

        b()
        {
        }
    }

}
