// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            Keyframe, FloatKeyframeSet, IntKeyframeSet, TypeEvaluator

class KeyframeSet
{

    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList mKeyframes;
    Keyframe mLastKeyframe;
    int mNumKeyframes;

    public transient KeyframeSet(Keyframe akeyframe[])
    {
        mNumKeyframes = akeyframe.length;
        mKeyframes = new ArrayList();
        mKeyframes.addAll(Arrays.asList(akeyframe));
        mFirstKeyframe = (Keyframe)mKeyframes.get(0);
        mLastKeyframe = (Keyframe)mKeyframes.get(-1 + mNumKeyframes);
        mInterpolator = mLastKeyframe.getInterpolator();
    }

    public static transient KeyframeSet ofFloat(float af[])
    {
        int i = 1;
        int j = af.length;
        Keyframe.FloatKeyframe afloatkeyframe[] = new Keyframe.FloatKeyframe[Math.max(j, 2)];
        if (j == i)
        {
            afloatkeyframe[0] = (Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0F);
            afloatkeyframe[i] = (Keyframe.FloatKeyframe)Keyframe.ofFloat(1.0F, af[0]);
        } else
        {
            afloatkeyframe[0] = (Keyframe.FloatKeyframe)Keyframe.ofFloat(0.0F, af[0]);
            while (i < j) 
            {
                afloatkeyframe[i] = (Keyframe.FloatKeyframe)Keyframe.ofFloat((float)i / (float)(j - 1), af[i]);
                i++;
            }
        }
        return new FloatKeyframeSet(afloatkeyframe);
    }

    public static transient KeyframeSet ofInt(int ai[])
    {
        int i = 1;
        int j = ai.length;
        Keyframe.IntKeyframe aintkeyframe[] = new Keyframe.IntKeyframe[Math.max(j, 2)];
        if (j == i)
        {
            aintkeyframe[0] = (Keyframe.IntKeyframe)Keyframe.ofInt(0.0F);
            aintkeyframe[i] = (Keyframe.IntKeyframe)Keyframe.ofInt(1.0F, ai[0]);
        } else
        {
            aintkeyframe[0] = (Keyframe.IntKeyframe)Keyframe.ofInt(0.0F, ai[0]);
            while (i < j) 
            {
                aintkeyframe[i] = (Keyframe.IntKeyframe)Keyframe.ofInt((float)i / (float)(j - 1), ai[i]);
                i++;
            }
        }
        return new IntKeyframeSet(aintkeyframe);
    }

    public static transient KeyframeSet ofKeyframe(Keyframe akeyframe[])
    {
        int i = 0;
        int j = akeyframe.length;
        int k = 0;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        while (k < j) 
        {
            if (akeyframe[k] instanceof Keyframe.FloatKeyframe)
            {
                flag2 = true;
            } else
            if (akeyframe[k] instanceof Keyframe.IntKeyframe)
            {
                flag1 = true;
            } else
            {
                flag = true;
            }
            k++;
        }
        if (flag2 && !flag1 && !flag)
        {
            Keyframe.FloatKeyframe afloatkeyframe[] = new Keyframe.FloatKeyframe[j];
            for (; i < j; i++)
            {
                afloatkeyframe[i] = (Keyframe.FloatKeyframe)akeyframe[i];
            }

            return new FloatKeyframeSet(afloatkeyframe);
        }
        if (flag1 && !flag2 && !flag)
        {
            Keyframe.IntKeyframe aintkeyframe[] = new Keyframe.IntKeyframe[j];
            for (int l = 0; l < j; l++)
            {
                aintkeyframe[l] = (Keyframe.IntKeyframe)akeyframe[l];
            }

            return new IntKeyframeSet(aintkeyframe);
        } else
        {
            return new KeyframeSet(akeyframe);
        }
    }

    public static transient KeyframeSet ofObject(Object aobj[])
    {
        int i = 1;
        int j = aobj.length;
        Keyframe.ObjectKeyframe aobjectkeyframe[] = new Keyframe.ObjectKeyframe[Math.max(j, 2)];
        if (j == i)
        {
            aobjectkeyframe[0] = (Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0F);
            aobjectkeyframe[i] = (Keyframe.ObjectKeyframe)Keyframe.ofObject(1.0F, aobj[0]);
        } else
        {
            aobjectkeyframe[0] = (Keyframe.ObjectKeyframe)Keyframe.ofObject(0.0F, aobj[0]);
            while (i < j) 
            {
                aobjectkeyframe[i] = (Keyframe.ObjectKeyframe)Keyframe.ofObject((float)i / (float)(j - 1), aobj[i]);
                i++;
            }
        }
        return new KeyframeSet(aobjectkeyframe);
    }

    public KeyframeSet clone()
    {
        ArrayList arraylist = mKeyframes;
        int i = mKeyframes.size();
        Keyframe akeyframe[] = new Keyframe[i];
        for (int j = 0; j < i; j++)
        {
            akeyframe[j] = ((Keyframe)arraylist.get(j)).clone();
        }

        return new KeyframeSet(akeyframe);
    }

    public volatile Object clone()
    {
        return clone();
    }

    public Object getValue(float f)
    {
        if (mNumKeyframes == 2)
        {
            if (mInterpolator != null)
            {
                f = mInterpolator.getInterpolation(f);
            }
            return mEvaluator.evaluate(f, mFirstKeyframe.getValue(), mLastKeyframe.getValue());
        }
        if (f <= 0.0F)
        {
            Keyframe keyframe3 = (Keyframe)mKeyframes.get(1);
            Interpolator interpolator2 = keyframe3.getInterpolator();
            if (interpolator2 != null)
            {
                f = interpolator2.getInterpolation(f);
            }
            float f5 = mFirstKeyframe.getFraction();
            float f6 = (f - f5) / (keyframe3.getFraction() - f5);
            return mEvaluator.evaluate(f6, mFirstKeyframe.getValue(), keyframe3.getValue());
        }
        if (f >= 1.0F)
        {
            Keyframe keyframe2 = (Keyframe)mKeyframes.get(-2 + mNumKeyframes);
            Interpolator interpolator1 = mLastKeyframe.getInterpolator();
            if (interpolator1 != null)
            {
                f = interpolator1.getInterpolation(f);
            }
            float f3 = keyframe2.getFraction();
            float f4 = (f - f3) / (mLastKeyframe.getFraction() - f3);
            return mEvaluator.evaluate(f4, keyframe2.getValue(), mLastKeyframe.getValue());
        }
        Keyframe keyframe = mFirstKeyframe;
        for (int i = 1; i < mNumKeyframes;)
        {
            Keyframe keyframe1 = (Keyframe)mKeyframes.get(i);
            if (f < keyframe1.getFraction())
            {
                Interpolator interpolator = keyframe1.getInterpolator();
                if (interpolator != null)
                {
                    f = interpolator.getInterpolation(f);
                }
                float f1 = keyframe.getFraction();
                float f2 = (f - f1) / (keyframe1.getFraction() - f1);
                return mEvaluator.evaluate(f2, keyframe.getValue(), keyframe1.getValue());
            }
            i++;
            keyframe = keyframe1;
        }

        return mLastKeyframe.getValue();
    }

    public void setEvaluator(TypeEvaluator typeevaluator)
    {
        mEvaluator = typeevaluator;
    }

    public String toString()
    {
        String s = " ";
        for (int i = 0; i < mNumKeyframes;)
        {
            String s1 = (new StringBuilder()).append(s).append(((Keyframe)mKeyframes.get(i)).getValue()).append("  ").toString();
            i++;
            s = s1;
        }

        return s;
    }
}
