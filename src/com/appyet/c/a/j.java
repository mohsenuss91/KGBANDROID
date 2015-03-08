// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c.a;

import android.content.DialogInterface;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.appyet.c.a:
//            i

final class j
    implements android.content.DialogInterface.OnClickListener
{

    final i a;

    j(i k)
    {
        a = k;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int k)
    {
        i.a(a).setCurrentItem(k);
        dialoginterface.dismiss();
    }
}
