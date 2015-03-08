// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;
import com.appyet.f.v;

// Referenced classes of package com.appyet.activity:
//            VideoPlayerActivity

final class ai
    implements android.media.MediaPlayer.OnErrorListener
{

    final VideoPlayerActivity a;

    ai(VideoPlayerActivity videoplayeractivity)
    {
        a = videoplayeractivity;
        super();
    }

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (!VideoPlayerActivity.d(a))
        {
            Toast.makeText(VideoPlayerActivity.e(a), 0x7f08007b, 1).show();
            String s = v.a(VideoPlayerActivity.f(a));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(VideoPlayerActivity.f(a)));
            intent.setType(s);
            a.startActivity(intent);
            a.finish();
            return true;
        } else
        {
            Toast.makeText(VideoPlayerActivity.e(a), 0x7f08007a, 1).show();
            return false;
        }
    }
}
