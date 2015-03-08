// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.androidsdk:
//            BannerView, BannerViewListener

class b
    implements Runnable
{

    final int a;
    final orCode b;
    final BannerView c;

    public void run()
    {
        a;
        JVM INSTR tableswitch 100 106: default 48
    //                   100 61
    //                   101 88
    //                   102 218
    //                   103 201
    //                   104 235
    //                   105 252
    //                   106 269;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        Log.debug("[InMobi]-[Network]-4.4.1", b.toString());
        return;
_L2:
        try
        {
            BannerView.a(c).onAdRequestCompleted(c);
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[Network]-4.4.1", "Exception giving callback to the publisher ", exception);
        }
        return;
_L3:
        a[b.ordinal()];
        JVM INSTR tableswitch 1 4: default 128
    //                   1 161
    //                   2 171
    //                   3 181
    //                   4 191;
           goto _L9 _L10 _L11 _L12 _L13
_L9:
        Log.debug("[InMobi]-[Network]-4.4.1", b.toString());
_L14:
        BannerView.a(c).onAdRequestFailed(c, b);
        return;
_L10:
        Log.debug("[InMobi]-[Network]-4.4.1", "Ad click in progress. Your request cannot be processed at this time. Try again later.");
          goto _L14
_L11:
        Log.debug("[InMobi]-[Network]-4.4.1", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
          goto _L14
_L12:
        Log.debug("[InMobi]-[Network]-4.4.1", "Ad request successful, but no ad was returned due to lack of ad inventory.");
          goto _L14
_L13:
        Log.debug("[InMobi]-[Network]-4.4.1", "Your App Id may be invalid or inactive. Please verify the app ID");
          goto _L14
_L5:
        BannerView.a(c).onDismissAdScreen(c);
        return;
_L4:
        BannerView.a(c).onShowAdScreen(c);
        return;
_L6:
        BannerView.a(c).onLeaveApplication(c);
        return;
_L7:
        BannerView.a(c).onShowAdScreen(c);
        return;
_L8:
        BannerView.a(c).onDismissAdScreen(c);
        return;
    }

    orCode(BannerView bannerview, int i, orCode orcode)
    {
        c = bannerview;
        a = i;
        b = orcode;
        super();
    }
}
