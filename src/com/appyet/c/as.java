// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

// Referenced classes of package com.appyet.c:
//            ar, at

final class as extends FragmentPagerAdapter
{

    final ar a;

    public as(ar ar1, FragmentManager fragmentmanager)
    {
        a = ar1;
        super(fragmentmanager);
    }

    public final int getCount()
    {
        if (ar.a(a) != null)
        {
            return ar.a(a).size();
        } else
        {
            return 0;
        }
    }

    public final Fragment getItem(int i)
    {
        at at1 = new at();
        Bundle bundle = new Bundle();
        bundle.putString("IMAGE_LINK", (String)ar.a(a).get(i));
        at1.setArguments(bundle);
        return at1;
    }

    public final int getItemPosition(Object obj)
    {
        return -2;
    }
}
