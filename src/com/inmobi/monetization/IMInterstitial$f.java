// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.monetization:
//            IMInterstitial, IMErrorCode, IMInterstitialListener

class a
    implements Runnable
{

    final IMInterstitial a;

    public void run()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "AppId cannot be set to null");
        if (IMInterstitial.a(a) != null)
        {
            IMInterstitial.a(a).onInterstitialFailed(a, IMErrorCode.INVALID_REQUEST);
        }
    }

    tener(IMInterstitial iminterstitial)
    {
        a = iminterstitial;
        super();
    }
}
