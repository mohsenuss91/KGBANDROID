// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.DownloadManager;
import android.net.Uri;
import android.view.View;
import com.appyet.context.ApplicationContext;
import com.appyet.manager.af;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.activity:
//            WebActionActivity

final class al
    implements android.view.View.OnClickListener
{

    final WebActionActivity a;

    al(WebActionActivity webactionactivity)
    {
        a = webactionactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            return;
        }
        WebActionActivity.b(a).l.a();
        DownloadManager downloadmanager = (DownloadManager)a.getSystemService("download");
        android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(Uri.parse(WebActionActivity.c(a)));
        String s = WebActionActivity.b(a).l.d(WebActionActivity.c(a));
        request.setDestinationUri(WebActionActivity.b(a).l.b(s));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            request.setNotificationVisibility(1);
        } else
        {
            request.setShowRunningNotification(true);
        }
        if (WebActionActivity.b(a).d.s())
        {
            request.setAllowedNetworkTypes(2);
        } else
        {
            request.setAllowedNetworkTypes(3);
        }
        request.setAllowedOverRoaming(false);
        request.setTitle(s);
        request.setDescription(WebActionActivity.c(a));
        downloadmanager.enqueue(request);
        a.finish();
    }
}
