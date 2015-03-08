// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.inmobi.androidsdk.impl.anim.Rotate3dAnimation;
import com.inmobi.androidsdk.impl.anim.Rotate3dAnimationVert;
import com.inmobi.commons.AnimationType;

// Referenced classes of package com.inmobi.androidsdk:
//            BannerView

class g
{

    private BannerView a;
    private android.view.animation.Animation.AnimationListener b;

    public g(BannerView bannerview, android.view.animation.Animation.AnimationListener animationlistener)
    {
        a = bannerview;
        b = animationlistener;
    }

    public void a(AnimationType animationtype)
    {
        if (animationtype != AnimationType.ANIMATION_ALPHA) goto _L2; else goto _L1
_L1:
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 0.5F);
        AlphaAnimation alphaanimation1 = new AlphaAnimation(0.5F, 1.0F);
        alphaanimation.setDuration(1000L);
        alphaanimation.setFillAfter(false);
        alphaanimation.setAnimationListener(b);
        alphaanimation.setInterpolator(new DecelerateInterpolator());
        alphaanimation1.setDuration(500L);
        alphaanimation1.setFillAfter(false);
        alphaanimation1.setAnimationListener(b);
        alphaanimation1.setInterpolator(new DecelerateInterpolator());
        a.a(alphaanimation);
        a.b(alphaanimation1);
_L4:
        a.startAnimation(a.a());
        return;
_L2:
        if (animationtype == AnimationType.ROTATE_HORIZONTAL_AXIS)
        {
            Rotate3dAnimation rotate3danimation = new Rotate3dAnimation(0.0F, 90F, (float)a.getWidth() / 2.0F, (float)a.getHeight() / 2.0F, 0.0F, true);
            Rotate3dAnimation rotate3danimation1 = new Rotate3dAnimation(270F, 360F, (float)a.getWidth() / 2.0F, (float)a.getHeight() / 2.0F, 0.0F, true);
            rotate3danimation.setDuration(500L);
            rotate3danimation.setFillAfter(false);
            rotate3danimation.setAnimationListener(b);
            rotate3danimation.setInterpolator(new AccelerateInterpolator());
            rotate3danimation1.setDuration(500L);
            rotate3danimation1.setFillAfter(false);
            rotate3danimation1.setAnimationListener(b);
            rotate3danimation1.setInterpolator(new DecelerateInterpolator());
            a.a(rotate3danimation);
            a.b(rotate3danimation1);
        } else
        if (animationtype == AnimationType.ROTATE_VERTICAL_AXIS)
        {
            Rotate3dAnimationVert rotate3danimationvert = new Rotate3dAnimationVert(0.0F, 90F, (float)a.getWidth() / 2.0F, (float)a.getHeight() / 2.0F, 0.0F, true);
            Rotate3dAnimationVert rotate3danimationvert1 = new Rotate3dAnimationVert(270F, 360F, (float)a.getWidth() / 2.0F, (float)a.getHeight() / 2.0F, 0.0F, true);
            rotate3danimationvert.setDuration(500L);
            rotate3danimationvert.setFillAfter(false);
            rotate3danimationvert.setAnimationListener(b);
            rotate3danimationvert.setInterpolator(new AccelerateInterpolator());
            rotate3danimationvert1.setDuration(500L);
            rotate3danimationvert1.setFillAfter(false);
            rotate3danimationvert1.setAnimationListener(b);
            rotate3danimationvert1.setInterpolator(new DecelerateInterpolator());
            a.a(rotate3danimationvert);
            a.b(rotate3danimationvert1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
