// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.appyet.activity:
//            c, CustomizeActivity, MainActivity

final class a
    implements android.widget.AdapterView.OnItemClickListener
{

    final CustomizeActivity a;

    a(CustomizeActivity customizeactivity)
    {
        a = customizeactivity;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        c c1 = (c)adapterview.getItemAtPosition(i);
        a.b.a(c1.c, c1.d, c1.h);
    }
}
