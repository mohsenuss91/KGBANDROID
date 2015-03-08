// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.widget.Toast;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidDisplayController

class val.message
    implements Runnable
{

    final MraidDisplayController this$0;
    private final String val$message;

    public void run()
    {
        Toast.makeText(MraidDisplayController.access$5(MraidDisplayController.this), val$message, 0).show();
    }

    ()
    {
        this$0 = final_mraiddisplaycontroller;
        val$message = String.this;
        super();
    }
}
