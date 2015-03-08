// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.view.View;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;

// Referenced classes of package com.inmobi.androidsdk:
//            IMBrowserActivity

class a
    implements android.view.
{

    final IMBrowserActivity a;

    public void onClick(View view)
    {
        if (IMBrowserActivity.a() != null && IMBrowserActivity.a().mInterstitialController != null)
        {
            IMBrowserActivity.a().mInterstitialController.handleInterstitialClose();
        }
        a.finish();
    }

    erstitialController(IMBrowserActivity imbrowseractivity)
    {
        a = imbrowseractivity;
        super();
    }
}
