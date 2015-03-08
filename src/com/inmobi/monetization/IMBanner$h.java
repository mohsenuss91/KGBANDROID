// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.androidsdk.BannerView;
import com.inmobi.androidsdk.BannerViewListener;
import com.inmobi.monetization.internal.MonetizationUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.inmobi.monetization:
//            IMBanner, IMBannerListener, IMErrorCode

class a
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

    public void onAdRequestFailed(BannerView bannerview, com.inmobi.androidsdk.rrorCode rrorcode)
    {
        if (a.b != com.inmobi.monetization.internal.cessor.ActionsRule.ACTIONS_TO_MEDIATION) goto _L2; else goto _L1
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
            IMBanner.a(a).onBannerRequestFailed(a, MonetizationUtils.getErrorCode(rrorcode));
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

    orCode(IMBanner imbanner)
    {
        a = imbanner;
        super();
    }
}
