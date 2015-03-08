// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.http.SslError;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.internal:
//            Log

public class WrapperFunctions
{

    private static int a;

    public WrapperFunctions()
    {
    }

    private static void a(WebView webview, int i)
    {
        try
        {
            Class class1 = webview.getClass();
            Class aclass[] = new Class[2];
            aclass[0] = Integer.TYPE;
            aclass[1] = android/graphics/Paint;
            Method method = class1.getMethod("setLayerType", aclass);
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(i);
            aobj[1] = null;
            method.invoke(webview, aobj);
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot set hardware accl", nosuchmethodexception);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot set hardware accl", illegalargumentexception);
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot set hardware accl", illegalaccessexception);
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot set hardware accl", invocationtargetexception);
        }
    }

    public static void disableHardwareAccl(WebView webview)
    {
        a(webview, 1);
    }

    public static int getCurrentOrientationInFixedValues(Context context)
    {
        switch (context.getResources().getConfiguration().orientation)
        {
        default:
            return 1;

        case 1: // '\001'
            if (android.os.Build.VERSION.SDK_INT < 8)
            {
                return 1;
            }
            int j = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
            return j != 1 && j != 2 ? 1 : 9;

        case 2: // '\002'
            break;
        }
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            return 0;
        }
        int i = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
        return i != 0 && i != 1 ? 8 : 0;
    }

    public static int getDisplayHeight(Display display)
    {
        Class aclass[] = {
            android/graphics/Point
        };
        Method method2 = android/view/Display.getMethod("getSize", aclass);
        Method method;
        boolean flag;
        method = method2;
        flag = true;
_L2:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        NoSuchMethodException nosuchmethodexception;
        NoSuchMethodException nosuchmethodexception1;
        int i;
        int j;
        Method method1;
        try
        {
            Point point = new Point();
            method.invoke(display, new Object[] {
                point
            });
            j = point.y;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get display height", illegalargumentexception);
            return 0;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get display height", illegalaccessexception);
            return 0;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get display height", invocationtargetexception);
            return 0;
        }
        return j;
        nosuchmethodexception;
        method1 = android/view/Display.getMethod("getHeight", null);
        method = method1;
        flag = false;
        continue; /* Loop/switch isn't completed */
        nosuchmethodexception1;
        Log.internal("[InMobi]-4.4.1", "Cannot get display height", nosuchmethodexception1);
        method = null;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        i = ((Integer)method.invoke(display, null)).intValue();
        return i;
    }

    public static int getDisplayWidth(Display display)
    {
        Class aclass[] = {
            android/graphics/Point
        };
        Method method2 = android/view/Display.getMethod("getSize", aclass);
        Method method;
        boolean flag;
        method = method2;
        flag = true;
_L2:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        NoSuchMethodException nosuchmethodexception;
        NoSuchMethodException nosuchmethodexception1;
        int i;
        int j;
        Method method1;
        try
        {
            Point point = new Point();
            method.invoke(display, new Object[] {
                point
            });
            j = point.x;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get display width", illegalargumentexception);
            return 0;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get display width", illegalaccessexception);
            return 0;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get display width", invocationtargetexception);
            return 0;
        }
        return j;
        nosuchmethodexception;
        method1 = android/view/Display.getMethod("getWidth", null);
        method = method1;
        flag = false;
        continue; /* Loop/switch isn't completed */
        nosuchmethodexception1;
        Log.internal("[InMobi]-4.4.1", "Cannot get display width", nosuchmethodexception1);
        method = null;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        i = ((Integer)method.invoke(display, null)).intValue();
        return i;
    }

    public static int getParamConfigScreenSize()
    {
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        int i;
        int j;
        try
        {
            field = android/content/pm/ActivityInfo.getField("CONFIG_SCREEN_SIZE");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get screen size", nosuchfieldexception);
            return 0;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get screen size", exception);
            return 0;
        }
        i = 0;
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        j = field.getInt(activityinfo);
        i = j;
        return i;
    }

    public static int getParamConfigSmallestScreenSize()
    {
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        int i;
        int j;
        try
        {
            field = android/content/pm/ActivityInfo.getField("CONFIG_SMALLEST_SCREEN_SIZE");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get smallest screen size", nosuchfieldexception);
            return 0;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get smallest screen size", exception);
            return 0;
        }
        i = 0;
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        j = field.getInt(activityinfo);
        i = j;
        return i;
    }

    public static int getParamFillParent()
    {
        if (a != 0) goto _L2; else goto _L1
_L1:
        com/inmobi/commons/internal/WrapperFunctions;
        JVM INSTR monitorenter ;
        if (a != 0) goto _L4; else goto _L3
_L3:
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(1, 1);
        Field field2 = android/view/ViewGroup$LayoutParams.getField("MATCH_PARENT");
        Field field = field2;
_L7:
        if (field == null) goto _L4; else goto _L5
_L5:
        a = field.getInt(layoutparams);
_L4:
        com/inmobi/commons/internal/WrapperFunctions;
        JVM INSTR monitorexit ;
_L2:
        return a;
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
        Field field1 = android/view/ViewGroup$LayoutParams.getField("FILL_PARENT");
        field = field1;
        continue; /* Loop/switch isn't completed */
        NoSuchFieldException nosuchfieldexception1;
        nosuchfieldexception1;
        Log.internal("[InMobi]-4.4.1", "Cannot get fill parent param", nosuchfieldexception1);
        field = null;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-4.4.1", "Cannot get fill parent param", exception1);
          goto _L4
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static int getParamLandscapeOrientation(int i)
    {
        int j = 0;
        if (i != 3)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        int k;
        try
        {
            field = android/content/pm/ActivityInfo.getField("SCREEN_ORIENTATION_REVERSE_LANDSCAPE");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get landscape orientation", nosuchfieldexception);
            return 0;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get landscape orientation", exception);
            return 0;
        }
        j = 0;
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        k = field.getInt(activityinfo);
        j = k;
        return j;
    }

    public static int getParamPortraitOrientation(int i)
    {
        int j = 1;
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        int k;
        try
        {
            field = android/content/pm/ActivityInfo.getField("SCREEN_ORIENTATION_REVERSE_PORTRAIT");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get portrait orientation", nosuchfieldexception);
            return j;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get portrait orientation", exception);
            return j;
        }
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        k = field.getInt(activityinfo);
        j = k;
        return j;
    }

    public static String getSSLErrorUrl(SslError sslerror)
    {
        String s;
        try
        {
            s = Class.forName("android.net.http.SslError").getDeclaredMethod("getUrl", new Class[0]).invoke(sslerror, new Object[0]).toString();
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get SSL Url", exception);
            return null;
        }
        return s;
    }

    public static Bitmap getVideoBitmap(String s)
    {
        Bitmap bitmap;
        try
        {
            Class class1 = Class.forName("android.media.ThumbnailUtils");
            Class aclass[] = new Class[2];
            aclass[0] = java/lang/String;
            aclass[1] = Integer.TYPE;
            Method method = class1.getDeclaredMethod("createVideoThumbnail", aclass);
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = Integer.valueOf(1);
            bitmap = (Bitmap)method.invoke(null, aobj);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.4.1", "Cannot get video bitmap", exception);
            throw exception;
        }
        return bitmap;
    }
}
