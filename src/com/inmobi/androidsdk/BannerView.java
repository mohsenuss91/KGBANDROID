// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.androidsdk.carb.CARB;
import com.inmobi.androidsdk.impl.ConfigException;
import com.inmobi.androidsdk.impl.ConnBroadcastReciever;
import com.inmobi.androidsdk.impl.SDKUtil;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.imai.IMAIController;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.container.IMWebView;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.androidsdk:
//            AdRequest, d, c, b, 
//            g, BannerViewListener

public final class BannerView extends RelativeLayout
{

    public static final int INMOBI_AD_UNIT_120X600 = 13;
    public static final int INMOBI_AD_UNIT_300X250 = 10;
    public static final int INMOBI_AD_UNIT_320X48 = 9;
    public static final int INMOBI_AD_UNIT_320X50 = 15;
    public static final int INMOBI_AD_UNIT_468X60 = 12;
    public static final int INMOBI_AD_UNIT_728X90 = 11;
    public static final String INMOBI_INTERNAL_TAG = "ref-__in__rt";
    public static final String INMOBI_REF_TAG = "ref-tag";
    private static ConnBroadcastReciever a = null;
    private boolean A;
    private d B;
    private android.view.animation.Animation.AnimationListener C;
    private HttpRequestCallback D;
    private com.inmobi.re.container.IMWebView.IMWebViewListener E;
    private boolean F;
    private IMWebView b;
    private IMWebView c;
    private IMWebView d;
    private Activity e;
    private boolean f;
    private UserInfo g;
    private AtomicBoolean h;
    private AtomicBoolean i;
    private Animation j;
    private Animation k;
    private String l;
    private String m;
    private BannerViewListener n;
    private AdRequest o;
    private String p;
    private int q;
    private long r;
    private long s;
    private long t;
    private boolean u;
    private AnimationType v;
    private boolean w;
    private g x;
    private String y;
    private RequestResponseManager z;

    public BannerView(Activity activity, int i1, String s1)
    {
        this(((Context) (activity)));
        a(activity, i1, s1);
    }

    public BannerView(Activity activity, int i1, String s1, long l1)
    {
        this(((Context) (activity)));
        r = l1;
        a(activity, i1, s1);
    }

    private BannerView(Context context)
    {
        super(context);
        f = true;
        h = new AtomicBoolean();
        i = new AtomicBoolean();
        l = null;
        m = null;
        o = new AdRequest();
        r = -1L;
        s = 0L;
        t = 0L;
        u = true;
        v = AnimationType.ROTATE_HORIZONTAL_AXIS;
        w = true;
        y = "http://i.w.inmobi.com/showad.asm";
        B = new d();
        C = new com.inmobi.androidsdk.d(this);
        D = new c(this);
        E = new b(this);
        F = true;
    }

