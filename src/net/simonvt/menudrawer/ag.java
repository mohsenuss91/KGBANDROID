// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;

// Referenced classes of package net.simonvt.menudrawer:
//            f, ah, x, a, 
//            ad, MenuDrawer, al

public final class ag extends f
{

    ag(Activity activity, int j)
    {
        super(activity, j);
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
        ah.a[getPosition().ordinal()];
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

    private boolean a(int j, int k, float f1, float f2)
    {
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 42
    //                   2 145
    //                   3 87
    //                   4 191;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L2:
        if (!F && e <= (float)I && f1 > 0.0F || F && (float)j >= W)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int i1 = getWidth();
        if (!F && e >= (float)(i1 - I) && f1 < 0.0F || F && (float)j <= (float)i1 + W)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!F && f <= (float)I && f2 > 0.0F || F && (float)k >= W)
        {
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
        int l = getHeight();
        if (!F && f >= (float)(l - I) && f2 < 0.0F || F && (float)k <= (float)l + W)
        {
            return true;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    private boolean r()
    {
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 42
    //                   2 133
    //                   3 83
    //                   4 174;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L2:
        if (!F && e <= (float)I || F && e >= W)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int k = getWidth();
        int l = (int)e;
        if (!F && l >= k - I || F && (float)l <= (float)k + W)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!F && f <= (float)I || F && f >= W)
        {
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
        int j = getHeight();
        if (!F && f >= (float)(j - I) || F && f <= (float)j + W)
        {
            return true;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected final void a(Context context, AttributeSet attributeset, int j)
    {
        super.a(context, attributeset, j);
        super.addView(C, -1, new android.view.ViewGroup.LayoutParams(-1, -1));
        super.addView(D, -1, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    protected final void a(Canvas canvas)
    {
        int j;
        int k;
        int l;
        float f1;
        j = getWidth();
        k = getHeight();
        l = (int)W;
        f1 = Math.abs(W) / (float)E;
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 72
    //                   1 96
    //                   2 128
    //                   3 111
    //                   4 143;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        t.setAlpha((int)(185F * (1.0F - f1)));
        t.draw(canvas);
        return;
_L2:
        t.setBounds(0, 0, l, k);
        continue; /* Loop/switch isn't completed */
_L4:
        t.setBounds(l + j, 0, j, k);
        continue; /* Loop/switch isn't completed */
_L3:
        t.setBounds(0, 0, j, l);
        continue; /* Loop/switch isn't completed */
_L5:
        t.setBounds(0, l + k, j, k);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final void a(boolean flag)
    {
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 50
    //                   2 50
    //                   3 58
    //                   4 58;
           goto _L1 _L2 _L2 _L3 _L3
_L1:
        int j = 0;
_L5:
        a(j, 0, flag);
        return;
_L2:
        j = E;
        continue; /* Loop/switch isn't completed */
_L3:
        j = -E;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final void b(int j)
    {
        byte byte0 = 4;
        if (!q) goto _L2; else goto _L1
_L1:
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 2 4: default 44
    //                   2 72
    //                   3 44
    //                   4 72;
           goto _L3 _L4 _L3 _L4
_L3:
        D.setTranslationX(j);
_L7:
        if (m && E != 0) goto _L6; else goto _L5
_L5:
        invalidate();
        return;
_L4:
        D.setTranslationY(j);
          goto _L7
_L2:
        switch (ah.a[getPosition().ordinal()])
        {
        case 3: // '\003'
        default:
            D.offsetLeftAndRight(j - D.getLeft());
            break;

        case 2: // '\002'
        case 4: // '\004'
            D.offsetTopAndBottom(j - D.getTop());
            break;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        int k = getWidth();
        int l = getHeight();
        int i1 = E;
        int j1 = (int)(W / Math.abs(W));
        int k1 = (int)(-0.25F * ((1.0F - Math.abs(W) / (float)i1) * (float)i1) * (float)j1);
        switch (ah.a[getPosition().ordinal()])
        {
        case 1: // '\001'
            if (q)
            {
                if (j > 0)
                {
                    C.setTranslationX(k1);
                } else
                {
                    C.setTranslationX(-i1);
                }
            } else
            {
                C.offsetLeftAndRight(k1 - C.getLeft());
                a a4 = C;
                if (j != 0)
                {
                    byte0 = 0;
                }
                a4.setVisibility(byte0);
            }
            break;

        case 3: // '\003'
            if (q)
            {
                if (j != 0)
                {
                    C.setTranslationX(k1);
                } else
                {
                    C.setTranslationX(i1);
                }
            } else
            {
                int i2 = k1 - (C.getRight() - k);
                C.offsetLeftAndRight(i2);
                a a3 = C;
                if (j != 0)
                {
                    byte0 = 0;
                }
                a3.setVisibility(byte0);
            }
            break;

        case 2: // '\002'
            if (q)
            {
                if (j > 0)
                {
                    C.setTranslationY(k1);
                } else
                {
                    C.setTranslationY(-i1);
                }
            } else
            {
                C.offsetTopAndBottom(k1 - C.getTop());
                a a2 = C;
                if (j != 0)
                {
                    byte0 = 0;
                }
                a2.setVisibility(byte0);
            }
            break;

        case 4: // '\004'
            if (q)
            {
                if (j != 0)
                {
                    C.setTranslationY(k1);
                } else
                {
                    C.setTranslationY(i1);
                }
            } else
            {
                int l1 = k1 - (C.getBottom() - l);
                C.offsetTopAndBottom(l1);
                a a1 = C;
                if (j != 0)
                {
                    byte0 = 0;
                }
                a1.setVisibility(byte0);
            }
            break;
        }
        if (true) goto _L5; else goto _L8
_L8:
        if (true) goto _L7; else goto _L9
_L9:
    }

    protected final void i()
    {
        int j;
        switch (ah.a[getPosition().ordinal()])
        {
        default:
            int k = E / 3;
            this.j.a(0, k, 5000);
            return;

        case 3: // '\003'
        case 4: // '\004'
            j = -E / 3;
            break;
        }
        this.j.a(0, j, 5000);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int j = 0xff & motionevent.getAction();
        if (j != 1 && j != 3) goto _L2; else goto _L1
_L1:
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
        int l;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        boolean flag;
        byte byte0;
        int i1;
        int j1;
        int k1;
        boolean flag1;
        if (d != -1)
        {
            i1 = motionevent.findPointerIndex(d);
            if (i1 == -1)
            {
                i1 = 0;
            }
        } else
        {
            i1 = 0;
        }
        j1 = (int)motionevent.getX(i1);
        k1 = (int)motionevent.getY(i1);
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 212
    //                   1 222
    //                   2 270
    //                   3 246
    //                   4 294;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        flag1 = false;
_L11:
        if (flag1)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (al.a(D) < j1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (al.c(D) > j1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (al.b(D) < k1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (al.d(D) > k1)
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
        JVM INSTR lookupswitch 3: default 388
    //                   0: 415
    //                   2: 520
    //                   6: 705;
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
            c = false;
        }
        continue; /* Loop/switch isn't completed */
_L16:
        k = d;
        if (k != -1)
        {
            l = motionevent.findPointerIndex(k);
            if (l == -1)
            {
                c = false;
                d = -1;
                e();
                a(0, 0, true);
                return false;
            }
            f1 = motionevent.getX(l);
            f2 = f1 - g;
            f3 = motionevent.getY(l);
            f4 = f3 - h;
            if (a(f2, f4))
            {
                if (Q != null && (J == 2 || F) && a((int)f2, (int)f4, (int)f1, (int)f3))
                {
                    e();
                    requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                if (a((int)f1, (int)f3, f2, f4))
                {
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

    protected final void onLayout(boolean flag, int j, int k, int l, int i1)
    {
        int j1 = l - j;
        int k1 = i1 - k;
        if (q)
        {
            D.layout(0, 0, j1, k1);
        } else
        {
            int l1 = (int)W;
            if (getPosition() == x.a || getPosition() == x.c)
            {
                D.layout(l1, 0, j1 + l1, k1);
            } else
            {
                D.layout(0, l1, j1, k1 + l1);
            }
        }
        switch (ah.a[getPosition().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            C.layout(0, 0, E, k1);
            return;

        case 3: // '\003'
            C.layout(j1 - E, 0, j1, k1);
            return;

        case 2: // '\002'
            C.layout(0, 0, j1, E);
            return;

        case 4: // '\004'
            C.layout(0, k1 - E, j1, k1);
            break;
        }
    }

    protected final void onMeasure(int j, int k)
    {
        int j1;
        int k1;
        int l = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getMode(k);
        if (l == 0 || i1 == 0)
        {
            throw new IllegalStateException("Must measure with an exact size");
        }
        j1 = android.view.View.MeasureSpec.getSize(j);
        k1 = android.view.View.MeasureSpec.getSize(k);
        if (W == -1F)
        {
            a(false);
        }
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 2 4: default 96
    //                   2 169
    //                   3 96
    //                   4 169;
           goto _L1 _L2 _L1 _L2
_L1:
        int l1;
        int i2;
        l1 = getChildMeasureSpec(j, 0, E);
        i2 = getChildMeasureSpec(j, 0, k1);
_L4:
        C.measure(l1, i2);
        int j2 = getChildMeasureSpec(j, 0, j1);
        int k2 = getChildMeasureSpec(j, 0, k1);
        D.measure(j2, k2);
        setMeasuredDimension(j1, k1);
        q();
        return;
_L2:
        l1 = getChildMeasureSpec(j, 0, j1);
        i2 = getChildMeasureSpec(k, 0, E);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void onSizeChanged(int j, int k, int l, int i1)
    {
        super.onSizeChanged(j, k, l, i1);
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
    //                   1 532
    //                   2 179
    //                   3 532
    //                   4 96
    //                   5 1005
    //                   6 1047;
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
            c();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        int i4 = motionevent.findPointerIndex(d);
        if (i4 == -1)
        {
            c = false;
            d = -1;
            e();
            a(0, 0, true);
            return false;
        }
        if (!c)
        {
            float f5 = motionevent.getX(i4);
            float f6 = f5 - g;
            float f7 = motionevent.getY(i4);
            float f8 = f7 - h;
            float f1;
            float f3;
            if (a(f6, f8))
            {
                if (a((int)f5, (int)f7, f6, f8))
                {
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
            f1 = motionevent.getX(i4);
            float f2 = f1 - g;
            f3 = motionevent.getY(i4);
            float f4 = f3 - h;
            g = f1;
            h = f3;
            switch (ah.a[getPosition().ordinal()])
            {
            case 1: // '\001'
                setOffsetPixels(Math.min(Math.max(f2 + W, 0.0F), E));
                break;

            case 3: // '\003'
                setOffsetPixels(Math.max(Math.min(f2 + W, 0.0F), -E));
                break;

            case 2: // '\002'
                setOffsetPixels(Math.min(Math.max(f4 + W, 0.0F), E));
                break;

            case 4: // '\004'
                setOffsetPixels(Math.max(Math.min(f4 + W, 0.0F), -E));
                break;
            }
            if (false)
            {
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int i1;
        int j1;
        int k1;
        int l = motionevent.findPointerIndex(d);
        if (l == -1)
        {
            l = 0;
        }
        i1 = (int)motionevent.getX(l);
        j1 = (int)motionevent.getY(l);
        k1 = (int)W;
        ah.a[getPosition().ordinal()];
        JVM INSTR tableswitch 1 4: default 616
    //                   1 629
    //                   2 719
    //                   3 809
    //                   4 909;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        d = -1;
        c = false;
        continue; /* Loop/switch isn't completed */
_L8:
        if (c)
        {
            this.k.computeCurrentVelocity(1000, this.l);
            int k3 = (int)a(this.k);
            g = i1;
            int l3;
            if (k3 > 0)
            {
                l3 = E;
            } else
            {
                l3 = 0;
            }
            a(l3, k3, true);
        } else
        if (F && i1 > k1)
        {
            p();
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (c)
        {
            this.k.computeCurrentVelocity(1000, this.l);
            int i3 = (int)b(this.k);
            h = j1;
            int j3;
            if (i3 > 0)
            {
                j3 = E;
            } else
            {
                j3 = 0;
            }
            a(j3, i3, true);
        } else
        if (F && j1 > k1)
        {
            p();
        }
        continue; /* Loop/switch isn't completed */
_L10:
        int j2 = getWidth();
        if (c)
        {
            this.k.computeCurrentVelocity(1000, this.l);
            int k2 = (int)a(this.k);
            g = i1;
            int l2;
            if (k2 > 0)
            {
                l2 = 0;
            } else
            {
                l2 = -E;
            }
            a(l2, k2, true);
        } else
        if (F && i1 < j2 + k1)
        {
            p();
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (c)
        {
            this.k.computeCurrentVelocity(1000, this.l);
            int l1 = (int)b(this.k);
            h = j1;
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
        if (F && j1 < k1 + getHeight())
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
}
