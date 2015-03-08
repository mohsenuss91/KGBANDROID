// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import java.util.TimerTask;

// Referenced classes of package com.adsdk.sdk.banner:
//            AdView

class ReloadTask extends TimerTask
{

    private final AdView mWebView;

    public ReloadTask(AdView adview)
    {
        mWebView = adview;
    }

    public void run()
    {
        mWebView.loadNextAd();
    }
}
