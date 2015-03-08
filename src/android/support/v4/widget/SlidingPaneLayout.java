// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.af;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.widget:
//            y, x, w, v, 
//            s, r, z, t

public final class SlidingPaneLayout extends ViewGroup
{

    static final v a;
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private final int f;
    private boolean g;
    private View h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private t p;
    private final z q;
    private boolean r;
    private boolean s;
    private final Rect t;
    private final ArrayList u;

    static ArrayList a(SlidingPaneLayout slidingpanelayout)
    {
        return slidingpanelayout.u;
    }

    static void a(SlidingPaneLayout slidingpanelayout, View view)
    {
        slidingpanelayout.a(view);
    }

    private void a(View view)
    {
        a.a(this, view);
    }

    private void a(View view, float f1, int i1)
    {
        s s1 = (s)view.getLayoutParams();
        if (f1 > 0.0F && i1 != 0)
        {
            int j1 = (int)(f1 * (float)((0xff000000 & i1) >>> 24)) << 24 | 0xffffff & i1;
            if (s1.d == null)
            {
                s1.d = new Paint();
            }
            s1.d.setColorFilter(new PorterDuffColorFilter(j1, android.graphics.PorterDuff.Mode.SRC_OVER));
            if (af.d(view) != 2)
            {
                af.a(view, 2, s1.d);
            }
            a(view);
        } else
        if (af.d(view) != 0)
        {
            if (s1.d != null)
            {
                s1.d.setColorFilter(null);
            }
            r r1 = new r(this, view);
            u.add(r1);
            af.a(this, r1);
            return;
        }
    }

    private boolean a()
    {
        boolean flag;
label0:
        {
            if (!s)
            {
                boolean flag1 = a(0.0F);
                flag = false;
                if (!flag1)
                {
                    break label0;
                }
            }
            r = false;
            flag = true;
        }
        return flag;
    }

    private boolean a(float f1)
    {
        if (!g)
        {
            return false;
        }
        boolean flag = b();
        s s1 = (s)h.getLayoutParams();
        int i1;
        if (flag)
        {
            int l1 = getPaddingRight() + s1.rightMargin;
            int i2 = h.getWidth();
            i1 = (int)((float)getWidth() - ((float)l1 + f1 * (float)k + (float)i2));
        } else
        {
            i1 = (int)((float)(getPaddingLeft() + s1.leftMargin) + f1 * (float)k);
        }
        if (q.a(h, i1, h.getTop()))
        {
            int j1 = getChildCount();
            for (int k1 = 0; k1 < j1; k1++)
            {
                View view = getChildAt(k1);
                if (view.getVisibility() == 4)
                {
                    view.setVisibility(0);
                }
            }

            af.b(this);
            return true;
        } else
        {
            return false;
        }
    }

    private boolean b()
    {
        return af.e(this) == 1;
    }

    private boolean b(View view)
    {
        if (view == null)
        {
            return false;
        }
        s s1 = (s)view.getLayoutParams();
        return g && s1.c && i > 0.0F;
    }

