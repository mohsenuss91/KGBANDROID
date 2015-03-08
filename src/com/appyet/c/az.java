// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.view.View;
import android.widget.AdapterView;
import com.appyet.activity.MainActivity;

// Referenced classes of package com.appyet.c:
//            bb, ay

final class az
    implements android.widget.AdapterView.OnItemClickListener
{

    final ay a;

    az(ay ay1)
    {
        a = ay1;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        bb bb1 = (bb)adapterview.getItemAtPosition(i);
        a.b.a(bb1.c, bb1.d, bb1.h);
    }
}
