// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDBasic;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.container.mraidimpl.MRAIDResizeController;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.AVPlayer;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.re.container:
//            b, a, c, CustomView

public class IMWebView extends WebView
    implements Serializable
{

    private static Class D = null;
    public static final String DIMENSIONS = "expand_dimensions";
    public static final String EXPAND_URL = "expand_url";
    protected static final int IMWEBVIEW_INTERSTITIAL_ID = 117;
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static int d[] = {
        0x101011f, 0x1010120
    };
    private static final long serialVersionUID = 0x6282f5dae34d0336L;
    public static boolean userInitiatedClose = false;
    private ViewParent A;
    private int B;
    private boolean C;
    private WebViewClient E;
    private WebChromeClient F;
    private android.media.MediaPlayer.OnCompletionListener G;
    private boolean H;
    double a;
    public AtomicBoolean acqMutexcPos;
    public AtomicBoolean acqMutexdPos;
    AtomicBoolean b;
    InstantVideoCallbackCallback c;
    public JSONObject curPosition;
    public JSONObject defPosition;
    public AtomicBoolean doNotFireVisibilityChanged;
    private boolean e;
    private JSUtilityController f;
    private float g;
    private int h;
    private int i;
    public AtomicBoolean isMutexAquired;
    public boolean isTablet;
    private ViewState j;
    private VideoView k;
    private View l;
    private android.webkit.WebChromeClient.CustomViewCallback m;
    public MRAIDAudioVideoController mAudioVideoController;
    public MRAIDExpandController mExpandController;
    public MRAIDInterstitialController mInterstitialController;
    public boolean mIsInterstitialAd;
    public boolean mIsViewable;
    public IMWebViewListener mListener;
    public MRAIDBasic mMraidBasic;
    public IMWebView mOriginalWebviewForExpandUrl;
    public MRAIDResizeController mResizeController;
    public boolean mWebViewIsBrowserActivity;
    protected boolean mraidLoaded;
    public Object mutex;
    public Object mutexcPos;
    public Object mutexdPos;
    private ViewGroup n;
    private FrameLayout o;
    private ArrayList p;
    public int publisherOrientation;
    private boolean q;
    private boolean r;
    private boolean s;
    private Message t;
    private Message u;
    private Activity v;
    private WebViewClient w;
    public String webviewUserAgent;
    private l x;
    private ArrayList y;
    private AtomicBoolean z;

    public IMWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        j = ViewState.LOADING;
        m = null;
        p = new ArrayList();
        q = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        r = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        y = new ArrayList();
        z = new AtomicBoolean();
        C = false;
        E = new b(this);
        F = new a(this);
        mIsViewable = false;
        G = new c(this);
        a = -1D;
        b = new AtomicBoolean(false);
        H = true;
        c = null;
        v = (Activity)context;
        a();
        getContext().obtainStyledAttributes(attributeset, d).recycle();
    }

    public IMWebView(Context context, IMWebViewListener imwebviewlistener)
    {
        super(context);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        j = ViewState.LOADING;
        m = null;
        p = new ArrayList();
        q = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        r = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        y = new ArrayList();
        z = new AtomicBoolean();
        C = false;
        E = new b(this);
        F = new a(this);
        mIsViewable = false;
        G = new c(this);
        a = -1D;
        b = new AtomicBoolean(false);
        H = true;
        c = null;
        mListener = imwebviewlistener;
        v = (Activity)context;
        a();
    }

    public IMWebView(Context context, IMWebViewListener imwebviewlistener, boolean flag, boolean flag1)
    {
        super(context);
        doNotFireVisibilityChanged = new AtomicBoolean(false);
        j = ViewState.LOADING;
        m = null;
        p = new ArrayList();
        q = false;
        mIsInterstitialAd = false;
        isTablet = false;
        mOriginalWebviewForExpandUrl = null;
        mWebViewIsBrowserActivity = false;
        r = false;
        mutex = new Object();
        mutexcPos = new Object();
        mutexdPos = new Object();
        isMutexAquired = new AtomicBoolean(false);
        acqMutexcPos = new AtomicBoolean(true);
        acqMutexdPos = new AtomicBoolean(true);
        y = new ArrayList();
        z = new AtomicBoolean();
        C = false;
        E = new b(this);
        F = new a(this);
        mIsViewable = false;
        G = new c(this);
        a = -1D;
        b = new AtomicBoolean(false);
        H = true;
        c = null;
        v = (Activity)context;
        mIsInterstitialAd = flag;
        mWebViewIsBrowserActivity = flag1;
        if (mIsInterstitialAd)
        {
            setId(117);
        }
        mListener = imwebviewlistener;
        a();
    }

    private int a(Activity activity)
    {
        Iterator iterator = activity.getPackageManager().queryIntentActivities(new Intent(activity, activity.getClass()), 0x10000).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
        if (!resolveinfo.activityInfo.name.contentEquals(activity.getClass().getName())) goto _L4; else goto _L3
_L3:
        return resolveinfo.activityInfo.configChanges;
_L2:
        resolveinfo = null;
        if (true) goto _L3; else goto _L5
_L5:
    }

    static Message a(IMWebView imwebview, Message message)
    {
        imwebview.t = message;
        return message;
    }

    static View a(IMWebView imwebview, View view)
    {
        imwebview.l = view;
        return view;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(IMWebView imwebview, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        imwebview.m = customviewcallback;
        return customviewcallback;
    }

    static WebViewClient a(IMWebView imwebview)
    {
        return imwebview.w;
    }

    static FrameLayout a(IMWebView imwebview, FrameLayout framelayout)
    {
        imwebview.o = framelayout;
        return framelayout;
    }

    static VideoView a(IMWebView imwebview, VideoView videoview)
    {
        imwebview.k = videoview;
        return videoview;
    }

    private void a()
    {
        userInitiatedClose = false;
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        webviewUserAgent = getSettings().getUserAgentString();
        InternalSDKUtil.getUserAgent(v);
        setBackgroundColor(Initializer.getConfigParams().getWebviewBgColor());
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            getSettings().setMediaPlaybackRequiresUserGesture(true);
        }
        g = v.getResources().getDisplayMetrics().density;
        e = false;
        getSettings().setJavaScriptEnabled(true);
        getSettings().setGeolocationEnabled(true);
        f = new JSUtilityController(this, getContext());
        addJavascriptInterface(f, "utilityController");
        setWebViewClient(E);
        setWebChromeClient(F);
        mExpandController = new MRAIDExpandController(this, v);
        mResizeController = new MRAIDResizeController(this, v);
        mMraidBasic = new MRAIDBasic(this, v);
        mInterstitialController = new MRAIDInterstitialController(this, v);
        mAudioVideoController = new MRAIDAudioVideoController(this);
        x = new l(mMraidBasic, mExpandController, mInterstitialController, mAudioVideoController, mResizeController);
        mExpandController.mSensorDisplay = ((WindowManager)v.getSystemService("window")).getDefaultDisplay();
        mAudioVideoController.videoValidateWidth = v.getResources().getDisplayMetrics().widthPixels;
        try
        {
            addJavascriptInterface(D.getDeclaredConstructor(new Class[] {
                com/inmobi/re/container/IMWebView
            }).newInstance(new Object[] {
                this
            }), "imaiController");
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Error adding js interface imai controller");
        }
        f.setWebViewClosed(false);
    }

    private void a(int i1, int j1)
    {
        injectJavaScript((new StringBuilder("window.mraid.broadcastEvent('sizeChange',")).append(i1).append(",").append(j1).append(");").toString());
    }

    private void a(View view, android.view.View.OnKeyListener onkeylistener)
    {
        view.setOnKeyListener(onkeylistener);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = 0;
            for (int j1 = viewgroup.getChildCount(); i1 < j1; i1++)
            {
                a(viewgroup.getChildAt(i1), onkeylistener);
            }

        }
    }

    private void a(View view, android.view.View.OnTouchListener ontouchlistener)
    {
        view.setOnTouchListener(ontouchlistener);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = 0;
            for (int j1 = viewgroup.getChildCount(); i1 < j1; i1++)
            {
                a(viewgroup.getChildAt(i1), ontouchlistener);
            }

        }
    }

    private void a(SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(v);
        builder.setPositiveButton("Continue", new d(sslerrorhandler));
        builder.setNegativeButton("Go Back", new k(sslerrorhandler));
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            builder.setNeutralButton("Open Browser", new e(sslerror));
        }
        builder.setTitle("Security Warning");
        builder.setMessage("There are problems with the security certificate for this site.");
        AlertDialog alertdialog = builder.create();
        try
        {
            alertdialog.show();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Dialog could not be shown due to an exception.", exception);
        }
    }

    static void a(IMWebView imwebview, View view, android.view.View.OnKeyListener onkeylistener)
    {
        imwebview.a(view, onkeylistener);
    }

    static void a(IMWebView imwebview, View view, android.view.View.OnTouchListener ontouchlistener)
    {
        imwebview.a(view, ontouchlistener);
    }

    static void a(IMWebView imwebview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        imwebview.a(sslerrorhandler, sslerror);
    }

    static void a(IMWebView imwebview, String s1)
    {
        imwebview.a(s1);
    }

    private void a(String s1)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        intent.addFlags(0x10000000);
        v.startActivity(intent);
        fireOnLeaveApplication();
    }

    private void a(boolean flag)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Viewable:")).append(flag).toString());
        injectJavaScript((new StringBuilder("window.mraid.broadcastEvent('viewableChange',")).append(isViewable()).append(");").toString());
    }

    static boolean a(IMWebView imwebview, boolean flag)
    {
        imwebview.C = flag;
        return flag;
    }

    static ViewState b(IMWebView imwebview)
    {
        return imwebview.j;
    }

    private void b()
    {
        Log.debug("[InMobi]-[RE]-4.4.1", "IMWebView-> initStates");
        j = ViewState.LOADING;
        z.set(false);
    }

    static AtomicBoolean c(IMWebView imwebview)
    {
        return imwebview.z;
    }

    private void c()
    {
        if (j == ViewState.EXPANDED)
        {
            mExpandController.closeExpanded();
        }
        invalidate();
        f.stopAllListeners();
        resetLayout();
    }

    static ArrayList d(IMWebView imwebview)
    {
        return imwebview.y;
    }

    private void d()
    {
        if (l == null)
        {
            return;
        }
        if (m != null)
        {
            m.onCustomViewHidden();
        }
        m = null;
        if (l.getParent() != null)
        {
            ((ViewGroup)l.getParent()).removeView(l);
        }
        l = null;
    }

    static Message e(IMWebView imwebview)
    {
        return imwebview.t;
    }

    private boolean e()
    {
        return b.get();
    }

    static Message f(IMWebView imwebview)
    {
        return imwebview.u;
    }

    static View g(IMWebView imwebview)
    {
        return imwebview.l;
    }

    static Activity h(IMWebView imwebview)
    {
        return imwebview.v;
    }

    static FrameLayout i(IMWebView imwebview)
    {
        return imwebview.o;
    }

    static VideoView j(IMWebView imwebview)
    {
        return imwebview.k;
    }

    static android.media.MediaPlayer.OnCompletionListener k(IMWebView imwebview)
    {
        return imwebview.G;
    }

    static void l(IMWebView imwebview)
    {
        imwebview.d();
    }

    static JSUtilityController m(IMWebView imwebview)
    {
        return imwebview.f;
    }

    static ViewGroup n(IMWebView imwebview)
    {
        return imwebview.n;
    }

    static void o(IMWebView imwebview)
    {
        imwebview.WebView.destroy();
    }

    static ArrayList p(IMWebView imwebview)
    {
        return imwebview.p;
    }

    public static void setIMAIController(Class class1)
    {
        D = class1;
    }

    public void addJavascriptObject(Object obj, String s1)
    {
        addJavascriptInterface(obj, s1);
    }

    public void cancelLoad()
    {
        z.set(true);
    }

    public void cancelSaveContent(String s1)
    {
        if (p == null) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L7:
        if (i1 >= p.size()) goto _L2; else goto _L3
_L3:
        i j1 = (i)p.get(i1);
        if (!j1.a().equals(s1) || j1.getStatus() != android.os.AsyncTask.Status.RUNNING) goto _L5; else goto _L4
_L4:
        j1.cancel(true);
_L2:
        return;
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void clearView()
    {
        c();
        super.clearView();
    }

    public void close()
    {
        try
        {
            removeSaveContentDir();
            f.setWebViewClosed(true);
            if (!x.hasMessages(1001))
            {
                x.sendEmptyMessage(1001);
            }
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "Exception closing webview. Webview not initialized properly", exception);
        }
    }

    public void closeExpanded()
    {
        x.sendEmptyMessage(1005);
    }

    protected void closeOpened(View view)
    {
        ((ViewGroup)((Activity)getContext()).getWindow().getDecorView()).removeView(view);
        requestLayout();
    }

    public void closeResized()
    {
        x.sendEmptyMessage(1031);
    }

    public void closeVideo(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "closeVideo");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "closeVideo");
            return;
        } else
        {
            mAudioVideoController.videoPlayerList.remove(s1);
            Message message = x.obtainMessage(1012);
            message.obj = avplayer;
            x.sendMessage(message);
            return;
        }
    }

    public void deinit()
    {
        if (getStateVariable() == ViewState.EXPANDED || getStateVariable() == ViewState.EXPANDING)
        {
            close();
        }
    }

    public void destroy()
    {
        Log.debug("[InMobi]-[RE]-4.4.1", "IMWebView: Destroy called.");
        close();
        postInHandler(new g());
    }

    public void disableHardwareAcceleration()
    {
        H = false;
        Log.internal("[InMobi]-[RE]-4.4.1", "disableHardwareAcceleration called.");
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            WrapperFunctions.disableHardwareAccl(this);
            mExpandController.disableEnableHardwareAccelerationForExpandWithURLView();
        }
    }

    public void doHidePlayers()
    {
        x.sendEmptyMessage(1023);
    }

    public void expand(String s1, com.inmobi.re.controller.JSController.ExpandProperties expandproperties)
    {
        setState(ViewState.EXPANDING);
        mExpandController.mIsExpandUrlValid = false;
        isMutexAquired.set(true);
        Message message = x.obtainMessage(1004);
        Bundle bundle = new Bundle();
        bundle.putString("expand_url", s1);
        message.setData(bundle);
        mExpandController.expandProperties = expandproperties;
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Dimensions: {")).append(mExpandController.expandProperties.x).append(" ,").append(mExpandController.expandProperties.y).append(" ,").append(mExpandController.expandProperties.width).append(" ,").append(mExpandController.expandProperties.height).append("}").toString());
        mExpandController.tempExpPropsLock = mExpandController.expandProperties.lockOrientation;
        x.sendMessage(message);
    }

    public void fireOnLeaveApplication()
    {
        if (mListener != null)
        {
            mListener.onLeaveApplication();
        }
    }

    public void fireOnShowAdScreen()
    {
        if (mListener != null && getStateVariable() == ViewState.DEFAULT && !mIsInterstitialAd)
        {
            IMBrowserActivity.requestOnAdDismiss(x.obtainMessage(1028));
            mListener.onShowAdScreen();
        }
    }

    public Activity getActivity()
    {
        return v;
    }

    public int getAudioVolume(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "getAudioVolume");
            return -1;
        } else
        {
            return avplayer.getVolume();
        }
    }

    public String getCurrentRotation(int i1)
    {
        switch (i1)
        {
        default:
            return "-1";

        case 0: // '\0'
            return "0";

        case 1: // '\001'
            return "90";

        case 2: // '\002'
            return "180";

        case 3: // '\003'
            return "270";
        }
    }

    public boolean getCustomClose()
    {
        return r;
    }

    public float getDensity()
    {
        return g;
    }

    public int getDismissMessage()
    {
        return 1028;
    }

    public Activity getExpandedActivity()
    {
        return v;
    }

    public int getIntegerCurrentRotation()
    {
        int i1 = InternalSDKUtil.getDisplayRotation(((WindowManager)v.getSystemService("window")).getDefaultDisplay());
        if (InternalSDKUtil.isDefOrientationLandscape(i1, v.getResources().getDisplayMetrics().widthPixels, v.getResources().getDisplayMetrics().heightPixels))
        {
            if (++i1 > 3)
            {
                i1 = 0;
            }
            if (InternalSDKUtil.isTablet(v.getApplicationContext()))
            {
                isTablet = true;
            }
        }
        return i1;
    }

    public double getLastGoodKnownMicValue()
    {
        return a;
    }

    public ArrayList getMRAIDUrls()
    {
        return y;
    }

    public int getOriginalIndex()
    {
        return B;
    }

    public ViewParent getOriginalParent()
    {
        if (A == null)
        {
            saveOriginalViewParent();
        }
        return A;
    }

    public String getPlacementType()
    {
        if (mIsInterstitialAd)
        {
            return "interstitial";
        } else
        {
            return "inline";
        }
    }

    public String getSize()
    {
        return (new StringBuilder("{ width: ")).append((int)((float)getWidth() / g)).append(", height: ").append((int)((float)getHeight() / g)).append("}").toString();
    }

    public String getState()
    {
        return j.toString().toLowerCase(Locale.ENGLISH);
    }

    public ViewState getStateVariable()
    {
        return j;
    }

    public int getVideoVolume(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "getVideoVolume");
            return -1;
        } else
        {
            return avplayer.getVolume();
        }
    }

    public ViewState getViewState()
    {
        return j;
    }

    public Handler getWebviewHandler()
    {
        return x;
    }

    public void hide()
    {
        x.sendEmptyMessage(1002);
    }

    public void hideVideo(String s1)
    {
        Message message = x.obtainMessage(1013);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        x.sendMessage(message);
    }

    public void incentCompleted(HashMap hashmap)
    {
        Message message = x.obtainMessage(1034);
        Bundle bundle = new Bundle();
        bundle.putSerializable("incent_ad_map", hashmap);
        message.setData(bundle);
        message.sendToTarget();
    }

    public void injectJavaScript(String s1)
    {
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (s1.length() < 400)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Injecting JavaScript: ")).append(s1).toString());
        }
        if (!e())
        {
            super.loadUrl((new StringBuilder("javascript:try{")).append(s1).append("}catch(e){}").toString());
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.4.1", "Error injecting javascript ", exception);
        return;
    }

    public boolean isAudioMuted(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "isAudioMuted");
            return false;
        } else
        {
            return avplayer.isMediaMuted();
        }
    }

    public boolean isBusy()
    {
        return q;
    }

    public boolean isConfigChangesListed(Activity activity)
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        int j1 = a(activity);
        boolean flag;
        boolean flag1;
        if ((j1 & 0x10) == 0 || (j1 & 0x20) == 0 || (j1 & 0x80) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (i1 >= 13 && ((j1 & 0x400) == 0 || (j1 & 0x800) == 0))
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        return flag && flag1;
    }

    public boolean isEnabledHardwareAcceleration()
    {
        return H;
    }

    public boolean isExpanded()
    {
        return j == ViewState.EXPANDED;
    }

    public boolean isLandscapeSyncOrientation(int i1)
    {
        return i1 == 1 || i1 == 3;
    }

    public boolean isModal()
    {
        return mIsInterstitialAd || j == ViewState.EXPANDED;
    }

    public boolean isPageFinished()
    {
        return e;
    }

    public boolean isPortraitSyncOrientation(int i1)
    {
        return i1 == 0 || i1 == 2;
    }

    public boolean isVideoMuted(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "isVideoMuted");
            return false;
        } else
        {
            return avplayer.isMediaMuted();
        }
    }

    public boolean isViewable()
    {
        return mIsViewable;
    }

    public void loadData(String s1, String s2, String s3)
    {
        super.loadData(s1, s2, s3);
    }

    public void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        if (j == ViewState.EXPANDED)
        {
            return;
        } else
        {
            b();
            super.loadDataWithBaseURL(s1, s2, s3, s4, s5);
            return;
        }
    }

    public void loadUrl(String s1)
    {
        if (j == ViewState.EXPANDED)
        {
            return;
        } else
        {
            b();
            super.loadUrl(s1);
            return;
        }
    }

    public void lockExpandOrientation(Activity activity, boolean flag, String s1)
    {
        int i1;
        int j1;
        try
        {
            if (!isConfigChangesListed(activity))
            {
                return;
            }
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Exception handling the orientation ", exception);
            return;
        }
        i1 = activity.getRequestedOrientation();
        if (i1 == 0 || i1 == 1)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        if (android.os.Build.VERSION.SDK_INT >= 9 && (i1 == 8 || i1 == 9 || i1 == 6 || i1 == 7))
        {
            break MISSING_BLOCK_LABEL_238;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        j1 = getIntegerCurrentRotation();
        mExpandController.initialExpandOrientation = activity.getRequestedOrientation();
        if (s1.equalsIgnoreCase("portrait"))
        {
            mExpandController.useLockOrient = true;
            activity.setRequestedOrientation(WrapperFunctions.getParamPortraitOrientation(j1));
            return;
        }
        if (s1.equalsIgnoreCase("landscape"))
        {
            mExpandController.useLockOrient = true;
            activity.setRequestedOrientation(WrapperFunctions.getParamLandscapeOrientation(j1));
            return;
        }
        mExpandController.useLockOrient = true;
        if (activity.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "In allowFalse, none mode dev orientation:ORIENTATION_LANDSCAPE");
            activity.setRequestedOrientation(0);
            return;
        }
        Log.internal("[InMobi]-[RE]-4.4.1", "In allowFalse, none mode dev orientation:ORIENTATION_PORTRAIT");
        activity.setRequestedOrientation(1);
        return;
        if (activity.getResources().getConfiguration().orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.4.1", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
            return;
        }
        Log.internal("[InMobi]-[RE]-4.4.1", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
    }

    public void mediaPlayerReleased(AVPlayer avplayer)
    {
        mAudioVideoController.mediaPlayerReleased(avplayer);
    }

    public void muteAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "muteAudio");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "muteAudio");
            return;
        } else
        {
            Message message = x.obtainMessage(1019);
            Bundle bundle = new Bundle();
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void muteVideo(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "muteVideo");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "muteVideo");
            return;
        } else
        {
            Message message = x.obtainMessage(1015);
            message.obj = avplayer;
            x.sendMessage(message);
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        Log.debug("[InMobi]-[RE]-4.4.1", "IMWebView-> onAttachedToWindow");
        saveOriginalViewParent();
        if (!s)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            h = layoutparams.height;
            i = layoutparams.width;
            s = true;
        }
        f.registerBroadcastListener();
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow()
    {
        Log.debug("[InMobi]-[RE]-4.4.1", "IMWebView-> onDetatchedFromWindow");
        f.stopAllListeners();
        y.clear();
        f.unRegisterBroadcastListener();
        if (mIsInterstitialAd && !mWebViewIsBrowserActivity)
        {
            mInterstitialController.handleInterstitialClose();
        }
        super.onDetachedFromWindow();
    }

    protected void onIMWebviewVisibilityChanged(boolean flag)
    {
        if (mIsViewable != flag)
        {
            mIsViewable = flag;
            if (!doNotFireVisibilityChanged.get())
            {
                a(flag);
                return;
            }
        }
    }

    public void onOrientationEventChange()
    {
        x.sendEmptyMessage(1027);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != 0 && j1 != 0)
        {
            if (!C)
            {
                a((int)((float)i1 / getDensity()), (int)((float)j1 / getDensity()));
            }
            C = false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        requestFocus();
        return super.onTouchEvent(motionevent);
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        boolean flag;
        if (i1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        onIMWebviewVisibilityChanged(flag);
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (f.supports("vibrate"))
        {
            ((Vibrator)v.getSystemService("vibrator")).cancel();
        }
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.4.1", "Failed to cancel existing vibration", exception);
        return;
    }

    public void openExternal(String s1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s1));
        intent.addFlags(0x10000000);
        try
        {
            getContext().startActivity(intent);
        }
        catch (Exception exception)
        {
            raiseError("Request must specify a valid URL", "openExternal");
            return;
        }
        if (mListener != null)
        {
            mListener.onLeaveApplication();
        }
    }

    public void openURL(String s1)
    {
        if (!isViewable())
        {
            raiseError("Cannot open URL.Ad is not viewable yet", "openURL");
            return;
        } else
        {
            Message message = x.obtainMessage(1024);
            Bundle bundle = new Bundle();
            bundle.putString("expand_url", s1);
            message.setData(bundle);
            x.sendMessage(message);
            return;
        }
    }

    public void pageFinishedCallbackForAdCreativeTesting(Message message)
    {
        u = message;
    }

    public void pauseAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "pauseAudio");
        } else
        {
            if (avplayer.getState() != com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING)
            {
                if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT && !avplayer.isPrepared())
                {
                    avplayer.setAutoPlay(false);
                    return;
                } else
                {
                    raiseError("Invalid player state", "pauseAudio");
                    return;
                }
            }
            if (avplayer.isPlaying())
            {
                Message message = x.obtainMessage(1010);
                Bundle bundle = new Bundle();
                bundle.putString("aplayerref", s1);
                message.setData(bundle);
                message.sendToTarget();
                return;
            }
        }
    }

    public void pauseVideo(String s1)
    {
        Message message = x.obtainMessage(1011);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        x.sendMessage(message);
    }

    public void playAudio(String s1, boolean flag, boolean flag1, boolean flag2, String s2, String s3, String s4)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag3 = isMutexAquired.get();
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mutex.wait();
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (!mIsInterstitialAd && j != ViewState.EXPANDED)
        {
            raiseError("Cannot play audio.Ad is not in an expanded state", "playAudio");
            return;
        }
        break MISSING_BLOCK_LABEL_86;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.4.1", "mutex failed ", interruptedexception);
          goto _L1
        Exception exception;
        exception;
        throw exception;
        if (!isViewable())
        {
            raiseError("Cannot play audio.Ad is not viewable yet", "playAudio");
            return;
        } else
        {
            com.inmobi.re.controller.JSController.PlayerProperties playerproperties = new com.inmobi.re.controller.JSController.PlayerProperties();
            playerproperties.setProperties(false, flag, flag1, flag2, s2, s3, s4);
            Bundle bundle = new Bundle();
            bundle.putString("expand_url", s1);
            bundle.putParcelable("player_properties", playerproperties);
            Message message = x.obtainMessage(1007);
            message.setData(bundle);
            x.sendMessage(message);
            return;
        }
    }

    public void playVideo(String s1, boolean flag, boolean flag1, boolean flag2, boolean flag3, com.inmobi.re.controller.JSController.Dimensions dimensions, String s2, 
            String s3, String s4)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        boolean flag4 = isMutexAquired.get();
        if (!flag4)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mutex.wait();
