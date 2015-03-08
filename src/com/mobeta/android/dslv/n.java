// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            u, DragSortListView

final class n extends u
{

    final DragSortListView a;
    private int e;
    private int f;
    private float g;
    private float h;

    public n(DragSortListView dragsortlistview, int i)
    {
        a = dragsortlistview;
        super(dragsortlistview, i);
    }

    private int d()
    {
        int i = a.getFirstVisiblePosition();
        int j = (DragSortListView.j(a) + a.getDividerHeight()) / 2;
        View view = a.getChildAt(e - i);
        if (view != null)
        {
            if (e == f)
            {
                return view.getTop();
            }
            if (e < f)
            {
                return view.getTop() - j;
            } else
            {
                return (j + view.getBottom()) - DragSortListView.k(a);
            }
        } else
        {
            super.c = true;
            return -1;
        }
    }

    public final void a()
    {
        e = DragSortListView.h(a);
        f = DragSortListView.i(a);
        DragSortListView.b(a, 2);
        g = DragSortListView.e(a).y - d();
        h = DragSortListView.e(a).x - a.getPaddingLeft();
    }

    public final void a(float f1)
    {
        int i = d();
        int j = a.getPaddingLeft();
        float f2 = DragSortListView.e(a).y - i;
        float f3 = DragSortListView.e(a).x - j;
        float f4 = 1.0F - f1;
        if (f4 < Math.abs(f2 / g) || f4 < Math.abs(f3 / h))
        {
            DragSortListView.e(a).y = i + (int)(f4 * g);
            DragSortListView.e(a).x = a.getPaddingLeft() + (int)(f4 * h);
            DragSortListView.g(a);
        }
    }

    public final void b()
    {
        DragSortListView.l(a);
    }
}
