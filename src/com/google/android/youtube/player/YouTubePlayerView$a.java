// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.view.View;
import com.google.android.youtube.player.internal.s;
import java.util.Set;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubePlayerView

final class <init>
    implements android.view.lobalFocusChangeListener
{

    final YouTubePlayerView a;

    public final void onGlobalFocusChanged(View view, View view1)
    {
        if (YouTubePlayerView.d(a) != null && YouTubePlayerView.i(a).contains(view1) && !YouTubePlayerView.i(a).contains(view))
        {
            YouTubePlayerView.d(a).g();
        }
    }

    private ner(YouTubePlayerView youtubeplayerview)
    {
        a = youtubeplayerview;
        super();
    }

    a(YouTubePlayerView youtubeplayerview, byte byte0)
    {
        this(youtubeplayerview);
    }
}