    public BannerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = true;
        h = new AtomicBoolean();
        i = new AtomicBoolean();
        l = null;
        m = null;
        o = new AdRequest();
        r = -1L;
        s = 0L;
        t = 0L;
        u = true;
        v = AnimationType.ROTATE_HORIZONTAL_AXIS;
        w = true;
        y = "http://i.w.inmobi.com/showad.asm";
        B = new d();
        C = new com.inmobi.androidsdk.d(this);
        D = new c(this);
        E = new b(this);
        F = true;
        if (attributeset == null)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Missing attributes in xml layout of IMAdview ");
            return;
        }
        String s1 = attributeset.getAttributeValue(null, "appId");
        int i1 = attributeset.getAttributeIntValue(null, "adSize", -1);
        String s2 = attributeset.getAttributeValue(null, "slotId");
        if (s2 != null)
        {
            r = Long.parseLong(s2);
        }
        a((Activity)context, i1, s1);
    }

    static BannerViewListener a(BannerView bannerview)
    {
        return bannerview.n;
    }

    static IMWebView a(BannerView bannerview, IMWebView imwebview)
    {
        bannerview.b = imwebview;
        return imwebview;
    }

    static String a(BannerView bannerview, String s1)
    {
        bannerview.l = s1;
        return s1;
    }

    private void a(int i1)
    {
        if (i1 < 0)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Invalid Ad Size. Please provide a valid Ad Size. If Ad Size is declared in the layout XML, please provide a valid 'adSize' attribute in the 'com.inmobi.androidsdk.IMAdView' tag of layout XML. For example, adSize=\"yourAdSize\"");
        }
    }

    private void a(int i1, AdRequest.ErrorCode errorcode)
    {
        if (!F)
        {
            e.runOnUiThread(new b());
        }
        if (!w)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "IMAdView not sending callback because the view is not added to any window.");
        } else
        if (n != null)
        {
            e.runOnUiThread(new a(i1, errorcode));
            return;
        }
    }

    private void a(Activity activity, int i1, String s1)
    {
        try
        {
            SDKUtil.validateAdConfiguration(activity);
        }
        catch (ConfigException configexception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "IMConfigException occured while initializing interstitial while validating adView", configexception);
        }
        InternalSDKUtil.getUserAgent(activity.getApplicationContext());
        a(i1);
        p = s1;
        q = i1;
        e = SDKUtil.getRootActivity(activity);
        IMWebView.setIMAIController(com/inmobi/androidsdk/impl/imai/IMAIController);
        InternalSDKUtil.printPublisherTestId();
        if (b == null)
        {
            b = new IMWebView(e, E, false, false);
            if (!F)
            {
                b.disableHardwareAcceleration();
            }
            b.addJavascriptInterface(new IMAIController(b), "imaiController");
        }
        if (c == null)
        {
            c = new IMWebView(e, E, false, false);
            if (!F)
            {
                c.disableHardwareAcceleration();
            }
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            d = c;
            addView(c, layoutparams);
            c.addJavascriptInterface(new IMAIController(c), "imaiController");
        }
        d();
        x = new g(this, C);
        if (a == null)
        {
            a = new ConnBroadcastReciever();
        }
        e.getApplicationContext().registerReceiver(a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    static void a(BannerView bannerview, int i1, AdRequest.ErrorCode errorcode)
    {
        bannerview.a(i1, errorcode);
    }

    static void a(BannerView bannerview, boolean flag)
    {
        bannerview.a(flag);
    }

    private void a(String s1)
    {
        if (s1 != null)
        {
            if (android.os.Build.VERSION.SDK_INT <= 8)
            {
                s1.replaceAll("%", "%25");
            }
            IMWebView imwebview;
            if (i())
            {
                if (b == null)
                {
                    b = new IMWebView(e, E, false, false);
                    if (!F)
                    {
                        b.disableHardwareAcceleration();
                    }
                }
                imwebview = b;
            } else
            {
                if (c == null)
                {
                    c = new IMWebView(e, E, false, false);
                    if (!F)
                    {
                        c.disableHardwareAcceleration();
                    }
                }
                imwebview = c;
            }
            imwebview.addJavascriptInterface(new IMAIController(imwebview), "imaiController");
            imwebview.requestOnPageFinishedCallback(B.obtainMessage(101));
            s = System.currentTimeMillis();
            B.sendEmptyMessageDelayed(108, Initializer.getConfigParams().getRenderTimeOut());
            imwebview.resetMraid();
            imwebview.loadDataWithBaseURL("", s1, "text/html", null, null);
            return;
        } else
        {
            a(false);
            Log.debug("[InMobi]-[Network]-4.4.1", "Cannot load Ad. Invalid Ad Response");
            a(101, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
    }

    private void a(boolean flag)
    {
        h.set(flag);
    }

    static long b(BannerView bannerview)
    {
        return bannerview.t;
    }

    static IMWebView b(BannerView bannerview, IMWebView imwebview)
    {
        bannerview.c = imwebview;
        return imwebview;
    }

    static void b(BannerView bannerview, String s1)
    {
        bannerview.a(s1);
    }

    private void b(boolean flag)
    {
        i.set(flag);
    }

    static boolean b(BannerView bannerview, boolean flag)
    {
        bannerview.u = flag;
        return flag;
    }

    static IMWebView c(BannerView bannerview, IMWebView imwebview)
    {
        bannerview.d = imwebview;
        return imwebview;
    }

    static String c(BannerView bannerview, String s1)
    {
        bannerview.m = s1;
        return s1;
    }

    private void c()
    {
        int i1;
        float f1;
        i1 = 320;
        f1 = e.getResources().getDisplayMetrics().density;
        q;
        JVM INSTR tableswitch 9 15: default 185
    //                   9 115
    //                   10 122
    //                   11 134
    //                   12 145
    //                   13 156
    //                   14 185
    //                   15 167;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L7
_L11:
        int j1;
        if (i1 == 0 || j1 == 0) goto _L9; else goto _L8
_L8:
        int k1;
        int l1;
        k1 = (int)(f1 * (float)i1);
        l1 = (int)(f1 * (float)j1);
        getLayoutParams().height = l1;
        getLayoutParams().width = k1;
        setLayoutParams(getLayoutParams());
_L9:
        return;
_L2:
        j1 = 48;
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = 300;
        j1 = 250;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = 729;
        j1 = 90;
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = 468;
        j1 = 60;
        continue; /* Loop/switch isn't completed */
_L6:
        i1 = 120;
        j1 = 600;
        continue; /* Loop/switch isn't completed */
_L7:
        j1 = 50;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Cannot set default size for adview", exception);
        return;
_L1:
        j1 = 0;
        i1 = 0;
        if (true) goto _L11; else goto _L10
_L10:
    }

    static void c(BannerView bannerview, boolean flag)
    {
        bannerview.b(flag);
    }

    private void c(boolean flag)
    {
        f = flag;
        if (flag)
        {
            b.deinit();
            b = null;
            return;
        } else
        {
            c.deinit();
            c = null;
            return;
        }
    }

    static boolean c(BannerView bannerview)
    {
        return bannerview.A;
    }

    static String d(BannerView bannerview)
    {
        return bannerview.m;
    }

    private void d()
    {
        if (g == null)
        {
            g = new UserInfo(e);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            e.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            float f1 = displaymetrics.density;
            Display display = ((WindowManager)e.getSystemService("window")).getDefaultDisplay();
            int i1 = (int)((float)WrapperFunctions.getDisplayWidth(display) / f1);
            int j1 = (int)((float)WrapperFunctions.getDisplayHeight(display) / f1);
            g.setScreenDensity(String.valueOf(f1));
            g.setScreenSize((new StringBuilder()).append(i1).append("X").append(j1).toString());
            try
            {
                if (b != null && g.getPhoneDefaultUserAgent().equals(""))
                {
                    g.setPhoneDefaultUserAgent(InternalSDKUtil.getUserAgent(e.getApplicationContext()));
                }
            }
            catch (Exception exception)
            {
                Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Exception occured while setting user agent")).append(exception).toString());
            }
        }
        g.setAdUnitSlot(String.valueOf(q));
        if (r != -1L)
        {
            g.setSlotId(Long.toString(r));
        }
        g.updateInfo(p, o);
    }

    static void d(BannerView bannerview, boolean flag)
    {
        bannerview.c(flag);
    }

    static String e(BannerView bannerview)
    {
        return bannerview.l;
    }

    private void e()
    {
        removeAllViews();
        if (!i())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        d = b;
        addView(b, layoutparams);
_L1:
        boolean flag = i();
        boolean flag1;
        flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        c(flag1);
        a(false);
        j();
        a(100, ((AdRequest.ErrorCode) (null)));
        return;
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        d = c;
        addView(c, layoutparams1);
          goto _L1
        Exception exception1;
        exception1;
        Log.debug("[InMobi]-[Network]-4.4.1", "Error swapping banner ads", exception1);
        a(100, ((AdRequest.ErrorCode) (null)));
        return;
        Exception exception;
        exception;
        a(100, ((AdRequest.ErrorCode) (null)));
        throw exception;
    }

    static long f(BannerView bannerview)
    {
        return bannerview.s;
    }

    private boolean f()
    {
        if (q < 0)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Invalid Ad Size. Please provide a valid adSize.");
            return false;
        } else
        {
            return true;
        }
    }

    private boolean g()
    {
        return h.get();
    }

    static boolean g(BannerView bannerview)
    {
        return bannerview.i();
    }

    static IMWebView h(BannerView bannerview)
    {
        return bannerview.b;
    }

    private boolean h()
    {
        if (i.get())
        {
            return true;
        }
        IMWebView imwebview;
        String s1;
        if (i())
        {
            imwebview = c;
        } else
        {
            imwebview = b;
        }
        s1 = imwebview.getState();
        Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Current Ad State: ")).append(s1).toString());
        if (com.inmobi.re.container.IMWebView.ViewState.EXPANDED.toString().equalsIgnoreCase(s1) || com.inmobi.re.container.IMWebView.ViewState.RESIZED.toString().equalsIgnoreCase(s1) || com.inmobi.re.container.IMWebView.ViewState.RESIZING.toString().equalsIgnoreCase(s1) || com.inmobi.re.container.IMWebView.ViewState.EXPANDING.toString().equalsIgnoreCase(s1))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Current Ad State is neither default nor loading. New ad will not be shown.");
            return true;
        }
        if (imwebview.isBusy())
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "New ad will not be shown because the present ad is busy. Eg. Video/audio is playing, etc.");
            return true;
        } else
        {
            return false;
        }
    }

    static IMWebView i(BannerView bannerview)
    {
        return bannerview.c;
    }

    private boolean i()
    {
        return f;
    }

    static RequestResponseManager j(BannerView bannerview)
    {
        return bannerview.z;
    }

    private void j()
    {
        try
        {
            if (c != null)
            {
                c.setBackgroundColor(0);
            }
            if (b != null)
            {
                b.setBackgroundColor(0);
            }
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Error setNormalBGColor", exception);
        }
    }

    static boolean k(BannerView bannerview)
    {
        return bannerview.u;
    }

    static void l(BannerView bannerview)
    {
        bannerview.e();
    }

    static AnimationType m(BannerView bannerview)
    {
        return bannerview.v;
    }

    static g n(BannerView bannerview)
    {
        return bannerview.x;
    }

    static void o(BannerView bannerview)
    {
        bannerview.j();
    }

    static d p(BannerView bannerview)
    {
        return bannerview.B;
    }

    final Animation a()
    {
        return j;
    }

    final void a(Animation animation)
    {
        j = animation;
    }

    final Animation b()
    {
        return k;
    }

    final void b(Animation animation)
    {
        k = animation;
    }

    public final void destroy()
    {
        try
        {
            if (d != null)
            {
                d.destroy();
            }
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Unable to destroy webview, or it has been destroyed already.");
        }
        d = null;
    }

    public final void disableHardwareAcceleration()
    {
        F = false;
        if (d != null)
        {
            d.disableHardwareAcceleration();
        }
    }

    public final int getAdSize()
    {
        return q;
    }

    public final android.widget.RelativeLayout.LayoutParams getAdViewPosition()
    {
        int ai[] = new int[2];
        android.widget.RelativeLayout.LayoutParams layoutparams1;
        if (d == null || d.getLayoutParams() == null || d.getParent() == this)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(getLayoutParams());
            layoutparams.width = getWidth();
            layoutparams.height = getHeight();
            getLocationOnScreen(ai);
            layoutparams.leftMargin = ai[0];
            layoutparams.topMargin = ai[1];
            layoutparams1 = layoutparams;
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(d.getLayoutParams());
            layoutparams2.width = d.getWidth();
            layoutparams2.height = d.getHeight();
            d.getLocationOnScreen(ai);
            layoutparams2.leftMargin = ai[0];
            layoutparams2.topMargin = ai[1];
            layoutparams1 = layoutparams2;
        }
        ((FrameLayout)getRootView().findViewById(0x1020002)).getLocationOnScreen(ai);
        layoutparams1.leftMargin = layoutparams1.leftMargin - ai[0];
        layoutparams1.topMargin = layoutparams1.topMargin - ai[1];
        layoutparams1.rightMargin = 0;
        layoutparams1.bottomMargin = 0;
        return layoutparams1;
    }

    public final String getAppId()
    {
        return p;
    }

    public final BannerViewListener getIMAdListener()
    {
        return n;
    }

    public final AdRequest getIMAdRequest()
    {
        return o;
    }

    public final long getSlotId()
    {
        return r;
    }

    public final boolean isModal()
    {
        if (d != null)
        {
            return d.isModal();
        } else
        {
            return false;
        }
    }

    public final void loadNewAd()
    {
        this;
        JVM INSTR monitorenter ;
        z = new RequestResponseManager();
        A = Initializer.getLogger().startNewSample();
        InternalSDKUtil.printPublisherTestId();
        Log.debug("[InMobi]-[Network]-4.4.1", " >>>> Start loading new Ad <<<<");
        if (InternalSDKUtil.checkNetworkAvailibility(e.getApplicationContext())) goto _L2; else goto _L1
_L1:
        a(101, AdRequest.ErrorCode.NETWORK_ERROR);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!g())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        a(101, AdRequest.ErrorCode.AD_DOWNLOAD_IN_PROGRESS);
          goto _L3
        Exception exception1;
        exception1;
        Log.debug("[InMobi]-[Network]-4.4.1", "Error in loading ad ", exception1);
          goto _L3
        Exception exception;
        exception;
        throw exception;
