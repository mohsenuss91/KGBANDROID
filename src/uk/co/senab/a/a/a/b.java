// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.a.a;

import android.view.View;
import android.view.animation.Animation;
import uk.co.senab.a.b.c;

// Referenced classes of package uk.co.senab.a.a.a:
//            a

final class b
    implements android.view.animation.Animation.AnimationListener
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (animation == a.a)
        {
            View view = ((c) (a)).b;
            if (view != null)
            {
                view.setVisibility(8);
            }
            a.e();
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