    protected final boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof s) && super.checkLayoutParams(layoutparams);
    }

    public final void computeScroll()
    {
label0:
        {
            if (q.g())
            {
                if (g)
                {
                    break label0;
                }
                q.f();
            }
            return;
        }
        af.b(this);
    }

    public final void draw(Canvas canvas)
    {
        super.draw(canvas);
        Drawable drawable;
        View view;
        if (b())
        {
            drawable = e;
        } else
        {
            drawable = d;
        }
        if (getChildCount() > 1)
        {
            view = getChildAt(1);
        } else
        {
            view = null;
        }
        if (view == null || drawable == null)
        {
            return;
        }
        int i1 = view.getTop();
        int j1 = view.getBottom();
        int k1 = drawable.getIntrinsicWidth();
        int l1;
        int i2;
        if (b())
        {
            i2 = view.getRight();
            l1 = i2 + k1;
        } else
        {
            l1 = view.getLeft();
            i2 = l1 - k1;
        }
        drawable.setBounds(i2, i1, l1, j1);
        drawable.draw(canvas);
    }

    protected final boolean drawChild(Canvas canvas, View view, long l1)
    {
        boolean flag;
        s s1 = (s)view.getLayoutParams();
        int i1 = canvas.save(2);
        if (g && !s1.b && h != null)
        {
            canvas.getClipBounds(t);
            android.graphics.Bitmap bitmap;
            if (b())
            {
                t.left = Math.max(t.left, h.getRight());
            } else
            {
                t.right = Math.min(t.right, h.getLeft());
            }
            canvas.clipRect(t);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11) goto _L2; else goto _L1
_L1:
        if (!s1.c || i <= 0.0F) goto _L4; else goto _L3
_L3:
        if (!view.isDrawingCacheEnabled())
        {
            view.setDrawingCacheEnabled(true);
        }
        bitmap = view.getDrawingCache();
        if (bitmap == null) goto _L6; else goto _L5
_L5:
        canvas.drawBitmap(bitmap, view.getLeft(), view.getTop(), s1.d);
        flag = false;
_L7:
        canvas.restoreToCount(i1);
        return flag;
_L6:
        Log.e("SlidingPaneLayout", (new StringBuilder("drawChild: child view ")).append(view).append(" returned null drawing cache").toString());
_L2:
        flag = super.drawChild(canvas, view, l1);
        if (true) goto _L7; else goto _L4
_L4:
        if (view.isDrawingCacheEnabled())
        {
            view.setDrawingCacheEnabled(false);
        }
          goto _L2
    }

    protected final android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new s();
    }

    public final android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new s(getContext(), attributeset);
    }

    protected final android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new s((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new s(layoutparams);
        }
    }

    public final int getCoveredFadeColor()
    {
        return c;
    }

    public final int getParallaxDistance()
    {
        return m;
    }

    public final int getSliderFadeColor()
    {
        return b;
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        s = true;
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        s = true;
        int i1 = u.size();
        for (int j1 = 0; j1 < i1; j1++)
        {
            ((r)u.get(j1)).run();
        }

        u.clear();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        boolean flag;
        i1 = w.a(motionevent);
        if (!g && i1 == 0 && getChildCount() > 1)
        {
            View view = getChildAt(1);
            if (view != null)
            {
                q;
                boolean flag2;
                if (!z.b(view, (int)motionevent.getX(), (int)motionevent.getY()))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                r = flag2;
            }
        }
        if (g && (!l || i1 == 0)) goto _L2; else goto _L1
_L1:
        q.e();
        flag = super.onInterceptTouchEvent(motionevent);
_L7:
        return flag;
_L2:
        if (i1 == 3 || i1 == 1)
        {
            q.e();
            return false;
        }
        i1;
        JVM INSTR tableswitch 0 2: default 152
    //                   0 175
    //                   1 152
    //                   2 242;
           goto _L3 _L4 _L3 _L5
_L3:
        boolean flag1 = false;
_L9:
        if (q.a(motionevent))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = false;
        if (!flag1) goto _L7; else goto _L6
_L6:
        return true;
_L4:
        float f5;
        float f6;
        l = false;
        f5 = motionevent.getX();
        f6 = motionevent.getY();
        n = f5;
        o = f6;
        q;
        if (!z.b(h, (int)f5, (int)f6) || !b(h)) goto _L3; else goto _L8
_L8:
        flag1 = true;
          goto _L9
_L5:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        float f3 = Math.abs(f1 - n);
        float f4 = Math.abs(f2 - o);
        if (f3 > (float)q.d() && f4 > f3)
        {
            q.e();
            l = true;
            return false;
        }
          goto _L3
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        boolean flag1 = b();
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int k3;
        if (flag1)
        {
            q.a(2);
        } else
        {
            q.a(1);
        }
        i2 = k1 - i1;
        if (flag1)
        {
            j2 = getPaddingRight();
        } else
        {
            j2 = getPaddingLeft();
        }
        if (flag1)
        {
            k2 = getPaddingLeft();
        } else
        {
            k2 = getPaddingRight();
        }
        l2 = getPaddingTop();
        i3 = getChildCount();
        if (s)
        {
            int j3;
            View view3;
            int j11;
            int k11;
            int i12;
            float f3;
            if (g && r)
            {
                f3 = 1.0F;
            } else
            {
                f3 = 0.0F;
            }
            i = f3;
        }
        j3 = 0;
        k3 = j2;
        while (j3 < i3) 
        {
            view3 = getChildAt(j3);
            int j9;
            int k9;
            if (view3.getVisibility() != 8)
            {
                s s2 = (s)view3.getLayoutParams();
                int l9 = view3.getMeasuredWidth();
                int i10 = 0;
                int k10;
                int l10;
                int i11;
                if (s2.b)
                {
                    j11 = s2.leftMargin + s2.rightMargin;
                    k11 = Math.min(j2, i2 - k2 - f) - k3 - j11;
                    k = k11;
                    int l11;
                    boolean flag6;
                    if (flag1)
                    {
                        l11 = s2.rightMargin;
                    } else
                    {
                        l11 = s2.leftMargin;
                    }
                    if (k11 + (k3 + l11) + l9 / 2 > i2 - k2)
                    {
                        flag6 = true;
                    } else
                    {
                        flag6 = false;
                    }
                    s2.c = flag6;
                    i12 = (int)((float)k11 * i);
                    k10 = k3 + (l11 + i12);
                    i = (float)i12 / (float)k;
                } else
                {
                    int l3;
                    View view;
                    boolean flag2;
                    int i4;
                    int j4;
                    int k4;
                    int l4;
                    int i5;
                    int j5;
                    int k5;
                    int l5;
                    int i6;
                    int j6;
                    View view1;
                    int k6;
                    int l6;
                    int i7;
                    int j7;
                    int k7;
                    int l7;
                    byte byte0;
                    boolean flag3;
                    Drawable drawable;
                    float f1;
                    boolean flag4;
                    s s1;
                    boolean flag5;
                    int i8;
                    int j8;
                    View view2;
                    int k8;
                    int l8;
                    float f2;
                    int i9;
                    int j10;
                    if (g && m != 0)
                    {
                        j10 = (int)((1.0F - i) * (float)m);
                    } else
                    {
                        j10 = 0;
                    }
                    i10 = j10;
                    k10 = j2;
                }
                if (flag1)
                {
                    i11 = i10 + (i2 - k10);
                    l10 = i11 - l9;
                } else
                {
                    l10 = k10 - i10;
                    i11 = l10 + l9;
                }
                view3.layout(l10, l2, i11, l2 + view3.getMeasuredHeight());
                j9 = j2 + view3.getWidth();
                k9 = k10;
            } else
            {
                j9 = j2;
                k9 = k3;
            }
            j3++;
            j2 = j9;
            k3 = k9;
        }
        if (!s)
        {
            break MISSING_BLOCK_LABEL_1082;
        }
        if (!g) goto _L2; else goto _L1
_L1:
        if (m == 0)
        {
            break MISSING_BLOCK_LABEL_668;
        }
        f1 = i;
        flag4 = b();
        s1 = (s)h.getLayoutParams();
        if (!s1.c)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        if (flag4)
        {
            i9 = s1.rightMargin;
        } else
        {
            i9 = s1.leftMargin;
        }
        if (i9 > 0)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        flag5 = true;
_L3:
        i8 = getChildCount();
        j8 = 0;
        while (j8 < i8) 
        {
            view2 = getChildAt(j8);
            if (view2 != h)
            {
                k8 = (int)((1.0F - j) * (float)m);
                j = f1;
                l8 = k8 - (int)((1.0F - f1) * (float)m);
                if (flag4)
                {
                    l8 = -l8;
                }
                view2.offsetLeftAndRight(l8);
                if (flag5)
                {
                    if (flag4)
                    {
                        f2 = j - 1.0F;
                    } else
                    {
                        f2 = 1.0F - j;
                    }
                    a(view2, f2, c);
                }
            }
            j8++;
        }
        break MISSING_BLOCK_LABEL_668;
        flag5 = false;
          goto _L3
        if (((s)h.getLayoutParams()).c)
        {
            a(h, i, b);
        }
_L7:
        view = h;
        flag2 = b();
        if (flag2)
        {
            i4 = getWidth() - getPaddingRight();
        } else
        {
            i4 = getPaddingLeft();
        }
        if (flag2)
        {
            j4 = getPaddingLeft();
        } else
        {
            j4 = getWidth() - getPaddingRight();
        }
        k4 = getPaddingTop();
        l4 = getHeight() - getPaddingBottom();
        if (view == null) goto _L5; else goto _L4
_L4:
        if (af.f(view))
        {
            flag3 = true;
        } else
        {
label0:
            {
                if (android.os.Build.VERSION.SDK_INT >= 18)
                {
                    break label0;
                }
                drawable = view.getBackground();
                if (drawable == null)
                {
                    break label0;
                }
                if (drawable.getOpacity() == -1)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
            }
        }
_L8:
        if (!flag3) goto _L5; else goto _L6
_L6:
        l5 = view.getLeft();
        k5 = view.getRight();
        j5 = view.getTop();
        i5 = view.getBottom();
_L9:
        i6 = getChildCount();
        j6 = 0;
        do
        {
            if (j6 >= i6)
            {
                break;
            }
            view1 = getChildAt(j6);
            if (view1 == view)
            {
                break;
            }
            if (flag2)
            {
                k6 = j4;
            } else
            {
                k6 = i4;
            }
            l6 = Math.max(k6, view1.getLeft());
            i7 = Math.max(k4, view1.getTop());
            if (flag2)
            {
                j7 = i4;
            } else
            {
                j7 = j4;
            }
            k7 = Math.min(j7, view1.getRight());
            l7 = Math.min(l4, view1.getBottom());
            if (l6 >= l5 && i7 >= j5 && k7 <= k5 && l7 <= i5)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            view1.setVisibility(byte0);
            j6++;
        } while (true);
        break MISSING_BLOCK_LABEL_1082;
_L2:
        l3 = 0;
        while (l3 < i3) 
        {
            a(getChildAt(l3), 0.0F, b);
            l3++;
        }
          goto _L7
        flag3 = false;
          goto _L8
_L5:
        i5 = 0;
        j5 = 0;
        k5 = 0;
        l5 = 0;
          goto _L9
        s = false;
        return;
          goto _L8
    }

    protected final void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int j2;
        k1 = android.view.View.MeasureSpec.getMode(i1);
        l1 = android.view.View.MeasureSpec.getSize(i1);
        i2 = android.view.View.MeasureSpec.getMode(j1);
        j2 = android.view.View.MeasureSpec.getSize(j1);
        if (k1 == 0x40000000) goto _L2; else goto _L1
