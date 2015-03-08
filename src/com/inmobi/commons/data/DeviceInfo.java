// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

public class DeviceInfo
{

    private static String a;
    private static String b;
    private static String c;
    private static String d = null;
    private static String e = null;
    private static String f;
    private static String g;
    private static int h;
    private static DeviceInfo i = new DeviceInfo();

    private DeviceInfo()
    {
    }

    private static String a()
    {
        return c;
    }

    private static void a(int j)
    {
        h = j;
    }

    private static void a(Context context)
    {
        try
        {
            if (f == null)
            {
                f = context.getSharedPreferences("inmobisdkaid", 0).getString("A_ID", null);
            }
            if (f == null)
            {
                f = UUID.randomUUID().toString();
                android.content.SharedPreferences.Editor editor = context.getSharedPreferences("inmobisdkaid", 0).edit();
                editor.putString("A_ID", f);
                editor.commit();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private static void a(String s)
    {
        a = s;
    }

    private static void b(String s)
    {
        b = s;
    }

    private static void c(String s)
    {
        c = s;
    }

    public static String getAid()
    {
        return f;
    }

    public static DeviceInfo getInstance()
    {
        return i;
    }

    public static String getLocalization()
    {
        return b;
    }

    public static String getNetworkType()
    {
        return a;
    }

    public static int getOrientation()
    {
        return h;
    }

    public static String getPhoneDefaultUserAgent()
    {
        if (g == null)
        {
            return "";
        } else
        {
            return g;
        }
    }

    public static String getScreenDensity()
    {
        return e;
    }

    public static String getScreenSize()
    {
        return d;
    }

    public static void setPhoneDefaultUserAgent(String s)
    {
        g = s;
    }

    public static void setScreenDensity(String s)
    {
        e = s;
    }

    public static void setScreenSize(String s)
    {
        d = s;
    }

    public void fillDeviceInfo()
    {
        if (a() != null) goto _L2; else goto _L1
_L1:
        Locale locale;
        String s;
        c = Build.BRAND;
        locale = Locale.getDefault();
        s = locale.getLanguage();
        if (s == null) goto _L4; else goto _L3
_L3:
        String s3;
        s3 = s.toLowerCase(Locale.ENGLISH);
        String s4 = locale.getCountry();
        if (s4 != null)
        {
            s3 = (new StringBuilder()).append(s3).append("_").append(s4.toLowerCase(Locale.ENGLISH)).toString();
        }
_L6:
        b(s3);
_L2:
        if (InternalSDKUtil.getContext() != null)
        {
            a(InternalSDKUtil.getContext());
        }
        a(InternalSDKUtil.getConnectivityType(InternalSDKUtil.getContext()));
        int j = WrapperFunctions.getCurrentOrientationInFixedValues(InternalSDKUtil.getContext());
        if (j != 9)
        {
            break; /* Loop/switch isn't completed */
        }
        String s1;
        String s2;
        try
        {
            a(2);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-4.4.1", "Error getting the orientation info ", exception);
        }
        break MISSING_BLOCK_LABEL_220;
_L4:
        s1 = (String)System.getProperties().get("user.language");
        s2 = (String)System.getProperties().get("user.region");
        if (s1 != null && s2 != null)
        {
            s3 = (new StringBuilder()).append(s1).append("_").append(s2).toString();
        } else
        {
            s3 = s;
        }
        if (s3 == null)
        {
            s3 = "en";
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (j != 8)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        a(4);
        return;
        return;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        a(3);
        return;
        a(1);
        return;
    }

}
