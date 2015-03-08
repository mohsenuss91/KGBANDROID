// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.ViewGroup;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayerListener;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDAudioVideoController

class a
    implements AVPlayerListener
{

    final com.inmobi.re.controller.s a;
    final MRAIDAudioVideoController b;

    public void onComplete(AVPlayer avplayer)
    {
        ViewGroup viewgroup1;
        if (!a.isFullScreen())
        {
            break MISSING_BLOCK_LABEL_37;
        }
        viewgroup1 = (ViewGroup)avplayer.getBackGroundLayout().getParent();
        ViewGroup viewgroup;
        if (viewgroup1 != null)
        {
            try
            {
                viewgroup1.removeView(avplayer.getBackGroundLayout());
                return;
            }
            catch (Exception exception)
            {
                Log.debug("[InMobi]-[RE]-4.4.1", "Problem removing the audio relativelayout", exception);
            }
        }
        break MISSING_BLOCK_LABEL_64;
        viewgroup = (ViewGroup)avplayer.getParent();
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        viewgroup.removeView(avplayer);
        return;
    }

    public void onError(AVPlayer avplayer)
    {
        onComplete(avplayer);
    }

    public void onPrepared(AVPlayer avplayer)
    {
    }

    (MRAIDAudioVideoController mraidaudiovideocontroller, com.inmobi.re.controller.s s)
    {
        b = mraidaudiovideocontroller;
        a = s;
        super();
    }
}
