// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMAdView, DTOResizeParameters

class ameters
    implements Runnable
{

    final MMWebView this$0;
    final MMAdView val$adView;
    final DTOResizeParameters val$resizeParams;

    private void handleMraidResize(DTOResizeParameters dtoresizeparameters)
    {
        MMAdView mmadview = val$adView;
        mmadview.getClass();
        nerBounds nerbounds = new nerBounds(mmadview, dtoresizeparameters);
        setUnresizeParameters();
        nerbounds.modifyLayoutParams(getLayoutParams());
    }

    private void setUnresizeParameters()
    {
        if (MMWebView.access$200(MMWebView.this))
        {
            android.view.youtParams youtparams = getLayoutParams();
            oldWidth = youtparams.width;
            oldHeight = youtparams.height;
            if (oldWidth <= 0)
            {
                oldWidth = getWidth();
            }
            if (oldHeight <= 0)
            {
                oldHeight = getHeight();
            }
        }
    }

    public void run()
    {
        synchronized (MMWebView.this)
        {
            val$adView.handleMraidResize(val$resizeParams);
            handleMraidResize(val$resizeParams);
            loadUrl("javascript:MMJS.sdk.setState('resized');");
            mraidState = "resized";
        }
    }

    ameters()
    {
        this$0 = final_mmwebview;
        val$adView = mmadview;
        val$resizeParams = DTOResizeParameters.this;
        super();
    }
}
