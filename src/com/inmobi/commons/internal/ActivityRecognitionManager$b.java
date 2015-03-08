// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.internal:
//            InternalSDKUtil, ActivityRecognitionManager, Log

class <init>
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

    private ()
    {
    }

    ( )
    {
        this();
    }
}
