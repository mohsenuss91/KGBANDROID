// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk:
//            BannerView

public interface BannerViewListener
{

    public abstract void onAdRequestCompleted(BannerView bannerview);

    public abstract void onAdRequestFailed(BannerView bannerview, AdRequest.ErrorCode errorcode);

    public abstract void onBannerInteraction(BannerView bannerview, Map map);

    public abstract void onDismissAdScreen(BannerView bannerview);

    public abstract void onLeaveApplication(BannerView bannerview);

    public abstract void onShowAdScreen(BannerView bannerview);
}