label0:
        {
            if (!h())
            {
                break label0;
            }
            a(101, AdRequest.ErrorCode.AD_CLICK_IN_PROGRESS);
        }
          goto _L3
label1:
        {
            if (f())
            {
                break label1;
            }
            a(101, AdRequest.ErrorCode.INVALID_REQUEST);
        }
          goto _L3
        CARB.getInstance().startCarb();
        a(true);
        d();
        t = System.currentTimeMillis();
        B.sendEmptyMessageDelayed(107, Initializer.getConfigParams().getFetchTimeOut());
        z.asyncRequestSecuredAd(g, com.inmobi.androidsdk.impl.net.RequestResponseManager.ActionType.AdRequest, y, D);
          goto _L3
    }

    public final void loadNewAd(AdRequest adrequest)
    {
        if (adrequest != null)
        {
            o = adrequest;
        }
        loadNewAd();
    }

    protected final void onAttachedToWindow()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "onAttachedToWindow");
        w = true;
        c();
    }

    protected final void onDetachedFromWindow()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "onDetatchedFromWindow");
        w = false;
        IMWebView imwebview;
        if (i())
        {
            imwebview = c;
        } else
        {
            imwebview = b;
        }
        if (imwebview != null)
        {
            imwebview.deinit();
        }
    }

    protected final void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        RequestResponseManager requestresponsemanager = new RequestResponseManager();
        requestresponsemanager.init();
        requestresponsemanager.processClick(e.getApplicationContext(), null);
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Exception ping in background", exception);
        return;
    }

    public final void setAdBackgroundColor(String s1)
    {
    }

    public final void setAdBackgroundGradientColor(String s1, String s2)
    {
    }

    public final void setAdServerUrl(String s1)
    {
        y = s1;
    }

    public final void setAdSize(int i1)
    {
        a(i1);
        q = i1;
    }

    public final void setAdTextColor(String s1)
    {
    }

    public final void setAnimationType(AnimationType animationtype)
    {
        v = animationtype;
    }

    public final void setAppId(String s1)
    {
        p = s1;
    }

    public final void setIMAdListener(BannerViewListener bannerviewlistener)
    {
        n = bannerviewlistener;
    }

    public final void setIMAdRequest(AdRequest adrequest)
    {
        o = adrequest;
    }

    public final void setRefTagParam(String s1, String s2)
    {
        if (s1 == null || s2 == null)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Key or Value cannot be null");
        } else
        {
            if (s1.trim().equals("") || s2.trim().equals(""))
            {
                Log.debug("[InMobi]-[Network]-4.4.1", "Key or Value cannot be empty");
                return;
            }
            if (g != null)
            {
                g.setRefTagKey(s1.toLowerCase(Locale.ENGLISH));
                g.setRefTagValue(s2.toLowerCase(Locale.ENGLISH));
                return;
            }
        }
    }

    public final void setSlotId(long l1)
    {
        r = l1;
    }

    public final void stopLoading()
    {
        if (B.hasMessages(107))
        {
            B.removeMessages(107);
            B.sendEmptyMessage(107);
        } else
        if (B.hasMessages(108))
        {
            B.removeMessages(108);
            B.sendEmptyMessage(108);
            return;
        }
    }


    private class d extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            BannerView bannerview = (BannerView)a.get();
            if (bannerview == null) goto _L2; else goto _L1
