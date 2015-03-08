// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;

import com.inmobi.monetization.internal.abstraction.IGetLtvpRuleRequestListener;
import com.inmobi.monetization.internal.abstraction.INativeAdController;
import com.inmobi.monetization.internal.abstraction.IServiceProvider;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.inmobi.monetization.internal:
//            GetLtvpRuleRequestTask, NativeAdRequestTask, GetLtvpRulesRequest, NativeAdRequest

public class ServiceProvider
    implements IServiceProvider
{

    private static ServiceProvider a;
    private ExecutorService b;

    private ServiceProvider()
    {
        b = Executors.newFixedThreadPool(15);
    }

    public static ServiceProvider getInstance()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/inmobi/monetization/internal/ServiceProvider;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new ServiceProvider();
        }
        com/inmobi/monetization/internal/ServiceProvider;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        throw exception;
    }

    public void getLtvpRule(GetLtvpRulesRequest getltvprulesrequest, IGetLtvpRuleRequestListener igetltvprulerequestlistener)
    {
        b.execute(new GetLtvpRuleRequestTask(getltvprulesrequest, igetltvprulerequestlistener));
    }

    public void getNativeAd(NativeAdRequest nativeadrequest, INativeAdController inativeadcontroller)
    {
        b.execute(new NativeAdRequestTask(nativeadrequest, inativeadcontroller));
    }
}
