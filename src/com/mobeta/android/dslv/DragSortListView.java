// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

// Referenced classes of package com.mobeta.android.dslv:
//            e, q, w, m, 
//            a, x, k, s, 
//            n, f, c, p, 
//            r, g, o, i, 
//            t, j, l

public class DragSortListView extends ListView
{

    private View A[];
    private k B;
    private float C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private j L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private p U;
    private MotionEvent V;
    private int W;
    private float Z;
    private View a;
    private float aa;
    private g ab;
    private boolean ac;
    private m ad;
    private boolean ae;
    private boolean af;
    private q ag;
    private s ah;
    private r ai;
    private n aj;
    private boolean ak;
    private float al;
    private boolean am;
    private boolean an;
    private Point b;
    private Point c;
    private int d;
    private boolean e;
    private DataSetObserver f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private i r;
    private o s;
    private t t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public DragSortListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = new Point();
        c = new Point();
        e = false;
        g = 1.0F;
        h = 1.0F;
        l = false;
        u = true;
        v = 0;
        w = 1;
        z = 0;
        A = new View[1];
        C = 0.3333333F;
        D = 0.3333333F;
        K = 0.5F;
        L = new e(this);
        R = 0;
        S = false;
        T = false;
        U = null;
        W = 0;
        Z = 0.25F;
        aa = 0.0F;
        ac = false;
        ae = false;
        af = false;
        ag = new q(this);
        al = 0.0F;
        am = false;
        an = false;
        int i1 = 150;
        int j1 = 150;
        if (attributeset != null)
        {
            TypedArray typedarray = getContext().obtainStyledAttributes(attributeset, w.DragSortListView, 0, 0);
            w = Math.max(1, typedarray.getDimensionPixelSize(0, 1));
            ac = typedarray.getBoolean(5, false);
            if (ac)
            {
                ad = new m(this);
            }
            g = typedarray.getFloat(6, g);
            h = g;
            u = typedarray.getBoolean(10, u);
            Z = Math.max(0.0F, Math.min(1.0F, 1.0F - typedarray.getFloat(7, 0.75F)));
            boolean flag;
            int k1;
            int l1;
            if (Z > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l = flag;
            setDragScrollStart(typedarray.getFloat(1, C));
            K = typedarray.getFloat(2, K);
            k1 = typedarray.getInt(8, 150);
            l1 = typedarray.getInt(9, 150);
            if (typedarray.getBoolean(17, true))
            {
                boolean flag1 = typedarray.getBoolean(12, false);
                int i2 = typedarray.getInt(4, 1);
                boolean flag2 = typedarray.getBoolean(11, true);
                int j2 = typedarray.getInt(13, 0);
                int k2 = typedarray.getResourceId(14, 0);
                int l2 = typedarray.getResourceId(15, 0);
                int i3 = typedarray.getResourceId(16, 0);
                int j3 = typedarray.getColor(3, 0xff000000);
                a a1 = new a(this, k2, j2, i2, i3, l2);
                a1.b(flag1);
                a1.a(flag2);
                a1.a = j3;
                U = a1;
                setOnTouchListener(a1);
            }
            typedarray.recycle();
            j1 = l1;
            i1 = k1;
        }
        B = new k(this);
        if (i1 > 0)
        {
            ah = new s(this, i1);
        }
        if (j1 > 0)
        {
            aj = new n(this, j1);
        }
        V = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
        f = new f(this);
    }

    static float a(DragSortListView dragsortlistview)
    {
        return dragsortlistview.K;
    }

    static float a(DragSortListView dragsortlistview, float f1)
    {
        dragsortlistview.al = f1;
        return f1;
    }

    private int a(int i1, int j1)
    {
        int k1 = getHeaderViewsCount();
        int l1 = getFooterViewsCount();
        if (i1 <= k1 || i1 >= getCount() - l1)
        {
            return j1;
        }
        int i2 = getDividerHeight();
        int j2 = x - w;
        int k2 = c(i1);
        int l2 = b(i1);
        if (k <= m)
        {
            if (i1 == k && j != k)
            {
                if (i1 == m)
                {
                    j1 = (j1 + l2) - x;
                } else
                {
                    j1 = (j1 + (l2 - k2)) - j2;
                }
            } else
            if (i1 > k && i1 <= m)
            {
                j1 -= j2;
            }
        } else
        if (i1 > m && i1 <= j)
        {
            j1 += j2;
        } else
        if (i1 == k && j != k)
        {
            j1 += l2 - k2;
        }
        if (i1 <= m)
        {
            return j1 + (x - i2 - c(i1 - 1)) / 2;
        } else
        {
            return j1 + (k2 - i2 - x) / 2;
        }
    }

