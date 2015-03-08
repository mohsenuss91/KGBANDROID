// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.androidsdk.InterstitialView;
import com.inmobi.androidsdk.InterstitialViewListener;
import com.inmobi.monetization.internal.MonetizationUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial, IMErrorCode, IMInterstitialListener, IMIncentivisedListener

class a
    implements InterstitialViewListener
{

    final IMInterstitial a;

    public void onAdRequestFailed(InterstitialView interstitialview, com.inmobi.androidsdk.de de)
    {
        if (a.b != com.inmobi.monetization.internal..ActionsRule.ACTIONS_TO_MEDIATION) goto _L2; else goto _L1
_L1:
        if (IMInterstitial.a(a) != null)
        {
            IMInterstitial.a(a).onInterstitialFailed(a, IMErrorCode.DO_MONETIZE);
        }
_L4:
        IMInterstitial.b(a).set(false);
        IMInterstitial.a(a, ate.INIT);
        return;
_L2:
        if (IMInterstitial.a(a) != null)
        {
            IMInterstitial.a(a).onInterstitialFailed(a, MonetizationUtils.getErrorCode(de));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onAdRequestLoaded(InterstitialView interstitialview)
    {
        IMInterstitial.a(a, ate.READY);
        IMInterstitial.b(a).set(false);
        if (IMInterstitial.a(a) != null)
        {
            IMInterstitial.a(a).onInterstitialLoaded(a);
        }
    }

    public void onDismissAdScreen(InterstitialView interstitialview)
    {
        IMInterstitial.a(a, ate.INIT);
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
        IMInterstitial.a(a, ate.ACTIVE);
        if (IMInterstitial.a(a) != null)
        {
            IMInterstitial.a(a).onShowInterstitialScreen(a);
        }
    }

    (IMInterstitial iminterstitial)
    {
        a = iminterstitial;
        super();
    }
}
