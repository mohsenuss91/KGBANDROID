// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.app.Activity;
import android.os.Handler;
import com.inmobi.androidsdk.AdRequest;
import com.inmobi.androidsdk.InterstitialView;
import com.inmobi.androidsdk.Mode;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.monetization.internal.LtvpRuleProcessor;
import com.inmobi.monetization.internal.MonetizationUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization:
//            IMErrorCode, IMInterstitialListener, IMIncentivisedListener

public class IMInterstitial
{

    private static com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule g = null;
    InterstitialView a;
    com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule b;
    AdMode c;
    boolean d;
    private IMInterstitialListener e;
    private IMIncentivisedListener f;
    private long h;
    private Activity i;
    private AtomicBoolean j;
    private State k;
    private Handler l;
    private String m;
    private String n;
    private Map o;

    public IMInterstitial(Activity activity, long l1)
    {
        b = com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.MEDIATION;
        h = -1L;
        j = new AtomicBoolean(false);
        k = State.INIT;
        l = new Handler();
        m = null;
        n = null;
        o = null;
        c = AdMode.AD_NETWORK;
        d = false;
        h = l1;
        a(activity);
    }

    public IMInterstitial(Activity activity, String s)
    {
        b = com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.MEDIATION;
        h = -1L;
        j = new AtomicBoolean(false);
        k = State.INIT;
        l = new Handler();
        m = null;
        n = null;
        o = null;
        c = AdMode.AD_NETWORK;
        d = false;
        a(activity);
        m = s;
    }

    static State a(IMInterstitial iminterstitial, State state)
    {
        iminterstitial.k = state;
        return state;
    }

    static IMInterstitialListener a(IMInterstitial iminterstitial)
    {
        return iminterstitial.e;
    }

    private com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule a()
    {
        return LtvpRuleProcessor.getInstance().getLtvpRuleConfig(h);
    }

    private void a(long l1)
    {
        a = new InterstitialView(i, InMobi.getAppId(), l1);
        a.setIMAdInterstitialListener(new e());
    }

    private void a(Activity activity)
    {
        i = activity;
        if (InternalSDKUtil.isInitializedSuccessfully())
        {
            try
            {
                ThinICE.start(i);
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[Network]-4.4.1", "Cannot start ice. Activity is null");
            }
            if (h != -1L)
            {
                a();
                return;
            }
        }
    }

    static AtomicBoolean b(IMInterstitial iminterstitial)
    {
        return iminterstitial.j;
    }

