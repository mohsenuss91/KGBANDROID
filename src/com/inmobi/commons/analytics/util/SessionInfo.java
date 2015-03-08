// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.GregorianCalendar;
import java.util.UUID;

public class SessionInfo
{

    private static String a;
    private static long b;
    private static String c;
    private static int d;

    public SessionInfo()
    {
    }

    public static String getAppId(Context context)
    {
        if (c != null)
        {
            return c;
        } else
        {
            String s = context.getSharedPreferences("inmobiAppAnalyticsAppId", 0).getString("APP_ID", null);
            c = s;
            return s;
        }
    }

    public static int getFirstTime()
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        int i = d;
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getSessionId(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        if (a == null) goto _L2; else goto _L1
_L1:
        String s = a;
_L4:
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).getString("SESSION_ID", null);
        a = s;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static long getSessionTime(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        if (b == 0L) goto _L2; else goto _L1
_L1:
        long l = b;
_L4:
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return l;
_L2:
        l = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).getLong("SESSION_TIME", 0L);
        b = l;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isUpdatedFromOldSDK(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        boolean flag = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).getBoolean("UPDATED_FROM_OLD_SDK", false);
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static void removeSessionId(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        a = null;
        b = 0L;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
        editor.putString("SESSION_ID", null);
        editor.putString("SESSION_TIME", null);
        editor.commit();
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void resetFirstTime()
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        d = 0;
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void storeAppId(Context context, String s)
    {
        c = s;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("inmobiAppAnalyticsAppId", 0).edit();
        editor.putString("APP_ID", s);
        editor.commit();
    }

    public static void storeFirstTime(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor;
        long l;
        SharedPreferences sharedpreferences = context.getSharedPreferences("inmobiAppAnalyticsSession", 0);
        editor = sharedpreferences.edit();
        l = sharedpreferences.getLong("SESSION_TIMEM", -1L);
        if (l == -1L) goto _L2; else goto _L1
_L1:
        GregorianCalendar gregoriancalendar;
        GregorianCalendar gregoriancalendar1;
        long l1;
        int i;
        int j;
        gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTimeInMillis(l);
        gregoriancalendar.setFirstDayOfWeek(2);
        gregoriancalendar1 = new GregorianCalendar();
        l1 = gregoriancalendar1.getTimeInMillis();
        gregoriancalendar1.setFirstDayOfWeek(2);
        i = gregoriancalendar.get(6);
        j = gregoriancalendar1.get(6);
        int k;
        k = 0;
        if (i != j)
        {
            k = 1;
        }
        if (gregoriancalendar.get(3) != gregoriancalendar1.get(3))
        {
            k |= 2;
        }
        Exception exception;
        int i1;
        long l2;
        long l3;
        if (gregoriancalendar.get(2) != gregoriancalendar1.get(2))
        {
            k |= 4;
        }
        i1 = k;
        l2 = l1;
          goto _L3
_L5:
        editor.putLong("SESSION_TIMEM", l2);
        editor.commit();
        d = i1;
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
_L2:
        l3 = (new GregorianCalendar()).getTimeInMillis();
        l2 = l3;
        i1 = 15;
        continue; /* Loop/switch isn't completed */
        exception;
        throw exception;
_L3:
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void storeSessionId(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        a = UUID.randomUUID().toString();
        b = System.currentTimeMillis() / 1000L;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
        editor.putString("SESSION_ID", a);
        editor.putLong("SESSION_TIME", b);
        editor.commit();
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void updatedFromOldSDK(Context context)
    {
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
        editor.putBoolean("UPDATED_FROM_OLD_SDK", true);
        editor.commit();
        com/inmobi/commons/analytics/util/SessionInfo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
