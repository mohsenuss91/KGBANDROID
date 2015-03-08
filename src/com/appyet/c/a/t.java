// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.widget.AbsListView;
import com.appyet.f.h;

// Referenced classes of package com.appyet.c.a:
//            r, y

final class t
    implements android.widget.AbsListView.OnScrollListener
{

    final r a;

    t(r r1)
    {
        a = r1;
        super();
    }

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (r.a(a) && i + j == k && !r.b(a) && (r.c(a) == null || r.c(a).d() == h.c))
        {
            r.a(a, new y(a, (byte)0));
            r.c(a).a(new Void[0]);
        }
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }
}
