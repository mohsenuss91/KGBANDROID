// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.a.b;

import android.app.Activity;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import uk.co.senab.a.b.a.a;
import uk.co.senab.a.b.a.b;
import uk.co.senab.a.b.b.c;

// Referenced classes of package uk.co.senab.a.b:
//            m, h, e, f, 
//            k, l, c

public class j
{

    f a;
    b b;
    public Activity c;
    View d;
    a e;
    final int f;
    float g;
    float h;
    boolean i;
    boolean j;
    boolean k;
    View l;
    final WeakHashMap m = new WeakHashMap();
    final boolean n;
    private e o;
    private final float p;
    private float q;
    private float r;
    private final int s;
    private final boolean t;
    private boolean u;
    private final int v[] = new int[2];
    private final Rect w = new Rect();
    private final Runnable x = new m(this);

    public j(Activity activity, h h1)
    {
        u = false;
        if (activity == null)
        {
            throw new IllegalArgumentException("activity cannot be null");
        }
        if (h1 == null)
        {
            Log.i("PullToRefreshAttacher", "Given null options so using default options.");
            h1 = new h();
        }
        c = activity;
        p = h1.d;
        n = h1.e;
        s = h1.f;
        t = h1.g;
        e e1;
        f f1;
        ViewGroup viewgroup;
        if (h1.a != null)
        {
            e1 = h1.a;
        } else
        {
            e1 = a();
        }
        o = e1;
        if (h1.c != null)
        {
            f1 = h1.c;
        } else
        {
            f1 = b();
        }
        a = f1;
        f = ViewConfiguration.get(activity).getScaledTouchSlop();
        viewgroup = (ViewGroup)activity.getWindow().getDecorView();
        d = LayoutInflater.from(o.a(activity)).inflate(h1.b, viewgroup, false);
        if (d == null)
        {
            throw new IllegalArgumentException("Must supply valid layout id for header.");
        } else
        {
            d.setVisibility(4);
            a.a(activity, d);
            viewgroup.post(new k(this, viewgroup));
            return;
        }
    }

    private boolean a(boolean flag)
    {
        return !j && (!flag || b != null);
    }

    private void g()
    {
        b(d);
        if (a.a() && e != null)
        {
            a _tmp = e;
            View _tmp1 = d;
        }
    }

    private void h()
    {
        j = false;
        if (t)
        {
            d.removeCallbacks(x);
        }
        if (a.b() && e != null)
        {
            a _tmp = e;
            View _tmp1 = d;
        }
    }

    protected e a()
    {
        return new l(this);
    }

    public void a(View view)
    {
        c.getWindow().getDecorView().getWindowVisibleDisplayFrame(w);
        int i1 = -1;
        int j1 = -2;
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (layoutparams != null)
        {
            i1 = layoutparams.width;
            j1 = layoutparams.height;
        }
        android.view.WindowManager.LayoutParams layoutparams1 = new android.view.WindowManager.LayoutParams(i1, j1, 1000, 24, -3);
        layoutparams1.x = 0;
        layoutparams1.y = w.top;
        layoutparams1.gravity = 48;
        view.setTag(layoutparams1);
        c.getWindowManager().addView(view, layoutparams1);
    }

    final void a(boolean flag, boolean flag1)
    {
        if (!f() && j != flag)
        {
            d();
            if (flag && a(flag1))
            {
                j = true;
                if (flag1 && b != null)
                {
                    b.e();
                }
                a.f();
                g();
                if (t)
                {
                    if (s > 0)
                    {
                        d.postDelayed(x, s);
                        return;
                    } else
                    {
                        d.post(x);
                        return;
                    }
                }
            } else
            {
                h();
                return;
            }
        }
    }

    final boolean a(MotionEvent motionevent)
    {
        float f1;
        float f2;
        if (j)
        {
            return false;
        }
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 52
    //                   0 140
    //                   1 367
    //                   2 57
    //                   3 367;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        return i;
_L4:
        if (!i && q > 0.0F)
        {
            float f4 = f2 - q;
            if (f4 > f1 - r && f4 > (float)f)
            {
                i = true;
                g();
                h = f2;
            } else
            if (f4 < (float)(-f))
            {
                d();
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Iterator iterator;
        if (!a(true))
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator = m.keySet().iterator();
_L6:
        View view;
        boolean flag;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        view = (View)iterator.next();
        if (!view.isShown() || !m.containsKey(view))
        {
            break; /* Loop/switch isn't completed */
        }
        view.getLocationOnScreen(v);
        int i1 = v[0];
        int j1 = v[1];
        w.set(i1, j1, i1 + view.getWidth(), j1 + view.getHeight());
        int k1 = (int)motionevent.getRawX();
        int l1 = (int)motionevent.getRawY();
        if (!w.contains(k1, l1))
        {
            break; /* Loop/switch isn't completed */
        }
        c c1 = (c)m.get(view);
        if (c1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        float f3 = k1 - w.left;
        w.top;
        flag = c1.a(view, f3);
_L7:
        if (flag)
        {
            r = f1;
            q = f2;
            l = view;
        }
        if (true) goto _L6; else goto _L5
_L5:
        flag = false;
          goto _L7
          goto _L6
_L3:
        d();
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected f b()
    {
        return new uk.co.senab.a.b.c();
    }

    public void b(View view)
    {
        c.getWindow().getDecorView().getWindowVisibleDisplayFrame(w);
        if (!(view.getLayoutParams() instanceof android.view.WindowManager.LayoutParams)) goto _L2; else goto _L1
_L1:
        android.view.WindowManager.LayoutParams layoutparams = (android.view.WindowManager.LayoutParams)view.getLayoutParams();
_L4:
        if (layoutparams != null && layoutparams.y != w.top)
        {
            layoutparams.y = w.top;
            c.getWindowManager().updateViewLayout(view, layoutparams);
        }
        return;
_L2:
        boolean flag = view.getTag() instanceof android.view.WindowManager.LayoutParams;
        layoutparams = null;
        if (flag)
        {
            layoutparams = (android.view.WindowManager.LayoutParams)view.getTag();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void c()
    {
        if (u)
        {
            return;
        } else
        {
            c(d);
            m.clear();
            c = null;
            d = null;
            e = null;
            o = null;
            a = null;
            u = true;
            return;
        }
    }

    public void c(View view)
    {
        if (view.getWindowToken() != null)
        {
            c.getWindowManager().removeViewImmediate(view);
        }
    }

    final float d(View view)
    {
        return (float)view.getHeight() * p;
    }

    final void d()
    {
        i = false;
        k = false;
        h = -1F;
        g = -1F;
        q = -1F;
    }

    final void e()
    {
        if (!j)
        {
            h();
        }
    }

    final boolean f()
    {
        if (u)
        {
            Log.i("PullToRefreshAttacher", "PullToRefreshAttacher is destroyed.");
        }
        return u;
    }
}
