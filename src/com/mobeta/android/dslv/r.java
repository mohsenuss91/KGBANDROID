// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.graphics.Point;

// Referenced classes of package com.mobeta.android.dslv:
//            u, DragSortListView

final class r extends u
{

    final DragSortListView a;
    private float e;
    private float f;

    public final void a()
    {
        e = DragSortListView.c(a);
        f = DragSortListView.d(a);
    }

    public final void a(float f1)
    {
        if (DragSortListView.b(a) != 4)
        {
            super.c = true;
            return;
        } else
        {
            DragSortListView.a(a, (int)(f1 * f + (1.0F - f1) * e));
            DragSortListView.e(a).y = DragSortListView.f(a) - DragSortListView.c(a);
            DragSortListView.g(a);
            return;
        }
    }
}
