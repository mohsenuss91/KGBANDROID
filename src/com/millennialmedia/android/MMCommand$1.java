// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.reflect.Method;

// Referenced classes of package com.millennialmedia.android:
//            MMCommand, MMWebView

class val.call
    implements Runnable
{

    final MMCommand this$0;
    final String val$call;
    final MMWebView val$webViewCallback;

    public void run()
    {
        if (MMCommand.access$000(MMCommand.this).getName().equals("expandWithProperties"))
        {
            val$webViewCallback.isExpanding = true;
        }
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