_L1:
        obj;
        JVM INSTR monitorexit ;
        if (!mIsInterstitialAd && j != ViewState.EXPANDED)
        {
            raiseError("Cannot play video.Ad is not in an expanded state", "playVideo");
            return;
        }
        break MISSING_BLOCK_LABEL_86;
        InterruptedException interruptedexception;
        interruptedexception;
        Log.debug("[InMobi]-[RE]-4.4.1", "mutex failed ", interruptedexception);
          goto _L1
        Exception exception;
        exception;
        throw exception;
        if (!isViewable())
        {
            raiseError("Cannot play video.Ad is not viewable yet", "playVideo");
            return;
        }
        if (!mAudioVideoController.videoPlayerList.isEmpty() && mAudioVideoController.videoPlayerList.size() >= 5 && !mAudioVideoController.videoPlayerList.containsKey(s4))
        {
            raiseError("Player Error. Exceeding permissible limit for saved play instances", "playVideo");
            return;
        } else
        {
            Message message = x.obtainMessage(1006);
            com.inmobi.re.controller.JSController.PlayerProperties playerproperties = new com.inmobi.re.controller.JSController.PlayerProperties();
            playerproperties.setProperties(flag, flag1, flag2, flag3, s2, s3, s4);
            Bundle bundle = new Bundle();
            bundle.putString("expand_url", s1);
            bundle.putParcelable("player_properties", playerproperties);
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Before validation dimension: (")).append(dimensions.x).append(", ").append(dimensions.y).append(", ").append(dimensions.width).append(", ").append(dimensions.height).append(")").toString());
            mAudioVideoController.validateVideoDimensions(dimensions);
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("After validation dimension: (")).append(dimensions.x).append(", ").append(dimensions.y).append(", ").append(dimensions.width).append(", ").append(dimensions.height).append(")").toString());
            bundle.putParcelable("expand_dimensions", dimensions);
            message.setData(bundle);
            x.sendMessage(message);
            return;
        }
    }

    public void postInHandler(Runnable runnable)
    {
        x.post(runnable);
    }

    public void postInjectJavaScript(String s1)
    {
        if (s1 != null)
        {
            if (s1.length() < 400)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("Injecting JavaScript: ")).append(s1).toString());
            }
            Message message = x.obtainMessage(1025);
            Bundle bundle = new Bundle();
            bundle.putString("injectMessage", s1);
            message.setData(bundle);
            message.sendToTarget();
        }
    }

    public void raiseCameraPictureCapturedEvent(String s1, int i1, int j1)
    {
        String s2 = (new StringBuilder("window.mraidview.fireCameraPictureCatpturedEvent('")).append(s1).append("','").append(i1).append("','").append(j1).append("')").toString();
        if (v != null)
        {
            v.runOnUiThread(new c(s2));
        }
    }

    public void raiseError(String s1, String s2)
    {
        Message message = x.obtainMessage(1008);
        Bundle bundle = new Bundle();
        bundle.putString("message", s1);
        bundle.putString("action", s2);
        message.setData(bundle);
        x.sendMessage(message);
    }

    public void raiseGalleryImageSelectedEvent(String s1, int i1, int j1)
    {
        String s2 = (new StringBuilder("window.mraidview.fireGalleryImageSelectedEvent('")).append(s1).append("','").append(i1).append("','").append(j1).append("')").toString();
        if (v != null)
        {
            v.runOnUiThread(new j(s2));
        }
    }

    public void raiseMicEvent(double d1)
    {
        a = d1;
        String s1 = (new StringBuilder("window.mraid.broadcastEvent('micIntensityChange',")).append(d1).append(")").toString();
        if (v != null)
        {
            v.runOnUiThread(new b(s1));
        }
    }

    public void raiseVibrateCompleteEvent()
    {
        if (v != null)
        {
            v.runOnUiThread(new a());
        }
    }

    public void removeSaveContentDir()
    {
        int i1 = 0;
        if (p != null)
        {
            android.util.Log.i("Nilanjana", "list_downloadTask not null");
            for (int j1 = 0; j1 < p.size(); j1++)
            {
                i k1 = (i)p.get(j1);
                if (k1.getStatus() == android.os.AsyncTask.Status.RUNNING)
                {
                    k1.cancel(true);
                }
            }

            p.clear();
            p = null;
        }
        Context context = InternalSDKUtil.getContext();
        File file = new File((new StringBuilder()).append(context.getExternalFilesDir(null)).append("/im_cached_content/").toString());
        if (file.exists() && file.isDirectory())
        {
            for (String as[] = file.list(); i1 < as.length; i1++)
            {
                (new File(file, as[i1])).delete();
            }

            file.delete();
        }
    }

    public void requestOnInterstitialClosed(Message message)
    {
        mInterstitialController.mMsgOnInterstitialClosed = message;
    }

    public void requestOnInterstitialShown(Message message)
    {
        mInterstitialController.mMsgOnInterstitialShown = message;
    }

    public void requestOnPageFinishedCallback(Message message)
    {
        t = message;
    }

    public void resetLayout()
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        if (s)
        {
            layoutparams.height = h;
            layoutparams.width = i;
        }
        setVisibility(0);
        requestLayout();
    }

    public void resetMraid()
    {
        mExpandController.reset();
        mResizeController.reset();
        f.reset();
    }

    public void resize(com.inmobi.re.controller.JSController.ResizeProperties resizeproperties)
    {
        setState(ViewState.RESIZING);
        isMutexAquired.set(true);
        Message message = x.obtainMessage(1030);
        mResizeController.resizeProperties = resizeproperties;
        x.sendMessage(message);
    }

    public void saveFile(File file, String s1, String s2)
    {
        (new i(file, s1, s2)).execute(new Void[0]);
    }

    public void saveOriginalViewParent()
    {
        if (A == null)
        {
            A = getParent();
            if (A != null)
            {
                int i1 = ((ViewGroup)A).getChildCount();
                int j1;
                for (j1 = 0; j1 < i1 && ((ViewGroup)A).getChildAt(j1) != this; j1++) { }
                B = j1;
                return;
            }
        }
    }

    public void seekAudio(String s1, int i1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "seekAudio");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "seekAudio");
            return;
        } else
        {
            Message message = x.obtainMessage(1022);
            Bundle bundle = new Bundle();
            bundle.putInt("seekaudio", i1);
            message.setData(bundle);
            message.obj = avplayer;
            message.sendToTarget();
            return;
        }
    }

    public void seekVideo(String s1, int i1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "seekVideo");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "seekVideo");
            return;
        } else
        {
            Message message = x.obtainMessage(1018);
            Bundle bundle = new Bundle();
            bundle.putInt("seek", i1);
            message.setData(bundle);
            message.obj = avplayer;
            x.sendMessage(message);
            return;
        }
    }

    public void sendToCPHandler()
    {
        x.sendEmptyMessage(1029);
    }

    public void sendToDPHandler()
    {
        x.sendEmptyMessage(1032);
    }

    public void sendasyncPing(String s1)
    {
        f.asyncPing(s1);
    }

    public void setActivity(Activity activity)
    {
        v = activity;
    }

    public void setAudioVolume(String s1, int i1)
    {
        if (mAudioVideoController.getCurrentAudioPlayer(s1) == null)
        {
            raiseError("Invalid property ID", "setAudioVolume");
            return;
        } else
        {
            Message message = x.obtainMessage(1021);
            Bundle bundle = new Bundle();
            bundle.putInt("vol", i1);
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void setBrowserActivity(Activity activity)
    {
        if (activity != null)
        {
            v = (IMBrowserActivity)activity;
        }
    }

    public void setBusy(boolean flag)
    {
        q = flag;
    }

    public void setCallBack(InstantVideoCallbackCallback instantvideocallbackcallback)
    {
        c = instantvideocallbackcallback;
    }

    public void setCloseButton()
    {
        CustomView customview = (CustomView)((ViewGroup)getRootView()).findViewById(225);
        if (customview == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (getCustomClose())
        {
            customview.setSwitchInt(CustomView.SwitchIconType.CLOSE_TRANSPARENT);
            customview.invalidate();
            return;
        }
        try
        {
            customview.setSwitchInt(CustomView.SwitchIconType.CLOSE_BUTTON);
            customview.invalidate();
            return;
        }
        catch (Exception exception) { }
    }

    public void setCustomClose(boolean flag)
    {
        r = flag;
        Message message = x.obtainMessage(1009);
        x.sendMessage(message);
    }

    public void setExpandPropertiesForInterstitial(boolean flag, boolean flag1, String s1)
    {
        setCustomClose(flag);
        mInterstitialController.orientationValueForInterstitial = s1;
        mInterstitialController.lockOrientationValueForInterstitial = flag1;
        if (mWebViewIsBrowserActivity)
        {
            mExpandController.handleOrientationFor2Piece();
        }
        if (isViewable() && mIsInterstitialAd)
        {
            x.sendEmptyMessage(1026);
        }
    }

    public void setExternalWebViewClient(WebViewClient webviewclient)
    {
        w = webviewclient;
    }

    public void setOrientationPropertiesForInterstitial(boolean flag, String s1)
    {
        mInterstitialController.orientationValueForInterstitial = s1;
        mInterstitialController.lockOrientationValueForInterstitial = flag;
        if (mWebViewIsBrowserActivity)
        {
            mExpandController.handleOrientationFor2Piece();
        }
        if (isViewable() && mIsInterstitialAd)
        {
            x.sendEmptyMessage(1026);
        }
    }

    public void setOriginalParent(ViewParent viewparent)
    {
        A = viewparent;
    }

    public void setState(ViewState viewstate)
    {
        Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("State changing from ")).append(j).append(" to ").append(viewstate).toString());
        j = viewstate;
        if (viewstate != ViewState.EXPANDING && viewstate != ViewState.RESIZING)
        {
            injectJavaScript((new StringBuilder("window.mraid.broadcastEvent('stateChange','")).append(getState()).append("');").toString());
        }
    }

    public void setVideoVolume(String s1, int i1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "setVideoVolume");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "setVideoVolume");
            return;
        } else
        {
            Message message = x.obtainMessage(1017);
            Bundle bundle = new Bundle();
            bundle.putInt("volume", i1);
            message.setData(bundle);
            message.obj = avplayer;
            x.sendMessage(message);
            return;
        }
    }

    public void show()
    {
        x.sendEmptyMessage(1003);
    }

    public void showVideo(String s1)
    {
        Message message = x.obtainMessage(1014);
        Bundle bundle = new Bundle();
        bundle.putString("pid", s1);
        message.setData(bundle);
        x.sendMessage(message);
    }

    public void unMuteAudio(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getCurrentAudioPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "unmuteAudio");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            raiseError("Invalid player state", "unmuteAudio");
            return;
        } else
        {
            Message message = x.obtainMessage(1020);
            Bundle bundle = new Bundle();
            bundle.putString("aplayerref", s1);
            message.setData(bundle);
            message.sendToTarget();
            return;
        }
    }

    public void unMuteVideo(String s1)
    {
        AVPlayer avplayer = mAudioVideoController.getVideoPlayer(s1);
        if (avplayer == null)
        {
            raiseError("Invalid property ID", "unMuteVideo");
            return;
        }
        if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
        {
            raiseError("Invalid player state", "unMuteVideo");
            return;
        } else
        {
            Message message = x.obtainMessage(1016);
            message.obj = avplayer;
            x.sendMessage(message);
            return;
        }
    }

    public void userInteraction(HashMap hashmap)
    {
        Message message = x.obtainMessage(1033);
        Bundle bundle = new Bundle();
        bundle.putSerializable("map", hashmap);
        message.setData(bundle);
        message.sendToTarget();
    }


    private class ViewState extends Enum
    {

        public static final ViewState DEFAULT;
        public static final ViewState EXPANDED;
        public static final ViewState EXPANDING;
        public static final ViewState HIDDEN;
        public static final ViewState LOADING;
        public static final ViewState RESIZED;
        public static final ViewState RESIZING;
        private static final ViewState a[];

        public static ViewState valueOf(String s1)
        {
            return (ViewState)Enum.valueOf(com/inmobi/re/container/IMWebView$ViewState, s1);
        }

        public static ViewState[] values()
        {
            return (ViewState[])a.clone();
        }

        static 
        {
            LOADING = new ViewState("LOADING", 0);
            DEFAULT = new ViewState("DEFAULT", 1);
            RESIZED = new ViewState("RESIZED", 2);
            EXPANDED = new ViewState("EXPANDED", 3);
            EXPANDING = new ViewState("EXPANDING", 4);
            HIDDEN = new ViewState("HIDDEN", 5);
            RESIZING = new ViewState("RESIZING", 6);
            ViewState aviewstate[] = new ViewState[7];
            aviewstate[0] = LOADING;
            aviewstate[1] = DEFAULT;
            aviewstate[2] = RESIZED;
            aviewstate[3] = EXPANDED;
            aviewstate[4] = EXPANDING;
            aviewstate[5] = HIDDEN;
            aviewstate[6] = RESIZING;
            a = aviewstate;
        }

        private ViewState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class l extends Handler
    {

        private final WeakReference a;
        private final WeakReference b;
        private final WeakReference c;
        private final WeakReference d;
        private final WeakReference e;
        private final WeakReference f;

        public void handleMessage(Message message)
        {
            IMWebView imwebview;
            MRAIDBasic mraidbasic;
            MRAIDExpandController mraidexpandcontroller;
            MRAIDResizeController mraidresizecontroller;
            MRAIDInterstitialController mraidinterstitialcontroller;
            MRAIDAudioVideoController mraidaudiovideocontroller;
            Bundle bundle;
            try
            {
                imwebview = (IMWebView)a.get();
                mraidbasic = (MRAIDBasic)d.get();
                mraidexpandcontroller = (MRAIDExpandController)b.get();
                mraidresizecontroller = (MRAIDResizeController)c.get();
                mraidinterstitialcontroller = (MRAIDInterstitialController)e.get();
                mraidaudiovideocontroller = (MRAIDAudioVideoController)f.get();
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "Webview Handle Message Exception ", exception);
                return;
            }
            if (imwebview == null) goto _L2; else goto _L1
_L1:
            Log.debug("[InMobi]-[RE]-4.4.1", (new StringBuilder("IMWebView->handleMessage: msg: ")).append(message).toString());
            bundle = message.getData();
            message.what;
            JVM INSTR tableswitch 1001 1034: default 256
        //                       1001 310
        //                       1002 400
        //                       1003 415
        //                       1004 449
        //                       1005 291
        //                       1006 505
        //                       1007 477
        //                       1008 1058
        //                       1009 1120
        //                       1010 533
        //                       1011 696
        //                       1012 774
        //                       1013 788
        //                       1014 863
        //                       1015 986
        //                       1016 999
        //                       1017 1037
        //                       1018 1012
        //                       1019 566
        //                       1020 599
        //                       1021 632
        //                       1022 672
        //                       1023 1127
        //                       1024 1135
        //                       1025 1151
        //                       1026 1191
        //                       1027 1199
        //                       1028 1214
        //                       1029 1233
        //                       1030 429
        //                       1031 262
        //                       1032 1241
        //                       1033 1249
        //                       1034 1285;
               goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36
_L2:
            super.handleMessage(message);
            return;
_L33:
            if (imwebview.mListener == null) goto _L2; else goto _L37
_L37:
            imwebview.mListener.onResizeClose();
              goto _L2
_L7:
            if (imwebview.mListener == null) goto _L2; else goto _L38
_L38:
            imwebview.mListener.onExpandClose();
              goto _L2
_L3:
            h.a[IMWebView.b(imwebview).ordinal()];
            JVM INSTR tableswitch 1 5: default 356
        //                       1 371
        //                       2 371
        //                       3 379
        //                       4 379
        //                       5 256;
               goto _L39 _L40 _L40 _L41 _L41 _L2
_L39:
            if (!imwebview.mIsInterstitialAd) goto _L43; else goto _L42
_L42:
            mraidinterstitialcontroller.resetContentsForInterstitials();
              goto _L2
_L40:
            mraidresizecontroller.closeResized();
              goto _L2
_L41:
            mraidexpandcontroller.closeExpanded();
            mraidexpandcontroller.mIsExpandUrlValid = false;
              goto _L2
_L43:
            imwebview.hide();
              goto _L2
_L4:
            imwebview.setVisibility(4);
            imwebview.setState(ViewState.HIDDEN);
              goto _L2
_L5:
            imwebview.injectJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
            imwebview.setVisibility(0);
              goto _L2
_L32:
            if (IMWebView.b(imwebview) != ViewState.RESIZING) goto _L2; else goto _L44
_L44:
            mraidresizecontroller.doResize(bundle);
              goto _L2
_L6:
            if (IMWebView.b(imwebview) == ViewState.EXPANDING)
            {
                mraidexpandcontroller.doExpand(bundle);
            }
            IMWebView.m(imwebview).setWebViewClosed(false);
              goto _L2
_L9:
            mraidaudiovideocontroller.playAudioImpl(bundle, IMWebView.h(imwebview));
              goto _L2
            Exception exception2;
            exception2;
            Log.debug("[InMobi]-[RE]-4.4.1", "Play audio failed ", exception2);
              goto _L2
_L8:
            mraidaudiovideocontroller.playVideoImpl(bundle, IMWebView.h(imwebview));
              goto _L2
            Exception exception1;
            exception1;
            Log.debug("[InMobi]-[RE]-4.4.1", "Play video failed ", exception1);
              goto _L2
_L12:
            AVPlayer avplayer6 = (AVPlayer)mraidaudiovideocontroller.audioPlayerList.get(bundle.getString("aplayerref"));
            if (avplayer6 == null) goto _L2; else goto _L45
_L45:
            avplayer6.pause();
              goto _L2
_L21:
            AVPlayer avplayer5 = (AVPlayer)mraidaudiovideocontroller.audioPlayerList.get(bundle.getString("aplayerref"));
            if (avplayer5 == null) goto _L2; else goto _L46
_L46:
            avplayer5.mute();
              goto _L2
_L22:
            AVPlayer avplayer4 = (AVPlayer)mraidaudiovideocontroller.audioPlayerList.get(bundle.getString("aplayerref"));
            if (avplayer4 == null) goto _L2; else goto _L47
_L47:
            avplayer4.unMute();
              goto _L2
_L23:
            AVPlayer avplayer3 = (AVPlayer)mraidaudiovideocontroller.audioPlayerList.get(bundle.getString("aplayerref"));
            if (avplayer3 == null) goto _L2; else goto _L48
_L48:
            avplayer3.setVolume(bundle.getInt("vol"));
              goto _L2
_L24:
            ((AVPlayer)message.obj).seekPlayer(1000 * bundle.getInt("seekaudio"));
              goto _L2
_L13:
            AVPlayer avplayer2 = mraidaudiovideocontroller.getVideoPlayer(bundle.getString("pid"));
            if (avplayer2 != null) goto _L50; else goto _L49
_L49:
            String s8 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"pauseVideo\")";
_L70:
            imwebview.injectJavaScript(s8);
              goto _L2
_L50:
            if (avplayer2.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING) goto _L52; else goto _L51
_L51:
            if (avplayer2.getState() != com.inmobi.re.controller.util.AVPlayer.playerState.INIT) goto _L54; else goto _L53
_L53:
            if (!avplayer2.isPrepared())
            {
                avplayer2.setAutoPlay(false);
            }
              goto _L2
_L52:
            avplayer2.pause();
            return;
_L14:
            ((AVPlayer)message.obj).releasePlayer(false);
              goto _L2
_L15:
            String s6;
            AVPlayer avplayer1;
            s6 = bundle.getString("pid");
            avplayer1 = mraidaudiovideocontroller.getVideoPlayer(s6);
            if (avplayer1 != null) goto _L56; else goto _L55
_L55:
            String s7 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"hideVideo\")";
_L59:
            imwebview.injectJavaScript(s7);
              goto _L2
_L56:
            if (avplayer1.getState() != com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED) goto _L58; else goto _L57
_L57:
            s7 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"hideVideo\")";
              goto _L59
_L58:
            mraidaudiovideocontroller.videoPlayerList.put(s6, avplayer1);
            avplayer1.hide();
            return;
_L16:
            String s4;
            AVPlayer avplayer;
            s4 = bundle.getString("pid");
            avplayer = mraidaudiovideocontroller.getVideoPlayer(s4);
            if (avplayer != null) goto _L61; else goto _L60
_L60:
            String s5 = "window.mraid.broadcastEvent('error',\"Invalid property ID\", \"showVideo\")";
_L64:
            imwebview.injectJavaScript(s5);
              goto _L2
_L61:
            if (avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED || avplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.HIDDEN) goto _L63; else goto _L62
_L62:
            s5 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"showVideo\")";
              goto _L64
_L63:
            if (mraidaudiovideocontroller.videoPlayer == null || mraidaudiovideocontroller.videoPlayer.getPropertyID().equalsIgnoreCase(s4)) goto _L66; else goto _L65
_L65:
            s5 = "window.mraid.broadcastEvent('error',\"Show failed. There is already a video playing\", \"showVideo\")";
              goto _L64
_L66:
            mraidaudiovideocontroller.videoPlayerList.remove(s4);
            mraidaudiovideocontroller.videoPlayer = avplayer;
            avplayer.show();
            return;
_L17:
            ((AVPlayer)message.obj).mute();
              goto _L2
_L18:
            ((AVPlayer)message.obj).unMute();
              goto _L2
_L20:
            ((AVPlayer)message.obj).seekPlayer(1000 * bundle.getInt("seek"));
              goto _L2
_L19:
            ((AVPlayer)message.obj).setVolume(bundle.getInt("volume"));
              goto _L2
_L10:
            String s2 = bundle.getString("message");
            String s3 = bundle.getString("action");
            imwebview.injectJavaScript((new StringBuilder("window.mraid.broadcastEvent('error',\"")).append(s2).append("\", \"").append(s3).append("\")").toString());
              goto _L2
_L11:
            imwebview.setCloseButton();
              goto _L2
_L25:
            mraidaudiovideocontroller.hidePlayers();
              goto _L2
_L26:
            mraidbasic.open(bundle.getString("expand_url"));
              goto _L2
_L27:
            String s1 = bundle.getString("injectMessage");
            if (s1 == null) goto _L2; else goto _L67
_L67:
            imwebview.loadUrl((new StringBuilder("javascript:")).append(s1).toString());
              goto _L2
_L28:
            mraidinterstitialcontroller.handleOrientationForInterstitial();
              goto _L2
_L29:
            if (imwebview.mIsInterstitialAd) goto _L2; else goto _L68
_L68:
            mraidresizecontroller.onOrientationChange();
              goto _L2
_L30:
            if (imwebview.mListener == null) goto _L2; else goto _L69
_L69:
            imwebview.mListener.onDismissAdScreen();
              goto _L2
_L31:
            mraidbasic.getCurrentPosition();
              goto _L2
_L34:
            mraidbasic.getDefaultPosition();
              goto _L2
_L35:
            HashMap hashmap1 = (HashMap)message.getData().getSerializable("map");
            if (imwebview.mListener != null)
            {
                imwebview.mListener.onUserInteraction(hashmap1);
            }
              goto _L2
_L36:
            HashMap hashmap = (HashMap)message.getData().getSerializable("incent_ad_map");
            if (imwebview.mListener != null)
            {
                imwebview.mListener.onIncentCompleted(hashmap);
            }
              goto _L2
_L54:
            s8 = "window.mraid.broadcastEvent('error',\"Invalid player state\", \"pauseVideo\")";
              goto _L70
        }

        public l(MRAIDBasic mraidbasic, MRAIDExpandController mraidexpandcontroller, MRAIDInterstitialController mraidinterstitialcontroller, MRAIDAudioVideoController mraidaudiovideocontroller, MRAIDResizeController mraidresizecontroller)
        {
            a = new WeakReference(IMWebView.this);
            b = new WeakReference(mraidexpandcontroller);
            d = new WeakReference(mraidbasic);
            e = new WeakReference(mraidinterstitialcontroller);
            f = new WeakReference(mraidaudiovideocontroller);
            c = new WeakReference(mraidresizecontroller);
        }

        private class h
        {

            static final int a[];

            static 
            {
                a = new int[ViewState.values().length];
                try
                {
                    a[ViewState.RESIZING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    a[ViewState.RESIZED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ViewState.EXPANDING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[ViewState.EXPANDED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[ViewState.HIDDEN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[ViewState.DEFAULT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5)
                {
                    return;
                }
            }
        }

    }


    private class d
        implements android.content.DialogInterface.OnClickListener
    {

        final SslErrorHandler a;
        final IMWebView b;

        public void onClick(DialogInterface dialoginterface, int i1)
        {
            dialoginterface.cancel();
            a.proceed();
        }

        d(SslErrorHandler sslerrorhandler)
        {
            b = IMWebView.this;
            a = sslerrorhandler;
            super();
        }
    }


    private class k
        implements android.content.DialogInterface.OnClickListener
    {

        final SslErrorHandler a;
        final IMWebView b;

        public void onClick(DialogInterface dialoginterface, int i1)
        {
            dialoginterface.cancel();
            a.cancel();
        }

        k(SslErrorHandler sslerrorhandler)
        {
            b = IMWebView.this;
            a = sslerrorhandler;
            super();
        }
    }


    private class e
        implements android.content.DialogInterface.OnClickListener
    {

        final SslError a;
        final IMWebView b;

        public void onClick(DialogInterface dialoginterface, int i1)
        {
            dialoginterface.cancel();
            IMWebView.a(b, WrapperFunctions.getSSLErrorUrl(a));
        }

        e(SslError sslerror)
        {
            b = IMWebView.this;
            a = sslerror;
            super();
        }
    }


    private class i extends AsyncTask
    {

        File a;
        String b;
        String c;
        int d;
        String e;
        final IMWebView f;

        public String a()
        {
            return c;
        }

        protected transient String a(Void avoid[])
        {
            boolean flag1;
            PackageManager packagemanager = IMWebView.h(f).getPackageManager();
            boolean flag;
            if (packagemanager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", packagemanager.getNameForUid(Binder.getCallingUid())) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                d = f.j.ordinal();
                return "failure";
            }
            if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
            {
                d = f.i.ordinal();
                return "failure";
            }
            if (!c.matches("[A-Za-z0-9]+") || c.equals(""))
            {
                d = f.c.ordinal();
                return "failure";
            }
            if (b.equals("") || !URLUtil.isValidUrl(b))
            {
                d = f.d.ordinal();
                return "failure";
            }
            if (!Environment.getExternalStorageState().equals("mounted"))
            {
                d = f.k.ordinal();
                return "failure";
            }
            String s1 = Initializer.getConfigParams().getAllowedContentType().replace("\\", "");
            String s2 = s1.substring(1, -1 + s1.length());
            String as[];
            int i1;
            long l1;
            HttpURLConnection httpurlconnection;
            String s3;
            int j1;
            if (s2.contains(","))
            {
                as = s2.split(",");
            } else
            {
                as = (new String[] {
                    s2
                });
            }
            i1 = Initializer.getConfigParams().getMaxSaveContentSize();
            long l2;
            FileOutputStream fileoutputstream;
            InputStream inputstream;
            byte abyte0[];
            long l3;
            int k1;
            long l4;
            String s4;
            JSONObject jsonobject;
            try
            {
                l1 = System.currentTimeMillis();
                httpurlconnection = (HttpURLConnection)(new URL(b)).openConnection();
                httpurlconnection.setRequestMethod("GET");
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setConnectTimeout(5000);
                s3 = httpurlconnection.getContentType();
                android.util.Log.i("Nilanjana", (new StringBuilder("contentType_url: ")).append(s3).toString());
            }
            catch (SocketTimeoutException sockettimeoutexception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "SocketTimeoutException");
                d = f.i.ordinal();
                return "failure";
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "FileNotFoundException");
                d = f.e.ordinal();
                return "failure";
            }
            catch (MalformedURLException malformedurlexception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "MalformedURLException");
                d = f.d.ordinal();
                return "failure";
            }
            catch (ProtocolException protocolexception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "ProtocolException");
                d = f.i.ordinal();
                return "failure";
            }
            catch (IOException ioexception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "IOException");
                d = f.a.ordinal();
                return "failure";
            }
            catch (JSONException jsonexception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "JSONException");
                d = f.a.ordinal();
                return "failure";
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "Unknown Exception");
                d = f.a.ordinal();
                return "failure";
            }
            j1 = 0;
            if (j1 >= as.length)
            {
                break MISSING_BLOCK_LABEL_845;
            }
            if (!as[j1].substring(1, -1 + as[j1].length()).equals(s3)) goto _L2; else goto _L1
