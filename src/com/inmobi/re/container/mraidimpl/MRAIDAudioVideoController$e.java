// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.view.KeyEvent;
import android.view.View;
import com.inmobi.commons.internal.Log;
import com.inmobi.re.controller.util.AVPlayer;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDAudioVideoController

class a
    implements android.view.dioVideoController.e
{

    final MRAIDAudioVideoController a;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            Log.debug("[InMobi]-[RE]-4.4.1", "Back pressed while fullscreen video is playing");
            a.videoPlayer.releasePlayer(true);
        }
        return false;
    }

    (MRAIDAudioVideoController mraidaudiovideocontroller)
    {
        a = mraidaudiovideocontroller;
        super();
    }
}
