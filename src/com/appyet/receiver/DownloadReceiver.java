// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.appyet.activity.DownloadActivity;

public class DownloadReceiver extends BroadcastReceiver
{

    public DownloadReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        if (!"android.intent.action.DOWNLOAD_COMPLETE".equals(s) && ("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED".equals(s) || "android.intent.action.VIEW_DOWNLOADS".equals(s)))
        {
            context.startActivity(new Intent(context, com/appyet/activity/DownloadActivity));
        }
    }
}
