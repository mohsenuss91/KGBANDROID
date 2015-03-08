// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


// Referenced classes of package com.google.android.youtube.player:
//            YouTubeBaseActivity, YouTubePlayerView

final class <init>
    implements <init>
{

    final YouTubeBaseActivity a;

    public final void a(YouTubePlayerView youtubeplayerview)
    {
        if (YouTubeBaseActivity.c(a) != null && YouTubeBaseActivity.c(a) != youtubeplayerview)
        {
            YouTubeBaseActivity.c(a).b(true);
        }
        YouTubeBaseActivity.a(a, youtubeplayerview);
        if (YouTubeBaseActivity.d(a) > 0)
        {
            youtubeplayerview.a();
        }
        if (YouTubeBaseActivity.d(a) >= 2)
        {
            youtubeplayerview.b();
        }
    }

    public final void a(YouTubePlayerView youtubeplayerview, String s, lizedListener lizedlistener)
    {
        youtubeplayerview.a(a, youtubeplayerview, s, lizedlistener, YouTubeBaseActivity.a(a));
        YouTubeBaseActivity.b(a);
    }

    private lizedListener(YouTubeBaseActivity youtubebaseactivity)
    {
        a = youtubebaseactivity;
        super();
    }

    a(YouTubeBaseActivity youtubebaseactivity, byte byte0)
    {
        this(youtubebaseactivity);
    }
}
