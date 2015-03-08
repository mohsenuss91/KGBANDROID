// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import java.util.Random;

// Referenced classes of package com.millennialmedia.android:
//            MMAdView

class this._cls1
    implements Runnable
{

    final geView this$1;

    public void run()
    {
        int i;
        i = transitionType;
        if (i == 4)
        {
            i = (new Random()).nextInt(4);
        }
        i;
        JVM INSTR tableswitch 2 3: default 52
    //                   2 110
    //                   3 136;
           goto _L1 _L2 _L3
_L1:
        Object obj = new AlphaAnimation(1.0F, 0.0F);
_L5:
        ((Animation) (obj)).setDuration(1000L);
        ((Animation) (obj)).setAnimationListener(_fld0);
        ((Animation) (obj)).setFillEnabled(true);
        ((Animation) (obj)).setFillBefore(true);
        ((Animation) (obj)).setFillAfter(true);
        refreshAnimationimageView.startAnimation(((Animation) (obj)));
        return;
_L2:
        obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(float)getHeight());
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, getHeight());
        if (true) goto _L5; else goto _L4
_L4:
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
