// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial, IMErrorCode

public interface IMInterstitialListener
{

    public abstract void onDismissInterstitialScreen(IMInterstitial iminterstitial);

    public abstract void onInterstitialFailed(IMInterstitial iminterstitial, IMErrorCode imerrorcode);

    public abstract void onInterstitialInteraction(IMInterstitial iminterstitial, Map map);

    public abstract void onInterstitialLoaded(IMInterstitial iminterstitial);

    public abstract void onLeaveApplication(IMInterstitial iminterstitial);

    public abstract void onShowInterstitialScreen(IMInterstitial iminterstitial);
}
