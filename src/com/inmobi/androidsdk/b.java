// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.mraidimpl.ResizeDimensions;
import java.util.Map;

// Referenced classes of package com.inmobi.androidsdk:
//            BannerView, BannerViewListener

class b
    implements com.inmobi.re.container.IMWebView.IMWebViewListener
{

    final BannerView a;

    b(BannerView bannerview)
    {
        a = bannerview;
        super();
    }

    public void onDismissAdScreen()
    {
        BannerView.a(a, 103, null);
    }

    public void onError()
    {
        Log.debug("[InMobi]-[Network]-4.4.1", "Error loading ad ");
        BannerView.p(a).sendEmptyMessage(111);
    }

    public void onExpand()
    {
        BannerView.a(a, 102, null);
    }

    public void onExpandClose()
    {
        BannerView.a(a, 103, null);
    }

    public void onIncentCompleted(Map map)
    {
    }

    public void onLeaveApplication()
    {
        BannerView.a(a, 104, null);
    }

    public void onResize(ResizeDimensions resizedimensions)
    {
        BannerView.a(a, 105, null);
    }

    public void onResizeClose()
    {
        BannerView.a(a, 106, null);
    }

    public void onShowAdScreen()
    {
        BannerView.a(a, 102, null);
    }

    public void onUserInteraction(Map map)
    {
        BannerView.a(a).onBannerInteraction(a, map);
    }
}
