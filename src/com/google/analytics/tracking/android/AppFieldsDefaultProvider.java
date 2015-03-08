// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

// Referenced classes of package com.google.analytics.tracking.android:
//            DefaultProvider, Log

class AppFieldsDefaultProvider
    implements DefaultProvider
{

    private static AppFieldsDefaultProvider sInstance;
    private static Object sInstanceLock = new Object();
    protected String mAppId;
    protected String mAppInstallerId;
    protected String mAppName;
    protected String mAppVersion;

    protected AppFieldsDefaultProvider()
    {
    }

    private AppFieldsDefaultProvider(Context context)
    {
        PackageManager packagemanager;
        String s;
        packagemanager = context.getPackageManager();
        mAppId = context.getPackageName();
        mAppInstallerId = packagemanager.getInstallerPackageName(mAppId);
        s = mAppId;
        PackageInfo packageinfo = packagemanager.getPackageInfo(context.getPackageName(), 0);
        String s1 = null;
        if (packageinfo != null)
        {
            try
            {
                s = packagemanager.getApplicationLabel(packageinfo.applicationInfo).toString();
                s1 = packageinfo.versionName;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                Log.e((new StringBuilder("Error retrieving package info: appName set to ")).append(s).toString());
                s1 = null;
            }
        }
        mAppName = s;
        mAppVersion = s1;
        return;
    }

    static void dropInstance()
    {
        synchronized (sInstanceLock)
        {
            sInstance = null;
        }
    }

    public static AppFieldsDefaultProvider getProvider()
    {
        return sInstance;
    }

    public static void initializeProvider(Context context)
    {
        synchronized (sInstanceLock)
        {
            if (sInstance == null)
            {
                sInstance = new AppFieldsDefaultProvider(context);
            }
        }
    }

    public String getValue(String s)
    {
        if (s != null)
        {
            if (s.equals("&an"))
            {
                return mAppName;
            }
            if (s.equals("&av"))
            {
                return mAppVersion;
            }
            if (s.equals("&aid"))
            {
                return mAppId;
            }
            if (s.equals("&aiid"))
            {
                return mAppInstallerId;
            }
        }
        return null;
    }

    public boolean providesField(String s)
    {
        return "&an".equals(s) || "&av".equals(s) || "&aid".equals(s) || "&aiid".equals(s);
    }

}
