// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import com.appyet.activity.MediaPlayerActivity;
import com.appyet.context.ApplicationContext;

// Referenced classes of package com.appyet.manager:
//            as

public class MediaProgressNotification extends Notification
{

    private int a;
    private int b;
    private int c;
    private String d;
    private NotificationManager e;
    private ApplicationContext f;

    public MediaProgressNotification(ApplicationContext applicationcontext, int i)
    {
        c = 0;
        f = applicationcontext;
        a = 2;
        b = i;
        d = null;
        try
        {
            e = (NotificationManager)f.getSystemService("notification");
            icon = 0x7f0200eb;
            flags = 2 | flags;
            Intent intent = new Intent(f, com/appyet/activity/MediaPlayerActivity);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            contentIntent = PendingIntent.getActivity(f, 0, intent, 0);
            contentView = new RemoteViews(f.getPackageName(), 0x7f03005a);
            contentView.setImageViewResource(0x7f0a00d0, 0x7f0200eb);
            e.notify(2, this);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public final int a()
    {
        return a;
    }

    public final void a(int i, String s)
    {
        c = i;
        contentView = new RemoteViews(f.getPackageName(), 0x7f03005a);
        if (!f.c.m()) goto _L2; else goto _L1
_L1:
        contentView.setImageViewResource(0x7f0a00d0, 0x7f0200ea);
        icon = 0x7f0200ea;
_L3:
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        contentView.setTextViewText(0x7f0a00d1, (new StringBuilder()).append(d).append(": ").append(s).toString());
_L4:
        e.notify(a, this);
        return;
_L2:
        try
        {
            contentView.setImageViewResource(0x7f0a00d0, 0x7f0200eb);
            icon = 0x7f0200eb;
        }
        catch (Exception exception)
        {
            return;
        }
          goto _L3
        contentView.setTextViewText(0x7f0a00d1, s);
          goto _L4
    }

    public final void b()
    {
        try
        {
            e.cancel(a);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
