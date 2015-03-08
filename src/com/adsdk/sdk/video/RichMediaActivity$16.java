// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.view.View;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

class this._cls0
    implements android.view.ity._cls16
{

    final RichMediaActivity this$0;

    public void onClick(View view)
    {
        Log.v("###########TRACKING SKIP INTERSTITIAL");
        RichMediaActivity.access$10(RichMediaActivity.this, true);
        setResult(-1);
        finish();
    }

    ()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
