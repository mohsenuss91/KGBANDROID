// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.net.Uri;

public final class z
{

    private static final Uri a = Uri.parse("http://play.google.com/store/apps/details");

    public static int a(Context context, Context context1)
    {
label0:
        {
            int i = 0;
            if (context1 != null)
            {
                i = context1.getResources().getIdentifier("clientTheme", "style", a(context));
            }
            if (i == 0)
            {
                if (android.os.Build.VERSION.SDK_INT < 14)
                {
                    break label0;
                }
                i = 0x1030128;
            }
            return i;
        }
        return android.os.Build.VERSION.SDK_INT < 11 ? 0x1030005 : 0x103006b;
    }

    public static Intent a(String s)
    {
        Uri uri = Uri.fromParts("package", s, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uri);
        return intent;
    }

    public static String a(Context context)
    {
        Intent intent = new Intent("com.google.android.youtube.api.service.START");
        PackageManager packagemanager = context.getPackageManager();
        ResolveInfo resolveinfo = packagemanager.resolveService(intent, 0);
        if (resolveinfo != null && resolveinfo.serviceInfo != null && resolveinfo.serviceInfo.packageName != null)
        {
            return resolveinfo.serviceInfo.packageName;
        }
        if (packagemanager.hasSystemFeature("com.google.android.tv"))
        {
            return "com.google.android.youtube.googletv";
        } else
        {
            return "com.google.android.youtube";
        }
    }

    public static boolean a(Context context, String s)
    {
        Resources resources;
        try
        {
            resources = context.getPackageManager().getResourcesForApplication(s);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return true;
        }
        if (s.equals("com.google.android.youtube.googletvdev"))
        {
            s = "com.google.android.youtube.googletv";
        }
        for (int i = resources.getIdentifier("youtube_api_version_code", "integer", s); i == 0 || 1000 > resources.getInteger(i);)
        {
            return true;
        }

        return false;
    }

    public static boolean a(PackageManager packagemanager)
    {
        return packagemanager.hasSystemFeature("com.google.android.tv");
    }

    public static Context b(Context context)
    {
        Context context1;
        try
        {
            context1 = context.createPackageContext(a(context), 3);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        return context1;
    }

    public static Intent b(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(a.buildUpon().appendQueryParameter("id", s).build());
        intent.setPackage("com.android.vending");
        intent.addFlags(0x80000);
        return intent;
    }

    public static int c(Context context)
    {
        return a(context, b(context));
    }

    public static String d(Context context)
    {
        String s;
        try
        {
            s = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", namenotfoundexception);
        }
        return s;
    }

}
