// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.adsdk.sdk.mraid:
//            BaseInterstitialActivity, MraidVideoView, BaseVideoView

public class MraidVideoPlayerActivity extends BaseInterstitialActivity
    implements BaseVideoView.BaseVideoViewListener
{

    private static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
    static final String VIDEO_URL = "video_url";
    private BaseVideoView mVideoView;

    public MraidVideoPlayerActivity()
    {
    }

    private void broadcastVastInterstitialAction(String s)
    {
    }

    static Intent createIntentMraid(Context context, String s)
    {
        Intent intent = new Intent(context, com/adsdk/sdk/mraid/MraidVideoPlayerActivity);
        intent.setFlags(0x10000000);
        intent.putExtra("video_view_class_name", "mraid");
        intent.putExtra("video_url", s);
        return intent;
    }

    static Intent createIntentVast(Context context, String s, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, ArrayList arraylist3, ArrayList arraylist4, ArrayList arraylist5, 
            String s1, ArrayList arraylist6)
    {
        return new Intent(context, com/adsdk/sdk/mraid/MraidVideoPlayerActivity);
    }

    private BaseVideoView createVideoView()
    {
        String s = getIntent().getStringExtra("video_view_class_name");
        if ("vast".equals(s))
        {
            return null;
        }
        if ("mraid".equals(s))
        {
            return new MraidVideoView(this, getIntent(), this);
        } else
        {
            broadcastInterstitialAction("com.mopub.action.interstitial.fail");
            finish();
            return new _cls1(this);
        }
    }

    static void startMraid(Context context, String s)
    {
        Intent intent = createIntentMraid(context, s);
        try
        {
            context.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.d("MraidVideoPlayerActivity", "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    static void startVast(Context context, String s, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, ArrayList arraylist3, ArrayList arraylist4, ArrayList arraylist5, 
            String s1, ArrayList arraylist6)
    {
        if (s == null)
        {
            return;
        }
        Intent intent = createIntentVast(context, s, arraylist, arraylist1, arraylist2, arraylist3, arraylist4, arraylist5, s1, arraylist6);
        try
        {
            context.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.d("MoPub", "Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
        }
    }

    public View getAdView()
    {
        mVideoView = createVideoView();
        return mVideoView;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        hideInterstitialCloseButton();
        mVideoView.start();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onPause()
    {
        mVideoView.onPause();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        mVideoView.onResume();
    }

    public void showCloseButton()
    {
        showInterstitialCloseButton();
    }

    public void videoClicked()
    {
        broadcastInterstitialAction("com.mopub.action.interstitial.click");
    }

    public void videoCompleted(boolean flag)
    {
        showInterstitialCloseButton();
        if (flag)
        {
            finish();
        }
    }

    public void videoError(boolean flag)
    {
        Log.d("MoPub", "Error: video can not be played.");
        showInterstitialCloseButton();
        broadcastInterstitialAction("com.mopub.action.interstitial.fail");
        if (flag)
        {
            finish();
        }
    }

    private class _cls1 extends BaseVideoView
    {

        final MraidVideoPlayerActivity this$0;

        _cls1(Context context)
        {
            this$0 = MraidVideoPlayerActivity.this;
            super(context);
        }
    }

}