_L1:
            int i1 = message.what;
            i1;
            JVM INSTR tableswitch 101 111: default 80
        //                       101 595
        //                       102 746
        //                       103 80
        //                       104 754
        //                       105 764
        //                       106 774
        //                       107 468
        //                       108 296
        //                       109 86
        //                       110 245
        //                       111 272;
               goto _L3 _L4 _L5 _L3 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L3:
            break; /* Loop/switch isn't completed */
_L8:
            break MISSING_BLOCK_LABEL_774;
_L2:
            super.handleMessage(message);
            return;
_L11:
            long l4 = System.currentTimeMillis() - BannerView.b(bannerview);
            if (!BannerView.c(bannerview)) goto _L15; else goto _L14
_L14:
            JSONObject jsonobject3 = new JSONObject();
            jsonobject3.put("ad", BannerView.d(bannerview));
            jsonobject3.put("t", l4);
_L16:
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.FETCH_COMPLETE, jsonobject3));
_L15:
            Exception exception;
            removeMessages(107);
            if (BannerView.e(bannerview) != null)
            {
                BannerView.a(bannerview, BannerView.e(bannerview).replace("@__imm_aft@", (new StringBuilder()).append(l4).toString()));
            }
            BannerView.b(bannerview, BannerView.e(bannerview));
              goto _L2
            JSONException jsonexception3;
            jsonexception3;
            Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
              goto _L16
