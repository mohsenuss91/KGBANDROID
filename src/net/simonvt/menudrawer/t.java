// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;

// Referenced classes of package net.simonvt.menudrawer:
//            f, u, v, x, 
//            a, ad, al, MenuDrawer

public final class t extends f
{

    private int aa;
    private Runnable ab;

    t(Activity activity, int j)
    {
        super(activity, j);
        ab = new u(this);
    }

    static int a(t t1)
    {
        return t1.aa;
    }

    private void a(MotionEvent motionevent)
    {
        int j = motionevent.getActionIndex();
        if (motionevent.getPointerId(j) == d)
        {
            int k;
            if (j == 0)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            g = motionevent.getX(k);
            d = motionevent.getPointerId(k);
            if (this.k != null)
            {
                this.k.clear();
            }
        }
    }

    private boolean a(float f1, float f2)
    {
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 2 4: default 36
    //                   2 63
    //                   3 36
    //                   4 63;
           goto _L1 _L2 _L1 _L2
_L1:
        if (Math.abs(f1) <= (float)a || Math.abs(f1) <= Math.abs(f2)) goto _L4; else goto _L3
_L3:
        return true;
_L2:
        if (Math.abs(f2) <= (float)a || Math.abs(f2) <= Math.abs(f1))
        {
            return false;
        }
        if (true) goto _L3; else goto _L4
_L4:
        return false;
    }

    private boolean a(int j, float f1, float f2)
    {
        if (!F || J != 2) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int k;
        switch (v.a[getPosition().ordinal()])
        {
        default:
            return false;

        case 3: // '\003'
            if ((F || e > (float)I || f1 <= 0.0F) && (!F || (float)j > W) && (Math.abs(W) > (float)aa || !F))
            {
                return false;
            }
            break;

        case 1: // '\001'
            int i1 = getWidth();
            if ((F || e < (float)(i1 - I) || f1 >= 0.0F) && (!F || (float)j < (float)i1 - W) && (Math.abs(W) > (float)aa || !F))
            {
                return false;
            }
            break;

        case 4: // '\004'
            if ((F || f > (float)I || f2 <= 0.0F) && (!F || (float)j > W) && (Math.abs(W) > (float)aa || !F))
            {
                return false;
            }
            break;

        case 2: // '\002'
            k = getHeight();
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!F && f >= (float)(k - I) && f2 < 0.0F || F && (float)j >= (float)k - W || Math.abs(W) <= (float)aa && F) goto _L1; else goto _L4
_L4:
        return false;
    }

