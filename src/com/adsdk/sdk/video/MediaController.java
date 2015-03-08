// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adsdk.sdk.Log;
import java.util.Formatter;
import java.util.Locale;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            ResourceManager, VideoData, AspectRatioImageViewWidth, NavIconData, 
//            NavIcon, AutoResizeTextView

public class MediaController extends FrameLayout
{

    private static final int DEFAULT_TIMEOUT = 5000;
    private static final int FADE_OUT = 1;
    private static final int SHOW_PROGRESS = 2;
    private double buttonWidthPercent;
    private LinearLayout mBottomBar;
    private Context mContext;
    private boolean mFixed;
    StringBuilder mFormatBuilder;
    Formatter mFormatter;
    private ResourceHandler mHandler;
    private TextView mLeftTime;
    private OnPauseListener mOnPauseListener;
    private OnReplayListener mOnReplayListener;
    private OnUnpauseListener mOnUnpauseListener;
    private AspectRatioImageViewWidth mPauseButton;
    private android.view.View.OnClickListener mPauseListener;
    private android.widget.MediaPlayerControl mPlayer;
    private AspectRatioImageViewWidth mReplayButton;
    private android.view.View.OnClickListener mReplayListener;
    private ResourceManager mResourceManager;
    private boolean mShowing;
    private LinearLayout mTopBar;
    private VideoData mVideoData;

    public MediaController(Context context, VideoData videodata)
    {
        super(context);
        buttonWidthPercent = 0.089999999999999997D;
        mHandler = new ResourceHandler();
        mPauseListener = new _cls1();
        mReplayListener = new _cls2();
        setVisibility(8);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        mShowing = false;
        mFixed = false;
        mContext = context;
        mVideoData = videodata;
        if (mVideoData == null)
        {
            throw new IllegalArgumentException("Video info cannot be null");
        } else
        {
            mFormatBuilder = new StringBuilder();
            mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
            mResourceManager = new ResourceManager(mContext, mHandler);
            buildNavigationBarView(displaymetrics);
            Log.d("MediaController created");
            return;
        }
    }

