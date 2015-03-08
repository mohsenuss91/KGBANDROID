// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import java.util.List;

// Referenced classes of package com.appyet.c:
//            a, k

final class g extends FragmentPagerAdapter
{

    final a a;

    public g(a a1, FragmentManager fragmentmanager)
    {
        a = a1;
        super(fragmentmanager);
    }

    public final int getCount()
    {
        if (com.appyet.c.a.a(a).n.b != null)
        {
            return com.appyet.c.a.a(a).n.b.size();
        } else
        {
            return 0;
        }
    }

    public final Fragment getItem(int i)
    {
        k k1 = new k();
        k1.a(i);
        return k1;
    }

    public final int getItemPosition(Object obj)
    {
        return -2;
    }
}
