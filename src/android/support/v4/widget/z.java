// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.support.v4.view.ab;
import android.support.v4.view.w;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

// Referenced classes of package android.support.v4.widget:
//            aa, ab, p, q

public final class z
{

    private static final Interpolator v = new aa();
    private int a;
    private int b;
    private int c;
    private float d[];
    private float e[];
    private float f[];
    private float g[];
    private int h[];
    private int i[];
    private int j[];
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private p q;
    private final android.support.v4.widget.ab r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w;

    private static float a(float f1, float f2, float f3)
    {
        float f4 = Math.abs(f1);
        if (f4 < f2)
        {
            f3 = 0.0F;
        } else
        if (f4 > f3)
        {
            if (f1 <= 0.0F)
            {
                return -f3;
            }
        } else
        {
            return f1;
        }
        return f3;
    }

    private int a(int i1, int j1, int k1)
    {
        if (i1 == 0)
        {
            return 0;
        }
        int l1 = u.getWidth();
        int i2 = l1 / 2;
        float f1 = Math.min(1.0F, (float)Math.abs(i1) / (float)l1);
        float f2 = (float)i2 + (float)i2 * (float)Math.sin((float)(0.4712389167638204D * (double)(f1 - 0.5F)));
        int j2 = Math.abs(j1);
        int k2;
        if (j2 > 0)
        {
            k2 = 4 * Math.round(1000F * Math.abs(f2 / (float)j2));
        } else
        {
            k2 = (int)(256F * (1.0F + (float)Math.abs(i1) / (float)k1));
        }
        return Math.min(k2, 600);
    }

    private void a(float f1)
    {
        t = true;
        r.a(s, f1);
        t = false;
        if (a == 1)
        {
            c(0);
        }
    }

    private void a(float f1, float f2, int i1)
    {
        if (d == null || d.length <= i1)
        {
            float af[] = new float[i1 + 1];
            float af1[] = new float[i1 + 1];
            float af2[] = new float[i1 + 1];
            float af3[] = new float[i1 + 1];
            int ai[] = new int[i1 + 1];
            int ai1[] = new int[i1 + 1];
            int ai2[] = new int[i1 + 1];
            if (d != null)
            {
                System.arraycopy(d, 0, af, 0, d.length);
                System.arraycopy(e, 0, af1, 0, e.length);
                System.arraycopy(f, 0, af2, 0, f.length);
                System.arraycopy(g, 0, af3, 0, g.length);
                System.arraycopy(h, 0, ai, 0, h.length);
                System.arraycopy(i, 0, ai1, 0, i.length);
                System.arraycopy(j, 0, ai2, 0, j.length);
            }
            d = af;
            e = af1;
            f = af2;
            g = af3;
            h = ai;
            i = ai1;
            j = ai2;
        }
        float af4[] = d;
        f[i1] = f1;
        af4[i1] = f1;
        float af5[] = e;
        g[i1] = f2;
        af5[i1] = f2;
        int ai3[] = h;
        int j1 = (int)f1;
        int k1 = (int)f2;
        int l1 = u.getLeft() + o;
        int i2 = 0;
        if (j1 < l1)
        {
            i2 = 1;
        }
        if (k1 < u.getTop() + o)
        {
            i2 |= 4;
        }
        if (j1 > u.getRight() - o)
        {
            i2 |= 2;
        }
        if (k1 > u.getBottom() - o)
        {
            i2 |= 8;
        }
        ai3[i1] = i2;
        k = k | 1 << i1;
    }

    private boolean a(float f1, float f2, int i1, int j1)
    {
        float f3 = Math.abs(f1);
        float f4 = Math.abs(f2);
        if ((j1 & h[i1]) == j1 && (j1 & p) != 0 && (j1 & j[i1]) != j1 && (j1 & i[i1]) != j1 && (f3 > (float)b || f4 > (float)b))
        {
            if (f3 < f4 * 0.5F)
            {
                android.support.v4.widget.ab _tmp = r;
            }
            if ((j1 & i[i1]) == 0 && f3 > (float)b)
            {
                return true;
            }
        }
        return false;
    }

    private boolean a(int i1, int j1, int k1, int l1)
    {
        int i2 = s.getLeft();
        int j2 = s.getTop();
        int k2 = i1 - i2;
        int l2 = j1 - j2;
        if (k2 == 0 && l2 == 0)
        {
            q.c();
            c(0);
            return false;
        } else
        {
            View view = s;
            int i3 = b(k1, (int)n, (int)m);
            int j3 = b(l1, (int)n, (int)m);
            Math.abs(k2);
            Math.abs(l2);
            Math.abs(i3);
            Math.abs(j3);
            a(k2, i3, r.c(view));
            android.support.v4.widget.ab _tmp = r;
            a(l2, j3, 0);
            p p1 = q;
            q _tmp1 = p1.b;
            Object _tmp2 = p1.a;
            c(2);
            return true;
        }
    }

