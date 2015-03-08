// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.appyet.context.ApplicationContext;
import com.appyet.d.d;
import com.appyet.f.v;
import com.appyet.manager.as;
import java.io.File;

// Referenced classes of package com.appyet.activity:
//            DownloadActivity, l, VideoPlayerActivity, MediaPlayerActivity

final class i
    implements android.widget.AdapterView.OnItemClickListener
{

    final DownloadActivity a;

    i(DownloadActivity downloadactivity)
    {
        a = downloadactivity;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int j, long l1)
    {
        File file;
        String s;
        file = (File)DownloadActivity.a(a).getItem(j);
        Intent intent;
        Intent intent2;
        try
        {
            s = v.a(file.getPath());
        }
        catch (Exception exception)
        {
            d.a(exception);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        if (s.contains("video"))
        {
            intent = new Intent(a.a, com/appyet/activity/VideoPlayerActivity);
            intent.putExtra("URL", Uri.fromFile(file).toString());
            intent.putExtra("TITLE", file.getName());
            a.a.startActivity(intent);
            return;
        }
        if (s.contains("audio"))
        {
            a.a.c.a(file);
            a.a.c.a(false);
            intent2 = new Intent(a.a, com/appyet/activity/MediaPlayerActivity);
            a.startActivity(intent2);
            return;
        }
        Intent intent1 = new Intent("android.intent.action.VIEW");
        intent1.setDataAndType(Uri.fromFile(file), s);
        a.a.startActivity(intent1);
        return;
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.fromFile(file));
        a.a.startActivity(intent3);
        return;
    }
}
