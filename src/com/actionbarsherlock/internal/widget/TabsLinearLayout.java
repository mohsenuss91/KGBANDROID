// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.actionbarsherlock.internal.widget:
//            IcsLinearLayout

public class TabsLinearLayout extends IcsLinearLayout
{

    private static final int LinearLayout_measureWithLargestChild;
    private static final int R_styleable_LinearLayout[] = {
        0x10102d4
    };
    private boolean mUseLargestChild;

    public TabsLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, R_styleable_LinearLayout);
        mUseLargestChild = typedarray.getBoolean(0, false);
        typedarray.recycle();
    }

    private void useLargestChildHorizontal()
    {
        int i = getChildCount();
        int j = 0;
        int k;
        int l1;
        for (k = 0; j < i; k = l1)
        {
            l1 = Math.max(getChildAt(j).getMeasuredWidth(), k);
            j++;
        }

        int l = 0;
        int i1 = 0;
        while (l < i) 
        {
            View view = getChildAt(l);
            int j1;
            if (view != null && view.getVisibility() != 8)
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                int k1;
                if (layoutparams.weight > 0.0F)
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0x40000000));
                    k1 = i1 + k;
                } else
                {
                    k1 = i1 + view.getMeasuredWidth();
                }
                j1 = k1 + (layoutparams.leftMargin + layoutparams.rightMargin);
            } else
            {
                j1 = i1;
            }
            l++;
            i1 = j1;
        }
        setMeasuredDimension(i1 + (getPaddingLeft() + getPaddingRight()), getMeasuredHeight());
    }

    public boolean isMeasureWithLargestChildEnabled()
    {
        return mUseLargestChild;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (getChildCount() > 2)
        {
            int k = android.view.View.MeasureSpec.getMode(i);
            if (mUseLargestChild && k == 0 && getOrientation() == 0)
            {
                useLargestChildHorizontal();
                return;
            }
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean flag)
    {
        mUseLargestChild = flag;
    }

}
