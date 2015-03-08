// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.AdManager;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Const;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.banner.BannerAdView;
import com.adsdk.sdk.mraid.MraidView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            ResourceManager, VideoData, SDKVideoView, WebFrame, 
//            MediaController, TrackEvent, TrackerService

public class RichMediaActivity extends Activity
{

    public static final int TYPE_BROWSER = 0;
    public static final int TYPE_INTERSTITIAL = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_VIDEO = 1;
    private AdResponse mAd;
    private boolean mCanClose;
    private Runnable mCheckProgressTask;
    private VideoView mCustomVideoView;
    private FrameLayout mCustomView;
    private android.webkit.WebChromeClient.CustomViewCallback mCustomViewCallback;
    private ResourceHandler mHandler;
    protected boolean mInterstitialAutocloseReset;
    private FrameLayout mLoadingView;
    private MediaController mMediaController;
    android.view.View.OnClickListener mOnInterstitialSkipListener;
    SDKVideoView.OnTimeEventListener mOnVideoCanCloseEventListener;
    android.view.View.OnClickListener mOnVideoClickListener;
    android.media.MediaPlayer.OnCompletionListener mOnVideoCompletionListener;
    android.media.MediaPlayer.OnErrorListener mOnVideoErrorListener;
    android.media.MediaPlayer.OnInfoListener mOnVideoInfoListener;
    MediaController.OnPauseListener mOnVideoPauseListener;
    android.media.MediaPlayer.OnPreparedListener mOnVideoPreparedListener;
    MediaController.OnReplayListener mOnVideoReplayListener;
    android.view.View.OnClickListener mOnVideoSkipListener;
    SDKVideoView.OnStartListener mOnVideoStartListener;
    SDKVideoView.OnTimeEventListener mOnVideoTimeEventListener;
    MediaController.OnUnpauseListener mOnVideoUnpauseListener;
    private final android.view.View.OnClickListener mOverlayClickListener = new _cls2();
    private final SDKVideoView.OnTimeEventListener mOverlayShowListener = new _cls1();
    private WebFrame mOverlayView;
    private ResourceManager mResourceManager;
    private boolean mResult;
    private FrameLayout mRootLayout;
    private ImageView mSkipButton;
    protected int mTimeTest;
    private int mType;
    private VideoData mVideoData;
    private int mVideoHeight;
    private int mVideoLastPosition;
    private FrameLayout mVideoLayout;
    private Timer mVideoTimeoutTimer;
    private SDKVideoView mVideoView;
    private int mVideoWidth;
    private WebFrame mWebBrowserView;
    private int mWindowHeight;
    private int mWindowWidth;
    int marginArg;
    DisplayMetrics metrics;
    int paddingArg;
    int skipButtonSizeLand;
    int skipButtonSizePort;
    private Uri uri;

    public RichMediaActivity()
    {
        paddingArg = 5;
        marginArg = 8;
        skipButtonSizeLand = 40;
        skipButtonSizePort = 40;
        mOnVideoErrorListener = new _cls3();
        mOnVideoInfoListener = new _cls4();
        mCheckProgressTask = new _cls5();
        mOnVideoPreparedListener = new _cls6();
        mOnVideoClickListener = new _cls7();
        mOnVideoCompletionListener = new _cls8();
        mOnVideoStartListener = new _cls9();
        mOnVideoPauseListener = new _cls10();
        mOnVideoUnpauseListener = new _cls11();
        mOnVideoTimeEventListener = new _cls12();
        mOnVideoCanCloseEventListener = new _cls13();
        mOnVideoSkipListener = new _cls14();
        mOnVideoReplayListener = new _cls15();
        mOnInterstitialSkipListener = new _cls16();
    }

    private AdListener createLocalAdListener()
    {
        return new _cls17();
    }

    private com.adsdk.sdk.mraid.MraidView.MraidListener createMraidListener()
    {
        return new _cls18();
    }

