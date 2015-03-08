// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.util.SparseIntArray;
import java.util.ArrayList;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

final class q
{

    SparseIntArray a;
    ArrayList b;
    int c;
    final DragSortListView d;

    public q(DragSortListView dragsortlistview)
    {
        d = dragsortlistview;
        super();
        a = new SparseIntArray(3);
        b = new ArrayList(3);
        c = 3;
    }
}