_L12:
            try
            {
                removeMessages(107);
                BannerView.a(bannerview, 101, (AdRequest.ErrorCode)message.obj);
                BannerView.a(bannerview, false);
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Exception hanlde message adview", exception);
            }
              goto _L2
_L13:
            removeMessages(108);
            removeMessages(101);
            BannerView.a(bannerview, 101, AdRequest.ErrorCode.INTERNAL_ERROR);
              goto _L2
_L10:
            if (!BannerView.c(bannerview)) goto _L18; else goto _L17
_L17:
            long l3;
            JSONObject jsonobject2;
            l3 = System.currentTimeMillis() - BannerView.f(bannerview);
            jsonobject2 = new JSONObject();
            jsonobject2.put("ad", BannerView.d(bannerview));
            jsonobject2.put("t", l3);
_L19:
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_TIMEOUT, jsonobject2));
_L18:
            IMWebView imwebview;
            removeMessages(111);
            removeMessages(101);
            BannerView.a(bannerview, false);
            if (!BannerView.g(bannerview))
            {
                break MISSING_BLOCK_LABEL_453;
            }
            imwebview = BannerView.h(bannerview);
            BannerView.a(bannerview, null);
_L20:
            imwebview.cancelLoad();
            imwebview.stopLoading();
            imwebview.deinit();
            BannerView.a(bannerview, 101, AdRequest.ErrorCode.AD_RENDERING_TIMEOUT);
              goto _L2
            JSONException jsonexception2;
            jsonexception2;
            Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
              goto _L19
            imwebview = BannerView.i(bannerview);
            BannerView.b(bannerview, null);
              goto _L20