    private void initInterstitialFromBannerView()
    {
        int i = 320;
        FrameLayout framelayout = new FrameLayout(this);
        int k;
        if (mAd.getType() == 1 || mAd.getType() == 0)
        {
            float f = getResources().getDisplayMetrics().density;
            int j;
            BannerAdView banneradview;
            MraidView mraidview;
            android.widget.FrameLayout.LayoutParams layoutparams;
            int l;
            if (mAd.isHorizontalOrientationRequested())
            {
                j = 480;
            } else
            {
                j = i;
                i = 480;
            }
            banneradview = new BannerAdView(this, mAd, j, i, false, createLocalAdListener());
            banneradview.setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)(0.5F + f * (float)j), (int)(0.5F + f * (float)i), 17));
            framelayout.addView(banneradview);
        }
        if (mAd.getType() == 4)
        {
            mraidview = new MraidView(this);
            framelayout.addView(mraidview, new android.widget.FrameLayout.LayoutParams(-1, -1));
            mraidview.setMraidListener(createMraidListener());
            mraidview.loadHtmlData(mAd.getText());
        }
        mSkipButton = new ImageView(this);
        mSkipButton.setAdjustViewBounds(false);
        if (mAd.isHorizontalOrientationRequested())
        {
            k = (int)TypedValue.applyDimension(1, skipButtonSizeLand, getResources().getDisplayMetrics());
        } else
        {
            k = (int)TypedValue.applyDimension(1, skipButtonSizePort, getResources().getDisplayMetrics());
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(k, k, 53);
        l = (int)TypedValue.applyDimension(1, 8F, getResources().getDisplayMetrics());
        layoutparams.topMargin = l;
        layoutparams.rightMargin = l;
        mSkipButton.setImageDrawable(mResourceManager.getResource(this, -18));
        mSkipButton.setOnClickListener(mOnInterstitialSkipListener);
        mCanClose = true;
        mSkipButton.setVisibility(0);
        framelayout.addView(mSkipButton, layoutparams);
        mRootLayout.addView(framelayout);
    }

    private void initRootLayout()
    {
        mRootLayout = new FrameLayout(this);
        mRootLayout.setBackgroundColor(0xff000000);
    }

    private void initVideoView()
    {
        Iterator iterator;
        mVideoData = mAd.getVideoData();
        setRequestedOrientation(mVideoData.orientation);
        if (mVideoData.orientation == 0)
        {
            if (mWindowWidth < mWindowHeight)
            {
                int j1 = mWindowWidth;
                mWindowWidth = mWindowHeight;
                mWindowHeight = j1;
            }
        } else
        if (mWindowHeight < mWindowWidth)
        {
            int i = mWindowHeight;
            mWindowHeight = mWindowWidth;
            mWindowWidth = i;
        }
        mVideoWidth = mVideoData.width;
        mVideoHeight = mVideoData.height;
        if (mVideoWidth <= 0)
        {
            mVideoWidth = mWindowWidth;
            mVideoHeight = mWindowHeight;
        } else
        {
            DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
            mVideoWidth = (int)TypedValue.applyDimension(1, mVideoWidth, displaymetrics);
            mVideoHeight = (int)TypedValue.applyDimension(1, mVideoHeight, displaymetrics);
            if (mVideoWidth > mWindowWidth)
            {
                mVideoWidth = mWindowWidth;
            }
            if (mVideoHeight > mWindowHeight)
            {
                mVideoHeight = mWindowHeight;
            }
        }
        Log.d((new StringBuilder("Video size (")).append(mVideoWidth).append(",").append(mVideoHeight).append(")").toString());
        mVideoLayout = new FrameLayout(this);
        mVideoView = new SDKVideoView(this, mVideoWidth, mVideoHeight, mVideoData.display);
        mVideoLayout.addView(mVideoView, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        if (mVideoData.showHtmlOverlay)
        {
            mOverlayView = new WebFrame(this, false, false, false);
            mOverlayView.setEnableZoom(false);
            mOverlayView.setOnClickListener(mOverlayClickListener);
            mOverlayView.setBackgroundColor(0);
            if (mVideoData.showHtmlOverlayAfter > 0)
            {
                mOverlayView.setVisibility(8);
                mVideoView.setOnTimeEventListener(mVideoData.showHtmlOverlayAfter, mOverlayShowListener);
            }
            android.widget.FrameLayout.LayoutParams layoutparams;
            TextView textview;
            String s;
            int i1;
            float f;
            android.widget.FrameLayout.LayoutParams layoutparams2;
            if (mVideoData.htmlOverlayType == 0)
            {
                mOverlayView.loadUrl(mVideoData.htmlOverlayUrl);
            } else
            {
                mOverlayView.setMarkup(mVideoData.htmlOverlayMarkup);
            }
            f = getResources().getDisplayMetrics().density;
            layoutparams2 = new android.widget.FrameLayout.LayoutParams((int)(0.5F + f * (float)mVideoData.overlayWidth), (int)(0.5F + f * (float)mVideoData.overlayHeight));
            if (mVideoData.showBottomNavigationBar && mVideoData.showTopNavigationBar)
            {
                layoutparams2.bottomMargin = (int)(0.11874999999999999D * (double)mWindowWidth);
                layoutparams2.topMargin = (int)(0.11874999999999999D * (double)mWindowWidth);
                layoutparams2.gravity = 17;
            } else
            if (mVideoData.showBottomNavigationBar && !mVideoData.showTopNavigationBar)
            {
                layoutparams2.bottomMargin = (int)(0.11874999999999999D * (double)mWindowWidth);
                layoutparams2.gravity = 48;
            } else
            if (mVideoData.showTopNavigationBar && !mVideoData.showBottomNavigationBar)
            {
                layoutparams2.topMargin = (int)(0.11874999999999999D * (double)mWindowWidth);
                layoutparams2.gravity = 80;
            } else
            {
                layoutparams2.gravity = 81;
            }
            mVideoLayout.addView(mOverlayView, layoutparams2);
        }
        mMediaController = new MediaController(this, mVideoData);
        mVideoView.setMediaController(mMediaController);
        if (mVideoData.showNavigationBars)
        {
            mMediaController.toggle();
        }
        if (!mVideoData.pauseEvents.isEmpty())
        {
            mMediaController.setOnPauseListener(mOnVideoPauseListener);
        }
        if (!mVideoData.resumeEvents.isEmpty())
        {
            mMediaController.setOnUnpauseListener(mOnVideoUnpauseListener);
        }
        if (!mVideoData.replayEvents.isEmpty())
        {
            mMediaController.setOnReplayListener(mOnVideoReplayListener);
        }
        mVideoLayout.addView(mMediaController, new android.widget.FrameLayout.LayoutParams(-1, -1, 7));
        if (mVideoData.showSkipButton)
        {
            mSkipButton = new ImageView(this);
            mSkipButton.setAdjustViewBounds(false);
            int k;
            android.widget.FrameLayout.LayoutParams layoutparams1;
            if (mAd.isHorizontalOrientationRequested())
            {
                k = (int)TypedValue.applyDimension(1, skipButtonSizeLand, getResources().getDisplayMetrics());
            } else
            {
                k = (int)TypedValue.applyDimension(1, skipButtonSizePort, getResources().getDisplayMetrics());
            }
            layoutparams1 = new android.widget.FrameLayout.LayoutParams(k, k, 53);
            if (mVideoData.orientation == 1)
            {
                i1 = (int)TypedValue.applyDimension(1, 8F, getResources().getDisplayMetrics());
                layoutparams1.topMargin = i1;
                layoutparams1.rightMargin = i1;
            } else
            {
                int l = (int)TypedValue.applyDimension(1, 10F, getResources().getDisplayMetrics());
                layoutparams1.topMargin = l;
                layoutparams1.rightMargin = l;
            }
            if (mVideoData.skipButtonImage != null && mVideoData.skipButtonImage.length() > 0)
            {
                mResourceManager.fetchResource(this, mVideoData.skipButtonImage, -18);
            } else
            {
                mSkipButton.setImageDrawable(mResourceManager.getResource(this, -18));
            }
            mSkipButton.setOnClickListener(mOnVideoSkipListener);
            if (mVideoData.showSkipButtonAfter > 0)
            {
                mCanClose = false;
                mSkipButton.setVisibility(8);
            } else
            {
                mCanClose = true;
                mSkipButton.setVisibility(0);
            }
            mVideoLayout.addView(mSkipButton, layoutparams1);
        } else
        {
            mCanClose = false;
        }
        if (mVideoData.showSkipButtonAfter > 0)
        {
            mVideoView.setOnTimeEventListener(mVideoData.showSkipButtonAfter, mOnVideoCanCloseEventListener);
        }
        layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2, 17);
        mLoadingView = new FrameLayout(this);
        textview = new TextView(this);
        textview.setText(Const.LOADING);
        mLoadingView.addView(textview, layoutparams);
        mVideoLayout.addView(mLoadingView, new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        if (mVideoData.videoClickThrough != null)
        {
            mVideoView.setOnClickListener(mOnVideoClickListener);
        }
        mVideoView.setOnPreparedListener(mOnVideoPreparedListener);
        mVideoView.setOnCompletionListener(mOnVideoCompletionListener);
        mVideoView.setOnErrorListener(mOnVideoErrorListener);
        mVideoView.setOnInfoListener(mOnVideoInfoListener);
        if (!mVideoData.startEvents.isEmpty())
        {
            mVideoView.setOnStartListener(mOnVideoStartListener);
        }
        if (mVideoData.timeTrackingEvents.isEmpty()) goto _L2; else goto _L1
_L1:
        iterator = mVideoData.timeTrackingEvents.keySet().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        mVideoLastPosition = 0;
        s = mVideoData.videoUrl;
        mVideoView.setVideoPath(s);
        return;
_L3:
        int j = ((Integer)iterator.next()).intValue();
        mVideoView.setOnTimeEventListener(j, mOnVideoTimeEventListener);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void initWebBrowserView(boolean flag)
    {
        mWebBrowserView = new WebFrame(this, true, true, flag);
        mRootLayout.addView(mWebBrowserView);
    }

    private void notifyAdClicked()
    {
        AdManager.notifyAdClick(mAd);
    }

    private void setOrientation()
    {
        if (mAd.isHorizontalOrientationRequested())
        {
            setRequestedOrientation(6);
            return;
        } else
        {
            setRequestedOrientation(7);
            return;
        }
    }

    private void setOrientationOldApi()
    {
        if (mAd.isHorizontalOrientationRequested())
        {
            setRequestedOrientation(0);
            return;
        } else
        {
            setRequestedOrientation(1);
            return;
        }
    }

    private void trackClick(String s)
    {
        TrackEvent trackevent = new TrackEvent();
        trackevent.url = s;
        trackevent.timestamp = System.currentTimeMillis();
        TrackerService.requestTrack(trackevent);
    }

    public void finish()
    {
        if (mAd == null) goto _L2; else goto _L1
_L1:
        Log.d((new StringBuilder("Finish Activity type:")).append(mType).append(" ad Type:").append(mAd.getType()).toString());
        mType;
        JVM INSTR tableswitch 1 2: default 72
    //                   1 77
    //                   2 88;
           goto _L2 _L3 _L4
_L2:
        super.finish();
        return;
_L3:
        if (mAd.getType() != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        AdManager.closeRunningAd(mAd, mResult);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public int getDipSize(int i)
    {
        return (int)TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    public FrameLayout getRootLayout()
    {
        return mRootLayout;
    }

    public void goBack()
    {
        if (mCustomView == null) goto _L2; else goto _L1
_L1:
        Log.d("Closing custom view on back key pressed");
        onHideCustomView();
_L8:
        return;
_L2:
        mType;
        JVM INSTR tableswitch 0 2: default 48
    //                   0 49
    //                   1 54
    //                   2 64;
           goto _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_49;
_L3:
        return;
_L7:
        finish();
        return;
_L5:
        if (!mCanClose) goto _L8; else goto _L7
_L6:
        mResult = true;
        setResult(-1);
          goto _L7
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 100 100: default 24
    //                   100 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        switch (message.arg1)
        {
        default:
            return;

        case -18: 
            break;
        }
        if (mSkipButton != null)
        {
            mSkipButton.setImageDrawable(mResourceManager.getResource(this, -18));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void navigate(String s)
    {
        AdManager.notifyAdClick(mAd);
        switch (mType)
        {
        default:
            Intent intent = new Intent(this, com/adsdk/sdk/video/RichMediaActivity);
            intent.setData(Uri.parse(s));
            startActivity(intent);
            return;

        case 0: // '\0'
            mWebBrowserView.loadUrl(s);
            break;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        Log.d("RichMediaActivity onConfigurationChanged");
    }

    public void onCreate(Bundle bundle)
    {
        Bundle bundle1;
        Log.d("RichMediaActivity onCreate");
        super.onCreate(bundle);
        Intent intent;
        try
        {
            mResult = false;
            setResult(0);
            Window window = getWindow();
            window.setFlags(1024, 1024);
            requestWindowFeature(1);
            window.addFlags(512);
            Display display = getWindowManager().getDefaultDisplay();
            metrics = new DisplayMetrics();
            ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(metrics);
            mWindowWidth = display.getWidth();
            mWindowHeight = display.getHeight();
            window.clearFlags(512);
            Log.d((new StringBuilder("RichMediaActivity Window Size:(")).append(mWindowWidth).append(",").append(mWindowHeight).append(")").toString());
            setVolumeControlStream(3);
            mType = -1;
            intent = getIntent();
            bundle1 = intent.getExtras();
        }
        catch (Exception exception)
        {
            finish();
            return;
        }
        if (bundle1 == null) goto _L2; else goto _L1
_L1:
        if (bundle1.getSerializable("RICH_AD_DATA") != null) goto _L3; else goto _L2
_L2:
        uri = intent.getData();
        if (uri == null)
        {
            Log.d("url is null so do not load anything");
            finish();
            return;
        }
        mType = 0;
_L6:
        mHandler = new ResourceHandler();
        mResourceManager = new ResourceManager(this, mHandler);
        initRootLayout();
        if (mType != 0) goto _L5; else goto _L4
_L4:
        initWebBrowserView(true);
        mWebBrowserView.loadUrl(uri.toString());
_L15:
        setContentView(mRootLayout);
        Log.d("RichMediaActivity onCreate done");
        return;
_L3:
        requestWindowFeature(1);
          goto _L6
_L5:
        mAd = (AdResponse)bundle1.getSerializable("RICH_AD_DATA");
        mCanClose = false;
        mType = bundle1.getInt("RICH_AD_TYPE", -1);
        if (mType != -1) goto _L8; else goto _L7
_L7:
        mAd.getType();
        JVM INSTR tableswitch 0 4: default 400
    //                   0 449
    //                   1 449
    //                   2 400
    //                   3 441
    //                   4 449;
           goto _L8 _L9 _L9 _L8 _L10 _L9
_L8:
        mType;
        JVM INSTR tableswitch 1 2: default 489
    //                   1 428
    //                   2 476;
           goto _L11 _L12 _L13
_L11:
        if (true) goto _L15; else goto _L14
_L14:
_L12:
        Log.v("Type video");
        initVideoView();
          goto _L15
_L10:
        mType = 1;
          goto _L8
_L9:
        if (android.os.Build.VERSION.SDK_INT >= 9) goto _L17; else goto _L16
_L16:
        setOrientationOldApi();
_L18:
        mType = 2;
          goto _L8
_L17:
        setOrientation();
          goto _L18
_L13:
        Log.v("Type interstitial like banner");
        initInterstitialFromBannerView();
          goto _L15
    }

    protected void onDestroy()
    {
        mMediaController = null;
        mResourceManager.releaseInstance();
        if (mVideoView != null)
        {
            mVideoView.destroy();
        }
        Log.d("RichMediaActivity onDestroy");
        super.onDestroy();
        Log.d("RichMediaActivity onDestroy done");
    }

    public void onHideCustomView()
    {
        Log.d("onHideCustomView Hidding Custom View");
        if (mCustomView != null)
        {
            mCustomView.setVisibility(8);
            mCustomView = null;
            if (mCustomVideoView != null)
            {
                try
                {
                    Log.d("onHideCustomView stop video");
                    mCustomVideoView.stopPlayback();
                }
                catch (Exception exception)
                {
                    Log.d("Couldn't stop custom video view");
                }
                mCustomVideoView = null;
            }
        }
        Log.d("onHideCustomView calling callback");
        mCustomViewCallback.onCustomViewHidden();
        mRootLayout.setVisibility(0);
        setContentView(mRootLayout);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            goBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        Log.d("RichMediaActivity onPause");
        super.onPause();
        mType;
        JVM INSTR tableswitch 1 1: default 32
    //                   1 39;
           goto _L1 _L2
_L1:
        Log.d("RichMediaActivity onPause done");
        return;
_L2:
        mVideoLastPosition = mVideoView.getCurrentPosition();
        mVideoView.stopPlayback();
        mRootLayout.removeView(mVideoLayout);
        if (mVideoTimeoutTimer != null)
        {
            mVideoTimeoutTimer.cancel();
            mVideoTimeoutTimer = null;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onResume()
    {
        Log.d("RichMediaActivity onResume");
        super.onResume();
        mType;
        JVM INSTR tableswitch 1 1: default 32
    //                   1 39;
           goto _L1 _L2
_L1:
        Log.d("RichMediaActivity onResume done");
        return;
_L2:
        mRootLayout.addView(mVideoLayout);
        mVideoView.seekTo(mVideoLastPosition);
        mVideoView.start();
        if (mVideoTimeoutTimer == null)
        {
            VideoTimeoutTask videotimeouttask = new VideoTimeoutTask(this);
            mVideoTimeoutTimer = new Timer();
            mVideoTimeoutTimer.schedule(videotimeouttask, 0x124f80L);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        Log.d(" onShowCustomView");
        if (view instanceof FrameLayout)
        {
            mCustomView = (FrameLayout)view;
            mCustomViewCallback = customviewcallback;
            if (mCustomView.getFocusedChild() instanceof VideoView)
            {
                Log.d(" onShowCustomView Starting Video View");
                mCustomVideoView = (VideoView)mCustomView.getFocusedChild();
                mCustomVideoView.setOnCompletionListener(new _cls19());
                mCustomVideoView.start();
            }
            mRootLayout.setVisibility(8);
            mCustomView.setVisibility(0);
            setContentView(mCustomView);
        }
    }

    public void playVideo()
    {
        Log.d((new StringBuilder("RichMediaActivity play video:")).append(mType).toString());
        mType;
        JVM INSTR tableswitch 1 1: default 44
    //                   1 45;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (mMediaController != null)
        {
            mMediaController.replay();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void replayVideo()
    {
        if (mMediaController != null)
        {
            mMediaController.replay();
        }
    }















    private class _cls1
        implements SDKVideoView.OnTimeEventListener
    {

        final RichMediaActivity this$0;

        public void onTimeEvent(int i)
        {
            Log.d("ADSDK", (new StringBuilder("RichMediaActivity mOverlayShowListener show after:")).append(i).toString());
            if (mOverlayView != null)
            {
                mOverlayView.setVisibility(0);
                mOverlayView.requestLayout();
            }
        }

        _cls1()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final RichMediaActivity this$0;

        public void onClick(View view)
        {
            if (mVideoData.overlayClickThrough != null)
            {
                if (mVideoData.overlayClickTracking != null)
                {
                    trackClick(mVideoData.overlayClickTracking);
                }
                String s = mVideoData.overlayClickThrough.trim();
                AdManager.notifyAdClick(RichMediaActivity.this);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
                startActivity(intent);
            }
            Log.d("ADSDK", "RichMediaActivity mOverlayClickListener");
            if (mMediaController != null)
            {
                mMediaController.toggle();
            }
        }

        _cls2()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls3
        implements android.media.MediaPlayer.OnErrorListener
    {

        final RichMediaActivity this$0;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            Log.w((new StringBuilder("Cannot play video/ Error: ")).append(i).append(" Extra: ").append(j).toString());
            finish();
            return false;
        }

        _cls3()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls4
        implements android.media.MediaPlayer.OnInfoListener
    {

        final RichMediaActivity this$0;

        public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
        {
            Log.i((new StringBuilder("Info: ")).append(i).append(" Extra: ").append(j).toString());
            if (i == 703)
            {
                mTimeTest = mVideoView.getCurrentPosition();
                (new Handler()).postDelayed(mCheckProgressTask, 5000L);
            }
            return false;
        }

        _cls4()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final RichMediaActivity this$0;

        public void run()
        {
            Log.w("Video playback is being checked");
            if (mVideoView.getCurrentPosition() - mTimeTest <= 1)
            {
                Log.w("Video playback too slow. Ending");
                finish();
                return;
            } else
            {
                Log.w("Video playback has restarted");
                return;
            }
        }

        _cls5()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls6
        implements android.media.MediaPlayer.OnPreparedListener
    {

        final RichMediaActivity this$0;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            Log.d("ADSDK", "RichMediaActivity onPrepared MediaPlayer");
            if (mVideoTimeoutTimer != null)
            {
                mVideoTimeoutTimer.cancel();
                mVideoTimeoutTimer = null;
            }
            if (mLoadingView != null)
            {
                mLoadingView.setVisibility(8);
            }
            if (mVideoData.showNavigationBars)
            {
                mMediaController.setVisibility(0);
            }
            mVideoView.requestFocus();
        }

        _cls6()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls7
        implements android.view.View.OnClickListener
    {

        final RichMediaActivity this$0;

        public void onClick(View view)
        {
            if (mVideoData.videoClickThrough == null) goto _L2; else goto _L1
_L1:
            if (mVideoData.videoClickTracking == null) goto _L4; else goto _L3
_L3:
            Iterator iterator = mVideoData.videoClickTracking.iterator();
_L7:
            if (iterator.hasNext()) goto _L5; else goto _L4
_L4:
            String s = mVideoData.videoClickThrough.trim();
            AdManager.notifyAdClick(RichMediaActivity.this);
            mOnVideoCanCloseEventListener.onTimeEvent(0);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            startActivity(intent);
_L2:
            return;
_L5:
            String s1 = (String)iterator.next();
            trackClick(s1);
            if (true) goto _L7; else goto _L6
_L6:
        }

        _cls7()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls8
        implements android.media.MediaPlayer.OnCompletionListener
    {

        final RichMediaActivity this$0;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            Log.d("###########TRACKING END VIDEO");
            Vector vector = mVideoData.completeEvents;
            int i = 0;
            do
            {
                if (i >= vector.size())
                {
                    mResult = true;
                    setResult(-1);
                    finish();
                    return;
                }
                Log.d((new StringBuilder("Track url:")).append((String)vector.get(i)).toString());
                TrackEvent trackevent = new TrackEvent();
                trackevent.url = (String)vector.get(i);
                trackevent.timestamp = System.currentTimeMillis();
                TrackerService.requestTrack(trackevent);
                i++;
            } while (true);
        }

        _cls8()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls9
        implements SDKVideoView.OnStartListener
    {

        final RichMediaActivity this$0;

        public void onVideoStart()
        {
            Log.d("###########TRACKING START VIDEO");
            Vector vector = mVideoData.startEvents;
            vector.addAll(mVideoData.impressionEvents);
            int i = 0;
            do
            {
                if (i >= vector.size())
                {
                    vector.clear();
                    mVideoData.impressionEvents.clear();
                    return;
                }
                Log.d((new StringBuilder("Track url:")).append((String)vector.get(i)).toString());
                TrackEvent trackevent = new TrackEvent();
                trackevent.url = (String)vector.get(i);
                trackevent.timestamp = System.currentTimeMillis();
                TrackerService.requestTrack(trackevent);
                i++;
            } while (true);
        }

        _cls9()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls10
        implements MediaController.OnPauseListener
    {

        final RichMediaActivity this$0;

        public void onVideoPause()
        {
            Log.d("###########TRACKING PAUSE VIDEO");
            Vector vector = mVideoData.pauseEvents;
            int i = 0;
            do
            {
                if (i >= vector.size())
                {
                    return;
                }
                Log.d((new StringBuilder("Track url:")).append((String)vector.get(i)).toString());
                TrackEvent trackevent = new TrackEvent();
                trackevent.url = (String)vector.get(i);
                trackevent.timestamp = System.currentTimeMillis();
                TrackerService.requestTrack(trackevent);
                i++;
            } while (true);
        }

        _cls10()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls11
        implements MediaController.OnUnpauseListener
    {

        final RichMediaActivity this$0;

        public void onVideoUnpause()
        {
            Log.d("###########TRACKING UNPAUSE VIDEO");
            Vector vector = mVideoData.resumeEvents;
            int i = 0;
            do
            {
                if (i >= vector.size())
                {
                    return;
                }
                Log.d((new StringBuilder("Track url:")).append((String)vector.get(i)).toString());
                TrackEvent trackevent = new TrackEvent();
                trackevent.url = (String)vector.get(i);
                trackevent.timestamp = System.currentTimeMillis();
                TrackerService.requestTrack(trackevent);
                i++;
            } while (true);
        }

        _cls11()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls12
        implements SDKVideoView.OnTimeEventListener
    {

        final RichMediaActivity this$0;

        public void onTimeEvent(int i)
        {
            Vector vector;
            Log.d((new StringBuilder("###########TRACKING TIME VIDEO:")).append(i).toString());
            vector = (Vector)mVideoData.timeTrackingEvents.get(Integer.valueOf(i));
            if (vector == null) goto _L2; else goto _L1
_L1:
            int j = 0;
_L5:
            if (j < vector.size()) goto _L3; else goto _L2
_L2:
            return;
_L3:
            Log.d((new StringBuilder("Track url:")).append((String)vector.get(j)).toString());
            TrackEvent trackevent = new TrackEvent();
            trackevent.url = (String)vector.get(j);
            trackevent.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(trackevent);
            j++;
            if (true) goto _L5; else goto _L4
_L4:
        }

        _cls12()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls13
        implements SDKVideoView.OnTimeEventListener
    {

        final RichMediaActivity this$0;

        public void onTimeEvent(int i)
        {
            Log.d((new StringBuilder("###########CAN CLOSE VIDEO:")).append(i).toString());
            mCanClose = true;
            if (mSkipButton.getVisibility() != 0 && mVideoData.showSkipButton && mSkipButton != null)
            {
                mSkipButton.setImageDrawable(mResourceManager.getResource(RichMediaActivity.this, -18));
                mSkipButton.setVisibility(0);
            }
        }

        _cls13()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls14
        implements android.view.View.OnClickListener
    {

        final RichMediaActivity this$0;

        public void onClick(View view)
        {
            Log.v("###########TRACKING SKIP VIDEO");
            Vector vector = mVideoData.skipEvents;
            int i = 0;
            do
            {
                if (i >= vector.size())
                {
                    finish();
                    return;
                }
                Log.d((new StringBuilder("Track url:")).append((String)vector.get(i)).toString());
                TrackEvent trackevent = new TrackEvent();
                trackevent.url = (String)vector.get(i);
                trackevent.timestamp = System.currentTimeMillis();
                TrackerService.requestTrack(trackevent);
                i++;
            } while (true);
        }

        _cls14()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls15
        implements MediaController.OnReplayListener
    {

        final RichMediaActivity this$0;

        public void onVideoReplay()
        {
            Log.d("###########TRACKING REPLAY VIDEO");
            Vector vector = mVideoData.replayEvents;
            int i = 0;
            do
            {
                if (i >= vector.size())
                {
                    return;
                }
                Log.d((new StringBuilder("Track url:")).append((String)vector.get(i)).toString());
                TrackEvent trackevent = new TrackEvent();
                trackevent.url = (String)vector.get(i);
                trackevent.timestamp = System.currentTimeMillis();
                TrackerService.requestTrack(trackevent);
                i++;
            } while (true);
        }

        _cls15()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls16
        implements android.view.View.OnClickListener
    {

        final RichMediaActivity this$0;

        public void onClick(View view)
        {
            Log.v("###########TRACKING SKIP INTERSTITIAL");
            mResult = true;
            setResult(-1);
            finish();
        }

        _cls16()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls17
        implements AdListener
    {

        final RichMediaActivity this$0;

        public void adClicked()
        {
            AdManager.notifyAdClick(RichMediaActivity.this);
        }

        public void adClosed(Ad ad, boolean flag)
        {
        }

        public void adLoadSucceeded(Ad ad)
        {
        }

        public void adShown(Ad ad, boolean flag)
        {
        }

        public void noAdFound()
        {
        }

        _cls17()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class _cls18
        implements com.adsdk.sdk.mraid.MraidView.MraidListener
    {

        final RichMediaActivity this$0;

        public void onClose(MraidView mraidview, com.adsdk.sdk.mraid.MraidView.ViewState viewstate)
        {
        }

        public void onExpand(MraidView mraidview)
        {
            AdManager.notifyAdClick(RichMediaActivity.this);
        }

        public void onFailure(MraidView mraidview)
        {
        }

        public void onReady(MraidView mraidview)
        {
        }

        _cls18()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }


    private class ResourceHandler extends Handler
    {

        WeakReference richMediaActivity;

        public void handleMessage(Message message)
        {
            RichMediaActivity richmediaactivity = (RichMediaActivity)richMediaActivity.get();
            if (richmediaactivity != null)
            {
                richmediaactivity.handleMessage(message);
            }
        }

        public ResourceHandler()
        {
            richMediaActivity = new WeakReference(RichMediaActivity.this);
        }
    }


    private class VideoTimeoutTask extends TimerTask
    {

        private final Activity mActivity;
        final RichMediaActivity this$0;

        public void run()
        {
            Log.v("###########TRACKING VIDEO TIMEOUT");
            class _cls1
                implements Runnable
            {

                final VideoTimeoutTask this$1;

                public void run()
                {
                    mActivity.finish();
                }

                _cls1()
                {
                    this$1 = VideoTimeoutTask.this;
                    super();
                }
            }

            mActivity.runOnUiThread(new _cls1());
        }


        public VideoTimeoutTask(Activity activity)
        {
            this$0 = RichMediaActivity.this;
            super();
            mActivity = activity;
        }
    }


    private class _cls19
        implements android.media.MediaPlayer.OnCompletionListener
    {

        final RichMediaActivity this$0;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            Log.d(" onCompletion Video");
            onHideCustomView();
        }

        _cls19()
        {
            this$0 = RichMediaActivity.this;
            super();
        }
    }

}
