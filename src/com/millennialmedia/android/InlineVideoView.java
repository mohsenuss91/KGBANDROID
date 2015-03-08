// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.VideoView;
import com.millennialmedia.google.gson.Gson;
import java.io.Serializable;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMLayout, MMAdImplController, MMSDK, VideoAd

class InlineVideoView extends VideoView
    implements Serializable
{

    private static final String ANCHOR_IN_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=";
    private static final String ANCHOR_OUT_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC";
    static final int TIME_TO_UPDATE_SEEK_JS = 500;
    private int duration;
    InlineParams inlineParams;
    MediaController mediaController;
    WeakReference mmLayoutRef;
    TransparentFix transFix;
    Handler transparentHandler;
    Handler videoHandler;

    public InlineVideoView(MMLayout mmlayout)
    {
        super(mmlayout.getContext());
        transparentHandler = new _cls4();
        setId(0x86c5ad);
        setFocusable(true);
        MMAdImplController.destroyOtherInlineVideo(mmlayout.getContext());
        mmLayoutRef = new WeakReference(mmlayout);
    }

    private android.media.MediaPlayer.OnCompletionListener createOnCompletionListener(InlineVideoView inlinevideoview)
    {
        return new _cls6();
    }

    private android.media.MediaPlayer.OnErrorListener createOnErrorListener(InlineVideoView inlinevideoview)
    {
        return new _cls5();
    }

    private android.media.MediaPlayer.OnPreparedListener createOnPreparedListener(InlineVideoView inlinevideoview)
    {
        return new _cls7();
    }

    private android.view.View.OnTouchListener createOnTouchListener(InlineVideoView inlinevideoview)
    {
        return new _cls2();
    }

    private Handler createVideoHandler()
    {
        return new _cls3();
    }

    private void downloadCacheVideo()
    {
        if (MMSDK.isUiThread())
        {
            Utils.ThreadUtils.execute(new _cls1());
            return;
        } else
        {
            downloadVideo();
            return;
        }
    }

    private void downloadVideo()
    {
        VideoAd.downloadVideoFile(getContext(), inlineParams.cachedVideoURI, inlineParams.cachedVideoID);
    }

    private Uri getVideoUri()
    {
        if (hasCachedVideo() && !inlineParams.isPlayingStreaming)
        {
            inlineParams.isPlayingStreaming = false;
            return VideoAd.getVideoUri(getContext(), inlineParams.cachedVideoID);
        }
        if (!TextUtils.isEmpty(inlineParams.streamVideoURI))
        {
            inlineParams.isPlayingStreaming = true;
            return Uri.parse(inlineParams.streamVideoURI);
        } else
        {
            return null;
        }
    }

    private boolean hasCachedVideo()
    {
        return !TextUtils.isEmpty(inlineParams.cachedVideoID) && VideoAd.hasVideoFile(getContext(), inlineParams.cachedVideoID);
    }

    private void initInternalInlineVideo()
    {
        videoHandler = createVideoHandler();
        setVideoURI(getVideoUri());
        setBackgroundColor(0xff000000);
        setClickable(true);
        setOnErrorListener(createOnErrorListener(this));
        setOnCompletionListener(createOnCompletionListener(this));
        setOnPreparedListener(createOnPreparedListener(this));
        if (inlineParams.autoPlay)
        {
            seekTo(inlineParams.currentPosition);
            startInternal();
            if (videoHandler != null && !videoHandler.hasMessages(2))
            {
                videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
            }
        }
        if (inlineParams.showControls)
        {
            mediaController = new MediaController(getContext());
            setMediaController(mediaController);
            mediaController.show();
        }
        setOnTouchListener(createOnTouchListener(this));
        MMSDK.Log.e("Finished inserting inlineVideo player");
    }

    private void makeTransparent()
    {
        if (!transparentHandler.hasMessages(4))
        {
            transparentHandler.sendEmptyMessage(4);
        }
    }

    private void removeFromParent()
    {
        ViewGroup viewgroup = (ViewGroup)getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(this);
        }
    }

    private void removeKeyboardFocusViewJira1642()
    {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        requestFocus();
    }

    private void resumeInternal(boolean flag)
    {
        if (!inlineParams.isCompleted)
        {
            seekTo(inlineParams.currentPosition);
            if (flag || inlineParams.autoPlay)
            {
                startInternal();
                if (videoHandler != null && !videoHandler.hasMessages(2))
                {
                    videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
                }
            }
        }
    }

    private void setInlineVideoParams(InlineParams inlineparams)
    {
        inlineParams = inlineparams;
    }

    private void updateVideoSeekTime()
    {
        int i = getCurrentPosition();
        if (i >= 0)
        {
            MMSDK.Log.d((new StringBuilder("Time is ")).append(i).toString());
            updateVideoSeekTime(Math.floor((float)i / 1000F));
        }
    }

    private void updateVideoSeekTime(double d)
    {
        MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
        if (mmlayout == null)
        {
            MMSDK.Log.w("MMLayout weak reference broken");
        }
        mmlayout.loadUrl((new StringBuilder("javascript:MMJS.inlineVideo.updateVideoSeekTime(")).append(d).append(");").toString());
    }

    private void updateVideoSeekTimeFinal()
    {
        if (duration > 0)
        {
            MMSDK.Log.d((new StringBuilder("Time is ")).append(duration).toString());
            updateVideoSeekTime(Math.ceil((float)duration / 1000F));
        }
    }

    boolean adjustVideo(InlineParams inlineparams)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        MMLayout mmlayout;
        setAdjustVideoParams(inlineparams);
        MMSDK.Log.e("Called initInlineVideo inside reposition section code");
        flag = isPlaying();
        stopPlayback();
        mmlayout = (MMLayout)mmLayoutRef.get();
        if (mmlayout == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        mmlayout.addInlineVideo();
        resumeInternal(flag);
        this;
        JVM INSTR monitorexit ;
        return true;
        Exception exception;
        exception;
        throw exception;
    }

    public android.widget.RelativeLayout.LayoutParams getCustomLayoutParams()
    {
        if (inlineParams.goingFullScreen)
        {
            return new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(inlineParams.scaleFactor * (float)inlineParams.width), (int)(inlineParams.scaleFactor * (float)inlineParams.height));
            layoutparams.topMargin = (int)(inlineParams.scaleFactor * (float)inlineParams.y);
            layoutparams.leftMargin = (int)(inlineParams.scaleFactor * (float)inlineParams.x);
            MMSDK.Log.d((new StringBuilder("lp height = ")).append(layoutparams.height).toString());
            return layoutparams;
        }
    }

    String getGsonState()
    {
        return (new Gson()).toJson(inlineParams);
    }

    InlineParams getInlineParams()
    {
        return inlineParams;
    }

    void initInlineVideo(InlineParams inlineparams)
    {
        this;
        JVM INSTR monitorenter ;
        inlineParams = inlineparams;
        if (!TextUtils.isEmpty(inlineParams.cachedVideoURI))
        {
            downloadCacheVideo();
        }
        if (!isValid()) goto _L2; else goto _L1
_L1:
        initInternalInlineVideo();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        MMSDK.Log.e("The videoURI attribute was not specified on the video marker div.");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    boolean isPlayingStreaming()
    {
        return inlineParams != null && inlineParams.isPlayingStreaming;
    }

    boolean isValid()
    {
        return !TextUtils.isEmpty(inlineParams.streamVideoURI) || hasCachedVideo();
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof AdViewOverlayView.SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        } else
        {
            AdViewOverlayView.SavedState savedstate = (AdViewOverlayView.SavedState)parcelable;
            super.onRestoreInstanceState(savedstate.getSuperState());
            inlineParams.inflateFromGson(savedstate.gson);
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        AdViewOverlayView.SavedState savedstate = new AdViewOverlayView.SavedState(super.onSaveInstanceState());
        if (isPlaying())
        {
            inlineParams.currentPosition = getCurrentPosition();
        }
        savedstate.gson = getGsonState();
        return savedstate;
    }

    void pauseVideo()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            inlineParams.currentPosition = getCurrentPosition();
            pause();
        }
    }

    void playVideo()
    {
        if (isPlaying()) goto _L2; else goto _L1
_L1:
        if (!inlineParams.isStopped || getVideoUri() == null) goto _L4; else goto _L3
_L3:
        inlineParams.isStopped = false;
        setVideoURI(getVideoUri());
        seekTo(0);
_L6:
        inlineParams.isCompleted = false;
        startInternal();
_L2:
        if (videoHandler != null && !videoHandler.hasMessages(2))
        {
            videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
        }
        return;
_L4:
        if (inlineParams.isCompleted)
        {
            seekTo(0);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    void removeVideo()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            stopPlayback();
        }
        removeFromParent();
    }

    void resumeVideo()
    {
        if (!isPlaying() && !inlineParams.isCompleted)
        {
            startInternal();
            if (videoHandler != null && !videoHandler.hasMessages(2))
            {
                videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
            }
        }
    }

    void setAdjustVideoParams(InlineParams inlineparams)
    {
        inlineParams.x = inlineparams.x;
        inlineParams.y = inlineparams.y;
        inlineParams.width = inlineparams.width;
        inlineParams.height = inlineparams.height;
    }

    void setVideoSource(String s)
    {
        if (isPlaying())
        {
            stopPlayback();
        }
        inlineParams.currentPosition = 0;
        setBackgroundColor(0xff000000);
        setVideoURI(Uri.parse(s));
        startInternal();
    }

    public void start()
    {
        makeTransparent();
        removeKeyboardFocusViewJira1642();
        super.start();
    }

    public void startInternal()
    {
        if (((PowerManager)getContext().getSystemService("power")).isScreenOn())
        {
            start();
        }
    }

    public void stopPlayback()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            inlineParams.currentPosition = 0;
            super.stopPlayback();
        }
    }

    void stopVideo()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            inlineParams.isStopped = true;
            inlineParams.currentPosition = 0;
            if (mmLayoutRef != null && mmLayoutRef.get() != null)
            {
                ((MMLayout)mmLayoutRef.get()).addBlackView();
            }
            stopPlayback();
        }
    }

    public String toString()
    {
        return inlineParams.toString();
    }





