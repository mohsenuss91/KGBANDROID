// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller.util;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.re.controller.util:
//            AVPlayer

class a extends Handler
{

    private final WeakReference a;

    public void handleMessage(Message message)
    {
        AVPlayer avplayer = (AVPlayer)a.get();
        if (avplayer == null) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR tableswitch 1001 1001: default 36
    //                   1001 42;
           goto _L2 _L3
_L2:
        super.handleMessage(message);
_L5:
        return;
_L3:
        if (!AVPlayer.a(avplayer)) goto _L5; else goto _L4
_L4:
        int i = Math.round(avplayer.getCurrentPosition() / 1000);
        int j = Math.round(avplayer.getDuration() / 1000);
        if (AVPlayer.b(avplayer) != i)
        {
            AVPlayer.a(avplayer, i, j);
            AVPlayer.a(avplayer, i);
            AVPlayer.b(avplayer, i);
        }
        sendEmptyMessageDelayed(1001, 1000L);
        if (true) goto _L2; else goto _L6
_L6:
    }

    public (AVPlayer avplayer)
    {
        a = new WeakReference(avplayer);
    }
}
