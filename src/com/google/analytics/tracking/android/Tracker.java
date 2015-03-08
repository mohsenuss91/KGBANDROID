// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            ClientIdDefaultProvider, ScreenResolutionDefaultProvider, AppFieldsDefaultProvider, SendHitRateLimiter, 
//            GAUsage, Utils, Log, RateLimiter, 
//            TrackerHandler

public class Tracker
{

    private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
    private final ClientIdDefaultProvider mClientIdDefaultProvider;
    private final TrackerHandler mHandler;
    private final String mName;
    private final Map mParams;
    private RateLimiter mRateLimiter;
    private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;

    Tracker(String s, String s1, TrackerHandler trackerhandler)
    {
        this(s, s1, trackerhandler, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider(), ((RateLimiter) (new SendHitRateLimiter())));
    }

    Tracker(String s, String s1, TrackerHandler trackerhandler, ClientIdDefaultProvider clientiddefaultprovider, ScreenResolutionDefaultProvider screenresolutiondefaultprovider, AppFieldsDefaultProvider appfieldsdefaultprovider, RateLimiter ratelimiter)
    {
        mParams = new HashMap();
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        } else
        {
            mName = s;
            mHandler = trackerhandler;
            mParams.put("&tid", s1);
            mParams.put("useSecure", "1");
            mClientIdDefaultProvider = clientiddefaultprovider;
            mScreenResolutionDefaultProvider = screenresolutiondefaultprovider;
            mAppFieldsDefaultProvider = appfieldsdefaultprovider;
            mRateLimiter = ratelimiter;
            return;
        }
    }

    public String get(String s)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET);
        if (!TextUtils.isEmpty(s))
        {
            if (mParams.containsKey(s))
            {
                return (String)mParams.get(s);
            }
            if (s.equals("&ul"))
            {
                return Utils.getLanguage(Locale.getDefault());
            }
            if (mClientIdDefaultProvider != null && mClientIdDefaultProvider.providesField(s))
            {
                return mClientIdDefaultProvider.getValue(s);
            }
            if (mScreenResolutionDefaultProvider != null && mScreenResolutionDefaultProvider.providesField(s))
            {
                return mScreenResolutionDefaultProvider.getValue(s);
            }
            if (mAppFieldsDefaultProvider != null && mAppFieldsDefaultProvider.providesField(s))
            {
                return mAppFieldsDefaultProvider.getValue(s);
            }
        }
        return null;
    }

    public String getName()
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER_NAME);
        return mName;
    }

    RateLimiter getRateLimiter()
    {
        return mRateLimiter;
    }

    public void send(Map map)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
        HashMap hashmap = new HashMap();
        hashmap.putAll(mParams);
        if (map != null)
        {
            hashmap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("&tid")))
        {
            Log.w(String.format("Missing tracking id (%s) parameter.", new Object[] {
                "&tid"
            }));
        }
        String s = (String)hashmap.get("&t");
        if (TextUtils.isEmpty(s))
        {
            Log.w(String.format("Missing hit type (%s) parameter.", new Object[] {
                "&t"
            }));
            s = "";
        }
        if (!s.equals("transaction") && !s.equals("item") && !mRateLimiter.tokenAvailable())
        {
            Log.w("Too many hits sent too quickly, rate limiting invoked.");
            return;
        } else
        {
            mHandler.sendHit(hashmap);
            return;
        }
    }

    public void set(String s, String s1)
    {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET);
        if (s1 == null)
        {
            mParams.remove(s);
            return;
        } else
        {
            mParams.put(s, s1);
            return;
        }
    }
}
