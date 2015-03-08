// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.app.DownloadManager;
import android.net.Uri;
import android.view.View;
import com.appyet.context.ApplicationContext;
import com.appyet.data.FeedItem;
import com.appyet.manager.af;
import com.appyet.manager.bp;

// Referenced classes of package com.appyet.activity:
//            PodcastActionActivity

final class x
    implements android.view.View.OnClickListener
{

    final PodcastActionActivity a;

    x(PodcastActionActivity podcastactionactivity)
    {
        a = podcastactionactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            return;
        }
        PodcastActionActivity.a(a).l.a();
        DownloadManager downloadmanager = (DownloadManager)a.getSystemService("download");
        android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(Uri.parse(PodcastActionActivity.b(a).getEnclosureLink()));
        String s = PodcastActionActivity.a(a).l.a(PodcastActionActivity.b(a).getTitle(), PodcastActionActivity.b(a).getEnclosureLink(), PodcastActionActivity.b(a).getEnclosureType());
        request.setDestinationUri(PodcastActionActivity.a(a).l.b(s));
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            request.setNotificationVisibility(1);
        } else
        {
            request.setShowRunningNotification(true);
        }
        if (PodcastActionActivity.a(a).d.s())
        {
            request.setAllowedNetworkTypes(2);
        } else
        {
            request.setAllowedNetworkTypes(3);
        }
        request.setAllowedOverRoaming(false);
        request.setTitle(s);
        request.setDescription(PodcastActionActivity.b(a).getEnclosureLink());
        downloadmanager.enqueue(request);
        a.finish();
    }
}
