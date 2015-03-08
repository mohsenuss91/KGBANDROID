// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.location.Location;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.AdRequest;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Gender;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.Util;
import com.adsdk.sdk.customevents.CustomEvent;
import com.adsdk.sdk.customevents.CustomEventBanner;
import com.adsdk.sdk.customevents.CustomEventBannerFactory;
import com.adsdk.sdk.mraid.MraidView;
import java.io.InputStream;
import java.util.List;
import java.util.Timer;

// Referenced classes of package com.adsdk.sdk.banner:
//            BannerAdView, ReloadTask

public class AdView extends FrameLayout
{

    private static final int CUSTOM_EVENT_RELOAD_INTERVAL = 30;
    public static final int LIVE = 0;
    public static final int TEST = 1;
    private FrameLayout MRAIDFrame;
    private AdListener adListener;
    private int adspaceHeight;
    private boolean adspaceStrict;
    private int adspaceWidth;
    private boolean animation;
    private com.adsdk.sdk.customevents.CustomEventBanner.CustomEventBannerListener customAdListener;
    private CustomEventBanner customEventBanner;
    private View customEventBannerView;
    private boolean includeLocation;
    private boolean isInternalBrowser;
    private List keywords;
    private Thread loadContentThread;
    private BannerAdView mBannerView;
    private Context mContext;
    protected boolean mIsInForeground;
    private MraidView mMRAIDView;
    private BroadcastReceiver mScreenStateReceiver;
    private String publisherId;
    private Timer reloadTimer;
    private AdRequest request;
    private String requestURL;
    private AdResponse response;
    private final Runnable showContent;
    private int telephonyPermission;
    private final Handler updateHandler;
    private int userAge;
    private Gender userGender;
    private InputStream xml;

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        includeLocation = false;
        isInternalBrowser = false;
        requestURL = null;
        mContext = null;
        updateHandler = new Handler();
        showContent = new _cls1();
        mContext = context;
        if (attributeset == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = attributeset.getAttributeCount();
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        initialize(context);
        return;
_L3:
        String s;
        s = attributeset.getAttributeName(j);
        if (!s.equals("publisherId"))
        {
            break; /* Loop/switch isn't completed */
        }
        publisherId = attributeset.getAttributeValue(j);
_L6:
        j++;
        if (true) goto _L5; else goto _L4
_L4:
        if (s.equals("request_url"))
        {
            requestURL = attributeset.getAttributeValue(j);
        } else
        if (s.equals("animation"))
        {
            animation = attributeset.getAttributeBooleanValue(j, false);
        } else
        if (s.equals("location"))
        {
            includeLocation = attributeset.getAttributeBooleanValue(j, false);
        } else
        if (s.equals("adspaceStrict"))
        {
            adspaceStrict = attributeset.getAttributeBooleanValue(j, false);
        } else
        if (s.equals("adspaceWidth"))
        {
            adspaceWidth = attributeset.getAttributeIntValue(j, 0);
        } else
        if (s.equals("adspaceHeight"))
        {
            adspaceHeight = attributeset.getAttributeIntValue(j, 0);
        }
          goto _L6
        if (true) goto _L5; else goto _L7
_L7:
    }

    public AdView(Context context, InputStream inputstream, String s, String s1, boolean flag, boolean flag1)
    {
        super(context);
        includeLocation = false;
        isInternalBrowser = false;
        requestURL = null;
        mContext = null;
        updateHandler = new Handler();
        showContent = new _cls1();
        xml = inputstream;
        requestURL = s;
        mContext = context;
        publisherId = s1;
        includeLocation = flag;
        animation = flag1;
        initialize(context);
    }

    public AdView(Context context, String s, InputStream inputstream, String s1, boolean flag, boolean flag1)
    {
        this(context, inputstream, s, s1, flag, flag1);
    }

    public AdView(Context context, String s, String s1)
    {
        this(context, s, s1, false, false);
    }

