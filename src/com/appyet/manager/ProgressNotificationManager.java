// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.appyet.activity.MainActivity;
import com.appyet.d.d;

public class ProgressNotificationManager extends Notification
{

    private int a;
    private int b;
    private int c;
    private String d;
    private NotificationManager e;
    private Context f;

    public ProgressNotificationManager(Context context, int i, String s)
    {
        c = 0;
        f = context;
        a = 0x41a9aa;
        b = i;
        d = s;
        try
        {
            e = (NotificationManager)context.getSystemService("notification");
            icon = 0x1080081;
            flags = 2 | flags;
            Intent intent = new Intent(context, com/appyet/activity/MainActivity);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setAction("android.intent.action.MAIN");
            contentIntent = PendingIntent.getActivity(context, 0, intent, 0);
            contentView = new RemoteViews(context.getPackageName(), 0x7f03005d);
            contentView.setImageViewResource(0x7f0a00d9, 0x1080081);
            contentView.setProgressBar(0x7f0a00db, i, c, false);
            e.notify(0x41a9aa, this);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void a()
    {
        try
        {
            e.cancel(a);
            return;
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
        }
    }

    public final void a(int i, String s)
    {
        c = i;
        icon = 0x1080081;
        contentView = new RemoteViews(f.getPackageName(), 0x7f03005d);
        contentView.setImageViewResource(0x7f0a00d9, 0x1080081);
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        contentView.setTextViewText(0x7f0a00da, (new StringBuilder()).append(d).append(": ").append(s).toString());
_L1:
        contentView.setProgressBar(0x7f0a00db, b, c, false);
        e.notify(a, this);
        return;
        try
        {
            contentView.setTextViewText(0x7f0a00da, s);
        }
        catch (Exception exception)
        {
            com.appyet.d.d.a(exception);
            return;
        }
          goto _L1
    }

    public final int b()
    {
        return a;
    }
}
