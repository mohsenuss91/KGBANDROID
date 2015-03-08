// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator
    implements Cloneable
{

    ArrayList mListeners;

    public Animator()
    {
        mListeners = null;
    }

    public void addListener(AnimatorListener animatorlistener)
    {
        if (mListeners == null)
        {
            mListeners = new ArrayList();
        }
        mListeners.add(animatorlistener);
    }

    public void cancel()
    {
    }

    public Animator clone()
    {
        Animator animator;
        ArrayList arraylist;
        int i;
        animator = (Animator)super.clone();
        if (mListeners == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        arraylist = mListeners;
        animator.mListeners = new ArrayList();
        i = arraylist.size();
        int j = 0;
        while (j < i) 
        {
            try
            {
                animator.mListeners.add(arraylist.get(j));
            }
            catch (CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError();
            }
            j++;
        }
        return animator;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public void end()
    {
    }

    public abstract long getDuration();

    public ArrayList getListeners()
    {
        return mListeners;
    }

    public abstract long getStartDelay();

    public abstract boolean isRunning();

    public boolean isStarted()
    {
        return isRunning();
    }

    public void removeAllListeners()
    {
        if (mListeners != null)
        {
            mListeners.clear();
            mListeners = null;
        }
    }

    public void removeListener(AnimatorListener animatorlistener)
    {
        if (mListeners != null)
        {
            mListeners.remove(animatorlistener);
            if (mListeners.size() == 0)
            {
                mListeners = null;
                return;
            }
        }
    }

    public abstract Animator setDuration(long l);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setStartDelay(long l);

    public void setTarget(Object obj)
    {
    }

    public void setupEndValues()
    {
    }

    public void setupStartValues()
    {
    }

    public void start()
    {
    }
}
