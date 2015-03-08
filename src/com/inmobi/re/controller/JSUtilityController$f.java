// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.inmobi.re.container.IMWebView;

// Referenced classes of package com.inmobi.re.controller:
//            JSUtilityController

class a extends BroadcastReceiver
{

    final JSUtilityController a;

    public void onReceive(Context context, Intent intent)
    {
        Cursor cursor;
        int i;
label0:
        {
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction()))
            {
                long l = intent.getLongExtra("extra_download_id", 0L);
                android.app.Controller.f f = new android.app.<init>();
                f.setFilterById(new long[] {
                    l
                });
                cursor = a.a.query(f);
                if (cursor.moveToFirst())
                {
                    i = cursor.getColumnIndex("status");
                    if (16 != cursor.getInt(i))
                    {
                        break label0;
                    }
                    a.imWebView.raiseError("download failed", "storePicture");
                }
            }
            return;
        }
        cursor.getInt(i);
    }

    (JSUtilityController jsutilitycontroller)
    {
        a = jsutilitycontroller;
        super();
    }
}
