// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal.abstraction;

import com.inmobi.monetization.internal.GetLtvpRulesRequest;
import com.inmobi.monetization.internal.NativeAdRequest;

// Referenced classes of package com.inmobi.monetization.internal.abstraction:
//            IGetLtvpRuleRequestListener, INativeAdController

public interface IServiceProvider
{

    public abstract void getLtvpRule(GetLtvpRulesRequest getltvprulesrequest, IGetLtvpRuleRequestListener igetltvprulerequestlistener);

    public abstract void getNativeAd(NativeAdRequest nativeadrequest, INativeAdController inativeadcontroller);
}