/*
    static int access$202(InlineVideoView inlinevideoview, int i)
    {
        inlinevideoview.duration = i;
        return i;
    }

*/




    private class _cls4 extends Handler
    {

        final InlineVideoView this$0;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 4 5: default 28
        //                       4 29
        //                       5 81;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            if (isPlaying() && getCurrentPosition() > 0)
            {
                transparentHandler.sendEmptyMessageDelayed(5, 100L);
                return;
            } else
            {
                transparentHandler.sendEmptyMessageDelayed(4, 50L);
                return;
            }
_L3:
            if (isPlaying() && getCurrentPosition() > 0)
            {
                setBackgroundColor(0);
                if (mmLayoutRef != null && mmLayoutRef.get() != null)
                {
                    ((MMLayout)mmLayoutRef.get()).removeBlackView();
                    return;
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        _cls4()
        {
            this$0 = InlineVideoView.this;
            super();
        }
    }


    private class _cls6
        implements android.media.MediaPlayer.OnCompletionListener
    {

        final InlineVideoView this$0;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            if (videoHandler != null && videoHandler.hasMessages(2))
            {
                videoHandler.removeMessages(2);
            }
            inlineParams.isCompleted = true;
            inlineParams.currentPosition = duration;
            if (inlineParams.currentPosition == -1)
            {
                inlineParams.currentPosition = 0;
            }
            updateVideoSeekTimeFinal();
        }

        _cls6()
        {
            this$0 = InlineVideoView.this;
            super();
        }
    }


    private class _cls5
        implements android.media.MediaPlayer.OnErrorListener
    {

        final InlineVideoView this$0;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            if (videoHandler != null && videoHandler.hasMessages(2))
            {
                videoHandler.removeMessages(2);
            }
            MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
            if (mmlayout == null)
            {
                MMSDK.Log.w("MMLayout weak reference broken");
                return false;
            } else
            {
                StringBuilder stringbuilder = new StringBuilder("javascript:MMJS.setError(");
                Object aobj[] = new Object[2];
                aobj[0] = Integer.valueOf(i);
                aobj[1] = Integer.valueOf(j);
                mmlayout.loadUrl(stringbuilder.append(String.format("Error while playing, %d - %d", aobj)).append(");").toString());
                return true;
            }
        }

        _cls5()
        {
            this$0 = InlineVideoView.this;
            super();
        }
    }


    private class _cls7
        implements android.media.MediaPlayer.OnPreparedListener
    {

        final InlineVideoView this$0;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            if (inlineParams.autoPlay)
            {
                makeTransparent();
            }
            seekTo(inlineParams.currentPosition);
            if (inlineParams.autoPlay || !inlineParams.isInitialPlayBack)
            {
                getHeight();
            } else
            {
                inlineParams.isInitialPlayBack = false;
            }
            duration = getDuration();
        }

        _cls7()
        {
            this$0 = InlineVideoView.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnTouchListener
    {

        final InlineVideoView this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 1)
            {
                MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
                if (mmlayout == null)
                {
                    MMSDK.Log.w("MMLayout weak reference broken");
                    return false;
                }
                if (!TextUtils.isEmpty(inlineParams.touchCallBack))
                {
                    String s = (new StringBuilder("javascript:")).append(inlineParams.touchCallBack).append("(%f,%f)").toString();
                    Object aobj[] = new Object[2];
                    aobj[0] = Float.valueOf(motionevent.getX());
                    aobj[1] = Float.valueOf(motionevent.getY());
                    mmlayout.loadUrl(String.format(s, aobj));
                }
                if (inlineParams.showControls && mediaController != null && !mediaController.isShowing())
                {
                    mediaController.show();
                    return true;
                }
            }
            return true;
        }

        _cls2()
        {
            this$0 = InlineVideoView.this;
            super();
        }
    }


    private class _cls3 extends Handler
    {

        final InlineVideoView this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 2: // '\002'
                break;
            }
            if (isPlaying())
            {
                updateVideoSeekTime();
            }
            videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
        }

        _cls3()
        {
            this$0 = InlineVideoView.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final InlineVideoView this$0;

        public void run()
        {
            downloadVideo();
        }

        _cls1()
        {
            this$0 = InlineVideoView.this;
            super();
        }
    }


    private class InlineParams
    {

        boolean autoPlay;
        int bodyHeight;
        int bodyWidth;
        String cachedVideoID;
        String cachedVideoURI;
        int currentPosition;
        boolean goingFullScreen;
        int height;
        boolean isCompleted;
        boolean isInitialPlayBack;
        boolean isPlayingStreaming;
        boolean isStopped;
        int originalOrientation;
        float scaleFactor;
        boolean showControls;
        String streamVideoURI;
        String touchCallBack;
        int width;
        int x;
        int y;

        static InlineParams getInlineParams(String s)
        {
            return (InlineParams)(new Gson()).fromJson(s, com/millennialmedia/android/InlineVideoView$InlineParams);
        }

        void inflateFromGson(String s)
        {
            InlineParams inlineparams = (InlineParams)(new Gson()).fromJson(s, com/millennialmedia/android/InlineVideoView$InlineParams);
            x = inlineparams.x;
            y = inlineparams.y;
            bodyWidth = inlineparams.bodyWidth;
            bodyHeight = inlineparams.bodyHeight;
            width = inlineparams.width;
            height = inlineparams.height;
            currentPosition = inlineparams.currentPosition;
            streamVideoURI = inlineparams.streamVideoURI;
            cachedVideoURI = inlineparams.cachedVideoURI;
            cachedVideoID = inlineparams.cachedVideoID;
            touchCallBack = inlineparams.touchCallBack;
            autoPlay = inlineparams.autoPlay;
            showControls = inlineparams.showControls;
            isInitialPlayBack = inlineparams.isInitialPlayBack;
            scaleFactor = inlineparams.scaleFactor;
            goingFullScreen = inlineparams.goingFullScreen;
            originalOrientation = inlineparams.originalOrientation;
            isCompleted = inlineparams.isCompleted;
            MMSDK.Log.d((new StringBuilder("gson*****")).append(s).toString());
            MMSDK.Log.d((new StringBuilder("PARAMS*****")).append(inlineparams).toString());
        }

        public String toString()
        {
            Object aobj[] = new Object[7];
            aobj[0] = cachedVideoID;
            aobj[1] = Integer.valueOf(x);
            aobj[2] = Integer.valueOf(y);
            aobj[3] = Integer.valueOf(bodyWidth);
            aobj[4] = Integer.valueOf(bodyHeight);
            aobj[5] = Integer.valueOf(currentPosition);
            aobj[6] = Boolean.valueOf(autoPlay);
            return String.format("%s id, %d x, %d y, %d bWidth, %d bHeight, %d pos, %b autoPlay", aobj);
        }

        InlineParams(HashMap hashmap, Context context)
        {
            isInitialPlayBack = true;
            if (hashmap.get("x") != null)
            {
                x = (int)Float.parseFloat((String)hashmap.get("x"));
            }
            if (hashmap.get("y") != null)
            {
                y = (int)Float.parseFloat((String)hashmap.get("y"));
            }
            if (hashmap.get("width") != null)
            {
                width = (int)Float.parseFloat((String)hashmap.get("width"));
            }
            if (hashmap.get("height") != null)
            {
                height = (int)Float.parseFloat((String)hashmap.get("height"));
            }
            streamVideoURI = (String)hashmap.get("streamVideoURI");
            cachedVideoURI = (String)hashmap.get("cachedVideoURI");
            cachedVideoID = (String)hashmap.get("cachedVideoID");
            if (hashmap.get("autoPlay") != null)
            {
                autoPlay = Boolean.parseBoolean((String)hashmap.get("autoPlay"));
            }
            if (hashmap.get("showControls") != null)
            {
                showControls = Boolean.parseBoolean((String)hashmap.get("showControls"));
            }
            if (hashmap.get("bodyWidth") != null)
            {
                bodyWidth = (int)Float.parseFloat((String)hashmap.get("bodyWidth"));
            }
            if (hashmap.get("bodyHeight") != null)
            {
                bodyHeight = (int)Float.parseFloat((String)hashmap.get("bodyHeight"));
            }
            touchCallBack = (String)hashmap.get("touchCallback");
            scaleFactor = context.getResources().getDisplayMetrics().density;
        }
    }


    private class MediaController extends android.widget.MediaController
    {

        BitmapDrawable inDrawable;
        BitmapDrawable outDrawable;
        final InlineVideoView this$0;

        public void setAnchorView(View view)
        {
            super.setAnchorView(view);
            Button button = new Button(getContext());
            class _cls1
                implements android.view.View.OnClickListener
            {

                final MediaController this$1;

                public void onClick(View view1)
                {
                    MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
                    if (mmlayout == null) goto _L2; else goto _L1
_L1:
                    setBackgroundColor(0xff000000);
                    if (isPlaying())
                    {
                        inlineParams.currentPosition = getCurrentPosition();
                    }
                    if (!inlineParams.goingFullScreen) goto _L4; else goto _L3
_L3:
                    inlineParams.goingFullScreen = false;
                    if (inlineParams.originalOrientation != 1) goto _L6; else goto _L5
_L5:
                    Activity activity1 = (Activity)getContext();
                    if (activity1 != null)
                    {
                        activity1.setRequestedOrientation(1);
                    }
_L2:
                    return;
_L6:
                    boolean flag1 = isPlaying();
                    stopPlayback();
                    mmlayout.repositionVideoLayout();
                    resumeInternal(flag1);
                    return;
_L4:
                    inlineParams.originalOrientation = getContext().getResources().getConfiguration().orientation;
                    inlineParams.goingFullScreen = true;
                    if (inlineParams.originalOrientation != 2)
                    {
                        Activity activity = (Activity)getContext();
                        if (activity != null)
                        {
                            activity.setRequestedOrientation(0);
                            return;
                        }
                    } else
                    {
                        boolean flag = isPlaying();
                        stopPlayback();
                        mmlayout.fullScreenVideoLayout();
                        resumeInternal(flag);
                        return;
                    }
                    if (true) goto _L2; else goto _L7
_L7:
                }

                _cls1()
                {
                    this$1 = MediaController.this;
                    super();
                }
            }

            android.widget.FrameLayout.LayoutParams layoutparams;
            if (inDrawable == null)
            {
                try
                {
                    inDrawable = new BitmapDrawable(new ByteArrayInputStream(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=")));
                }
                catch (Exception exception1)
                {
                    MMSDK.Log.e((new StringBuilder("Exception image:")).append(exception1.getMessage()).toString());
                }
            }
            if (outDrawable == null)
            {
                try
                {
                    outDrawable = new BitmapDrawable(new ByteArrayInputStream(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC")));
                }
                catch (Exception exception)
                {
                    MMSDK.Log.e((new StringBuilder("Exception image:")).append(exception.getMessage()).toString());
                }
            }
            if (inlineParams.goingFullScreen)
            {
                button.setBackgroundDrawable(inDrawable);
            } else
            {
                button.setBackgroundDrawable(outDrawable);
            }
            button.setOnClickListener(new _cls1());
            layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2, 5);
            layoutparams.setMargins(0, 20, 10, 0);
            addView(button, layoutparams);
        }

        public MediaController(Context context)
        {
            this$0 = InlineVideoView.this;
            super(context);
        }
    }

}
