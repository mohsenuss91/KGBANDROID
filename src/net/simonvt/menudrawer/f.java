// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

// Referenced classes of package net.simonvt.menudrawer:
//            MenuDrawer, w, g, h, 
//            p, ad, i, j, 
//            x, al, a

public abstract class f extends MenuDrawer
{

    private static final Interpolator aa = new w();
    protected int a;
    private final Runnable ab = new h(this);
    private Runnable ac;
    private ad ad;
    protected final Runnable b = new g(this);
    protected boolean c;
    protected int d;
    protected float e;
    protected float f;
    protected float g;
    protected float h;
    protected long i;
    protected ad j;
    protected VelocityTracker k;
    protected int l;
    protected boolean m;
    protected int n;
    protected boolean o;
    protected boolean p;

    f(Activity activity, int i1)
    {
        super(activity, i1);
        d = -1;
        g = -1F;
        h = -1F;
        m = true;
    }

    static void a(f f1)
    {
        f1.s();
    }

    private boolean a(View view, boolean flag, int i1, int j1, int k1)
    {
        if (!(view instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        int l1;
        viewgroup = (ViewGroup)view;
        l1 = -1 + viewgroup.getChildCount();
_L8:
        if (l1 < 0) goto _L2; else goto _L3
_L3:
        View view1;
        int i2;
        int j2;
        int k2;
        int l2;
        view1 = viewgroup.getChildAt(l1);
        i2 = view1.getLeft() + c(view1);
        j2 = view1.getRight() + c(view1);
        k2 = view1.getTop() + b(view1);
        l2 = view1.getBottom() + b(view1);
        if (j1 < i2 || j1 >= j2 || k1 < k2 || k1 >= l2 || !a(view1, true, i1, j1 - i2, k1 - k2)) goto _L5; else goto _L4
_L4:
        return true;
_L5:
        l1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag && Q.a()) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static int b(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return (int)view.getTranslationY();
        } else
        {
            return 0;
        }
    }

    static void b(f f1)
    {
        f1.r();
    }

    private boolean b(View view, boolean flag, int i1, int j1, int k1)
    {
        if (!(view instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        int l1;
        viewgroup = (ViewGroup)view;
        l1 = -1 + viewgroup.getChildCount();
_L8:
        if (l1 < 0) goto _L2; else goto _L3
_L3:
        View view1;
        int i2;
        int j2;
        int k2;
        int l2;
        view1 = viewgroup.getChildAt(l1);
        i2 = view1.getLeft() + c(view1);
        j2 = view1.getRight() + c(view1);
        k2 = view1.getTop() + b(view1);
        l2 = view1.getBottom() + b(view1);
        if (j1 < i2 || j1 >= j2 || k1 < k2 || k1 >= l2 || !b(view1, true, i1, j1 - i2, k1 - k2)) goto _L5; else goto _L4
_L4:
        return true;
_L5:
        l1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag && Q.a()) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static int c(View view)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return (int)view.getTranslationX();
        } else
        {
            return 0;
        }
    }

    private void r()
    {
        if (ad.d())
        {
            int k1 = (int)W;
            int l1 = ad.b();
            if (l1 != k1)
            {
                setOffsetPixels(l1);
            }
            if (l1 != ad.c())
            {
                postOnAnimation(ab);
                return;
            }
        }
        ad.e();
        int i1 = ad.c();
        setOffsetPixels(i1);
        int j1;
        if (i1 == 0)
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        setDrawerState(j1);
        d();
    }

    private void s()
    {
        if (j.d())
        {
            int i1 = (int)W;
            int j1 = j.b();
            if (j1 != i1)
            {
                setOffsetPixels(j1);
            }
            if (!j.a())
            {
                postOnAnimation(b);
                return;
            }
            if (i > 0L)
            {
                ac = new i(this);
                postDelayed(ac, i);
            }
        }
        j.e();
        setOffsetPixels(0.0F);
        setDrawerState(0);
        d();
        o = false;
    }

    protected final float a(VelocityTracker velocitytracker)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            return velocitytracker.getXVelocity(d);
        } else
        {
            return velocitytracker.getXVelocity();
        }
    }

    public final void a()
    {
        if (G == 8 || G == 4)
        {
            p();
        } else
        if (G == 0 || G == 1)
        {
            a(true);
            return;
        }
    }

    protected final void a(int i1, int j1)
    {
        int k1 = (int)W;
        int l1 = i1 - k1;
        if (l1 > 0)
        {
            setDrawerState(4);
            ad.a(k1, l1, j1);
        } else
        {
            setDrawerState(1);
            ad.a(k1, l1, j1);
        }
        c();
        r();
    }

    protected final void a(int i1, int j1, boolean flag)
    {
        e();
        j();
        int k1 = i1 - (int)W;
        if (k1 == 0 || !flag)
        {
            setOffsetPixels(i1);
            int l1;
            if (i1 == 0)
            {
                l1 = 0;
            } else
            {
                l1 = 8;
            }
            setDrawerState(l1);
            d();
            return;
        }
        int i2 = Math.abs(j1);
        int j2;
        if (i2 > 0)
        {
            j2 = 4 * Math.round(1000F * Math.abs((float)k1 / (float)i2));
        } else
        {
            j2 = (int)(600F * Math.abs((float)k1 / (float)E));
        }
        a(i1, Math.min(j2, P));
    }

    protected void a(Context context, AttributeSet attributeset, int i1)
    {
        super.a(context, attributeset, i1);
        ViewConfiguration viewconfiguration = ViewConfiguration.get(context);
        a = viewconfiguration.getScaledTouchSlop();
        l = viewconfiguration.getScaledMaximumFlingVelocity();
        ad = new ad(context, MenuDrawer.r);
        j = new ad(context, aa);
        n = a(3);
    }

    final void a(Bundle bundle)
    {
        boolean flag;
        if (G == 8 || G == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.putBoolean("net.simonvt.menudrawer.MenuDrawer.menuVisible", flag);
    }

    public final void a(Parcelable parcelable)
    {
        super.a(parcelable);
        boolean flag = ((Bundle)parcelable).getBoolean("net.simonvt.menudrawer.MenuDrawer.menuVisible");
        int i1;
        if (flag)
        {
            a(false);
        } else
        {
            setOffsetPixels(0.0F);
        }
        i1 = 0;
        if (flag)
        {
            i1 = 8;
        }
        G = i1;
    }

    protected final boolean a(int i1, int j1, int k1, int l1)
    {
        switch (j.a[getPosition().ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            if (!F)
            {
                return a(((View) (D)), false, i1, k1 - al.a(D), l1 - al.b(D));
            } else
            {
                return a(((View) (C)), false, i1, k1 - al.a(C), l1 - al.b(D));
            }

        case 3: // '\003'
        case 4: // '\004'
            break;
        }
        if (!F)
        {
            return b(D, false, j1, k1 - al.a(D), l1 - al.b(D));
        } else
        {
            return b(C, false, j1, k1 - al.a(C), l1 - al.b(D));
        }
    }

    protected final float b(VelocityTracker velocitytracker)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            return velocitytracker.getYVelocity(d);
        } else
        {
            return velocitytracker.getYVelocity();
        }
    }

    public final boolean b()
    {
        return F;
    }

    protected void c()
    {
        if (q && K && !p)
        {
            p = true;
            D.setLayerType(2, null);
            C.setLayerType(2, null);
        }
    }

    protected void d()
    {
        if (p)
        {
            p = false;
            D.setLayerType(0, null);
            C.setLayerType(0, null);
        }
    }

    protected final void e()
    {
        c = false;
        if (k != null)
        {
            k.recycle();
            k = null;
        }
    }

    protected void f()
    {
        removeCallbacks(ab);
        ad.e();
        d();
    }

    protected final void g()
    {
        int i1 = 0;
        long l1 = SystemClock.uptimeMillis();
        MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        for (int j1 = getChildCount(); i1 < j1; i1++)
        {
            getChildAt(i1).dispatchTouchEvent(motionevent);
        }

        D.dispatchTouchEvent(motionevent);
        motionevent.recycle();
    }

    public boolean getOffsetMenuEnabled()
    {
        return m;
    }

    public int getTouchBezelSize()
    {
        return H;
    }

    public int getTouchMode()
    {
        return J;
    }

    protected final void h()
    {
        o = true;
        i();
        c();
        s();
    }

    protected abstract void i();

    protected final void j()
    {
        removeCallbacks(ac);
        removeCallbacks(b);
        d();
        o = false;
    }

    protected final boolean k()
    {
        return Math.abs(W) <= (float)n;
    }

    public void setHardwareLayerEnabled(boolean flag)
    {
        if (flag != K)
        {
            K = flag;
            C.a(flag);
            D.a(flag);
            d();
        }
    }

    public void setMenuSize(int i1)
    {
        E = i1;
        if (G == 8 || G == 4)
        {
            setOffsetPixels(E);
        }
        requestLayout();
        invalidate();
    }

    public void setOffsetMenuEnabled(boolean flag)
    {
        if (flag != m)
        {
            m = flag;
            requestLayout();
            invalidate();
        }
    }

    public void setTouchBezelSize(int i1)
    {
        H = i1;
    }

    public void setTouchMode(int i1)
    {
        if (J != i1)
        {
            J = i1;
            q();
        }
    }

}