_L1:
        if (!isInEditMode()) goto _L4; else goto _L3
_L3:
        if (k1 == 0x80000000 || k1 != 0) goto _L6; else goto _L5
_L5:
        int k2;
        int l2;
        int i3;
        k2 = i2;
        l2 = 300;
        i3 = j2;
_L21:
        k2;
        JVM INSTR lookupswitch 2: default 88
    //                   -2147483648: 308
    //                   1073741824: 287;
           goto _L7 _L8 _L9
_L7:
        int j3;
        int k3;
        k3 = 0;
        j3 = -1;
_L15:
        boolean flag;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        float f1;
        flag = false;
        l3 = l2 - getPaddingLeft() - getPaddingRight();
        i4 = getChildCount();
        if (i4 > 2)
        {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        h = null;
        j4 = 0;
        k4 = l3;
        l4 = k3;
        f1 = 0.0F;
_L14:
        if (j4 >= i4) goto _L11; else goto _L10
_L10:
        View view1;
        s s2;
        view1 = getChildAt(j4);
        s2 = (s)view1.getLayoutParams();
        if (view1.getVisibility() != 8) goto _L13; else goto _L12
_L12:
        int k8;
        float f2;
        boolean flag4;
        int l8;
        s2.c = false;
        k8 = k4;
        l8 = l4;
        f2 = f1;
        flag4 = flag;
_L19:
        j4++;
        flag = flag4;
        l4 = l8;
        k4 = k8;
        f1 = f2;
          goto _L14
_L4:
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
_L2:
        if (i2 == 0)
        {
            if (isInEditMode())
            {
                if (i2 == 0)
                {
                    k2 = 0x80000000;
                    l2 = l1;
                    i3 = 300;
                    continue; /* Loop/switch isn't completed */
                }
            } else
            {
                throw new IllegalStateException("Height must not be UNSPECIFIED");
            }
        }
          goto _L6
_L9:
        k3 = i3 - getPaddingTop() - getPaddingBottom();
        j3 = k3;
          goto _L15
_L8:
        j3 = i3 - getPaddingTop() - getPaddingBottom();
        k3 = 0;
          goto _L15
_L13:
        if (s2.a <= 0.0F) goto _L17; else goto _L16
_L16:
        f1 += s2.a;
        if (s2.width == 0) goto _L18; else goto _L17
_L17:
        int i7 = s2.leftMargin + s2.rightMargin;
        int j7;
        int k7;
        int l7;
        int i8;
        int j8;
        boolean flag2;
        boolean flag3;
        if (s2.width == -2)
        {
            j7 = android.view.View.MeasureSpec.makeMeasureSpec(l3 - i7, 0x80000000);
        } else
        if (s2.width == -1)
        {
            j7 = android.view.View.MeasureSpec.makeMeasureSpec(l3 - i7, 0x40000000);
        } else
        {
            j7 = android.view.View.MeasureSpec.makeMeasureSpec(s2.width, 0x40000000);
        }
        if (s2.height == -2)
        {
            k7 = android.view.View.MeasureSpec.makeMeasureSpec(j3, 0x80000000);
        } else
        if (s2.height == -1)
        {
            k7 = android.view.View.MeasureSpec.makeMeasureSpec(j3, 0x40000000);
        } else
        {
            k7 = android.view.View.MeasureSpec.makeMeasureSpec(s2.height, 0x40000000);
        }
        view1.measure(j7, k7);
        l7 = view1.getMeasuredWidth();
        i8 = view1.getMeasuredHeight();
        if (k2 == 0x80000000 && i8 > l4)
        {
            l4 = Math.min(i8, j3);
        }
        j8 = k4 - l7;
        if (j8 < 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        s2.b = flag2;
        flag3 = flag2 | flag;
        if (s2.b)
        {
            h = view1;
        }
        k8 = j8;
        f2 = f1;
        flag4 = flag3;
        l8 = l4;
          goto _L19
_L11:
        if (flag || f1 > 0.0F)
        {
            int i5 = l3 - f;
            int j5 = 0;
            while (j5 < i4) 
            {
                View view = getChildAt(j5);
                if (view.getVisibility() == 8)
                {
                    continue;
                }
                s s1 = (s)view.getLayoutParams();
                if (view.getVisibility() != 8)
                {
                    boolean flag1;
                    int k5;
                    if (s1.width == 0 && s1.a > 0.0F)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag1)
                    {
                        k5 = 0;
                    } else
                    {
                        k5 = view.getMeasuredWidth();
                    }
                    if (flag && view != h)
                    {
                        if (s1.width < 0 && (k5 > i5 || s1.a > 0.0F))
                        {
                            int l6;
                            if (flag1)
                            {
                                if (s1.height == -2)
                                {
                                    l6 = android.view.View.MeasureSpec.makeMeasureSpec(j3, 0x80000000);
                                } else
                                if (s1.height == -1)
                                {
                                    l6 = android.view.View.MeasureSpec.makeMeasureSpec(j3, 0x40000000);
                                } else
                                {
                                    l6 = android.view.View.MeasureSpec.makeMeasureSpec(s1.height, 0x40000000);
                                }
                            } else
                            {
                                l6 = android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0x40000000);
                            }
                            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i5, 0x40000000), l6);
                        }
                    } else
                    if (s1.a > 0.0F)
                    {
                        int l5;
                        if (s1.width == 0)
                        {
                            if (s1.height == -2)
                            {
                                l5 = android.view.View.MeasureSpec.makeMeasureSpec(j3, 0x80000000);
                            } else
                            if (s1.height == -1)
                            {
                                l5 = android.view.View.MeasureSpec.makeMeasureSpec(j3, 0x40000000);
                            } else
                            {
                                l5 = android.view.View.MeasureSpec.makeMeasureSpec(s1.height, 0x40000000);
                            }
                        } else
                        {
                            l5 = android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0x40000000);
                        }
                        if (flag)
                        {
                            int j6 = l3 - (s1.leftMargin + s1.rightMargin);
                            int k6 = android.view.View.MeasureSpec.makeMeasureSpec(j6, 0x40000000);
                            if (k5 != j6)
                            {
                                view.measure(k6, l5);
                            }
                        } else
                        {
                            int i6 = Math.max(0, k4);
                            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k5 + (int)((s1.a * (float)i6) / f1), 0x40000000), l5);
                        }
                    }
                }
                j5++;
            }
        }
        setMeasuredDimension(l2, l4 + getPaddingTop() + getPaddingBottom());
        g = flag;
        if (q.a() != 0 && !flag)
        {
            q.f();
        }
        return;
