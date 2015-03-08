// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuView, ActionMenuItemView, MenuBuilder, ActionMenuPresenter, 
//            MenuItemImpl

public class ActionMenuView extends IcsLinearLayout
    implements MenuBuilder.ItemInvoker, MenuView
{

    static final int GENERATED_ITEM_PADDING = 4;
    private static final boolean IS_FROYO = false;
    static final int MIN_CELL_SIZE = 56;
    private boolean mFirst;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    private int mMinCellSize;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public ActionMenuView(Context context)
    {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFirst = true;
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int)(56F * f);
        mGeneratedItemPadding = (int)(f * 4F);
    }

    static int measureChildForCells(View view, int i, int j, int k, int l)
    {
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        int i1 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(k) - l, android.view.View.MeasureSpec.getMode(k));
        int j1;
        if (j > 0)
        {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i * j, 0x80000000), i1);
            int k1 = view.getMeasuredWidth();
            int l1 = k1 / i;
            ActionMenuItemView actionmenuitemview;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (k1 % i != 0)
            {
                j1 = l1 + 1;
            } else
            {
                j1 = l1;
            }
        } else
        {
            j1 = 0;
        }
        if (view instanceof ActionMenuItemView)
        {
            actionmenuitemview = (ActionMenuItemView)view;
        } else
        {
            actionmenuitemview = null;
        }
        flag = layoutparams.isOverflowButton;
        flag1 = false;
        if (!flag)
        {
            flag1 = false;
            if (actionmenuitemview != null)
            {
                flag2 = actionmenuitemview.hasText();
                flag1 = false;
                if (flag2)
                {
                    flag1 = true;
                }
            }
        }
        layoutparams.expandable = flag1;
        layoutparams.cellsUsed = j1;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j1 * i, 0x40000000), i1);
        return j1;
    }

    private void onMeasureExactFormat(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(j);
        int l = android.view.View.MeasureSpec.getSize(i);
        int i1 = android.view.View.MeasureSpec.getSize(j);
        int j1 = getPaddingLeft() + getPaddingRight();
        int k1 = getPaddingTop() + getPaddingBottom();
        int l1 = l - j1;
        int i2 = l1 / mMinCellSize;
        int j2 = l1 % mMinCellSize;
        if (i2 == 0)
        {
            setMeasuredDimension(l1, 0);
            return;
        }
        int k2 = mMinCellSize + j2 / i2;
        int l2 = 0;
        int i3 = 0;
        int j3 = 0;
        int k3 = 0;
        boolean flag = false;
        long l3 = 0L;
        int i4 = getChildCount();
        int j4 = 0;
        while (j4 < i4) 
        {
            View view3 = getChildAt(j4);
            int j9;
            long l9;
            int k9;
            int i10;
            int j10;
            if (view3.getVisibility() != 8)
            {
                boolean flag6 = view3 instanceof ActionMenuItemView;
                int k10 = k3 + 1;
                if (flag6)
                {
                    view3.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                }
                LayoutParams layoutparams4 = (LayoutParams)view3.getLayoutParams();
                layoutparams4.expanded = false;
                layoutparams4.extraPixels = 0;
                layoutparams4.cellsUsed = 0;
                layoutparams4.expandable = false;
                layoutparams4.leftMargin = 0;
                layoutparams4.rightMargin = 0;
                boolean flag7;
                int l10;
                int i11;
                int j11;
                int k11;
                boolean flag8;
                int l11;
                int i12;
                if (flag6 && ((ActionMenuItemView)view3).hasText())
                {
                    flag7 = true;
                } else
                {
                    flag7 = false;
                }
                layoutparams4.preventEdgeOffset = flag7;
                if (layoutparams4.isOverflowButton)
                {
                    l10 = 1;
                } else
                {
                    l10 = i2;
                }
                i11 = measureChildForCells(view3, k2, l10, j, k1);
                j11 = Math.max(i3, i11);
                boolean flag1;
                boolean flag2;
                long l4;
                int k4;
                long l5;
                boolean flag3;
                boolean flag4;
                int i5;
                int j5;
                View view;
                LayoutParams layoutparams;
                int k5;
                float f;
                float f1;
                int i6;
                int j6;
                boolean flag5;
                View view1;
                LayoutParams layoutparams1;
                int k6;
                long l6;
                int i7;
                int j7;
                int k7;
                int l7;
                int i8;
                long l8;
                View view2;
                LayoutParams layoutparams2;
                int j8;
                LayoutParams layoutparams3;
                int k8;
                int i9;
                if (layoutparams4.expandable)
                {
                    k11 = j3 + 1;
                } else
                {
                    k11 = j3;
                }
                if (layoutparams4.isOverflowButton)
                {
                    flag8 = true;
                } else
                {
                    flag8 = flag;
                }
                l11 = i2 - i11;
                i12 = Math.max(l2, view3.getMeasuredHeight());
                if (i11 == 1)
                {
                    long l13 = l3 | (long)(1 << j4);
                    k9 = i12;
                    i10 = l11;
                    j3 = k11;
                    flag = flag8;
                    l9 = l13;
                    j10 = j11;
                    j9 = k10;
                } else
                {
                    j9 = k10;
                    j10 = j11;
                    long l12 = l3;
                    k9 = i12;
                    i10 = l11;
                    flag = flag8;
                    j3 = k11;
                    l9 = l12;
                }
            } else
            {
                j9 = k3;
                l9 = l3;
                k9 = l2;
                i10 = i2;
                j10 = i3;
            }
            j4++;
            i3 = j10;
            l2 = k9;
            i2 = i10;
            l3 = l9;
            k3 = j9;
        }
        if (flag && k3 == 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag2 = false;
        l4 = l3;
        k4 = i2;
        if (j3 <= 0 || k4 <= 0) goto _L2; else goto _L1
_L1:
        k6 = 0x7fffffff;
        l6 = 0L;
        i7 = 0;
        j7 = 0;
_L9:
        if (j7 >= i4) goto _L4; else goto _L3
_L3:
        layoutparams3 = (LayoutParams)getChildAt(j7).getLayoutParams();
        if (!layoutparams3.expandable) goto _L6; else goto _L5
_L5:
        if (layoutparams3.cellsUsed >= k6) goto _L8; else goto _L7
_L7:
        i9 = layoutparams3.cellsUsed;
        l6 = 1 << j7;
        k8 = 1;
_L11:
        j7++;
        k6 = i9;
        i7 = k8;
          goto _L9
_L8:
        if (layoutparams3.cellsUsed != k6) goto _L6; else goto _L10
_L10:
        l6 |= 1 << j7;
        k8 = i7 + 1;
        i9 = k6;
          goto _L11
_L4:
        l4 |= l6;
        if (i7 <= k4)
        {
            k7 = k6 + 1;
            l7 = k4;
            i8 = 0;
            l8 = l4;
            while (i8 < i4) 
            {
                view2 = getChildAt(i8);
                layoutparams2 = (LayoutParams)view2.getLayoutParams();
                if ((l6 & (long)(1 << i8)) == 0L)
                {
                    if (layoutparams2.cellsUsed == k7)
                    {
                        l8 |= 1 << i8;
                        j8 = l7;
                    } else
                    {
                        j8 = l7;
                    }
                } else
                {
                    if (flag1 && layoutparams2.preventEdgeOffset && l7 == 1)
                    {
                        view2.setPadding(k2 + mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                    }
                    layoutparams2.cellsUsed = 1 + layoutparams2.cellsUsed;
                    layoutparams2.expanded = true;
                    j8 = l7 - 1;
                }
                i8++;
                l7 = j8;
            }
            l4 = l8;
            flag2 = true;
            k4 = l7;
            break MISSING_BLOCK_LABEL_432;
        }
_L2:
        l5 = l4;
        if (!flag && k3 == 1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (k4 <= 0 || l5 == 0L) goto _L13; else goto _L12
_L12:
        k5 = k3 - 1;
        if (k4 >= k5 && !flag3 && i3 <= 1) goto _L13; else goto _L14
_L14:
        f = Long.bitCount(l5);
        if (flag3) goto _L16; else goto _L15
_L15:
        if ((1L & l5) != 0L && !((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset)
        {
            f -= 0.5F;
        }
        if ((l5 & (long)(1 << i4 - 1)) == 0L || ((LayoutParams)getChildAt(i4 - 1).getLayoutParams()).preventEdgeOffset) goto _L16; else goto _L17
_L17:
        f1 = f - 0.5F;
_L21:
        if (f1 > 0.0F)
        {
            i6 = (int)((float)(k4 * k2) / f1);
        } else
        {
            i6 = 0;
        }
        j6 = 0;
        flag4 = flag2;
_L19:
        if (j6 >= i4)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((l5 & (long)(1 << j6)) == 0L)
        {
            break MISSING_BLOCK_LABEL_1089;
        }
        view1 = getChildAt(j6);
        layoutparams1 = (LayoutParams)view1.getLayoutParams();
        if (view1 instanceof ActionMenuItemView)
        {
            layoutparams1.extraPixels = i6;
            layoutparams1.expanded = true;
            if (j6 == 0 && !layoutparams1.preventEdgeOffset)
            {
                layoutparams1.leftMargin = -i6 / 2;
            }
            flag5 = true;
        } else
        {
label0:
            {
                if (!layoutparams1.isOverflowButton)
                {
                    break label0;
                }
                layoutparams1.extraPixels = i6;
                layoutparams1.expanded = true;
                layoutparams1.rightMargin = -i6 / 2;
                flag5 = true;
            }
        }
_L20:
        j6++;
        flag4 = flag5;
        if (true) goto _L19; else goto _L18
        if (j6 != 0)
        {
            layoutparams1.leftMargin = i6 / 2;
        }
        if (j6 != i4 - 1)
        {
            layoutparams1.rightMargin = i6 / 2;
        }
        flag5 = flag4;
          goto _L20
_L13:
        flag4 = flag2;
_L18:
        if (flag4)
        {
            i5 = android.view.View.MeasureSpec.makeMeasureSpec(i1 - k1, k);
            for (j5 = 0; j5 < i4; j5++)
            {
                view = getChildAt(j5);
                layoutparams = (LayoutParams)view.getLayoutParams();
                if (layoutparams.expanded)
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k2 * layoutparams.cellsUsed + layoutparams.extraPixels, 0x40000000), i5);
                }
            }

        }
        if (k == 0x40000000)
        {
            l2 = i1;
        }
        setMeasuredDimension(l1, l2);
        return;
_L16:
        f1 = f;
        if (true) goto _L21; else goto _L6
_L6:
        k8 = i7;
        i9 = k6;
          goto _L11
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams != null && (layoutparams instanceof LayoutParams);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return false;
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected volatile android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams()
    {
        LayoutParams layoutparams = new LayoutParams(-2, -2);
        layoutparams.gravity = 16;
        return layoutparams;
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public volatile android.widget.LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof LayoutParams)
        {
            LayoutParams layoutparams1 = new LayoutParams((LayoutParams)layoutparams);
            if (layoutparams1.gravity <= 0)
            {
                layoutparams1.gravity = 16;
            }
            return layoutparams1;
        } else
        {
            return generateDefaultLayoutParams();
        }
    }

    public LayoutParams generateOverflowButtonLayoutParams()
    {
        LayoutParams layoutparams = generateDefaultLayoutParams();
        layoutparams.isOverflowButton = true;
        return layoutparams;
    }

    public int getWindowAnimations()
    {
        return 0;
    }

    protected boolean hasDividerBeforeChildAt(int i)
    {
        if (i == 0)
        {
            return false;
        }
        View view = getChildAt(i - 1);
        View view1 = getChildAt(i);
        int j = getChildCount();
        boolean flag = false;
        if (i < j)
        {
            boolean flag1 = view instanceof ActionMenuChildView;
            flag = false;
            if (flag1)
            {
                flag = false | ((ActionMenuChildView)view).needsDividerAfter();
            }
        }
        if (i > 0 && (view1 instanceof ActionMenuChildView))
        {
            return flag | ((ActionMenuChildView)view1).needsDividerBefore();
        } else
        {
            return flag;
        }
    }

    public void initialize(MenuBuilder menubuilder)
    {
        mMenu = menubuilder;
    }

    public boolean invokeItem(MenuItemImpl menuitemimpl)
    {
        return mMenu.performItemAction(menuitemimpl, 0);
    }

    public boolean isExpandedFormat()
    {
        return mFormatItems;
    }

    public boolean isOverflowReserved()
    {
        return mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (IS_FROYO)
        {
            super.onConfigurationChanged(configuration);
        }
        mPresenter.updateMenuView(false);
        if (mPresenter != null && mPresenter.isOverflowMenuShowing())
        {
            mPresenter.hideOverflowMenu();
            mPresenter.showOverflowMenu();
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
    }

    protected void onDraw(Canvas canvas)
    {
        if (!IS_FROYO && mFirst)
        {
            mFirst = false;
            requestLayout();
            return;
        } else
        {
            super.onDraw(canvas);
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (!mFormatItems)
        {
            super.onLayout(flag, i, j, k, l);
        } else
        {
            int i1 = getChildCount();
            int j1 = (j + l) / 2;
            int k1 = 0;
            int l1 = k - i - getPaddingRight() - getPaddingLeft();
            boolean flag1 = false;
            int i2 = 0;
            while (i2 < i1) 
            {
                View view2 = getChildAt(i2);
                int j2;
                int k2;
                int l2;
                int i3;
                int j3;
                int k3;
                View view;
                LayoutParams layoutparams;
                int l3;
                int i4;
                int j4;
                int k4;
                int l4;
                View view1;
                int i5;
                int j5;
                int k5;
                int l5;
                int i6;
                int j6;
                boolean flag2;
                if (view2.getVisibility() != 8)
                {
                    LayoutParams layoutparams1 = (LayoutParams)view2.getLayoutParams();
                    if (layoutparams1.isOverflowButton)
                    {
                        int k6 = view2.getMeasuredWidth();
                        if (hasDividerBeforeChildAt(i2))
                        {
                            k6 += 0;
                        }
                        int l6 = view2.getMeasuredHeight();
                        int i7 = getWidth() - getPaddingRight() - layoutparams1.rightMargin;
                        int j7 = i7 - k6;
                        int k7 = j1 - l6 / 2;
                        view2.layout(j7, k7, i7, l6 + k7);
                        i6 = l1 - k6;
                        flag2 = true;
                        j6 = k1;
                    } else
                    {
                        i6 = l1 - (view2.getMeasuredWidth() + layoutparams1.leftMargin + layoutparams1.rightMargin);
                        j6 = k1 + 1;
                        flag2 = flag1;
                    }
                } else
                {
                    i6 = l1;
                    j6 = k1;
                    flag2 = flag1;
                }
                i2++;
                flag1 = flag2;
                k1 = j6;
                l1 = i6;
            }
            if (i1 == 1 && !flag1)
            {
                view1 = getChildAt(0);
                i5 = view1.getMeasuredWidth();
                j5 = view1.getMeasuredHeight();
                k5 = (k - i) / 2 - i5 / 2;
                l5 = j1 - j5 / 2;
                view1.layout(k5, l5, i5 + k5, j5 + l5);
                return;
            }
            if (flag1)
            {
                j2 = 0;
            } else
            {
                j2 = 1;
            }
            k2 = k1 - j2;
            if (k2 > 0)
            {
                l2 = l1 / k2;
            } else
            {
                l2 = 0;
            }
            i3 = Math.max(0, l2);
            j3 = getPaddingLeft();
            k3 = 0;
            while (k3 < i1) 
            {
                view = getChildAt(k3);
                layoutparams = (LayoutParams)view.getLayoutParams();
                if (view.getVisibility() != 8 && !layoutparams.isOverflowButton)
                {
                    i4 = j3 + layoutparams.leftMargin;
                    j4 = view.getMeasuredWidth();
                    k4 = view.getMeasuredHeight();
                    l4 = j1 - k4 / 2;
                    view.layout(i4, l4, i4 + j4, k4 + l4);
                    l3 = i4 + (i3 + (j4 + layoutparams.rightMargin));
                } else
                {
                    l3 = j3;
                }
                k3++;
                j3 = l3;
            }
        }
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag = mFormatItems;
        boolean flag1;
        int k;
        if (android.view.View.MeasureSpec.getMode(i) == 0x40000000)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        mFormatItems = flag1;
        if (flag != mFormatItems)
        {
            mFormatItemsWidth = 0;
        }
        k = android.view.View.MeasureSpec.getMode(i);
        if (mFormatItems && mMenu != null && k != mFormatItemsWidth)
        {
            mFormatItemsWidth = k;
            mMenu.onItemsChanged(true);
        }
        if (mFormatItems)
        {
            onMeasureExactFormat(i, j);
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setOverflowReserved(boolean flag)
    {
        mReserveOverflow = flag;
    }

    public void setPresenter(ActionMenuPresenter actionmenupresenter)
    {
        mPresenter = actionmenupresenter;
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IS_FROYO = flag;
    }

    private class LayoutParams extends android.widget.LinearLayout.LayoutParams
    {

        public int cellsUsed;
        public boolean expandable;
        public boolean expanded;
        public int extraPixels;
        public boolean isOverflowButton;
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int j)
        {
            super(i, j);
            isOverflowButton = false;
        }

        public LayoutParams(int i, int j, boolean flag)
        {
            super(i, j);
            isOverflowButton = flag;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
            isOverflowButton = layoutparams.isOverflowButton;
        }
    }


    private class ActionMenuChildView
    {

        public abstract boolean needsDividerAfter();

        public abstract boolean needsDividerBefore();
    }

}
