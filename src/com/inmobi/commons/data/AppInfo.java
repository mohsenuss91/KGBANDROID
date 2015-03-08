// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class AppInfo
{

    private static String a;
    private static String b;
    private static String c;
    private static String d;

    public AppInfo()
    {
    }

    private static void a(String s)
    {
        b = s;
    }

    private static void b(String s)
    {
        a = s;
    }

    private static void c(String s)
    {
        c = s;
    }

    public static void fillAppInfo()
    {
        Context context;
        PackageManager packagemanager;
        ApplicationInfo applicationinfo;
        PackageInfo packageinfo;
        String s;
        try
        {
            context = InternalSDKUtil.getContext();
            packagemanager = context.getPackageManager();
            applicationinfo = packagemanager.getApplicationInfo(context.getPackageName(), 128);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Failed to fill AppInfo", exception);
            return;
        }
        if (applicationinfo == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        a = applicationinfo.packageName;
        b = applicationinfo.loadLabel(packagemanager).toString();
        packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 128);
        s = null;
        if (packageinfo == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        s = packageinfo.versionName;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (!s.equals(""))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        s = (new StringBuilder()).append(packageinfo.versionCode).toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        if (!s.equals(""))
        {
            c(s);
        }
    }

    public static String getAppBId()
    {
        return a;
    }

    public static String getAppDisplayName()
    {
        return b;
    }

    public static String getAppId()
    {
        return d;
    }

    public static String getAppVer()
    {
        return c;
    }

    public static void setAppId(String s)
    {
        d = s;
    }
}
