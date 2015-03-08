// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.view.animation;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.FloatMath;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation
{

    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap PROXIES = new WeakHashMap();
    private final RectF mAfter = new RectF();
    private float mAlpha;
    private final RectF mBefore = new RectF();
    private float mScaleX;
    private float mScaleY;
    private final Matrix mTempMatrix = new Matrix();
    private float mTranslationX;
    private float mTranslationY;
    private final WeakReference mView;

    private AnimatorProxy(View view)
    {
        mAlpha = 1.0F;
        mScaleX = 1.0F;
        mScaleY = 1.0F;
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        mView = new WeakReference(view);
    }

    private void computeRect(RectF rectf, View view)
    {
        rectf.set(0.0F, 0.0F, view.getWidth(), view.getHeight());
        Matrix matrix = mTempMatrix;
        matrix.reset();
        transformMatrix(matrix, view);
        mTempMatrix.mapRect(rectf);
        rectf.offset(view.getLeft(), view.getTop());
        if (rectf.right < rectf.left)
        {
            float f1 = rectf.right;
            rectf.right = rectf.left;
            rectf.left = f1;
        }
        if (rectf.bottom < rectf.top)
        {
            float f = rectf.top;
            rectf.top = rectf.bottom;
            rectf.bottom = f;
        }
    }

    private void invalidateAfterUpdate()
    {
        View view = (View)mView.get();
        View view1;
        if (view != null)
        {
            if ((view1 = (View)view.getParent()) != null)
            {
                view.setAnimation(this);
                RectF rectf = mAfter;
                computeRect(rectf, view);
                rectf.union(mBefore);
                view1.invalidate((int)FloatMath.floor(rectf.left), (int)FloatMath.floor(rectf.top), (int)FloatMath.ceil(rectf.right), (int)FloatMath.ceil(rectf.bottom));
                return;
            }
        }
    }

    private void prepareForUpdate()
    {
        View view = (View)mView.get();
        if (view != null)
        {
            computeRect(mBefore, view);
        }
    }

    private void transformMatrix(Matrix matrix, View view)
    {
        float f = view.getWidth();
        float f1 = view.getHeight();
        float f2 = mScaleX;
        float f3 = mScaleY;
        if (f2 != 1.0F || f3 != 1.0F)
        {
            float f4 = (f2 * f - f) / 2.0F;
            float f5 = (f3 * f1 - f1) / 2.0F;
            matrix.postScale(f2, f3);
            matrix.postTranslate(-f4, -f5);
        }
        matrix.postTranslate(mTranslationX, mTranslationY);
    }

    public static AnimatorProxy wrap(View view)
    {
        AnimatorProxy animatorproxy = (AnimatorProxy)PROXIES.get(view);
        if (animatorproxy == null)
        {
            animatorproxy = new AnimatorProxy(view);
            PROXIES.put(view, animatorproxy);
        }
        return animatorproxy;
    }

    protected final void applyTransformation(float f, Transformation transformation)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            transformation.setAlpha(mAlpha);
            transformMatrix(transformation.getMatrix(), view);
        }
    }

    public final float getAlpha()
    {
        return mAlpha;
    }

    public final float getScaleX()
    {
        return mScaleX;
    }

    public final float getScaleY()
    {
        return mScaleY;
    }

    public final int getScrollX()
    {
        View view = (View)mView.get();
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getScrollX();
        }
    }

    public final int getScrollY()
    {
        View view = (View)mView.get();
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getScrollY();
        }
    }

    public final float getTranslationX()
    {
        return mTranslationX;
    }

    public final float getTranslationY()
    {
        return mTranslationY;
    }

    public final void reset()
    {
    }

    public final void setAlpha(float f)
    {
        if (mAlpha != f)
        {
            mAlpha = f;
            View view = (View)mView.get();
            if (view != null)
            {
                view.invalidate();
            }
        }
    }

    public final void setScaleX(float f)
    {
        if (mScaleX != f)
        {
            prepareForUpdate();
            mScaleX = f;
            invalidateAfterUpdate();
        }
    }

    public final void setScaleY(float f)
    {
        if (mScaleY != f)
        {
            prepareForUpdate();
            mScaleY = f;
            invalidateAfterUpdate();
        }
    }

    public final void setScrollX(int i)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public final void setScrollY(int i)
    {
        View view = (View)mView.get();
        if (view != null)
        {
            view.scrollTo(view.getScrollY(), i);
        }
    }

    public final void setTranslationX(float f)
    {
        if (mTranslationX != f)
        {
            prepareForUpdate();
            mTranslationX = f;
            invalidateAfterUpdate();
        }
    }

    public final void setTranslationY(float f)
    {
        if (mTranslationY != f)
        {
            prepareForUpdate();
            mTranslationY = f;
            invalidateAfterUpdate();
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        NEEDS_PROXY = flag;
    }
}
