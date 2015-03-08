// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.analytics;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public class InMobiAnalytics
{

    public InMobiAnalytics()
    {
    }

    public static void beginSection(String s)
    {
        beginSection(s, null);
    }

    public static void beginSection(String s, Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            int i = s.hashCode();
            AnalyticsEventsWrapper.getInstance().beginSection(i, s, map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Analytics]-4.4.1", "Please pass a valid Section Name");
        }
    }

    public static void endSection(String s)
    {
        endSection(s, null);
    }

    public static void endSection(String s, Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            int i = s.hashCode();
            AnalyticsEventsWrapper.getInstance().endSection(i, s, map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Analytics]-4.4.1", "Please pass a valid Section Name");
        }
    }

    public static void endSessionManually()
    {
        endSessionManually(null);
    }

    public static void endSessionManually(Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        } else
        {
            AnalyticsEventsWrapper.getInstance().endSession(map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
    }

    public static void reportCustomGoal(String s)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            IMAdTracker.getInstance().reportCustomGoal(s);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Unable to report custom goal due to unexpected exception.", exception);
        }
    }

    public static void startSessionManually()
    {
        startSessionManually(null);
    }

    public static void startSessionManually(Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        } else
        {
            AnalyticsEventsWrapper.getInstance().startSession(InMobi.getAppId(), map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
    }

    public static void tagEvent(String s)
    {
        tagEvent(s, null);
    }

    public static void tagEvent(String s, Map map)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            AnalyticsEventsWrapper.getInstance().tagEvent(s, map);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Unable to tag event due to unexpected exception.", exception);
        }
    }

    public static void tagTransactionManually(Intent intent, Bundle bundle)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        try
        {
            AnalyticsEventsWrapper.getInstance().tagTransactionManually(intent, bundle);
            AnalyticsEventsWrapper.setIsEventsUser();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Unable to tag transaction due to unexpected exception.", exception);
        }
    }
}
