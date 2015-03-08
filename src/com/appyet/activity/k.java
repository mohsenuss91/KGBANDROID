// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.DialogInterface;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.activity:
//            DownloadActivity, m

final class k
    implements android.content.DialogInterface.OnClickListener
{

    final DownloadActivity a;

    k(DownloadActivity downloadactivity)
    {
        a = downloadactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.a.d.h(i);
        (new m(a)).a(new Void[0]);
        dialoginterface.dismiss();
    }
}
