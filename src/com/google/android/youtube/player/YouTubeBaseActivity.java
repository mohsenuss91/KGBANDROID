// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubePlayerView

public class YouTubeBaseActivity extends Activity
{

    private a a;
    private YouTubePlayerView b;
    private int c;
    private Bundle d;

    public YouTubeBaseActivity()
    {
    }

    static Bundle a(YouTubeBaseActivity youtubebaseactivity)
    {
        return youtubebaseactivity.d;
    }

    static YouTubePlayerView a(YouTubeBaseActivity youtubebaseactivity, YouTubePlayerView youtubeplayerview)
    {
        youtubebaseactivity.b = youtubeplayerview;
        return youtubeplayerview;
    }

    static Bundle b(YouTubeBaseActivity youtubebaseactivity)
    {
        youtubebaseactivity.d = null;
        return null;
    }

    static YouTubePlayerView c(YouTubeBaseActivity youtubebaseactivity)
    {
        return youtubebaseactivity.b;
    }

    static int d(YouTubeBaseActivity youtubebaseactivity)
    {
        return youtubebaseactivity.c;
    }

    final YouTubePlayerView.b a()
    {
        return a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = new a((byte)0);
        Bundle bundle1;
        if (bundle != null)
        {
            bundle1 = bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE");
        } else
        {
            bundle1 = null;
        }
        d = bundle1;
    }

    protected void onDestroy()
    {
        if (b != null)
        {
            b.a(isFinishing());
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        c = 1;
        if (b != null)
        {
            b.c();
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        c = 2;
        if (b != null)
        {
            b.b();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Bundle bundle1;
        if (b != null)
        {
            bundle1 = b.e();
        } else
        {
            bundle1 = d;
        }
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", bundle1);
    }

    protected void onStart()
    {
        super.onStart();
        c = 1;
        if (b != null)
        {
            b.a();
        }
    }

    protected void onStop()
    {
        c = 0;
        if (b != null)
        {
            b.d();
        }
        super.onStop();
    }

    private class a
        implements YouTubePlayerView.b
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

        public final void a(YouTubePlayerView youtubeplayerview, String s, YouTubePlayer.OnInitializedListener oninitializedlistener)
        {
            youtubeplayerview.a(a, youtubeplayerview, s, oninitializedlistener, YouTubeBaseActivity.a(a));
            YouTubeBaseActivity.b(a);
        }

        private a()
        {
            a = YouTubeBaseActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

}
