// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity, VideoAd, VideoImage, MMWebView, 
//            MMActivity, InterstitialWebViewClient, HttpGetRequest, VideoLogEvent, 
//            AdCache, AdProperties

class CachedVideoPlayerActivity extends VideoPlayerActivity
    implements android.os.Handler.Callback
{

    private static final int STATIC_HUD_ID = 402;
    private static final int STATIC_HUD_SECONDS_ID = 401;
    private RelativeLayout buttonsLayout;
    private boolean hasCountdownHud;
    boolean hasLoadedCompletionUrl;
    boolean hasWebOverlay;
    private TextView hudSeconds;
    private TextView hudStaticText;
    private int lastVideoPosition;
    private Handler logTimeAndEventhandler;
    private MMWebView mWebView;
    private VideoAd videoAd;

    CachedVideoPlayerActivity()
    {
        hasCountdownHud = true;
    }

    private String calculateHudSecondsText()
    {
        if (currentVideoPosition != 0)
        {
            return String.valueOf(currentVideoPosition / 1000);
        }
        if (videoAd != null)
        {
            return String.valueOf(videoAd.duration / 1000L);
        } else
        {
            return "";
        }
    }

    private void dismissAfter(long l)
    {
        logTimeAndEventhandler.postDelayed(new _cls1(), l);
    }

    private void fadeButton(VideoImage videoimage)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(videoimage.fromAlpha, videoimage.toAlpha);
        alphaanimation.setDuration(videoimage.fadeDuration);
        alphaanimation.setFillEnabled(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillAfter(true);
        videoimage.button.startAnimation(alphaanimation);
    }

    private void fadeButtons()
    {
        if (videoAd != null && videoAd.buttons != null)
        {
            for (int i = 0; i < videoAd.buttons.size(); i++)
            {
                VideoImage videoimage = (VideoImage)videoAd.buttons.get(i);
                if (!videoimage.isLeaveBehind)
                {
                    setButtonAlpha(videoimage.button, videoimage.fromAlpha);
                }
                if (videoimage.button.getParent() == null)
                {
                    buttonsLayout.addView(videoimage.button, videoimage.layoutParams);
                }
                for (int j = 0; j < videoAd.buttons.size(); j++)
                {
                    buttonsLayout.bringChildToFront(((VideoImage)videoAd.buttons.get(j)).button);
                }

                Object aobj[] = new Object[2];
                aobj[0] = Integer.valueOf(i);
                aobj[1] = Float.valueOf(videoimage.fromAlpha);
                MMSDK.Log.v("Button: %d alpha: %f", aobj);
            }

        }
    }

    private void hideHud()
    {
        if (hudStaticText != null)
        {
            hudStaticText.setVisibility(4);
        }
        if (hudSeconds != null)
        {
            hudSeconds.setVisibility(4);
        }
    }

    private void initHudSeconds(ViewGroup viewgroup)
    {
        hudSeconds = new TextView(activity);
        hudSeconds.setText(calculateHudSecondsText());
        hudSeconds.setTextColor(-1);
        hudSeconds.setId(401);
        hudSeconds.setShadowLayer(1.0F, 0.0F, 0.0F, 0xff000000);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(10);
        layoutparams.addRule(0, 402);
        viewgroup.addView(hudSeconds, layoutparams);
    }

    private void initHudStaticText(ViewGroup viewgroup)
    {
        hudStaticText = new TextView(activity);
        hudStaticText.setText(" seconds remaining ...");
        hudStaticText.setTextColor(-1);
        hudStaticText.setPadding(0, 0, 5, 0);
        hudStaticText.setId(402);
        hudStaticText.setShadowLayer(1.0F, 0.0F, 0.0F, 0xff000000);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(10);
        layoutparams.addRule(11);
        viewgroup.addView(hudStaticText, layoutparams);
    }

    private void initWebOverlay()
    {
        mWebView = new MMWebView(activity, activity.creatorAdImplInternalId);
        mWebView.setId(413);
        _cls3 _lcls3 = new _cls3();
        mWebView.setWebViewClient(new InterstitialWebViewClient(_lcls3, redirectListenerImpl));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        mWebView.setLayoutParams(layoutparams);
        mWebView.setBackgroundColor(0);
        loadUrlForMraidInjection(videoAd.webOverlayURL);
    }

    private void showHud()
    {
        if (videoAd != null)
        {
            hudSeconds.setText(String.valueOf(videoAd.duration / 1000L));
        }
        hudStaticText.setVisibility(0);
        hudSeconds.setVisibility(0);
    }

    protected boolean canFadeButtons()
    {
        return !videoAd.stayInPlayer || !super.canFadeButtons();
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (videoAd != null)
        {
            if (logTimeAndEventhandler != null)
            {
                logTimeAndEventhandler.removeMessages(1);
            }
            if (!hasWebOverlay)
            {
                int i = 0;
                while (i < videoAd.buttons.size()) 
                {
                    VideoImage videoimage = (VideoImage)videoAd.buttons.get(i);
                    setButtonAlpha(videoimage.button, videoimage.fromAlpha);
                    if (videoimage.inactivityTimeout > 0L)
                    {
                        Message message = Message.obtain(logTimeAndEventhandler, 1, videoimage);
                        logTimeAndEventhandler.sendMessageDelayed(message, videoimage.inactivityTimeout);
                    } else
                    if (motionevent.getAction() == 1)
                    {
                        if (canFadeButtons())
                        {
                            AlphaAnimation alphaanimation = new AlphaAnimation(videoimage.fromAlpha, videoimage.toAlpha);
                            alphaanimation.setDuration(videoimage.fadeDuration);
                            alphaanimation.setFillEnabled(true);
                            alphaanimation.setFillBefore(true);
                            alphaanimation.setFillAfter(true);
                            videoimage.button.startAnimation(alphaanimation);
                        }
                    } else
                    if (motionevent.getAction() == 0)
                    {
                        setButtonAlpha(videoimage.button, videoimage.fromAlpha);
                    }
                    i++;
                }
            }
        }
        return super.dispatchTouchEvent(motionevent);
    }

    protected void enableButtons()
    {
        super.enableButtons();
        if (!hasWebOverlay && videoAd != null && videoAd.buttons != null)
        {
            Iterator iterator = videoAd.buttons.iterator();
            while (iterator.hasNext()) 
            {
                VideoImage videoimage = (VideoImage)iterator.next();
                if (videoimage.button != null)
                {
                    videoimage.button.setEnabled(true);
                }
            }
        }
    }

    protected void errorPlayVideo(String s)
    {
        if (videoAd != null)
        {
            HttpGetRequest.log(videoAd.videoError);
        }
        if (mWebView != null)
        {
            mWebView.loadUrl((new StringBuilder("javascript:MMJS.cachedVideo.setError(")).append(s).append(");").toString());
        }
        super.errorPlayVideo(s);
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 34
    //                   2 172
    //                   3 54;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        if (canFadeButtons())
        {
            fadeButton((VideoImage)message.obj);
            return true;
        }
          goto _L1
_L4:
        VideoImage videoimage = (VideoImage)message.obj;
        Object aobj[];
        try
        {
            if (buttonsLayout.indexOfChild(videoimage.button) == -1)
            {
                buttonsLayout.addView(videoimage.button, videoimage.layoutParams);
            }
        }
        catch (IllegalStateException illegalstateexception1)
        {
            illegalstateexception1.printStackTrace();
        }
        if (!canFadeButtons()) goto _L1; else goto _L5
_L5:
        fadeButton(videoimage);
        aobj = new Object[3];
        aobj[0] = Long.valueOf(videoimage.fadeDuration);
        aobj[1] = Integer.valueOf(videoimage.button.getId());
        aobj[2] = Long.valueOf(System.currentTimeMillis());
        MMSDK.Log.v("Beginning animation to visibility. Fade duration: %d Button: %d Time: %d", aobj);
        return true;
_L3:
        if (mVideoView == null || !mVideoView.isPlaying()) goto _L7; else goto _L6
_L6:
        int i = mVideoView.getCurrentPosition();
        if (i <= lastVideoPosition) goto _L9; else goto _L8
_L8:
        if (videoAd == null) goto _L11; else goto _L10
_L10:
        if (lastVideoPosition == 0)
        {
            videoAd.logBeginEvent();
        }
          goto _L12
_L20:
        int j;
        if (j >= videoAd.activities.size()) goto _L11; else goto _L13
_L13:
        VideoLogEvent videologevent = (VideoLogEvent)videoAd.activities.get(j);
        if (videologevent == null) goto _L15; else goto _L14
_L14:
        if (videologevent.position >= (long)lastVideoPosition && videologevent.position < (long)i)
        {
            int k = 0;
            do
            {
                long l;
                try
                {
                    if (k >= videologevent.activities.length)
                    {
                        break;
                    }
                    MMSDK.Event.logEvent(videologevent.activities[k]);
                }
                catch (IllegalStateException illegalstateexception)
                {
                    illegalstateexception.printStackTrace();
                    return true;
                }
                k++;
            } while (true);
        }
          goto _L15
_L11:
        lastVideoPosition = i;
_L9:
        if (hasWebOverlay && mWebView != null)
        {
            mWebView.loadUrl((new StringBuilder("javascript:MMJS.cachedVideo.updateVideoSeekTime(")).append((float)Math.floor((float)i / 1000F)).append(");").toString());
        }
        if (!hasCountdownHud) goto _L7; else goto _L16
_L16:
        l = (videoAd.duration - (long)i) / 1000L;
        if (l <= 0L) goto _L18; else goto _L17
_L17:
        if (hudSeconds != null)
        {
            hudSeconds.setText(String.valueOf(l));
        }
_L7:
        logTimeAndEventhandler.sendMessageDelayed(Message.obtain(logTimeAndEventhandler, 2), 500L);
        return true;
_L18:
        hideHud();
          goto _L7
_L12:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L15:
        j++;
        if (true) goto _L20; else goto _L19
_L19:
    }

    protected RelativeLayout initLayout()
    {
        RelativeLayout relativelayout;
        relativelayout = super.initLayout();
        logTimeAndEventhandler = new Handler(this);
        setRequestedOrientation(0);
        if (hasCountdownHud)
        {
            initHudStaticText(relativelayout);
            initHudSeconds(relativelayout);
            showHud();
        }
        if (videoAd == null || videoAd.webOverlayURL == null) goto _L2; else goto _L1
_L1:
        initWebOverlay();
        relativelayout.addView(mWebView);
        hasWebOverlay = true;
_L6:
        return relativelayout;
_L2:
        hasWebOverlay = false;
        buttonsLayout = new RelativeLayout(activity);
        buttonsLayout.setId(1000);
        ArrayList arraylist;
        File file;
        int i;
        final VideoImage button;
        final ImageButton newButton;
        Exception exception;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        Object aobj[];
        Message message;
        Message message1;
        android.graphics.Bitmap bitmap;
        if (videoAd != null)
        {
            arraylist = videoAd.buttons;
        } else
        {
            arraylist = null;
        }
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_705;
        }
        file = AdCache.getCacheDirectory(activity);
        i = 0;
        if (i >= arraylist.size())
        {
            break MISSING_BLOCK_LABEL_688;
        }
        button = (VideoImage)arraylist.get(i);
        newButton = new ImageButton(activity);
        button.button = newButton;
        bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append(videoAd.getId()).append(Uri.parse(button.imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat")).toString());
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        try
        {
            newButton.setImageBitmap(bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            MMSDK.Log.e(exception);
        }
        setButtonAlpha(newButton, button.fromAlpha);
        newButton.setId(i + 1);
        newButton.setPadding(0, 0, 0, 0);
        if (button.isLeaveBehind)
        {
            newButton.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            newButton.setBackgroundColor(0xff000000);
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else
        {
            newButton.setBackgroundColor(0);
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            aobj = new Object[5];
            aobj[0] = Integer.valueOf(newButton.getId());
            aobj[1] = Integer.valueOf(button.anchor);
            aobj[2] = Integer.valueOf(button.position);
            aobj[3] = Integer.valueOf(button.anchor2);
            aobj[4] = Integer.valueOf(button.position2);
            MMSDK.Log.v("Button: %d Anchor: %d Position: %d Anchor2: %d Position2: %d", aobj);
            layoutparams.addRule(button.position, button.anchor);
            layoutparams.addRule(button.position2, button.anchor2);
            layoutparams.setMargins(button.paddingLeft, button.paddingTop, button.paddingRight, button.paddingBottom);
        }
        if (!TextUtils.isEmpty(button.linkUrl))
        {
            newButton.setOnClickListener(new _cls2());
        }
        if (button.appearanceDelay > 0L)
        {
            button.layoutParams = layoutparams;
            message1 = Message.obtain(logTimeAndEventhandler, 3, button);
            logTimeAndEventhandler.sendMessageDelayed(message1, button.appearanceDelay);
        } else
        {
            buttonsLayout.addView(newButton, layoutparams);
        }
        if (button.inactivityTimeout > 0L)
        {
            message = Message.obtain(logTimeAndEventhandler, 1, button);
            logTimeAndEventhandler.sendMessageDelayed(message, button.inactivityTimeout + button.appearanceDelay + button.fadeDuration);
        }
        i++;
        if (false)
        {
            break MISSING_BLOCK_LABEL_446;
        } else
        {
            break MISSING_BLOCK_LABEL_139;
        }
_L4:
        newButton.setImageURI(Uri.parse((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append(videoAd.getId()).append(Uri.parse(button.imageUrl).getLastPathSegment().replaceFirst("\\.[^\\.]*$", ".dat")).toString()));
        break MISSING_BLOCK_LABEL_256;
        relativelayout.addView(buttonsLayout, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        if (buttonsLayout != null)
        {
            relativelayout.bringChildToFront(buttonsLayout);
        }
        if (mWebView != null)
        {
            relativelayout.bringChildToFront(mWebView);
            return relativelayout;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void initSavedInstance(Bundle bundle)
    {
        super.initSavedInstance(bundle);
        if (bundle == null)
        {
            String s = getIntent().getStringExtra("videoId");
            videoAd = (VideoAd)AdCache.load(activity, s);
            if (videoAd != null)
            {
                hasBottomBar = videoAd.showControls;
                hasCountdownHud = videoAd.showCountdown;
            }
            return;
        } else
        {
            videoAd = (VideoAd)bundle.getParcelable("videoAd");
            hasBottomBar = bundle.getBoolean("shouldShowBottomBar");
            lastVideoPosition = bundle.getInt("lastVideoPosition");
            currentVideoPosition = bundle.getInt("currentVideoPosition");
            hasCountdownHud = videoAd.showCountdown;
            return;
        }
    }

    void loadUrlForMraidInjection(String s)
    {
        (new FetchWebViewContentTask(s)).execute(new Void[0]);
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        super.onCompletion(mediaplayer);
        if (hasCountdownHud)
        {
            hideHud();
        }
        if (videoAd != null)
        {
            videoPlayerOnCompletion(videoAd.onCompletionUrl);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adProperties = new AdProperties(activity);
        MMSDK.Log.v("Is Cached Ad");
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Object aobj[] = new Object[2];
        aobj[0] = Integer.valueOf(i);
        aobj[1] = Integer.valueOf(j);
        errorPlayVideo(String.format("Error while playing, %d - %d", aobj));
        return super.onError(mediaplayer, i, j);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        videoAd = (VideoAd)bundle.getParcelable("videoAd");
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        if (mWebView != null)
        {
            mWebView.bringToFront();
        }
        if (buttonsLayout != null)
        {
            buttonsLayout.bringToFront();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("videoAd", videoAd);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        if (!hasWebOverlay && videoAd != null && videoAd.stayInPlayer && isVideoCompleted)
        {
            fadeButtons();
        }
    }

    protected void pauseVideo()
    {
        super.pauseVideo();
        logTimeAndEventhandler.removeMessages(1);
        logTimeAndEventhandler.removeMessages(2);
        logTimeAndEventhandler.removeMessages(3);
    }

    protected void playVideo(int i)
    {
        if (videoAd == null)
        {
            Toast.makeText(activity, "Sorry. There was a problem playing the video", 1).show();
            return;
        }
        if (!logTimeAndEventhandler.hasMessages(2) && videoAd != null)
        {
            logTimeAndEventhandler.sendMessageDelayed(Message.obtain(logTimeAndEventhandler, 2), 1000L);
        }
        super.playVideo(i);
    }

    protected void restartVideo()
    {
        if (videoAd != null)
        {
            if ((hasLoadedCompletionUrl || videoAd.reloadNonEndOverlayOnRestart) && videoAd.webOverlayURL != null && mWebView != null)
            {
                loadUrlForMraidInjection(videoAd.webOverlayURL);
                hasLoadedCompletionUrl = false;
            }
            ArrayList arraylist = videoAd.buttons;
            logTimeAndEventhandler.removeMessages(1);
            logTimeAndEventhandler.removeMessages(2);
            logTimeAndEventhandler.removeMessages(3);
            lastVideoPosition = 0;
            if (!hasWebOverlay && buttonsLayout != null && arraylist != null)
            {
                for (int i = 0; i < arraylist.size(); i++)
                {
                    VideoImage videoimage = (VideoImage)arraylist.get(i);
                    if (videoimage == null)
                    {
                        continue;
                    }
                    if (videoimage.appearanceDelay > 0L)
                    {
                        ImageButton imagebutton = videoimage.button;
                        buttonsLayout.removeView(imagebutton);
                        Message message1 = Message.obtain(logTimeAndEventhandler, 3, videoimage);
                        logTimeAndEventhandler.sendMessageDelayed(message1, videoimage.appearanceDelay);
                    }
                    if (videoimage.inactivityTimeout > 0L)
                    {
                        Message message = Message.obtain(logTimeAndEventhandler, 1, videoimage);
                        logTimeAndEventhandler.sendMessageDelayed(message, videoimage.inactivityTimeout + videoimage.appearanceDelay + videoimage.fadeDuration);
                    }
                }

            }
            if (logTimeAndEventhandler != null)
            {
                logTimeAndEventhandler.sendMessageDelayed(Message.obtain(logTimeAndEventhandler, 2), 1000L);
            }
            if (hasCountdownHud)
            {
                showHud();
            }
        }
        super.restartVideo();
    }

    protected void resumeVideo()
    {
        if (videoAd != null)
        {
            if (!logTimeAndEventhandler.hasMessages(2))
            {
                logTimeAndEventhandler.sendMessageDelayed(Message.obtain(logTimeAndEventhandler, 2), 1000L);
            }
            if (!hasWebOverlay)
            {
                if (hasCountdownHud)
                {
                    long l1 = (videoAd.duration - (long)currentVideoPosition) / 1000L;
                    int i;
                    VideoImage videoimage;
                    Message message;
                    Message message1;
                    if (l1 > 0L)
                    {
                        if (hudSeconds != null)
                        {
                            hudSeconds.setText(String.valueOf(l1));
                        }
                    } else
                    {
                        hideHud();
                    }
                }
                if (videoAd.buttons != null)
                {
                    i = 0;
                    while (i < videoAd.buttons.size()) 
                    {
                        videoimage = (VideoImage)videoAd.buttons.get(i);
                        long l;
                        if (videoimage.appearanceDelay > 0L && buttonsLayout.indexOfChild(videoimage.button) == -1)
                        {
                            message1 = Message.obtain(logTimeAndEventhandler, 3, videoimage);
                            l = videoimage.appearanceDelay - (long)currentVideoPosition;
                            if (l < 0L)
                            {
                                l = 500L;
                            }
                            logTimeAndEventhandler.sendMessageDelayed(message1, l);
                        } else
                        {
                            l = 0L;
                        }
                        if (videoimage.inactivityTimeout > 0L)
                        {
                            message = Message.obtain(logTimeAndEventhandler, 1, videoimage);
                            logTimeAndEventhandler.sendMessageDelayed(message, l + videoimage.inactivityTimeout + videoimage.fadeDuration);
                        }
                        i++;
                    }
                }
            }
        }
        super.resumeVideo();
    }

    protected void videoPlayerOnCompletion(String s)
    {
label0:
        {
            if (s != null)
            {
                dispatchButtonClick(s);
            }
            if (videoAd != null)
            {
                videoAd.logEndEvent();
                if (videoAd.stayInPlayer)
                {
                    break label0;
                }
                dismiss();
            }
            return;
        }
        if (!hasWebOverlay && videoAd.buttons != null)
        {
            fadeButtons();
            if (!videoAd.hasEndCard())
            {
                dismiss();
            }
        }
        if (mWebView == null || TextUtils.isEmpty(videoAd.endOverlayURL)) goto _L2; else goto _L1
_L1:
        loadUrlForMraidInjection(videoAd.endOverlayURL);
        mWebView.bringToFront();
_L4:
        if (videoAd.closeDelayMillis != 0L)
        {
            dismissAfter(videoAd.closeDelayMillis);
        }
        logTimeAndEventhandler.removeMessages(1);
        logTimeAndEventhandler.removeMessages(2);
        logTimeAndEventhandler.removeMessages(3);
        return;
_L2:
        if (hasWebOverlay)
        {
            dismiss();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }



    private class _cls1
        implements Runnable
    {

        final CachedVideoPlayerActivity this$0;

        public void run()
        {
            dismiss();
        }

        _cls1()
        {
            this$0 = CachedVideoPlayerActivity.this;
            super();
        }
    }


    private class _cls3 extends MMWebViewClient.MMWebViewClientListener
    {

        final CachedVideoPlayerActivity this$0;

        public void onPageFinished(String s)
        {
            MMSDK.Log.d((new StringBuilder("@@ ON PAGE FINISHED")).append(s).toString());
            if (mVideoView != null && videoAd != null && !mVideoView.isPlaying() && s.equalsIgnoreCase(videoAd.webOverlayURL))
            {
                playVideo(0);
            }
        }

        _cls3()
        {
            this$0 = CachedVideoPlayerActivity.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final CachedVideoPlayerActivity this$0;
        final VideoImage val$button;
        final ImageButton val$newButton;

        public void onClick(View view)
        {
            if (newButton != null)
            {
                newButton.setEnabled(false);
            }
            redirectListenerImpl.orientation = button.overlayOrientation;
            dispatchButtonClick(button.linkUrl);
            logButtonEvent(button);
        }

        _cls2()
        {
            this$0 = CachedVideoPlayerActivity.this;
            newButton = imagebutton;
            button = videoimage;
            super();
        }
    }


    private class FetchWebViewContentTask extends AsyncTask
    {

        private String baseUrl;
        private boolean cancelVideo;
        final CachedVideoPlayerActivity this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            HttpResponse httpresponse;
            StatusLine statusline;
            httpresponse = (new HttpGetRequest()).get(baseUrl);
            statusline = httpresponse.getStatusLine();
            if (httpresponse == null || statusline == null)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            HttpEntity httpentity;
            if (statusline.getStatusCode() == 404)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            httpentity = httpresponse.getEntity();
            if (httpentity == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            return HttpGetRequest.convertStreamToString(httpentity.getContent());
            cancelVideo = true;
_L2:
            return null;
            Exception exception;
            exception;
            exception.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (cancelVideo)
            {
                dismiss();
            }
            if (s != null)
            {
                mWebView.setWebViewContent(s, baseUrl, activity);
                hasLoadedCompletionUrl = true;
            }
        }

        public FetchWebViewContentTask(String s)
        {
            this$0 = CachedVideoPlayerActivity.this;
            super();
            baseUrl = s;
        }
    }

}
