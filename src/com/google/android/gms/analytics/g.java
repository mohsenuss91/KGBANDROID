// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

// Referenced classes of package com.google.android.gms.analytics:
//            m, aa

class g
    implements m
{

    private static g tD;
    private static Object tn = new Object();
    protected String tA;
    protected String tB;
    protected String tC;
    protected String tz;

    protected g()
    {
    }

    private g(Context context)
    {
        PackageManager packagemanager;
        String s;
        packagemanager = context.getPackageManager();
        tB = context.getPackageName();
        tC = packagemanager.getInstallerPackageName(tB);
        s = tB;
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
                aa.A((new StringBuilder("Error retrieving package info: appName set to ")).append(s).toString());
                s1 = null;
            }
        }
        tz = s;
        tA = s1;
        return;
    }

    public static g cp()
    {
        return tD;
    }

    public static void r(Context context)
    {
        synchronized (tn)
        {
            if (tD == null)
            {
                tD = new g(context);
            }
        }
    }

    public boolean J(String s)
    {
        return "&an".equals(s) || "&av".equals(s) || "&aid".equals(s) || "&aiid".equals(s);
    }

    public String getValue(String s)
    {
        if (s != null)
        {
            if (s.equals("&an"))
            {
                return tz;
            }
            if (s.equals("&av"))
            {
                return tA;
            }
            if (s.equals("&aid"))
            {
                return tB;
            }
            if (s.equals("&aiid"))
            {
                return tC;
            }
        }
        return null;
    }

}
