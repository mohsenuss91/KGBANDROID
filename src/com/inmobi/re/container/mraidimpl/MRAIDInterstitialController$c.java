// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.animation.Animation;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDInterstitialController

class a
    implements android.view.animation.ntroller.c
{

    final MRAIDInterstitialController a;

    public void onAnimationEnd(Animation animation)
    {
        a.dismissWebview();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (MRAIDInterstitialController mraidinterstitialcontroller)
    {
        a = mraidinterstitialcontroller;
        super();
    }
}
