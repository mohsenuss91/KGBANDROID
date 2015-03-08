// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.ConditionVariable;
import android.os.Handler;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.adsdk.sdk.Log;
import java.io.IOException;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            MediaController

public class SDKVideoView extends SurfaceView
    implements android.widget.MediaController.MediaPlayerControl
{

    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private android.media.MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener;
    private android.media.MediaPlayer.OnCompletionListener mCompletionListener;
    private Context mContext;
    private int mCurrentBufferPercentage;
    private int mCurrentState;
    private int mDisplayMode;
    private int mDuration;
    private android.media.MediaPlayer.OnErrorListener mErrorListener;
    public Handler mHandler;
    private int mHeight;
    private android.media.MediaPlayer.OnInfoListener mInfoListener;
    private MediaController mMediaController;
    private MediaPlayer mMediaPlayer;
    private android.media.MediaPlayer.OnCompletionListener mOnCompletionListener;
    private android.media.MediaPlayer.OnErrorListener mOnErrorListener;
    private android.media.MediaPlayer.OnInfoListener mOnInfoListener;
    private android.media.MediaPlayer.OnPreparedListener mOnPreparedListener;
    private OnStartListener mOnStartListener;
    private boolean mPlayWhenSurfaceReady;
    android.media.MediaPlayer.OnPreparedListener mPreparedListener;
    android.view.SurfaceHolder.Callback mSHCallback;
    private int mSeekWhenPrepared;
    android.media.MediaPlayer.OnVideoSizeChangedListener mSizeChangedListener;
    private int mSurfaceHeight;
    private boolean mSurfaceReady;
    private int mSurfaceWidth;
    private int mTargetState;
    private SparseArray mTimeEventListeners;
    private Runnable mTimeEventRunnable;
    private Thread mTimeEventThread;
    private ConditionVariable mTimeEventThreadDone;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;
    private int mWidth;

    public SDKVideoView(Context context, int i, int j, int k)
    {
        super(context);
        mCurrentState = 0;
        mTargetState = 0;
        mMediaPlayer = null;
        mSurfaceReady = false;
        mTimeEventThreadDone = new ConditionVariable(false);
        mTimeEventListeners = new SparseArray();
        mSizeChangedListener = new _cls1();
        mPreparedListener = new _cls2();
        mCompletionListener = new _cls3();
        mErrorListener = new _cls4();
        mInfoListener = new _cls5();
        mBufferingUpdateListener = new _cls6();
        mSHCallback = new _cls7();
        mContext = context;
        mWidth = i;
        mHeight = j;
        mDisplayMode = k;
        initVideoView();
    }

    private void attachMediaController()
    {
        if (mMediaPlayer != null && mMediaController != null)
        {
            mMediaController.setMediaPlayer(this);
            mMediaController.setEnabled(isInPlaybackState());
        }
    }

    private void initVideoView()
    {
        mHandler = new Handler();
        mVideoWidth = 0;
        mVideoHeight = 0;
        mSurfaceWidth = 0;
        mSurfaceHeight = 0;
        mSurfaceReady = false;
        setVisibility(0);
        getHolder().addCallback(mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        mCurrentState = 0;
        mTargetState = 0;
    }

    private boolean isInPlaybackState()
    {
        return mMediaPlayer != null && mCurrentState != -1 && mCurrentState != 0 && mCurrentState != 1;
    }

    private void openVideo()
    {
        if (mUri == null)
        {
            return;
        }
        mPlayWhenSurfaceReady = false;
        if (!mSurfaceReady)
        {
            mPlayWhenSurfaceReady = true;
            Log.d("Open Video not starting until surface created");
            return;
        }
        release(false);
        try
        {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDisplay(getHolder());
            mMediaPlayer.setOnPreparedListener(mPreparedListener);
            mMediaPlayer.setOnVideoSizeChangedListener(mSizeChangedListener);
            mDuration = -1;
            mMediaPlayer.setOnCompletionListener(mCompletionListener);
            mMediaPlayer.setOnErrorListener(mErrorListener);
            mMediaPlayer.setOnBufferingUpdateListener(mBufferingUpdateListener);
            mMediaPlayer.setOnInfoListener(mInfoListener);
            mCurrentBufferPercentage = 0;
            mMediaPlayer.setDataSource(mContext, mUri);
            mMediaPlayer.setAudioStreamType(3);
            mMediaPlayer.setScreenOnWhilePlaying(true);
            mMediaPlayer.prepareAsync();
            mTimeEventRunnable = new _cls8();
            mTimeEventThread = new Thread(mTimeEventRunnable);
            mTimeEventThread.start();
            mCurrentState = 1;
            attachMediaController();
            return;
        }
        catch (IOException ioexception)
        {
            Log.w("ADSDK", (new StringBuilder("Unable to open content: ")).append(mUri).toString(), ioexception);
            mCurrentState = -1;
            mTargetState = -1;
            mErrorListener.onError(mMediaPlayer, 1, 0);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.w("ADSDK", (new StringBuilder("Unable to open content: ")).append(mUri).toString(), illegalargumentexception);
        }
        mCurrentState = -1;
        mTargetState = -1;
        mErrorListener.onError(mMediaPlayer, 1, 0);
    }

    private void release(boolean flag)
    {
        if (mMediaPlayer != null)
        {
            mCurrentState = 0;
            if (mTimeEventThread != null)
            {
                mTimeEventThreadDone.open();
                mTimeEventThread = null;
            }
            mMediaPlayer.reset();
            mMediaPlayer.release();
            mMediaPlayer = null;
            if (flag)
            {
                mTargetState = 0;
            }
        }
    }

    private void setVideoDisplaySize()
    {
        mVideoWidth = 0;
        mVideoHeight = 0;
        if (mMediaPlayer != null)
        {
            mVideoWidth = mMediaPlayer.getVideoWidth();
            mVideoHeight = mMediaPlayer.getVideoHeight();
        }
        Log.d((new StringBuilder("SDKVideoView setVideoDisplaySize View Size (")).append(mWidth).append(",").append(mHeight).append(") Video size (").append(mVideoWidth).append(",").append(mVideoHeight).append(") surface:(").append(mSurfaceWidth).append(",").append(mSurfaceHeight).append(")").toString());
        if (!mSurfaceReady || mVideoWidth <= 0 || mVideoHeight <= 0) goto _L2; else goto _L1
_L1:
        if (mDisplayMode != 1) goto _L4; else goto _L3
_L3:
        if (mVideoWidth * mHeight <= mWidth * mVideoHeight) goto _L6; else goto _L5
_L5:
        mHeight = (mWidth * mVideoHeight) / mVideoWidth;
_L4:
        getHolder().setFixedSize(mWidth, mHeight);
_L2:
        getHolder().setFixedSize(mVideoWidth, mVideoHeight);
        return;
_L6:
        if (mVideoWidth * mHeight < mWidth * mVideoHeight)
        {
            mWidth = (mHeight * mVideoWidth) / mVideoHeight;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void toggleMediaControlsVisiblity()
    {
        if (mMediaController != null)
        {
            mMediaController.toggle();
        }
    }

    public boolean canPause()
    {
        return true;
    }

    public boolean canSeekBackward()
    {
        return false;
    }

    public boolean canSeekForward()
    {
        return true;
    }

    public void destroy()
    {
        mTimeEventThreadDone.open();
    }

    public int getAudioSessionId()
    {
        if (mMediaPlayer != null)
        {
            return mMediaPlayer.getAudioSessionId();
        } else
        {
            return 0;
        }
    }

    public int getBufferPercentage()
    {
        if (mMediaPlayer != null)
        {
            return mCurrentBufferPercentage;
        } else
        {
            return 0;
        }
    }

    public int getCurrentPosition()
    {
        if (isInPlaybackState())
        {
            return mMediaPlayer.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public int getDuration()
    {
        if (isInPlaybackState())
        {
            if (mDuration > 0)
            {
                return mDuration;
            } else
            {
                mDuration = mMediaPlayer.getDuration();
                return mDuration;
            }
        } else
        {
            mDuration = -1;
            return mDuration;
        }
    }

    public boolean isPlaying()
    {
        return isInPlaybackState() && mMediaPlayer.isPlaying();
    }

    protected void onDetachedFromWindow()
    {
        Log.i("Video view detached from Window");
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag;
        if (i != 4 && i != 24 && i != 25 && i != 82 && i != 5 && i != 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isInPlaybackState() && flag && mMediaController != null)
        {
            if (i == 79 || i == 85)
            {
                if (mMediaPlayer.isPlaying())
                {
                    pause();
                    return true;
                } else
                {
                    start();
                    return true;
                }
            }
            if (i == 86 && mMediaPlayer.isPlaying())
            {
                pause();
            } else
            {
                toggleMediaControlsVisiblity();
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        k = getDefaultSize(mVideoWidth, i);
        l = getDefaultSize(mVideoHeight, j);
        if (mVideoWidth <= 0 || mVideoHeight <= 0) goto _L2; else goto _L1
_L1:
        if (l * mVideoWidth <= k * mVideoHeight) goto _L4; else goto _L3
_L3:
        l = (k * mVideoHeight) / mVideoWidth;
_L2:
        setMeasuredDimension(k, l);
        Log.d((new StringBuilder("SDKVideoView onMeasure video size (")).append(mVideoWidth).append(",").append(mVideoHeight).append(") surface:(").append(mSurfaceWidth).append(",").append(mSurfaceHeight).append(") Setting size:(").append(k).append(",").append(l).append(")").toString());
        return;
_L4:
        if (l * mVideoWidth < k * mVideoHeight)
        {
            k = (l * mVideoWidth) / mVideoHeight;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isInPlaybackState() && mMediaController != null && motionevent.getAction() == 0)
        {
            toggleMediaControlsVisiblity();
        }
        return super.onTouchEvent(motionevent);
    }

    public boolean onTrackballEvent(MotionEvent motionevent)
    {
        if (isInPlaybackState() && mMediaController != null)
        {
            toggleMediaControlsVisiblity();
        }
        return false;
    }

    public void pause()
    {
        if (isInPlaybackState() && mMediaPlayer.isPlaying())
        {
            mMediaPlayer.pause();
            mCurrentState = 4;
            if (mMediaController != null)
            {
                mMediaController.onPause();
            }
        }
        mTargetState = 4;
    }

    public void seekTo(int i)
    {
        if (isInPlaybackState())
        {
            mMediaPlayer.seekTo(i);
            mSeekWhenPrepared = 0;
            return;
        } else
        {
            mSeekWhenPrepared = i;
            return;
        }
    }

    public void setMediaController(MediaController mediacontroller)
    {
        if (mMediaController != null)
        {
            mMediaController.hide();
        }
        mMediaController = mediacontroller;
        attachMediaController();
    }

    public void setOnCompletionListener(android.media.MediaPlayer.OnCompletionListener oncompletionlistener)
    {
        mOnCompletionListener = oncompletionlistener;
    }

    public void setOnErrorListener(android.media.MediaPlayer.OnErrorListener onerrorlistener)
    {
        mOnErrorListener = onerrorlistener;
    }

    public void setOnInfoListener(android.media.MediaPlayer.OnInfoListener oninfolistener)
    {
        mOnInfoListener = oninfolistener;
    }

    public void setOnPreparedListener(android.media.MediaPlayer.OnPreparedListener onpreparedlistener)
    {
        mOnPreparedListener = onpreparedlistener;
    }

    public void setOnStartListener(OnStartListener onstartlistener)
    {
        mOnStartListener = onstartlistener;
    }

    public void setOnTimeEventListener(int i, OnTimeEventListener ontimeeventlistener)
    {
        Vector vector = (Vector)mTimeEventListeners.get(i);
        if (vector == null)
        {
            vector = new Vector();
            mTimeEventListeners.put(i, vector);
        }
        vector.add(ontimeeventlistener);
    }

    public void setVideoPath(String s)
    {
        setVideoURI(Uri.parse(s));
    }

    public void setVideoURI(Uri uri)
    {
        mUri = uri;
        mSeekWhenPrepared = 0;
        openVideo();
    }

    public void start()
    {
        mTargetState = 3;
        if (isInPlaybackState())
        {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            mContext.sendBroadcast(intent);
            mMediaPlayer.start();
            if (mMediaController != null)
            {
                mMediaController.onStart();
            }
            if (mCurrentState == 2 && mOnStartListener != null)
            {
                mOnStartListener.onVideoStart();
            }
            mCurrentState = 3;
        } else
        if (mMediaPlayer == null)
        {
            openVideo();
            return;
        }
    }

    public void stopPlayback()
    {
        if (mMediaPlayer != null)
        {
            if (mMediaPlayer.isPlaying())
            {
                mMediaPlayer.stop();
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
            mCurrentState = 0;
            mTargetState = 0;
        }
    }
























    private class _cls1
        implements android.media.MediaPlayer.OnVideoSizeChangedListener
    {

        final SDKVideoView this$0;

        public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
        {
            Log.d("SDKVideoView OnVideoSizeChangedListener");
        }

        _cls1()
        {
            this$0 = SDKVideoView.this;
            super();
        }
    }


    private class _cls2
        implements android.media.MediaPlayer.OnPreparedListener
    {

        final SDKVideoView this$0;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            Log.d("SDKVideoView onPrepared");
            mCurrentState = 2;
            if (mOnPreparedListener != null)
            {
                mOnPreparedListener.onPrepared(mMediaPlayer);
            }
            if (mMediaController != null)
            {
                mMediaController.setEnabled(true);
            }
            int i = mSeekWhenPrepared;
            if (i != 0)
            {
                seekTo(i);
            }
            if (!mSurfaceReady)
            {
                Log.d("SDKVideoView onPrepared surface not ready yet");
            } else
            {
                setVideoDisplaySize();
                if (mTargetState == 3)
                {
                    start();
                    return;
                }
                if (!isPlaying() && (i != 0 || getCurrentPosition() > 0) && mMediaController != null)
                {
                    mMediaController.show(0);
                    return;
                }
            }
        }

        _cls2()
        {
            this$0 = SDKVideoView.this;
            super();
        }
    }


    private class _cls3
        implements android.media.MediaPlayer.OnCompletionListener
    {

        final SDKVideoView this$0;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            mCurrentState = 5;
            mTargetState = 5;
            if (mMediaController != null)
            {
                mMediaController.show(0);
            }
            if (mOnCompletionListener != null)
            {
                mOnCompletionListener.onCompletion(mMediaPlayer);
                mOnCompletionListener = null;
            }
        }

        _cls3()
        {
            this$0 = SDKVideoView.this;
            super();
        }
    }


    private class _cls4
        implements android.media.MediaPlayer.OnErrorListener
    {

        final SDKVideoView this$0;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            Log.d((new StringBuilder("Error: ")).append(i).append(",").append(j).toString());
            mCurrentState = -1;
            mTargetState = -1;
            if (mMediaController != null)
            {
                mMediaController.hide();
            }
            if (mOnErrorListener != null)
            {
                if (!mOnErrorListener.onError(mMediaPlayer, i, j));
            }
            return true;
        }

        _cls4()
        {
            this$0 = SDKVideoView.this;
            super();
        }
    }


    private class _cls5
        implements android.media.MediaPlayer.OnInfoListener
    {

        final SDKVideoView this$0;

        public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
        {
            Log.d((new StringBuilder("Info/Warning: ")).append(i).append(",").append(j).toString());
            if (mOnInfoListener != null)
            {
                if (!mOnInfoListener.onInfo(mMediaPlayer, i, j));
            }
            return true;
        }

        _cls5()
        {
            this$0 = SDKVideoView.this;
            super();
        }
    }


    private class _cls6
        implements android.media.MediaPlayer.OnBufferingUpdateListener
    {

        final SDKVideoView this$0;

        public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
        {
            mCurrentBufferPercentage = i;
        }

        _cls6()
        {
            this$0 = SDKVideoView.this;
            super();
        }
    }


    private class _cls7
        implements android.view.SurfaceHolder.Callback
    {

        final SDKVideoView this$0;

        public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
        {
            Log.d("SDKVideoView surfaceChanged");
            mSurfaceWidth = j;
            mSurfaceHeight = k;
            setVideoDisplaySize();
        }

        public void surfaceCreated(SurfaceHolder surfaceholder)
        {
            Log.d("Surface created");
            mSurfaceReady = true;
            if (mPlayWhenSurfaceReady)
            {
                openVideo();
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
            Log.d("Surface destroyed");
            mSurfaceReady = false;
            if (mMediaController != null)
            {
                mMediaController.hide();
            }
            release(true);
        }

        _cls7()
        {
            this$0 = SDKVideoView.this;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final SDKVideoView this$0;

        public void run()
        {
            Log.d("Time Event Thread started");
_L7:
            if (mMediaPlayer == null || mCurrentState != 3) goto _L2; else goto _L1
_L1:
            final int time;
            Vector vector;
            time = mMediaPlayer.getCurrentPosition() / 1000;
            vector = (Vector)mTimeEventListeners.get(time);
            if (vector == null) goto _L2; else goto _L3
_L3:
            int i = 0;
_L8:
            if (i < vector.size()) goto _L5; else goto _L4
_L4:
            vector.clear();
_L2:
            if (!mTimeEventThreadDone.block(1000L)) goto _L7; else goto _L6
_L6:
            Log.v("Time Event Thread stopped");
            return;
_L5:
            final OnTimeEventListener l = (OnTimeEventListener)vector.elementAt(i);
            class _cls1
                implements Runnable
            {

                final _cls8 this$1;
                private final OnTimeEventListener val$l;
                private final int val$time;

                public void run()
                {
                    l.onTimeEvent(time);
                }

                _cls1()
                {
                    this$1 = _cls8.this;
                    l = ontimeeventlistener;
                    time = i;
                    super();
                }
            }

            mHandler.post(new _cls1());
            i++;
              goto _L8
            Exception exception;
            exception;
            Log.e((new StringBuilder("Time Event Thread error")).append(exception).toString(), exception);
              goto _L2
        }

        _cls8()
        {
            this$0 = SDKVideoView.this;
            super();
        }

        private class OnTimeEventListener
        {

            public abstract void onTimeEvent(int i);
        }

    }


    private class OnStartListener
    {

        public abstract void onVideoStart();
    }

}
