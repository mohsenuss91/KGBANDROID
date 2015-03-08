// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.banner:
//            AdView

class val.e
    implements Runnable
{

    final AdView this$0;
    private final Throwable val$e;

    public void run()
    {
        Log.e("ADSDK", "Exception when building ad:", val$e);
        if (AdView.access$9(AdView.this) != null)
        {
            Log.d("ADSDK", (new StringBuilder("notify bannerListener: ")).append(AdView.access$9(AdView.this).getClass().getName()).toString());
            AdView.access$9(AdView.this).noAdFound();
        }
    }

    ()
    {
        this$0 = final_adview;
        val$e = Throwable.this;
        super();
    }
}
