// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.ArrayList;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            AnimatorSet, Animator

class mRule
    implements mRule
{

    private AnimatorSet mAnimatorSet;
    private startIfReady mNode;
    private int mRule;

    private void startIfReady(Animator animator)
    {
        if (!mAnimatorSet.mTerminated) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        i = mNode.s.size();
        j = 0;
_L5:
        mRule mrule;
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        mrule = (s)mNode.s.get(j);
        if (mrule.s != mRule || mrule.mRule.mRule != animator) goto _L4; else goto _L3
_L3:
        animator.removeListener(this);
_L6:
        mNode.s.remove(mrule);
        if (mNode.s.size() == 0)
        {
            mNode.mNode.start();
            AnimatorSet.access$000(mAnimatorSet).add(mNode.mNode);
            return;
        }
          goto _L1
_L4:
        j++;
          goto _L5
        mrule = null;
          goto _L6
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (mRule == 1)
        {
            startIfReady(animator);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        if (mRule == 0)
        {
            startIfReady(animator);
        }
    }

    public (AnimatorSet animatorset,  , int i)
    {
        mAnimatorSet = animatorset;
        mNode = ;
        mRule = i;
    }
}
