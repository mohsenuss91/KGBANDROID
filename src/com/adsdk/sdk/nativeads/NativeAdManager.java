// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.adsdk.sdk.Gender;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.Util;
import java.util.List;

// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAdRequest, NativeAdView, NativeAd, NativeAdListener, 
//            NativeViewBinder

public class NativeAdManager
{

    private List adTypes;
    private Context context;
    private Handler handler;
    private boolean includeLocation;
    private List keywords;
    private NativeAdListener listener;
    private NativeAd nativeAd;
    private String publisherId;
    private NativeAdRequest request;
    private String requestUrl;
    private int telephonyPermission;
    private int userAge;
    private Gender userGender;

    public NativeAdManager(Context context1, String s, boolean flag, String s1, NativeAdListener nativeadlistener, List list)
    {
        includeLocation = false;
        if (s1 == null || s1.length() == 0)
        {
            Log.e("Publisher Id cannot be null or empty");
            throw new IllegalArgumentException("User Id cannot be null or empty");
        } else
        {
            context = context1;
            requestUrl = s;
            includeLocation = flag;
            publisherId = s1;
            listener = nativeadlistener;
            adTypes = list;
            handler = new Handler();
            telephonyPermission = context1.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE");
            Util.prepareAndroidAdId(context1);
            return;
        }
    }

    private android.view.View.OnClickListener createOnNativeAdClickListener(final String clickUrl)
    {
        return new _cls3();
    }

    private NativeAdRequest getRequest()
    {
        if (request == null)
        {
            request = new NativeAdRequest();
            if (telephonyPermission == 0)
            {
                TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
                request.setAndroidIMEI(telephonymanager.getDeviceId());
            }
            request.setAndroidID(Util.getDeviceId(context));
            request.setAndroidAdId(Util.getAndroidAdId());
            request.setPublisherId(publisherId);
            request.setUserAgent(Util.getDefaultUserAgentString(context));
            request.setUserAgent2(Util.buildUserAgent());
            Log.d("ADSDK", (new StringBuilder("WebKit UserAgent:")).append(request.getUserAgent()).toString());
        }
        request.setRequestUrl(requestUrl);
        request.setAdTypes(adTypes);
        request.setGender(userGender);
        request.setUserAge(userAge);
        request.setAdTypes(adTypes);
        request.setKeywords(keywords);
        boolean flag = includeLocation;
        Location location = null;
        if (flag)
        {
            location = Util.getLocation(context);
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
        return request;
    }

    private void notifyAdClicked()
    {
        if (listener != null)
        {
            handler.post(new _cls6());
        }
    }

    private void notifyAdFailed()
    {
        if (listener != null)
        {
            handler.post(new _cls5());
        }
    }

    private void notifyAdLoaded(final NativeAd ad)
    {
        if (listener != null)
        {
            handler.post(new _cls4());
        }
    }

    public NativeAdView getNativeAdView(NativeAd nativead, NativeViewBinder nativeviewbinder)
    {
        NativeAdView nativeadview = new NativeAdView(context, nativead, nativeviewbinder, listener);
        if (nativead != null)
        {
            nativeadview.setOnClickListener(createOnNativeAdClickListener(nativead.getClickUrl()));
        }
        return nativeadview;
    }

    public void requestAd()
    {
        Thread thread = new Thread(new _cls1());
        thread.setUncaughtExceptionHandler(new _cls2());
        thread.start();
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









    private class _cls3
        implements android.view.View.OnClickListener
    {

        final NativeAdManager this$0;
        private final String val$clickUrl;

        public void onClick(View view)
        {
            notifyAdClicked();
            if (clickUrl != null && !clickUrl.equals(""))
            {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(clickUrl));
                context.startActivity(intent);
            }
        }

        _cls3()
        {
            this$0 = NativeAdManager.this;
            clickUrl = s;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final NativeAdManager this$0;

        public void run()
        {
            listener.adClicked();
        }

        _cls6()
        {
            this$0 = NativeAdManager.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final NativeAdManager this$0;

        public void run()
        {
            listener.adFailedToLoad();
        }

        _cls5()
        {
            this$0 = NativeAdManager.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final NativeAdManager this$0;
        private final NativeAd val$ad;

        public void run()
        {
            listener.adLoaded(ad);
        }

        _cls4()
        {
            this$0 = NativeAdManager.this;
            ad = nativead;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final NativeAdManager this$0;

        public void run()
        {
            RequestNativeAd requestnativead;
            Log.d("ADSDK", "starting request thread");
            requestnativead = new RequestNativeAd();
            nativeAd = requestnativead.sendRequest(getRequest());
            if (nativeAd == null) goto _L2; else goto _L1
_L1:
            notifyAdLoaded(nativeAd);
_L4:
            Log.d("ADSDK", "finishing request thread");
            return;
_L2:
            try
            {
                notifyAdFailed();
            }
            catch (Throwable throwable)
            {
                notifyAdFailed();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        _cls1()
        {
            this$0 = NativeAdManager.this;
            super();
        }
    }


    private class _cls2
        implements Thread.UncaughtExceptionHandler
    {

        final NativeAdManager this$0;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            Log.e("ADSDK", "Exception in request thread", throwable);
        }

        _cls2()
        {
            this$0 = NativeAdManager.this;
            super();
        }
    }

}
