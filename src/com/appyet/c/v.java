// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.DialogInterface;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.c:
//            r, ae

final class v
    implements android.content.DialogInterface.OnClickListener
{

    final r a;

    v(r r1)
    {
        a = r1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.a.d.a(i);
        r.a(a).clear();
        a.c();
        dialoginterface.dismiss();
    }
}
