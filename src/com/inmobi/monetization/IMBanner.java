// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.androidsdk.BannerView;
import com.inmobi.androidsdk.BannerViewListener;
import com.inmobi.androidsdk.bootstrapper.ConfigParams;
import com.inmobi.androidsdk.bootstrapper.Initializer;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.monetization.internal.LtvpRuleProcessor;
import com.inmobi.monetization.internal.MonetizationUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization:
//            IMErrorCode, IMBannerListener

public final class IMBanner extends RelativeLayout
{

    public static final int INMOBI_AD_UNIT_120X600 = 13;
    public static final int INMOBI_AD_UNIT_300X250 = 10;
    public static final int INMOBI_AD_UNIT_320X48 = 9;
    public static final int INMOBI_AD_UNIT_320X50 = 15;
    public static final int INMOBI_AD_UNIT_468X60 = 12;
    public static final int INMOBI_AD_UNIT_728X90 = 11;
    public static final int REFRESH_INTERVAL_MINIMUM = 0;
    public static final int REFRESH_INTERVAL_OFF = -1;
    private static com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule j = null;
    BannerView a;
    com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule b;
    BannerViewListener c;
    Activity d;
    long e;
    int f;
    AnimationType g;
    boolean h;
    private AtomicBoolean i;
    private IMBannerListener k;
    private AtomicBoolean l;
    private String m;
    private String n;
    private String o;
    private Map p;
    private String q;
    private int r;
    private int s;
    private a t;

    public IMBanner(Activity activity, long l1)
    {
        super(activity);
        a = null;
        i = new AtomicBoolean(false);
        b = com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.MEDIATION;
        c = null;
        l = new AtomicBoolean(false);
        e = -1L;
        f = 15;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        g = null;
        h = false;
        r = 0;
        s = 0;
        t = new a();
        d = activity;
        e = l1;
        a();
    }

    public IMBanner(Activity activity, String s1, int i1)
    {
        super(activity);
        a = null;
        i = new AtomicBoolean(false);
        b = com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.MEDIATION;
        c = null;
        l = new AtomicBoolean(false);
        e = -1L;
        f = 15;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        g = null;
        h = false;
        r = 0;
        s = 0;
        t = new a();
        d = activity;
        f = i1;
        q = s1;
        a();
    }

    public IMBanner(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        i = new AtomicBoolean(false);
        b = com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.MEDIATION;
        c = null;
        l = new AtomicBoolean(false);
        e = -1L;
        f = 15;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        g = null;
        h = false;
        r = 0;
        s = 0;
        t = new a();
        d = (Activity)context;
        try
        {
            e = Long.parseLong(attributeset.getAttributeValue(null, "slotId"));
        }
        catch (Exception exception) { }
        try
        {
            f = Integer.parseInt(attributeset.getAttributeValue(null, "adSize"));
        }
        catch (Exception exception1) { }
        try
        {
            q = attributeset.getAttributeValue(null, "appId");
        }
        catch (Exception exception2) { }
        if (e == -1L && q == null)
        {
            Log.debug("[InMobi]-[Monetization]", "slotId and appId is missing in IMBanner xml layout. Please integrate using appId or slotId. Refer integration guidelines for more details.");
        }
        a();
    }

    static IMBannerListener a(IMBanner imbanner)
    {
        return imbanner.k;
    }

    private void a()
    {
        setRefreshInterval(Initializer.getConfigParams().getDefaultRefreshRate());
        if (InternalSDKUtil.isInitializedSuccessfully())
        {
            try
            {
                ThinICE.start(d);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Cannot start ice. Activity is null");
            }
            if (e != -1L)
            {
                b();
                return;
            }
        }
    }

