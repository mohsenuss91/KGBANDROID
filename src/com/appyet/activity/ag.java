// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.media.MediaPlayer;
import android.widget.ProgressBar;
import android.widget.VideoView;

// Referenced classes of package com.appyet.activity:
//            VideoPlayerActivity

final class ag
    implements android.media.MediaPlayer.OnPreparedListener
{

    final VideoPlayerActivity a;

    ag(VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        VideoPlayerActivity.b(a).setVisibility(8);
        VideoPlayerActivity.a(a).start();
        VideoPlayerActivity.c(a);
    }
}
