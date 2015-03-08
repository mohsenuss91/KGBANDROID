// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDInterstitialController

class b
    implements Runnable
{

    final RelativeLayout a;
    final FrameLayout b;
    final MRAIDInterstitialController c;

    public void run()
    {
        a.removeView(MRAIDInterstitialController.a(c));
        b.removeView(a);
    }

    (MRAIDInterstitialController mraidinterstitialcontroller, RelativeLayout relativelayout, FrameLayout framelayout)
    {
        c = mraidinterstitialcontroller;
        a = relativelayout;
        b = framelayout;
        super();
    }
}
