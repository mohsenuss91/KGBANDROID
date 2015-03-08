// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Ad;
import com.adsdk.sdk.AdListener;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

class this._cls0
    implements AdListener
{

    final RichMediaActivity this$0;

    public void adClicked()
    {
        RichMediaActivity.access$3(RichMediaActivity.this);
    }

    public void adClosed(Ad ad, boolean flag)
    {
    }

    public void adLoadSucceeded(Ad ad)
    {
    }

    public void adShown(Ad ad, boolean flag)
    {
    }

    public void noAdFound()
    {
    }

    ()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
