// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.nativeads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.adsdk.sdk.nativeads:
//            NativeAdManager

class val.clickUrl
    implements android.view.er
{

    final NativeAdManager this$0;
    private final String val$clickUrl;

    public void onClick(View view)
    {
        NativeAdManager.access$5(NativeAdManager.this);
        if (val$clickUrl != null && !val$clickUrl.equals(""))
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(val$clickUrl));
            NativeAdManager.access$6(NativeAdManager.this).startActivity(intent);
        }
    }

    ()
    {
        this$0 = final_nativeadmanager;
        val$clickUrl = String.this;
        super();
    }
}
