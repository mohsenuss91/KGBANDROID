// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.youtube.player.internal.ac;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubePlayerView

public class YouTubePlayerSupportFragment extends Fragment
    implements YouTubePlayer.Provider
{

    private final a a = new a((byte)0);
    private Bundle b;
    private YouTubePlayerView c;
    private String d;
    private YouTubePlayer.OnInitializedListener e;

    public YouTubePlayerSupportFragment()
    {
    }

    static YouTubePlayer.OnInitializedListener a(YouTubePlayerSupportFragment youtubeplayersupportfragment)
    {
        return youtubeplayersupportfragment.e;
    }

    private void a()
    {
        if (c != null && e != null)
        {
            c.a(getActivity(), this, d, e, b);
            b = null;
            e = null;
        }
    }

    public static YouTubePlayerSupportFragment newInstance()
    {
        return new YouTubePlayerSupportFragment();
    }

    public void initialize(String s, YouTubePlayer.OnInitializedListener oninitializedlistener)
    {
        d = ac.a(s, "Developer key cannot be null or empty");
        e = oninitializedlistener;
        a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1;
        if (bundle != null)
        {
            bundle1 = bundle.getBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE");
        } else
        {
            bundle1 = null;
        }
        b = bundle1;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = new YouTubePlayerView(getActivity(), null, 0, a);
        a();
        return c;
    }

    public void onDestroy()
    {
        if (c != null)
        {
            FragmentActivity fragmentactivity = getActivity();
            YouTubePlayerView youtubeplayerview = c;
            boolean flag;
            if (fragmentactivity == null || fragmentactivity.isFinishing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            youtubeplayerview.a(flag);
        }
        super.onDestroy();
    }

    public void onDestroyView()
    {
        c.b(getActivity().isFinishing());
        c = null;
        super.onDestroyView();
    }

    public void onPause()
    {
        c.c();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        c.b();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Bundle bundle1;
        if (c != null)
        {
            bundle1 = c.e();
        } else
        {
            bundle1 = b;
        }
        bundle.putBundle("YouTubePlayerSupportFragment.KEY_PLAYER_VIEW_STATE", bundle1);
    }

    public void onStart()
    {
        super.onStart();
        c.a();
    }

    public void onStop()
    {
        c.d();
        super.onStop();
    }

    private class a
        implements YouTubePlayerView.b
    {

        final YouTubePlayerSupportFragment a;

        public final void a(YouTubePlayerView youtubeplayerview)
        {
        }

        public final void a(YouTubePlayerView youtubeplayerview, String s, YouTubePlayer.OnInitializedListener oninitializedlistener)
        {
            a.initialize(s, YouTubePlayerSupportFragment.a(a));
        }

        private a()
        {
            a = YouTubePlayerSupportFragment.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

}
