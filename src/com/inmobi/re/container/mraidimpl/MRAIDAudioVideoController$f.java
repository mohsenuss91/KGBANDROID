// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.ViewGroup;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.AVPlayer;
import com.inmobi.re.controller.util.AVPlayerListener;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDAudioVideoController

class a
    implements AVPlayerListener
{

    final MRAIDAudioVideoController a;

    public void onComplete(AVPlayer avplayer)
    {
        MRAIDAudioVideoController.a(a).setBusy(false);
        ViewGroup viewgroup = avplayer.getBackGroundLayout();
        if (viewgroup == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        ((ViewGroup)viewgroup.getParent()).removeView(avplayer.getBackGroundLayout());
        avplayer.setBackGroundLayout(null);
_L2:
        this;
        JVM INSTR monitorenter ;
        if (a.videoPlayer != null && avplayer.getPropertyID().equalsIgnoreCase(a.videoPlayer.getPropertyID()))
        {
            a.videoPlayer = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        Log.debug("[InMobi]-[RE]-4.4.1", "Problem removing the video framelayout or relativelayout depending on video startstyle", exception);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
        throw exception1;
    }

    public void onError(AVPlayer avplayer)
    {
        onComplete(avplayer);
    }

    public void onPrepared(AVPlayer avplayer)
    {
    }

    (MRAIDAudioVideoController mraidaudiovideocontroller)
    {
        a = mraidaudiovideocontroller;
        super();
    }
}
