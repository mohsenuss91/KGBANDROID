// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, MMAdImplController, MMWebView

class r extends r
{

    final MMAdImpl this$0;

    public void onPageFinished(String s)
    {
        setClickable(true);
        if (controller == null || controller.webView == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        MMWebView mmwebview = controller.webView;
        mmwebview;
        JVM INSTR monitorenter ;
        if (!controller.webView.hasWindowFocus())
        {
            break MISSING_BLOCK_LABEL_76;
        }
        controller.webView.setMraidViewableVisible();
_L2:
        return;
        controller.webView.setMraidViewableHidden();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    void onPageStarted(String s)
    {
        setClickable(false);
    }

    r()
    {
        this$0 = MMAdImpl.this;
        super();
    }
}
