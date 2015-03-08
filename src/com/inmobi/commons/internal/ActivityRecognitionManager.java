// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Referenced classes of package com.inmobi.commons.internal:
//            Log, InternalSDKUtil

public class ActivityRecognitionManager extends IntentService
{

    static Object a = null;
    static Object b = null;
    static int c = -1;
    private static Object d = null;
    private static Object e = null;

    public ActivityRecognitionManager()
    {
        super("InMobi activity service");
    }

    private static void a(Context context)
    {
        if (a == null)
        {
            return;
        }
        Class class1;
        Class class2;
        Class aclass[];
        int i;
        class1 = Class.forName("com.google.android.gms.common.GooglePlayServicesClient");
        class2 = Class.forName("com.google.android.gms.location.ActivityRecognitionClient");
        if (b != null)
        {
            class1.getMethod("disconnect", null).invoke(b, null);
        }
        aclass = class1.getDeclaredClasses();
        i = aclass.length;
        int j;
        Class class3;
        Class class4;
        j = 0;
        class3 = null;
        class4 = null;
_L2:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        Class class5;
        class5 = aclass[j];
        if (class5.getSimpleName().equalsIgnoreCase("ConnectionCallbacks"))
        {
            Class aclass1[] = {
                class5
            };
            d = Proxy.newProxyInstance(class5.getClassLoader(), aclass1, new b(null));
            break MISSING_BLOCK_LABEL_282;
        }
        if (!class5.getSimpleName().equalsIgnoreCase("OnConnectionFailedListener"))
        {
            break MISSING_BLOCK_LABEL_275;
        }
        Class aclass2[] = {
            class5
        };
        e = Proxy.newProxyInstance(class5.getClassLoader(), aclass2, new b(null));
        class4 = class5;
        class5 = class3;
        break MISSING_BLOCK_LABEL_282;
        try
        {
            Constructor constructor = class2.getDeclaredConstructor(new Class[] {
                android/content/Context, class3, class4
            });
            Object aobj[] = new Object[3];
            aobj[0] = context;
            aobj[1] = d;
            aobj[2] = e;
            b = constructor.newInstance(aobj);
            class1.getMethod("connect", null).invoke(b, null);
            return;
        }
        catch (ClassCastException classcastexception)
        {
            Log.internal("[InMobi]-4.4.1", "Init: Google play services not included. Cannot get current activity.");
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Init: Something went wrong during ActivityRecognitionManager.init", exception);
        }
        return;
        class5 = class3;
        j++;
        class3 = class5;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(Intent intent)
    {
        try
        {
            Class class1 = Class.forName("com.google.android.gms.location.ActivityRecognitionResult");
            if (((Boolean)class1.getMethod("hasResult", new Class[] {
    android/content/Intent
}).invoke(null, new Object[] {
    intent
})).booleanValue())
            {
                Object obj = class1.getMethod("extractResult", new Class[] {
                    android/content/Intent
                }).invoke(null, new Object[] {
                    intent
                });
                a = class1.getMethod("getMostProbableActivity", null).invoke(obj, null);
            }
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.internal("[InMobi]-4.4.1", "HandleIntent: Google play services not included. Cannot get current activity.");
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "HandleIntent: Google play services not included. Cannot get current activity.");
        }
    }

    private static boolean a()
    {
        if (android.os.Build.VERSION.SDK_INT >= 8) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (c != -1)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        Class class1 = Class.forName("com.google.android.gms.location.DetectedActivity");
        Class aclass[] = new Class[2];
        aclass[0] = Integer.TYPE;
        aclass[1] = Integer.TYPE;
        Constructor constructor = class1.getConstructor(aclass);
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(-1);
        aobj[1] = Integer.valueOf(100);
        a = constructor.newInstance(aobj);
        c = 1;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext()) == 0)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        c = 0;
        return false;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        Log.debug("[InMobi]-4.4.1", "Google play services not included.");
        c = 0;
_L3:
        if (c == 1)
        {
            return true;
        }
          goto _L1
        Exception exception;
        exception;
        Log.debug("[InMobi]-4.4.1", "Google play services not included.");
        c = 0;
          goto _L3
    }

    public static int getDetectedActivity()
    {
        if (a == null)
        {
            return -1;
        }
        int i;
        try
        {
            i = ((Integer)Class.forName("com.google.android.gms.location.DetectedActivity").getMethod("getType", null).invoke(a, null)).intValue();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.internal("[InMobi]-4.4.1", "getDetectedActivity: Google play services not included. Returning null.");
            return -1;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "getDetectedActivity: Google play services not included. Returning null.");
            return -1;
        }
        return i;
    }

    public static void init(Context context)
    {
        if (a())
        {
            a(context);
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        if (a())
        {
            a(intent);
        }
    }


    private class b
        implements InvocationHandler
    {

        public void a(Bundle bundle)
        {
            PendingIntent pendingintent;
            int i;
            Intent intent = new Intent(InternalSDKUtil.getContext().getApplicationContext(), com/inmobi/commons/internal/ActivityRecognitionManager);
            pendingintent = PendingIntent.getService(InternalSDKUtil.getContext().getApplicationContext(), 0, intent, 0x8000000);
            i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(InternalSDKUtil.getContext());
            if (i == 0)
            {
                try
                {
                    Method method = Class.forName("com.google.android.gms.location.ActivityRecognitionClient").getMethod("requestActivityUpdates", new Class[] {
                        java/lang/Integer, android/app/PendingIntent
                    });
                    Object obj = ActivityRecognitionManager.b;
                    Object aobj[] = new Object[2];
                    aobj[0] = Integer.valueOf(1000);
                    aobj[1] = pendingintent;
                    method.invoke(obj, aobj);
                    return;
                }
                catch (Exception exception1) { }
                try
                {
                    Log.internal("[InMobi]-4.4.1", "Unable to request activity updates from ActivityRecognition client");
                    Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", null).invoke(ActivityRecognitionManager.b, null);
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-4.4.1", "Unable to request activity updates from ActivityRecognition client");
                }
                return;
            }
            Class.forName("com.google.android.gms.common.GooglePlayServicesClient").getMethod("disconnect", null).invoke(ActivityRecognitionManager.b, null);
            return;
        }

        public Object invoke(Object obj, Method method, Object aobj[])
        {
            if (aobj != null)
            {
                try
                {
                    if (method.getName().equals("onConnected"))
                    {
                        a((Bundle)aobj[0]);
                    }
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-4.4.1", "Unable to invoke method", exception);
                }
            }
            return null;
        }

        private b()
        {
        }

        b(a a1)
        {
            this();
        }
    }

}
