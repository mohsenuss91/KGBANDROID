// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            MMAdView

class tListener extends tListener
{

    final imateTransition this$1;
    final MMAdView val$this$0;

    public void onPageFinished(String s)
    {
        super.onPageFinished(s);
        if (TransitionAnimated())
        {
            imateTransition();
        }
    }

    tListener()
    {
        this$1 = final_tlistener;
        val$this$0 = MMAdView.this;
        super(final_tlistener);
    }
}