    private boolean r()
    {
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 83
    //                   2 174
    //                   3 42
    //                   4 133;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L4:
        if (!F && e <= (float)I || F && e <= W)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        int k = getWidth();
        int i1 = (int)e;
        if (!F && i1 >= k - I || F && (float)i1 >= (float)k + W)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!F && f <= (float)I || F && f <= W)
        {
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int j = getHeight();
        if (!F && f >= (float)(j - I) || F && f >= (float)j + W)
        {
            return true;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected final void a(Context context, AttributeSet attributeset, int j)
    {
        super.a(context, attributeset, j);
        super.addView(D, -1, new android.view.ViewGroup.LayoutParams(-1, -1));
        if (q)
        {
            D.setLayerType(0, null);
        }
        D.a(false);
        super.addView(C, -1, new android.view.ViewGroup.LayoutParams(-1, -1));
        aa = a(20);
    }

    protected final void a(Canvas canvas)
    {
        int j;
        int k;
        int i1;
        float f1;
        j = getWidth();
        k = getHeight();
        i1 = (int)W;
        f1 = Math.abs(W) / (float)E;
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 72
    //                   1 109
    //                   2 141
    //                   3 94
    //                   4 126;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        t.setAlpha((int)(185F * f1));
        t.draw(canvas);
        return;
_L4:
        t.setBounds(i1, 0, j, k);
        continue; /* Loop/switch isn't completed */
_L2:
        t.setBounds(0, 0, j + i1, k);
        continue; /* Loop/switch isn't completed */
_L5:
        t.setBounds(0, i1, j, k);
        continue; /* Loop/switch isn't completed */
_L3:
        t.setBounds(0, 0, j, k + i1);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final void a(boolean flag)
    {
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 58
    //                   2 58
    //                   3 50
    //                   4 50;
           goto _L1 _L2 _L2 _L3 _L3
_L1:
        int j = 0;
_L5:
        a(j, 0, flag);
        return;
_L3:
        j = E;
        continue; /* Loop/switch isn't completed */
_L2:
        j = -E;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final void b(int j)
    {
        if (!q) goto _L2; else goto _L1
_L1:
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 87
    //                   2 104
    //                   3 53
    //                   4 70;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        invalidate();
        return;
_L6:
        C.setTranslationX(j - E);
        continue; /* Loop/switch isn't completed */
_L7:
        C.setTranslationY(j - E);
        continue; /* Loop/switch isn't completed */
_L4:
        C.setTranslationX(j + E);
        continue; /* Loop/switch isn't completed */
_L5:
        C.setTranslationY(j + E);
        if (true) goto _L3; else goto _L2
_L2:
        switch (v.a[getPosition().ordinal()])
        {
        case 1: // '\001'
            C.offsetLeftAndRight(j - (C.getLeft() - getWidth()));
            break;

        case 4: // '\004'
            C.offsetTopAndBottom(j - C.getBottom());
            break;

        case 2: // '\002'
            C.offsetTopAndBottom(j - (C.getTop() - getHeight()));
            break;

        case 3: // '\003'
            C.offsetLeftAndRight(j - C.getRight());
            break;
        }
        if (true) goto _L3; else goto _L8
_L8:
    }

    protected final void c()
    {
        if (q && K && !p)
        {
            p = true;
            C.setLayerType(2, null);
        }
    }

    protected final void d()
    {
        if (p)
        {
            p = false;
            C.setLayerType(0, null);
        }
    }

    protected final void f()
    {
        super.f();
        removeCallbacks(ab);
    }

    protected final android.graphics.drawable.GradientDrawable.Orientation getDropShadowOrientation()
    {
        switch (v.a[getPosition().ordinal()])
        {
        case 3: // '\003'
        default:
            return android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT;

        case 4: // '\004'
            return android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM;

        case 1: // '\001'
            return android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT;

        case 2: // '\002'
            return android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP;
        }
    }

    protected final void i()
    {
        int j;
        switch (v.a[getPosition().ordinal()])
        {
        default:
            int k = aa;
            this.j.a(0, k, 5000);
            return;

        case 1: // '\001'
        case 2: // '\002'
            j = -aa;
            break;
        }
        this.j.a(0, j, 5000);
    }

    protected final void l()
    {
        int j = (int)((Math.abs(W) / (float)E) * (float)x);
        switch (v.a[getPosition().ordinal()])
        {
        default:
            return;

        case 3: // '\003'
            V.top = 0;
            V.bottom = getHeight();
            V.left = al.c(C);
            V.right = j + V.left;
            return;

        case 4: // '\004'
            V.left = 0;
            V.right = getWidth();
            V.top = al.d(C);
            V.bottom = j + V.top;
            return;

        case 1: // '\001'
            V.top = 0;
            V.bottom = getHeight();
            V.right = al.a(C);
            V.left = V.right - j;
            return;

        case 2: // '\002'
            V.left = 0;
            V.right = getWidth();
            V.bottom = al.b(C);
            V.top = V.bottom - j;
            return;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int j = 0xff & motionevent.getAction();
        if (j != 1 && j != 3) goto _L2; else goto _L1
_L1:
        removeCallbacks(ab);
        d = -1;
        c = false;
        if (this.k != null)
        {
            this.k.recycle();
            this.k = null;
        }
        if (Math.abs(W) <= (float)(E / 2)) goto _L4; else goto _L3
_L3:
        a(true);
_L13:
        return false;
_L4:
        p();
        return false;
_L2:
        if (j == 0 && F && k())
        {
            setOffsetPixels(0.0F);
            f();
            j();
            setDrawerState(0);
            c = false;
        }
        if (!F)
        {
            continue; /* Loop/switch isn't completed */
        }
        int k;
        int i1;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        boolean flag;
        byte byte0;
        int j1;
        int k1;
        int l1;
        boolean flag1;
        if (d != -1)
        {
            j1 = motionevent.findPointerIndex(d);
            if (j1 == -1)
            {
                j1 = 0;
            }
        } else
        {
            j1 = 0;
        }
        k1 = (int)motionevent.getX(j1);
        l1 = (int)motionevent.getY(j1);
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 224
    //                   1 258
    //                   2 306
    //                   3 234
    //                   4 282;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        flag1 = false;
_L11:
        if (flag1)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L8:
        if (al.c(C) < k1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (al.a(C) > k1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (al.d(C) < l1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (al.b(C) > l1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (true) goto _L11; else goto _L10
_L10:
        if (!F && !c && J == 0) goto _L13; else goto _L12
_L12:
        if (j != 0 && c)
        {
            return true;
        }
        j;
        JVM INSTR lookupswitch 3: default 400
    //                   0: 427
    //                   2: 564
    //                   6: 798;
           goto _L14 _L15 _L16 _L17
_L14:
        if (this.k == null)
        {
            this.k = VelocityTracker.obtain();
        }
        this.k.addMovement(motionevent);
        return c;
_L15:
        f5 = motionevent.getX();
        e = f5;
        g = f5;
        f6 = motionevent.getY();
        f = f6;
        h = f6;
        g;
        h;
        flag = r();
        d = motionevent.getPointerId(0);
        if (flag)
        {
            if (F)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            setDrawerState(byte0);
            f();
            j();
            if (!F && e <= (float)aa)
            {
                postDelayed(ab, 160L);
            }
            c = false;
        }
        continue; /* Loop/switch isn't completed */
_L16:
        k = d;
        if (k != -1)
        {
            i1 = motionevent.findPointerIndex(k);
            if (i1 == -1)
            {
                c = false;
                d = -1;
                e();
                a(0, 0, true);
                return false;
            }
            f1 = motionevent.getX(i1);
            f2 = f1 - g;
            f3 = motionevent.getY(i1);
            f4 = f3 - h;
            if (Math.abs(f2) >= (float)a || Math.abs(f4) >= (float)a)
            {
                removeCallbacks(ab);
                j();
            }
            if (a(f2, f4))
            {
                if (Q != null && (J == 2 || F) && a((int)f2, (int)f4, (int)f1, (int)f3))
                {
                    e();
                    requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                if (a((int)f1, f2, f4))
                {
                    j();
                    f();
                    setDrawerState(2);
                    c = true;
                    g = f1;
                    h = f3;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L17:
        a(motionevent);
        g = motionevent.getX(motionevent.findPointerIndex(d));
        h = motionevent.getY(motionevent.findPointerIndex(d));
        if (true) goto _L14; else goto _L18
_L18:
    }

    protected final void onLayout(boolean flag, int j, int k, int i1, int j1)
    {
        int k1 = i1 - j;
        int l1 = j1 - k;
        D.layout(0, 0, k1, l1);
        if (q)
        {
            switch (v.a[getPosition().ordinal()])
            {
            default:
                return;

            case 3: // '\003'
                C.layout(0, 0, E, l1);
                return;

            case 1: // '\001'
                C.layout(k1 - E, 0, k1, l1);
                return;

            case 4: // '\004'
                C.layout(0, 0, k1, E);
                return;

            case 2: // '\002'
                C.layout(0, l1 - E, k1, l1);
                return;
            }
        }
        int i2 = (int)W;
        int j2 = E;
        switch (v.a[getPosition().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            C.layout(k1 + i2, 0, i2 + (k1 + j2), l1);
            return;

        case 3: // '\003'
            C.layout(i2 + -j2, 0, i2, l1);
            return;

        case 4: // '\004'
            C.layout(0, i2 + -j2, k1, i2);
            return;

        case 2: // '\002'
            C.layout(0, l1 + i2, k1, i2 + (l1 + j2));
            return;
        }
    }

    protected final void onMeasure(int j, int k)
    {
        int k1;
        int l1;
        int i1 = android.view.View.MeasureSpec.getMode(j);
        int j1 = android.view.View.MeasureSpec.getMode(k);
        if (i1 == 0 || j1 == 0)
        {
            throw new IllegalStateException("Must measure with an exact size");
        }
        k1 = android.view.View.MeasureSpec.getSize(j);
        l1 = android.view.View.MeasureSpec.getSize(k);
        if (W == -1F)
        {
            a(false);
        }
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 2 4: default 96
    //                   2 169
    //                   3 96
    //                   4 169;
           goto _L1 _L2 _L1 _L2
_L1:
        int i2;
        int j2;
        i2 = getChildMeasureSpec(j, 0, E);
        j2 = getChildMeasureSpec(j, 0, l1);
_L4:
        C.measure(i2, j2);
        int k2 = getChildMeasureSpec(j, 0, k1);
        int l2 = getChildMeasureSpec(j, 0, l1);
        D.measure(k2, l2);
        setMeasuredDimension(k1, l1);
        q();
        return;
_L2:
        i2 = getChildMeasureSpec(j, 0, k1);
        j2 = getChildMeasureSpec(k, 0, E);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void onSizeChanged(int j, int k, int i1, int j1)
    {
        super.onSizeChanged(j, k, i1, j1);
        b((int)W);
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        int j;
        if (!F && !c && J == 0)
        {
            return false;
        }
        j = 0xff & motionevent.getAction();
        if (this.k == null)
        {
            this.k = VelocityTracker.obtain();
        }
        this.k.addMovement(motionevent);
        j;
        JVM INSTR tableswitch 0 6: default 96
    //                   0 98
    //                   1 568
    //                   2 211
    //                   3 568
    //                   4 96
    //                   5 1012
    //                   6 1054;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        return true;
_L2:
        float f9 = motionevent.getX();
        e = f9;
        g = f9;
        float f10 = motionevent.getY();
        f = f10;
        h = f10;
        g;
        h;
        boolean flag = r();
        d = motionevent.getPointerId(0);
        if (flag)
        {
            f();
            j();
            if (!F && g <= (float)aa)
            {
                postDelayed(ab, 160L);
            }
            c();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int l3 = motionevent.findPointerIndex(d);
        if (l3 == -1)
        {
            c = false;
            d = -1;
            e();
            a(0, 0, true);
            return false;
        }
        if (!c)
        {
            float f5 = motionevent.getX(l3);
            float f6 = f5 - g;
            float f7 = motionevent.getY(l3);
            float f8 = f7 - h;
            float f1;
            float f3;
            if (a(f6, f8))
            {
                if (a((int)f5, f6, f8))
                {
                    j();
                    f();
                    setDrawerState(2);
                    c = true;
                    g = f5;
                    h = f7;
                } else
                {
                    e = f5;
                    f = f7;
                }
            }
        }
        if (c)
        {
            c();
            f1 = motionevent.getX(l3);
            float f2 = f1 - g;
            f3 = motionevent.getY(l3);
            float f4 = f3 - h;
            g = f1;
            h = f3;
            switch (v.a[getPosition().ordinal()])
            {
            case 1: // '\001'
                setOffsetPixels(Math.max(Math.min(f2 + W, 0.0F), -E));
                break;

            case 3: // '\003'
                setOffsetPixels(Math.min(Math.max(f2 + W, 0.0F), E));
                break;

            case 4: // '\004'
                setOffsetPixels(Math.min(Math.max(f4 + W, 0.0F), E));
                break;

            case 2: // '\002'
                setOffsetPixels(Math.max(Math.min(f4 + W, 0.0F), -E));
                break;
            }
            if (false)
            {
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int j1;
        int k1;
        removeCallbacks(ab);
        int i1 = motionevent.findPointerIndex(d);
        if (i1 == -1)
        {
            i1 = 0;
        }
        j1 = (int)motionevent.getX(i1);
        k1 = (int)motionevent.getY(i1);
        W;
        v.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 660
    //                   1 839
    //                   2 928
    //                   3 673
    //                   4 756;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        d = -1;
        c = false;
        continue; /* Loop/switch isn't completed */
_L10:
        if (c)
        {
            this.k.computeCurrentVelocity(1000, l);
            int j3 = (int)a(this.k);
            g = j1;
            int k3;
            if (j3 > 0)
            {
                k3 = E;
            } else
            {
                k3 = 0;
            }
            a(k3, j3, true);
        } else
        if (F)
        {
            p();
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (c)
        {
            this.k.computeCurrentVelocity(1000, l);
            int l2 = (int)b(this.k);
            h = k1;
            int i3;
            if (l2 > 0)
            {
                i3 = E;
            } else
            {
                i3 = 0;
            }
            a(i3, l2, true);
        } else
        if (F)
        {
            p();
        }
        continue; /* Loop/switch isn't completed */
_L8:
        getWidth();
        if (c)
        {
            this.k.computeCurrentVelocity(1000, l);
            int j2 = (int)a(this.k);
            g = j1;
            int k2;
            if (j2 > 0)
            {
                k2 = 0;
            } else
            {
                k2 = -E;
            }
            a(k2, j2, true);
        } else
        if (F)
        {
            p();
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (c)
        {
            this.k.computeCurrentVelocity(1000, l);
            int l1 = (int)b(this.k);
            h = k1;
            int i2;
            if (l1 < 0)
            {
                i2 = -E;
            } else
            {
                i2 = 0;
            }
            a(i2, l1, true);
        } else
        if (F)
        {
            p();
        }
        if (true) goto _L7; else goto _L5
_L5:
        int k = (0xff00 & motionevent.getAction()) >> 8;
        g = motionevent.getX(k);
        h = motionevent.getY(k);
        d = motionevent.getPointerId(k);
        continue; /* Loop/switch isn't completed */
_L6:
        a(motionevent);
        g = motionevent.getX(motionevent.findPointerIndex(d));
        h = motionevent.getY(motionevent.findPointerIndex(d));
        if (true) goto _L1; else goto _L12
_L12:
    }

    public final void p()
    {
        a(0, 0, true);
    }

    public final void requestDisallowInterceptTouchEvent(boolean flag)
    {
        super.requestDisallowInterceptTouchEvent(flag);
        removeCallbacks(ab);
        if (o)
        {
            j();
            a(0, 5000);
        }
    }
}
