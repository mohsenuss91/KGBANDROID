// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMLayout, AdViewOverlayActivity, MMAdImpl, MMAdImplController, 
//            MMActivity, OverlaySettings, MMWebView, InlineVideoView

class AdViewOverlayView extends MMLayout
{

    private Button mraidCloseButton;
    CloseTopDrawable mraidCloseDrawable;
    WeakReference overlayActivityRef;
    private ProgressBar progressBar;
    private boolean progressDone;
    OverlaySettings settings;

    AdViewOverlayView(AdViewOverlayActivity adviewoverlayactivity, OverlaySettings overlaysettings)
    {
        super(adviewoverlayactivity.activity);
        overlayActivityRef = new WeakReference(adviewoverlayactivity);
        adImpl = new AdViewOverlayViewMMAdImpl(adviewoverlayactivity.activity);
        setId(15062);
        adImpl.adType = "i";
        settings = overlaysettings;
        boolean flag = adviewoverlayactivity.activity instanceof Activity;
        NonConfigurationInstance nonconfigurationinstance = null;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (flag)
        {
            nonconfigurationinstance = (NonConfigurationInstance)adviewoverlayactivity.activity.getLastNonConfigurationInstance();
            float f;
            Integer integer;
            if (nonconfigurationinstance != null)
            {
                progressDone = nonconfigurationinstance.progressDone;
                adImpl.controller = nonconfigurationinstance.controller;
                settings = nonconfigurationinstance.settings;
                if (adImpl != null && adImpl.controller != null && adImpl.controller.webView != null)
                {
                    addView(adImpl.controller.webView);
                }
                MMSDK.Log.d((new StringBuilder("Restoring configurationinstance w/ controller= ")).append(nonconfigurationinstance.controller).toString());
            } else
            {
                MMSDK.Log.d("Null configurationinstance ");
            }
        }
        f = adviewoverlayactivity.activity.getResources().getDisplayMetrics().density;
        if (settings.height != 0 && settings.width != 0)
        {
            layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(f * (float)settings.width), (int)(f * (float)settings.height));
        } else
        {
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        }
        layoutparams.addRule(13);
        setLayoutParams(layoutparams);
        integer = Integer.valueOf((int)(0.0625F * f * (float)settings.shouldResizeOverlay));
        setPadding(integer.intValue(), integer.intValue(), integer.intValue(), integer.intValue());
        mraidCloseButton = initMRaidCloseButton(adviewoverlayactivity.activity, f);
        if (settings.isExpanded() && !settings.hasExpandUrl())
        {
            adImpl.linkForExpansionId = settings.creatorAdImplId;
        }
        MMAdImplController.assignAdViewController(adImpl);
        if (mraidCloseButton != null)
        {
            addView(mraidCloseButton);
        }
        if (!progressDone && !settings.isExpanded() && !settings.isFromInterstitial())
        {
            initProgressBar();
        }
        if (settings.getIsTransparent())
        {
            adImpl.controller.webView.setBackgroundColor(0);
            adImpl.setBackgroundColor(0);
        } else
        {
            adImpl.controller.webView.setBackgroundColor(-1);
            adImpl.setBackgroundColor(-1);
        }
        if (settings.enableHardwareAccel())
        {
            adImpl.controller.webView.enableHardwareAcceleration();
        }
        if (nonconfigurationinstance == null)
        {
            animateView();
        }
        setUseCustomClose(settings.getUseCustomClose());
    }

    private void animateView()
    {
        Object obj;
        if (settings.getTransition().equals("slideup"))
        {
            obj = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            MMSDK.Log.v("Translate up");
        } else
        {
            if (!settings.getTransition().equals("slidedown"))
            {
                continue;
            }
            obj = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1F, 1, 0.0F);
            MMSDK.Log.v("Translate down");
        }
        do
        {
            ((Animation) (obj)).setDuration(settings.getTransitionDurationInMillis());
            startAnimation(((Animation) (obj)));
            do
            {
                return;
            } while (!settings.getTransition().equals("explode"));
            ScaleAnimation scaleanimation = new ScaleAnimation(1.1F, 0.9F, 0.1F, 0.9F, 1, 0.5F, 1, 0.5F);
            MMSDK.Log.v("Explode");
            obj = scaleanimation;
        } while (true);
    }

    private android.widget.RelativeLayout.LayoutParams getCloseAreaParams(float f)
    {
        int i = (int)(0.5F + 50F * f);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i, i);
        layoutparams.addRule(11);
        layoutparams.addRule(10);
        return layoutparams;
    }

    private Button initMRaidCloseButton(Context context, float f)
    {
        Button button = new Button(context);
        button.setId(301);
        mraidCloseDrawable = new CloseTopDrawable(true, f);
        button.setOnClickListener(new _cls1());
        android.widget.RelativeLayout.LayoutParams layoutparams = getCloseAreaParams(f);
        button.setLayoutParams(layoutparams);
        button.post(new SetCloseButtonTouchDelegateRunnable(button, layoutparams.topMargin, layoutparams.leftMargin, layoutparams.bottomMargin, layoutparams.rightMargin));
        return button;
    }

    private void initProgressBar()
    {
        AdViewOverlayActivity adviewoverlayactivity = (AdViewOverlayActivity)overlayActivityRef.get();
        if (adviewoverlayactivity != null)
        {
            progressBar = new ProgressBar(adviewoverlayactivity.activity);
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(0);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(13);
            addView(progressBar, layoutparams);
        }
    }

    private void removeProgressBar()
    {
        if (!progressDone && progressBar != null)
        {
            progressDone = true;
            progressBar.setVisibility(8);
            removeView(progressBar);
            progressBar = null;
        }
    }

    void addInlineVideo()
    {
        super.addInlineVideo();
        bringMraidCloseToFront();
    }

    void attachWebViewToLink()
    {
        if (adImpl.linkForExpansionId != 0L)
        {
            MMAdImplController.attachWebViewFromOverlay(adImpl);
        }
    }

    void bringMraidCloseToFront()
    {
        if (mraidCloseButton != null)
        {
            mraidCloseButton.bringToFront();
        }
    }

    void closeAreaTouched()
    {
        post(new _cls2());
    }

    void finishOverlayWithAnimation()
    {
        MMSDK.Log.d("Ad overlay closed");
        if ((Activity)getContext() == null)
        {
            return;
        } else
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
            alphaanimation.setAnimationListener(new _cls3());
            alphaanimation.setFillEnabled(true);
            alphaanimation.setFillBefore(true);
            alphaanimation.setFillAfter(true);
            alphaanimation.setDuration(400L);
            startAnimation(alphaanimation);
            return;
        }
    }

    void fullScreenVideoLayout()
    {
        removeView(inlineVideoLayout);
        addView(inlineVideoLayout, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        bringMraidCloseToFront();
    }

    Object getNonConfigurationInstance()
    {
        MMSDK.Log.d((new StringBuilder("Saving getNonConfigurationInstance for ")).append(adImpl).toString());
        NonConfigurationInstance nonconfigurationinstance = new NonConfigurationInstance(null);
        if (adImpl.controller != null)
        {
            adImpl.controller.webView.removeFromParent();
        }
        nonconfigurationinstance.progressDone = progressDone;
        nonconfigurationinstance.controller = adImpl.controller;
        nonconfigurationinstance.settings = settings;
        return nonconfigurationinstance;
    }

    void getWebContent(String s)
    {
        (new FetchWebViewContentTask(s)).execute(new Void[0]);
    }

    void injectJS(String s)
    {
        if (adImpl.controller != null)
        {
            adImpl.controller.loadUrl(s);
        }
    }

    void inlineConfigChange()
    {
        if (inlineVideoView != null && inlineVideoLayout != null)
        {
            inlineVideoLayout.setLayoutParams(inlineVideoView.getCustomLayoutParams());
            bringMraidCloseToFront();
        }
    }

    void repositionVideoLayout()
    {
        removeView(inlineVideoLayout);
        addView(inlineVideoLayout, inlineVideoView.getCustomLayoutParams());
        bringMraidCloseToFront();
    }

    void setUseCustomClose(boolean flag)
    {
        settings.setUseCustomClose(flag);
        Button button = mraidCloseButton;
        Object obj;
        if (flag)
        {
            obj = null;
        } else
        {
            obj = mraidCloseDrawable;
        }
        button.setBackgroundDrawable(((Drawable) (obj)));
    }





    private class AdViewOverlayViewMMAdImpl extends MMLayout.MMLayoutMMAdImpl
    {

        final AdViewOverlayView this$0;

        MMWebViewClient getMMWebViewClient()
        {
            MMSDK.Log.d((new StringBuilder("Returning a client for user: OverlayWebViewClient, adimpl=")).append(adImpl).toString());
            class OverlayRedirectionListenerImpl extends MMAdImpl.MMAdImplRedirectionListenerImpl
            {

                final AdViewOverlayViewMMAdImpl this$1;

                public boolean isExpandingToUrl()
                {
                    return settings.hasExpandUrl() && !settings.hasLoadedExpandUrl();
                }

                OverlayRedirectionListenerImpl()
                {
                    this$1 = AdViewOverlayViewMMAdImpl.this;
                    super(AdViewOverlayViewMMAdImpl.this);
                }
            }

            if (adImpl.linkForExpansionId != 0L || settings.hasExpandUrl())
            {
                BannerExpandedWebViewClient bannerexpandedwebviewclient = new BannerExpandedWebViewClient(mmWebViewClientListener, new OverlayRedirectionListenerImpl());
                mmWebViewClient = bannerexpandedwebviewclient;
                return bannerexpandedwebviewclient;
            } else
            {
                InterstitialWebViewClient interstitialwebviewclient = new InterstitialWebViewClient(mmWebViewClientListener, new OverlayRedirectionListenerImpl());
                mmWebViewClient = interstitialwebviewclient;
                return interstitialwebviewclient;
            }
        }

        public AdViewOverlayViewMMAdImpl(Context context)
        {
            this$0 = AdViewOverlayView.this;
            super(AdViewOverlayView.this, context);
            class _cls1 extends MMAdImpl.BasicMMWebViewClientListener
            {

                final AdViewOverlayViewMMAdImpl this$1;
                final AdViewOverlayView val$this$0;

                public void onPageFinished(String s)
                {
                    super.onPageFinished(s);
                    removeProgressBar();
                }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            }

            mmWebViewClientListener = new _cls1();
        }
    }


    private class NonConfigurationInstance
    {

        MMAdImplController controller;
        boolean progressDone;
        OverlaySettings settings;

        private NonConfigurationInstance()
        {
        }

        NonConfigurationInstance(_cls1 _pcls1)
        {
            this();
        }
    }


    private class CloseTopDrawable extends CloseDrawable
    {
        private class CloseDrawable extends Drawable
        {

            protected boolean enabled;
            protected final Paint paint = new Paint();

            public void draw(Canvas canvas)
            {
                Rect rect = copyBounds();
                int i = rect.right - rect.left;
                int j = rect.bottom - rect.top;
                float f = (float)i / 6F;
                paint.setStrokeWidth(f);
                char c;
                if (enabled)
                {
                    c = '\377';
                } else
                {
                    c = 'P';
                }
                paint.setARGB(255, c, c, c);
                canvas.drawLine(f / 2.0F, f / 2.0F, (float)i - f / 2.0F, (float)j - f / 2.0F, paint);
                canvas.drawLine((float)i - f / 2.0F, f / 2.0F, f / 2.0F, (float)j - f / 2.0F, paint);
            }

            public int getOpacity()
            {
                return -3;
            }

            public void setAlpha(int i)
            {
            }

            public void setColorFilter(ColorFilter colorfilter)
            {
            }

            CloseDrawable(boolean flag)
            {
                enabled = true;
                enabled = flag;
                paint.setAntiAlias(true);
                paint.setStyle(android.graphics.Paint.Style.STROKE);
            }
        }


        final float dist;
        final float scale;

        public void draw(Canvas canvas)
        {
            Rect rect = copyBounds();
            float f = (float)(rect.right - rect.left) / 10F;
            float f1 = (float)rect.right - 20F * scale;
            float f2 = (float)rect.top + 20F * scale;
            paint.setStrokeWidth(f);
            paint.setColor(0xff000000);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawCircle(f1, f2, 12F * scale, paint);
            paint.setColor(-1);
            paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(f1, f2, 10F * scale, paint);
            paint.setColor(0xff000000);
            canvas.drawCircle(f1, f2, 7F * scale, paint);
            paint.setColor(-1);
            paint.setStrokeWidth(f / 2.0F);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawLine(f1 - dist, f2 - dist, f1 + dist, f2 + dist, paint);
            canvas.drawLine(f1 + dist, f2 - dist, f1 - dist, f2 + dist, paint);
        }

        CloseTopDrawable(boolean flag, float f)
        {
            super(flag);
            scale = f;
            dist = 4F * f;
            paint.setColor(0xff000000);
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final AdViewOverlayView this$0;

        public void onClick(View view)
        {
            MMSDK.Log.v("Close button clicked.");
            finishOverlayWithAnimation();
        }

        _cls1()
        {
            this$0 = AdViewOverlayView.this;
            super();
        }
    }


    private class SetCloseButtonTouchDelegateRunnable
        implements Runnable
    {

        int bottom;
        private final Button closeButton;
        int left;
        int right;
        int top;

        public void run()
        {
            Rect rect = new Rect();
            closeButton.getHitRect(rect);
            rect.top = rect.top + top;
            rect.right = rect.right + right;
            rect.bottom = rect.bottom + bottom;
            rect.left = rect.left + left;
            TouchDelegate touchdelegate = new TouchDelegate(rect, closeButton);
            if (android/view/View.isInstance(closeButton.getParent()))
            {
                ((View)closeButton.getParent()).setTouchDelegate(touchdelegate);
            }
        }

        SetCloseButtonTouchDelegateRunnable(Button button, int i, int j, int k, int l)
        {
            closeButton = button;
            top = i;
            left = j;
            bottom = k;
            right = l;
        }
    }


    private class _cls2
        implements Runnable
    {

        final AdViewOverlayView this$0;

        public void run()
        {
            finishOverlayWithAnimation();
        }

        _cls2()
        {
            this$0 = AdViewOverlayView.this;
            super();
        }
    }


    private class _cls3
        implements android.view.animation.Animation.AnimationListener
    {

        final AdViewOverlayView this$0;

        public void onAnimationEnd(Animation animation)
        {
            Activity activity = (Activity)getContext();
            MMSDK.Log.d("Finishing overlay this is in w/ anim finishOverLayWithAnim()");
            attachWebViewToLink();
            activity.finish();
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            if (mraidCloseButton != null)
            {
                mraidCloseButton.setVisibility(8);
            }
        }

        _cls3()
        {
            this$0 = AdViewOverlayView.this;
            super();
        }
    }


    private class FetchWebViewContentTask extends AsyncTask
    {

        private String baseUrl;
        private boolean cancelVideo;
        final AdViewOverlayView this$0;

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
                AdViewOverlayActivity adviewoverlayactivity = (AdViewOverlayActivity)overlayActivityRef.get();
                if (adviewoverlayactivity != null)
                {
                    adviewoverlayactivity.finish();
                } else
                {
                    removeProgressBar();
                }
            }
            if (s != null)
            {
                adImpl.controller.setWebViewContent(s, baseUrl);
            }
        }

        protected void onPreExecute()
        {
            if (progressBar == null)
            {
                initProgressBar();
            }
            super.onPreExecute();
        }

        public FetchWebViewContentTask(String s)
        {
            this$0 = AdViewOverlayView.this;
            super();
            baseUrl = s;
        }
    }

}