_L9:
            long l2;
            removeMessages(109);
            removeMessages(110);
            BannerView.j(bannerview).doCancel();
            l2 = System.currentTimeMillis() - BannerView.b(bannerview);
            if (!BannerView.c(bannerview)) goto _L22; else goto _L21
_L21:
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("t", l2);
            jsonobject1.put("m", 1);
_L23:
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.CONNECT_ERROR, jsonobject1));
_L22:
            BannerView.a(bannerview, false);
            BannerView.a(bannerview, 101, AdRequest.ErrorCode.AD_FETCH_TIMEOUT);
              goto _L2
            JSONException jsonexception1;
            jsonexception1;
            Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for error at ")).append(System.currentTimeMillis()).toString());
              goto _L23
_L4:
            if (!BannerView.c(bannerview)) goto _L25; else goto _L24
_L24:
            long l1;
            JSONObject jsonobject;
            l1 = System.currentTimeMillis() - BannerView.b(bannerview);
            jsonobject = new JSONObject();
            jsonobject.put("ad", BannerView.d(bannerview));
            jsonobject.put("t", l1);
_L26:
            Initializer.getLogger().logEvent(new EventLog(NetworkEventType.RENDER_COMPLETE, jsonobject));
_L25:
            removeMessages(108);
            if (!BannerView.k(bannerview))
            {
                break MISSING_BLOCK_LABEL_715;
            }
            BannerView.l(bannerview);
            BannerView.b(bannerview, false);
              goto _L2
            JSONException jsonexception;
            jsonexception;
            Log.internal("[InMobi]-[Network]-4.4.1", (new StringBuilder("Error creating metric logs for fetch_complete at ")).append(System.currentTimeMillis()).toString());
              goto _L26
