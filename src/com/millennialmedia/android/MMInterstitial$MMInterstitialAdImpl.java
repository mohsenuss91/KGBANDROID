// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, AdProperties, MMInterstitial, MMAd

class getContext extends MMAdImpl
{

    final MMInterstitial this$0;

    volatile MMAd getCallingAd()
    {
        return getCallingAd();
    }

    MMInterstitial getCallingAd()
    {
        return MMInterstitial.this;
    }

    public (Context context)
    {
        this$0 = MMInterstitial.this;
        super(context);
        adProperties = new AdProperties(getContext());
    }
}
