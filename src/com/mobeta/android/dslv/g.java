// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;

// Referenced classes of package com.mobeta.android.dslv:
//            h, c, DragSortListView, d

final class g extends BaseAdapter
{

    final DragSortListView a;
    private ListAdapter b;

    public g(DragSortListView dragsortlistview, ListAdapter listadapter)
    {
        a = dragsortlistview;
        super();
        b = listadapter;
        b.registerDataSetObserver(new h(this, dragsortlistview));
    }

    public final ListAdapter a()
    {
        return b;
    }

    public final boolean areAllItemsEnabled()
    {
        return b.areAllItemsEnabled();
    }

    public final int getCount()
    {
        return b.getCount();
    }

    public final Object getItem(int i)
    {
        return b.getItem(i);
    }

    public final long getItemId(int i)
    {
        return b.getItemId(i);
    }

    public final int getItemViewType(int i)
    {
        return b.getItemViewType(i);
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj1;
        if (view != null)
        {
            obj1 = (c)view;
            View view2 = ((c) (obj1)).getChildAt(0);
            View view3 = b.getView(i, view2, a);
            if (view3 != view2)
            {
                if (view2 != null)
                {
                    ((c) (obj1)).removeViewAt(0);
                }
                ((c) (obj1)).addView(view3);
            }
        } else
        {
            View view1 = b.getView(i, null, a);
            Object obj;
            if (view1 instanceof Checkable)
            {
                obj = new d(a.getContext());
            } else
            {
                obj = new c(a.getContext());
            }
            ((c) (obj)).setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
            ((c) (obj)).addView(view1);
            obj1 = obj;
        }
        DragSortListView.a(a, i + a.getHeaderViewsCount(), ((View) (obj1)));
        return ((View) (obj1));
    }

    public final int getViewTypeCount()
    {
        return b.getViewTypeCount();
    }

    public final boolean hasStableIds()
    {
        return b.hasStableIds();
    }

    public final boolean isEmpty()
    {
        return b.isEmpty();
    }

    public final boolean isEnabled(int i)
    {
        return b.isEnabled(i);
    }
}
