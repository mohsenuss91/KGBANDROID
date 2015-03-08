// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk:
//            InterstitialView, InterstitialViewListener

class e
    implements com.inmobi.re.container.IMWebView.IMWebViewListener
{

    final InterstitialView a;

    e(InterstitialView interstitialview)
    {
        a = interstitialview;
        super();
    }

    public void onDismissAdScreen()
    {
        InterstitialView.a(a, 103, null);
    }

    public void onError()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "Error loading the interstitial ad ");
        InterstitialView.b(a).sendEmptyMessage(310);
    }

    public void onExpand()
    {
    }

    public void onExpandClose()
    {
    }

    public void onIncentCompleted(Map map)
    {
        if (InterstitialView.a(a) != null)
        {
            InterstitialView.a(a).onIncentCompleted(a, map);
        }
    }

    public void onLeaveApplication()
    {
        InterstitialView.a(a, 104, null);
    }

    public void onResize(ResizeDimensions resizedimensions)
    {
    }

    public void onResizeClose()
    {
    }

    public void onShowAdScreen()
    {
        InterstitialView.a(a, 102, null);
    }

    public void onUserInteraction(Map map)
    {
        if (InterstitialView.a(a) != null)
        {
            InterstitialView.a(a).onInterstitialInteraction(a, map);
        }
    }
}
