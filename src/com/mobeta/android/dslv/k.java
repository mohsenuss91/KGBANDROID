// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.SystemClock;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView, j

final class k
    implements Runnable
{

    final DragSortListView a;
    private boolean b;
    private long c;
    private long d;
    private int e;
    private float f;
    private long g;
    private int h;
    private float i;
    private boolean j;

    public k(DragSortListView dragsortlistview)
    {
        a = dragsortlistview;
        super();
        j = false;
    }

    public final void a(int l)
    {
        if (!j)
        {
            b = false;
            j = true;
            g = SystemClock.uptimeMillis();
            c = g;
            h = l;
            a.post(this);
        }
    }

    public final boolean a()
    {
        return j;
    }

    public final int b()
    {
        if (j)
        {
            return h;
        } else
        {
            return -1;
        }
    }

    public final void c()
    {
        a.removeCallbacks(this);
        j = false;
    }

    public final void run()
    {
        if (b)
        {
            j = false;
            return;
        }
        int l = a.getFirstVisiblePosition();
        int i1 = a.getLastVisiblePosition();
        int j1 = a.getCount();
        int k1 = a.getPaddingTop();
        int l1 = a.getHeight() - k1 - a.getPaddingBottom();
        int i2 = Math.min(DragSortListView.f(a), DragSortListView.s(a) + DragSortListView.d(a));
        int j2 = Math.max(DragSortListView.f(a), DragSortListView.s(a) - DragSortListView.d(a));
        View view1;
        int k2;
        if (h == 0)
        {
            View view2 = a.getChildAt(0);
            if (view2 == null)
            {
                j = false;
                return;
            }
            if (l == 0 && view2.getTop() == k1)
            {
                j = false;
                return;
            }
            j j4 = DragSortListView.v(a);
            float f2 = (DragSortListView.t(a) - (float)j2) / DragSortListView.u(a);
            long _tmp = c;
            i = j4.a(f2);
        } else
        {
            View view = a.getChildAt(i1 - l);
            if (view == null)
            {
                j = false;
                return;
            }
            if (i1 == j1 - 1 && view.getBottom() <= l1 + k1)
            {
                j = false;
                return;
            }
            j j3 = DragSortListView.v(a);
            float f1 = ((float)i2 - DragSortListView.w(a)) / DragSortListView.x(a);
            long _tmp1 = c;
            i = -j3.a(f1);
        }
        d = SystemClock.uptimeMillis();
        f = d - c;
        e = Math.round(i * f);
        if (e >= 0)
        {
            e = Math.min(l1, e);
            i1 = l;
        } else
        {
            e = Math.max(-l1, e);
        }
        view1 = a.getChildAt(i1 - l);
        k2 = view1.getTop() + e;
        if (i1 == 0 && k2 > k1)
        {
            k2 = k1;
        }
        DragSortListView.a(a, true);
        a.setSelectionFromTop(i1, k2 - k1);
        a.layoutChildren();
        a.invalidate();
        DragSortListView.a(a, false);
        DragSortListView.c(a, i1, view1);
        c = d;
        a.post(this);
    }
}
