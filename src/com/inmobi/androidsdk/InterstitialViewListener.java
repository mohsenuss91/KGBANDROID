// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk:
//            InterstitialView

public interface InterstitialViewListener
{

    public abstract void onAdRequestFailed(InterstitialView interstitialview, AdRequest.ErrorCode errorcode);

    public abstract void onAdRequestLoaded(InterstitialView interstitialview);

    public abstract void onDismissAdScreen(InterstitialView interstitialview);

    public abstract void onIncentCompleted(InterstitialView interstitialview, Map map);

    public abstract void onInterstitialInteraction(InterstitialView interstitialview, Map map);

    public abstract void onLeaveApplication(InterstitialView interstitialview);

    public abstract void onShowAdScreen(InterstitialView interstitialview);
}
