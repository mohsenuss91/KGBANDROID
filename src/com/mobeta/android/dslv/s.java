// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            u, DragSortListView

final class s extends u
{

    final DragSortListView a;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public s(DragSortListView dragsortlistview, int i1)
    {
        a = dragsortlistview;
        super(dragsortlistview, i1);
        h = -1;
        i = -1;
    }

    public final void a()
    {
        int i1;
        float f1;
        i1 = -1;
        h = i1;
        i = i1;
        j = DragSortListView.m(a);
        k = DragSortListView.n(a);
        l = DragSortListView.i(a);
        DragSortListView.b(a, 1);
        e = DragSortListView.e(a).x;
        if (!DragSortListView.o(a))
        {
            break MISSING_BLOCK_LABEL_212;
        }
        f1 = 2.0F * (float)a.getWidth();
        if (DragSortListView.p(a) != 0.0F) goto _L2; else goto _L1
_L1:
        DragSortListView dragsortlistview = a;
        if (e >= 0.0F)
        {
            i1 = 1;
        }
        DragSortListView.a(dragsortlistview, f1 * (float)i1);
_L4:
        return;
_L2:
        float f2;
        f2 = f1 * 2.0F;
        if (DragSortListView.p(a) < 0.0F && DragSortListView.p(a) > -f2)
        {
            DragSortListView.a(a, -f2);
            return;
        }
        if (DragSortListView.p(a) <= 0.0F || DragSortListView.p(a) >= f2) goto _L4; else goto _L3
_L3:
        DragSortListView.a(a, f2);
        return;
        DragSortListView.q(a);
        return;
    }

    public final void a(float f1)
    {
        float f2;
        int i1;
        View view;
        f2 = 1.0F - f1;
        i1 = a.getFirstVisiblePosition();
        view = a.getChildAt(j - i1);
        if (!DragSortListView.o(a)) goto _L2; else goto _L1
_L1:
        float f3 = (float)(SystemClock.uptimeMillis() - b) / 1000F;
        if (f3 != 0.0F) goto _L4; else goto _L3
_L3:
        return;
_L4:
        float f4 = f3 * DragSortListView.p(a);
        int l1 = a.getWidth();
        DragSortListView dragsortlistview = a;
        int i2;
        if (DragSortListView.p(a) > 0.0F)
        {
            i2 = 1;
        } else
        {
            i2 = -1;
        }
        DragSortListView.b(dragsortlistview, f3 * (float)i2 * (float)l1);
        e = f4 + e;
        DragSortListView.e(a).x = (int)e;
        if (e < (float)l1 && e > (float)(-l1))
        {
            b = SystemClock.uptimeMillis();
            DragSortListView.g(a);
            return;
        }
_L2:
        if (view != null)
        {
            if (h == -1)
            {
                h = DragSortListView.b(a, j, view);
                f = view.getHeight() - h;
            }
            int k1 = Math.max((int)(f2 * f), 1);
            android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
            layoutparams1.height = k1 + h;
            view.setLayoutParams(layoutparams1);
        }
        if (k != j)
        {
            View view1 = a.getChildAt(k - i1);
            if (view1 != null)
            {
                if (i == -1)
                {
                    i = DragSortListView.b(a, k, view1);
                    g = view1.getHeight() - i;
                }
                int j1 = Math.max((int)(f2 * g), 1);
                android.view.ViewGroup.LayoutParams layoutparams = view1.getLayoutParams();
                layoutparams.height = j1 + i;
                view1.setLayoutParams(layoutparams);
                return;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final void b()
    {
        DragSortListView.r(a);
    }
}