    private void b()
    {
_L2:
        return;
        if (!InternalSDKUtil.isInitializedSuccessfully(false) || j.get() || getState() != State.READY && getState() != State.INIT) goto _L2; else goto _L1
_L1:
        d();
        if (h == -1L) goto _L4; else goto _L3
_L3:
        b = a();
        if (g != null)
        {
            b = g;
        }
        a.a[b.ordinal()];
        JVM INSTR tableswitch 1 4: default 116
    //                   1 232
    //                   2 232
    //                   3 239
    //                   4 262;
           goto _L5 _L6 _L6 _L7 _L8
_L5:
        e();
        l.post(new b());
_L4:
        if (a != null)
        {
            MonetizationUtils.updateIMAdRequest(a.getIMAdRequest());
            if (o != null)
            {
                a.getIMAdRequest().setRequestParams(o);
            }
            if (n != null)
            {
                a.getIMAdRequest().setKeywords(n);
            }
            Mode mode;
            if (c == AdMode.AD_NETWORK)
            {
                mode = Mode.AD_NETWORK;
            } else
            {
                mode = Mode.APP_GALLERY;
            }
            a.setMode(mode);
            if (d)
            {
                a.disableHardwareAcceleration();
                return;
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
        c();
          goto _L4
_L7:
        e();
        l.post(new d());
          goto _L4
_L8:
        e();
        l.post(new c());
          goto _L4
    }

    static IMIncentivisedListener c(IMInterstitial iminterstitial)
    {
        return iminterstitial.f;
    }

    private void c()
    {
        d();
        a.setAdServerUrl(AnalyticsInitializer.getConfigParams().getEndPoints().getHouseUrl());
        a.setSlotId(h);
        Map map = MonetizationUtils.buildLtvpRequestMap(null);
        a.getIMAdRequest().setRequestParams(map);
        a.setAppId(InMobi.getAppId());
    }

    private void d()
    {
        if (a == null)
        {
            a(h);
        }
        if (m != null)
        {
            a.setAppId(m);
        }
    }

    private void e()
    {
        if (a != null)
        {
            a.setIMAdInterstitialListener(null);
            a = null;
        }
    }

    public void destroy()
    {
        if (a != null)
        {
            a.destroy();
        }
    }

    public void disableHardwareAcceleration()
    {
        d = true;
    }

    public State getState()
    {
        return k;
    }

    public void loadInterstitial()
    {
        if (!InternalSDKUtil.isInitializedSuccessfully())
        {
            return;
        }
        b();
        if (j.get() || getState() != State.READY && getState() != State.INIT)
        {
            IMErrorCode imerrorcode = IMErrorCode.INVALID_REQUEST;
            String s;
            if (j.get())
            {
                s = "Interstitial load is already in progress.";
            } else
            {
                s = "Interstitial can only be loaded in init or ready state.";
            }
            imerrorcode.setMessage(s);
            l.post(new g(imerrorcode));
            Log.verbose("[InMobi]-[Monetization]", s);
            return;
        }
        j.set(true);
        k = State.LOADING;
        Log.debug("[InMobi]-[Monetization]", "loading");
        if (a != null)
        {
            if (m != null || h != -1L)
            {
                a.loadNewAd();
                return;
            } else
            {
                j.set(false);
                k = State.INIT;
                l.post(new f());
                return;
            }
        } else
        {
            j.set(false);
            return;
        }
    }

    public void setAppId(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "AppId cannot be null or blank.");
            return;
        }
        if (h != -1L)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "A new appId cannot be set if a slotId is already set.");
            return;
        } else
        {
            m = s;
            return;
        }
    }

    public void setIMIncentivisedListener(IMIncentivisedListener imincentivisedlistener)
    {
        f = imincentivisedlistener;
    }

    public void setIMInterstitialListener(IMInterstitialListener iminterstitiallistener)
    {
        e = iminterstitiallistener;
    }

    public void setKeywords(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Keywords cannot be null or blank.");
            return;
        } else
        {
            n = s;
            return;
        }
    }

    public void setMode(AdMode admode)
    {
        if (admode != null)
        {
            c = admode;
            return;
        } else
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "AdMode cannot be null.");
            return;
        }
    }

    public void setRequestParams(Map map)
    {
        if (map == null || map.isEmpty())
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Request params cannot be null or empty.");
            return;
        } else
        {
            o = map;
            return;
        }
    }

    public void setSlotId(long l1)
    {
        if (l1 == -1L)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Invalid slotId : -1");
        } else
        {
            if (h == -1L && m != null)
            {
                Log.debug("[InMobi]-[Network]-4.4.1", "A new slotId can be set only if a valid slotId is provided during object construction.");
                return;
            }
            h = l1;
            if (a != null)
            {
                a.setSlotId(h);
                return;
            }
        }
    }

    public void show()
    {
        if (a != null)
        {
            a.show();
        }
        try
        {
            ThinICE.start(i);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Cannot start ice. Activity is null");
        }
    }

    public void show(long l1)
    {
        if (a != null)
        {
            a.show(l1);
        }
        try
        {
            ThinICE.start(i);
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Network]-4.4.1", "Cannot start ice. Activity is null");
        }
    }

    public void stopLoading()
    {
        if (a != null)
        {
            a.stopLoading();
        }
    }


    private class State extends Enum
    {

        public static final State ACTIVE;
        public static final State INIT;
        public static final State LOADING;
        public static final State READY;
        public static final State UNKNOWN;
        private static final State a[];

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/inmobi/monetization/IMInterstitial$State, s);
        }

        public static State[] values()
        {
            return (State[])a.clone();
        }

        static 
        {
            INIT = new State("INIT", 0);
            ACTIVE = new State("ACTIVE", 1);
            LOADING = new State("LOADING", 2);
            READY = new State("READY", 3);
            UNKNOWN = new State("UNKNOWN", 4);
            State astate[] = new State[5];
            astate[0] = INIT;
            astate[1] = ACTIVE;
            astate[2] = LOADING;
            astate[3] = READY;
            astate[4] = UNKNOWN;
            a = astate;
        }

        private State(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class AdMode extends Enum
    {

        public static final AdMode AD_NETWORK;
        public static final AdMode APP_GALLERY;
        private static final AdMode a[];

        public static AdMode valueOf(String s)
        {
            return (AdMode)Enum.valueOf(com/inmobi/monetization/IMInterstitial$AdMode, s);
        }

        public static AdMode[] values()
        {
            return (AdMode[])a.clone();
        }

        static 
        {
            AD_NETWORK = new AdMode("AD_NETWORK", 0);
            APP_GALLERY = new AdMode("APP_GALLERY", 1);
            AdMode aadmode[] = new AdMode[2];
            aadmode[0] = AD_NETWORK;
            aadmode[1] = APP_GALLERY;
            a = aadmode;
        }

        private AdMode(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class e
        implements InterstitialViewListener
    {

        final IMInterstitial a;

        public void onAdRequestFailed(InterstitialView interstitialview, com.inmobi.androidsdk.AdRequest.ErrorCode errorcode)
        {
            if (a.b != com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION) goto _L2; else goto _L1
_L1:
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialFailed(a, IMErrorCode.DO_MONETIZE);
            }
_L4:
            IMInterstitial.b(a).set(false);
            IMInterstitial.a(a, State.INIT);
            return;
_L2:
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialFailed(a, MonetizationUtils.getErrorCode(errorcode));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public void onAdRequestLoaded(InterstitialView interstitialview)
        {
            IMInterstitial.a(a, State.READY);
            IMInterstitial.b(a).set(false);
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialLoaded(a);
            }
        }

        public void onDismissAdScreen(InterstitialView interstitialview)
        {
            IMInterstitial.a(a, State.INIT);
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onDismissInterstitialScreen(a);
            }
        }

        public void onIncentCompleted(InterstitialView interstitialview, Map map)
        {
            if (IMInterstitial.c(a) != null)
            {
                IMInterstitial.c(a).onIncentCompleted(a, map);
            }
        }

        public void onInterstitialInteraction(InterstitialView interstitialview, Map map)
        {
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialInteraction(a, map);
            }
        }

        public void onLeaveApplication(InterstitialView interstitialview)
        {
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onLeaveApplication(a);
            }
        }

        public void onShowAdScreen(InterstitialView interstitialview)
        {
            IMInterstitial.a(a, State.ACTIVE);
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onShowInterstitialScreen(a);
            }
        }

        e()
        {
            a = IMInterstitial.this;
            super();
        }
    }


    private class a
    {

        static final int a[];

        static 
        {
            a = new int[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.values().length];
            try
            {
                a[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.ACTIONS_TO_MEDIATION.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                a[com.inmobi.monetization.internal.LtvpRuleProcessor.ActionsRule.ACTIONS_ONLY.ordinal()] = 2;
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


    private class b
        implements Runnable
    {

        final IMInterstitial a;

        public void run()
        {
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialFailed(a, IMErrorCode.NO_FILL);
            }
        }

        b()
        {
            a = IMInterstitial.this;
            super();
        }
    }


    private class d
        implements Runnable
    {

        final IMInterstitial a;

        public void run()
        {
            IMInterstitial.b(a).set(false);
            IMInterstitial.a(a, State.INIT);
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialFailed(a, IMErrorCode.DO_MONETIZE);
            }
        }

        d()
        {
            a = IMInterstitial.this;
            super();
        }
    }


    private class c
        implements Runnable
    {

        final IMInterstitial a;

        public void run()
        {
            IMInterstitial.b(a).set(false);
            IMInterstitial.a(a, State.INIT);
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialFailed(a, IMErrorCode.DO_NOTHING);
            }
        }

        c()
        {
            a = IMInterstitial.this;
            super();
        }
    }


    private class g
        implements Runnable
    {

        final IMErrorCode a;
        final IMInterstitial b;

        public void run()
        {
            if (IMInterstitial.a(b) != null)
            {
                IMInterstitial.a(b).onInterstitialFailed(b, a);
            }
        }

        g(IMErrorCode imerrorcode)
        {
            b = IMInterstitial.this;
            a = imerrorcode;
            super();
        }
    }


    private class f
        implements Runnable
    {

        final IMInterstitial a;

        public void run()
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "AppId cannot be set to null");
            if (IMInterstitial.a(a) != null)
            {
                IMInterstitial.a(a).onInterstitialFailed(a, IMErrorCode.INVALID_REQUEST);
            }
        }

        f()
        {
            a = IMInterstitial.this;
            super();
        }
    }

}
