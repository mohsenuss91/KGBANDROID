// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;

import android.media.MediaPlayer;
import android.widget.SeekBar;
import com.appyet.d.d;
import com.appyet.data.FeedItem;

// Referenced classes of package com.appyet.manager:
//            as

final class az
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    final as a;

    az(as as1)
    {
        a = as1;
        super();
    }

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        int j;
        try
        {
            if (as.f(a) == null || !as.f(a).isPlaying())
            {
                break MISSING_BLOCK_LABEL_107;
            }
        }
        catch (Exception exception)
        {
            d.a(exception);
            return;
        }
        if (i < 0)
        {
            j = 0;
        } else
        {
            j = i;
        }
        if (j > as.f(a).getDuration())
        {
            j = -1 + as.f(a).getDuration();
        }
        if (as.h(a) != null)
        {
            as.h(a).setEnclosureCurrentPosition(Integer.valueOf(j));
        }
        as.f(a).seekTo(j);
        a.l();
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
    }
}
