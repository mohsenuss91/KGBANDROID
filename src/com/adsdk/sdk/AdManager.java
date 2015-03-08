// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Handler;
import com.adsdk.sdk.customevents.CustomEvent;
import com.adsdk.sdk.customevents.CustomEventFullscreen;
import com.adsdk.sdk.customevents.CustomEventFullscreenFactory;
import com.adsdk.sdk.video.ResourceManager;
import com.adsdk.sdk.video.RichMediaActivity;
import com.adsdk.sdk.video.TrackerService;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.adsdk.sdk:
//            Util, AdResponse, Log, AdRequest, 
//            AdListener, Gender

public class AdManager
{

    private static Context mContext;
    private static HashMap sRunningAds = new HashMap();
    private boolean alreadyRequestedInterstitial;
    private boolean alreadyRequestedVideo;
    private String androidAdId;
    private String androidID;
    private String androidIMEI;
    private CustomEventFullscreen customEventFullscreen;
    private com.adsdk.sdk.customevents.CustomEventFullscreen.CustomEventFullscreenListener customFullscreenListener;
    private String interstitialRequestURL;
    private boolean isInterstitialAdsEnabled;
    private boolean isVideoAdsEnabled;
    private List keywords;
    private boolean mEnabled;
    private Handler mHandler;
    private boolean mIncludeLocation;
    private AdListener mListener;
    private String mPublisherId;
    private Thread mRequestThread;
    private AdResponse mResponse;
    private String mUniqueId1;
    private String mUniqueId2;
    private boolean prioritizeVideoAds;
    private AdRequest request;
    private boolean requestedHorizontalAd;
    private int userAge;
    private Gender userGender;
    private int videoMaxDuration;
    private int videoMinimalDuration;

    public AdManager(Context context, String s, String s1, boolean flag)
    {
        androidIMEI = "";
        androidID = "";
        request = null;
        mEnabled = true;
        isInterstitialAdsEnabled = true;
        Util.prepareAndroidAdId(context);
        setmContext(context);
        interstitialRequestURL = s;
        mPublisherId = s1;
        mIncludeLocation = flag;
        mRequestThread = null;
        mHandler = new Handler();
        initialize();
    }

    public static void closeRunningAd(AdResponse adresponse, boolean flag)
    {
        AdManager admanager = (AdManager)sRunningAds.remove(Long.valueOf(adresponse.getTimestamp()));
        if (admanager == null)
        {
            Log.d((new StringBuilder("Cannot find AdManager with running ad:")).append(adresponse.getTimestamp()).toString());
            return;
        } else
        {
            Log.d((new StringBuilder("Notify closing event to AdManager with running ad:")).append(adresponse.getTimestamp()).toString());
            admanager.notifyAdClose(adresponse, flag);
            return;
        }
    }

    private com.adsdk.sdk.customevents.CustomEventFullscreen.CustomEventFullscreenListener createCustomFullscreenListener()
    {
        return new _cls6();
    }

    public static AdManager getAdManager(AdResponse adresponse)
    {
        AdManager admanager = (AdManager)sRunningAds.remove(Long.valueOf(adresponse.getTimestamp()));
        if (admanager == null)
        {
            Log.d((new StringBuilder("Cannot find AdManager with running ad:")).append(adresponse.getTimestamp()).toString());
        }
        return admanager;
    }

    private Context getContext()
    {
        return getmContext();
    }

