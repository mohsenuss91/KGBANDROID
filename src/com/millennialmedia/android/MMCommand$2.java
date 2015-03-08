// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMWebView, MMCommand

class val.call
    implements Runnable
{

    final MMCommand this$0;
    final String val$call;
    final MMWebView val$webViewCallback;

    public void run()
    {
        val$webViewCallback.loadUrl(val$call);
    }

    ()
    {
        this$0 = final_mmcommand;
        val$webViewCallback = mmwebview;
        val$call = String.this;
        super();
    }
}
