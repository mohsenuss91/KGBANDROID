// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.adsdk.sdk.Log;
import java.lang.reflect.Method;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

public class WebViewClient extends android.webkit.WebViewClient
{

    private Activity mActivity;
    private boolean mAllowNavigation;
    private String mAllowedUrl;
    private long mFinishedLoadingTime;
    private OnPageLoadedListener mOnPageLoadedListener;

    public WebViewClient(Activity activity, boolean flag)
    {
        mAllowNavigation = false;
        mActivity = activity;
        mAllowNavigation = flag;
        mFinishedLoadingTime = 0L;
    }

    public String getAllowedUrl()
    {
        return mAllowedUrl;
    }

    public long getFinishedLoadingTime()
    {
        return mFinishedLoadingTime;
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        Log.d((new StringBuilder("onPageFinished:")).append(s).append(" mAllowedUrl:").append(mAllowedUrl).toString());
        if (mAllowedUrl == null || s.equals(mAllowedUrl))
        {
            if (mFinishedLoadingTime == 0L)
            {
                mFinishedLoadingTime = System.currentTimeMillis();
            }
            if (mOnPageLoadedListener != null)
            {
                mOnPageLoadedListener.onPageLoaded();
            }
        }
    }

    public void setAllowedUrl(String s)
    {
        mFinishedLoadingTime = 0L;
        mAllowedUrl = s;
        if (mAllowedUrl != null)
        {
            String s1 = Uri.parse(mAllowedUrl).getPath();
            if (s1 == null || s1.length() == 0)
            {
                mAllowedUrl = (new StringBuilder(String.valueOf(mAllowedUrl))).append("/").toString();
            }
        }
    }

    public void setOnPageLoadedListener(OnPageLoadedListener onpageloadedlistener)
    {
        mOnPageLoadedListener = onpageloadedlistener;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Log.d((new StringBuilder("Loading url:")).append(s).toString());
        if (s.startsWith("market:") || s.startsWith("http://market.android.com") || s.startsWith("sms:") || s.startsWith("tel:") || s.startsWith("mailto:") || s.startsWith("voicemail:") || s.startsWith("geo:") || s.startsWith("google.streetview:"))
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            try
            {
                mActivity.startActivity(intent);
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                Log.w((new StringBuilder("Could open URL: ")).append(s).toString());
                return true;
            }
            return true;
        }
        if (s.startsWith("mfox:external:"))
        {
            Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(s.substring(14)));
            mActivity.startActivity(intent1);
            return true;
        }
        if (s.startsWith("mfox:replayvideo"))
        {
            try
            {
                mActivity.getClass().getMethod("replayVideo", new Class[0]).invoke(mActivity, new Object[0]);
            }
            catch (NoSuchMethodException nosuchmethodexception1)
            {
                Log.d("Your activity class has no replayVideo method");
                return true;
            }
            catch (Exception exception1)
            {
                Log.d("Couldn't run replayVideo method in your Activity");
                return true;
            }
            return true;
        }
        if (s.startsWith("mfox:playvideo"))
        {
            try
            {
                mActivity.getClass().getMethod("playVideo", new Class[0]).invoke(mActivity, new Object[0]);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.d("Your activity class has no playVideo method");
                return true;
            }
            catch (Exception exception)
            {
                Log.d("Couldn't run replayVideo method in your Activity");
                return true;
            }
            return true;
        }
        if (s.startsWith("mfox:skip"))
        {
            mActivity.finish();
            return true;
        }
        if (mAllowNavigation || s.equals(mAllowedUrl))
        {
            webview.loadUrl(s);
            return true;
        } else
        {
            Intent intent2 = new Intent(mActivity, com/adsdk/sdk/video/RichMediaActivity);
            intent2.setData(Uri.parse(s));
            mActivity.startActivity(intent2);
            return true;
        }
    }

    private class OnPageLoadedListener
    {

        public abstract void onPageLoaded();
    }

}
