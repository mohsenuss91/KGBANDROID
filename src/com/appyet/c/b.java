// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.DialogInterface;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.c:
//            a, g

final class b
    implements android.content.DialogInterface.OnClickListener
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        com.appyet.c.a.a(a).d.f(i);
        com.appyet.c.a.b(a).notifyDataSetChanged();
        dialoginterface.dismiss();
    }
}