_L1:
            flag1 = true;
_L7:
            if (flag1) goto _L4; else goto _L3
_L3:
            d = f.g.ordinal();
            return "failure";
_L2:
            j1++;
            break MISSING_BLOCK_LABEL_304;
_L4:
            l2 = httpurlconnection.getContentLength();
            if (l2 < 0L || l2 <= (long)(1024 * (i1 * 1024)))
            {
                break MISSING_BLOCK_LABEL_425;
            }
            d = f.h.ordinal();
            return "failure";
            httpurlconnection.connect();
            fileoutputstream = new FileOutputStream(a);
            inputstream = httpurlconnection.getInputStream();
            abyte0 = new byte[1024];
            l3 = 0L;
_L5:
            k1 = inputstream.read(abyte0);
            if (k1 <= 0)
            {
                break MISSING_BLOCK_LABEL_549;
            }
            l3 += k1;
            if (l3 <= (long)(1024 * (i1 * 1024)))
            {
                break MISSING_BLOCK_LABEL_512;
            }
            d = f.h.ordinal();
            return "failure";
            fileoutputstream.write(abyte0, 0, k1);
              goto _L5
            fileoutputstream.close();
            l4 = System.currentTimeMillis();
            s4 = (new StringBuilder("file://")).append(a.getAbsolutePath()).toString();
            Log.internal("[InMobi]-[RE]-4.4.1", (new StringBuilder("file path of video: ")).append(s4).toString());
            jsonobject = new JSONObject();
            jsonobject.put("url", b);
            jsonobject.put("saved_url", s4);
            jsonobject.put("size_in_bytes", a.length());
            jsonobject.put("download_started_at", l1);
            jsonobject.put("download_ended_at", l4);
            e = jsonobject.toString().replace("\"", "\\\"");
            return "success";
            flag1 = false;
            if (true) goto _L7; else goto _L6
