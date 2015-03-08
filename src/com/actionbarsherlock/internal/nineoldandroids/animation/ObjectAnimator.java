// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.HashMap;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            ValueAnimator, PropertyValuesHolder, TypeEvaluator, Animator

public final class ObjectAnimator extends ValueAnimator
{

    private static final boolean DBG;
    private String mPropertyName;
    private Object mTarget;

    public ObjectAnimator()
    {
    }

    private ObjectAnimator(Object obj, String s)
    {
        mTarget = obj;
        setPropertyName(s);
    }

    public static transient ObjectAnimator ofFloat(Object obj, String s, float af[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setFloatValues(af);
        return objectanimator;
    }

    public static transient ObjectAnimator ofInt(Object obj, String s, int ai[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setIntValues(ai);
        return objectanimator;
    }

    public static transient ObjectAnimator ofObject(Object obj, String s, TypeEvaluator typeevaluator, Object aobj[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setObjectValues(aobj);
        objectanimator.setEvaluator(typeevaluator);
        return objectanimator;
    }

    public static transient ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder apropertyvaluesholder[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator();
        objectanimator.mTarget = obj;
        objectanimator.setValues(apropertyvaluesholder);
        return objectanimator;
    }

    final void animateValue(float f)
    {
        super.animateValue(f);
        int i = mValues.length;
        for (int j = 0; j < i; j++)
        {
            mValues[j].setAnimatedValue(mTarget);
        }

    }

    public final volatile Animator clone()
    {
        return clone();
    }

    public final ObjectAnimator clone()
    {
        return (ObjectAnimator)super.clone();
    }

    public final volatile ValueAnimator clone()
    {
        return clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final String getPropertyName()
    {
        return mPropertyName;
    }

    public final Object getTarget()
    {
        return mTarget;
    }

    final void initAnimation()
    {
        if (!mInitialized)
        {
            int i = mValues.length;
            for (int j = 0; j < i; j++)
            {
                mValues[j].setupSetterAndGetter(mTarget);
            }

            super.initAnimation();
        }
    }

    public final volatile Animator setDuration(long l)
    {
        return setDuration(l);
    }

    public final ObjectAnimator setDuration(long l)
    {
        super.setDuration(l);
        return this;
    }

    public final volatile ValueAnimator setDuration(long l)
    {
        return setDuration(l);
    }

    public final transient void setFloatValues(float af[])
    {
        if (mValues == null || mValues.length == 0)
        {
            PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
            apropertyvaluesholder[0] = PropertyValuesHolder.ofFloat(mPropertyName, af);
            setValues(apropertyvaluesholder);
            return;
        } else
        {
            super.setFloatValues(af);
            return;
        }
    }

    public final transient void setIntValues(int ai[])
    {
        if (mValues == null || mValues.length == 0)
        {
            PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
            apropertyvaluesholder[0] = PropertyValuesHolder.ofInt(mPropertyName, ai);
            setValues(apropertyvaluesholder);
            return;
        } else
        {
            super.setIntValues(ai);
            return;
        }
    }

    public final transient void setObjectValues(Object aobj[])
    {
        if (mValues == null || mValues.length == 0)
        {
            PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
            apropertyvaluesholder[0] = PropertyValuesHolder.ofObject(mPropertyName, null, aobj);
            setValues(apropertyvaluesholder);
            return;
        } else
        {
            super.setObjectValues(aobj);
            return;
        }
    }

    public final void setPropertyName(String s)
    {
        if (mValues != null)
        {
            PropertyValuesHolder propertyvaluesholder = mValues[0];
            String s1 = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setPropertyName(s);
            mValuesMap.remove(s1);
            mValuesMap.put(s, propertyvaluesholder);
        }
        mPropertyName = s;
        mInitialized = false;
    }

    public final void setTarget(Object obj)
    {
label0:
        {
            if (mTarget != obj)
            {
                Object obj1 = mTarget;
                mTarget = obj;
                if (obj1 == null || obj == null || obj1.getClass() != obj.getClass())
                {
                    break label0;
                }
            }
            return;
        }
        mInitialized = false;
    }

    public final void setupEndValues()
    {
        initAnimation();
        int i = mValues.length;
        for (int j = 0; j < i; j++)
        {
            mValues[j].setupEndValue(mTarget);
        }

    }

    public final void setupStartValues()
    {
        initAnimation();
        int i = mValues.length;
        for (int j = 0; j < i; j++)
        {
            mValues[j].setupStartValue(mTarget);
        }

    }

    public final void start()
    {
        super.start();
    }

    public final String toString()
    {
        String s = (new StringBuilder("ObjectAnimator@")).append(Integer.toHexString(hashCode())).append(", target ").append(mTarget).toString();
        if (mValues != null)
        {
            for (int i = 0; i < mValues.length; i++)
            {
                s = (new StringBuilder()).append(s).append("\n    ").append(mValues[i].toString()).toString();
            }

        }
        return s;
    }
}