    public AdView(Context context, String s, String s1, boolean flag, boolean flag1)
    {
        this(context, s, s1, flag, flag1, ((AdListener) (null)));
    }

    public AdView(Context context, String s, String s1, boolean flag, boolean flag1, AdListener adlistener)
    {
        super(context);
        includeLocation = false;
        isInternalBrowser = false;
        requestURL = null;
        mContext = null;
        updateHandler = new Handler();
        showContent = new _cls1();
        requestURL = s;
        mContext = context;
        publisherId = s1;
        includeLocation = flag;
        animation = flag1;
        adListener = adlistener;
        StringBuilder stringbuilder = new StringBuilder("AdListener: ");
        AdListener adlistener1 = adListener;
        boolean flag2 = false;
        if (adlistener1 == null)
        {
            flag2 = true;
        }
        Log.d(stringbuilder.append(flag2).toString());
        initialize(context);
    }

    private void addMRAIDBannerView()
    {
        float f = mContext.getResources().getDisplayMetrics().density;
        if (adspaceHeight != 0 && adspaceWidth != 0)
        {
            addView(MRAIDFrame, new android.widget.FrameLayout.LayoutParams((int)(0.5F + f * (float)adspaceWidth), (int)(0.5F + f * (float)adspaceHeight)));
            return;
        } else
        {
            addView(MRAIDFrame, new android.widget.FrameLayout.LayoutParams(-2, (int)(0.5F + f * 50F)));
            return;
        }
    }

    private com.adsdk.sdk.customevents.CustomEventBanner.CustomEventBannerListener createCustomAdListener(final AdListener listener)
    {
        return new _cls7();
    }

    private com.adsdk.sdk.mraid.MraidView.MraidListener createMraidListener(final AdListener listener)
    {
        return new _cls8();
    }

    private AdRequest getRequest()
    {
        if (request == null)
        {
            request = new AdRequest();
            boolean flag;
            Location location;
            if (telephonyPermission == 0)
            {
                TelephonyManager telephonymanager = (TelephonyManager)getContext().getSystemService("phone");
                request.setDeviceId(telephonymanager.getDeviceId());
                request.setAndroidIMEI(telephonymanager.getDeviceId());
            } else
            {
                request.setDeviceId(Util.getDeviceId(mContext));
            }
            request.setAndroidID(Util.getDeviceId(mContext));
            request.setAndroidAdId(Util.getAndroidAdId());
            request.setPublisherId(publisherId);
            request.setUserAgent(Util.getDefaultUserAgentString(mContext));
            request.setUserAgent2(Util.buildUserAgent());
            Log.d("ADSDK", (new StringBuilder("WebKit UserAgent:")).append(request.getUserAgent()).toString());
            Log.d("ADSDK", (new StringBuilder("SDK built UserAgent:")).append(request.getUserAgent2()).toString());
        }
        request.setGender(userGender);
        request.setUserAge(userAge);
        request.setKeywords(keywords);
        flag = includeLocation;
        location = null;
        if (flag)
        {
            location = Util.getLocation(mContext);
        }
        if (location != null)
        {
            Log.d("ADSDK", (new StringBuilder("location is longitude: ")).append(location.getLongitude()).append(", latitude: ").append(location.getLatitude()).toString());
            request.setLatitude(location.getLatitude());
            request.setLongitude(location.getLongitude());
        } else
        {
            request.setLatitude(0.0D);
            request.setLongitude(0.0D);
        }
        request.setAdspaceHeight(adspaceHeight);
        request.setAdspaceWidth(adspaceWidth);
        request.setAdspaceStrict(adspaceStrict);
        request.setRequestURL(requestURL);
        return request;
    }

    private void initialize(Context context)
    {
        Log.LOGGING_ENABLED = Log.isLoggingEnabled(mContext);
        Log.d("ADSDK", "SDK Version:5.2.0");
        registerScreenStateBroadcastReceiver();
        telephonyPermission = context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
        Util.prepareAndroidAdId(context);
    }