_L6:
        }

        protected void a(String s1)
        {
            if (!s1.equals("success")) goto _L2; else goto _L1
_L1:
            f.injectJavaScript((new StringBuilder("window.mraid.sendSaveContentResult(\"saveContent_")).append(c).append("\", 'success', \"").append(e).append("\");").toString());
            if (f.c != null)
            {
                f.c.postSuccess();
            }
_L4:
            super.onPostExecute(s1);
            return;
_L2:
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("url", b);
                jsonobject.put("reason", d);
                String s2 = jsonobject.toString().replace("\"", "\\\"");
                f.injectJavaScript((new StringBuilder("window.mraid.sendSaveContentResult(\"saveContent_")).append(c).append("\", 'failure', \"").append(s2).append("\");").toString());
                if (f.c != null)
                {
                    f.c.postFailed(d);
                }
            }
            catch (JSONException jsonexception) { }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        i(File file, String s1, String s2)
        {
            f = IMWebView.this;
            super();
            d = -1;
            e = "";
            a = file;
            b = s1;
            c = s2;
            IMWebView.p(IMWebView.this).add(this);
        }

        private class f extends Enum
        {

            public static final f a;
            public static final f b;
            public static final f c;
            public static final f d;
            public static final f e;
            public static final f f;
            public static final f g;
            public static final f h;
            public static final f i;
            public static final f j;
            public static final f k;
            private static final f l[];

            public static f valueOf(String s1)
            {
                return (f)Enum.valueOf(com/inmobi/re/container/IMWebView$f, s1);
            }

            public static f[] values()
            {
                return (f[])l.clone();
            }

            static 
            {
                a = new f("UNKNOWN_ERROR", 0);
                b = new f("MISSING_PARAMETER", 1);
                c = new f("CONETNT_ID_ERROR", 2);
                d = new f("CONTENT_URL_ERROR", 3);
                e = new f("CONTENT_URL_NOT_FOUND", 4);
                f = new f("NOT_SUPPORTED_SDK", 5);
                g = new f("CONTENT_TYPE_NOT_SUPPORTED", 6);
                h = new f("CONTENT_SIZE_NOT_SUPPORTED", 7);
                i = new f("NETWORK_ERROR", 8);
                j = new f("PERMISSION_ERROR", 9);
                k = new f("SD_CARD_ERROR", 10);
                f af[] = new f[11];
                af[0] = a;
                af[1] = b;
                af[2] = c;
                af[3] = d;
                af[4] = e;
                af[5] = f;
                af[6] = g;
                af[7] = h;
                af[8] = i;
                af[9] = j;
                af[10] = k;
                l = af;
            }

            private f(String s1, int i1)
            {
                super(s1, i1);
            }
        }


        private class InstantVideoCallbackCallback
        {

            public abstract void postFailed(int i1);

            public abstract void postSuccess();
        }

    }


    private class g
        implements Runnable
    {

        final IMWebView a;

        public void run()
        {
            if (a.getParent() != null)
            {
                ((ViewGroup)a.getParent()).removeView(a);
            }
            a.b.set(true);
            IMWebView.o(a);
        }

        g()
        {
            a = IMWebView.this;
            super();
        }
    }


    private class IMWebViewListener
    {

        public abstract void onDismissAdScreen();

        public abstract void onError();

        public abstract void onExpand();

        public abstract void onExpandClose();

        public abstract void onIncentCompleted(Map map);

        public abstract void onLeaveApplication();

        public abstract void onResize(ResizeDimensions resizedimensions);

        public abstract void onResizeClose();

        public abstract void onShowAdScreen();

        public abstract void onUserInteraction(Map map);
    }


    private class c
        implements Runnable
    {

        final String a;
        final IMWebView b;

        public void run()
        {
            b.injectJavaScript(a);
        }

        c(String s1)
        {
            b = IMWebView.this;
            a = s1;
            super();
        }
    }


    private class j
        implements Runnable
    {

        final String a;
        final IMWebView b;

        public void run()
        {
            b.injectJavaScript(a);
        }

        j(String s1)
        {
            b = IMWebView.this;
            a = s1;
            super();
        }
    }


    private class b
        implements Runnable
    {

        final String a;
        final IMWebView b;

        public void run()
        {
            b.injectJavaScript(a);
        }

        b(String s1)
        {
            b = IMWebView.this;
            a = s1;
            super();
        }
    }


    private class a
        implements Runnable
    {

        final IMWebView a;

        public void run()
        {
            try
            {
                a.injectJavaScript("window.mraid.broadcastEvent('vibrateComplete')");
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[RE]-4.4.1", "Exception giviing vibration complete callback", exception);
            }
        }

        a()
        {
            a = IMWebView.this;
            super();
        }
    }

}