label0:
            {
                if (BannerView.m(bannerview) != AnimationType.ANIMATION_OFF)
                {
                    break label0;
                }
                BannerView.l(bannerview);
            }
              goto _L2
            BannerView.n(bannerview).a(BannerView.m(bannerview));
              goto _L2
_L5:
            BannerView.c(bannerview, false);
              goto _L2
_L6:
            BannerView.a(bannerview, 103, null);
              goto _L2
_L7:
            BannerView.a(bannerview, 102, null);
              goto _L2
            BannerView.a(bannerview, 104, null);
              goto _L2
        }

        public d()
        {
            a = new WeakReference(BannerView.this);
        }
    }


    private class b
        implements Runnable
    {

        final BannerView a;

        public void run()
        {
            a.disableHardwareAcceleration();
        }

        b()
        {
            a = BannerView.this;
            super();
        }
    }


    private class a
        implements Runnable
    {

        final int a;
        final AdRequest.ErrorCode b;
        final BannerView c;

        public void run()
        {
            a;
            JVM INSTR tableswitch 100 106: default 48
        //                       100 61
        //                       101 88
        //                       102 218
        //                       103 201
        //                       104 235
        //                       105 252
        //                       106 269;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            Log.debug("[InMobi]-[Network]-4.4.1", b.toString());
            return;
_L2:
            try
            {
                BannerView.a(c).onAdRequestCompleted(c);
                return;
            }
            catch (Exception exception)
            {
                Log.debug("[InMobi]-[Network]-4.4.1", "Exception giving callback to the publisher ", exception);
            }
            return;
_L3:
            c.a[b.ordinal()];
            JVM INSTR tableswitch 1 4: default 128
        //                       1 161
        //                       2 171
        //                       3 181
        //                       4 191;
               goto _L9 _L10 _L11 _L12 _L13
_L9:
            Log.debug("[InMobi]-[Network]-4.4.1", b.toString());
_L14:
            BannerView.a(c).onAdRequestFailed(c, b);
            return;
_L10:
            Log.debug("[InMobi]-[Network]-4.4.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
              goto _L14
_L11:
            Log.debug("[InMobi]-[Network]-4.4.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
              goto _L14
_L12:
            Log.debug("[InMobi]-[Network]-4.4.1", "Ad request successful, but no ad was returned due to lack of ad inventory.");
              goto _L14
_L13:
            Log.debug("[InMobi]-[Network]-4.4.1", "Your App Id may be invalid or inactive. Please verify the app ID");
              goto _L14
_L5:
            BannerView.a(c).onDismissAdScreen(c);
            return;
_L4:
            BannerView.a(c).onShowAdScreen(c);
            return;
_L6:
            BannerView.a(c).onLeaveApplication(c);
            return;
_L7:
            BannerView.a(c).onShowAdScreen(c);
            return;
_L8:
            BannerView.a(c).onDismissAdScreen(c);
            return;
        }

        a(int i1, AdRequest.ErrorCode errorcode)
        {
            c = BannerView.this;
            a = i1;
            b = errorcode;
            super();
        }

        private class c
        {

            static final int a[];

            static 
            {
                a = new int[AdRequest.ErrorCode.values().length];
                try
                {
                    a[AdRequest.ErrorCode.AD_CLICK_IN_PROGRESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    a[AdRequest.ErrorCode.AD_DOWNLOAD_IN_PROGRESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AdRequest.ErrorCode.NO_FILL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AdRequest.ErrorCode.INVALID_APP_ID.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3)
                {
                    return;
                }
            }
        }

    }

}
