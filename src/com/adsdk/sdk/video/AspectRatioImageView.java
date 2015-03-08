// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

public class AspectRatioImageView extends ImageView
{

    private boolean mFill;
    private int mMaxH;
    private int mMinW;

    public AspectRatioImageView(Context context)
    {
        super(context);
        mFill = false;
        mMinW = -1;
        mMaxH = -1;
    }

    public AspectRatioImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFill = false;
        mMinW = -1;
        mMaxH = -1;
    }

    public AspectRatioImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFill = false;
        mMinW = -1;
        mMaxH = -1;
    }

    public static float dip2pixel(int i, Context context)
    {
        Resources resources = context.getResources();
        return TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }

    void ensureConstraintMetAndSet(int i, int j, int k, int l)
    {
        boolean flag;
        if (k < l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (mMinW > 0)
        {
            float f3 = dip2pixel(mMinW, getContext());
            if ((float)i < f3)
            {
                i = (int)f3;
                j = i * (l / k);
            }
        }
        if (mMaxH > 0)
        {
            float f2 = dip2pixel(mMaxH, getContext());
            if ((float)j > f2)
            {
                j = (int)f2;
                i = (j * k) / l;
            }
        }
_L4:
        setMeasuredDimension(i, j);
        return;
_L2:
        if (mMaxH > 0)
        {
            float f1 = dip2pixel(mMaxH, getContext());
            if ((float)j > f1)
            {
                j = (int)f1;
                i = (j * k) / l;
            }
        }
        if (mMinW > 0)
        {
            float f = dip2pixel(mMinW, getContext());
            if ((float)i < f)
            {
                i = (int)f;
                j = i * (l / k);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void fillParent(boolean flag, int i, int j)
    {
        mFill = flag;
        mMaxH = j;
        mMinW = i;
    }

    int getConstrainedHeight(int i, int j, int k, int l)
    {
        boolean flag;
        if (k < l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (mMinW > 0)
            {
                float f3 = dip2pixel(mMinW, getContext());
                if ((float)i < f3)
                {
                    j = (int)f3 * (l / k);
                }
            }
            if (mMaxH > 0)
            {
                float f2 = dip2pixel(mMaxH, getContext());
                if ((float)j > f2)
                {
                    j = (int)f2;
                }
            }
        } else
        {
            if (mMaxH > 0)
            {
                float f1 = dip2pixel(mMaxH, getContext());
                if ((float)j > f1)
                {
                    j = (int)f1;
                    i = (j * k) / l;
                }
            }
            if (mMinW > 0)
            {
                float f = dip2pixel(mMinW, getContext());
                if ((float)i < f)
                {
                    return (int)f * (l / k);
                }
            }
        }
        return j;
    }

    protected int getMeasuredHeight(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        android.view.View.MeasureSpec.getSize(j);
        if (!mFill || getDrawable() == null)
        {
            super.onMeasure(i, j);
            return 0;
        }
        int l = getDrawable().getIntrinsicHeight();
        int i1 = getDrawable().getIntrinsicWidth();
        int k1;
        if (i1 > l)
        {
            k1 = (k * l) / i1;
        } else
        {
            int j1 = (k * i1) / l;
            k1 = k;
            k = j1;
        }
        return getConstrainedHeight(k, k1, i1, l);
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        android.view.View.MeasureSpec.getSize(j);
        if (!mFill || getDrawable() == null)
        {
            super.onMeasure(i, j);
            return;
        }
        int l = getDrawable().getIntrinsicHeight();
        int i1 = getDrawable().getIntrinsicWidth();
        int l1;
        if (i1 > l)
        {
            l1 = (k * l) / i1;
        } else
        {
            int j1 = (k * i1) / l;
            int k1 = k;
            k = j1;
            l1 = k1;
        }
        ensureConstraintMetAndSet(k, l1, i1, l);
    }
}
