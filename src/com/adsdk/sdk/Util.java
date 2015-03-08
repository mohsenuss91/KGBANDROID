// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Locale;

// Referenced classes of package com.adsdk.sdk:
//            Log

public class Util
{

    private static final float MINIMAL_ACCURACY = 1000F;
    private static final long MINIMAL_TIME_FROM_FIX = 0x124f80L;
    private static String androidAdId;

    public Util()
    {
    }

    public static String buildUserAgent()
    {
        String s = android.os.Build.VERSION.RELEASE;
        String s1 = Build.MODEL;
        String s2 = Build.ID;
        Locale locale = Locale.getDefault();
        String s3 = locale.getLanguage();
        String s4 = "en";
        if (s3 != null)
        {
            s4 = s3.toLowerCase();
            String s5 = locale.getCountry();
            if (s5 != null)
            {
                s4 = (new StringBuilder(String.valueOf(s4))).append("-").append(s5.toLowerCase()).toString();
            }
        }
        return String.format("Mozilla/5.0 (Linux; U; Android %1$s; %2$s; %3$s Build/%4$s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1", new Object[] {
            s, s4, s1, s2
        });
    }

    public static String getAndroidAdId()
    {
        if (androidAdId == null)
        {
            return "";
        } else
        {
            return androidAdId;
        }
    }

    public static String getConnectionType(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo == null)
            {
                return "UNKNOWN";
            }
            int i = networkinfo.getType();
            int j = networkinfo.getSubtype();
            if (i == 1)
            {
                return "WIFI";
            }
            if (i == 6)
            {
                return "WIMAX";
            }
            if (i == 0)
            {
                switch (j)
                {
                default:
                    return "MOBILE";

                case 7: // '\007'
                    return "1xRTT";

                case 4: // '\004'
                    return "CDMA";

                case 2: // '\002'
                    return "EDGE";

                case 5: // '\005'
                    return "EVDO_0";

                case 6: // '\006'
                    return "EVDO_A";

                case 1: // '\001'
                    return "GPRS";

                case 3: // '\003'
                    return "UMTS";

                case 14: // '\016'
                    return "EHRPD";

                case 12: // '\f'
                    return "EVDO_B";

                case 8: // '\b'
                    return "HSDPA";

                case 10: // '\n'
                    return "HSPA";

                case 15: // '\017'
                    return "HSPAP";

                case 9: // '\t'
                    return "HSUPA";

                case 11: // '\013'
                    return "IDEN";

                case 13: // '\r'
                    return "LTE";
                }
            } else
            {
                return "UNKNOWN";
            }
        } else
        {
            return "UNKNOWN";
        }
    }

    public static String getDefaultUserAgentString(Context context)
    {
        return System.getProperty("http.agent");
    }

    public static String getDeviceId(Context context)
    {
        String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (s == null || s.equals("9774d56d682e549c") || s.equals("0000000000000000"))
        {
            s = "";
        }
        return s;
    }

    public static String getLocalIpAddress()
    {
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L2:
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        Enumeration enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L4:
        if (!enumeration1.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration1.nextElement();
        if (inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        String s = inetaddress.getHostAddress().toString();
        return s;
        SocketException socketexception;
        socketexception;
        Log.e(socketexception.toString());
        return null;
    }

    public static Location getLocation(Context context)
    {
        boolean flag;
        boolean flag1;
        LocationManager locationmanager;
        Location location;
        long l;
        Location location1;
        long l1;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
        {
            flag = true;
            flag1 = true;
        } else
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
        {
            flag = true;
            flag1 = false;
        } else
        {
            flag = false;
            flag1 = false;
        }
        locationmanager = (LocationManager)context.getSystemService("location");
        if (locationmanager == null || !flag1 || !locationmanager.isProviderEnabled("gps")) goto _L2; else goto _L1
_L1:
        location1 = locationmanager.getLastKnownLocation("gps");
        if (location1 != null) goto _L4; else goto _L3
_L3:
        location = null;
_L6:
        return location;
_L4:
        l1 = Math.abs(System.currentTimeMillis() - location1.getTime());
        if (location1.hasAccuracy() && location1.getAccuracy() < 1000F && l1 < 0x124f80L)
        {
            return location1;
        }
_L2:
        if (locationmanager == null || !flag || !locationmanager.isProviderEnabled("network"))
        {
            break; /* Loop/switch isn't completed */
        }
        location = locationmanager.getLastKnownLocation("network");
        if (location == null)
        {
            return null;
        }
        l = Math.abs(System.currentTimeMillis() - location.getTime());
        if (location.hasAccuracy() && location.getAccuracy() < 1000F && l < 0x124f80L) goto _L6; else goto _L5
_L5:
        return null;
    }

    public static int getMemoryClass(Context context)
    {
        int i;
        try
        {
            i = ((Integer)android/app/ActivityManager.getMethod("getMemoryClass", new Class[0]).invoke((ActivityManager)context.getSystemService("activity"), new Object[0])).intValue();
        }
        catch (Exception exception)
        {
            return 16;
        }
        return i;
    }

    public static String getTelephonyDeviceId(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0)
        {
            return ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        } else
        {
            return "";
        }
    }

    public static boolean isNetworkAvailable(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo == null)
            {
                return false;
            }
            int i = networkinfo.getType();
            if (i == 1 || i == 0)
            {
                return networkinfo.isConnected();
            } else
            {
                return false;
            }
        } else
        {
            return true;
        }
    }

    public static void prepareAndroidAdId(final Context context)
    {
        try
        {
            Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return;
        }
        if (androidAdId == null && GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0)
        {
            (new _cls1()).execute(new Void[0]);
        }
    }


    private class _cls1 extends AsyncTask
    {

        private final Context val$context;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                Util.androidAdId = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
            {
                googleplayservicesnotavailableexception.printStackTrace();
            }
            catch (IllegalStateException illegalstateexception)
            {
                illegalstateexception.printStackTrace();
            }
            catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
            {
                googleplayservicesrepairableexception.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            return null;
        }

        _cls1()
        {
            context = context1;
            super();
        }
    }

}
