// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.androidsdk:
//            InterstitialView, InterstitialViewListener

class b
    implements Runnable
{

    final int a;
    final  b;
    final InterstitialView c;

    public void run()
    {
        a;
        JVM INSTR tableswitch 100 104: default 40
    //                   100 53
    //                   101 70
    //                   102 174
    //                   103 157
    //                   104 191;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        Log.debug("[InMobi]-[Network]-4.4.1", b.toString());
        return;
_L2:
        InterstitialView.a(c).onAdRequestLoaded(c);
        return;
_L3:
        a[b.ordinal()];
        JVM INSTR tableswitch 1 2: default 104
    //                   1 137
    //                   2 147;
           goto _L7 _L8 _L9
_L7:
        Log.debug("[InMobi]-[Network]-4.4.1", b.toString());
_L10:
        InterstitialView.a(c).onAdRequestFailed(c, b);
        return;
_L8:
        Log.debug("[InMobi]-[Network]-4.4.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
          goto _L10
_L9:
        Log.debug("[InMobi]-[Network]-4.4.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
          goto _L10
_L5:
        InterstitialView.a(c).onDismissAdScreen(c);
        return;
_L4:
        InterstitialView.a(c).onShowAdScreen(c);
        return;
_L6:
        InterstitialView.a(c).onLeaveApplication(c);
        return;
    }

    (InterstitialView interstitialview, int i,  )
    {
        c = interstitialview;
        a = i;
        b = ;
        super();
    }
}
