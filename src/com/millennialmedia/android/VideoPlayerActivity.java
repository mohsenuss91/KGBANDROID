// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity, MMActivity, HttpRedirection, VideoImage, 
//            AdProperties

class VideoPlayerActivity extends MMBaseActivity
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    private static final int CONTROLS_ID = 0x4fe0613;
    private static final String END_VIDEO = "endVideo";
    protected static final int MESSAGE_CHECK_PLAYING_VIDEO = 4;
    protected static final int MESSAGE_DELAYED_BUTTON = 3;
    protected static final int MESSAGE_INACTIVITY_ANIMATION = 1;
    protected static final int MESSAGE_ONE_SECOND_CHECK = 2;
    protected static final int MESSAGE_SET_TRANSPARENCY = 5;
    private static final String RESTART_VIDEO = "restartVideo";
    AdProperties adProperties;
    View blackView;
    protected int currentVideoPosition;
    protected boolean hasBottomBar;
    private boolean hasFocus;
    boolean isPaused;
    boolean isUserPausing;
    protected boolean isVideoCompleted;
    private boolean isVideoCompletedOnce;
    String lastOverlayOrientation;
    protected VideoView mVideoView;
    Button pausePlay;
    ProgressBar progBar;
    HttpRedirection.RedirectionListenerImpl redirectListenerImpl;
    private boolean shouldSetUri;
    Handler transparentHandler;
    RelativeLayout videoLayout;

    VideoPlayerActivity()
    {
        shouldSetUri = true;
        hasBottomBar = true;
        currentVideoPosition = 0;
        transparentHandler = new _cls6();
        isUserPausing = false;
    }

    private void initBottomBar(RelativeLayout relativelayout)
    {
        RelativeLayout relativelayout1 = new RelativeLayout(activity);
        relativelayout1.setId(0x4fe0613);
        relativelayout1.setBackgroundColor(0xff000000);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        relativelayout1.setLayoutParams(layoutparams);
        layoutparams.addRule(12);
        Button button = new Button(activity);
        pausePlay = new Button(activity);
        Button button1 = new Button(activity);
        button.setBackgroundResource(0x1080025);
        android.widget.RelativeLayout.LayoutParams layoutparams1;
        android.widget.RelativeLayout.LayoutParams layoutparams2;
        android.widget.RelativeLayout.LayoutParams layoutparams3;
        if (mVideoView.isPlaying())
        {
            pausePlay.setBackgroundResource(0x1080023);
        } else
        {
            pausePlay.setBackgroundResource(0x1080024);
        }
        button1.setBackgroundResource(0x1080038);
        layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams1.addRule(14);
        relativelayout1.addView(pausePlay, layoutparams1);
        layoutparams3.addRule(0, pausePlay.getId());
        relativelayout1.addView(button);
        layoutparams2.addRule(11);
        relativelayout1.addView(button1, layoutparams2);
        button.setOnClickListener(new _cls3());
        pausePlay.setOnClickListener(new _cls4());
        button1.setOnClickListener(new _cls5());
        relativelayout.addView(relativelayout1, layoutparams);
    }

    private void initRedirectListener()
    {
        redirectListenerImpl = new _cls1();
        redirectListenerImpl.creatorAdImplInternalId = activity.creatorAdImplInternalId;
    }

    private void initVideoListeners()
    {
        mVideoView.setOnCompletionListener(this);
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnErrorListener(this);
    }

    private void initWindow()
    {
        requestWindowFeature(1);
        getWindow().clearFlags(2048);
        getWindow().addFlags(1024);
    }

    private boolean isActionSupported(String s)
    {
        return s != null && (s.equalsIgnoreCase("restartVideo") || s.equalsIgnoreCase("endVideo"));
    }

    private boolean isActionable(Uri uri)
    {
        if (uri.getScheme().equalsIgnoreCase("mmsdk"))
        {
            if (isActionSupported(uri.getHost()))
            {
                return true;
            }
            MMSDK.Log.v("Unrecognized mmsdk:// URI %s.", new Object[] {
                uri
            });
        }
        return false;
    }

    private void makeTransparent()
    {
        if (!transparentHandler.hasMessages(4))
        {
            transparentHandler.sendEmptyMessage(4);
        }
    }

    private void startVideo(int i)
    {
        mVideoView.requestFocus();
        mVideoView.seekTo(i);
        if (((PowerManager)getSystemService("power")).isScreenOn())
        {
            if (progBar != null)
            {
                progBar.bringToFront();
                progBar.setVisibility(0);
            }
            if (pausePlay != null)
            {
                pausePlay.setBackgroundResource(0x1080023);
            }
            mVideoView.start();
            makeTransparent();
        }
    }

    protected boolean canFadeButtons()
    {
        return !isVideoCompleted;
    }

    protected void dismiss()
    {
        MMSDK.Log.d("Video ad player closed");
        if (mVideoView != null)
        {
            if (mVideoView.isPlaying())
            {
                mVideoView.stopPlayback();
            }
            mVideoView = null;
        }
        finish();
    }

    void dispatchButtonClick(String s)
    {
        if (s != null)
        {
            MMSDK.Log.d("Button Click with URL: %s", new Object[] {
                s
            });
            redirectListenerImpl.url = s;
            redirectListenerImpl.weakContext = new WeakReference(activity);
            if (!redirectListenerImpl.isHandlingMMVideo(Uri.parse(s)))
            {
                HttpRedirection.startActivityFromUri(redirectListenerImpl);
                return;
            }
        }
    }

    protected void enableButtons()
    {
    }

    protected void endVideo()
    {
        MMSDK.Log.d("End Video.");
        if (mVideoView != null)
        {
            shouldSetUri = true;
            dismiss();
        }
    }

    protected void errorPlayVideo(String s)
    {
        Toast.makeText(activity, "Sorry. There was a problem playing the video", 1).show();
        if (mVideoView != null)
        {
            mVideoView.stopPlayback();
        }
    }

    protected RelativeLayout initLayout()
    {
        RelativeLayout relativelayout = new RelativeLayout(activity);
        relativelayout.setId(400);
        relativelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        relativelayout.setBackgroundColor(0xff000000);
        videoLayout = new RelativeLayout(activity);
        videoLayout.setBackgroundColor(0xff000000);
        videoLayout.setId(410);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams1.addRule(13);
        layoutparams.addRule(13);
        mVideoView = new VideoView(activity);
        mVideoView.setId(411);
        mVideoView.getHolder().setFormat(-2);
        mVideoView.setBackgroundColor(0xff000000);
        initVideoListeners();
        videoLayout.addView(mVideoView, layoutparams1);
        blackView = new View(activity);
        blackView.setBackgroundColor(0xff000000);
        android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        relativelayout.addView(videoLayout, layoutparams);
        if (hasBottomBar)
        {
            layoutparams2.addRule(2, 0x4fe0613);
            initBottomBar(relativelayout);
        }
        blackView.setLayoutParams(layoutparams2);
        relativelayout.addView(blackView);
        progBar = new ProgressBar(activity);
        progBar.setIndeterminate(true);
        android.widget.RelativeLayout.LayoutParams layoutparams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams3.addRule(13);
        progBar.setLayoutParams(layoutparams3);
        relativelayout.addView(progBar);
        progBar.setVisibility(4);
        return relativelayout;
    }

    protected void initSavedInstance(Bundle bundle)
    {
        if (bundle != null)
        {
            isVideoCompleted = bundle.getBoolean("videoCompleted");
            isVideoCompletedOnce = bundle.getBoolean("videoCompletedOnce");
            currentVideoPosition = bundle.getInt("videoPosition");
            hasBottomBar = bundle.getBoolean("hasBottomBar");
            shouldSetUri = bundle.getBoolean("shouldSetUri");
        }
    }

    protected boolean isPlayable()
    {
        return mVideoView != null && !mVideoView.isPlaying() && !isVideoCompleted;
    }

    protected void logButtonEvent(VideoImage videoimage)
    {
        MMSDK.Log.d("Cached video button event logged");
        for (int i = 0; i < videoimage.eventLoggingUrls.length; i++)
        {
            MMSDK.Event.logEvent(videoimage.eventLoggingUrls[i]);
        }

    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        isVideoCompletedOnce = true;
        isVideoCompleted = true;
        if (pausePlay != null && !mVideoView.isPlaying())
        {
            pausePlay.setBackgroundResource(0x1080024);
        }
        MMSDK.Log.v("Video player on complete");
    }

    public void onCreate(Bundle bundle)
    {
        setTheme(0x1030005);
        super.onCreate(bundle);
        MMSDK.Log.d("Setting up the video player");
        initWindow();
        initSavedInstance(bundle);
        initRedirectListener();
        setContentView(initLayout());
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0 && !isVideoCompletedOnce)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onPause()
    {
        super.onPause();
        isPaused = true;
        MMSDK.Log.v("VideoPlayer - onPause");
        pauseVideo();
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        MMSDK.Log.d("Video Prepared");
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        currentVideoPosition = bundle.getInt("currentVideoPosition");
        isVideoCompleted = bundle.getBoolean("isVideoCompleted");
        isVideoCompletedOnce = bundle.getBoolean("isVideoCompletedOnce");
        hasBottomBar = bundle.getBoolean("hasBottomBar", hasBottomBar);
        shouldSetUri = bundle.getBoolean("shouldSetUri", shouldSetUri);
        isUserPausing = bundle.getBoolean("isUserPausing", isUserPausing);
        isPaused = bundle.getBoolean("isPaused", isPaused);
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        blackView.bringToFront();
        blackView.setVisibility(0);
        isPaused = false;
        MMSDK.Log.v("VideoPlayer - onResume");
        if (hasFocus && !isUserPausing)
        {
            resumeVideo();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("currentVideoPosition", currentVideoPosition);
        bundle.putBoolean("isVideoCompleted", isVideoCompleted);
        bundle.putBoolean("isVideoCompletedOnce", isVideoCompletedOnce);
        bundle.putBoolean("hasBottomBar", hasBottomBar);
        bundle.putBoolean("shouldSetUri", shouldSetUri);
        bundle.putBoolean("isUserPausing", isUserPausing);
        bundle.putBoolean("isPaused", isPaused);
        super.onSaveInstanceState(bundle);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        hasFocus = flag;
        if (!isPaused && flag && !isUserPausing)
        {
            resumeVideo();
        }
    }

    protected void pauseVideo()
    {
        if (mVideoView != null && mVideoView.isPlaying())
        {
            currentVideoPosition = mVideoView.getCurrentPosition();
            mVideoView.pause();
            MMSDK.Log.v("Video paused");
        }
    }

    protected void pauseVideoByUser()
    {
        isUserPausing = true;
        pauseVideo();
    }

    protected void playVideo(int i)
    {
        String s;
        try
        {
            isUserPausing = false;
            s = getIntent().getData().toString();
            MMSDK.Log.d("playVideo path: %s", new Object[] {
                s
            });
        }
        catch (Exception exception)
        {
            MMSDK.Log.e((new StringBuilder("error: ")).append(exception.getMessage()).toString(), new Object[] {
                exception
            });
            errorPlayVideo((new StringBuilder("error: ")).append(exception.getMessage()).toString());
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (s.length() != 0 && mVideoView != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        errorPlayVideo("no name or null videoview");
        return;
        isVideoCompleted = false;
        if (shouldSetUri && mVideoView != null)
        {
            mVideoView.setVideoURI(Uri.parse(s));
        }
        startVideo(i);
        return;
    }

    void processVideoPlayerUri(final String action)
    {
        runOnUiThread(new _cls2());
    }

    protected void restartVideo()
    {
        MMSDK.Log.d("Restart Video.");
        if (mVideoView != null)
        {
            playVideo(0);
        }
    }

    protected void resumeVideo()
    {
        if (isPlayable())
        {
            playVideo(currentVideoPosition);
        }
    }

    protected void setButtonAlpha(ImageButton imagebutton, float f)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(f, f);
        alphaanimation.setDuration(0L);
        alphaanimation.setFillEnabled(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillAfter(true);
        imagebutton.startAnimation(alphaanimation);
    }



/*
    static boolean access$102(VideoPlayerActivity videoplayeractivity, boolean flag)
    {
        videoplayeractivity.shouldSetUri = flag;
        return flag;
    }

*/

    private class _cls6 extends Handler
    {

        final VideoPlayerActivity this$0;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 4 5: default 28
        //                       4 29
        //                       5 108;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if (mVideoView != null && mVideoView.isPlaying() && mVideoView.getCurrentPosition() > 0)
            {
                mVideoView.setBackgroundColor(0);
                transparentHandler.sendEmptyMessageDelayed(5, 100L);
                return;
            } else
            {
                transparentHandler.sendEmptyMessageDelayed(4, 50L);
                return;
            }
_L3:
            if (mVideoView != null && mVideoView.isPlaying() && mVideoView.getCurrentPosition() > 0)
            {
                blackView.setVisibility(4);
                progBar.setVisibility(4);
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        _cls6()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final VideoPlayerActivity this$0;

        public void onClick(View view)
        {
            if (mVideoView != null)
            {
                mVideoView.seekTo(0);
            }
        }

        _cls3()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final VideoPlayerActivity this$0;

        public void onClick(View view)
        {
label0:
            {
                if (mVideoView != null)
                {
                    if (!mVideoView.isPlaying())
                    {
                        break label0;
                    }
                    pauseVideoByUser();
                    pausePlay.setBackgroundResource(0x1080024);
                }
                return;
            }
            if (isVideoCompleted)
            {
                playVideo(0);
            } else
            if (isUserPausing && !isVideoCompleted)
            {
                resumeVideo();
            } else
            {
                playVideo(currentVideoPosition);
            }
            pausePlay.setBackgroundResource(0x1080023);
        }

        _cls4()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final VideoPlayerActivity this$0;

        public void onClick(View view)
        {
            if (mVideoView != null)
            {
                shouldSetUri = true;
                dismiss();
            }
        }

        _cls5()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }
    }


    private class _cls1 extends HttpRedirection.RedirectionListenerImpl
    {

        final VideoPlayerActivity this$0;

        public JSONObject getAdProperties()
        {
            if (adProperties != null)
            {
                return adProperties.getAdProperties();
            } else
            {
                return null;
            }
        }

        public OverlaySettings getOverlaySettings()
        {
            String s = lastOverlayOrientation;
            OverlaySettings overlaysettings = null;
            if (s != null)
            {
                overlaysettings = new OverlaySettings();
                overlaysettings.orientation = lastOverlayOrientation;
            }
            return overlaysettings;
        }

        public boolean isHandlingMMVideo(Uri uri)
        {
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;

                public void run()
                {
                    enableButtons();
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
            }

            runOnUiThread(new _cls1());
            if (uri != null && isActionable(uri))
            {
                processVideoPlayerUri(uri.getHost());
                return true;
            } else
            {
                return false;
            }
        }

        _cls1()
        {
            this$0 = VideoPlayerActivity.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final VideoPlayerActivity this$0;
        final String val$action;

        public void run()
        {
            if (action.equalsIgnoreCase("restartVideo"))
            {
                restartVideo();
            } else
            if (action.equalsIgnoreCase("endVideo"))
            {
                endVideo();
                return;
            }
        }

        _cls2()
        {
            this$0 = VideoPlayerActivity.this;
            action = s;
            super();
        }
    }

}
