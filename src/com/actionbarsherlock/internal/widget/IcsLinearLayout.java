// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineLinearLayout;

// Referenced classes of package com.actionbarsherlock.internal.widget:
//            IcsColorDrawable

public class IcsLinearLayout extends NineLinearLayout
{

    private static final int LinearLayout_divider = 0;
    private static final int LinearLayout_dividerPadding = 2;
    private static final int LinearLayout_showDividers = 1;
    private static final int R_styleable_LinearLayout[] = {
        0x1010129, 0x1010329, 0x101032a
    };
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mShowDividers;

    public IcsLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, R_styleable_LinearLayout);
        setDividerDrawable(typedarray.getDrawable(0));
        mShowDividers = typedarray.getInt(1, 0);
        mDividerPadding = typedarray.getDimensionPixelSize(2, 0);
        typedarray.recycle();
    }

    void drawDividersHorizontal(Canvas canvas)
    {
        int i = getChildCount();
        for (int j = 0; j < i; j++)
        {
            View view1 = getChildAt(j);
            if (view1 != null && view1.getVisibility() != 8 && hasDividerBeforeChildAt(j))
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view1.getLayoutParams();
                drawVerticalDivider(canvas, view1.getLeft() - layoutparams.leftMargin);
            }
        }

        if (hasDividerBeforeChildAt(i))
        {
            View view = getChildAt(i - 1);
            int k;
            if (view == null)
            {
                k = getWidth() - getPaddingRight() - mDividerWidth;
            } else
            {
                k = view.getRight();
            }
            drawVerticalDivider(canvas, k);
        }
    }

    void drawDividersVertical(Canvas canvas)
    {
        int i = getChildCount();
        for (int j = 0; j < i; j++)
        {
            View view1 = getChildAt(j);
            if (view1 != null && view1.getVisibility() != 8 && hasDividerBeforeChildAt(j))
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view1.getLayoutParams();
                drawHorizontalDivider(canvas, view1.getTop() - layoutparams.topMargin);
            }
        }

        if (hasDividerBeforeChildAt(i))
        {
            View view = getChildAt(i - 1);
            int k;
            if (view == null)
            {
                k = getHeight() - getPaddingBottom() - mDividerHeight;
            } else
            {
                k = view.getBottom();
            }
            drawHorizontalDivider(canvas, k);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i)
    {
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, i, getWidth() - getPaddingRight() - mDividerPadding, i + mDividerHeight);
        mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i)
    {
        mDivider.setBounds(i, getPaddingTop() + mDividerPadding, i + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
    }

    public int getDividerPadding()
    {
        return mDividerPadding;
    }

    public int getDividerWidth()
    {
        return mDividerWidth;
    }

    public int getShowDividers()
    {
        return mShowDividers;
    }

    protected boolean hasDividerBeforeChildAt(int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        if ((1 & mShowDividers) == 0) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (i != getChildCount())
        {
            break; /* Loop/switch isn't completed */
        }
        if ((4 & mShowDividers) == 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
        if ((2 & mShowDividers) == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        int j = i - 1;
        do
        {
            if (j < 0)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            if (getChildAt(j).getVisibility() != 8)
            {
                break;
            }
            j--;
        } while (true);
        if (true) goto _L3; else goto _L6
_L6:
        return false;
        return false;
    }

    protected void measureChildWithMargins(View view, int i, int j, int k, int l)
    {
        int i1 = indexOfChild(view);
        int j1 = getOrientation();
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
        int k1;
        if (hasDividerBeforeChildAt(i1))
        {
            if (j1 == 1)
            {
                layoutparams.topMargin = mDividerHeight;
            } else
            {
                layoutparams.leftMargin = mDividerWidth;
            }
        }
        k1 = getChildCount();
        if (i1 == k1 - 1 && hasDividerBeforeChildAt(k1))
        {
            if (j1 == 1)
            {
                layoutparams.bottomMargin = mDividerHeight;
            } else
            {
                layoutparams.rightMargin = mDividerWidth;
            }
        }
        super.measureChildWithMargins(view, i, j, k, l);
    }

    public void onDraw(Canvas canvas)
    {
        if (mDivider != null)
        {
            if (getOrientation() == 1)
            {
                drawDividersVertical(canvas);
            } else
            {
                drawDividersHorizontal(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void setDividerDrawable(Drawable drawable)
    {
        if (drawable == mDivider)
        {
            return;
        }
        if ((drawable instanceof ColorDrawable) && android.os.Build.VERSION.SDK_INT < 11)
        {
            drawable = new IcsColorDrawable((ColorDrawable)drawable);
        }
        mDivider = drawable;
        boolean flag;
        if (drawable != null)
        {
            mDividerWidth = drawable.getIntrinsicWidth();
            mDividerHeight = drawable.getIntrinsicHeight();
        } else
        {
            mDividerWidth = 0;
            mDividerHeight = 0;
        }
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        requestLayout();
    }

    public void setDividerPadding(int i)
    {
        mDividerPadding = i;
    }

    public void setShowDividers(int i)
    {
        if (i != mShowDividers)
        {
            requestLayout();
            invalidate();
        }
        mShowDividers = i;
    }

}
