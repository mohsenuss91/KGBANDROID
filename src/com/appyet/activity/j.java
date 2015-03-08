// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.DialogInterface;
import java.io.File;

// Referenced classes of package com.appyet.activity:
//            DownloadActivity, l

final class j
    implements android.content.DialogInterface.OnClickListener
{

    final int a;
    final DownloadActivity b;

    j(DownloadActivity downloadactivity, int i)
    {
        b = downloadactivity;
        a = i;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        File file;
        switch (i)
        {
        default:
            return;

        case -1: 
            file = (File)DownloadActivity.a(b).getItem(a);
            break;
        }
        DownloadActivity.a(b).remove(file);
        file.delete();
        DownloadActivity.a(b).notifyDataSetChanged();
    }
}
