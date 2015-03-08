// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.TreeMap;

// Referenced classes of package com.millennialmedia.android:
//            MMRequest, MMSDK, HandShake

final class MMConversionTracker
{

    private static final String KEY_REFERRER = "installReferrer";

    MMConversionTracker()
    {
    }

    protected static void trackConversion(Context context, final String goalId, MMRequest mmrequest)
    {
        int i = 0;
        com/millennialmedia/android/MMConversionTracker;
        JVM INSTR monitorenter ;
        if (context == null || goalId == null) goto _L2; else goto _L1
_L1:
        int j = goalId.length();
        if (j != 0) goto _L3; else goto _L2
_L2:
        com/millennialmedia/android/MMConversionTracker;
        JVM INSTR monitorexit ;
        return;
_L3:
        SharedPreferences sharedpreferences;
        final boolean isFirstLaunch;
        String s;
        final TreeMap extraParams;
        sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        isFirstLaunch = sharedpreferences.getBoolean((new StringBuilder("firstLaunch_")).append(goalId).toString(), true);
        s = sharedpreferences.getString("installReferrer", null);
        extraParams = new TreeMap();
        if (mmrequest == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        mmrequest.getUrlParams(extraParams);
        MMRequest.insertLocation(extraParams);
        if (s == null) goto _L5; else goto _L4
_L4:
        String as[];
        int k;
        as = s.split("&");
        k = as.length;
_L8:
        if (i >= k) goto _L5; else goto _L6
_L6:
        String as1[] = as[i].split("=");
        if (as1.length >= 2)
        {
            extraParams.put(as1[0], as1[1]);
        }
        break MISSING_BLOCK_LABEL_383;
_L5:
        if (!isFirstLaunch)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean((new StringBuilder("firstLaunch_")).append(goalId).toString(), false);
        editor.commit();
        android.content.pm.PackageInfo packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        long l = packageinfo.getClass().getField("firstInstallTime").getLong(packageinfo);
        final long installTimeUTC = l;
_L7:
        if (installTimeUTC <= 0L)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTimeInMillis(installTimeUTC);
        gregoriancalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        installTimeUTC = gregoriancalendar.getTimeInMillis();
        if (!MMSDK.isConnected(context))
        {
            break MISSING_BLOCK_LABEL_375;
        }
        extraParams.put("ua", (new StringBuilder("Android:")).append(Build.MODEL).toString());
        extraParams.put("apid", HandShake.apid);
        MMSDK.insertUrlCommonValues(context, extraParams);
        Utils.ThreadUtils.execute(new _cls1());
          goto _L2
        Exception exception;
        exception;
        throw exception;
        Exception exception1;
        exception1;
        installTimeUTC = 0L;
          goto _L7
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        installTimeUTC = 0L;
          goto _L7
        MMSDK.Log.w("No network available for conversion tracking.");
          goto _L2
        i++;
          goto _L8
    }

    private class _cls1
        implements Runnable
    {

        final TreeMap val$extraParams;
        final String val$goalId;
        final long val$installTimeUTC;
        final boolean val$isFirstLaunch;

        public final void run()
        {
            HttpGetRequest httpgetrequest = new HttpGetRequest();
            try
            {
                httpgetrequest.trackConversion(goalId, isFirstLaunch, installTimeUTC, extraParams);
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        _cls1()
        {
            goalId = s;
            isFirstLaunch = flag;
            installTimeUTC = l;
            extraParams = treemap;
            super();
        }
    }

}
