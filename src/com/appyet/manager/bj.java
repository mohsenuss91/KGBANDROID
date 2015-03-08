// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.SeekBar;
import android.widget.TextView;
import com.appyet.d.a;
import com.appyet.d.d;
import com.appyet.data.FeedItem;

public final class bj
    implements Runnable
{

    private Activity a;
    private MediaPlayer b;
    private FeedItem c;

    public bj()
    {
    }

    public final void a(Activity activity, MediaPlayer mediaplayer, FeedItem feeditem)
    {
        a = activity;
        b = mediaplayer;
        c = feeditem;
    }

    public final void run()
    {
        try
        {
            if (a != null)
            {
                TextView textview = (TextView)a.findViewById(0x7f0a00c8);
                TextView textview1 = (TextView)a.findViewById(0x7f0a00c9);
                SeekBar seekbar = (SeekBar)a.findViewById(0x7f0a00c7);
                if (b != null && b.isPlaying())
                {
                    textview.setText(com.appyet.d.a.a(b.getCurrentPosition()));
                    textview1.setText(com.appyet.d.a.a(b.getDuration()));
                    seekbar.setMax(b.getDuration());
                    seekbar.setProgress(b.getCurrentPosition());
                }
            }
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
