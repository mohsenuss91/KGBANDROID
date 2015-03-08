// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.banner:
//            AdView

class this._cls0
    implements Runnable
{

    final AdView this$0;

    public void run()
    {
        Log.d("ADSDK", "No Ad");
        if (AdView.access$9(AdView.this) != null)
        {
            AdView.access$9(AdView.this).noAdFound();
        }
    }

    ()
    {
        this$0 = AdView.this;
        super();
    }
}