    private boolean a(View view, float f1)
    {
        if (view != null)
        {
            boolean flag;
            if (r.c(view) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            android.support.v4.widget.ab _tmp = r;
            if (flag && Math.abs(f1) > (float)b)
            {
                return true;
            }
        }
        return false;
    }

    private static int b(int i1, int j1, int k1)
    {
        int l1 = Math.abs(i1);
        if (l1 < j1)
        {
            k1 = 0;
        } else
        if (l1 > k1)
        {
            if (i1 <= 0)
            {
                return -k1;
            }
        } else
        {
            return i1;
        }
        return k1;
    }

    private void b(float f1, float f2, int i1)
    {
        int j1 = 1;
        if (!a(f1, f2, i1, j1))
        {
            j1 = 0;
        }
        if (a(f2, f1, i1, 4))
        {
            j1 |= 4;
        }
        if (a(f1, f2, i1, 2))
        {
            j1 |= 2;
        }
        if (a(f2, f1, i1, 8))
        {
            j1 |= 8;
        }
        if (j1 != 0)
        {
            int ai[] = i;
            ai[i1] = j1 | ai[i1];
            r.a(j1, i1);
        }
    }

    private void b(int i1)
    {
        if (d == null)
        {
            return;
        } else
        {
            d[i1] = 0.0F;
            e[i1] = 0.0F;
            f[i1] = 0.0F;
            g[i1] = 0.0F;
            h[i1] = 0;
            i[i1] = 0;
            j[i1] = 0;
            k = k & (-1 ^ 1 << i1);
            return;
        }
    }

    private boolean b(View view, int i1)
    {
        if (view == s && c == i1)
        {
            return true;
        }
        if (view != null && r.a(view))
        {
            c = i1;
            a(view, i1);
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean b(View view, int i1, int j1)
    {
        while (view == null || i1 < view.getLeft() || i1 >= view.getRight() || j1 < view.getTop() || j1 >= view.getBottom()) 
        {
            return false;
        }
        return true;
    }

    private void c(int i1)
    {
        if (a != i1)
        {
            a = i1;
            r.a(i1);
            if (i1 == 0)
            {
                s = null;
            }
        }
    }

    private void c(MotionEvent motionevent)
    {
        int i1 = android.support.v4.view.w.c(motionevent);
        for (int j1 = 0; j1 < i1; j1++)
        {
            int k1 = android.support.v4.view.w.b(motionevent, j1);
            float f1 = android.support.v4.view.w.c(motionevent, j1);
            float f2 = android.support.v4.view.w.d(motionevent, j1);
            f[k1] = f1;
            g[k1] = f2;
        }

    }

    private void i()
    {
        l.computeCurrentVelocity(1000, m);
        float f1 = a(ab.a(l, c), n, m);
        a(ab.b(l, c), n, m);
        a(f1);
    }

    public final int a()
    {
        return a;
    }

    public final void a(int i1)
    {
        p = i1;
    }

    public final void a(View view, int i1)
    {
        if (view.getParent() != u)
        {
            throw new IllegalArgumentException((new StringBuilder("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (")).append(u).append(")").toString());
        } else
        {
            s = view;
            c = i1;
            r.b(view);
            c(1);
            return;
        }
    }

    public final boolean a(int i1, int j1)
    {
        if (!t)
        {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        } else
        {
            return a(i1, j1, (int)ab.a(l, c), (int)ab.b(l, c));
        }
    }

    public final boolean a(MotionEvent motionevent)
    {
        int i1;
        int j1;
        i1 = android.support.v4.view.w.a(motionevent);
        j1 = android.support.v4.view.w.b(motionevent);
        if (i1 == 0)
        {
            e();
        }
        if (l == null)
        {
            l = VelocityTracker.obtain();
        }
        l.addMovement(motionevent);
        i1;
        JVM INSTR tableswitch 0 6: default 84
    //                   0 94
    //                   1 451
    //                   2 308
    //                   3 451
    //                   4 84
    //                   5 195
    //                   6 439;
           goto _L1 _L2 _L3 _L4 _L3 _L1 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_451;
_L7:
        float f6;
        float f7;
        int k2;
        View view2;
        return a == 1;
_L2:
        f6 = motionevent.getX();
        f7 = motionevent.getY();
        k2 = android.support.v4.view.w.b(motionevent, 0);
        a(f6, f7, k2);
        view2 = b((int)f6, (int)f7);
        if (view2 == s && a == 2)
        {
            b(view2, k2);
        }
        if ((h[k2] & p) != 0)
        {
            android.support.v4.widget.ab ab2 = r;
            p;
            ab2.b();
        }
          goto _L7
_L5:
        int j2 = android.support.v4.view.w.b(motionevent, j1);
        float f4 = android.support.v4.view.w.c(motionevent, j1);
        float f5 = android.support.v4.view.w.d(motionevent, j1);
        a(f4, f5, j2);
        if (a == 0)
        {
            if ((h[j2] & p) != 0)
            {
                android.support.v4.widget.ab ab1 = r;
                p;
                ab1.b();
            }
        } else
        if (a == 2)
        {
            View view1 = b((int)f4, (int)f5);
            if (view1 == s)
            {
                b(view1, j2);
            }
        }
          goto _L7
_L4:
        int k1 = android.support.v4.view.w.c(motionevent);
        int l1 = 0;
        do
        {
            if (l1 >= k1)
            {
                break;
            }
            int i2 = android.support.v4.view.w.b(motionevent, l1);
            float f1 = android.support.v4.view.w.c(motionevent, l1);
            float f2 = android.support.v4.view.w.d(motionevent, l1);
            float f3 = f1 - d[i2];
            b(f3, f2 - e[i2], i2);
            if (a == 1)
            {
                break;
            }
            View view = b((int)f1, (int)f2);
            if (view != null && a(view, f3) && b(view, i2))
            {
                break;
            }
            l1++;
        } while (true);
        c(motionevent);
          goto _L7
_L6:
        b(android.support.v4.view.w.b(motionevent, j1));
          goto _L7
        e();
          goto _L7
    }

    public final boolean a(View view, int i1, int j1)
    {
        s = view;
        c = -1;
        return a(i1, j1, 0, 0);
    }

    public final int b()
    {
        return o;
    }

    public final View b(int i1, int j1)
    {
        for (int k1 = -1 + u.getChildCount(); k1 >= 0; k1--)
        {
            ViewGroup viewgroup = u;
            android.support.v4.widget.ab _tmp = r;
            View view = viewgroup.getChildAt(k1);
            if (i1 >= view.getLeft() && i1 < view.getRight() && j1 >= view.getTop() && j1 < view.getBottom())
            {
                return view;
            }
        }

        return null;
    }

    public final void b(MotionEvent motionevent)
    {
        int i1;
        int j1;
        int k1;
        i1 = 0;
        j1 = android.support.v4.view.w.a(motionevent);
        k1 = android.support.v4.view.w.b(motionevent);
        if (j1 == 0)
        {
            e();
        }
        if (l == null)
        {
            l = VelocityTracker.obtain();
        }
        l.addMovement(motionevent);
        j1;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 89
    //                   1 733
    //                   2 297
    //                   3 750
    //                   4 88
    //                   5 171
    //                   6 607;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return;
_L2:
        float f10 = motionevent.getX();
        float f11 = motionevent.getY();
        int l5 = android.support.v4.view.w.b(motionevent, 0);
        View view1 = b((int)f10, (int)f11);
        a(f10, f11, l5);
        b(view1, l5);
        if ((h[l5] & p) != 0)
        {
            android.support.v4.widget.ab ab2 = r;
            p;
            ab2.b();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        int i5;
        float f8;
        float f9;
        i5 = android.support.v4.view.w.b(motionevent, k1);
        f8 = android.support.v4.view.w.c(motionevent, k1);
        f9 = android.support.v4.view.w.d(motionevent, k1);
        a(f8, f9, i5);
        if (a != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        b(b((int)f8, (int)f9), i5);
        if ((h[i5] & p) != 0)
        {
            android.support.v4.widget.ab ab1 = r;
            p;
            ab1.b();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
        int j5 = (int)f8;
        int k5 = (int)f9;
        if (b(s, j5, k5))
        {
            b(s, i5);
            return;
        }
          goto _L1
_L4:
        if (a == 1)
        {
            int j3 = android.support.v4.view.w.a(motionevent, c);
            float f6 = android.support.v4.view.w.c(motionevent, j3);
            float f7 = android.support.v4.view.w.d(motionevent, j3);
            int k3 = (int)(f6 - f[c]);
            int l3 = (int)(f7 - g[c]);
            int i4 = k3 + s.getLeft();
            s.getTop();
            int j4 = s.getLeft();
            int k4 = s.getTop();
            if (k3 != 0)
            {
                i4 = r.b(s, i4);
                s.offsetLeftAndRight(i4 - j4);
            }
            if (l3 != 0)
            {
                int l4 = r.d(s);
                s.offsetTopAndBottom(l4 - k4);
            }
            if (k3 != 0 || l3 != 0)
            {
                r.a(s, i4);
            }
            c(motionevent);
            return;
        }
        int l2 = android.support.v4.view.w.c(motionevent);
        do
        {
            if (i1 >= l2)
            {
                break;
            }
            int i3 = android.support.v4.view.w.b(motionevent, i1);
            float f3 = android.support.v4.view.w.c(motionevent, i1);
            float f4 = android.support.v4.view.w.d(motionevent, i1);
            float f5 = f3 - d[i3];
            b(f5, f4 - e[i3], i3);
            if (a == 1)
            {
                break;
            }
            View view = b((int)f3, (int)f4);
            if (a(view, f5) && b(view, i3))
            {
                break;
            }
            i1++;
        } while (true);
        c(motionevent);
        return;
_L7:
        int l1 = android.support.v4.view.w.b(motionevent, k1);
        if (a != 1 || l1 != c) goto _L10; else goto _L9
_L9:
        int i2 = android.support.v4.view.w.c(motionevent);
_L16:
        if (i1 >= i2) goto _L12; else goto _L11
_L11:
        int k2 = android.support.v4.view.w.b(motionevent, i1);
        if (k2 == c) goto _L14; else goto _L13
_L13:
        float f1;
        float f2;
        f1 = android.support.v4.view.w.c(motionevent, i1);
        f2 = android.support.v4.view.w.d(motionevent, i1);
        if (b((int)f1, (int)f2) != s || !b(s, k2)) goto _L14; else goto _L15
_L15:
        int j2 = c;
_L17:
        if (j2 == -1)
        {
            i();
        }
_L10:
        b(l1);
        return;
_L14:
        i1++;
          goto _L16
_L3:
        if (a == 1)
        {
            i();
        }
        e();
        return;
_L5:
        if (a == 1)
        {
            a(0.0F);
        }
        e();
        return;
_L12:
        j2 = -1;
          goto _L17
    }

    public final View c()
    {
        return s;
    }

    public final int d()
    {
        return b;
    }

    public final void e()
    {
        c = -1;
        if (d != null)
        {
            Arrays.fill(d, 0.0F);
            Arrays.fill(e, 0.0F);
            Arrays.fill(f, 0.0F);
            Arrays.fill(g, 0.0F);
            Arrays.fill(h, 0);
            Arrays.fill(i, 0);
            Arrays.fill(j, 0);
            k = 0;
        }
        if (l != null)
        {
            l.recycle();
            l = null;
        }
    }

    public final void f()
    {
        e();
        if (a == 2)
        {
            q.a();
            q.b();
            q.c();
            int i1 = q.a();
            q.b();
            r.a(s, i1);
        }
        c(0);
    }

    public final boolean g()
    {
        if (a == 2)
        {
            p p1 = q;
            q q1 = p1.b;
            Object _tmp = p1.a;
            boolean flag = q1.d();
            int i1 = q.a();
            int j1 = q.b();
            int k1 = i1 - s.getLeft();
            int l1 = j1 - s.getTop();
            if (k1 != 0)
            {
                s.offsetLeftAndRight(k1);
            }
            if (l1 != 0)
            {
                s.offsetTopAndBottom(l1);
            }
            if (k1 != 0 || l1 != 0)
            {
                r.a(s, i1);
            }
            if (flag)
            {
                p p2 = q;
                q q2 = p2.b;
                Object _tmp1 = p2.a;
                if (i1 == q2.e())
                {
                    p p3 = q;
                    q q3 = p3.b;
                    Object _tmp2 = p3.a;
                    if (j1 == q3.f())
                    {
                        q.c();
                        p p4 = q;
                        q q4 = p4.b;
                        Object _tmp3 = p4.a;
                        flag = q4.a();
                    }
                }
            }
            if (!flag)
            {
                u.post(w);
            }
        }
        return a == 2;
    }

    public final boolean h()
    {
        int i1 = d.length;
        boolean flag;
        boolean flag1;
        for (int j1 = 0; j1 < i1; j1++)
        {
            if ((k & 1 << j1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                float f1 = f[j1] - d[j1];
                float f2 = g[j1] - e[j1];
                if (f1 * f1 + f2 * f2 > (float)(b * b))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                return true;
            }
        }

        return false;
    }

}
