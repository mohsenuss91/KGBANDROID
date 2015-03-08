// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMSDK, MMWebView, MMAdView

class val.adView
    implements Runnable
{

    final MMWebView this$0;
    final MMAdView val$adView;

    void handleUnresize()
    {
        if (MMSDK.hasSetTranslationMethod() && !MMWebView.access$200(MMWebView.this))
        {
            android.view.youtParams youtparams = getLayoutParams();
            youtparams.width = oldWidth;
            youtparams.height = oldHeight;
            oldWidth = -50;
            oldHeight = -50;
            requestLayout();
        }
    }

    public void run()
    {
        synchronized (MMWebView.this)
        {
            val$adView.handleUnresize();
            handleUnresize();
            loadUrl("javascript:MMJS.sdk.setState('default');");
            mraidState = "default";
            invalidate();
        }
    }

    ()
    {
        this$0 = final_mmwebview;
        val$adView = MMAdView.this;
        super();
    }
}