    private AdRequest getInterstitialRequest()
    {
        if (request == null)
        {
            request = new AdRequest();
            request.setDeviceId(mUniqueId1);
            request.setDeviceId2(mUniqueId2);
            request.setAndroidID(androidID);
            request.setAndroidIMEI(androidIMEI);
            request.setAndroidAdId(androidAdId);
            request.setPublisherId(mPublisherId);
            request.setUserAgent(Util.getDefaultUserAgentString(mContext));
            request.setUserAgent2(Util.buildUserAgent());
        }
        request.setVideoRequest(false);
        request.setGender(userGender);
        request.setUserAge(userAge);
        request.setKeywords(keywords);
        boolean flag = mIncludeLocation;
        Location location = null;
        if (flag)
        {
            location = Util.getLocation(mContext);
        }
        if (location != null)
        {
            Log.d((new StringBuilder("location is longitude: ")).append(location.getLongitude()).append(", latitude: ").append(location.getLatitude()).toString());
            request.setLatitude(location.getLatitude());
            request.setLongitude(location.getLongitude());
        } else
        {
            request.setLatitude(0.0D);
            request.setLongitude(0.0D);
        }
        if (mContext.getResources().getConfiguration().orientation == 2)
        {
            requestedHorizontalAd = true;
            request.setAdspaceHeight(320);
            request.setAdspaceWidth(480);
        } else
        {
            requestedHorizontalAd = false;
            request.setAdspaceHeight(480);
            request.setAdspaceWidth(320);
        }
        request.setAdspaceStrict(false);
        request.setConnectionType(Util.getConnectionType(getContext()));
        request.setIpAddress(Util.getLocalIpAddress());
        request.setTimestamp(System.currentTimeMillis());
        request.setRequestURL(interstitialRequestURL);
        return request;
    }

    private AdRequest getVideoRequest()
    {
        if (request == null)
        {
            request = new AdRequest();
            request.setDeviceId(mUniqueId1);
            request.setDeviceId2(mUniqueId2);
            request.setAndroidID(androidID);
            request.setAndroidIMEI(androidIMEI);
            request.setAndroidAdId(androidAdId);
            request.setPublisherId(mPublisherId);
            request.setUserAgent(Util.getDefaultUserAgentString(mContext));
            request.setUserAgent2(Util.buildUserAgent());
        }
        request.setGender(userGender);
        request.setUserAge(userAge);
        request.setKeywords(keywords);
        request.setVideoRequest(true);
        request.setVideoMaxDuration(videoMaxDuration);
        request.setVideoMinDuration(videoMinimalDuration);
        boolean flag = mIncludeLocation;
        Location location = null;
        if (flag)
        {
            location = Util.getLocation(mContext);
        }
        if (location != null)
        {
            Log.d((new StringBuilder("location is longitude: ")).append(location.getLongitude()).append(", latitude: ").append(location.getLatitude()).toString());
            request.setLatitude(location.getLatitude());
            request.setLongitude(location.getLongitude());
        } else
        {
            request.setLatitude(0.0D);
            request.setLongitude(0.0D);
        }
        request.setAdspaceHeight(480);
        request.setAdspaceWidth(320);
        request.setAdspaceStrict(false);
        request.setConnectionType(Util.getConnectionType(getContext()));
        request.setIpAddress(Util.getLocalIpAddress());
        request.setTimestamp(System.currentTimeMillis());
        request.setRequestURL(interstitialRequestURL);
        return request;
    }

    private static Context getmContext()
    {
        return mContext;
    }