    static int a(DragSortListView dragsortlistview, int i1)
    {
        dragsortlistview.o = i1;
        return i1;
    }

    private void a(int i1, float f1)
    {
        if (v != 0 && v != 4) goto _L2; else goto _L1
_L1:
        if (v == 0)
        {
            m = i1 + getHeaderViewsCount();
            j = m;
            k = m;
            i = m;
            View view = getChildAt(m - getFirstVisiblePosition());
            if (view != null)
            {
                view.setVisibility(4);
            }
        }
        v = 1;
        al = f1;
        if (!T) goto _L4; else goto _L3
_L3:
        W;
        JVM INSTR tableswitch 1 2: default 124
    //                   1 139
    //                   2 151;
           goto _L4 _L5 _L6
_L4:
        if (ah == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ah.c();
_L2:
        return;
_L5:
        super.onTouchEvent(V);
        continue; /* Loop/switch isn't completed */
_L6:
        super.onInterceptTouchEvent(V);
        if (true) goto _L4; else goto _L7
_L7:
        f();
        return;
    }

    private void a(int i1, Canvas canvas)
    {
        Drawable drawable = getDivider();
        int j1 = getDividerHeight();
        if (drawable != null && j1 != 0)
        {
            ViewGroup viewgroup = (ViewGroup)getChildAt(i1 - getFirstVisiblePosition());
            if (viewgroup != null)
            {
                int k1 = getPaddingLeft();
                int l1 = getWidth() - getPaddingRight();
                int i2 = viewgroup.getChildAt(0).getHeight();
                int j2;
                int k2;
                if (i1 > m)
                {
                    k2 = i2 + viewgroup.getTop();
                    j2 = k2 + j1;
                } else
                {
                    j2 = viewgroup.getBottom() - i2;
                    k2 = j2 - j1;
                }
                canvas.save();
                canvas.clipRect(k1, k2, l1, j2);
                drawable.setBounds(k1, k2, l1, j2);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void a(int i1, View view, boolean flag)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        int j1;
        int k1;
        int l1;
        byte byte0;
        View view1;
        if (i1 != m && i1 != j && i1 != k)
        {
            j1 = -2;
        } else
        {
            j1 = b(i1, b(i1, view, flag));
        }
        if (j1 != layoutparams.height)
        {
            layoutparams.height = j1;
            view.setLayoutParams(layoutparams);
        }
        if (i1 != j && i1 != k) goto _L2; else goto _L1
_L1:
        if (i1 >= m) goto _L4; else goto _L3
_L3:
        ((c)view).setGravity(80);
_L2:
        k1 = view.getVisibility();
        l1 = m;
        byte0 = 0;
        if (i1 == l1)
        {
            view1 = a;
            byte0 = 0;
            if (view1 != null)
            {
                byte0 = 4;
            }
        }
        if (byte0 != k1)
        {
            view.setVisibility(byte0);
        }
        return;
_L4:
        if (i1 > m)
        {
            ((c)view).setGravity(48);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = 0xff & motionevent.getAction();
        if (i1 != 0)
        {
            O = M;
            P = N;
        }
        M = (int)motionevent.getX();
        N = (int)motionevent.getY();
        if (i1 == 0)
        {
            O = M;
            P = N;
        }
        p = (int)motionevent.getRawX() - M;
        q = (int)motionevent.getRawY() - N;
    }

    private void a(View view)
    {
        Object obj = view.getLayoutParams();
        if (obj == null)
        {
            obj = new android.widget.AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
        int i1 = ViewGroup.getChildMeasureSpec(z, getListPaddingLeft() + getListPaddingRight(), ((android.view.ViewGroup.LayoutParams) (obj)).width);
        int j1;
        if (((android.view.ViewGroup.LayoutParams) (obj)).height > 0)
        {
            j1 = android.view.View.MeasureSpec.makeMeasureSpec(((android.view.ViewGroup.LayoutParams) (obj)).height, 0x40000000);
        } else
        {
            j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i1, j1);
    }

    static void a(DragSortListView dragsortlistview, int i1, View view)
    {
        dragsortlistview.a(i1, view, true);
    }

    static boolean a(DragSortListView dragsortlistview, boolean flag)
    {
        dragsortlistview.ae = flag;
        return flag;
    }

    private boolean a(boolean flag, float f1)
    {
        View view = a;
        boolean flag1 = false;
        if (view != null)
        {
            B.c();
            if (flag)
            {
                a(m - getHeaderViewsCount(), f1);
            } else
            if (aj != null)
            {
                aj.c();
            } else
            {
                e();
            }
            if (ac)
            {
                m m1 = ad;
                if (m1.e)
                {
                    m1.a.append("</DSLVStates>\n");
                    m1.a();
                    m1.e = false;
                }
            }
            flag1 = true;
        }
        return flag1;
    }

    static float b(DragSortListView dragsortlistview, float f1)
    {
        float f2 = f1 + dragsortlistview.al;
        dragsortlistview.al = f2;
        return f2;
    }

    private int b(int i1)
    {
        View view = getChildAt(i1 - getFirstVisiblePosition());
        if (view != null)
        {
            return view.getHeight();
        } else
        {
            return b(i1, c(i1));
        }
    }

    private int b(int i1, int j1)
    {
        boolean flag;
        int k1;
        int l1;
        getDividerHeight();
        if (l && j != k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k1 = x - w;
        l1 = (int)(aa * (float)k1);
        if (i1 != m) goto _L2; else goto _L1
_L1:
        if (m != j) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        j1 = l1 + w;
_L8:
        return j1;
_L6:
        return x;
_L4:
        if (m == k)
        {
            return x - l1;
        } else
        {
            return w;
        }
_L2:
        if (i1 == j)
        {
            if (flag)
            {
                return j1 + l1;
            } else
            {
                return j1 + k1;
            }
        }
        if (i1 == k)
        {
            return (j1 + k1) - l1;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int b(int i1, View view, boolean flag)
    {
        int j1 = m;
        int k1 = 0;
        if (i1 != j1)
        {
            android.view.ViewGroup.LayoutParams layoutparams;
            if (i1 >= getHeaderViewsCount() && i1 < getCount() - getFooterViewsCount())
            {
                view = ((ViewGroup)view).getChildAt(0);
            }
            layoutparams = view.getLayoutParams();
            if (layoutparams != null && layoutparams.height > 0)
            {
                return layoutparams.height;
            }
            k1 = view.getHeight();
            if (k1 == 0 || flag)
            {
                a(view);
                return view.getMeasuredHeight();
            }
        }
        return k1;
    }

    static int b(DragSortListView dragsortlistview)
    {
        return dragsortlistview.v;
    }

    static int b(DragSortListView dragsortlistview, int i1)
    {
        dragsortlistview.v = i1;
        return i1;
    }

    static int b(DragSortListView dragsortlistview, int i1, View view)
    {
        return dragsortlistview.b(i1, view, false);
    }

    private int c(int i1)
    {
        int j1;
        if (i1 == m)
        {
            j1 = 0;
        } else
        {
            View view = getChildAt(i1 - getFirstVisiblePosition());
            if (view != null)
            {
                return b(i1, view, false);
            }
            j1 = ag.a.get(i1, -1);
            if (j1 == -1)
            {
                ListAdapter listadapter = getAdapter();
                int k1 = listadapter.getItemViewType(i1);
                int l1 = listadapter.getViewTypeCount();
                if (l1 != A.length)
                {
                    A = new View[l1];
                }
                View view1;
                int i2;
                q q1;
                int j2;
                if (k1 >= 0)
                {
                    if (A[k1] == null)
                    {
                        view1 = listadapter.getView(i1, null, this);
                        A[k1] = view1;
                    } else
                    {
                        view1 = listadapter.getView(i1, A[k1], this);
                    }
                } else
                {
                    view1 = listadapter.getView(i1, null, this);
                }
                i2 = b(i1, view1, true);
                q1 = ag;
                j2 = q1.a.get(i1, -1);
                if (j2 != i2)
                {
                    if (j2 == -1)
                    {
                        if (q1.a.size() == q1.c)
                        {
                            q1.a.delete(((Integer)q1.b.remove(0)).intValue());
                        }
                    } else
                    {
                        q1.b.remove(Integer.valueOf(i1));
                    }
                    q1.a.put(i1, i2);
                    q1.b.add(Integer.valueOf(i1));
                }
                return i2;
            }
        }
        return j1;
    }

    static int c(DragSortListView dragsortlistview)
    {
        return dragsortlistview.o;
    }

    private void c(int i1, View view, boolean flag)
    {
        int l3;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int j6;
        int k6;
        int i7;
        int l10;
        ae = true;
        if (U != null)
        {
            c.set(M, N);
            p p1 = U;
            a;
            Point point = b;
            c;
            p1.a(point);
        }
        int j1 = b.x;
        int k1 = b.y;
        int l1 = getPaddingLeft();
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int i4;
        View view1;
        int l6;
        int j7;
        int k7;
        float f1;
        int l7;
        int k9;
        int i10;
        int j10;
        if ((1 & R) == 0 && j1 > l1)
        {
            b.x = l1;
        } else
        if ((2 & R) == 0 && j1 < l1)
        {
            b.x = l1;
        }
        i2 = getHeaderViewsCount();
        j2 = getFooterViewsCount();
        k2 = getFirstVisiblePosition();
        l2 = getLastVisiblePosition();
        i3 = getPaddingTop();
        if (k2 < i2)
        {
            i3 = getChildAt(-1 + (i2 - k2)).getBottom();
        }
        if ((8 & R) == 0 && k2 <= m)
        {
            i3 = Math.max(getChildAt(m - k2).getTop(), i3);
        }
        j3 = getHeight() - getPaddingBottom();
        if (l2 >= -1 + (getCount() - j2))
        {
            j3 = getChildAt((-1 + (getCount() - j2)) - k2).getBottom();
        }
        if ((4 & R) == 0 && l2 >= m)
        {
            j3 = Math.min(getChildAt(m - k2).getBottom(), j3);
        }
        if (k1 < i3)
        {
            b.y = i3;
        } else
        if (k1 + x > j3)
        {
            b.y = j3 - x;
        }
        d = b.y + y;
        k3 = j;
        l3 = k;
        i4 = getFirstVisiblePosition();
        j4 = j;
        view1 = getChildAt(j4 - i4);
        if (view1 == null)
        {
            j4 = i4 + getChildCount() / 2;
            view1 = getChildAt(j4 - i4);
        }
        k4 = view1.getTop();
        l4 = view1.getHeight();
        i5 = a(j4, k4);
        j5 = getDividerHeight();
        if (d >= i5) goto _L2; else goto _L1
_L1:
        j6 = j4;
        k6 = i5;
_L8:
        if (j6 < 0) goto _L4; else goto _L3
_L3:
        j6--;
        l10 = b(j6);
        if (j6 != 0) goto _L6; else goto _L5
_L5:
        i5 = k4 - j5 - l10;
_L4:
        l6 = getHeaderViewsCount();
        i7 = getFooterViewsCount();
        j7 = j;
        k7 = k;
        f1 = aa;
        if (!l)
        {
            break MISSING_BLOCK_LABEL_1087;
        }
        k9 = Math.abs(i5 - k6);
        int k5;
        int l5;
        int i6;
        float f2;
        int k10;
        if (d >= i5)
        {
            int l9 = k6;
            k6 = i5;
            i5 = l9;
        }
        i10 = (int)(0.5F * Z * (float)k9);
        f2 = i10;
        j10 = k6 + i10;
        k10 = i5 - i10;
        if (d < j10)
        {
            j = j6 - 1;
            k = j6;
            aa = (0.5F * (float)(j10 - d)) / f2;
        } else
        {
            if (d < k10)
            {
                break MISSING_BLOCK_LABEL_1087;
            }
            j = j6;
            k = j6 + 1;
            aa = 0.5F * (1.0F + (float)(i5 - d) / f2);
        }
_L11:
label0:
        {
            {
                boolean flag1;
                boolean flag2;
                int i8;
                int j8;
                int k8;
                int l8;
                int i9;
                int j9;
                if (j < l6)
                {
                    j = l6;
                    k = l6;
                    j6 = l6;
                } else
                if (k >= getCount() - i7)
                {
                    j6 = -1 + (getCount() - i7);
                    j = j6;
                    k = j6;
                }
                if (j != j7 || k != k7 || aa != f1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (j6 != i)
                {
                    if (r != null)
                    {
                        r;
                        i;
                    }
                    i = j6;
                    flag2 = true;
                } else
                {
                    flag2 = flag1;
                }
                if (!flag2)
                {
                    break label0;
                }
                j();
                l7 = c(i1);
                i8 = view.getHeight();
                j8 = b(i1, l7);
                if (i1 != m)
                {
                    k8 = i8 - l7;
                    l8 = j8 - l7;
                } else
                {
                    k8 = i8;
                    l8 = j8;
                }
                i9 = x;
                if (m != j && m != k)
                {
                    i9 -= w;
                }
                if (i1 <= k3)
                {
                    if (i1 <= j)
                    {
                        break MISSING_BLOCK_LABEL_1231;
                    }
                    j9 = 0 + (i9 - l8);
                } else
                if (i1 == l3)
                {
                    if (i1 <= j)
                    {
                        j9 = 0 + (k8 - i9);
                    } else
                    if (i1 == k)
                    {
                        j9 = 0 + (i8 - j8);
                    } else
                    {
                        j9 = k8 + 0;
                    }
                } else
                if (i1 <= j)
                {
                    j9 = 0 - i9;
                } else
                {
                    if (i1 != k)
                    {
                        break MISSING_BLOCK_LABEL_1231;
                    }
                    j9 = 0 - l8;
                }
            }
            setSelectionFromTop(i1, (j9 + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (flag2 || flag)
        {
            invalidate();
        }
        ae = false;
        return;
_L6:
        k4 -= l10 + j5;
        i5 = a(j6, k4);
        if (d >= i5) goto _L4; else goto _L7
_L7:
        k6 = i5;
          goto _L8
_L2:
        k5 = getCount();
        l5 = k4;
        i6 = l4;
        j6 = j4;
        k6 = i5;
_L10:
        if (j6 < k5)
        {
label1:
            {
                if (j6 != k5 - 1)
                {
                    break label1;
                }
                i5 = i6 + (l5 + j5);
            }
        }
          goto _L4
        l5 += j5 + i6;
        i6 = b(j6 + 1);
        i5 = a(j6 + 1, l5);
        if (d < i5) goto _L4; else goto _L9
_L9:
        j6++;
        k6 = i5;
          goto _L10
        j = j6;
        k = j6;
          goto _L11
        j9 = 0;
        break MISSING_BLOCK_LABEL_791;
    }

    static void c(DragSortListView dragsortlistview, int i1, View view)
    {
        dragsortlistview.c(i1, view, false);
    }

    static int d(DragSortListView dragsortlistview)
    {
        return dragsortlistview.y;
    }

    private void d()
    {
        m = -1;
        j = -1;
        k = -1;
        i = -1;
    }

    static Point e(DragSortListView dragsortlistview)
    {
        return dragsortlistview.b;
    }

    private void e()
    {
        v = 2;
        if (s != null && i >= 0 && i < getCount())
        {
            getHeaderViewsCount();
            o _tmp = s;
            int _tmp1 = m;
            int _tmp2 = i;
        }
        m();
        g();
        d();
        j();
        if (T)
        {
            v = 3;
            return;
        } else
        {
            v = 0;
            return;
        }
    }

    static int f(DragSortListView dragsortlistview)
    {
        return dragsortlistview.N;
    }

    private void f()
    {
        v = 1;
        if (t != null)
        {
            t _tmp = t;
        }
        m();
        g();
        d();
        if (T)
        {
            v = 3;
            return;
        } else
        {
            v = 0;
            return;
        }
    }

    private void g()
    {
        int i1 = getFirstVisiblePosition();
        if (m < i1)
        {
            View view = getChildAt(0);
            int j1 = 0;
            if (view != null)
            {
                j1 = view.getTop();
            }
            setSelectionFromTop(i1 - 1, j1 - getPaddingTop());
        }
    }

    static void g(DragSortListView dragsortlistview)
    {
        dragsortlistview.l();
    }

    static int h(DragSortListView dragsortlistview)
    {
        return dragsortlistview.i;
    }

    private void h()
    {
        W = 0;
        T = false;
        if (v == 3)
        {
            v = 0;
        }
        h = g;
        am = false;
        q q1 = ag;
        q1.a.clear();
        q1.b.clear();
    }

    static int i(DragSortListView dragsortlistview)
    {
        return dragsortlistview.m;
    }

    private void i()
    {
        int i1 = getPaddingTop();
        int j1 = getHeight() - i1 - getPaddingBottom();
        float f1 = j1;
        H = (float)i1 + f1 * C;
        G = (float)i1 + f1 * (1.0F - D);
        E = (int)H;
        F = (int)G;
        I = H - (float)i1;
        J = (float)(i1 + j1) - G;
    }

    static int j(DragSortListView dragsortlistview)
    {
        return dragsortlistview.w;
    }

    private void j()
    {
        int i1 = getFirstVisiblePosition();
        int j1 = getLastVisiblePosition();
        int k1 = Math.max(0, getHeaderViewsCount() - i1);
        for (int l1 = Math.min(j1 - i1, (-1 + getCount()) - getFooterViewsCount() - i1); k1 <= l1; k1++)
        {
            View view = getChildAt(k1);
            if (view != null)
            {
                a(i1 + k1, view, false);
            }
        }

    }

    static int k(DragSortListView dragsortlistview)
    {
        return dragsortlistview.x;
    }

    private void k()
    {
        if (a != null)
        {
            a(a);
            x = a.getMeasuredHeight();
            y = x / 2;
        }
    }

    private void l()
    {
        int i1 = getFirstVisiblePosition() + getChildCount() / 2;
        View view = getChildAt(getChildCount() / 2);
        if (view == null)
        {
            return;
        } else
        {
            c(i1, view, true);
            return;
        }
    }

    static void l(DragSortListView dragsortlistview)
    {
        dragsortlistview.e();
    }

    static int m(DragSortListView dragsortlistview)
    {
        return dragsortlistview.j;
    }

    private void m()
    {
        if (a != null)
        {
            a.setVisibility(8);
            if (U != null)
            {
                U.a(a);
            }
            a = null;
            invalidate();
        }
    }

    static int n(DragSortListView dragsortlistview)
    {
        return dragsortlistview.k;
    }

    static boolean o(DragSortListView dragsortlistview)
    {
        return dragsortlistview.ak;
    }

    static float p(DragSortListView dragsortlistview)
    {
        return dragsortlistview.al;
    }

    static void q(DragSortListView dragsortlistview)
    {
        dragsortlistview.m();
    }

    static void r(DragSortListView dragsortlistview)
    {
        int _tmp = dragsortlistview.m;
        dragsortlistview.getHeaderViewsCount();
        dragsortlistview.f();
    }

    static int s(DragSortListView dragsortlistview)
    {
        return dragsortlistview.d;
    }

    static float t(DragSortListView dragsortlistview)
    {
        return dragsortlistview.H;
    }

    static float u(DragSortListView dragsortlistview)
    {
        return dragsortlistview.I;
    }

    static j v(DragSortListView dragsortlistview)
    {
        return dragsortlistview.L;
    }

    static float w(DragSortListView dragsortlistview)
    {
        return dragsortlistview.G;
    }

    static float x(DragSortListView dragsortlistview)
    {
        return dragsortlistview.J;
    }

    public final void a()
    {
label0:
        {
            if (v == 4)
            {
                B.c();
                m();
                d();
                j();
                if (!T)
                {
                    break label0;
                }
                v = 3;
            }
            return;
        }
        v = 0;
    }

    public final void a(int i1)
    {
        ak = false;
        a(i1, 0.0F);
    }

    public final boolean a(float f1)
    {
        ak = true;
        return a(true, f1);
    }

    public final boolean a(int i1, int j1, int k1, int l1)
    {
        if (T && U != null) goto _L2; else goto _L1
_L1:
        View view;
        return false;
_L2:
        if ((view = U.a(i1)) == null || v != 0 || !T || a != null || view == null || !u) goto _L1; else goto _L3
_L3:
        if (getParent() != null)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int i2 = i1 + getHeaderViewsCount();
        j = i2;
        k = i2;
        m = i2;
        i = i2;
        v = 4;
        R = 0;
        R = j1 | R;
        a = view;
        k();
        n = k1;
        o = l1;
        Q = N;
        b.x = M - n;
        b.y = N - o;
        View view1 = getChildAt(m - getFirstVisiblePosition());
        if (view1 != null)
        {
            view1.setVisibility(4);
        }
        if (ac)
        {
            m m1 = ad;
            m1.a.append("<DSLVStates>\n");
            m1.d = 0;
            m1.e = true;
        }
        W;
        JVM INSTR tableswitch 1 2: default 284
    //                   1 304
    //                   2 316;
           goto _L4 _L5 _L6
_L4:
        requestLayout();
        if (ai != null)
        {
            ai.c();
        }
        return true;
_L5:
        super.onTouchEvent(V);
        continue; /* Loop/switch isn't completed */
_L6:
        super.onInterceptTouchEvent(V);
        if (true) goto _L4; else goto _L7
_L7:
    }

    public final boolean b()
    {
        return am;
    }

    public final boolean c()
    {
        return u;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (v != 0)
        {
            if (j != m)
            {
                a(j, canvas);
            }
            if (k != j && k != m)
            {
                a(k, canvas);
            }
        }
        if (a != null)
        {
            int i1 = a.getWidth();
            int j1 = a.getHeight();
            int k1 = b.x;
            int l1 = getWidth();
            if (k1 < 0)
            {
                k1 = -k1;
            }
            float f1;
            int i2;
            if (k1 < l1)
            {
                float f2 = (float)(l1 - k1) / (float)l1;
                f1 = f2 * f2;
            } else
            {
                f1 = 0.0F;
            }
            i2 = (int)(f1 * (255F * h));
            canvas.save();
            canvas.translate(b.x, b.y);
            canvas.clipRect(0, 0, i1, j1);
            canvas.saveLayerAlpha(0.0F, 0.0F, i1, j1, i2, 31);
            a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public float getFloatAlpha()
    {
        return h;
    }

    public ListAdapter getInputAdapter()
    {
        if (ab == null)
        {
            return null;
        } else
        {
            return ab.a();
        }
    }

    protected void layoutChildren()
    {
        super.layoutChildren();
        if (a != null)
        {
            if (a.isLayoutRequested() && !e)
            {
                k();
            }
            a.layout(0, 0, a.getMeasuredWidth(), a.getMeasuredHeight());
            e = false;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (ac)
        {
            m m1 = ad;
            if (m1.e)
            {
                m1.a.append("<DSLVState>\n");
                int i1 = m1.f.getChildCount();
                int j1 = m1.f.getFirstVisiblePosition();
                m1.a.append("    <Positions>");
                for (int k1 = 0; k1 < i1; k1++)
                {
                    m1.a.append(j1 + k1).append(",");
                }

                m1.a.append("</Positions>\n");
                m1.a.append("    <Tops>");
                for (int l1 = 0; l1 < i1; l1++)
                {
                    m1.a.append(m1.f.getChildAt(l1).getTop()).append(",");
                }

                m1.a.append("</Tops>\n");
                m1.a.append("    <Bottoms>");
                for (int i2 = 0; i2 < i1; i2++)
                {
                    m1.a.append(m1.f.getChildAt(i2).getBottom()).append(",");
                }

                m1.a.append("</Bottoms>\n");
                m1.a.append("    <FirstExpPos>").append(m1.f.j).append("</FirstExpPos>\n");
                m1.a.append("    <FirstExpBlankHeight>").append(m1.f.b(m1.f.j) - m1.f.c(m1.f.j)).append("</FirstExpBlankHeight>\n");
                m1.a.append("    <SecondExpPos>").append(m1.f.k).append("</SecondExpPos>\n");
                m1.a.append("    <SecondExpBlankHeight>").append(m1.f.b(m1.f.k) - m1.f.c(m1.f.k)).append("</SecondExpBlankHeight>\n");
                m1.a.append("    <SrcPos>").append(m1.f.m).append("</SrcPos>\n");
                m1.a.append("    <SrcHeight>").append(m1.f.x + m1.f.getDividerHeight()).append("</SrcHeight>\n");
                m1.a.append("    <ViewHeight>").append(m1.f.getHeight()).append("</ViewHeight>\n");
                m1.a.append("    <LastY>").append(m1.f.P).append("</LastY>\n");
                m1.a.append("    <FloatY>").append(m1.f.d).append("</FloatY>\n");
                m1.a.append("    <ShuffleEdges>");
                for (int j2 = 0; j2 < i1; j2++)
                {
                    m1.a.append(m1.f.a(j1 + j2, m1.f.getChildAt(j2).getTop())).append(",");
                }

                m1.a.append("</ShuffleEdges>\n");
                m1.a.append("</DSLVState>\n");
                m1.c = 1 + m1.c;
                if (m1.c > 1000)
                {
                    m1.a();
                    m1.c = 0;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        if (!u)
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        a(motionevent);
        S = true;
        i1 = 0xff & motionevent.getAction();
        if (i1 == 0)
        {
            if (v != 0)
            {
                af = true;
                return true;
            }
            T = true;
        }
        if (a == null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        if (i1 == 1 || i1 == 3)
        {
            T = false;
        }
        return flag;
_L2:
        if (super.onInterceptTouchEvent(motionevent))
        {
            am = true;
            flag = true;
        } else
        {
            flag = false;
        }
        switch (i1)
        {
        case 2: // '\002'
        default:
            if (flag)
            {
                W = 1;
            } else
            {
                W = 2;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            h();
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        if (a != null)
        {
            if (a.isLayoutRequested())
            {
                k();
            }
            e = true;
        }
        z = i1;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        i();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        if (!af) goto _L2; else goto _L1
_L1:
        af = false;
_L10:
        return flag;
_L2:
        if (!u)
        {
            return super.onTouchEvent(motionevent);
        }
        boolean flag1 = S;
        S = false;
        if (!flag1)
        {
            a(motionevent);
        }
        if (v != 4) goto _L4; else goto _L3
_L3:
        motionevent.getAction();
        0xff & motionevent.getAction();
        JVM INSTR tableswitch 1 3: default 96
    //                   1 117
    //                   2 144
    //                   3 98;
           goto _L5 _L6 _L7 _L8
_L5:
        return true;
_L8:
        if (v == 4)
        {
            a();
        }
        h();
        continue; /* Loop/switch isn't completed */
_L6:
        if (v == 4)
        {
            ak = false;
            a(false, 0.0F);
        }
        h();
        continue; /* Loop/switch isn't completed */
_L7:
        int j1 = (int)motionevent.getX();
        int k1 = (int)motionevent.getY();
        b.x = j1 - n;
        b.y = k1 - o;
        l();
        int l1 = Math.min(k1, d + y);
        int i2 = Math.max(k1, d - y);
        int j2 = B.b();
        if (l1 > P && l1 > F && j2 != 1)
        {
            if (j2 != -1)
            {
                B.c();
            }
            B.a(1);
        } else
        if (i2 < P && i2 < E && j2 != 0)
        {
            if (j2 != -1)
            {
                B.c();
            }
            B.a(0);
        } else
        if (i2 >= E && l1 <= F && B.a())
        {
            B.c();
        }
        if (true) goto _L5; else goto _L4
_L4:
        int i1 = v;
        flag = false;
        if (i1 == 0)
        {
            boolean flag2 = super.onTouchEvent(motionevent);
            flag = false;
            if (flag2)
            {
                flag = true;
            }
        }
        switch (0xff & motionevent.getAction())
        {
        case 2: // '\002'
        default:
            if (flag)
            {
                W = 1;
                return flag;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            h();
            return flag;
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void requestLayout()
    {
        if (!ae)
        {
            super.requestLayout();
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (listadapter != null)
        {
            ab = new g(this, listadapter);
            listadapter.registerDataSetObserver(f);
            if (listadapter instanceof o)
            {
                setDropListener((o)listadapter);
            }
            if (listadapter instanceof i)
            {
                setDragListener((i)listadapter);
            }
            if (listadapter instanceof t)
            {
                setRemoveListener((t)listadapter);
            }
        } else
        {
            ab = null;
        }
        super.setAdapter(ab);
    }

    public void setDragEnabled(boolean flag)
    {
        u = flag;
    }

    public void setDragListener(i i1)
    {
        r = i1;
    }

    public void setDragScrollProfile(j j1)
    {
        if (j1 != null)
        {
            L = j1;
        }
    }

    public void setDragScrollStart(float f1)
    {
        if (f1 > 0.5F)
        {
            D = 0.5F;
        } else
        {
            D = f1;
        }
        if (f1 > 0.5F)
        {
            C = 0.5F;
        } else
        {
            C = f1;
        }
        if (getHeight() != 0)
        {
            i();
        }
    }

    public void setDragSortListener(l l1)
    {
        setDropListener(l1);
        setDragListener(l1);
        setRemoveListener(l1);
    }

    public void setDropListener(o o1)
    {
        s = o1;
    }

    public void setFloatAlpha(float f1)
    {
        h = f1;
    }

    public void setFloatViewManager(p p1)
    {
        U = p1;
    }

    public void setMaxScrollSpeed(float f1)
    {
        K = f1;
    }

    public void setRemoveListener(t t1)
    {
        t = t1;
    }
}
