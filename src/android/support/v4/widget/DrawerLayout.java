// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.af;
import android.support.v4.view.n;
import android.support.v4.view.r;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.widget:
//            z, h, j, g, 
//            f

public final class DrawerLayout extends ViewGroup
{

    private static final int a[] = {
        0x10100b3
    };
    private final f b;
    private int c;
    private int d;
    private float e;
    private Paint f;
    private final z g;
    private final z h;
    private final j i;
    private final j j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private g r;
    private float s;
    private float t;
    private Drawable u;
    private Drawable v;

    private void a(int i1, int j1)
    {
        int k1;
        k1 = android.support.v4.view.n.a(j1, af.e(this));
        if (k1 == 3)
        {
            n = i1;
        } else
        if (k1 == 5)
        {
            o = i1;
        }
        if (i1 != 0)
        {
            z z1;
            if (k1 == 3)
            {
                z1 = g;
            } else
            {
                z1 = h;
            }
            z1.e();
        }
        i1;
        JVM INSTR tableswitch 1 2: default 64
    //                   1 106
    //                   2 87;
           goto _L1 _L2 _L3
_L1:
        View view1;
        return;
_L3:
        View view;
        if ((view1 = a(k1)) != null)
        {
            h(view1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ((view = a(k1)) != null)
        {
            d(view);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void a(boolean flag)
    {
        int i1 = getChildCount();
        int j1 = 0;
        boolean flag1 = false;
        while (j1 < i1) 
        {
            View view = getChildAt(j1);
            h h1 = (h)view.getLayoutParams();
            if (c(view) && (!flag || h1.c))
            {
                int k1 = view.getWidth();
                if (a(view, 3))
                {
                    flag1 |= g.a(view, -k1, view.getTop());
                } else
                {
                    flag1 |= h.a(view, getWidth(), view.getTop());
                }
                h1.c = false;
            }
            j1++;
        }
        i.a();
        j.a();
        if (flag1)
        {
            invalidate();
        }
    }

    static float b(View view)
    {
        return ((h)view.getLayoutParams()).b;
    }

    private static String b(int i1)
    {
        if ((i1 & 3) == 3)
        {
            return "LEFT";
        }
        if ((i1 & 5) == 5)
        {
            return "RIGHT";
        } else
        {
            return Integer.toHexString(i1);
        }
    }

    static boolean c(View view)
    {
        return (7 & android.support.v4.view.n.a(((h)view.getLayoutParams()).a, af.e(view))) != 0;
    }

    static boolean e(View view)
    {
        return af.c(view) != 4 && af.c(view) != 2;
    }

    static int[] e()
    {
        return a;
    }

    private int f(View view)
    {
        return android.support.v4.view.n.a(((h)view.getLayoutParams()).a, af.e(this));
    }

    private View f()
    {
        int i1 = getChildCount();
        for (int j1 = 0; j1 < i1; j1++)
        {
            View view = getChildAt(j1);
            if (c(view) && i(view))
            {
                return view;
            }
        }

        return null;
    }

    private static boolean g(View view)
    {
        return ((h)view.getLayoutParams()).a == 0;
    }

    private void h(View view)
    {
        if (!c(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a sliding drawer").toString());
        }
        if (m)
        {
            h h1 = (h)view.getLayoutParams();
            h1.b = 1.0F;
            h1.d = true;
        } else
        if (a(view, 3))
        {
            g.a(view, 0, view.getTop());
        } else
        {
            h.a(view, getWidth() - view.getWidth(), view.getTop());
        }
        invalidate();
    }

    private static boolean i(View view)
    {
        if (!c(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a drawer").toString());
        }
        return ((h)view.getLayoutParams()).b > 0.0F;
    }

    public final int a(View view)
    {
        int i1 = f(view);
        if (i1 == 3)
        {
            return n;
        }
        if (i1 == 5)
        {
            return o;
        } else
        {
            return 0;
        }
    }

    final View a(int i1)
    {
        int j1 = 7 & android.support.v4.view.n.a(i1, af.e(this));
        int k1 = getChildCount();
        for (int l1 = 0; l1 < k1; l1++)
        {
            View view = getChildAt(l1);
            if ((7 & f(view)) == j1)
            {
                return view;
            }
        }

        return null;
    }

    public final void a()
    {
        View view = a(0x800003);
        if (view == null)
        {
            throw new IllegalArgumentException((new StringBuilder("No drawer view found with gravity ")).append(b(0x800003)).toString());
        } else
        {
            h(view);
            return;
        }
    }

    final void a(int i1, View view)
    {
        h h1;
        int j1 = g.a();
        int k1 = h.a();
        int l1;
        h h3;
        View view2;
        View view3;
        if (j1 == 1 || k1 == 1)
        {
            l1 = 1;
        } else
        if (j1 == 2 || k1 == 2)
        {
            l1 = 2;
        } else
        {
            l1 = 0;
        }
        if (view == null || i1 != 0) goto _L2; else goto _L1
_L1:
        h1 = (h)view.getLayoutParams();
        if (h1.b != 0.0F) goto _L4; else goto _L3
_L3:
        h3 = (h)view.getLayoutParams();
        if (h3.d)
        {
            h3.d = false;
            if (r != null)
            {
                r.onDrawerClosed(view);
            }
            view2 = getChildAt(0);
            if (view2 != null)
            {
                af.b(view2, 1);
            }
            af.b(view, 4);
            if (hasWindowFocus())
            {
                view3 = getRootView();
                if (view3 != null)
                {
                    view3.sendAccessibilityEvent(32);
                }
            }
        }
_L2:
        if (l1 != k)
        {
            k = l1;
            if (r != null)
            {
                r.onDrawerStateChanged(l1);
            }
        }
        return;
_L4:
        if (h1.b == 1.0F)
        {
            h h2 = (h)view.getLayoutParams();
            if (!h2.d)
            {
                h2.d = true;
                if (r != null)
                {
                    r.onDrawerOpened(view);
                }
                View view1 = getChildAt(0);
                if (view1 != null)
                {
                    af.b(view1, 4);
                }
                af.b(view, 1);
                sendAccessibilityEvent(32);
                view.requestFocus();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    final void a(View view, float f1)
    {
        h h1 = (h)view.getLayoutParams();
        if (f1 != h1.b)
        {
            h1.b = f1;
            if (r != null)
            {
                r.onDrawerSlide(view, f1);
                return;
            }
        }
    }

    final boolean a(View view, int i1)
    {
        return (i1 & f(view)) == i1;
    }

    public final void addView(View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (i1 > 0 || i1 < 0 && getChildCount() > 0)
        {
            af.b(view, 4);
            af.a(view, b);
        } else
        {
            af.b(view, 1);
        }
        super.addView(view, i1, layoutparams);
    }

    public final void b()
    {
        View view = a(0x800003);
        if (view == null)
        {
            throw new IllegalArgumentException((new StringBuilder("No drawer view found with gravity ")).append(b(0x800003)).toString());
        } else
        {
            d(view);
            return;
        }
    }

    public final boolean c()
    {
        View view = a(0x800003);
        if (view != null)
        {
            if (!c(view))
            {
                throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a drawer").toString());
            } else
            {
                return ((h)view.getLayoutParams()).d;
            }
        } else
        {
            return false;
        }
    }

    protected final boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof h) && super.checkLayoutParams(layoutparams);
    }

    public final void computeScroll()
    {
        int i1 = getChildCount();
        float f1 = 0.0F;
        for (int j1 = 0; j1 < i1; j1++)
        {
            f1 = Math.max(f1, ((h)getChildAt(j1).getLayoutParams()).b);
        }

        e = f1;
        if (g.g() | h.g())
        {
            af.b(this);
        }
    }

    public final void d(View view)
    {
        if (!c(view))
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a sliding drawer").toString());
        }
        if (m)
        {
            h h1 = (h)view.getLayoutParams();
            h1.b = 0.0F;
            h1.d = false;
        } else
        if (a(view, 3))
        {
            g.a(view, -view.getWidth(), view.getTop());
        } else
        {
            h.a(view, getWidth(), view.getTop());
        }
        invalidate();
    }

    public final boolean d()
    {
        View view = a(0x800003);
        if (view != null)
        {
            return i(view);
        } else
        {
            return false;
        }
    }

    protected final boolean drawChild(Canvas canvas, View view, long l1)
    {
        int i1 = getHeight();
        boolean flag = g(view);
        int j1 = getWidth();
        int k1 = canvas.save();
        int i2 = 0;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        int k4 = getChildCount();
        int l4 = 0;
        do
        {
label0:
            {
                {
                    if (l4 >= k4)
                    {
                        break MISSING_BLOCK_LABEL_192;
                    }
                    View view1 = getChildAt(l4);
                    if (view1 == view || view1.getVisibility() != 0)
                    {
                        break MISSING_BLOCK_LABEL_185;
                    }
                    Drawable drawable = view1.getBackground();
                    int i5;
                    boolean flag2;
                    int j5;
                    if (drawable != null)
                    {
                        if (drawable.getOpacity() == -1)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                    } else
                    {
                        flag2 = false;
                    }
                    if (!flag2 || !c(view1) || view1.getHeight() < i1)
                    {
                        break MISSING_BLOCK_LABEL_185;
                    }
                    if (!a(view1, 3))
                    {
                        break label0;
                    }
                    j5 = view1.getRight();
                    int j2;
                    boolean flag1;
                    int k2;
                    int l2;
                    int i3;
                    int j3;
                    float f1;
                    int k3;
                    int l3;
                    int i4;
                    float f2;
                    int j4;
                    if (j5 <= i2)
                    {
                        j5 = i2;
                    }
                    i2 = j5;
                    i5 = j1;
                }
                l4++;
                j1 = i5;
            }
        } while (true);
        i5 = view1.getLeft();
        if (i5 < j1)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        i5 = j1;
        break MISSING_BLOCK_LABEL_149;
        canvas.clipRect(i2, 0, j1, getHeight());
        j2 = j1;
        flag1 = super.drawChild(canvas, view, l1);
        canvas.restoreToCount(k1);
        if (e > 0.0F && flag)
        {
            j4 = (int)((float)((0xff000000 & d) >>> 24) * e) << 24 | 0xffffff & d;
            f.setColor(j4);
            canvas.drawRect(i2, 0.0F, j2, getHeight(), f);
        } else
        {
            if (u != null && a(view, 3))
            {
                k3 = u.getIntrinsicWidth();
                l3 = view.getRight();
                i4 = g.b();
                f2 = Math.max(0.0F, Math.min((float)l3 / (float)i4, 1.0F));
                u.setBounds(l3, view.getTop(), k3 + l3, view.getBottom());
                u.setAlpha((int)(255F * f2));
                u.draw(canvas);
                return flag1;
            }
            if (v != null && a(view, 5))
            {
                k2 = v.getIntrinsicWidth();
                l2 = view.getLeft();
                i3 = getWidth() - l2;
                j3 = h.b();
                f1 = Math.max(0.0F, Math.min((float)i3 / (float)j3, 1.0F));
                v.setBounds(l2 - k2, view.getTop(), l2, view.getBottom());
                v.setAlpha((int)(255F * f1));
                v.draw(canvas);
                return flag1;
            }
        }
        return flag1;
    }

    protected final android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new h();
    }

    public final android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new h(getContext(), attributeset);
    }

    protected final android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof h)
        {
            return new h((h)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new h((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new h(layoutparams);
        }
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        m = true;
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        m = true;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        boolean flag;
        i1 = w.a(motionevent);
        flag = g.a(motionevent) | h.a(motionevent);
        i1;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 130
    //                   1 228
    //                   2 198
    //                   3 228;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        boolean flag1 = false;
_L13:
        if (flag || flag1) goto _L6; else goto _L5
_L5:
        int j1;
        int k1;
        j1 = getChildCount();
        k1 = 0;
_L15:
        if (k1 >= j1) goto _L8; else goto _L7
_L7:
        if (!((h)getChildAt(k1).getLayoutParams()).c) goto _L10; else goto _L9
_L9:
        boolean flag3 = true;
_L16:
        if (flag3) goto _L6; else goto _L11
_L11:
        boolean flag2;
        boolean flag4;
        flag4 = q;
        flag2 = false;
        if (!flag4) goto _L12; else goto _L6
_L6:
        flag2 = true;
_L12:
        return flag2;
_L2:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        s = f1;
        t = f2;
        if (e > 0.0F && g(g.b((int)f1, (int)f2)))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        p = false;
        q = false;
          goto _L13
_L4:
        if (!g.h()) goto _L1; else goto _L14
_L14:
        i.a();
        j.a();
        flag1 = false;
          goto _L13
_L3:
        a(true);
        p = false;
        q = false;
          goto _L1
_L10:
        k1++;
          goto _L15
_L8:
        flag3 = false;
          goto _L16
    }

    public final boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            boolean flag;
            if (f() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                android.support.v4.view.r.c(keyevent);
                return true;
            }
        }
        return super.onKeyDown(i1, keyevent);
    }

    public final boolean onKeyUp(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            View view = f();
            if (view != null && a(view) == 0)
            {
                a(false);
            }
            boolean flag = false;
            if (view != null)
            {
                flag = true;
            }
            return flag;
        } else
        {
            return super.onKeyUp(i1, keyevent);
        }
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int i2;
        int j2;
        int k2;
        l = true;
        i2 = k1 - i1;
        j2 = getChildCount();
        k2 = 0;
_L2:
        View view;
        h h1;
        if (k2 >= j2)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        view = getChildAt(k2);
        if (view.getVisibility() != 8)
        {
            h1 = (h)view.getLayoutParams();
            if (!g(view))
            {
                break; /* Loop/switch isn't completed */
            }
            view.layout(h1.leftMargin, h1.topMargin, h1.leftMargin + view.getMeasuredWidth(), h1.topMargin + view.getMeasuredHeight());
        }
_L6:
        k2++;
        if (true) goto _L2; else goto _L1
_L1:
        int l2;
        int i3;
        int j3;
        l2 = view.getMeasuredWidth();
        i3 = view.getMeasuredHeight();
        float f1;
        boolean flag1;
        if (a(view, 3))
        {
            j3 = -l2 + (int)((float)l2 * h1.b);
            f1 = (float)(l2 + j3) / (float)l2;
        } else
        {
            j3 = i2 - (int)((float)l2 * h1.b);
            f1 = (float)(i2 - j3) / (float)l2;
        }
        if (f1 != h1.b)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        0x70 & h1.a;
        JVM INSTR lookupswitch 2: default 208
    //                   16: 358
    //                   80: 315;
           goto _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_358;
_L3:
        view.layout(j3, h1.topMargin, l2 + j3, i3 + h1.topMargin);
_L7:
        if (flag1)
        {
            a(view, f1);
        }
        int k3;
        int l3;
        int i4;
        int j4;
        if (h1.b > 0.0F)
        {
            i4 = 0;
        } else
        {
            i4 = 4;
        }
        if (view.getVisibility() != i4)
        {
            view.setVisibility(i4);
        }
          goto _L6
_L5:
        j4 = l1 - j1;
        view.layout(j3, j4 - h1.bottomMargin - view.getMeasuredHeight(), l2 + j3, j4 - h1.bottomMargin);
          goto _L7
        k3 = l1 - j1;
        l3 = (k3 - i3) / 2;
        if (l3 < h1.topMargin)
        {
            l3 = h1.topMargin;
        } else
        if (l3 + i3 > k3 - h1.bottomMargin)
        {
            l3 = k3 - h1.bottomMargin - i3;
        }
        view.layout(j3, l3, l2 + j3, i3 + l3);
          goto _L7
        l = false;
        m = false;
        return;
          goto _L6
    }

    protected final void onMeasure(int i1, int j1)
    {
_L2:
        setMeasuredDimension(j2, k1);
        int l2 = getChildCount();
        int i3 = 0;
        while (i3 < l2) 
        {
            View view = getChildAt(i3);
            if (view.getVisibility() != 8)
            {
                h h1 = (h)view.getLayoutParams();
                if (g(view))
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j2 - h1.leftMargin - h1.rightMargin, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(k1 - h1.topMargin - h1.bottomMargin, 0x40000000));
                } else
                if (c(view))
                {
                    int j3 = 7 & f(view);
                    if ((j3 & 0) != 0)
                    {
                        throw new IllegalStateException((new StringBuilder("Child drawer has absolute gravity ")).append(b(j3)).append(" but this DrawerLayout already has a drawer view along that edge").toString());
                    }
                    view.measure(getChildMeasureSpec(i1, c + h1.leftMargin + h1.rightMargin, h1.width), getChildMeasureSpec(j1, h1.topMargin + h1.bottomMargin, h1.height));
                } else
                {
                    throw new IllegalStateException((new StringBuilder("Child ")).append(view).append(" at index ").append(i3).append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY").toString());
                }
            }
            i3++;
        }
        return;
        int k1 = 300;
        int l1 = android.view.View.MeasureSpec.getMode(i1);
        int i2 = android.view.View.MeasureSpec.getMode(j1);
        int j2 = android.view.View.MeasureSpec.getSize(i1);
        int k2 = android.view.View.MeasureSpec.getSize(j1);
        if (l1 != 0x40000000 || i2 != 0x40000000)
        {
            if (isInEditMode())
            {
                if (l1 != 0x80000000 && l1 == 0)
                {
                    j2 = k1;
                }
                if (i2 != 0x80000000 && i2 == 0)
                {
                    break MISSING_BLOCK_LABEL_80;
                }
            } else
            {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        k1 = k2;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected final void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (savedstate.a != 0)
        {
            View view = a(savedstate.a);
            if (view != null)
            {
                h(view);
            }
        }
        a(savedstate.b, 3);
        a(savedstate.c, 5);
    }

    protected final Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        int i1 = getChildCount();
        int j1 = 0;
        do
        {
label0:
            {
                if (j1 < i1)
                {
                    View view = getChildAt(j1);
                    if (!c(view))
                    {
                        break label0;
                    }
                    h h1 = (h)view.getLayoutParams();
                    if (!h1.d)
                    {
                        break label0;
                    }
                    savedstate.a = h1.a;
                }
                savedstate.b = n;
                savedstate.c = o;
                return savedstate;
            }
            j1++;
        } while (true);
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        g.b(motionevent);
        h.b(motionevent);
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 56
    //                   0 58
    //                   1 94
    //                   2 56
    //                   3 267;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        return true;
_L2:
        float f5 = motionevent.getX();
        float f6 = motionevent.getY();
        s = f5;
        t = f6;
        p = false;
        q = false;
        return true;
_L3:
        int j1;
        int k1;
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        View view = g.b((int)f1, (int)f2);
        if (view == null || !g(view))
        {
            break MISSING_BLOCK_LABEL_284;
        }
        float f3 = f1 - s;
        float f4 = f2 - t;
        int i1 = g.d();
        if (f3 * f3 + f4 * f4 >= (float)(i1 * i1))
        {
            break MISSING_BLOCK_LABEL_284;
        }
        j1 = getChildCount();
        k1 = 0;
_L9:
        if (k1 >= j1) goto _L6; else goto _L5
_L5:
        View view2 = getChildAt(k1);
        if (!((h)view2.getLayoutParams()).d) goto _L8; else goto _L7
_L7:
        View view1 = view2;
_L10:
        boolean flag;
        if (view1 == null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        if (a(view1) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L11:
        a(flag);
        p = false;
        return true;
_L8:
        k1++;
          goto _L9
_L6:
        view1 = null;
          goto _L10
_L4:
        a(true);
        p = false;
        q = false;
        return true;
        flag = true;
          goto _L11
    }

    public final void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        p = flag;
        if (flag)
        {
            a(true);
        }
    }

    public final void requestLayout()
    {
        if (!l)
        {
            super.requestLayout();
        }
    }

    public final void setDrawerListener(g g1)
    {
        r = g1;
    }

    public final void setDrawerLockMode(int i1)
    {
        a(i1, 3);
        a(i1, 5);
    }

    public final void setScrimColor(int i1)
    {
        d = i1;
        invalidate();
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new i();
        int a;
        int b;
        int c;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = 0;
            b = 0;
            c = 0;
            a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
            a = 0;
            b = 0;
            c = 0;
        }
    }

}