    private void initialize()
    {
        Log.LOGGING_ENABLED = Log.isLoggingEnabled(getmContext());
        Log.d("Ad SDK Version:5.2.0");
        mUniqueId1 = Util.getTelephonyDeviceId(getContext());
        mUniqueId2 = Util.getDeviceId(getContext());
        androidID = Util.getDeviceId(getContext());
        androidIMEI = Util.getTelephonyDeviceId(getContext());
        androidAdId = Util.getAndroidAdId();
        if (mPublisherId == null || mPublisherId.length() == 0)
        {
            Log.e("Publisher Id cannot be null or empty");
            throw new IllegalArgumentException("User Id cannot be null or empty");
        }
        if (mUniqueId2 == null)
        {
            Log.e("Cannot get system device Id");
            throw new IllegalArgumentException("System Device Id cannot be null");
        }
        Log.d((new StringBuilder("AdManager Publisher Id:")).append(mPublisherId).append(" Device Id:").append(mUniqueId1).append(" DeviceId2:").append(mUniqueId2).toString());
        boolean flag;
        if (Util.getMemoryClass(getContext()) > 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mEnabled = flag;
        customFullscreenListener = createCustomFullscreenListener();
    }

    private void loadCustomEventFullscreen()
    {
        customEventFullscreen = null;
        do
        {
            if (mResponse.getCustomEvents().isEmpty() || customEventFullscreen != null)
            {
                return;
            }
            try
            {
                final CustomEvent event = (CustomEvent)mResponse.getCustomEvents().get(0);
                mResponse.getCustomEvents().remove(event);
                customEventFullscreen = CustomEventFullscreenFactory.create(event.getClassName());
                mHandler.post(new _cls5());
            }
            catch (Exception exception)
            {
                customEventFullscreen = null;
                Log.d("Failed to create Custom Event Fullscreen.");
            }
        } while (true);
    }

    public static void notifyAdClick(AdResponse adresponse)
    {
        AdManager admanager = (AdManager)sRunningAds.get(Long.valueOf(adresponse.getTimestamp()));
        if (admanager != null)
        {
            admanager.notifyAdClicked();
        }
    }

    private void notifyAdClicked()
    {
        if (mListener != null)
        {
            mHandler.post(new _cls9());
        }
    }

    private void notifyAdClose(final AdResponse ad, final boolean ok)
    {
        if (mListener != null)
        {
            Log.d((new StringBuilder("Ad Close. Result:")).append(ok).toString());
            mHandler.post(new _cls11());
        }
    }

    private void notifyAdLoaded(final AdResponse ad)
    {
        if (mListener != null)
        {
            mHandler.post(new _cls8());
        }
    }

    private void notifyAdShown(final AdResponse ad, final boolean ok)
    {
        if (mListener != null)
        {
            Log.d((new StringBuilder("Ad Shown. Result:")).append(ok).toString());
            mHandler.post(new _cls10());
        }
        mResponse = null;
    }

    private void notifyNoAdFound()
    {
        if (mListener != null)
        {
            Log.d("No ad found.");
            mHandler.post(new _cls7());
        }
        mResponse = null;
    }

    private void requestAdInternal(boolean flag)
    {
        if (!mEnabled)
        {
            Log.w("Cannot request rich adds on low memory devices");
            return;
        }
        if (!flag)
        {
            alreadyRequestedInterstitial = false;
            alreadyRequestedVideo = false;
        }
        if (mRequestThread == null)
        {
            Log.d("Requesting Ad (v5.2.0-3.0)");
            mResponse = null;
            if (!isVideoAdsEnabled)
            {
                prioritizeVideoAds = false;
            }
            mRequestThread = new Thread(new _cls1());
            mRequestThread.setUncaughtExceptionHandler(new _cls2());
            mRequestThread.start();
            return;
        } else
        {
            Log.w("Request thread already running");
            return;
        }
    }

    private static void setmContext(Context context)
    {
        mContext = context;
    }

    public int getVideoMaxDuration()
    {
        return videoMaxDuration;
    }

    public int getVideoMinimalDuration()
    {
        return videoMinimalDuration;
    }

    public boolean isAdLoaded()
    {
        return mResponse != null;
    }

    public boolean isPrioritizeVideoAds()
    {
        return prioritizeVideoAds;
    }

    public void release()
    {
        TrackerService.release();
        ResourceManager.cancel();
    }

    public void requestAd()
    {
        requestAdInternal(false);
    }

    public void requestAd(final InputStream xml)
    {
        if (!mEnabled)
        {
            Log.w("Cannot request rich adds on low memory devices");
            return;
        }
        alreadyRequestedInterstitial = false;
        alreadyRequestedVideo = false;
        if (mRequestThread == null)
        {
            Log.d("Requesting Ad (v5.2.0-3.0)");
            mResponse = null;
            mRequestThread = new Thread(new _cls3());
            mRequestThread.setUncaughtExceptionHandler(new _cls4());
            mRequestThread.start();
            return;
        } else
        {
            Log.w("Request thread already running");
            return;
        }
    }

    public void requestAdAndShow(long l)
    {
        AdListener adlistener = mListener;
        mListener = null;
        requestAd();
        long l1 = System.currentTimeMillis();
        long l2 = l1 + l;
        do
        {
            if (isAdLoaded() || l1 >= l2)
            {
                mListener = adlistener;
                showAd();
                return;
            }
            try
            {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedexception) { }
            l1 = System.currentTimeMillis();
        } while (true);
    }

    public void setInterstitialAdsEnabled(boolean flag)
    {
        isInterstitialAdsEnabled = flag;
    }

    public void setInterstitialRequestURL(String s)
    {
        interstitialRequestURL = s;
    }

    public void setKeywords(List list)
    {
        keywords = list;
    }

    public void setListener(AdListener adlistener)
    {
        mListener = adlistener;
    }

    public void setPrioritizeVideoAds(boolean flag)
    {
        prioritizeVideoAds = flag;
    }

    public void setUserAge(int i)
    {
        userAge = i;
    }

    public void setUserGender(Gender gender)
    {
        userGender = gender;
    }

    public void setVideoAdsEnabled(boolean flag)
    {
        isVideoAdsEnabled = flag;
    }

    public void setVideoMaxDuration(int i)
    {
        videoMaxDuration = i;
    }

    public void setVideoMinimalDuration(int i)
    {
        videoMinimalDuration = i;
    }

    public void showAd()
    {
        boolean flag;
        Activity activity;
        AdResponse adresponse;
        flag = false;
        activity = (Activity)getContext();
        if ((mResponse == null || mResponse.getType() == 2 || mResponse.getType() == -1) && customEventFullscreen == null)
        {
            notifyAdShown(mResponse, false);
            return;
        }
        adresponse = mResponse;
        boolean flag1 = Util.isNetworkAvailable(getContext());
        flag = false;
        if (!flag1) goto _L2; else goto _L1
_L1:
        CustomEventFullscreen customeventfullscreen;
        adresponse.setTimestamp(System.currentTimeMillis());
        adresponse.setHorizontalOrientationRequested(requestedHorizontalAd);
        Log.v((new StringBuilder("Showing Ad:")).append(adresponse).toString());
        customeventfullscreen = customEventFullscreen;
        flag = false;
        if (customeventfullscreen != null) goto _L4; else goto _L3
_L3:
        Intent intent = new Intent(activity, com/adsdk/sdk/video/RichMediaActivity);
        intent.putExtra("RICH_AD_DATA", adresponse);
        activity.startActivityForResult(intent, 0);
_L5:
        boolean flag2 = true;
        sRunningAds.put(Long.valueOf(adresponse.getTimestamp()), this);
_L6:
        notifyAdShown(adresponse, flag2);
        return;
_L4:
        customEventFullscreen.showFullscreen();
          goto _L5
        Exception exception1;
        exception1;
_L9:
        Log.e("Unknown exception when showing Ad", exception1);
        notifyAdShown(adresponse, flag);
        return;
_L2:
        Log.d("No network available. Cannot show Ad.");
        flag2 = false;
          goto _L6
        Exception exception;
        exception;
_L8:
        notifyAdShown(adresponse, flag);
        throw exception;
        Exception exception3;
        exception3;
        flag = flag2;
        exception = exception3;
        if (true) goto _L8; else goto _L7
_L7:
        Exception exception2;
        exception2;
        flag = flag2;
        exception1 = exception2;
          goto _L9
    }



























    private class _cls6
        implements com.adsdk.sdk.customevents.CustomEventFullscreen.CustomEventFullscreenListener
    {

        final AdManager this$0;

        public void onFullscreenClosed()
        {
            notifyAdClose(mResponse, true);
        }

        public void onFullscreenFailed()
        {
            loadCustomEventFullscreen();
            if (customEventFullscreen != null)
            {
                return;
            }
            if (mResponse.getType() != 2 && mResponse.getType() != -1)
            {
                notifyAdLoaded(mResponse);
                return;
            }
            if (isVideoAdsEnabled && !alreadyRequestedVideo || isInterstitialAdsEnabled && !alreadyRequestedInterstitial)
            {
                requestAdInternal(true);
                return;
            } else
            {
                notifyNoAdFound();
                return;
            }
        }

        public void onFullscreenLeftApplication()
        {
            notifyAdClicked();
        }

        public void onFullscreenLoaded(CustomEventFullscreen customeventfullscreen)
        {
            customEventFullscreen = customeventfullscreen;
            notifyAdLoaded(mResponse);
        }

        public void onFullscreenOpened()
        {
        }

        _cls6()
        {
            this$0 = AdManager.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final AdManager this$0;
        private final CustomEvent val$event;

        public void run()
        {
            try
            {
                customEventFullscreen.loadFullscreen(AdManager.mContext, customFullscreenListener, event.getOptionalParameter(), event.getPixelUrl());
                return;
            }
            catch (Exception exception)
            {
                customEventFullscreen = null;
            }
            Log.d("Failed to create Custom Event Fullscreen.");
        }

        _cls5()
        {
            this$0 = AdManager.this;
            event = customevent;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final AdManager this$0;

        public void run()
        {
            mListener.adClicked();
        }

        _cls9()
        {
            this$0 = AdManager.this;
            super();
        }
    }


    private class _cls11
        implements Runnable
    {

        final AdManager this$0;
        private final AdResponse val$ad;
        private final boolean val$ok;

        public void run()
        {
            mListener.adClosed(ad, ok);
        }

        _cls11()
        {
            this$0 = AdManager.this;
            ad = adresponse;
            ok = flag;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final AdManager this$0;
        private final AdResponse val$ad;

        public void run()
        {
            mListener.adLoadSucceeded(ad);
        }

        _cls8()
        {
            this$0 = AdManager.this;
            ad = adresponse;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final AdManager this$0;
        private final AdResponse val$ad;
        private final boolean val$ok;

        public void run()
        {
            mListener.adShown(ad, ok);
        }

        _cls10()
        {
            this$0 = AdManager.this;
            ad = adresponse;
            ok = flag;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final AdManager this$0;

        public void run()
        {
            mListener.noAdFound();
        }

        _cls7()
        {
            this$0 = AdManager.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final AdManager this$0;

        public void run()
        {
_L11:
            if (ResourceManager.isDownloading()) goto _L2; else goto _L1
_L1:
            Log.d("starting request thread");
            RequestGeneralAd requestgeneralad = new RequestGeneralAd();
            if (!isInterstitialAdsEnabled || prioritizeVideoAds || alreadyRequestedInterstitial) goto _L4; else goto _L3
_L3:
            request = getInterstitialRequest();
            alreadyRequestedInterstitial = true;
_L12:
            mResponse = (AdResponse)requestgeneralad.sendRequest(request);
            if (mResponse.getType() != 2 || mResponse.getCustomEvents() != null && !mResponse.getCustomEvents().isEmpty()) goto _L6; else goto _L5
_L5:
            if (!isVideoAdsEnabled || alreadyRequestedVideo) goto _L8; else goto _L7
_L7:
            request = getVideoRequest();
            alreadyRequestedVideo = true;
            mResponse = (AdResponse)requestgeneralad.sendRequest(request);
_L6:
            if (mResponse.getVideoData() == null || android.os.Build.VERSION.SDK_INT >= 8 || mResponse.getCustomEvents() != null && !mResponse.getCustomEvents().isEmpty()) goto _L10; else goto _L9
_L9:
            Log.d("Not capable of video");
            notifyNoAdFound();
_L13:
            Log.d("finishing ad request thread");
            mRequestThread = null;
            return;
_L2:
            try
            {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedexception) { }
              goto _L11
_L4:
            Throwable throwable;
            if (!isVideoAdsEnabled || alreadyRequestedVideo)
            {
                break MISSING_BLOCK_LABEL_376;
            }
            request = getVideoRequest();
            alreadyRequestedVideo = true;
              goto _L12
            try
            {
                Log.d("Both video and interstitial ads disabled");
                notifyNoAdFound();
                mRequestThread = null;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable) { }
            if (isVideoAdsEnabled && !alreadyRequestedVideo)
            {
                mRequestThread = null;
                requestAdInternal(true);
            } else
            if (isInterstitialAdsEnabled && !alreadyRequestedInterstitial)
            {
                mRequestThread = null;
                requestAdInternal(true);
            } else
            {
                mResponse = new AdResponse();
                mResponse.setType(-1);
                notifyNoAdFound();
            }
              goto _L13
_L8:
            if (!isInterstitialAdsEnabled || alreadyRequestedInterstitial) goto _L6; else goto _L14
_L14:
            request = getInterstitialRequest();
            alreadyRequestedInterstitial = true;
            mResponse = (AdResponse)requestgeneralad.sendRequest(request);
              goto _L6
_L10:
label0:
            {
                if (mResponse.getType() != 3 || !mResponse.getCustomEvents().isEmpty())
                {
                    break label0;
                }
                Log.d("response OK received");
                notifyAdLoaded(mResponse);
            }
              goto _L13
label1:
            {
                if (!mResponse.getCustomEvents().isEmpty() || mResponse.getType() != 1 && mResponse.getType() != 4 && mResponse.getType() != 0)
                {
                    break label1;
                }
                notifyAdLoaded(mResponse);
            }
              goto _L13
label2:
            {
                if (mResponse.getType() != 2 || mResponse.getCustomEvents() == null || !mResponse.getCustomEvents().isEmpty())
                {
                    break label2;
                }
                Log.d("response NO AD received");
                notifyNoAdFound();
            }
              goto _L13
label3:
            {
                if (mResponse.getCustomEvents() == null || mResponse.getCustomEvents().isEmpty())
                {
                    break label3;
                }
                loadCustomEventFullscreen();
                if (customEventFullscreen == null)
                {
                    mResponse.getCustomEvents().clear();
                    notifyNoAdFound();
                }
            }
              goto _L13
            notifyNoAdFound();
              goto _L13
        }

        _cls1()
        {
            this$0 = AdManager.this;
            super();
        }
    }


    private class _cls2
        implements Thread.UncaughtExceptionHandler
    {

        final AdManager this$0;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            mResponse = new AdResponse();
            mResponse.setType(-1);
            Log.e("Handling exception in ad request thread", throwable);
            mRequestThread = null;
        }

        _cls2()
        {
            this$0 = AdManager.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final AdManager this$0;
        private final InputStream val$xml;

        public void run()
        {
_L11:
            if (ResourceManager.isDownloading()) goto _L2; else goto _L1
_L1:
            Log.d("starting request thread");
            RequestGeneralAd requestgeneralad = new RequestGeneralAd(xml);
            if (!isInterstitialAdsEnabled || prioritizeVideoAds) goto _L4; else goto _L3
_L3:
            request = getInterstitialRequest();
_L12:
            mResponse = (AdResponse)requestgeneralad.sendRequest(request);
            if (mResponse.getType() != 2 || !mResponse.getCustomEvents().isEmpty()) goto _L6; else goto _L5
_L5:
            if (!isVideoAdsEnabled || alreadyRequestedVideo) goto _L8; else goto _L7
_L7:
            request = getVideoRequest();
            alreadyRequestedVideo = true;
            mResponse = (AdResponse)requestgeneralad.sendRequest(request);
_L6:
            if (mResponse.getType() == 2 || !mResponse.getCustomEvents().isEmpty()) goto _L10; else goto _L9
_L9:
            Log.d("response OK received");
            notifyAdLoaded(mResponse);
_L13:
            Log.d("finishing ad request thread");
            mRequestThread = null;
            return;
_L2:
            try
            {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedexception) { }
              goto _L11
_L4:
            Throwable throwable;
label0:
            {
                if (!isVideoAdsEnabled)
                {
                    break label0;
                }
                request = getVideoRequest();
            }
              goto _L12
            try
            {
                Log.d("Both video and interstitial ads disabled");
                notifyNoAdFound();
                mRequestThread = null;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Throwable throwable)
            {
                mResponse = new AdResponse();
                mResponse.setType(-1);
                notifyNoAdFound();
            }
              goto _L13
_L8:
            if (!isInterstitialAdsEnabled || alreadyRequestedInterstitial) goto _L6; else goto _L14
_L14:
            request = getInterstitialRequest();
            alreadyRequestedInterstitial = true;
            mResponse = (AdResponse)requestgeneralad.sendRequest(request);
              goto _L6
_L10:
label1:
            {
                if (!mResponse.getCustomEvents().isEmpty())
                {
                    break label1;
                }
                Log.d("response NO AD received");
                notifyNoAdFound();
            }
              goto _L13
            loadCustomEventFullscreen();
            if (customEventFullscreen == null)
            {
                mResponse.getCustomEvents().clear();
                notifyNoAdFound();
            }
              goto _L13
        }

        _cls3()
        {
            this$0 = AdManager.this;
            xml = inputstream;
            super();
        }
    }


    private class _cls4
        implements Thread.UncaughtExceptionHandler
    {

        final AdManager this$0;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            mResponse = new AdResponse();
            mResponse.setType(-1);
            Log.e("Handling exception in ad request thread", throwable);
            mRequestThread = null;
        }

        _cls4()
        {
            this$0 = AdManager.this;
            super();
        }
    }

}
