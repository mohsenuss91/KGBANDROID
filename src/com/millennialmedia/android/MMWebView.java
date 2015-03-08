// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.millennialmedia.google.gson.Gson;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            HandShake, MMAdView, MMSDK, MMActivity, 
//            AdViewOverlayView, MMLayout, MMAdImpl, DTOAdViewLayout, 
//            MRaid, DTOResizeParameters

class MMWebView extends WebView
{

    static final String JS_INTERFACE_NAME = "interface";
    static final String PROPERTY_BANNER_TYPE = "PROPERTY_BANNER_TYPE";
    static final String PROPERTY_EXPANDING = "PROPERTY_EXPANDING";
    static final String PROPERTY_STATE = "PROPERTY_STATE";
    long creatorAdImplId;
    String currentUrl;
    volatile boolean isExpanding;
    volatile boolean isUserClosedResize;
    private MyWebChromeClient mWebChromeClient;
    volatile String mraidState;
    int oldHeight;
    int oldWidth;
    volatile boolean requiresPreAdSizeFix;
    final GestureDetector tapDetector;
    final String userAgent;

    public MMWebView(final Context context, long l)
    {
        super(context);
        mWebChromeClient = new MyWebChromeClient(null);
        oldHeight = -50;
        oldWidth = -50;
        MMSDK.Log.d((new StringBuilder("Setting isExpanding in constructor to ")).append(isExpanding).toString());
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOnTouchListener(new _cls1());
        mraidState = "loading";
        creatorAdImplId = l;
        Object aobj[] = new Object[1];
        aobj[0] = Long.valueOf(creatorAdImplId);
        MMSDK.Log.v("Assigning WebView internal id: %d", aobj);
        setId((int)(15063L + creatorAdImplId));
        WebSettings websettings;
        if (HandShake.sharedHandShake(getContext()).hardwareAccelerationEnabled)
        {
            enableHardwareAcceleration();
        } else
        {
            disableAllAcceleration();
        }
        setMediaPlaybackRequiresUserGesture(false);
        setWebChromeClient(mWebChromeClient);
        websettings = getSettings();
        userAgent = (new StringBuilder()).append(websettings.getUserAgentString()).append(Build.MODEL).toString();
        websettings.setJavaScriptEnabled(true);
        websettings.setCacheMode(-1);
        websettings.setDefaultTextEncodingName("UTF-8");
        websettings.setLoadWithOverviewMode(true);
        websettings.setGeolocationEnabled(true);
        websettings.setJavaScriptCanOpenWindowsAutomatically(true);
        tapDetector = new GestureDetector(context, new _cls2());
    }

    private boolean canScroll()
    {
        return getParent() instanceof MMAdView;
    }

    private boolean hasDefaultResizeParams()
    {
        return oldWidth == -50 && oldHeight == -50;
    }

    void animateTransition(final MMAdImpl adImpl)
    {
        _cls5 _lcls5 = new _cls5();
        _lcls5;
        JVM INSTR monitorenter ;
        MMSDK.runOnUiThread(_lcls5);
        _lcls5.wait();
        _lcls5;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        _lcls5;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        _lcls5.notify();
        return;
    }

