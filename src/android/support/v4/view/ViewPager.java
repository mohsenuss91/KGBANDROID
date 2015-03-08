// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.widget.k;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            at, au, bf, ax, 
//            av, aa, af, w, 
//            ay, bb, aw, ab, 
//            r, ap, az, bd, 
//            ba, bc

public class ViewPager extends ViewGroup
{

    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator COMPARATOR = new at();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int LAYOUT_ATTRS[] = {
        0x10100b3
    };
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE;
    private static final Interpolator sInterpolator = new au();
    private static final bf sPositionComparator = new bf();
    private int mActivePointerId;
    private aa mAdapter;
    private ba mAdapterChangeListener;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private bb mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private k mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private bd mObserver;
    private int mOffscreenPageLimit;
    private bb mOnPageChangeListener;
    private int mPageMargin;
    private bc mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private k mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ax mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public ViewPager(Context context)
    {
        super(context);
        mItems = new ArrayList();
        mTempItem = new ax();
        mTempRect = new Rect();
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
        mFirstOffset = -3.402823E+38F;
        mLastOffset = 3.402823E+38F;
        mOffscreenPageLimit = 1;
        mActivePointerId = -1;
        mFirstLayout = true;
        mNeedCalculatePageOffsets = false;
        mEndScrollRunnable = new av(this);
        mScrollState = 0;
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mItems = new ArrayList();
        mTempItem = new ax();
        mTempRect = new Rect();
        mRestoredCurItem = -1;
        mRestoredAdapterState = null;
        mRestoredClassLoader = null;
        mFirstOffset = -3.402823E+38F;
        mLastOffset = 3.402823E+38F;
        mOffscreenPageLimit = 1;
        mActivePointerId = -1;
        mFirstLayout = true;
        mNeedCalculatePageOffsets = false;
        mEndScrollRunnable = new av(this);
        mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ax ax1, int i, ax ax2)
    {
        int j = mAdapter.getCount();
        int l = getClientWidth();
        float f;
        if (l > 0)
        {
            f = (float)mPageMargin / (float)l;
        } else
        {
            f = 0.0F;
        }
        if (ax2 != null)
        {
            int j3 = ax2.b;
            if (j3 < ax1.b)
            {
                float f8 = f + (ax2.e + ax2.d);
                int i4 = j3 + 1;
                for (int j4 = 0; i4 <= ax1.b && j4 < mItems.size(); i4++)
                {
                    ax ax6;
                    for (ax6 = (ax)mItems.get(j4); i4 > ax6.b && j4 < -1 + mItems.size(); ax6 = (ax)mItems.get(j4))
                    {
                        j4++;
                    }

                    for (; i4 < ax6.b; i4++)
                    {
                        f8 += f + mAdapter.getPageWidth(i4);
                    }

                    ax6.e = f8;
                    f8 += f + ax6.d;
                }

            } else
            if (j3 > ax1.b)
            {
                int k3 = -1 + mItems.size();
                float f7 = ax2.e;
                for (int l3 = j3 - 1; l3 >= ax1.b && k3 >= 0; l3--)
                {
                    ax ax5;
                    for (ax5 = (ax)mItems.get(k3); l3 < ax5.b && k3 > 0; ax5 = (ax)mItems.get(k3))
                    {
                        k3--;
                    }

                    for (; l3 > ax5.b; l3--)
                    {
                        f7 -= f + mAdapter.getPageWidth(l3);
                    }

                    f7 -= f + ax5.d;
                    ax5.e = f7;
                }

            }
        }
        int i1 = mItems.size();
        float f1 = ax1.e;
        int j1 = -1 + ax1.b;
        float f2;
        float f3;
        if (ax1.b == 0)
        {
            f2 = ax1.e;
        } else
        {
            f2 = -3.402823E+38F;
        }
        mFirstOffset = f2;
        if (ax1.b == j - 1)
        {
            f3 = (ax1.e + ax1.d) - 1.0F;
        } else
        {
            f3 = 3.402823E+38F;
        }
        mLastOffset = f3;
        int l2;
        for (int k1 = i - 1; k1 >= 0; k1 = l2)
        {
            ax ax4 = (ax)mItems.get(k1);
            float f6 = f1;
            int i3;
            for (; j1 > ax4.b; j1 = i3)
            {
                aa aa2 = mAdapter;
                i3 = j1 - 1;
                f6 -= f + aa2.getPageWidth(j1);
            }

            f1 = f6 - (f + ax4.d);
            ax4.e = f1;
            if (ax4.b == 0)
            {
                mFirstOffset = f1;
            }
            l2 = k1 - 1;
            j1--;
        }

        float f4 = f + (ax1.e + ax1.d);
        int l1 = 1 + ax1.b;
        int j2;
        for (int i2 = i + 1; i2 < i1; i2 = j2)
        {
            ax ax3 = (ax)mItems.get(i2);
            float f5 = f4;
            int k2;
            for (; l1 < ax3.b; l1 = k2)
            {
                aa aa1 = mAdapter;
                k2 = l1 + 1;
                f5 += f + aa1.getPageWidth(l1);
            }

            if (ax3.b == j - 1)
            {
                mLastOffset = (f5 + ax3.d) - 1.0F;
            }
            ax3.e = f5;
            f4 = f5 + (f + ax3.d);
            j2 = i2 + 1;
            l1++;
        }

        mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean flag)
    {
label0:
        {
            boolean flag1;
            int i;
            boolean flag2;
            if (mScrollState == 2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                setScrollingCacheEnabled(false);
                mScroller.abortAnimation();
                int j = getScrollX();
                int l = getScrollY();
                int i1 = mScroller.getCurrX();
                int j1 = mScroller.getCurrY();
                if (j != i1 || l != j1)
                {
                    scrollTo(i1, j1);
                }
            }
            mPopulatePending = false;
            i = 0;
            flag2 = flag1;
            for (; i < mItems.size(); i++)
            {
                ax ax1 = (ax)mItems.get(i);
                if (ax1.c)
                {
                    ax1.c = false;
                    flag2 = true;
                }
            }

            if (flag2)
            {
                if (!flag)
                {
                    break label0;
                }
                af.a(this, mEndScrollRunnable);
            }
            return;
        }
        mEndScrollRunnable.run();
    }

    private int determineTargetPage(int i, float f, int j, int l)
    {
        if (Math.abs(l) > mFlingDistance && Math.abs(j) > mMinimumVelocity)
        {
            if (j <= 0)
            {
                i++;
            }
        } else
        {
            float f1;
            if (i >= mCurItem)
            {
                f1 = 0.4F;
            } else
            {
                f1 = 0.6F;
            }
            i = (int)(f1 + (f + (float)i));
        }
        if (mItems.size() > 0)
        {
            ax ax1 = (ax)mItems.get(0);
            ax ax2 = (ax)mItems.get(-1 + mItems.size());
            i = Math.max(ax1.b, Math.min(i, ax2.b));
        }
        return i;
    }

    private void enableLayers(boolean flag)
    {
        int i = getChildCount();
        int j = 0;
        while (j < i) 
        {
            byte byte0;
            if (flag)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            af.a(getChildAt(j), byte0, null);
            j++;
        }
    }

    private void endDrag()
    {
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view)
    {
        Rect rect1;
        if (rect == null)
        {
            rect1 = new Rect();
        } else
        {
            rect1 = rect;
        }
        if (view == null)
        {
            rect1.set(0, 0, 0, 0);
            return rect1;
        }
        rect1.left = view.getLeft();
        rect1.right = view.getRight();
        rect1.top = view.getTop();
        rect1.bottom = view.getBottom();
        ViewGroup viewgroup;
        for (ViewParent viewparent = view.getParent(); (viewparent instanceof ViewGroup) && viewparent != this; viewparent = viewgroup.getParent())
        {
            viewgroup = (ViewGroup)viewparent;
            rect1.left = rect1.left + viewgroup.getLeft();
            rect1.right = rect1.right + viewgroup.getRight();
            rect1.top = rect1.top + viewgroup.getTop();
            rect1.bottom = rect1.bottom + viewgroup.getBottom();
        }

        return rect1;
    }

    private int getClientWidth()
    {
        return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    }

