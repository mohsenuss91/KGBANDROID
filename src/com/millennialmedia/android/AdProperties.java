// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            MMSDK, BridgeMMDevice

class AdProperties
{

    WeakReference contextRef;

    AdProperties(Context context)
    {
        contextRef = new WeakReference(context);
    }

    private JSONObject getAd()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("height", getAdDpiIndependentHeight());
        jsonobject.put("width", getAdDpiIndependentWidth());
        return jsonobject;
    }

    private JSONObject getPermissions()
    {
        JSONObject jsonobject = new JSONObject();
        boolean flag;
        if (getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        jsonobject.put("android.permission.ACCESS_FINE_LOCATION", flag);
        return jsonobject;
    }

    private JSONObject getScreen()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("height", getScreenDpiIndependentHeight());
        jsonobject.put("width", getScreenDpiIndependentWidth());
        return jsonobject;
    }

    private JSONObject getSupports()
    {
        JSONObject jsonobject = new JSONObject();
        Context context = getContext();
        jsonobject.put("sms", MMSDK.getSupportsSms(context));
        jsonobject.put("tel", MMSDK.getSupportsTel(context));
        jsonobject.put("calendar", "false");
        jsonobject.put("storePicture", "false");
        jsonobject.put("inlineVideo", "true");
        return jsonobject;
    }

    String getAdDpiIndependentHeight()
    {
        return getScreenDpiIndependentHeight();
    }

    String getAdDpiIndependentWidth()
    {
        return getScreenDpiIndependentWidth();
    }

    public JSONObject getAdProperties()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("screen", getScreen());
            jsonobject.put("ad", getAd());
            jsonobject.put("do", MMSDK.getOrientation(getContext()));
            jsonobject.put("supports", getSupports());
            jsonobject.put("device", BridgeMMDevice.getDeviceInfo(getContext()));
            jsonobject.put("permissions", getPermissions());
            jsonobject.put("maxSize", getScreen());
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    Context getContext()
    {
        return (Context)contextRef.get();
    }

    String getScreenDpiIndependentHeight()
    {
        DisplayMetrics displaymetrics = MMSDK.getMetrics(getContext());
        return String.valueOf((int)((float)displaymetrics.heightPixels / displaymetrics.density));
    }

    String getScreenDpiIndependentWidth()
    {
        DisplayMetrics displaymetrics = MMSDK.getMetrics(getContext());
        return String.valueOf((int)((float)displaymetrics.widthPixels / displaymetrics.density));
    }
}