    void disableAllAcceleration()
    {
        try
        {
            Class aclass[] = new Class[2];
            aclass[0] = Integer.TYPE;
            aclass[1] = android/graphics/Paint;
            Method method = android/webkit/WebView.getMethod("setLayerType", aclass);
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(0);
            aobj[1] = null;
            method.invoke(this, aobj);
            MMSDK.Log.d("Remove allAcceleration");
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    void enableHardwareAcceleration()
    {
        try
        {
            Class aclass[] = new Class[2];
            aclass[0] = Integer.TYPE;
            aclass[1] = android/graphics/Paint;
            Method method = android/webkit/WebView.getMethod("setLayerType", aclass);
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(2);
            aobj[1] = null;
            method.invoke(this, aobj);
            MMSDK.Log.d("Enabled hardwareAcceleration");
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    void enableSoftwareAcceleration()
    {
        try
        {
            Class aclass[] = new Class[2];
            aclass[0] = Integer.TYPE;
            aclass[1] = android/graphics/Paint;
            Method method = android/webkit/WebView.getMethod("setLayerType", aclass);
            Object aobj[] = new Object[2];
            aobj[0] = Integer.valueOf(1);
            aobj[1] = null;
            method.invoke(this, aobj);
            MMSDK.Log.d("Remove allAcceleration");
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    Activity getActivity()
    {
        this;
        JVM INSTR monitorenter ;
        android.view.ViewParent viewparent = getParent();
        if (viewparent == null) goto _L2; else goto _L1
_L1:
        if (!(viewparent instanceof ViewGroup)) goto _L2; else goto _L3
_L3:
        Context context = ((ViewGroup)viewparent).getContext();
        if (context == null) goto _L2; else goto _L4
_L4:
        if (!(context instanceof MMActivity)) goto _L2; else goto _L5
_L5:
        MMActivity mmactivity = (MMActivity)context;
_L7:
        this;
        JVM INSTR monitorexit ;
        return mmactivity;
_L2:
        mmactivity = null;
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    AdViewOverlayView getAdViewOverlayView()
    {
        this;
        JVM INSTR monitorenter ;
        android.view.ViewParent viewparent = getParent();
        if (viewparent == null) goto _L2; else goto _L1
_L1:
        if (!(viewparent instanceof AdViewOverlayView)) goto _L2; else goto _L3
_L3:
        AdViewOverlayView adviewoverlayview = (AdViewOverlayView)viewparent;
_L5:
        this;
        JVM INSTR monitorexit ;
        return adviewoverlayview;
_L2:
        adviewoverlayview = null;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    MMAdView getBanner()
    {
        this;
        JVM INSTR monitorenter ;
        android.view.ViewParent viewparent = getParent();
        if (viewparent == null) goto _L2; else goto _L1
_L1:
        if (!(viewparent instanceof MMAdView)) goto _L2; else goto _L3
_L3:
        MMAdView mmadview = (MMAdView)viewparent;
_L5:
        this;
        JVM INSTR monitorexit ;
        return mmadview;
_L2:
        mmadview = null;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    MMAdView getMMAdView()
    {
        if (getParent() instanceof MMAdView)
        {
            return (MMAdView)getParent();
        } else
        {
            return null;
        }
    }

    MMLayout getMMLayout()
    {
        if (getParent() instanceof MMLayout)
        {
            return (MMLayout)getParent();
        } else
        {
            return null;
        }
    }

    String getUserAgent()
    {
        return userAgent;
    }

    boolean isCurrentParent(long l)
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent == null)
        {
            return false;
        }
        MMSDK.Log.w((new StringBuilder("Id check for parent: ")).append(l).append(" versus ").append(((MMLayout)viewparent).adImpl.internalId).toString());
        return l == ((MMLayout)viewparent).adImpl.internalId;
    }

    boolean isMraidResized()
    {
        return "resized".equals(mraidState);
    }

    boolean isOriginalUrl(String s)
    {
        return !TextUtils.isEmpty(currentUrl) && s.equals((new StringBuilder()).append(currentUrl).append("?").toString()) || s.equals((new StringBuilder()).append(currentUrl).append("#").toString());
    }

    boolean isParentBannerAd()
    {
        if (getParent() != null)
        {
            return (ViewGroup)getParent() instanceof MMAdView;
        } else
        {
            return false;
        }
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        currentUrl = s;
        super.loadDataWithBaseURL(s, s1, s2, s3, s4);
    }

    public void loadUrl(String s)
    {
        if (s.startsWith("http"))
        {
            currentUrl = s;
        }
        MMSDK.Log.v((new StringBuilder("loadUrl @@")).append(s).toString());
        super.loadUrl(s);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int k = android.view.View.MeasureSpec.getSize(j);
        int l = android.view.View.MeasureSpec.getSize(i);
        int i1 = getMeasuredHeight();
        if (i1 != 0)
        {
            k = i1;
        }
        if (requiresPreAdSizeFix)
        {
            setMeasuredDimension(1, 1);
            return;
        } else
        {
            setMeasuredDimension(l, k);
            return;
        }
    }

    public void onPauseWebViewVideo()
    {
        try
        {
            android/webkit/WebView.getMethod("onPause", new Class[0]).invoke(this, new Object[0]);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void onResumeWebViewVideo()
    {
        try
        {
            android/webkit/WebView.getMethod("onResume", new Class[0]).invoke(this, new Object[0]);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        int ai[] = new int[2];
        getLocationInWindow(ai);
        DTOAdViewLayout dtoadviewlayout = new DTOAdViewLayout(ai[0], ai[1], getWidth(), getHeight());
        loadUrl((new StringBuilder("javascript:MMJS.sdk.setAdSize(")).append((new Gson()).toJson(dtoadviewlayout)).append(");").toString());
        super.onSizeChanged(i, j, k, l);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        requestFocus();
        tapDetector.onTouchEvent(motionevent);
        if (motionevent.getAction() == 1)
        {
            Object aobj[] = new Object[3];
            aobj[0] = Integer.valueOf(motionevent.getAction());
            aobj[1] = Float.valueOf(motionevent.getX());
            aobj[2] = Float.valueOf(motionevent.getY());
            MMSDK.Log.v("Ad clicked: action=%d x=%f y=%f", aobj);
        }
        return super.onTouchEvent(motionevent);
    }

    void removeFromParent()
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            ((ViewGroup)viewparent).removeView(this);
        }
    }

    void setAdProperties(JSONObject jsonobject)
    {
        if (jsonobject != null)
        {
            loadUrl((new StringBuilder("javascript:MMJS.sdk.setAdProperties(")).append(jsonobject).append(");").toString());
        }
    }

    public void setBackgroundColor(int i)
    {
        if (i == 0)
        {
            enableSoftwareAcceleration();
        }
        super.setBackgroundColor(i);
    }

    void setMediaPlaybackRequiresUserGesture(boolean flag)
    {
        try
        {
            Class aclass[] = new Class[1];
            aclass[0] = Boolean.TYPE;
            Method method = android/webkit/WebView.getMethod("setMediaPlaybackRequiresUserGesture", aclass);
            Object aobj[] = new Object[1];
            aobj[0] = Boolean.valueOf(flag);
            method.invoke(this, aobj);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    void setMraidDefault()
    {
        loadUrl("javascript:MMJS.sdk.setState('default')");
        mraidState = "default";
    }

    void setMraidExpanded()
    {
        MMSDK.Log.d((new StringBuilder("Changing state to EXPANDED for ---- ")).append(toString()).append("---- of creatorId ---").append(creatorAdImplId).append(" ----").toString());
        loadUrl("javascript:MMJS.sdk.setState('expanded');");
        mraidState = "expanded";
    }

    void setMraidHidden()
    {
        loadUrl("javascript:MMJS.sdk.setState('hidden')");
        mraidState = "hidden";
    }

    void setMraidPlacementTypeInline()
    {
        loadUrl("javascript:MMJS.sdk.setPlacementType('inline');");
    }

    void setMraidPlacementTypeInterstitial()
    {
        loadUrl("javascript:MMJS.sdk.setPlacementType('interstitial');");
    }

    void setMraidReady()
    {
        loadUrl("javascript:MMJS.sdk.ready();");
    }

    void setMraidResize(final DTOResizeParameters resizeParams)
    {
        this;
        JVM INSTR monitorenter ;
        final MMAdView adView;
        if (!MMSDK.hasSetTranslationMethod())
        {
            break MISSING_BLOCK_LABEL_55;
        }
        adView = getMMAdView();
        isUserClosedResize = false;
        MMSDK.Log.d((new StringBuilder("New DTOResizeParameters = ")).append(resizeParams).toString());
        if (adView == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        MMSDK.runOnUiThread(new _cls6());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void setMraidViewableHidden()
    {
        loadUrl("javascript:MMJS.sdk.setViewable(false)");
    }

    void setMraidViewableVisible()
    {
        loadUrl("javascript:MMJS.sdk.setViewable(true)");
    }

    void setWebViewContent(final String finalContent, String s, Context context)
    {
        if (finalContent == null || s == null)
        {
            return;
        }
        final String finalBaseUrl = s.substring(0, 1 + s.lastIndexOf("/"));
        if (MMSDK.logLevel >= 5)
        {
            MMSDK.Log.v("Received ad with base url %s.", new Object[] {
                s
            });
            MMSDK.Log.v(finalContent);
        }
        if (MRaid.hasMraidLocally(context))
        {
            finalContent = MRaid.injectMraidJs(context, finalContent);
        } else
        {
            MMSDK.Log.e("MMJS is not downloaded");
        }
        MMSDK.runOnUiThread(new _cls4());
    }

    void setWebViewContent(final String finalContent, String s, final MMAdImpl adImpl)
    {
        if (finalContent == null || s == null || adImpl == null)
        {
            return;
        }
        unresizeToDefault(adImpl);
        final String baseUrl = s.substring(0, 1 + s.lastIndexOf("/"));
        if (MMSDK.logLevel >= 5)
        {
            MMSDK.Log.v("Received ad with base url %s.", new Object[] {
                baseUrl
            });
            MMSDK.Log.v(finalContent);
        }
        if (adImpl.isTransitionAnimated())
        {
            animateTransition(adImpl);
        }
        if (adImpl.ignoreDensityScaling)
        {
            finalContent = (new StringBuilder("<head><meta name=\"viewport\" content=\"target-densitydpi=device-dpi\" /></head>")).append(finalContent).toString();
        }
        if (MRaid.hasMraidLocally(adImpl.getContext()))
        {
            finalContent = MRaid.injectMraidJs(adImpl.getContext(), finalContent);
        } else
        {
            MMSDK.Log.e("MMJS is not downloaded");
        }
        MMSDK.runOnUiThread(new _cls3());
    }

    public String toString()
    {
        return (new StringBuilder("MMWebView originally from(")).append(creatorAdImplId).append(") MRaidState(").append(mraidState).append(").").toString();
    }

    void unresizeToDefault(MMAdImpl mmadimpl)
    {
        this;
        JVM INSTR monitorenter ;
        if (!MMSDK.hasSetTranslationMethod() || !isMraidResized() || mmadimpl == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        MMAd mmad = mmadimpl.getCallingAd();
        if (mmad instanceof MMAdView)
        {
            final MMAdView adView = (MMAdView)mmad;
            isUserClosedResize = true;
            MMSDK.runOnUiThread(new _cls7());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void updateArgumentsWithSettings(Map map)
    {
        String s;
        if (isParentBannerAd())
        {
            s = "true";
        } else
        {
            s = "false";
        }
        map.put("PROPERTY_BANNER_TYPE", s);
        map.put("PROPERTY_STATE", mraidState);
        map.put("PROPERTY_EXPANDING", String.valueOf(creatorAdImplId));
    }



    private class MyWebChromeClient extends WebChromeClient
    {

        private static final String KEY_USE_GEO = "mm_use_geo_location";
        final MMWebView this$0;

        private String getApplicationName(Context context)
        {
            PackageManager packagemanager = context.getApplicationContext().getPackageManager();
            android.content.pm.ApplicationInfo applicationinfo1 = packagemanager.getApplicationInfo(context.getPackageName(), 0);
            android.content.pm.ApplicationInfo applicationinfo = applicationinfo1;
_L1:
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            Object obj;
            if (applicationinfo != null)
            {
                obj = packagemanager.getApplicationLabel(applicationinfo);
            } else
            {
                obj = "This app";
            }
            return (String)(String)obj;
            namenotfoundexception;
            applicationinfo = null;
              goto _L1
        }

        private boolean isFirstGeoRequest()
        {
            boolean flag = getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location");
            boolean flag1 = false;
            if (!flag)
            {
                flag1 = true;
            }
            return flag1;
        }

        private boolean retrieveUseGeo()
        {
            return getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false);
        }

        private void saveUseGeo(boolean flag)
        {
            android.content.SharedPreferences.Editor editor = getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
            editor.putBoolean("mm_use_geo_location", flag);
            editor.commit();
        }

        public void onConsoleMessage(String s, int i, String s1)
        {
            MMSDK.Log.d((new StringBuilder()).append(s).append(" at ").append(s1).append(" -- line ").append(i).toString());
            super.onConsoleMessage(s, i, s1);
        }

        public void onGeolocationPermissionsShowPrompt(final String origin, final android.webkit.GeolocationPermissions.Callback callback)
        {
            if (!isFirstGeoRequest())
            {
                break MISSING_BLOCK_LABEL_104;
            }
            if (!retrieveUseGeo()) goto _L2; else goto _L1
_L1:
            callback.invoke(origin, true, true);
_L4:
            return;
_L2:
            Activity activity = getActivity();
            if (activity == null) goto _L4; else goto _L3
_L3:
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
            builder.setTitle(getApplicationName(activity));
            class _cls2
                implements android.content.DialogInterface.OnClickListener
            {

                final MyWebChromeClient this$1;
                final android.webkit.GeolocationPermissions.Callback val$callback;
                final String val$origin;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    saveUseGeo(true);
                    callback.invoke(origin, true, true);
                }

                _cls2()
                {
                    this$1 = MyWebChromeClient.this;
                    callback = callback1;
                    origin = s;
                    super();
                }
            }

            class _cls1
                implements android.content.DialogInterface.OnClickListener
            {

                final MyWebChromeClient this$1;
                final android.webkit.GeolocationPermissions.Callback val$callback;
                final String val$origin;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    saveUseGeo(false);
                    callback.invoke(origin, false, false);
                }

                _cls1()
                {
                    this$1 = MyWebChromeClient.this;
                    callback = callback1;
                    origin = s;
                    super();
                }
            }

            builder.setMessage("Would like to use your Current Location.").setPositiveButton("Allow", new _cls2()).setNegativeButton("Don't Allow", new _cls1());
            builder.create().show();
            return;
            callback.invoke(origin, false, false);
            return;
        }

        public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            if (getContext() != getContext().getApplicationContext())
            {
                return super.onJsAlert(webview, s, s1, jsresult);
            } else
            {
                Toast.makeText(getContext(), s1, 0).show();
                return true;
            }
        }


        private MyWebChromeClient()
        {
            this$0 = MMWebView.this;
            super();
        }

        MyWebChromeClient(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1
        implements android.view.View.OnTouchListener
    {

        final MMWebView this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            return motionevent.getAction() == 2 && canScroll();
        }

        _cls1()
        {
            this$0 = MMWebView.this;
            super();
        }
    }


    private class _cls2 extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final MMWebView this$0;
        final Context val$context;

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            MMSDK.Event.overlayTap(context, creatorAdImplId);
            return false;
        }

        _cls2()
        {
            this$0 = MMWebView.this;
            context = context1;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final MMWebView this$0;
        final MMAdImpl val$adImpl;

        public void run()
        {
            this;
            JVM INSTR monitorenter ;
            Bitmap bitmap;
            buildDrawingCache();
            bitmap = getDrawingCache();
            if (bitmap == null)
            {
                break MISSING_BLOCK_LABEL_36;
            }
            Bitmap bitmap1 = Bitmap.createBitmap(bitmap);
            adImpl.prepareTransition(bitmap1);
            destroyDrawingCache();
            notify();
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            MMSDK.Log.d(exception1);
            notify();
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            throw exception;
        }

        _cls5()
        {
            this$0 = MMWebView.this;
            adImpl = mmadimpl;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final MMWebView this$0;
        final MMAdView val$adView;
        final DTOResizeParameters val$resizeParams;

        private void handleMraidResize(DTOResizeParameters dtoresizeparameters)
        {
            MMAdView mmadview = adView;
            mmadview.getClass();
            MMAdView.BannerBounds bannerbounds = new MMAdView.BannerBounds(mmadview, dtoresizeparameters);
            setUnresizeParameters();
            bannerbounds.modifyLayoutParams(getLayoutParams());
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

        public void run()
        {
            synchronized (MMWebView.this)
            {
                adView.handleMraidResize(resizeParams);
                handleMraidResize(resizeParams);
                loadUrl("javascript:MMJS.sdk.setState('resized');");
                mraidState = "resized";
            }
        }

        _cls6()
        {
            this$0 = MMWebView.this;
            adView = mmadview;
            resizeParams = dtoresizeparameters;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final MMWebView this$0;
        final String val$finalBaseUrl;
        final String val$finalContent;

        public void run()
        {
            if (HandShake.sharedHandShake(getContext()).hardwareAccelerationEnabled)
            {
                enableHardwareAcceleration();
            } else
            {
                disableAllAcceleration();
            }
            loadDataWithBaseURL(finalBaseUrl, finalContent, "text/html", "UTF-8", null);
        }

        _cls4()
        {
            this$0 = MMWebView.this;
            finalBaseUrl = s;
            finalContent = s1;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final MMWebView this$0;
        final MMAdImpl val$adImpl;
        final String val$baseUrl;
        final String val$finalContent;

        public void run()
        {
            MMAd mmad;
            if (HandShake.sharedHandShake(getContext()).hardwareAccelerationEnabled)
            {
                enableHardwareAcceleration();
            } else
            {
                disableAllAcceleration();
            }
            mmad = adImpl.getCallingAd();
            if (mmad != null && (mmad instanceof MMLayout))
            {
                ((MMLayout)mmad).removeVideo();
            }
            loadDataWithBaseURL(baseUrl, finalContent, "text/html", "UTF-8", null);
        }

        _cls3()
        {
            this$0 = MMWebView.this;
            adImpl = mmadimpl;
            baseUrl = s;
            finalContent = s1;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final MMWebView this$0;
        final MMAdView val$adView;

        void handleUnresize()
        {
            if (MMSDK.hasSetTranslationMethod() && !hasDefaultResizeParams())
            {
                android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
                layoutparams.width = oldWidth;
                layoutparams.height = oldHeight;
                oldWidth = -50;
                oldHeight = -50;
                requestLayout();
            }
        }

        public void run()
        {
            synchronized (MMWebView.this)
            {
                adView.handleUnresize();
                handleUnresize();
                loadUrl("javascript:MMJS.sdk.setState('default');");
                mraidState = "default";
                invalidate();
            }
        }

        _cls7()
        {
            this$0 = MMWebView.this;
            adView = mmadview;
            super();
        }
    }

}
