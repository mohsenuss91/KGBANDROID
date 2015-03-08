// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.view.ViewGroup;
import android.view.animation.Animation;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.androidsdk:
//            BannerView

class d
    implements android.view.animation.Animation.AnimationListener
{

    final BannerView a;

    d(BannerView bannerview)
    {
        a = bannerview;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (!animation.equals(a.a())) goto _L2; else goto _L1
_L1:
        boolean flag2;
        a.removeAllViews();
        flag2 = BannerView.g(a);
        if (!flag2) goto _L4; else goto _L3
_L3:
        Exception exception;
        Exception exception1;
        BannerView bannerview;
        boolean flag;
        boolean flag1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        android.widget.RelativeLayout.LayoutParams layoutparams1;
        try
        {
            ((ViewGroup)BannerView.h(a).getParent()).removeView(BannerView.h(a));
        }
        catch (Exception exception3) { }
        layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        BannerView.c(a, BannerView.h(a));
        a.addView(BannerView.h(a), layoutparams1);
_L5:
        a.startAnimation(a.b());
_L8:
        if (!animation.equals(a.a()))
        {
            BannerView.a(a, 100, null);
        }
_L7:
        return;
_L4:
        try
        {
            ((ViewGroup)BannerView.i(a).getParent()).removeView(BannerView.i(a));
        }
        catch (Exception exception2) { }
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        BannerView.c(a, BannerView.i(a));
        a.addView(BannerView.i(a), layoutparams);
          goto _L5
        exception1;
        Log.debug("[InMobi]-[Network]-4.4.1", "Error animating banner ads", exception1);
        if (animation.equals(a.a())) goto _L7; else goto _L6
_L6:
        BannerView.a(a, 100, null);
        return;
_L2:
        bannerview = a;
        flag = BannerView.g(a);
        flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        BannerView.d(bannerview, flag1);
        BannerView.a(a, false);
        BannerView.o(a);
          goto _L8
        exception;
        if (!animation.equals(a.a()))
        {
            BannerView.a(a, 100, null);
        }
        throw exception;
          goto _L5
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
