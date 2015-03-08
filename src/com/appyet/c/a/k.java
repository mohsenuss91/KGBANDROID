// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.appyet.a.a.e;

// Referenced classes of package com.appyet.c.a:
//            i, l

final class k extends FragmentPagerAdapter
{

    final i a;

    public k(i j, FragmentManager fragmentmanager)
    {
        a = j;
        super(fragmentmanager);
    }

    public final int getCount()
    {
        if (i.c(a) != null)
        {
            return 1 + i.c(a).h / 10;
        } else
        {
            return 0;
        }
    }

    public final Fragment getItem(int j)
    {
        l l1 = new l();
        l1.a(j);
        l1.a(i.b(a));
        return l1;
    }

    public final int getItemPosition(Object obj)
    {
        return -2;
    }
}
