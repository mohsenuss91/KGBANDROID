// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.media.MediaPlayer;

// Referenced classes of package com.appyet.activity:
//            VideoPlayerActivity

final class ah
    implements android.media.MediaPlayer.OnCompletionListener
{

    final VideoPlayerActivity a;

    ah(VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a.finish();
    }
}