    private ax infoForCurrentScrollPosition()
    {
        int i = getClientWidth();
        float f;
        float f1;
        float f2;
        float f3;
        int j;
        int l;
        boolean flag;
        ax ax1;
        if (i > 0)
        {
            f = (float)getScrollX() / (float)i;
        } else
        {
            f = 0.0F;
        }
        if (i > 0)
        {
            f1 = (float)mPageMargin / (float)i;
        } else
        {
            f1 = 0.0F;
        }
        f2 = 0.0F;
        f3 = 0.0F;
        j = -1;
        l = 0;
        flag = true;
        ax1 = null;
        do
        {
label0:
            {
                if (l < mItems.size())
                {
                    ax ax2 = (ax)mItems.get(l);
                    int i1;
                    ax ax3;
                    float f4;
                    float f5;
                    int j1;
                    float f6;
                    int k1;
                    if (!flag && ax2.b != j + 1)
                    {
                        ax ax4 = mTempItem;
                        ax4.e = f1 + (f2 + f3);
                        ax4.b = j + 1;
                        ax4.d = mAdapter.getPageWidth(ax4.b);
                        i1 = l - 1;
                        ax3 = ax4;
                    } else
                    {
                        i1 = l;
                        ax3 = ax2;
                    }
                    f4 = ax3.e;
                    f5 = f1 + (f4 + ax3.d);
                    if (flag || f >= f4)
                    {
                        if (f >= f5 && i1 != -1 + mItems.size())
                        {
                            break label0;
                        }
                        ax1 = ax3;
                    }
                }
                return ax1;
            }
            j1 = ax3.b;
            f6 = ax3.d;
            k1 = i1 + 1;
            f3 = f4;
            j = j1;
            f2 = f6;
            ax1 = ax3;
            l = k1;
            flag = false;
        } while (true);
    }

    private boolean isGutterDrag(float f, float f1)
    {
        return f < (float)mGutterSize && f1 > 0.0F || f > (float)(getWidth() - mGutterSize) && f1 < 0.0F;
    }

