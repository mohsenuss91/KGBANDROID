// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.database.DataSetObserver;

// Referenced classes of package android.support.v4.view:
//            ViewPager

final class bd extends DataSetObserver
{

    final ViewPager a;

    private bd(ViewPager viewpager)
    {
        a = viewpager;
        super();
    }

    bd(ViewPager viewpager, byte byte0)
    {
        this(viewpager);
    }

    public final void onChanged()
    {
        a.dataSetChanged();
    }

    public final void onInvalidated()
    {
        a.dataSetChanged();
    }
}
