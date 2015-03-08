// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial, IMErrorCode, IMInterstitialListener

class a
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

    tener(IMInterstitial iminterstitial)
    {
        a = iminterstitial;
        super();
    }
}