    private void a(int i1)
    {
        r = i1;
        if (i1 == -1)
        {
            t.removeMessages(100);
            return;
        }
        int j1 = Initializer.getConfigParams().getMinimumRefreshRate();
        if (i1 < j1)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", (new StringBuilder("Refresh Interval cannot be less than ")).append(j1).append(" seconds. Setting refresh rate to ").append(j1).toString());
        }
        h();
    }

    static void a(IMBanner imbanner, boolean flag)
    {
        imbanner.a(flag);
    }

    private void a(boolean flag)
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        c();
        if (i.get() || l.get())
        {
            IMErrorCode imerrorcode = IMErrorCode.INVALID_REQUEST;
            String s1;
            if (i.get())
            {
                s1 = "Banner load is already in progress.";
            } else
            {
                s1 = "Banner click in progress.";
            }
            imerrorcode.setMessage(s1);
            t.post(new d(imerrorcode));
            Log.verbose("[InMobi]-[Monetization]", s1);
            h();
            return;
        }
        i.set(true);
        t.removeMessages(100);
        if (a != null)
        {
            Object obj = a.getIMAdRequest().getRequestParams();
            if (obj == null)
            {
                obj = new HashMap();
            }
            if (flag)
            {
                ((Map) (obj)).put("u-rt", "0");
            } else
            {
                ((Map) (obj)).put("u-rt", "1");
            }
            a.getIMAdRequest().setRequestParams(((Map) (obj)));
            if (q != null || e != -1L)
            {
                a.loadNewAd();
                return;
            } else
            {
                i.set(false);
                t.post(new e());
                return;
            }
        } else
        {
            i.set(false);
            return;
        }
    }

    private com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule b()
    {
        return LtvpRuleProcessor.getInstance().getLtvpRuleConfig(e);
    }

    static void b(IMBanner imbanner)
    {
        imbanner.h();
    }

    static AtomicBoolean c(IMBanner imbanner)
    {
        return imbanner.l;
    }

    private void c()
    {
_L2:
        return;
        if (!InternalSDKUtil.isInitializedSuccessfully(false) || i.get() || l.get()) goto _L2; else goto _L1
_L1:
        e();
        if (e == -1L) goto _L4; else goto _L3
_L3:
        b = b();
        if (j != null)
        {
            b = j;
        }
        f.a[b.ordinal()];
        JVM INSTR tableswitch 1 4: default 104
    //                   1 256
    //                   2 256
    //                   3 263
    //                   4 286;
           goto _L5 _L6 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_286;
_L6:
        break; /* Loop/switch isn't completed */
_L5:
        g();
        t.post(new g());
_L4:
        if (a != null)
        {
            MonetizationUtils.updateIMAdRequest(a.getIMAdRequest());
            if (n != null && o != null)
            {
                a.setRefTagParam(n, o);
            }
            if (p != null)
            {
                a.getIMAdRequest().setRequestParams(p);
            }
            if (m != null)
            {
                a.getIMAdRequest().setKeywords(m);
            }
            a.setAdSize(f);
            if (g != null)
            {
                a.setAnimationType(g);
            }
            if (h)
            {
                a.disableHardwareAcceleration();
                return;
            }
        }
        if (true) goto _L2; else goto _L9
_L9:
        d();
          goto _L4
_L7:
        g();
        t.post(new b());
          goto _L4
        g();
        t.post(new c());
          goto _L4
    }

    static AtomicBoolean d(IMBanner imbanner)
    {
        return imbanner.i;
    }

    private void d()
    {
        a.setAdServerUrl(AnalyticsInitializer.getConfigParams().getEndPoints().getHouseUrl());
        a.setSlotId(e);
        Map map = MonetizationUtils.buildLtvpRequestMap(this);
        a.getIMAdRequest().setRequestParams(map);
        a.setAppId(InMobi.getAppId());
    }

    static int e(IMBanner imbanner)
    {
        return imbanner.r;
    }

    private void e()
    {
        if (a == null)
        {
            f();
        }
        if (q != null)
        {
            a.setAppId(q);
        }
    }

    private void f()
    {
        a = new BannerView(d, f, InMobi.getAppId(), -1L);
        MonetizationUtils.updateIMAdRequest(a.getIMAdRequest());
        c = new h();
        a.setIMAdListener(c);
        addView(a);
    }

    private void g()
    {
        if (a != null)
        {
            a.destroy();
            removeView(a);
            a = null;
            c = null;
        }
    }

    private void h()
    {
        t.removeMessages(100);
        if (r == -1)
        {
            return;
        }
        int i1 = Initializer.getConfigParams().getMinimumRefreshRate();
        if (r < i1)
        {
            t.sendEmptyMessageDelayed(100, i1 * 1000);
            return;
        } else
        {
            t.sendEmptyMessageDelayed(100, 1000 * r);
            return;
        }
    }

    public final void destroy()
    {
        if (a != null)
        {
            a.destroy();
        }
    }

    public final void disableHardwareAcceleration()
    {
        h = true;
    }

    public final void loadBanner()
    {
        a(true);
    }

    protected final void onWindowVisibilityChanged(int i1)
    {
        if (i1 == 0)
        {
            try
            {
                ThinICE.start(d);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Cannot start ice. Activity is null");
            }
            a(s);
            return;
        } else
        {
            a(-1);
            return;
        }
    }

    public final void setAdSize(int i1)
    {
        f = i1;
    }

    public final void setAnimationType(AnimationType animationtype)
    {
        g = animationtype;
    }

    public final void setAppId(String s1)
    {
        if (s1 == null || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "AppId cannot be null or blank.");
            return;
        }
        if (e != -1L)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "A new appId cannot be set if a slotId is already set.");
            return;
        } else
        {
            q = s1;
            return;
        }
    }

    public final void setIMBannerListener(IMBannerListener imbannerlistener)
    {
        k = imbannerlistener;
    }

    public final void setKeywords(String s1)
    {
        if (s1 == null || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Keywords cannot be null or blank.");
            return;
        } else
        {
            m = s1;
            return;
        }
    }

    public final void setRefTagParam(String s1, String s2)
    {
        if (s1 == null || "".equals(s1.trim()))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Ref tag key cannot be null or blank.");
            return;
        }
        if (s2 == null || "".equals(s2.trim()))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "RefTag value cannot be null or blank.");
            return;
        } else
        {
            n = s1;
            o = s2;
            return;
        }
    }

    public final void setRefreshInterval(int i1)
    {
        s = i1;
        a(i1);
    }

    public final void setRequestParams(Map map)
    {
        if (map == null || map.isEmpty())
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Request params cannot be null or empty.");
            return;
        } else
        {
            p = map;
            return;
        }
    }

    public final void setSlotId(long l1)
    {
        if (l1 == -1L)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Invalid slotId : -1");
        } else
        {
            if (e == -1L && q != null)
            {
                Log.debug("[InMobi]-[Network]-4.4.1", "A new slotId can be set only if a valid slotId is provided during object construction.");
                return;
            }
            e = l1;
            if (a != null)
            {
                a.setSlotId(e);
                return;
            }
        }
    }

    public final void stopLoading()
    {
        if (a != null)
        {
            a.stopLoading();
        }
    }


    private class a extends Handler
    {

        private final WeakReference a;

        public void handleMessage(Message message)
        {
            IMBanner imbanner = (IMBanner)a.get();
            if (imbanner != null)
            {
                switch (message.what)
                {
                default:
                    return;

                case 100: // 'd'
                    break;
                }
                if (IMBanner.e(imbanner) != -1)
                {
                    if (!imbanner.d.hasWindowFocus())
                    {
                        Log.debug("[InMobi]-[Network]-4.4.1", "Activity is not in the foreground. New ad will not be loaded.");
                        return;
                    }
                    if (MRAIDInterstitialController.isInterstitialDisplayed.get())
                    {
                        Log.debug("[InMobi]-[Network]-4.4.1", "Ad cannot be loaded.Interstitial Ad is displayed.");
                        return;
                    } else
                    {
                        IMBanner.a(imbanner, false);
                        return;
                    }
                }
            }
        }

        public a()
        {
            a = new WeakReference(IMBanner.this);
        }
    }


    private class d
        implements Runnable
    {

        final IMErrorCode a;
        final IMBanner b;

        public void run()
        {
            if (IMBanner.a(b) != null)
            {
                IMBanner.a(b).onBannerRequestFailed(b, a);
            }
        }

        d(IMErrorCode imerrorcode)
        {
            b = IMBanner.this;
            a = imerrorcode;
            super();
        }
    }


    private class e
        implements Runnable
    {

        final IMBanner a;

        public void run()
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "AppId Not Set - Please call setAppId on the IMBanner object with a valid appId. For XML, please add \"appId\" attribute to the XML. Please refer integration guideline for more details.");
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerRequestFailed(a, IMErrorCode.INVALID_REQUEST);
            }
            IMBanner.b(a);
        }

        e()
        {
            a = IMBanner.this;
            super();
        }
    }


    private class f
    {

        static final int a[];

        static 
        {
            a = new int[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.values().length];
            try
            {
                a[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.ACTIONS_ONLY.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.MEDIATION.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                a[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.NO_ADS.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3)
            {
                return;
            }
        }
    }


    private class g
        implements Runnable
    {

        final IMBanner a;

        public void run()
        {
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerRequestFailed(a, IMErrorCode.NO_FILL);
            }
        }

        g()
        {
            a = IMBanner.this;
            super();
        }
    }


    private class b
        implements Runnable
    {

        final IMBanner a;

        public void run()
        {
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerRequestFailed(a, IMErrorCode.DO_MONETIZE);
            }
        }

        b()
        {
            a = IMBanner.this;
            super();
        }
    }


    private class c
        implements Runnable
    {

        final IMBanner a;

        public void run()
        {
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerRequestFailed(a, IMErrorCode.DO_NOTHING);
            }
        }

        c()
        {
            a = IMBanner.this;
            super();
        }
    }


    private class h
        implements BannerViewListener
    {

        final IMBanner a;

        public void onAdRequestCompleted(BannerView bannerview)
        {
            IMBanner.d(a).set(false);
            IMBanner.b(a);
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerRequestSucceeded(a);
            }
        }

        public void onAdRequestFailed(BannerView bannerview, com.inmobi.androidsdk.AdRequest.ErrorCode errorcode)
        {
            if (a.b != com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION) goto _L2; else goto _L1
_L1:
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerRequestFailed(a, IMErrorCode.DO_MONETIZE);
            }
_L4:
            IMBanner.d(a).set(false);
            IMBanner.b(a);
            return;
_L2:
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerRequestFailed(a, MonetizationUtils.getErrorCode(errorcode));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onBannerInteraction(BannerView bannerview, Map map)
        {
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onBannerInteraction(a, map);
            }
        }

        public void onDismissAdScreen(BannerView bannerview)
        {
            IMBanner.c(a).set(false);
            IMBanner.b(a);
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onDismissBannerScreen(a);
            }
        }

        public void onLeaveApplication(BannerView bannerview)
        {
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onLeaveApplication(a);
            }
        }

        public void onShowAdScreen(BannerView bannerview)
        {
            IMBanner.c(a).set(true);
            if (IMBanner.a(a) != null)
            {
                IMBanner.a(a).onShowBannerScreen(a);
            }
        }

        h()
        {
            a = IMBanner.this;
            super();
        }
    }

}
