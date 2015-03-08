// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            AdViewOverlayView, MMAdImpl, OverlaySettings, BannerExpandedWebViewClient, 
//            InterstitialWebViewClient, MMWebViewClient

class _cls1 extends _cls1
{

    final AdViewOverlayView this$0;

    MMWebViewClient getMMWebViewClient()
    {
        it>((new StringBuilder("Returning a client for user: OverlayWebViewClient, adimpl=")).append(adImpl).toString());
        class OverlayRedirectionListenerImpl extends MMAdImpl.MMAdImplRedirectionListenerImpl
        {

            final AdViewOverlayView.AdViewOverlayViewMMAdImpl this$1;

            public boolean isExpandingToUrl()
            {
                return settings.hasExpandUrl() && !settings.hasLoadedExpandUrl();
            }

            OverlayRedirectionListenerImpl()
            {
                this$1 = AdViewOverlayView.AdViewOverlayViewMMAdImpl.this;
                super(AdViewOverlayView.AdViewOverlayViewMMAdImpl.this);
            }
        }

        if (adImpl.linkForExpansionId != 0L || settings.hasExpandUrl())
        {
            BannerExpandedWebViewClient bannerexpandedwebviewclient = new BannerExpandedWebViewClient(mmWebViewClientListener, new OverlayRedirectionListenerImpl());
            mmWebViewClient = bannerexpandedwebviewclient;
            return bannerexpandedwebviewclient;
        } else
        {
            InterstitialWebViewClient interstitialwebviewclient = new InterstitialWebViewClient(mmWebViewClientListener, new OverlayRedirectionListenerImpl());
            mmWebViewClient = interstitialwebviewclient;
            return interstitialwebviewclient;
        }
    }

    public (Context context)
    {
        this.this$0 = AdViewOverlayView.this;
        super(AdViewOverlayView.this, context);
        class _cls1 extends MMAdImpl.BasicMMWebViewClientListener
        {

            final AdViewOverlayView.AdViewOverlayViewMMAdImpl this$1;
            final AdViewOverlayView val$this$0;

            public void onPageFinished(String s)
            {
                super.onPageFinished(s);
                AdViewOverlayView.access$200(AdViewOverlayView.AdViewOverlayViewMMAdImpl.this.this$0);
            }

            _cls1()
            {
                this$1 = AdViewOverlayView.AdViewOverlayViewMMAdImpl.this;
                this$0 = adviewoverlayview;
                super(AdViewOverlayView.AdViewOverlayViewMMAdImpl.this);
            }
        }

        mmWebViewClientListener = new _cls1();
    }
}
