// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import com.google.android.youtube.player.internal.n;
import com.google.android.youtube.player.internal.s;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubePlayerView

final class a
    implements com.google.android.youtube.player.internal.
{

    final Activity a;
    final YouTubePlayerView b;

    public final void a()
    {
        if (YouTubePlayerView.a(b) != null)
        {
            YouTubePlayerView.a(b, a);
        }
        YouTubePlayerView.b(b);
    }

    public final void b()
    {
        if (!YouTubePlayerView.c(b) && YouTubePlayerView.d(b) != null)
        {
            YouTubePlayerView.d(b).f();
        }
        YouTubePlayerView.e(b).a();
        if (b.indexOfChild(YouTubePlayerView.e(b)) < 0)
        {
            b.addView(YouTubePlayerView.e(b));
            b.removeView(YouTubePlayerView.f(b));
        }
        YouTubePlayerView.g(b);
        YouTubePlayerView.h(b);
        YouTubePlayerView.b(b);
    }

    (YouTubePlayerView youtubeplayerview, Activity activity)
    {
        b = youtubeplayerview;
        a = activity;
        super();
    }
}
