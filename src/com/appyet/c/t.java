// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.appyet.c:
//            r

final class t
    implements android.widget.AdapterView.OnItemClickListener
{

    final r a;

    t(r r1)
    {
        a = r1;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        r.a(a, i);
    }
}
