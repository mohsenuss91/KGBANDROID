// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import com.adsdk.sdk.AdListener;
import com.adsdk.sdk.mraid.MraidView;

// Referenced classes of package com.adsdk.sdk.banner:
//            AdView

class val.listener
    implements com.adsdk.sdk.mraid..MraidListener
{

    final AdView this$0;
    private final AdListener val$listener;

    public void onClose(MraidView mraidview, com.adsdk.sdk.mraid..ViewState viewstate)
    {
        if (val$listener != null)
        {
            val$listener.adClosed(null, true);
        }
    }

    public void onExpand(MraidView mraidview)
    {
        if (val$listener != null)
        {
            val$listener.adClicked();
            val$listener.adShown(null, true);
        }
    }

    public void onFailure(MraidView mraidview)
    {
        if (val$listener != null)
        {
            val$listener.noAdFound();
        }
    }

    public void onReady(MraidView mraidview)
    {
        if (val$listener != null)
        {
            val$listener.adLoadSucceeded(null);
        }
    }

    ViewState()
    {
        this$0 = final_adview;
        val$listener = AdListener.this;
        super();
    }
}
