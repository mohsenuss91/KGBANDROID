// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.c:
//            a

final class c
    implements android.content.DialogInterface.OnClickListener
{

    final a a;

    c(a a1)
    {
        a = a1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            com.appyet.c.a.a(a).d.W();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(com.appyet.c.a.a(a).getPackageName()).toString()));
            a.startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
