// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import com.appyet.activity.MediaPlayerActivity;
import com.appyet.d.d;

// Referenced classes of package com.appyet.manager:
//            as

final class bc
    implements android.media.MediaPlayer.OnBufferingUpdateListener
{

    final as a;

    bc(as as1)
    {
        a = as1;
        super();
    }

    public final void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        try
        {
            if (as.j(a) != null && as.f(a) != null && as.f(a).isPlaying())
            {
                int j = (i * as.f(a).getDuration()) / 100;
                ((SeekBar)as.j(a).findViewById(0x7f0a00c7)).setSecondaryProgress(j);
            }
            return;
        }
        catch (Exception exception)
        {
            d.a(exception);
        }
    }
}
