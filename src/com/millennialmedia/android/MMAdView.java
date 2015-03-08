// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.millennialmedia.android:
//            MMLayout, MMAdImpl, MMRequest, MMSDK, 
//            DTOResizeParameters, MMAdImplController, MMWebView, RequestListener

public final class MMAdView extends MMLayout
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener
{

    static final int DEFAULT_RESIZE_PARAM_VALUES = -50;
    public static final int TRANSITION_DOWN = 3;
    public static final int TRANSITION_FADE = 1;
    public static final int TRANSITION_NONE = 0;
    public static final int TRANSITION_RANDOM = 4;
    public static final int TRANSITION_UP = 2;
    int height;
    int oldHeight;
    int oldWidth;
    ImageView refreshAnimationimageView;
    int transitionType;
    ResizeView view;
    int width;

    public MMAdView(Context context)
    {
        super(context);
        transitionType = 4;
        height = 0;
        width = 0;
        oldHeight = -50;
        oldWidth = -50;
        adImpl = new MMAdViewMMAdImpl(context);
        init(context);
    }

    public MMAdView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MMAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        transitionType = 4;
        height = 0;
        width = 0;
        oldHeight = -50;
        oldWidth = -50;
        if (!isInEditMode())
        {
            MMSDK.Log.d("Creating MMAdView from XML layout.");
            adImpl = new MMAdViewMMAdImpl(context);
            if (attributeset != null)
            {
                super.setApid(attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "apid"));
                adImpl.ignoreDensityScaling = attributeset.getAttributeBooleanValue("http://millennialmedia.com/android/schema", "ignoreDensityScaling", false);
                String s = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "height");
                String s1 = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "width");
                try
                {
                    if (!TextUtils.isEmpty(s))
                    {
                        height = Integer.parseInt(s);
                    }
                    if (!TextUtils.isEmpty(s1))
                    {
                        width = Integer.parseInt(s1);
                    }
                }
                catch (NumberFormatException numberformatexception) { }
                if (adImpl.mmRequest != null)
                {
                    adImpl.mmRequest.age = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "age");
                    adImpl.mmRequest.children = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "children");
                    adImpl.mmRequest.education = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "education");
                    adImpl.mmRequest.ethnicity = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "ethnicity");
                    adImpl.mmRequest.gender = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "gender");
                    adImpl.mmRequest.income = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "income");
                    adImpl.mmRequest.keywords = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "keywords");
                    adImpl.mmRequest.orientation = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "orientation");
                    adImpl.mmRequest.marital = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "marital");
                    adImpl.mmRequest.politics = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "politics");
                    adImpl.mmRequest.vendor = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "vendor");
                    adImpl.mmRequest.zip = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "zip");
                }
                goalId = attributeset.getAttributeValue("http://millennialmedia.com/android/schema", "goalId");
            }
            adImpl.xmlLayout = true;
            init(context);
            return;
        } else
        {
            initEclipseAd(context);
            return;
        }
    }

    private void attachToWindow(View view1)
    {
        this;
        JVM INSTR monitorenter ;
        Context context;
        detachFromParent(view1);
        context = getContext();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        Window window;
        if (!(context instanceof Activity))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        window = ((Activity)context).getWindow();
        if (window == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        View view2 = window.getDecorView();
        if (view2 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (view2 instanceof ViewGroup)
        {
            ((ViewGroup)view2).addView(view1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void callSetTranslationX(int i)
    {
        try
        {
            Class aclass[] = new Class[1];
            aclass[0] = Float.TYPE;
            Method method = android/view/View.getMethod("setTranslationX", aclass);
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(i);
            method.invoke(this, aobj);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void callSetTranslationY(int i)
    {
        try
        {
            Class aclass[] = new Class[1];
            aclass[0] = Float.TYPE;
            Method method = android/view/View.getMethod("setTranslationY", aclass);
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(i);
            method.invoke(this, aobj);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void detachFromParent(View view1)
    {
        this;
        JVM INSTR monitorenter ;
        if (view1 == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        android.view.ViewParent viewparent = getParent();
        if (viewparent == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        if (viewparent instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)viewparent;
            if (view1.getParent() != null)
            {
                viewgroup.removeView(view1);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void getAdInternal()
    {
        if (adImpl != null)
        {
            adImpl.requestAd();
        }
    }

    private boolean hasDefaultResizeParams()
    {
        return oldWidth == -50 && oldHeight == -50;
    }

    private void init(Context context)
    {
        setBackgroundColor(0);
        adImpl.adType = "b";
        setOnClickListener(this);
        setFocusable(true);
        refreshAnimationimageView = new ImageView(context);
        refreshAnimationimageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        refreshAnimationimageView.setVisibility(8);
        addView(refreshAnimationimageView, new android.widget.RelativeLayout.LayoutParams(-2, -2));
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
    }

    private void initEclipseAd(Context context)
    {
        FileOutputStream fileoutputstream;
        ImageView imageview;
        fileoutputstream = null;
        imageview = new ImageView(context);
        String s = System.getProperty("java.io.tmpdir");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (!s.endsWith(File.separator))
        {
            s = (new StringBuilder()).append(s).append(File.separator).toString();
        }
        File file;
        InputStream inputstream2;
        file = new File((new StringBuilder()).append(s).append("millenial355jns6u3l1nmedia.png").toString());
        if (file.exists())
        {
            break MISSING_BLOCK_LABEL_373;
        }
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL("http://images.millennialmedia.com/9513/192134.gif")).openConnection();
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setConnectTimeout(3000);
        httpurlconnection.connect();
        inputstream2 = httpurlconnection.getInputStream();
        InputStream inputstream1 = inputstream2;
        FileOutputStream fileoutputstream1 = new FileOutputStream(file);
        byte abyte0[] = new byte[1024];
_L3:
        int i = inputstream1.read(abyte0);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        fileoutputstream1.write(abyte0, 0, i);
          goto _L3
        Exception exception8;
        exception8;
        InputStream inputstream = inputstream1;
_L6:
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        inputstream.close();
        Exception exception2;
        Exception exception5;
        Bitmap bitmap;
        Exception exception7;
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (Exception exception1) { }
        }
        addView(imageview);
        return;
_L2:
        inputstream = inputstream1;
_L7:
        bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        imageview.setImageBitmap(bitmap);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        inputstream.close();
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (Exception exception6) { }
        }
        break MISSING_BLOCK_LABEL_215;
        exception2;
        inputstream1 = null;
_L5:
        if (inputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        inputstream1.close();
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            catch (Exception exception3) { }
        }
        throw exception2;
        exception2;
        fileoutputstream = null;
        continue; /* Loop/switch isn't completed */
        exception7;
        fileoutputstream = fileoutputstream1;
        exception2 = exception7;
        continue; /* Loop/switch isn't completed */
        exception5;
        inputstream1 = inputstream;
        fileoutputstream = fileoutputstream1;
        exception2 = exception5;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        fileoutputstream1 = null;
        inputstream = null;
          goto _L6
        Exception exception9;
        exception9;
        inputstream = inputstream1;
        fileoutputstream1 = null;
          goto _L6
        Exception exception4;
        exception4;
          goto _L6
        fileoutputstream1 = null;
        inputstream = null;
          goto _L7
    }

    private void setUnresizeParameters()
    {
        if (hasDefaultResizeParams())
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            oldWidth = layoutparams.width;
            oldHeight = layoutparams.height;
            if (oldWidth <= 0)
            {
                oldWidth = getWidth();
            }
            if (oldHeight <= 0)
            {
                oldHeight = getHeight();
            }
        }
    }

    public final volatile void addBlackView()
    {
        super.addBlackView();
    }

    final void closeAreaTouched()
    {
        adImpl.unresizeToDefault();
    }

    public final void getAd()
    {
        if (adImpl != null && adImpl.requestListener != null)
        {
            getAd(adImpl.requestListener);
            return;
        } else
        {
            getAdInternal();
            return;
        }
    }

    public final void getAd(RequestListener requestlistener)
    {
        if (adImpl != null)
        {
            adImpl.requestListener = requestlistener;
        }
        getAdInternal();
    }

    public final volatile String getApid()
    {
        return super.getApid();
    }

    public final volatile boolean getIgnoresDensityScaling()
    {
        return super.getIgnoresDensityScaling();
    }

    public final volatile RequestListener getListener()
    {
        return super.getListener();
    }

    public final volatile MMRequest getMMRequest()
    {
        return super.getMMRequest();
    }

    final void handleMraidResize(DTOResizeParameters dtoresizeparameters)
    {
        this;
        JVM INSTR monitorenter ;
        android.view.ViewParent viewparent;
        refreshAnimationimageView.setImageBitmap(null);
        if (!MMSDK.hasSetTranslationMethod())
        {
            break MISSING_BLOCK_LABEL_227;
        }
        if (view == null)
        {
            view = new ResizeView(getContext());
            view.setId(0x121f0dbe);
            view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(1, 1));
            view.setBackgroundColor(0);
        }
        if (view.getParent() != null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        viewparent = getParent();
        if (viewparent == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (viewparent instanceof ViewGroup)
        {
            ((ViewGroup)viewparent).addView(view);
        }
        BannerBounds bannerbounds = new BannerBounds(dtoresizeparameters);
        if (!dtoresizeparameters.allowOffScreen)
        {
            bannerbounds.calculateOnScreenBounds();
        }
        int ai[] = new int[2];
        getLocationInWindow(ai);
        attachToWindow(this);
        int ai1[] = new int[2];
        getLocationInWindow(ai1);
        setUnresizeParameters();
        int i = ai[0] - ai1[0];
        int j = ai[1] - ai1[1];
        bannerbounds.modifyLayoutParams(getLayoutParams());
        callSetTranslationX(i + bannerbounds.translationX);
        callSetTranslationY(j + bannerbounds.translationY);
        setCloseArea(dtoresizeparameters.customClosePosition);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void handleUnresize()
    {
        this;
        JVM INSTR monitorenter ;
        android.view.ViewParent viewparent;
        if (!MMSDK.hasSetTranslationMethod())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        removeCloseTouchDelegate();
        if (!hasDefaultResizeParams())
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            layoutparams.width = oldWidth;
            layoutparams.height = oldHeight;
            callSetTranslationX(0);
            callSetTranslationY(0);
            oldWidth = -50;
            oldHeight = -50;
        }
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        isResizing = true;
        view.attachToContext(this);
        viewparent = getParent();
        if (viewparent == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (viewparent instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)viewparent;
            if (view.getParent() != null)
            {
                viewgroup.removeView(view);
            }
        }
        isResizing = false;
        setBackgroundColor(0xff0000ff);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onAnimationEnd(Animation animation)
    {
        refreshAnimationimageView.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    public final void onClick(View view1)
    {
        MMSDK.Log.d((new StringBuilder("On click for ")).append(view1.getId()).append(" view, ").append(view1).append(" adimpl").append(adImpl).toString());
        onTouchEvent(MotionEvent.obtain(0L, System.currentTimeMillis(), 1, 0.0F, 0.0F, 0));
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        Object aobj[] = new Object[5];
        aobj[0] = Boolean.valueOf(flag);
        aobj[1] = Integer.valueOf(i);
        aobj[2] = Integer.valueOf(j);
        aobj[3] = Integer.valueOf(k);
        aobj[4] = Integer.valueOf(l);
        MMSDK.Log.w(String.format("AdView onLayout changed%b int left %d int top %d int right %d int bottom %d", aobj));
        float f = getContext().getResources().getDisplayMetrics().density;
        if (width <= 0)
        {
            width = (int)((float)getWidth() / f);
        }
        if (height <= 0)
        {
            height = (int)((float)getHeight() / f);
        }
    }

    public final volatile boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    public final void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && adImpl.controller != null)
        {
            if (adImpl.controller.webView == null)
            {
                adImpl.controller.webView = MMAdImplController.getWebViewFromExistingAdImpl(adImpl);
            }
            if (!adImpl.controller.webView.isCurrentParent(adImpl.internalId))
            {
                adImpl.controller.webView.removeFromParent();
                addView(adImpl.controller.webView);
            }
        }
    }

    public final volatile void removeBlackView()
    {
        super.removeBlackView();
    }

    public final volatile void setApid(String s)
    {
        super.setApid(s);
    }

    public final void setHeight(int i)
    {
        height = i;
    }

    public final volatile void setIgnoresDensityScaling(boolean flag)
    {
        super.setIgnoresDensityScaling(flag);
    }

    public final volatile void setListener(RequestListener requestlistener)
    {
        super.setListener(requestlistener);
    }

    public final volatile void setMMRequest(MMRequest mmrequest)
    {
        super.setMMRequest(mmrequest);
    }

    public final void setTransitionType(int i)
    {
        transitionType = i;
    }

    public final void setWidth(int i)
    {
        width = i;
    }



    private class MMAdViewMMAdImpl extends MMLayout.MMLayoutMMAdImpl
    {

        final MMAdView this$0;

        void animateTransition()
        {
            class _cls2
                implements Runnable
            {

                final MMAdViewMMAdImpl this$1;

                public void run()
                {
                    int i;
                    i = transitionType;
                    if (i == 4)
                    {
                        i = (new Random()).nextInt(4);
                    }
                    i;
                    JVM INSTR tableswitch 2 3: default 52
                //                               2 110
                //                               3 136;
                       goto _L1 _L2 _L3
_L1:
                    Object obj = new AlphaAnimation(1.0F, 0.0F);
_L5:
                    ((Animation) (obj)).setDuration(1000L);
                    ((Animation) (obj)).setAnimationListener(_fld0);
                    ((Animation) (obj)).setFillEnabled(true);
                    ((Animation) (obj)).setFillBefore(true);
                    ((Animation) (obj)).setFillAfter(true);
                    refreshAnimationimageView.startAnimation(((Animation) (obj)));
                    return;
_L2:
                    obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(float)getHeight());
                    continue; /* Loop/switch isn't completed */
_L3:
                    obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, getHeight());
                    if (true) goto _L5; else goto _L4
_L4:
                }

                _cls2()
                {
                    this$1 = MMAdViewMMAdImpl.this;
                    super();
                }
            }

            if (refreshAnimationimageView.getDrawable() != null)
            {
                MMSDK.runOnUiThread(new _cls2());
            }
        }

        String getReqType()
        {
            return "getad";
        }

        String getRequestCompletedAction()
        {
            return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
        }

        String getRequestFailedAction()
        {
            return "millennialmedia.action.ACTION_GETAD_FAILED";
        }

        public boolean hasCachedVideoSupport()
        {
            return false;
        }

        void insertUrlAdMetaValues(Map map)
        {
            if (height > 0)
            {
                map.put("hsht", String.valueOf(height));
            }
            if (width > 0)
            {
                map.put("hswd", String.valueOf(width));
            }
            super.insertUrlAdMetaValues(map);
        }

        public boolean isBanner()
        {
            return true;
        }

        boolean isLifecycleObservable()
        {
            return getWindowToken() != null;
        }

        boolean isTransitionAnimated()
        {
            return transitionType != 0;
        }

        void prepareTransition(Bitmap bitmap)
        {
            refreshAnimationimageView.setImageBitmap(bitmap);
            refreshAnimationimageView.setVisibility(0);
            refreshAnimationimageView.bringToFront();
        }

        public MMAdViewMMAdImpl(Context context)
        {
            this$0 = MMAdView.this;
            super(MMAdView.this, context);
            class _cls1 extends MMAdImpl.BasicMMWebViewClientListener
            {

                final MMAdViewMMAdImpl this$1;
                final MMAdView val$this$0;

                public void onPageFinished(String s)
                {
                    super.onPageFinished(s);
                    if (isTransitionAnimated())
                    {
                        animateTransition();
                    }
                }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
            }

            mmWebViewClientListener = new _cls1();
        }
    }


    private class ResizeView extends View
    {

        final MMAdView this$0;

        void attachToContext(View view1)
        {
            this;
            JVM INSTR monitorenter ;
            detachFromParent(view1);
            if (getParent() != null && (getParent() instanceof ViewGroup))
            {
                ((ViewGroup)getParent()).addView(view1);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        protected void onRestoreInstanceState(Parcelable parcelable)
        {
            MMSDK.Log.d("onRestoreInstanceState");
            attachToWindow(MMAdView.this);
            super.onRestoreInstanceState(parcelable);
        }

        protected Parcelable onSaveInstanceState()
        {
            MMSDK.Log.d("onSaveInstanceState");
            attachToContext(MMAdView.this);
            return super.onSaveInstanceState();
        }

        public ResizeView(Context context)
        {
            this$0 = MMAdView.this;
            super(context);
        }
    }


    private class BannerBounds
    {

        DTOResizeParameters resizeParams;
        final MMAdView this$0;
        int translationX;
        int translationY;

        private BoundsResult calculateBounds(int i, int j, int k, int l)
        {
            if (j + (i + k) <= l) goto _L2; else goto _L1
_L1:
            j += l - k;
            if (j >= 0) goto _L4; else goto _L3
_L3:
            j = 0;
            k = l;
_L6:
            class BoundsResult
            {

                int size;
                final BannerBounds this$1;
                int translation;

                private BoundsResult()
                {
                    this$1 = BannerBounds.this;
                    super();
                }

                BoundsResult(_cls1 _pcls1)
                {
                    this();
                }
            }

            BoundsResult boundsresult = new BoundsResult(null);
            boundsresult.translation = j - i;
            boundsresult.size = k;
            return boundsresult;
_L4:
            if (j + k > l)
            {
                j = l - k;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (j <= 0)
            {
                j = i;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        private void calculateXBounds()
        {
            int ai[] = new int[2];
            getLocationInWindow(ai);
            BoundsResult boundsresult = calculateBounds(ai[0], resizeParams.offsetX, resizeParams.width, resizeParams.xMax);
            resizeParams.width = boundsresult.size;
            translationX = boundsresult.translation;
        }

        private void calculateYBounds()
        {
            int ai[] = new int[2];
            getLocationInWindow(ai);
            BoundsResult boundsresult = calculateBounds(ai[1], resizeParams.offsetY, resizeParams.height, resizeParams.yMax);
            resizeParams.height = boundsresult.size;
            translationY = boundsresult.translation;
        }

        void calculateOnScreenBounds()
        {
            calculateXBounds();
            calculateYBounds();
        }

        android.view.ViewGroup.LayoutParams modifyLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            layoutparams.width = resizeParams.width;
            layoutparams.height = resizeParams.height;
            return layoutparams;
        }

        BannerBounds(DTOResizeParameters dtoresizeparameters)
        {
            this$0 = MMAdView.this;
            super();
            resizeParams = dtoresizeparameters;
            translationX = dtoresizeparameters.offsetX;
            translationY = dtoresizeparameters.offsetY;
        }
    }

}
