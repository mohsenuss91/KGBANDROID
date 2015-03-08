// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.ArrayList;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            AnimatorListenerAdapter, Animator, AnimatorSet

class canceled extends AnimatorListenerAdapter
{

    boolean canceled;
    final AnimatorSet this$0;
    final ArrayList val$nodesToStart;

    public void onAnimationCancel(Animator animator)
    {
        canceled = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        if (!canceled)
        {
            int i = val$nodesToStart.size();
            for (int j = 0; j < i; j++)
            {
                de de = (de)val$nodesToStart.get(j);
                de.animation.start();
                AnimatorSet.access$000(AnimatorSet.this).add(de.animation);
            }

        }
    }

    de()
    {
        this$0 = final_animatorset;
        val$nodesToStart = ArrayList.this;
        super();
        canceled = false;
    }
}