    private void loadContent()
    {
        Log.d("ADSDK", "load content");
        if (loadContentThread == null)
        {
            loadContentThread = new Thread(new _cls3());
            loadContentThread.setUncaughtExceptionHandler(new _cls4());
            loadContentThread.start();
        }
    }

    private void loadCustomEventBanner()
    {
        customEventBanner = null;
_L2:
        if (response.getCustomEvents().isEmpty() || customEventBanner != null)
        {
            return;
        }
        CustomEvent customevent = (CustomEvent)response.getCustomEvents().get(0);
        response.getCustomEvents().remove(customevent);
        customEventBanner = CustomEventBannerFactory.create(customevent.getClassName());
        Exception exception;
        if (adspaceHeight != 0 && adspaceWidth != 0)
        {
            customEventBanner.loadBanner(mContext, customAdListener, customevent.getOptionalParameter(), customevent.getPixelUrl(), adspaceWidth, adspaceHeight);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            customEventBanner.loadBanner(mContext, customAdListener, customevent.getOptionalParameter(), customevent.getPixelUrl(), 300, 50);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            customEventBanner = null;
            Log.d("Failed to create Custom Event Banner.");
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void notifyLoadAdFailed(final Throwable e)
    {
        updateHandler.post(new _cls6());
    }

    private void notifyNoAd()
    {
        updateHandler.post(new _cls5());
    }

    private void registerScreenStateBroadcastReceiver()
    {
        mScreenStateReceiver = new _cls2();
        IntentFilter intentfilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.USER_PRESENT");
        mContext.registerReceiver(mScreenStateReceiver, intentfilter);
    }

    private void showContent()
    {
        if (mBannerView != null)
        {
            removeView(mBannerView);
            mBannerView = null;
        }
        if (mMRAIDView != null)
        {
            mMRAIDView.destroy();
            removeView(mMRAIDView);
            mMRAIDView = null;
        }
        if (MRAIDFrame != null)
        {
            removeView(MRAIDFrame);
            MRAIDFrame = null;
        }
        if (customEventBannerView != null)
        {
            removeView(customEventBannerView);
        }
        if (response.getType() == 1 || response.getType() == 0)
        {
            mBannerView = new BannerAdView(mContext, response, adspaceWidth, adspaceHeight, animation, adListener);
            if (response.getCustomEvents().isEmpty())
            {
                addView(mBannerView);
            }
        }
        if (response.getType() == 4)
        {
            mMRAIDView = new MraidView(mContext);
            MRAIDFrame = new FrameLayout(mContext);
            MRAIDFrame.addView(mMRAIDView);
            if (response.getCustomEvents().isEmpty())
            {
                addMRAIDBannerView();
            }
            mMRAIDView.setMraidListener(createMraidListener(adListener));
            mMRAIDView.loadHtmlData(response.getText());
        }
        if (response.getType() == 2 && response.getCustomEvents().isEmpty())
        {
            notifyNoAd();
        }
        if (!response.getCustomEvents().isEmpty())
        {
            loadCustomEventBanner();
            if (customEventBanner == null)
            {
                response.getCustomEvents().clear();
                customAdListener.onBannerFailed();
            } else
            {
                response.setRefresh(30);
            }
        }
        startReloadTimer();
    }

    private void startReloadTimer()
    {
        Log.d("ADSDK", "start reload timer");
        if (reloadTimer == null || response.getRefresh() <= 0)
        {
            return;
        } else
        {
            int i = 1000 * response.getRefresh();
            Log.d("ADSDK", (new StringBuilder("set timer: ")).append(i).toString());
            ReloadTask reloadtask = new ReloadTask(this);
            reloadTimer.schedule(reloadtask, i);
            return;
        }
    }

    private void unregisterScreenStateBroadcastReceiver()
    {
        try
        {
            mContext.unregisterReceiver(mScreenStateReceiver);
            return;
        }
        catch (Exception exception)
        {
            Log.d("Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    protected void finalize()
    {
        unregisterScreenStateBroadcastReceiver();
        super.finalize();
    }

    public int getRefreshRate()
    {
        if (response != null)
        {
            return response.getRefresh();
        } else
        {
            return -1;
        }
    }

    public boolean isInternalBrowser()
    {
        return isInternalBrowser;
    }

    public void loadNextAd()
    {
        Log.d("ADSDK", "load next ad");
        loadContent();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        IntentFilter intentfilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentfilter.addAction("android.intent.action.USER_PRESENT");
        mContext.registerReceiver(mScreenStateReceiver, intentfilter);
        Log.v("ADSDK", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        unregisterScreenStateBroadcastReceiver();
        Log.v("ADSDK", "onDetachedFromWindow");
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (i == 0)
        {
            mIsInForeground = true;
            resume();
        } else
        {
            mIsInForeground = false;
            pause();
        }
        Log.d("ADSDK", (new StringBuilder("onWindowVisibilityChanged: ")).append(i).toString());
    }

    public void pause()
    {
        if (reloadTimer == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        Log.d("ADSDK", "cancel reload timer");
        reloadTimer.cancel();
        reloadTimer = null;
        return;
        Exception exception;
        exception;
        Log.e("ADSDK", "unable to cancel reloadTimer", exception);
        return;
    }

    public void release()
    {
        unregisterScreenStateBroadcastReceiver();
        if (mMRAIDView != null)
        {
            mMRAIDView.destroy();
        }
    }

    public void resume()
    {
        if (reloadTimer != null)
        {
            reloadTimer.cancel();
            reloadTimer = null;
        }
        reloadTimer = new Timer();
        Log.d("ADSDK", (new StringBuilder("response: ")).append(response).toString());
        if (response != null && response.getRefresh() > 0)
        {
            startReloadTimer();
        } else
        if (response == null || mMRAIDView == null && mBannerView == null)
        {
            loadContent();
            return;
        }
    }

    public void setAdListener(AdListener adlistener)
    {
        adListener = adlistener;
        if (mMRAIDView != null)
        {
            mMRAIDView.setMraidListener(createMraidListener(adlistener));
        }
        if (mBannerView != null)
        {
            mBannerView.setAdListener(adlistener);
        }
        customAdListener = createCustomAdListener(adListener);
    }

    public void setAdspaceHeight(int i)
    {
        adspaceHeight = i;
    }

    public void setAdspaceStrict(boolean flag)
    {
        adspaceStrict = flag;
    }

    public void setAdspaceWidth(int i)
    {
        adspaceWidth = i;
    }

    public void setInternalBrowser(boolean flag)
    {
        isInternalBrowser = flag;
    }

    public void setKeywords(List list)
    {
        keywords = list;
    }

    public void setUserAge(int i)
    {
        userAge = i;
    }

    public void setUserGender(Gender gender)
    {
        userGender = gender;
    }

















    private class _cls1
        implements Runnable
    {

        final AdView this$0;

        public void run()
        {
            try
            {
                showContent();
                return;
            }
            catch (Exception exception)
            {
                notifyLoadAdFailed(exception);
            }
        }

        _cls1()
        {
            this$0 = AdView.this;
            super();
        }
    }


    private class _cls7
        implements com.adsdk.sdk.customevents.CustomEventBanner.CustomEventBannerListener
    {

        final AdView this$0;
        private final AdListener val$listener;

        public void onBannerClosed()
        {
            if (listener != null)
            {
                listener.adClosed(null, true);
            }
        }

        public void onBannerExpanded()
        {
            if (listener != null)
            {
                listener.adClicked();
                listener.adShown(null, true);
            }
        }

        public void onBannerFailed()
        {
            loadCustomEventBanner();
            if (customEventBanner != null)
            {
                return;
            }
            if (mBannerView != null)
            {
                addView(mBannerView);
                return;
            }
            if (mMRAIDView != null)
            {
                addMRAIDBannerView();
                return;
            } else
            {
                notifyNoAd();
                return;
            }
        }

        public void onBannerLoaded(View view)
        {
            addView(view);
            if (listener != null)
            {
                listener.adLoadSucceeded(null);
            }
        }

        _cls7()
        {
            this$0 = AdView.this;
            listener = adlistener;
            super();
        }
    }


    private class _cls8
        implements com.adsdk.sdk.mraid.MraidView.MraidListener
    {

        final AdView this$0;
        private final AdListener val$listener;

        public void onClose(MraidView mraidview, com.adsdk.sdk.mraid.MraidView.ViewState viewstate)
        {
            if (listener != null)
            {
                listener.adClosed(null, true);
            }
        }

        public void onExpand(MraidView mraidview)
        {
            if (listener != null)
            {
                listener.adClicked();
                listener.adShown(null, true);
            }
        }

        public void onFailure(MraidView mraidview)
        {
            if (listener != null)
            {
                listener.noAdFound();
            }
        }

        public void onReady(MraidView mraidview)
        {
            if (listener != null)
            {
                listener.adLoadSucceeded(null);
            }
        }

        _cls8()
        {
            this$0 = AdView.this;
            listener = adlistener;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final AdView this$0;

        public void run()
        {
            Log.d("ADSDK", "starting request thread");
            RequestGeneralAd requestgeneralad;
            if (xml == null)
            {
                requestgeneralad = new RequestGeneralAd();
            } else
            {
                requestgeneralad = new RequestGeneralAd(xml);
            }
            try
            {
                response = (AdResponse)requestgeneralad.sendRequest(getRequest());
                if (response != null)
                {
                    Log.d("ADSDK", "response received");
                    Log.d("ADSDK", (new StringBuilder("getVisibility: ")).append(getVisibility()).toString());
                    updateHandler.post(showContent);
                }
            }
            catch (Throwable throwable)
            {
                notifyLoadAdFailed(throwable);
            }
            loadContentThread = null;
            Log.d("ADSDK", "finishing request thread");
        }

        _cls3()
        {
            this$0 = AdView.this;
            super();
        }
    }


    private class _cls4
        implements Thread.UncaughtExceptionHandler
    {

        final AdView this$0;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            Log.e("ADSDK", "Exception in request thread", throwable);
            loadContentThread = null;
        }

        _cls4()
        {
            this$0 = AdView.this;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final AdView this$0;
        private final Throwable val$e;

        public void run()
        {
            Log.e("ADSDK", "Exception when building ad:", e);
            if (adListener != null)
            {
                Log.d("ADSDK", (new StringBuilder("notify bannerListener: ")).append(adListener.getClass().getName()).toString());
                adListener.noAdFound();
            }
        }

        _cls6()
        {
            this$0 = AdView.this;
            e = throwable;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final AdView this$0;

        public void run()
        {
            Log.d("ADSDK", "No Ad");
            if (adListener != null)
            {
                adListener.noAdFound();
            }
        }

        _cls5()
        {
            this$0 = AdView.this;
            super();
        }
    }


    private class _cls2 extends BroadcastReceiver
    {

        final AdView this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (!intent.getAction().equals("android.intent.action.SCREEN_OFF")) goto _L2; else goto _L1
_L1:
            if (!mIsInForeground) goto _L4; else goto _L3
_L3:
            Log.d("ADSDK", "Screen sleep with ad in foreground, disable refresh");
            pause();
_L6:
            return;
_L4:
            Log.d("ADSDK", "Screen sleep but ad in background; refresh should already be disabled");
            return;
_L2:
            if (intent.getAction().equals("android.intent.action.USER_PRESENT"))
            {
                if (mIsInForeground)
                {
                    resume();
                    Log.d("ADSDK", "Screen wake / ad in foreground, reset refresh");
                    return;
                } else
                {
                    Log.d("ADSDK", "Screen wake but ad in background; don't enable refresh");
                    return;
                }
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        _cls2()
        {
            this$0 = AdView.this;
            super();
        }
    }

}
