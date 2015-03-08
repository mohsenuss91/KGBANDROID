// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMBanner, IMErrorCode

public interface IMBannerListener
{

    public abstract void onBannerInteraction(IMBanner imbanner, Map map);

    public abstract void onBannerRequestFailed(IMBanner imbanner, IMErrorCode imerrorcode);

    public abstract void onBannerRequestSucceeded(IMBanner imbanner);

    public abstract void onDismissBannerScreen(IMBanner imbanner);

    public abstract void onLeaveApplication(IMBanner imbanner);

    public abstract void onShowBannerScreen(IMBanner imbanner);
}
