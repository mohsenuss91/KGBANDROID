// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            AnimatorSet, Animator

class mAnimatorSet
    implements mAnimatorSet
{

    private AnimatorSet mAnimatorSet;
    final AnimatorSet this$0;

    public void onAnimationCancel(Animator animator)
    {
        if (!mTerminated && AnimatorSet.access$000(AnimatorSet.this).size() == 0 && mListeners != null)
        {
            int i = mListeners.size();
            for (int j = 0; j < i; j++)
            {
                ((this._cls0)mListeners.get(j)).ationCancel(mAnimatorSet);
            }

        }
    }

    public void onAnimationEnd(Animator animator)
    {
        animator.removeListener(this);
        AnimatorSet.access$000(AnimatorSet.this).remove(animator);
        ((this._cls0)AnimatorSet.access$100(mAnimatorSet).get(animator)).mAnimatorSet = true;
        if (mTerminated) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        int i;
        int j;
        arraylist = AnimatorSet.access$200(mAnimatorSet);
        i = arraylist.size();
        j = 0;
_L5:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        if (((mAnimatorSet)arraylist.get(j)).mAnimatorSet) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        if (flag)
        {
            if (mListeners != null)
            {
                ArrayList arraylist1 = (ArrayList)mListeners.clone();
                int k = arraylist1.size();
                for (int l = 0; l < k; l++)
                {
                    ((mAnimatorSet)arraylist1.get(l)).ationEnd(mAnimatorSet);
                }

            }
            AnimatorSet.access$302(mAnimatorSet, false);
        }
          goto _L2
_L4:
        j++;
          goto _L5
_L2:
        return;
        flag = true;
          goto _L6
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (AnimatorSet animatorset1)
    {
        this$0 = AnimatorSet.this;
        super();
        mAnimatorSet = animatorset1;
    }
}
