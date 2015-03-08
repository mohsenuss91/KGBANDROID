// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class AdViewController
{

    static final int DEFAULT_REFRESH_TIME_MILLISECONDS = 60000;
    static final int MINIMUM_REFRESH_TIME_MILLISECONDS = 10000;
    private static WeakHashMap sViewShouldHonorServerDimensions = new WeakHashMap();
    private boolean mAutoRefreshEnabled;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsDestroyed;
    private boolean mIsFacebookSupported;
    private boolean mIsLoading;
    private boolean mIsTesting;
    private String mKeywords;
    private Map mLocalExtras;
    private Location mLocation;
    private Runnable mRefreshRunnable;
    private String mUrl;

    public AdViewController()
    {
        mLocalExtras = new HashMap();
        mAutoRefreshEnabled = true;
        mIsFacebookSupported = true;
    }

    private void cancelRefreshTimer()
    {
        mHandler.removeCallbacks(mRefreshRunnable);
    }

    private boolean isNetworkAvailable()
    {
        if (mContext.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            return true;
        }
        NetworkInfo networkinfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    protected static void setShouldHonorServerDimensions(View view)
    {
        sViewShouldHonorServerDimensions.put(view, Boolean.valueOf(true));
    }

    void cleanup()
    {
        if (mIsDestroyed)
        {
            return;
        } else
        {
            setAutorefreshEnabled(false);
            cancelRefreshTimer();
            mIsDestroyed = true;
            return;
        }
    }

    public void customEventActionWillBegin()
    {
        registerClick();
    }

    public void customEventDidLoadAd()
    {
        setNotLoading();
        trackImpression();
        scheduleRefreshTimerIfEnabled();
    }

    void fetchAd(String s)
    {
    }

    void forceRefresh()
    {
        setNotLoading();
        loadAd();
    }

    public boolean getAutorefreshEnabled()
    {
        return mAutoRefreshEnabled;
    }

    public String getKeywords()
    {
        return mKeywords;
    }

    Map getLocalExtras()
    {
        if (mLocalExtras != null)
        {
            return new HashMap(mLocalExtras);
        } else
        {
            return new HashMap();
        }
    }

    public Location getLocation()
    {
        return mLocation;
    }

    public boolean getTesting()
    {
        return mIsTesting;
    }

    boolean isDestroyed()
    {
        return mIsDestroyed;
    }

    public boolean isFacebookSupported()
    {
        return mIsFacebookSupported;
    }

    public void loadAd()
    {
        if (!isNetworkAvailable())
        {
            Log.d("MoPub", "Can't load an ad because there is no network connectivity.");
            scheduleRefreshTimerIfEnabled();
        }
    }

    void loadNonJavascript(String s)
    {
        if (s != null)
        {
            Log.d("MoPub", (new StringBuilder("Loading url: ")).append(s).toString());
            if (!mIsLoading)
            {
                mUrl = s;
                mIsLoading = true;
                fetchAd(mUrl);
                return;
            }
        }
    }

    void registerClick()
    {
    }

    public void reload()
    {
        Log.d("MoPub", (new StringBuilder("Reload ad: ")).append(mUrl).toString());
        loadNonJavascript(mUrl);
    }

    void scheduleRefreshTimerIfEnabled()
    {
    }

    public void setAutorefreshEnabled(boolean flag)
    {
        mAutoRefreshEnabled = flag;
        if (mAutoRefreshEnabled)
        {
            scheduleRefreshTimerIfEnabled();
            return;
        } else
        {
            cancelRefreshTimer();
            return;
        }
    }

    public void setFacebookSupported(boolean flag)
    {
        mIsFacebookSupported = flag;
    }

    void setFailUrl(String s)
    {
    }

    public void setKeywords(String s)
    {
        mKeywords = s;
    }

    void setLocalExtras(Map map)
    {
        HashMap hashmap;
        if (map != null)
        {
            hashmap = new HashMap(map);
        } else
        {
            hashmap = new HashMap();
        }
        mLocalExtras = hashmap;
    }

    public void setLocation(Location location)
    {
        mLocation = location;
    }

    void setNotLoading()
    {
        mIsLoading = false;
    }

    public void setTesting(boolean flag)
    {
        mIsTesting = flag;
    }

    public void setTimeout(int i)
    {
    }

    void trackImpression()
    {
    }

}
