// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.banner;

import android.os.Handler;
import com.adsdk.sdk.AdResponse;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.RequestGeneralAd;

// Referenced classes of package com.adsdk.sdk.banner:
//            AdView

class this._cls0
    implements Runnable
{

    final AdView this$0;

    public void run()
    {
        Log.d("ADSDK", "starting request thread");
        RequestGeneralAd requestgeneralad;
        if (AdView.access$2(AdView.this) == null)
        {
            requestgeneralad = new RequestGeneralAd();
        } else
        {
            requestgeneralad = new RequestGeneralAd(AdView.access$2(AdView.this));
        }
        try
        {
            AdView.access$4(AdView.this, (AdResponse)requestgeneralad.sendRequest(AdView.access$3(AdView.this)));
            if (AdView.access$5(AdView.this) != null)
            {
                Log.d("ADSDK", "response received");
                Log.d("ADSDK", (new StringBuilder("getVisibility: ")).append(getVisibility()).toString());
                AdView.access$6(AdView.this).post(AdView.access$7(AdView.this));
            }
        }
        catch (Throwable throwable)
        {
            AdView.access$1(AdView.this, throwable);
        }
        AdView.access$8(AdView.this, null);
        Log.d("ADSDK", "finishing request thread");
    }

    ()
    {
        this$0 = AdView.this;
        super();
    }
}
