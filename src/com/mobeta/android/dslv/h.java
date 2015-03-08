// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.database.DataSetObserver;

// Referenced classes of package com.mobeta.android.dslv:
//            g, DragSortListView

final class h extends DataSetObserver
{

    final DragSortListView a;
    final g b;

    h(g g1, DragSortListView dragsortlistview)
    {
        b = g1;
        a = dragsortlistview;
        super();
    }

    public final void onChanged()
    {
        b.notifyDataSetChanged();
    }

    public final void onInvalidated()
    {
        b.notifyDataSetInvalidated();
    }
}
