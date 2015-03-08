// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobfox.adapter;

import com.adsdk.sdk.Ad;
import com.adsdk.sdk.AdListener;
import com.google.ads.b;
import com.google.ads.mediation.d;

// Referenced classes of package com.mobfox.adapter:
//            MobFoxAdapter

class this._cls0
    implements AdListener
{

    final MobFoxAdapter this$0;

    public void adClicked()
    {
        if (MobFoxAdapter.access$2(MobFoxAdapter.this) != null)
        {
            MobFoxAdapter.access$2(MobFoxAdapter.this).onClick(MobFoxAdapter.this);
        }
    }

    public void adClosed(Ad ad, boolean flag)
    {
        if (MobFoxAdapter.access$2(MobFoxAdapter.this) != null)
        {
            MobFoxAdapter.access$2(MobFoxAdapter.this).onDismissScreen(MobFoxAdapter.this);
        }
    }

    public void adLoadSucceeded(Ad ad)
    {
        if (MobFoxAdapter.access$2(MobFoxAdapter.this) != null)
        {
            MobFoxAdapter.access$2(MobFoxAdapter.this).onReceivedAd(MobFoxAdapter.this);
        }
    }

    public void adShown(Ad ad, boolean flag)
    {
        if (MobFoxAdapter.access$2(MobFoxAdapter.this) != null)
        {
            MobFoxAdapter.access$2(MobFoxAdapter.this).onPresentScreen(MobFoxAdapter.this);
        }
    }

    public void noAdFound()
    {
        if (MobFoxAdapter.access$2(MobFoxAdapter.this) != null)
        {
            MobFoxAdapter.access$2(MobFoxAdapter.this).onFailedToReceiveAd(MobFoxAdapter.this, b.b);
        }
    }

    ()
    {
        this$0 = MobFoxAdapter.this;
        super();
    }
}
