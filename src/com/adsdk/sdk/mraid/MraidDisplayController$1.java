// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.os.Handler;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidDisplayController, MraidViewableProperty, MraidView

class this._cls0
    implements Runnable
{

    final MraidDisplayController this$0;

    public void run()
    {
        boolean flag = checkViewable();
        if (MraidDisplayController.access$0(MraidDisplayController.this) != flag)
        {
            MraidDisplayController.access$1(MraidDisplayController.this, flag);
            getMraidView().fireChangeEventForProperty(MraidViewableProperty.createWithViewable(MraidDisplayController.access$0(MraidDisplayController.this)));
        }
        MraidDisplayController.access$2(MraidDisplayController.this).postDelayed(this, 3000L);
    }

    ()
    {
        this$0 = MraidDisplayController.this;
        super();
    }
}
