// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Context;
import android.widget.MediaController;
import android.widget.VideoView;
import com.actionbarsherlock.app.ActionBar;

// Referenced classes of package com.appyet.activity:
//            VideoPlayerActivity

final class af extends MediaController
{

    final VideoPlayerActivity a;

    af(VideoPlayerActivity videoplayeractivity, Context context)
    {
        a = videoplayeractivity;
        super(context);
    }

    public final void hide()
    {
        a.getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            VideoPlayerActivity.a(a).setSystemUiVisibility(1);
        }
        super.hide();
    }

    public final void show()
    {
        a.getSupportActionBar().show();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            VideoPlayerActivity.a(a).setSystemUiVisibility(0);
        }
        super.show();
    }
}
