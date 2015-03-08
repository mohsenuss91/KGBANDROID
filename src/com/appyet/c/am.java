// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.animation.Animation;
import android.widget.ProgressBar;

// Referenced classes of package com.appyet.c:
//            r

final class am
    implements android.view.animation.Animation.AnimationListener
{

    final r a;
    private ProgressBar b;

    public am(r r, ProgressBar progressbar)
    {
        a = r;
        super();
        b = progressbar;
    }

    public final void onAnimationEnd(Animation animation)
    {
        b.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
