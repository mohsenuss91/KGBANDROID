// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.c;

import android.content.DialogInterface;

// Referenced classes of package com.appyet.c:
//            ah, r

final class y
    implements android.content.DialogInterface.OnClickListener
{

    final r a;

    y(r r)
    {
        a = r;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        switch (i)
        {
        default:
            return;

        case -1: 
            (new ah(a)).a(new Void[0]);
            break;
        }
    }
}
