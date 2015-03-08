// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

// Referenced classes of package com.google.analytics.tracking.android:
//            DefaultProvider

class ScreenResolutionDefaultProvider
    implements DefaultProvider
{

    private static ScreenResolutionDefaultProvider sInstance;
    private static Object sInstanceLock = new Object();
    private final Context mContext;

    protected ScreenResolutionDefaultProvider(Context context)
    {
        mContext = context;
    }

    static void dropInstance()
    {
        synchronized (sInstanceLock)
        {
            sInstance = null;
        }
    }

    public static ScreenResolutionDefaultProvider getProvider()
    {
        ScreenResolutionDefaultProvider screenresolutiondefaultprovider;
        synchronized (sInstanceLock)
        {
            screenresolutiondefaultprovider = sInstance;
        }
        return screenresolutiondefaultprovider;
    }

    public static void initializeProvider(Context context)
    {
        synchronized (sInstanceLock)
        {
            if (sInstance == null)
            {
                sInstance = new ScreenResolutionDefaultProvider(context);
            }
        }
    }

    protected String getScreenResolutionString()
    {
        DisplayMetrics displaymetrics = mContext.getResources().getDisplayMetrics();
        return (new StringBuilder()).append(displaymetrics.widthPixels).append("x").append(displaymetrics.heightPixels).toString();
    }

    public String getValue(String s)
    {
        while (s == null || !s.equals("&sr")) 
        {
            return null;
        }
        return getScreenResolutionString();
    }

    public boolean providesField(String s)
    {
        return "&sr".equals(s);
    }

}
