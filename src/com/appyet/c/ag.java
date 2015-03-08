// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.widget.AbsListView;
import com.a.a.b.a.j;
import com.appyet.context.ApplicationContext;
import com.appyet.context.f;
import com.appyet.f.h;

// Referenced classes of package com.appyet.c:
//            r, al

final class ag extends j
{

    final r a;

    public ag(r r1, com.a.a.b.f f1, boolean flag, boolean flag1)
    {
        a = r1;
        super(f1, flag, flag1);
    }

    public final void onScroll(AbsListView abslistview, int i, int k, int l)
    {
        if (r.a(a) == null || a.a.n.j) goto _L2; else goto _L1
_L1:
        abslistview.getId();
        JVM INSTR tableswitch 2131361922 2131361923: default 52
    //                   2131361922 62
    //                   2131361923 62;
           goto _L2 _L3 _L3
_L2:
        super.onScroll(abslistview, i, k, l);
        return;
_L3:
        if (i + k == l && (r.n(a) == null || r.n(a).d() == h.a || r.n(a).d() == h.c))
        {
            r.a(a, new al(a));
            r.n(a).a(new Void[0]);
        }
        if (true) goto _L2; else goto _L4
_L4:
    }
}
