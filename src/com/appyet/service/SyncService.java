// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.ProgressNotificationManager;
import com.appyet.manager.bq;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SyncService extends Service
{

    private static final Class b[];
    private static final Class c[];
    private static final Class d[];
    private ApplicationContext a;
    private Method e;
    private Method f;
    private Method g;
    private Object h[];
    private Object i[];
    private Object j[];
    private ProgressNotificationManager k;

    public SyncService()
    {
        h = new Object[1];
        i = new Object[2];
        j = new Object[1];
    }

    private void a(Method method, Object aobj[])
    {
        try
        {
            method.invoke(this, aobj);
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Log.w("ApiDemos", "Unable to invoke method", invocationtargetexception);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.w("ApiDemos", "Unable to invoke method", illegalaccessexception);
        }
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        a = (ApplicationContext)getApplicationContext();
        k = a.t.d();
        ProgressNotificationManager progressnotificationmanager;
        try
        {
            f = getClass().getMethod("startForeground", c);
            g = getClass().getMethod("stopForeground", d);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            g = null;
            f = null;
        }
        try
        {
            if (f == null || g == null)
            {
                e = getClass().getMethod("setForeground", b);
            }
        }
        catch (NoSuchMethodException nosuchmethodexception1)
        {
            e = null;
        }
        progressnotificationmanager = k;
        if (f == null || progressnotificationmanager == null) goto _L2; else goto _L1
_L1:
        i[0] = Integer.valueOf(progressnotificationmanager.b());
        i[1] = progressnotificationmanager;
        a(f, i);
_L4:
        super.onCreate();
        return;
_L2:
        if (e != null)
        {
            h[0] = Boolean.TRUE;
            a(e, h);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDestroy()
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        j[0] = Boolean.TRUE;
        a(g, j);
_L4:
        stopSelf();
        return;
_L2:
        if (e != null)
        {
            h[0] = Boolean.FALSE;
            a(e, h);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        Class aclass[] = new Class[1];
        aclass[0] = Boolean.TYPE;
        b = aclass;
        Class aclass1[] = new Class[2];
        aclass1[0] = Integer.TYPE;
        aclass1[1] = android/app/Notification;
        c = aclass1;
        Class aclass2[] = new Class[1];
        aclass2[0] = Boolean.TYPE;
        d = aclass2;
    }
}
