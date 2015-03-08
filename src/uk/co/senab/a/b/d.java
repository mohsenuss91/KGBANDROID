// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package uk.co.senab.a.b:
//            c

final class d extends AnimatorListenerAdapter
{

    final c a;

    d(c c1)
    {
        a = c1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        View view = a.b;
        if (view != null)
        {
            view.setVisibility(8);
        }
        a.e();
    }
}