_L18:
        k8 = k4;
        l8 = l4;
        f2 = f1;
        flag4 = flag;
          goto _L19
_L6:
        k2 = i2;
        l2 = l1;
        i3 = j2;
        if (true) goto _L21; else goto _L20
_L20:
    }

    protected final void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        if (savedstate.a)
        {
            View _tmp = h;
            if (s || a(1.0F))
            {
                r = true;
            }
        } else
        {
            View _tmp1 = h;
            a();
        }
        r = savedstate.a;
    }

    protected final Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        boolean flag;
        if (g)
        {
            if (!g || i == 1.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = r;
        }
        savedstate.a = flag;
        return savedstate;
    }

    protected final void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != k1)
        {
            s = true;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!g)
        {
            return super.onTouchEvent(motionevent);
        }
        q.b(motionevent);
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 52
    //                   0 54
    //                   1 81;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        float f5 = motionevent.getX();
        float f6 = motionevent.getY();
        n = f5;
        o = f6;
        continue; /* Loop/switch isn't completed */
_L3:
        if (b(h))
        {
            float f1 = motionevent.getX();
            float f2 = motionevent.getY();
            float f3 = f1 - n;
            float f4 = f2 - o;
            int i1 = q.d();
            if (f3 * f3 + f4 * f4 < (float)(i1 * i1))
            {
                q;
                if (z.b(h, (int)f1, (int)f2))
                {
                    h;
                    a();
                }
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void requestChildFocus(View view, View view1)
    {
        super.requestChildFocus(view, view1);
        if (!isInTouchMode() && !g)
        {
            boolean flag;
            if (view == h)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            r = flag;
        }
    }

    public final void setCoveredFadeColor(int i1)
    {
        c = i1;
    }

    public final void setPanelSlideListener(t t1)
    {
        p = t1;
    }

    public final void setParallaxDistance(int i1)
    {
        m = i1;
        requestLayout();
    }

    public final void setShadowDrawable(Drawable drawable)
    {
        d = drawable;
    }

    public final void setShadowDrawableLeft(Drawable drawable)
    {
        d = drawable;
    }

    public final void setShadowDrawableRight(Drawable drawable)
    {
        e = drawable;
    }

    public final void setShadowResource(int i1)
    {
        d = getResources().getDrawable(i1);
    }

    public final void setShadowResourceLeft(int i1)
    {
        d = getResources().getDrawable(i1);
    }

    public final void setShadowResourceRight(int i1)
    {
        e = getResources().getDrawable(i1);
    }

    public final void setSliderFadeColor(int i1)
    {
        b = i1;
    }

    static 
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        if (i1 >= 17)
        {
            a = new y();
        } else
        if (i1 >= 16)
        {
            a = new x();
        } else
        {
            a = new android.support.v4.widget.w();
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new u();
        boolean a;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            int j1;
            if (a)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            parcel.writeInt(j1);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            boolean flag;
            if (parcel.readInt() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a = flag;
        }

        SavedState(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
