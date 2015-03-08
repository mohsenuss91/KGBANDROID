// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.banner:
//            AdView

class this._cls0
    implements caughtExceptionHandler
{

    final AdView this$0;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Log.e("ADSDK", "Exception in request thread", throwable);
        AdView.access$8(AdView.this, null);
    }

    tionHandler()
    {
        this$0 = AdView.this;
        super();
    }
}
