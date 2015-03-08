// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

class FlowMonitor
{

    static final String HITS_DISPATCHED = "hitsDispatched";
    static final String HITS_DISPATCHED_PARAM = "_s";
    static final String HITS_GENERATED = "hitsGenerated";
    static final String HITS_GENERATED_PARAM = "_g";
    static final String HITS_PAST_PROXY = "hitsPastProxy";
    static final String HITS_PAST_PROXY_PARAM = "_p";
    static final String HITS_STORED_IN_DB = "hitsStoredInDb";
    static final String HITS_STORED_IN_DB_PARAM = "_d";
    private static final int HIT_INTERVAL = 50;
    static final String LAST_QUERY_TIMESTAMP = "lastQueryTimestamp";
    static final String LAST_QUERY_TIMESTAMP_PARAM = "_ts";
    static final String MONITOR_TYPE = "flow";
    static final String MONITOR_TYPE_PARAM = "_t";
    static final String PREFERENCES_LABEL = "GoogleAnalytics";
    private static final long TIME_INTERVAL = 0xdbba00L;
    private static FlowMonitor sInstance;
    android.content.SharedPreferences.Editor mEditor;
    private int mHitsDispatched;
    private int mHitsGenerated;
    private int mHitsPastProxy;
    private int mHitsStoredInDb;
    private long mLastQueryTimeStamp;
    SharedPreferences mPersistentStore;

    FlowMonitor(Context context)
    {
        mPersistentStore = context.getSharedPreferences("GoogleAnalytics", 0);
        mEditor = mPersistentStore.edit();
        mHitsGenerated = mPersistentStore.getInt("hitsGenerated", 0);
        mHitsPastProxy = mPersistentStore.getInt("hitsPastProxy", 0);
        mHitsStoredInDb = mPersistentStore.getInt("hitsStoredInDb", 0);
        mHitsDispatched = mPersistentStore.getInt("hitsDispatched", 0);
        mLastQueryTimeStamp = mPersistentStore.getLong("lastQueryTimestamp", 0L);
        if (mLastQueryTimeStamp == 0L)
        {
            mLastQueryTimeStamp = System.currentTimeMillis();
            mEditor.putLong("lastQueryTimestamp", mLastQueryTimeStamp);
            mEditor.commit();
        }
    }

    public static FlowMonitor getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new FlowMonitor(context);
        }
        return sInstance;
    }

    public String buildAndResetHitsDispatched()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("_s=").append(mHitsDispatched);
        mHitsDispatched = 0;
        mEditor.putInt("hitsDispatched", mHitsDispatched);
        mEditor.commit();
        return stringbuilder.toString();
    }

    public Map generateHit()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("_t", "flow");
        hashmap.put("_ts", String.valueOf(mLastQueryTimeStamp));
        mLastQueryTimeStamp = System.currentTimeMillis();
        mEditor.putLong("lastQueryTimestamp", mLastQueryTimeStamp);
        hashmap.put("_g", getAndResetHitsGeneratedParameter());
        return hashmap;
    }

    String getAndResetHitsGeneratedParameter()
    {
        String s = String.valueOf(mHitsGenerated);
        mHitsGenerated = 0;
        mEditor.putInt("hitsGenerated", 0);
        mEditor.commit();
        return s;
    }

    public String getAndResetHitsPastProxy()
    {
        String s = String.valueOf(mHitsPastProxy);
        mHitsPastProxy = 0;
        mEditor.putInt("hitsPastProxy", mHitsPastProxy);
        mEditor.commit();
        return s;
    }

    public String getAndResetHitsStoredInDb()
    {
        String s = String.valueOf(mHitsStoredInDb);
        mHitsStoredInDb = 0;
        mEditor.putInt("hitsStoredInDb", mHitsStoredInDb);
        mEditor.commit();
        return s;
    }

    public void incrementHitsDispatched(int i)
    {
        mHitsDispatched = i + mHitsDispatched;
        mEditor.putInt("hitsDispatched", i);
        mEditor.commit();
    }

    public void incrementHitsGenerated(int i)
    {
        mHitsGenerated = i + mHitsGenerated;
        mEditor.putInt("hitsGenerated", i);
        mEditor.commit();
    }

    public void incrementHitsPastProxy(int i)
    {
        mHitsPastProxy = i + mHitsPastProxy;
        mEditor.putInt("hitsPastProxy", i);
        mEditor.commit();
    }

    public void incrementHitsStoredInDb(int i)
    {
        mHitsStoredInDb = i + mHitsStoredInDb;
        mEditor.putInt("hitsStoredInDb", i);
        mEditor.commit();
    }

    public boolean shouldReport()
    {
        return mHitsGenerated >= 50 && System.currentTimeMillis() - mLastQueryTimeStamp >= 0xdbba00L;
    }
}
