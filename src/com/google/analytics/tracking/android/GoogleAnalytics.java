// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            TrackerHandler, GAThread, AppFieldsDefaultProvider, ScreenResolutionDefaultProvider, 
//            ClientIdDefaultProvider, DefaultLoggerImpl, GAUsage, Tracker, 
//            Utils, AnalyticsThread, Logger

public class GoogleAnalytics extends TrackerHandler
{

    private static GoogleAnalytics sInstance;
    private volatile Boolean mAppOptOut;
    private Context mContext;
    private Tracker mDefaultTracker;
    private boolean mDryRun;
    private Logger mLogger;
    private AnalyticsThread mThread;
    private final Map mTrackers;

    protected GoogleAnalytics(Context context)
    {
        this(context, ((AnalyticsThread) (GAThread.getInstance(context))));
    }

    private GoogleAnalytics(Context context, AnalyticsThread analyticsthread)
    {
        mAppOptOut = Boolean.valueOf(false);
        mTrackers = new HashMap();
        if (context == null)
        {
            throw new IllegalArgumentException("context cannot be null");
        } else
        {
            mContext = context.getApplicationContext();
            mThread = analyticsthread;
            AppFieldsDefaultProvider.initializeProvider(mContext);
            ScreenResolutionDefaultProvider.initializeProvider(mContext);
            ClientIdDefaultProvider.initializeProvider(mContext);
            mLogger = new DefaultLoggerImpl();
            return;
        }
    }

    static void clearDefaultProviders()
    {
        AppFieldsDefaultProvider.dropInstance();
        ScreenResolutionDefaultProvider.dropInstance();
        ClientIdDefaultProvider.dropInstance();
    }

    static void clearInstance()
    {
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorenter ;
        sInstance = null;
        clearDefaultProviders();
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static GoogleAnalytics getInstance()
    {
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorenter ;
        GoogleAnalytics googleanalytics = sInstance;
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorexit ;
        return googleanalytics;
        Exception exception;
        exception;
        throw exception;
    }

    public static GoogleAnalytics getInstance(Context context)
    {
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorenter ;
        GoogleAnalytics googleanalytics;
        if (sInstance == null)
        {
            sInstance = new GoogleAnalytics(context);
        }
        googleanalytics = sInstance;
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorexit ;
        return googleanalytics;
        Exception exception;
        exception;
        throw exception;
    }

    static GoogleAnalytics getNewInstance(Context context, AnalyticsThread analyticsthread)
    {
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorenter ;
        GoogleAnalytics googleanalytics;
        if (sInstance != null)
        {
            sInstance.close();
        }
        googleanalytics = new GoogleAnalytics(context, analyticsthread);
        sInstance = googleanalytics;
        com/google/analytics/tracking/android/GoogleAnalytics;
        JVM INSTR monitorexit ;
        return googleanalytics;
        Exception exception;
        exception;
        throw exception;
    }

    void close()
    {
    }

    public void closeTracker(String s)
    {
        this;
        JVM INSTR monitorenter ;
        GAUsage.getInstance().setUsage(GAUsage.Field.CLOSE_TRACKER);
        if ((Tracker)mTrackers.remove(s) == mDefaultTracker)
        {
            mDefaultTracker = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getAppOptOut()
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_OPT_OUT);
        return mAppOptOut.booleanValue();
    }

    public Tracker getDefaultTracker()
    {
        this;
        JVM INSTR monitorenter ;
        Tracker tracker;
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_DEFAULT_TRACKER);
        tracker = mDefaultTracker;
        this;
        JVM INSTR monitorexit ;
        return tracker;
        Exception exception;
        exception;
        throw exception;
    }

    public Logger getLogger()
    {
        return mLogger;
    }

    public Tracker getTracker(String s)
    {
        return getTracker(s, s);
    }

    public Tracker getTracker(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Tracker name cannot be empty");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Tracker tracker = (Tracker)mTrackers.get(s);
        if (tracker != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        tracker = new Tracker(s, s1, this);
        mTrackers.put(s, tracker);
        if (mDefaultTracker == null)
        {
            mDefaultTracker = tracker;
        }
        if (!TextUtils.isEmpty(s1))
        {
            tracker.set("&tid", s1);
        }
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER);
        this;
        JVM INSTR monitorexit ;
        return tracker;
    }

    public boolean isDryRunEnabled()
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_DRY_RUN);
        return mDryRun;
    }

    void sendHit(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("hit cannot be null");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Utils.putIfAbsent(map, "&ul", Utils.getLanguage(Locale.getDefault()));
        Utils.putIfAbsent(map, "&sr", ScreenResolutionDefaultProvider.getProvider().getValue("&sr"));
        map.put("&_u", GAUsage.getInstance().getAndClearSequence());
        GAUsage.getInstance().getAndClearUsage();
        mThread.sendHit(map);
        this;
        JVM INSTR monitorexit ;
    }

    public void setAppOptOut(boolean flag)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_OPT_OUT);
        mAppOptOut = Boolean.valueOf(flag);
        if (mAppOptOut.booleanValue())
        {
            mThread.clearHits();
        }
    }

    public void setDefaultTracker(Tracker tracker)
    {
        this;
        JVM INSTR monitorenter ;
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_DEFAULT_TRACKER);
        mDefaultTracker = tracker;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setDryRun(boolean flag)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_DRY_RUN);
        mDryRun = flag;
    }

    public void setLogger(Logger logger)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_LOGGER);
        mLogger = logger;
    }
}
