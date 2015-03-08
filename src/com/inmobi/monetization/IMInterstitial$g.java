// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial, IMInterstitialListener, IMErrorCode

class a
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

    tener(IMInterstitial iminterstitial, IMErrorCode imerrorcode)
    {
        b = iminterstitial;
        a = imerrorcode;
        super();
    }
}
