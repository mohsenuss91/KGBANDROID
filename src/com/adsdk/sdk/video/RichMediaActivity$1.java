// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, WebFrame

class this._cls0
    implements ventListener
{

    final RichMediaActivity this$0;

    public void onTimeEvent(int i)
    {
        Log.d("ADSDK", (new StringBuilder("RichMediaActivity mOverlayShowListener show after:")).append(i).toString());
        if (RichMediaActivity.access$0(RichMediaActivity.this) != null)
        {
            RichMediaActivity.access$0(RichMediaActivity.this).setVisibility(0);
            RichMediaActivity.access$0(RichMediaActivity.this).requestLayout();
        }
    }

    ventListener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