    private void doPauseResume()
    {
        if (mPlayer == null)
        {
            return;
        }
        if (!mPlayer.isPlaying()) goto _L2; else goto _L1
_L1:
        mPlayer.pause();
        if (mOnPauseListener != null)
        {
            mOnPauseListener.onVideoPause();
        }
_L4:
        updatePausePlay();
        return;
_L2:
        mPlayer.start();
        if (mOnUnpauseListener != null)
        {
            mOnUnpauseListener.onVideoUnpause();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void handleMessage(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 3: default 40
    //                   1: 41
    //                   2: 46
    //                   100: 51;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        hide();
        return;
_L3:
        refreshProgress();
        return;
_L4:
        message.arg1;
        JVM INSTR lookupswitch 5: default 104
    //                   -13: 208
    //                   -12: 194
    //                   -11: 180
    //                   -2: 144
    //                   -1: 109;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        requestLayout();
        return;
_L10:
        if (mTopBar != null)
        {
            android.graphics.drawable.Drawable drawable1 = mResourceManager.getResource(mContext, -1);
            if (drawable1 != null)
            {
                mTopBar.setBackgroundDrawable(drawable1);
            }
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (mBottomBar != null)
        {
            android.graphics.drawable.Drawable drawable = mResourceManager.getResource(mContext, -2);
            if (drawable != null)
            {
                mBottomBar.setBackgroundDrawable(drawable);
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (mPauseButton != null)
        {
            updatePausePlay();
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (mPauseButton != null)
        {
            updatePausePlay();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (mReplayButton != null)
        {
            updateReplay();
        }
        if (true) goto _L5; else goto _L11
_L11:
    }

    private void initNavigationBarControllerView(int i, DisplayMetrics displaymetrics)
    {
        int j = displaymetrics.widthPixels;
        if (!mVideoData.showBottomNavigationBar)
        {
            mBottomBar.setVisibility(8);
        } else
        {
            mBottomBar.setVisibility(0);
            if (mVideoData.bottomNavigationBarBackground != null && mVideoData.bottomNavigationBarBackground.length() > 0)
            {
                mResourceManager.fetchResource(mContext, mVideoData.bottomNavigationBarBackground, -2);
            } else
            {
                mBottomBar.setBackgroundDrawable(mResourceManager.getResource(mContext, -2));
            }
            if (mPauseButton != null)
            {
                int k;
                NavIconData navicondata;
                NavIcon navicon;
                android.widget.LinearLayout.LayoutParams layoutparams;
                if (mVideoData.pauseButtonImage != null && mVideoData.pauseButtonImage.length() > 0)
                {
                    mPauseButton.setBackgroundDrawable(null);
                    mResourceManager.fetchResource(mContext, mVideoData.pauseButtonImage, -12);
                } else
                {
                    mPauseButton.setImageDrawable(mResourceManager.getResource(mContext, -12));
                }
                if (mVideoData.playButtonImage != null && mVideoData.playButtonImage.length() > 0)
                {
                    mResourceManager.fetchResource(mContext, mVideoData.playButtonImage, -11);
                }
                mPauseButton.setOnClickListener(mPauseListener);
                if (mVideoData.showPauseButton)
                {
                    mPauseButton.setVisibility(0);
                } else
                {
                    mPauseButton.setVisibility(8);
                }
            }
            if (mReplayButton != null)
            {
                if (mVideoData.replayButtonImage != null && mVideoData.replayButtonImage.length() > 0)
                {
                    mReplayButton.setImageDrawable(null);
                    mResourceManager.fetchResource(mContext, mVideoData.replayButtonImage, -13);
                } else
                {
                    mReplayButton.setImageDrawable(mResourceManager.getResource(mContext, -13));
                }
                mReplayButton.setOnClickListener(mReplayListener);
                if (mVideoData.showReplayButton)
                {
                    mReplayButton.setVisibility(0);
                } else
                {
                    mReplayButton.setVisibility(8);
                }
            }
            if (mLeftTime != null)
            {
                if (mVideoData.showTimer)
                {
                    mLeftTime.setVisibility(0);
                } else
                {
                    mLeftTime.setVisibility(8);
                }
            }
            if (!mVideoData.icons.isEmpty())
            {
                k = 0;
                while (k < mVideoData.icons.size()) 
                {
                    navicondata = (NavIconData)mVideoData.icons.get(k);
                    navicon = new NavIcon(mContext, navicondata);
                    layoutparams = new android.widget.LinearLayout.LayoutParams((int)((double)j * buttonWidthPercent), (int)((double)j * buttonWidthPercent));
                    mBottomBar.addView(navicon, layoutparams);
                    k++;
                }
            }
        }
        if (!mVideoData.showTopNavigationBar)
        {
            mTopBar.setVisibility(8);
        } else
        {
            mTopBar.setVisibility(0);
            if (mVideoData.topNavigationBarBackground != null && mVideoData.topNavigationBarBackground.length() > 0)
            {
                mResourceManager.fetchResource(mContext, mVideoData.topNavigationBarBackground, -1);
            } else
            {
                mTopBar.setBackgroundDrawable(mResourceManager.getResource(mContext, -1));
            }
        }
        if (!mVideoData.showNavigationBars)
        {
            setVisibility(8);
        }
    }

    private void refreshProgress()
    {
        if (mShowing)
        {
            updatePausePlay();
            int i = setProgress();
            if (mPlayer != null && mPlayer.isPlaying())
            {
                mHandler.removeMessages(2);
                Message message = mHandler.obtainMessage(2);
                mHandler.sendMessageDelayed(message, 1000 - i % 1000);
            }
        }
    }

    private int setProgress()
    {
        int i;
        if (mPlayer == null)
        {
            i = 0;
        } else
        {
            i = mPlayer.getCurrentPosition();
            int j = mPlayer.getDuration() - i;
            if (mLeftTime != null)
            {
                mLeftTime.setText(stringForTime(j));
                return i;
            }
        }
        return i;
    }

    private String stringForTime(int i)
    {
        int j = i / 1000;
        int k = j % 60;
        int l = (j / 60) % 60;
        int i1 = j / 3600;
        mFormatBuilder.setLength(0);
        if (i1 > 0)
        {
            Formatter formatter2 = mFormatter;
            Object aobj2[] = new Object[3];
            aobj2[0] = Integer.valueOf(i1);
            aobj2[1] = Integer.valueOf(l);
            aobj2[2] = Integer.valueOf(k);
            return formatter2.format("%d:%02d:%02d", aobj2).toString();
        }
        if (l > 0)
        {
            Formatter formatter1 = mFormatter;
            Object aobj1[] = new Object[2];
            aobj1[0] = Integer.valueOf(l);
            aobj1[1] = Integer.valueOf(k);
            return formatter1.format("%02d:%02d", aobj1).toString();
        } else
        {
            Formatter formatter = mFormatter;
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(k);
            return formatter.format("0:%02d", aobj).toString();
        }
    }

    private void updatePausePlay()
    {
        if (mPauseButton == null)
        {
            return;
        }
        if (mPlayer != null && mPlayer.isPlaying())
        {
            if (mResourceManager.containsResource(-12))
            {
                android.graphics.drawable.Drawable drawable2 = mResourceManager.getResource(mContext, -12);
                mPauseButton.setImageDrawable(drawable2);
                return;
            } else
            {
                android.graphics.drawable.Drawable drawable1 = mResourceManager.getResource(mContext, -12);
                mPauseButton.setImageDrawable(drawable1);
                return;
            }
        } else
        {
            mResourceManager.containsResource(-11);
            android.graphics.drawable.Drawable drawable = mResourceManager.getResource(mContext, -11);
            mPauseButton.setImageDrawable(drawable);
            return;
        }
    }

    private void updateReplay()
    {
        if (mReplayButton == null)
        {
            return;
        } else
        {
            mResourceManager.containsResource(-13);
            android.graphics.drawable.Drawable drawable = mResourceManager.getResource(mContext, -13);
            mReplayButton.setImageDrawable(drawable);
            return;
        }
    }

    protected void buildNavigationBarView(DisplayMetrics displaymetrics)
    {
        int i = displaymetrics.widthPixels;
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        mTopBar = new LinearLayout(mContext);
        mTopBar.setOrientation(0);
        mTopBar.setWeightSum(1.0F);
        mTopBar.setBackgroundColor(0);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, (int)(0.11899999999999999D * (double)i));
        layoutparams.gravity = 55;
        mTopBar.setGravity(16);
        int j = (int)TypedValue.applyDimension(1, 5F, getResources().getDisplayMetrics());
        addView(mTopBar, layoutparams);
        mBottomBar = new LinearLayout(mContext);
        mBottomBar.setOrientation(0);
        mBottomBar.setGravity(16);
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, (int)(0.11899999999999999D * (double)i));
        layoutparams1.gravity = 80;
        mBottomBar.setWeightSum(1.0F);
        mBottomBar.setPadding(j, 0, j, 0);
        mBottomBar.setBackgroundColor(0);
        addView(mBottomBar, layoutparams1);
        LinearLayout linearlayout = new LinearLayout(mContext);
        (new android.widget.LinearLayout.LayoutParams(-2, -1)).gravity = 3;
        linearlayout.setOrientation(0);
        linearlayout.setGravity(16);
        linearlayout.setBackgroundColor(0xff00ff00);
        mReplayButton = new AspectRatioImageViewWidth(mContext);
        android.widget.LinearLayout.LayoutParams layoutparams2 = new android.widget.LinearLayout.LayoutParams((int)((double)i * buttonWidthPercent), (int)((double)i * buttonWidthPercent));
        layoutparams2.gravity = 16;
        mReplayButton.setAdjustViewBounds(true);
        mReplayButton.setPadding(j, j, j, j);
        mBottomBar.addView(mReplayButton, layoutparams2);
        mPauseButton = new AspectRatioImageViewWidth(mContext);
        android.widget.LinearLayout.LayoutParams layoutparams3 = new android.widget.LinearLayout.LayoutParams((int)((double)i * buttonWidthPercent), (int)((double)i * buttonWidthPercent));
        layoutparams3.gravity = 16;
        mPauseButton.setPadding(j, j, j, j);
        mPauseButton.setAdjustViewBounds(true);
        mBottomBar.addView(mPauseButton, layoutparams3);
        mLeftTime = new AutoResizeTextView(mContext);
        android.widget.LinearLayout.LayoutParams layoutparams4 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams4.gravity = 16;
        mLeftTime.setTypeface(Typeface.defaultFromStyle(1));
        mLeftTime.setPadding(j, j, j, j);
        mLeftTime.setGravity(16);
        mLeftTime.setTextSize(23F);
        mBottomBar.addView(mLeftTime, layoutparams4);
        View view = new View(mContext);
        android.widget.LinearLayout.LayoutParams layoutparams5 = new android.widget.LinearLayout.LayoutParams(0, 0);
        layoutparams5.weight = 1.0F;
        layoutparams5.gravity = 16;
        mBottomBar.addView(view, layoutparams5);
        initNavigationBarControllerView(j, displaymetrics);
    }

    public boolean canToggle()
    {
        return mVideoData.allowTapNavigationBars;
    }

    public void hide()
    {
        Log.d("HIDE");
        mFixed = false;
        if (canToggle())
        {
            Log.d("Hide can toggle");
            if (mShowing)
            {
                Log.d("Hide change visibility");
                mHandler.removeMessages(2);
                setVisibility(8);
                mShowing = false;
            }
        }
    }

    public boolean isShowing()
    {
        return mShowing;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i != 4 && i != 24 && i != 25 && i != 82 && i != 5 && i != 6)
        {
            if (i == 79 || i == 85)
            {
                doPauseResume();
                return true;
            }
            if (i == 86 && mPlayer != null && mPlayer.isPlaying())
            {
                mPlayer.pause();
                if (mOnPauseListener != null)
                {
                    mOnPauseListener.onVideoPause();
                }
            } else
            {
                toggle();
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onPause()
    {
        show(0);
    }

    public void onStart()
    {
        refreshProgress();
    }

    public void replay()
    {
        if (mPlayer != null)
        {
            mPlayer.seekTo(0);
            mPlayer.start();
        }
        refreshProgress();
        if (mOnReplayListener != null)
        {
            mOnReplayListener.onVideoReplay();
        }
    }

    public void resizeTopBar(int i)
    {
        if (i > 0)
        {
            int j = (int)TypedValue.applyDimension(1, 4F, getResources().getDisplayMetrics());
            if (mTopBar != null)
            {
                android.view.ViewGroup.LayoutParams layoutparams = mTopBar.getLayoutParams();
                layoutparams.height = j + i;
                mTopBar.setLayoutParams(layoutparams);
                return;
            }
        }
    }

    public void setMediaPlayer(android.widget.MediaPlayerControl mediaplayercontrol)
    {
        mPlayer = mediaplayercontrol;
        updatePausePlay();
    }

    public void setOnPauseListener(OnPauseListener onpauselistener)
    {
        mOnPauseListener = onpauselistener;
    }

    public void setOnReplayListener(OnReplayListener onreplaylistener)
    {
        mOnReplayListener = onreplaylistener;
    }

    public void setOnUnpauseListener(OnUnpauseListener onunpauselistener)
    {
        mOnUnpauseListener = onunpauselistener;
    }

    public void show()
    {
        show(5000);
    }

    public void show(int i)
    {
        Log.d((new StringBuilder("SHOW:")).append(i).toString());
        if (i == 0)
        {
            mFixed = true;
        }
        if (!mShowing)
        {
            setVisibility(0);
            mShowing = true;
            Log.d("Change Visibility");
        }
        refreshProgress();
        mHandler.removeMessages(1);
        if (i != 0 && !mFixed)
        {
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessageDelayed(message, i);
        }
    }

    public void toggle()
    {
label0:
        {
            if (canToggle())
            {
                if (!mShowing)
                {
                    break label0;
                }
                hide();
            }
            return;
        }
        show();
    }



    private class ResourceHandler extends Handler
    {

        private final WeakReference mController;

        public void handleMessage(Message message)
        {
            MediaController mediacontroller = (MediaController)mController.get();
            if (mediacontroller != null)
            {
                mediacontroller.handleMessage(message);
            }
        }

        public ResourceHandler()
        {
            mController = new WeakReference(MediaController.this);
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final MediaController this$0;

        public void onClick(View view)
        {
            doPauseResume();
        }

        _cls1()
        {
            this$0 = MediaController.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final MediaController this$0;

        public void onClick(View view)
        {
            replay();
        }

        _cls2()
        {
            this$0 = MediaController.this;
            super();
        }
    }


    private class OnPauseListener
    {

        public abstract void onVideoPause();
    }


    private class OnUnpauseListener
    {

        public abstract void onVideoUnpause();
    }


    private class OnReplayListener
    {

        public abstract void onVideoReplay();
    }

}