    private void onSecondaryPointerUp(MotionEvent motionevent)
    {
        int i = w.b(motionevent);
        if (w.b(motionevent, i) == mActivePointerId)
        {
            int j;
            if (i == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            mLastMotionX = w.c(motionevent, j);
            mActivePointerId = w.b(motionevent, j);
            if (mVelocityTracker != null)
            {
                mVelocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i)
    {
        boolean flag;
        if (mItems.size() == 0)
        {
            mCalledSuper = false;
            onPageScrolled(0, 0.0F, 0);
            boolean flag1 = mCalledSuper;
            flag = false;
            if (!flag1)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
        } else
        {
            ax ax1 = infoForCurrentScrollPosition();
            int j = getClientWidth();
            int l = j + mPageMargin;
            float f = (float)mPageMargin / (float)j;
            int i1 = ax1.b;
            float f1 = ((float)i / (float)j - ax1.e) / (f + ax1.d);
            int j1 = (int)(f1 * (float)l);
            mCalledSuper = false;
            onPageScrolled(i1, f1, j1);
            if (!mCalledSuper)
            {
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            flag = true;
        }
        return flag;
    }

    private boolean performDrag(float f)
    {
        boolean flag = true;
        float f1 = mLastMotionX - f;
        mLastMotionX = f;
        float f2 = f1 + (float)getScrollX();
        int i = getClientWidth();
        float f3 = (float)i * mFirstOffset;
        float f4 = (float)i * mLastOffset;
        ax ax1 = (ax)mItems.get(0);
        ax ax2 = (ax)mItems.get(-1 + mItems.size());
        boolean flag1;
        float f5;
        boolean flag2;
        if (ax1.b != 0)
        {
            f3 = ax1.e * (float)i;
            flag1 = false;
        } else
        {
            flag1 = flag;
        }
        if (ax2.b != -1 + mAdapter.getCount())
        {
            f5 = ax2.e * (float)i;
            flag = false;
        } else
        {
            f5 = f4;
        }
        if (f2 < f3)
        {
            flag2 = false;
            if (flag1)
            {
                float f6 = f3 - f2;
                flag2 = mLeftEdge.a(Math.abs(f6) / (float)i);
            }
        } else
        if (f2 > f5)
        {
            flag2 = false;
            if (flag)
            {
                float f7 = f2 - f5;
                flag2 = mRightEdge.a(Math.abs(f7) / (float)i);
            }
            f3 = f5;
        } else
        {
            f3 = f2;
            flag2 = false;
        }
        mLastMotionX = mLastMotionX + (f3 - (float)(int)f3);
        scrollTo((int)f3, getScrollY());
        pageScrolled((int)f3);
        return flag2;
    }

    private void recomputeScrollPosition(int i, int j, int l, int i1)
    {
        if (j > 0 && !mItems.isEmpty())
        {
            int k1 = l + (i - getPaddingLeft() - getPaddingRight());
            int l1 = i1 + (j - getPaddingLeft() - getPaddingRight());
            int i2 = (int)(((float)getScrollX() / (float)l1) * (float)k1);
            scrollTo(i2, getScrollY());
            if (!mScroller.isFinished())
            {
                int j2 = mScroller.getDuration() - mScroller.timePassed();
                ax ax2 = infoForPosition(mCurItem);
                mScroller.startScroll(i2, 0, (int)(ax2.e * (float)i), 0, j2);
            }
        } else
        {
            ax ax1 = infoForPosition(mCurItem);
            float f;
            int j1;
            if (ax1 != null)
            {
                f = Math.min(ax1.e, mLastOffset);
            } else
            {
                f = 0.0F;
            }
            j1 = (int)(f * (float)(i - getPaddingLeft() - getPaddingRight()));
            if (j1 != getScrollX())
            {
                completeScroll(false);
                scrollTo(j1, getScrollY());
                return;
            }
        }
    }

    private void removeNonDecorViews()
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            if (!((ay)getChildAt(i).getLayoutParams()).a)
            {
                removeViewAt(i);
                i--;
            }
        }

    }

    private void requestParentDisallowInterceptTouchEvent(boolean flag)
    {
        ViewParent viewparent = getParent();
        if (viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(flag);
        }
    }

    private void scrollToItem(int i, boolean flag, int j, boolean flag1)
    {
        ax ax1 = infoForPosition(i);
        int l;
        if (ax1 != null)
        {
            l = (int)((float)getClientWidth() * Math.max(mFirstOffset, Math.min(ax1.e, mLastOffset)));
        } else
        {
            l = 0;
        }
        if (flag)
        {
            smoothScrollTo(l, 0, j);
            if (flag1 && mOnPageChangeListener != null)
            {
                mOnPageChangeListener.a(i);
            }
            if (flag1 && mInternalPageChangeListener != null)
            {
                mInternalPageChangeListener.a(i);
            }
            return;
        }
        if (flag1 && mOnPageChangeListener != null)
        {
            mOnPageChangeListener.a(i);
        }
        if (flag1 && mInternalPageChangeListener != null)
        {
            mInternalPageChangeListener.a(i);
        }
        completeScroll(false);
        scrollTo(l, 0);
        pageScrolled(l);
    }

    private void setScrollState(int i)
    {
        if (mScrollState != i)
        {
            mScrollState = i;
            if (mPageTransformer != null)
            {
                boolean flag;
                if (i != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                enableLayers(flag);
            }
            if (mOnPageChangeListener != null)
            {
                mOnPageChangeListener.b(i);
                return;
            }
        }
    }

    private void setScrollingCacheEnabled(boolean flag)
    {
        if (mScrollingCacheEnabled != flag)
        {
            mScrollingCacheEnabled = flag;
        }
    }

    private void sortChildDrawingOrder()
    {
        if (mDrawingOrder != 0)
        {
            int i;
            if (mDrawingOrderedChildren == null)
            {
                mDrawingOrderedChildren = new ArrayList();
            } else
            {
                mDrawingOrderedChildren.clear();
            }
            i = getChildCount();
            for (int j = 0; j < i; j++)
            {
                View view = getChildAt(j);
                mDrawingOrderedChildren.add(view);
            }

            Collections.sort(mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList arraylist, int i, int j)
    {
        int l = arraylist.size();
        int i1 = getDescendantFocusability();
        if (i1 != 0x60000)
        {
            for (int j1 = 0; j1 < getChildCount(); j1++)
            {
                View view = getChildAt(j1);
                if (view.getVisibility() == 0)
                {
                    ax ax1 = infoForChild(view);
                    if (ax1 != null && ax1.b == mCurItem)
                    {
                        view.addFocusables(arraylist, i, j);
                    }
                }
            }

        }
        while (i1 == 0x40000 && l != arraylist.size() || !isFocusable() || (j & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode() || arraylist == null) 
        {
            return;
        }
        arraylist.add(this);
    }

    ax addNewItem(int i, int j)
    {
        ax ax1 = new ax();
        ax1.b = i;
        ax1.a = mAdapter.instantiateItem(this, i);
        ax1.d = mAdapter.getPageWidth(i);
        if (j < 0 || j >= mItems.size())
        {
            mItems.add(ax1);
            return ax1;
        } else
        {
            mItems.add(j, ax1);
            return ax1;
        }
    }

    public void addTouchables(ArrayList arraylist)
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ax ax1 = infoForChild(view);
            if (ax1 != null && ax1.b == mCurItem)
            {
                view.addTouchables(arraylist);
            }
        }

    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.view.ViewGroup.LayoutParams layoutparams1;
        ay ay1;
        if (!checkLayoutParams(layoutparams))
        {
            layoutparams1 = generateLayoutParams(layoutparams);
        } else
        {
            layoutparams1 = layoutparams;
        }
        ay1 = (ay)layoutparams1;
        ay1.a = ay1.a | (view instanceof aw);
        if (mInLayout)
        {
            if (ay1 != null && ay1.a)
            {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else
            {
                ay1.d = true;
                addViewInLayout(view, i, layoutparams1);
                return;
            }
        } else
        {
            super.addView(view, i, layoutparams1);
            return;
        }
    }

    public boolean arrowScroll(int i)
    {
        View view = findFocus();
        if (view != this) goto _L2; else goto _L1
_L1:
        View view1 = null;
_L13:
        View view2 = FocusFinder.getInstance().findNextFocus(this, view1, i);
        if (view2 == null || view2 == view1) goto _L4; else goto _L3
_L3:
        if (i != 17) goto _L6; else goto _L5
_L5:
        boolean flag;
        boolean flag1;
        int i1 = getChildRectInPagerCoordinates(mTempRect, view2).left;
        int j1 = getChildRectInPagerCoordinates(mTempRect, view1).left;
        ViewParent viewparent;
        StringBuilder stringbuilder;
        ViewParent viewparent1;
        if (view1 != null && i1 >= j1)
        {
            flag = pageLeft();
        } else
        {
            flag = view2.requestFocus();
        }
_L18:
        if (flag)
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return flag;
_L2:
        if (view == null) goto _L8; else goto _L7
_L7:
        viewparent = view.getParent();
_L12:
        if (!(viewparent instanceof ViewGroup))
        {
            break MISSING_BLOCK_LABEL_363;
        }
        if (viewparent != this) goto _L10; else goto _L9
_L9:
        flag1 = true;
_L19:
        if (flag1) goto _L8; else goto _L11
_L10:
        viewparent = viewparent.getParent();
          goto _L12
_L11:
        stringbuilder = new StringBuilder();
        stringbuilder.append(view.getClass().getSimpleName());
        for (viewparent1 = view.getParent(); viewparent1 instanceof ViewGroup; viewparent1 = viewparent1.getParent())
        {
            stringbuilder.append(" => ").append(viewparent1.getClass().getSimpleName());
        }

        Log.e("ViewPager", (new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ")).append(stringbuilder.toString()).toString());
        view1 = null;
          goto _L13
_L6:
        if (i != 66) goto _L15; else goto _L14
_L14:
        int j;
        int l;
        j = getChildRectInPagerCoordinates(mTempRect, view2).left;
        l = getChildRectInPagerCoordinates(mTempRect, view1).left;
        if (view1 != null && j <= l) goto _L17; else goto _L16
_L16:
        flag = view2.requestFocus();
          goto _L18
_L4:
label0:
        {
            if (i != 17 && i != 1)
            {
                break label0;
            }
            flag = pageLeft();
        }
          goto _L18
        if (i != 66 && i != 2) goto _L15; else goto _L17
_L17:
        flag = pageRight();
          goto _L18
_L15:
        flag = false;
          goto _L18
_L8:
        view1 = view;
          goto _L13
        flag1 = false;
          goto _L19
    }

    public boolean beginFakeDrag()
    {
        if (mIsBeingDragged)
        {
            return false;
        }
        mFakeDragging = true;
        setScrollState(1);
        mLastMotionX = 0.0F;
        mInitialMotionX = 0.0F;
        long l;
        MotionEvent motionevent;
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        } else
        {
            mVelocityTracker.clear();
        }
        l = SystemClock.uptimeMillis();
        motionevent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
        mVelocityTracker.addMovement(motionevent);
        motionevent.recycle();
        mFakeDragBeginTime = l;
        return true;
    }

    protected boolean canScroll(View view, boolean flag, int i, int j, int l)
    {
        if (!(view instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        int i1;
        int j1;
        int k1;
        viewgroup = (ViewGroup)view;
        i1 = view.getScrollX();
        j1 = view.getScrollY();
        k1 = -1 + viewgroup.getChildCount();
_L8:
        if (k1 < 0) goto _L2; else goto _L3
_L3:
        View view1 = viewgroup.getChildAt(k1);
        if (j + i1 < view1.getLeft() || j + i1 >= view1.getRight() || l + j1 < view1.getTop() || l + j1 >= view1.getBottom() || !canScroll(view1, true, i, (j + i1) - view1.getLeft(), (l + j1) - view1.getTop())) goto _L5; else goto _L4
_L4:
        return true;
_L5:
        k1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag && af.a(view, -i)) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean canScrollHorizontally(int i)
    {
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j;
        int l;
        j = getClientWidth();
        l = getScrollX();
        if (i >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l <= (int)((float)j * mFirstOffset)) goto _L1; else goto _L3
_L3:
        return true;
        if (i <= 0 || l >= (int)((float)j * mLastOffset)) goto _L1; else goto _L4
_L4:
        return true;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof ay) && super.checkLayoutParams(layoutparams);
    }

    public void computeScroll()
    {
        if (!mScroller.isFinished() && mScroller.computeScrollOffset())
        {
            int i = getScrollX();
            int j = getScrollY();
            int l = mScroller.getCurrX();
            int i1 = mScroller.getCurrY();
            if (i != l || j != i1)
            {
                scrollTo(l, i1);
                if (!pageScrolled(l))
                {
                    mScroller.abortAnimation();
                    scrollTo(0, i1);
                }
            }
            af.b(this);
            return;
        } else
        {
            completeScroll(true);
            return;
        }
    }

    void dataSetChanged()
    {
        boolean flag1;
        int l;
        boolean flag2;
        int i1;
        ax ax1;
        int l1;
        int i = mAdapter.getCount();
        mExpectedAdapterCount = i;
        boolean flag;
        int j;
        int k2;
        int i3;
        if (mItems.size() < 1 + 2 * mOffscreenPageLimit && mItems.size() < i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = mCurItem;
        flag1 = false;
        l = j;
        flag2 = flag;
        i1 = 0;
        if (i1 >= mItems.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ax1 = (ax)mItems.get(i1);
        l1 = mAdapter.getItemPosition(ax1.a);
        if (l1 == -1)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        if (l1 == -2)
        {
            mItems.remove(i1);
            int l2 = i1 - 1;
            if (!flag1)
            {
                mAdapter.startUpdate(this);
                flag1 = true;
            }
            mAdapter.destroyItem(this, ax1.b, ax1.a);
            int j1;
            int k1;
            ay ay1;
            int i2;
            boolean flag3;
            int j2;
            boolean flag4;
            if (mCurItem == ax1.b)
            {
                i3 = Math.max(0, Math.min(mCurItem, i - 1));
                i2 = l2;
                flag3 = flag1;
                j2 = i3;
                flag4 = true;
            } else
            {
                i2 = l2;
                flag3 = flag1;
                j2 = l;
                flag4 = true;
            }
        } else
        {
            if (ax1.b == l1)
            {
                break MISSING_BLOCK_LABEL_379;
            }
            if (ax1.b == mCurItem)
            {
                l = l1;
            }
            ax1.b = l1;
            i2 = i1;
            flag3 = flag1;
            j2 = l;
            flag4 = true;
        }
        k2 = i2 + 1;
        flag2 = flag4;
        l = j2;
        flag1 = flag3;
        i1 = k2;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_61;
_L1:
        if (flag1)
        {
            mAdapter.finishUpdate(this);
        }
        Collections.sort(mItems, COMPARATOR);
        if (flag2)
        {
            j1 = getChildCount();
            for (k1 = 0; k1 < j1; k1++)
            {
                ay1 = (ay)getChildAt(k1).getLayoutParams();
                if (!ay1.a)
                {
                    ay1.c = 0.0F;
                }
            }

            setCurrentItemInternal(l, false, true);
            requestLayout();
        }
        return;
        i2 = i1;
        flag3 = flag1;
        j2 = l;
        flag4 = flag2;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_207;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return super.dispatchKeyEvent(keyevent) || executeKeyEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        if (accessibilityevent.getEventType() != 4096) goto _L2; else goto _L1
_L1:
        boolean flag = super.dispatchPopulateAccessibilityEvent(accessibilityevent);
_L4:
        return flag;
_L2:
        int i = getChildCount();
        int j = 0;
        do
        {
            flag = false;
            if (j >= i)
            {
                continue;
            }
            View view = getChildAt(j);
            if (view.getVisibility() == 0)
            {
                ax ax1 = infoForChild(view);
                if (ax1 != null && ax1.b == mCurItem && view.dispatchPopulateAccessibilityEvent(accessibilityevent))
                {
                    return true;
                }
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    float distanceInfluenceForSnapDuration(float f)
    {
        return (float)Math.sin((float)(0.4712389167638204D * (double)(f - 0.5F)));
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int i = af.a(this);
        boolean flag1;
        if (i == 0 || i == 1 && mAdapter != null && mAdapter.getCount() > 1)
        {
            boolean flag = mLeftEdge.a();
            flag1 = false;
            if (!flag)
            {
                int j1 = canvas.save();
                int k1 = getHeight() - getPaddingTop() - getPaddingBottom();
                int l1 = getWidth();
                canvas.rotate(270F);
                canvas.translate(-k1 + getPaddingTop(), mFirstOffset * (float)l1);
                mLeftEdge.a(k1, l1);
                flag1 = false | mLeftEdge.a(canvas);
                canvas.restoreToCount(j1);
            }
            if (!mRightEdge.a())
            {
                int j = canvas.save();
                int l = getWidth();
                int i1 = getHeight() - getPaddingTop() - getPaddingBottom();
                canvas.rotate(90F);
                canvas.translate(-getPaddingTop(), -(1.0F + mLastOffset) * (float)l);
                mRightEdge.a(i1, l);
                flag1 |= mRightEdge.a(canvas);
                canvas.restoreToCount(j);
            }
        } else
        {
            mLeftEdge.b();
            mRightEdge.b();
            flag1 = false;
        }
        if (flag1)
        {
            af.b(this);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = mMarginDrawable;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag()
    {
        if (!mFakeDragging)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else
        {
            VelocityTracker velocitytracker = mVelocityTracker;
            velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int i = (int)ab.a(velocitytracker, mActivePointerId);
            mPopulatePending = true;
            int j = getClientWidth();
            int l = getScrollX();
            ax ax1 = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(ax1.b, ((float)l / (float)j - ax1.e) / ax1.d, i, (int)(mLastMotionX - mInitialMotionX)), true, true, i);
            endDrag();
            mFakeDragging = false;
            return;
        }
    }

    public boolean executeKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        keyevent.getKeyCode();
        JVM INSTR lookupswitch 3: default 44
    //                   21: 46
    //                   22: 53
    //                   61: 60;
           goto _L2 _L3 _L4 _L5
_L2:
        return false;
_L3:
        return arrowScroll(17);
_L4:
        return arrowScroll(66);
_L5:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            if (r.b(keyevent))
            {
                return arrowScroll(2);
            }
            if (r.a(keyevent))
            {
                return arrowScroll(1);
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void fakeDragBy(float f)
    {
        if (!mFakeDragging)
        {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        mLastMotionX = f + mLastMotionX;
        float f1 = (float)getScrollX() - f;
        int i = getClientWidth();
        float f2 = (float)i * mFirstOffset;
        float f3 = (float)i * mLastOffset;
        ax ax1 = (ax)mItems.get(0);
        ax ax2 = (ax)mItems.get(-1 + mItems.size());
        float f4;
        float f5;
        long l;
        MotionEvent motionevent;
        if (ax1.b != 0)
        {
            f4 = ax1.e * (float)i;
        } else
        {
            f4 = f2;
        }
        if (ax2.b != -1 + mAdapter.getCount())
        {
            f5 = ax2.e * (float)i;
        } else
        {
            f5 = f3;
        }
        if (f1 >= f4)
        {
            if (f1 > f5)
            {
                f4 = f5;
            } else
            {
                f4 = f1;
            }
        }
        mLastMotionX = mLastMotionX + (f4 - (float)(int)f4);
        scrollTo((int)f4, getScrollY());
        pageScrolled((int)f4);
        l = SystemClock.uptimeMillis();
        motionevent = MotionEvent.obtain(mFakeDragBeginTime, l, 2, mLastMotionX, 0.0F, 0);
        mVelocityTracker.addMovement(motionevent);
        motionevent.recycle();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new ay();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new ay(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateDefaultLayoutParams();
    }

    public aa getAdapter()
    {
        return mAdapter;
    }

    protected int getChildDrawingOrder(int i, int j)
    {
        if (mDrawingOrder == 2)
        {
            j = i - 1 - j;
        }
        return ((ay)((View)mDrawingOrderedChildren.get(j)).getLayoutParams()).f;
    }

    public int getCurrentItem()
    {
        return mCurItem;
    }

    public int getOffscreenPageLimit()
    {
        return mOffscreenPageLimit;
    }

    public int getPageMargin()
    {
        return mPageMargin;
    }

    ax infoForAnyChild(View view)
    {
        do
        {
            ViewParent viewparent = view.getParent();
            if (viewparent != this)
            {
                if (viewparent == null || !(viewparent instanceof View))
                {
                    return null;
                }
                view = (View)viewparent;
            } else
            {
                return infoForChild(view);
            }
        } while (true);
    }

    ax infoForChild(View view)
    {
        for (int i = 0; i < mItems.size(); i++)
        {
            ax ax1 = (ax)mItems.get(i);
            if (mAdapter.isViewFromObject(view, ax1.a))
            {
                return ax1;
            }
        }

        return null;
    }

    ax infoForPosition(int i)
    {
        for (int j = 0; j < mItems.size(); j++)
        {
            ax ax1 = (ax)mItems.get(j);
            if (ax1.b == i)
            {
                return ax1;
            }
        }

        return null;
    }

    void initViewPager()
    {
        setWillNotDraw(false);
        setDescendantFocusability(0x40000);
        setFocusable(true);
        Context context = getContext();
        mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        mTouchSlop = ap.a(viewconfiguration);
        mMinimumVelocity = (int)(400F * f);
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
        mLeftEdge = new k(context);
        mRightEdge = new k(context);
        mFlingDistance = (int)(25F * f);
        mCloseEnough = (int)(2.0F * f);
        mDefaultGutterSize = (int)(16F * f);
        af.a(this, new az(this));
        if (af.c(this) == 0)
        {
            af.b(this, 1);
        }
    }

    public boolean isFakeDragging()
    {
        return mFakeDragging;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }

    protected void onDetachedFromWindow()
    {
        removeCallbacks(mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mPageMargin > 0 && mMarginDrawable != null && mItems.size() > 0 && mAdapter != null)
        {
            int i = getScrollX();
            int j = getWidth();
            float f = (float)mPageMargin / (float)j;
            ax ax1 = (ax)mItems.get(0);
            float f1 = ax1.e;
            int l = mItems.size();
            int i1 = ax1.b;
            int j1 = ((ax)mItems.get(l - 1)).b;
            int k1 = 0;
            int l1 = i1;
            do
            {
                if (l1 >= j1)
                {
                    break;
                }
                ArrayList arraylist;
                for (; l1 > ax1.b && k1 < l; ax1 = (ax)arraylist.get(k1))
                {
                    arraylist = mItems;
                    k1++;
                }

                float f3;
                if (l1 == ax1.b)
                {
                    f3 = (ax1.e + ax1.d) * (float)j;
                    f1 = f + (ax1.e + ax1.d);
                } else
                {
                    float f2 = mAdapter.getPageWidth(l1);
                    f3 = (f1 + f2) * (float)j;
                    f1 += f2 + f;
                }
                if (f3 + (float)mPageMargin > (float)i)
                {
                    mMarginDrawable.setBounds((int)f3, mTopPageBounds, (int)(0.5F + (f3 + (float)mPageMargin)), mBottomPageBounds);
                    mMarginDrawable.draw(canvas);
                }
                if (f3 > (float)(i + j))
                {
                    break;
                }
                l1++;
            } while (true);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = 0xff & motionevent.getAction();
        if (i != 3 && i != 1) goto _L2; else goto _L1
_L1:
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        mActivePointerId = -1;
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
_L4:
        return false;
_L2:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (mIsBeingDragged)
        {
            return true;
        }
        if (mIsUnableToDrag) goto _L4; else goto _L3
_L3:
        i;
        JVM INSTR lookupswitch 3: default 112
    //                   0: 391
    //                   2: 139
    //                   6: 526;
           goto _L5 _L6 _L7 _L8
_L5:
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        return mIsBeingDragged;
_L7:
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int j = mActivePointerId;
        if (j == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        int l = w.a(motionevent, j);
        f2 = w.c(motionevent, l);
        f3 = f2 - mLastMotionX;
        f4 = Math.abs(f3);
        f5 = w.d(motionevent, l);
        f6 = Math.abs(f5 - mInitialMotionY);
        if (f3 != 0.0F && !isGutterDrag(mLastMotionX, f3) && canScroll(this, false, (int)f3, (int)f2, (int)f5))
        {
            mLastMotionX = f2;
            mLastMotionY = f5;
            mIsUnableToDrag = true;
            return false;
        }
        if (f4 <= (float)mTouchSlop || 0.5F * f4 <= f6) goto _L10; else goto _L9
_L9:
        mIsBeingDragged = true;
        requestParentDisallowInterceptTouchEvent(true);
        setScrollState(1);
        float f7;
        if (f3 > 0.0F)
        {
            f7 = mInitialMotionX + (float)mTouchSlop;
        } else
        {
            f7 = mInitialMotionX - (float)mTouchSlop;
        }
        mLastMotionX = f7;
        mLastMotionY = f5;
        setScrollingCacheEnabled(true);
_L11:
        if (mIsBeingDragged && performDrag(f2))
        {
            af.b(this);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (f6 > (float)mTouchSlop)
        {
            mIsUnableToDrag = true;
        }
        if (true) goto _L11; else goto _L6
_L6:
        float f = motionevent.getX();
        mInitialMotionX = f;
        mLastMotionX = f;
        float f1 = motionevent.getY();
        mInitialMotionY = f1;
        mLastMotionY = f1;
        mActivePointerId = w.b(motionevent, 0);
        mIsUnableToDrag = false;
        mScroller.computeScrollOffset();
        if (mScrollState == 2 && Math.abs(mScroller.getFinalX() - mScroller.getCurrX()) > mCloseEnough)
        {
            mScroller.abortAnimation();
            mPopulatePending = false;
            populate();
            mIsBeingDragged = true;
            requestParentDisallowInterceptTouchEvent(true);
            setScrollState(1);
        } else
        {
            completeScroll(false);
            mIsBeingDragged = false;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        onSecondaryPointerUp(motionevent);
        if (true) goto _L5; else goto _L12
_L12:
    }

    protected void onLayout(boolean flag, int i, int j, int l, int i1)
    {
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        j1 = getChildCount();
        k1 = l - i;
        l1 = i1 - j;
        i2 = getPaddingLeft();
        j2 = getPaddingTop();
        k2 = getPaddingRight();
        l2 = getPaddingBottom();
        i3 = getScrollX();
        j3 = 0;
        k3 = 0;
_L14:
        if (k3 >= j1) goto _L2; else goto _L1
_L1:
        View view1 = getChildAt(k3);
        if (view1.getVisibility() == 8) goto _L4; else goto _L3
_L3:
        ay ay2 = (ay)view1.getLayoutParams();
        if (!ay2.a) goto _L4; else goto _L5
_L5:
        int k5;
        int l5;
        k5 = 7 & ay2.b;
        l5 = 0x70 & ay2.b;
        k5;
        JVM INSTR tableswitch 1 5: default 152
    //                   1 305
    //                   2 152
    //                   3 284
    //                   4 152
    //                   5 325;
           goto _L6 _L7 _L6 _L8 _L6 _L9
_L6:
        int j6 = i2;
_L15:
        l5;
        JVM INSTR lookupswitch 3: default 192
    //                   16: 384
    //                   48: 355
    //                   80: 416;
           goto _L10 _L11 _L12 _L13
_L10:
        int k6;
        int i7;
        int j7;
        k6 = j2;
        int k8 = l2;
        i7 = j2;
        j7 = k8;
_L16:
        int k4;
        int l4;
        int i5;
        int j5;
        int k7 = j6 + i3;
        view1.layout(k7, k6, k7 + view1.getMeasuredWidth(), k6 + view1.getMeasuredHeight());
        k4 = j3 + 1;
        l4 = i7;
        l2 = j7;
        i5 = k2;
        j5 = i2;
_L17:
        k3++;
        i2 = j5;
        k2 = i5;
        j2 = l4;
        j3 = k4;
          goto _L14
_L8:
        int l8 = i2 + view1.getMeasuredWidth();
        j6 = i2;
        i2 = l8;
          goto _L15
_L7:
        j6 = Math.max((k1 - view1.getMeasuredWidth()) / 2, i2);
          goto _L15
_L9:
        int i6 = k1 - k2 - view1.getMeasuredWidth();
        k2 += view1.getMeasuredWidth();
        j6 = i6;
          goto _L15
_L12:
        int i8 = j2 + view1.getMeasuredHeight();
        int j8 = j2;
        j7 = l2;
        i7 = i8;
        k6 = j8;
          goto _L16
_L11:
        k6 = Math.max((l1 - view1.getMeasuredHeight()) / 2, j2);
        int l7 = l2;
        i7 = j2;
        j7 = l7;
          goto _L16
_L13:
        k6 = l1 - l2 - view1.getMeasuredHeight();
        int l6 = l2 + view1.getMeasuredHeight();
        i7 = j2;
        j7 = l6;
          goto _L16
_L2:
        int l3 = k1 - i2 - k2;
        for (int i4 = 0; i4 < j1; i4++)
        {
            View view = getChildAt(i4);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            ay ay1 = (ay)view.getLayoutParams();
            if (ay1.a)
            {
                continue;
            }
            ax ax1 = infoForChild(view);
            if (ax1 == null)
            {
                continue;
            }
            int j4 = i2 + (int)((float)l3 * ax1.e);
            if (ay1.d)
            {
                ay1.d = false;
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)l3 * ay1.c), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(l1 - j2 - l2, 0x40000000));
            }
            view.layout(j4, j2, j4 + view.getMeasuredWidth(), j2 + view.getMeasuredHeight());
        }

        mTopPageBounds = j2;
        mBottomPageBounds = l1 - l2;
        mDecorChildCount = j3;
        if (mFirstLayout)
        {
            scrollToItem(mCurItem, false, 0, false);
        }
        mFirstLayout = false;
        return;
_L4:
        k4 = j3;
        l4 = j2;
        i5 = k2;
        j5 = i2;
          goto _L17
    }

    protected void onMeasure(int i, int j)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, j));
        int l = getMeasuredWidth();
        mGutterSize = Math.min(l / 10, mDefaultGutterSize);
        i1 = l - getPaddingLeft() - getPaddingRight();
        j1 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        k1 = getChildCount();
        l1 = 0;
_L3:
        if (l1 >= k1) goto _L2; else goto _L1
_L1:
        View view1 = getChildAt(l1);
        if (view1.getVisibility() == 8)
        {
            continue; /* Loop/switch isn't completed */
        }
        ay ay2 = (ay)view1.getLayoutParams();
        if (ay2 == null || !ay2.a)
        {
            continue; /* Loop/switch isn't completed */
        }
        int k2 = 7 & ay2.b;
        int l2 = 0x70 & ay2.b;
        int i3 = 0x80000000;
        int j3 = 0x80000000;
        boolean flag;
        boolean flag1;
        int k3;
        int l3;
        if (l2 == 48 || l2 == 80)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k2 == 3 || k2 == 5)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag)
        {
            i3 = 0x40000000;
        } else
        if (flag1)
        {
            j3 = 0x40000000;
        }
        if (ay2.width != -2)
        {
            k3 = 0x40000000;
            int i2;
            int j2;
            View view;
            ay ay1;
            int i4;
            if (ay2.width != -1)
            {
                l3 = ay2.width;
            } else
            {
                l3 = i1;
            }
        } else
        {
            k3 = i3;
            l3 = i1;
        }
        if (ay2.height == -2)
        {
            break MISSING_BLOCK_LABEL_464;
        }
        j3 = 0x40000000;
        if (ay2.height == -1)
        {
            break MISSING_BLOCK_LABEL_464;
        }
        i4 = ay2.height;
        view1.measure(android.view.View.MeasureSpec.makeMeasureSpec(l3, k3), android.view.View.MeasureSpec.makeMeasureSpec(i4, j3));
        if (flag)
        {
            j1 -= view1.getMeasuredHeight();
        } else
        if (flag1)
        {
            i1 -= view1.getMeasuredWidth();
        }
        l1++;
          goto _L3
_L2:
        mChildWidthMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
        mChildHeightMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x40000000);
        mInLayout = true;
        populate();
        mInLayout = false;
        i2 = getChildCount();
        for (j2 = 0; j2 < i2; j2++)
        {
            view = getChildAt(j2);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            ay1 = (ay)view.getLayoutParams();
            if (ay1 == null || !ay1.a)
            {
                view.measure(android.view.View.MeasureSpec.makeMeasureSpec((int)((float)i1 * ay1.c), 0x40000000), mChildHeightMeasureSpec);
            }
        }

        return;
        i4 = j1;
        break MISSING_BLOCK_LABEL_254;
    }

    protected void onPageScrolled(int i, float f, int j)
    {
        if (mDecorChildCount <= 0) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        j1 = getScrollX();
        k1 = getPaddingLeft();
        l1 = getPaddingRight();
        i2 = getWidth();
        j2 = getChildCount();
        k2 = 0;
_L8:
        if (k2 >= j2) goto _L2; else goto _L3
_L3:
        View view1;
        ay ay1;
        view1 = getChildAt(k2);
        ay1 = (ay)view1.getLayoutParams();
        if (!ay1.a)
        {
            break MISSING_BLOCK_LABEL_386;
        }
        7 & ay1.b;
        JVM INSTR tableswitch 1 5: default 116
    //                   1 204
    //                   2 116
    //                   3 175
    //                   4 116
    //                   5 236;
           goto _L4 _L5 _L4 _L6 _L4 _L7
_L4:
        int i3;
        int j3;
        int l3;
        l3 = k1;
        int j5 = l1;
        i3 = k1;
        j3 = j5;
_L9:
        int j4 = (l3 + j1) - view1.getLeft();
        if (j4 != 0)
        {
            view1.offsetLeftAndRight(j4);
        }
_L10:
        k2++;
        int k3 = j3;
        k1 = i3;
        l1 = k3;
          goto _L8
_L6:
        int l4 = k1 + view1.getWidth();
        int i5 = k1;
        j3 = l1;
        i3 = l4;
        l3 = i5;
          goto _L9
_L5:
        l3 = Math.max((i2 - view1.getMeasuredWidth()) / 2, k1);
        int k4 = l1;
        i3 = k1;
        j3 = k4;
          goto _L9
_L7:
        l3 = i2 - l1 - view1.getMeasuredWidth();
        int i4 = l1 + view1.getMeasuredWidth();
        i3 = k1;
        j3 = i4;
          goto _L9
_L2:
        if (mOnPageChangeListener != null)
        {
            mOnPageChangeListener.a(i, f, j);
        }
        if (mInternalPageChangeListener != null)
        {
            mInternalPageChangeListener.a(i, f, j);
        }
        if (mPageTransformer != null)
        {
            getScrollX();
            int l = getChildCount();
            for (int i1 = 0; i1 < l; i1++)
            {
                View view = getChildAt(i1);
                if (!((ay)view.getLayoutParams()).a)
                {
                    view.getLeft();
                    getClientWidth();
                    mPageTransformer;
                }
            }

        }
        mCalledSuper = true;
        return;
        int l2 = l1;
        i3 = k1;
        j3 = l2;
          goto _L10
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect)
    {
        byte byte0 = -1;
        int j = getChildCount();
        int l;
        if ((i & 2) != 0)
        {
            byte0 = 1;
            l = 0;
        } else
        {
            l = j - 1;
            j = byte0;
        }
        for (; l != j; l += byte0)
        {
            View view = getChildAt(l);
            if (view.getVisibility() != 0)
            {
                continue;
            }
            ax ax1 = infoForChild(view);
            if (ax1 != null && ax1.b == mCurItem && view.requestFocus(i, rect))
            {
                return true;
            }
        }

        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (mAdapter != null)
        {
            mAdapter.restoreState(savedstate.b, savedstate.c);
            setCurrentItemInternal(savedstate.a, false, true);
            return;
        } else
        {
            mRestoredCurItem = savedstate.a;
            mRestoredAdapterState = savedstate.b;
            mRestoredClassLoader = savedstate.c;
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = mCurItem;
        if (mAdapter != null)
        {
            savedstate.b = mAdapter.saveState();
        }
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int l, int i1)
    {
        super.onSizeChanged(i, j, l, i1);
        if (i != l)
        {
            recomputeScrollPosition(i, l, mPageMargin, mPageMargin);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        boolean flag;
        if (mFakeDragging)
        {
            return true;
        }
        if (motionevent.getAction() == 0 && motionevent.getEdgeFlags() != 0)
        {
            return false;
        }
        if (mAdapter == null || mAdapter.getCount() == 0)
        {
            return false;
        }
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        i = 0xff & motionevent.getAction();
        flag = false;
        i;
        JVM INSTR tableswitch 0 6: default 120
    //                   0 130
    //                   1 397
    //                   2 196
    //                   3 548
    //                   4 120
    //                   5 600
    //                   6 631;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        if (flag)
        {
            android.support.v4.view.af.b(this);
        }
        return true;
_L2:
        mScroller.abortAnimation();
        mPopulatePending = false;
        populate();
        float f5 = motionevent.getX();
        mInitialMotionX = f5;
        mLastMotionX = f5;
        float f6 = motionevent.getY();
        mInitialMotionY = f6;
        mLastMotionY = f6;
        mActivePointerId = android.support.v4.view.w.b(motionevent, 0);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!mIsBeingDragged)
        {
            int k1 = w.a(motionevent, mActivePointerId);
            float f = w.c(motionevent, k1);
            float f1 = Math.abs(f - mLastMotionX);
            float f2 = android.support.v4.view.w.d(motionevent, k1);
            float f3 = Math.abs(f2 - mLastMotionY);
            if (f1 > (float)mTouchSlop && f1 > f3)
            {
                mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                boolean flag3;
                float f4;
                ViewParent viewparent;
                if (f - mInitialMotionX > 0.0F)
                {
                    f4 = mInitialMotionX + (float)mTouchSlop;
                } else
                {
                    f4 = mInitialMotionX - (float)mTouchSlop;
                }
                mLastMotionX = f4;
                mLastMotionY = f2;
                setScrollState(1);
                setScrollingCacheEnabled(true);
                viewparent = getParent();
                if (viewparent != null)
                {
                    viewparent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        flag3 = mIsBeingDragged;
        flag = false;
        if (flag3)
        {
            flag = false | performDrag(w.c(motionevent, w.a(motionevent, mActivePointerId)));
        }
        continue; /* Loop/switch isn't completed */
_L3:
        boolean flag2 = mIsBeingDragged;
        flag = false;
        if (flag2)
        {
            VelocityTracker velocitytracker = mVelocityTracker;
            velocitytracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int l = (int)ab.a(velocitytracker, mActivePointerId);
            mPopulatePending = true;
            int i1 = getClientWidth();
            int j1 = getScrollX();
            ax ax1 = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(ax1.b, ((float)j1 / (float)i1 - ax1.e) / ax1.d, l, (int)(w.c(motionevent, w.a(motionevent, mActivePointerId)) - mInitialMotionX)), true, true, l);
            mActivePointerId = -1;
            endDrag();
            flag = mLeftEdge.c() | mRightEdge.c();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        boolean flag1 = mIsBeingDragged;
        flag = false;
        if (flag1)
        {
            scrollToItem(mCurItem, true, 0, false);
            mActivePointerId = -1;
            endDrag();
            flag = mLeftEdge.c() | mRightEdge.c();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        int j = android.support.v4.view.w.b(motionevent);
        mLastMotionX = w.c(motionevent, j);
        mActivePointerId = android.support.v4.view.w.b(motionevent, j);
        flag = false;
        continue; /* Loop/switch isn't completed */
_L7:
        onSecondaryPointerUp(motionevent);
        mLastMotionX = w.c(motionevent, w.a(motionevent, mActivePointerId));
        flag = false;
        if (true) goto _L1; else goto _L8
_L8:
    }

    boolean pageLeft()
    {
        if (mCurItem > 0)
        {
            setCurrentItem(-1 + mCurItem, true);
            return true;
        } else
        {
            return false;
        }
    }

    boolean pageRight()
    {
        if (mAdapter != null && mCurItem < -1 + mAdapter.getCount())
        {
            setCurrentItem(1 + mCurItem, true);
            return true;
        } else
        {
            return false;
        }
    }

    void populate()
    {
        populate(mCurItem);
    }

    void populate(int i)
    {
        byte byte0;
        ax ax1;
        int l;
        int i1;
        int j1;
        int k1;
        ax ax2;
        ax ax3;
        ax ax7;
        int i3;
        float f1;
        int k3;
        int l3;
        int i4;
        android.content.res.Resources.NotFoundException notfoundexception;
        String s;
        String s1;
        if (mCurItem != i)
        {
            byte byte1;
            ax ax16;
            if (mCurItem < i)
            {
                byte1 = 66;
            } else
            {
                byte1 = 17;
            }
            ax16 = infoForPosition(mCurItem);
            mCurItem = i;
            ax1 = ax16;
            byte0 = byte1;
        } else
        {
            byte0 = 2;
            ax1 = null;
        }
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        sortChildDrawingOrder();
_L4:
        return;
_L2:
        if (mPopulatePending)
        {
            sortChildDrawingOrder();
            return;
        }
        if (getWindowToken() == null) goto _L4; else goto _L3
_L3:
        mAdapter.startUpdate(this);
        int j = mOffscreenPageLimit;
        l = Math.max(0, mCurItem - j);
        i1 = mAdapter.getCount();
        j1 = Math.min(i1 - 1, j + mCurItem);
        if (i1 == mExpectedAdapterCount) goto _L6; else goto _L5
_L5:
        s1 = getResources().getResourceName(getId());
        s = s1;
_L7:
        throw new IllegalStateException((new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ")).append(mExpectedAdapterCount).append(", found: ").append(i1).append(" Pager id: ").append(s).append(" Pager class: ").append(getClass()).append(" Problematic adapter: ").append(mAdapter.getClass()).toString());
        notfoundexception;
        s = Integer.toHexString(getId());
        if (true) goto _L7; else goto _L6
_L6:
        k1 = 0;
_L17:
        if (k1 >= mItems.size())
        {
            break MISSING_BLOCK_LABEL_1295;
        }
        ax2 = (ax)mItems.get(k1);
        if (ax2.b < mCurItem) goto _L9; else goto _L8
_L8:
        if (ax2.b != mCurItem)
        {
            break MISSING_BLOCK_LABEL_1295;
        }
_L24:
        if (ax2 == null && i1 > 0)
        {
            ax3 = addNewItem(mCurItem, k1);
        } else
        {
            ax3 = ax2;
        }
        if (ax3 == null) goto _L11; else goto _L10
_L10:
        int l2 = k1 - 1;
        float f;
        int j3;
        if (l2 >= 0)
        {
            ax7 = (ax)mItems.get(l2);
        } else
        {
            ax7 = null;
        }
        i3 = getClientWidth();
        if (i3 <= 0)
        {
            f = 0.0F;
        } else
        {
            f = (2.0F - ax3.d) + (float)getPaddingLeft() / (float)i3;
        }
        j3 = -1 + mCurItem;
        f1 = 0.0F;
        k3 = j3;
        l3 = k1;
        i4 = l2;
        if (k3 < 0) goto _L13; else goto _L12
_L12:
        if (f1 < f || k3 >= l) goto _L15; else goto _L14
_L14:
        if (ax7 == null) goto _L13; else goto _L16
_L16:
        if (k3 == ax7.b && !ax7.c)
        {
            mItems.remove(i4);
            mAdapter.destroyItem(this, k3, ax7.a);
            i4--;
            l3--;
            if (i4 >= 0)
            {
                ax7 = (ax)mItems.get(i4);
            } else
            {
                ax7 = null;
            }
        }
_L18:
        k3--;
        break MISSING_BLOCK_LABEL_392;
_L9:
        k1++;
          goto _L17
_L15:
        if (ax7 != null && k3 == ax7.b)
        {
            f1 += ax7.d;
            if (--i4 >= 0)
            {
                ax7 = (ax)mItems.get(i4);
            } else
            {
                ax7 = null;
            }
        } else
        {
            f1 += addNewItem(k3, i4 + 1).d;
            l3++;
            if (i4 >= 0)
            {
                ax7 = (ax)mItems.get(i4);
            } else
            {
                ax7 = null;
            }
        }
          goto _L18
_L13:
        float f2 = ax3.d;
        int j4 = l3 + 1;
        if (f2 >= 2.0F)
        {
            break MISSING_BLOCK_LABEL_1005;
        }
        ax ax8;
        float f3;
        int k4;
        ax ax9;
        int l4;
        int i5;
        ax ax10;
        if (j4 < mItems.size())
        {
            ax8 = (ax)mItems.get(j4);
        } else
        {
            ax8 = null;
        }
        if (i3 <= 0)
        {
            f3 = 0.0F;
        } else
        {
            f3 = 2.0F + (float)getPaddingRight() / (float)i3;
        }
        k4 = 1 + mCurItem;
        ax9 = ax8;
        l4 = j4;
        i5 = k4;
        ax10 = ax9;
        do
        {
            if (i5 >= i1)
            {
                break MISSING_BLOCK_LABEL_1005;
            }
            if (f2 >= f3 && i5 > j1)
            {
                if (ax10 == null)
                {
                    break MISSING_BLOCK_LABEL_1005;
                }
                aa aa1;
                int l1;
                Object obj;
                int i2;
                int j2;
                View view;
                ax ax4;
                int k2;
                View view1;
                ax ax5;
                View view2;
                ay ay1;
                ax ax6;
                ax ax11;
                float f4;
                ax ax12;
                ax ax13;
                float f5;
                float f7;
                ax ax14;
                if (i5 == ax10.b && !ax10.c)
                {
                    mItems.remove(l4);
                    mAdapter.destroyItem(this, i5, ax10.a);
                    float f6;
                    ax ax15;
                    float f9;
                    if (l4 < mItems.size())
                    {
                        ax15 = (ax)mItems.get(l4);
                    } else
                    {
                        ax15 = null;
                    }
                    f9 = f2;
                    ax13 = ax15;
                    f5 = f9;
                } else
                {
                    float f8 = f2;
                    ax13 = ax10;
                    f5 = f8;
                }
            } else
            if (ax10 != null && i5 == ax10.b)
            {
                f7 = f2 + ax10.d;
                if (++l4 < mItems.size())
                {
                    ax14 = (ax)mItems.get(l4);
                } else
                {
                    ax14 = null;
                }
                ax13 = ax14;
                f5 = f7;
            } else
            {
                ax11 = addNewItem(i5, l4);
                l4++;
                f4 = f2 + ax11.d;
                if (l4 < mItems.size())
                {
                    ax12 = (ax)mItems.get(l4);
                } else
                {
                    ax12 = null;
                }
                ax13 = ax12;
                f5 = f4;
            }
            i5++;
            f6 = f5;
            ax10 = ax13;
            f2 = f6;
        } while (true);
          goto _L17
        calculatePageOffsets(ax3, l3, ax1);
_L11:
        aa1 = mAdapter;
        l1 = mCurItem;
        if (ax3 != null)
        {
            obj = ax3.a;
        } else
        {
            obj = null;
        }
        aa1.setPrimaryItem(this, l1, obj);
        mAdapter.finishUpdate(this);
        i2 = getChildCount();
        for (j2 = 0; j2 < i2; j2++)
        {
            view2 = getChildAt(j2);
            ay1 = (ay)view2.getLayoutParams();
            ay1.f = j2;
            if (ay1.a || ay1.c != 0.0F)
            {
                continue;
            }
            ax6 = infoForChild(view2);
            if (ax6 != null)
            {
                ay1.c = ax6.d;
                ay1.e = ax6.b;
            }
        }

        sortChildDrawingOrder();
        if (!hasFocus()) goto _L4; else goto _L19
_L19:
        view = findFocus();
        if (view != null)
        {
            ax4 = infoForAnyChild(view);
        } else
        {
            ax4 = null;
        }
        if (ax4 != null && ax4.b == mCurItem) goto _L4; else goto _L20
_L20:
        k2 = 0;
_L23:
        if (k2 >= getChildCount()) goto _L4; else goto _L21
_L21:
        view1 = getChildAt(k2);
        ax5 = infoForChild(view1);
        if (ax5 != null && ax5.b == mCurItem && view1.requestFocus(byte0)) goto _L4; else goto _L22
_L22:
        k2++;
          goto _L23
        ax2 = null;
          goto _L24
    }

    public void removeView(View view)
    {
        if (mInLayout)
        {
            removeViewInLayout(view);
            return;
        } else
        {
            super.removeView(view);
            return;
        }
    }

    public void setAdapter(aa aa1)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mObserver);
            mAdapter.startUpdate(this);
            for (int i = 0; i < mItems.size(); i++)
            {
                ax ax1 = (ax)mItems.get(i);
                mAdapter.destroyItem(this, ax1.b, ax1.a);
            }

            mAdapter.finishUpdate(this);
            mItems.clear();
            removeNonDecorViews();
            mCurItem = 0;
            scrollTo(0, 0);
        }
        aa aa2 = mAdapter;
        mAdapter = aa1;
        mExpectedAdapterCount = 0;
        if (mAdapter != null)
        {
            if (mObserver == null)
            {
                mObserver = new bd(this, (byte)0);
            }
            mAdapter.registerDataSetObserver(mObserver);
            mPopulatePending = false;
            boolean flag = mFirstLayout;
            mFirstLayout = true;
            mExpectedAdapterCount = mAdapter.getCount();
            if (mRestoredCurItem >= 0)
            {
                mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            } else
            if (!flag)
            {
                populate();
            } else
            {
                requestLayout();
            }
        }
        if (mAdapterChangeListener != null && aa2 != aa1)
        {
            ba _tmp = mAdapterChangeListener;
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean flag)
    {
        if (android.os.Build.VERSION.SDK_INT < 7)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        Method method;
        Object aobj[];
        if (mSetChildrenDrawingOrderEnabled == null)
        {
            try
            {
                Class aclass[] = new Class[1];
                aclass[0] = Boolean.TYPE;
                mSetChildrenDrawingOrderEnabled = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", aclass);
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", nosuchmethodexception);
            }
        }
        method = mSetChildrenDrawingOrderEnabled;
        aobj = new Object[1];
        aobj[0] = Boolean.valueOf(flag);
        method.invoke(this, aobj);
        return;
        Exception exception;
        exception;
        Log.e("ViewPager", "Error changing children drawing order", exception);
        return;
    }

    public void setCurrentItem(int i)
    {
        mPopulatePending = false;
        boolean flag;
        if (!mFirstLayout)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setCurrentItemInternal(i, flag, false);
    }

    public void setCurrentItem(int i, boolean flag)
    {
        mPopulatePending = false;
        setCurrentItemInternal(i, flag, false);
    }

    void setCurrentItemInternal(int i, boolean flag, boolean flag1)
    {
        setCurrentItemInternal(i, flag, flag1, 0);
    }

    void setCurrentItemInternal(int i, boolean flag, boolean flag1, int j)
    {
        if (mAdapter == null || mAdapter.getCount() <= 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!flag1 && mCurItem == i && mItems.size() != 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i >= 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        int l = mOffscreenPageLimit;
        if (i > l + mCurItem || i < mCurItem - l)
        {
            for (int i1 = 0; i1 < mItems.size(); i1++)
            {
                ((ax)mItems.get(i1)).c = true;
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (i >= mAdapter.getCount())
        {
            i = -1 + mAdapter.getCount();
        }
        if (true) goto _L4; else goto _L3
_L3:
        int j1 = mCurItem;
        boolean flag2 = false;
        if (j1 != i)
        {
            flag2 = true;
        }
        if (mFirstLayout)
        {
            mCurItem = i;
            if (flag2 && mOnPageChangeListener != null)
            {
                mOnPageChangeListener.a(i);
            }
            if (flag2 && mInternalPageChangeListener != null)
            {
                mInternalPageChangeListener.a(i);
            }
            requestLayout();
            return;
        } else
        {
            populate(i);
            scrollToItem(i, flag, j, flag2);
            return;
        }
    }

    bb setInternalPageChangeListener(bb bb1)
    {
        bb bb2 = mInternalPageChangeListener;
        mInternalPageChangeListener = bb1;
        return bb2;
    }

    public void setOffscreenPageLimit(int i)
    {
        if (i <= 0)
        {
            Log.w("ViewPager", (new StringBuilder("Requested offscreen page limit ")).append(i).append(" too small; defaulting to 1").toString());
            i = 1;
        }
        if (i != mOffscreenPageLimit)
        {
            mOffscreenPageLimit = i;
            populate();
        }
    }

    void setOnAdapterChangeListener(ba ba)
    {
        mAdapterChangeListener = ba;
    }

    public void setOnPageChangeListener(bb bb1)
    {
        mOnPageChangeListener = bb1;
    }

    public void setPageMargin(int i)
    {
        int j = mPageMargin;
        mPageMargin = i;
        int l = getWidth();
        recomputeScrollPosition(l, l, i, j);
        requestLayout();
    }

    public void setPageMarginDrawable(int i)
    {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable)
    {
        mMarginDrawable = drawable;
        if (drawable != null)
        {
            refreshDrawableState();
        }
        boolean flag;
        if (drawable == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        invalidate();
    }

    public void setPageTransformer(boolean flag, bc bc)
    {
        int i = 1;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            boolean flag1;
            int j;
            int l;
            if (bc != null)
            {
                flag1 = i;
            } else
            {
                flag1 = false;
            }
            if (mPageTransformer != null)
            {
                j = i;
            } else
            {
                j = 0;
            }
            if (flag1 != j)
            {
                l = i;
            } else
            {
                l = 0;
            }
            mPageTransformer = bc;
            setChildrenDrawingOrderEnabledCompat(flag1);
            if (flag1)
            {
                if (flag)
                {
                    i = 2;
                }
                mDrawingOrder = i;
            } else
            {
                mDrawingOrder = 0;
            }
            if (l != 0)
            {
                populate();
            }
        }
    }

    void smoothScrollTo(int i, int j)
    {
        smoothScrollTo(i, j, 0);
    }

    void smoothScrollTo(int i, int j, int l)
    {
        if (getChildCount() == 0)
        {
            setScrollingCacheEnabled(false);
            return;
        }
        int i1 = getScrollX();
        int j1 = getScrollY();
        int k1 = i - i1;
        int l1 = j - j1;
        if (k1 == 0 && l1 == 0)
        {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int i2 = getClientWidth();
        int j2 = i2 / 2;
        float f = Math.min(1.0F, (1.0F * (float)Math.abs(k1)) / (float)i2);
        float f1 = (float)j2 + (float)j2 * distanceInfluenceForSnapDuration(f);
        int k2 = Math.abs(l);
        int l2;
        int i3;
        if (k2 > 0)
        {
            l2 = 4 * Math.round(1000F * Math.abs(f1 / (float)k2));
        } else
        {
            float f2 = (float)i2 * mAdapter.getPageWidth(mCurItem);
            l2 = (int)(100F * (1.0F + (float)Math.abs(k1) / (f2 + (float)mPageMargin)));
        }
        i3 = Math.min(l2, 600);
        mScroller.startScroll(i1, j1, k1, l1, i3);
        android.support.v4.view.af.b(this);
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == mMarginDrawable;
    }






    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR;
        int a;
        Parcelable b;
        ClassLoader c;

        public String toString()
        {
            return (new StringBuilder("FragmentPager.SavedState{")).append(Integer.toHexString(System.identityHashCode(this))).append(" position=").append(a).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(a);
            parcel.writeParcelable(b, i);
        }

        static 
        {
            be be1 = new be();
            if (android.os.Build.VERSION.SDK_INT >= 13)
            {
                new d(be1);
            }
            CREATOR = new b(be1);
        }

        SavedState(Parcel parcel, ClassLoader classloader)
        {
            super(parcel);
            if (classloader == null)
            {
                classloader = getClass().getClassLoader();
            }
            a = parcel.readInt();
            b = parcel.readParcelable(classloader);
            c = classloader;
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
