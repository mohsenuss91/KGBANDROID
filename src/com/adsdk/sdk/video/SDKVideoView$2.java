// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            SDKVideoView, MediaController

class this._cls0
    implements android.media.reparedListener
{

    final SDKVideoView this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        Log.d("SDKVideoView onPrepared");
        SDKVideoView.access$0(SDKVideoView.this, 2);
        if (SDKVideoView.access$1(SDKVideoView.this) != null)
        {
            SDKVideoView.access$1(SDKVideoView.this).onPrepared(SDKVideoView.access$2(SDKVideoView.this));
        }
        if (SDKVideoView.access$3(SDKVideoView.this) != null)
        {
            SDKVideoView.access$3(SDKVideoView.this).setEnabled(true);
        }
        int i = SDKVideoView.access$4(SDKVideoView.this);
        if (i != 0)
        {
            seekTo(i);
        }
        if (!SDKVideoView.access$5(SDKVideoView.this))
        {
            Log.d("SDKVideoView onPrepared surface not ready yet");
        } else
        {
            SDKVideoView.access$6(SDKVideoView.this);
            if (SDKVideoView.access$7(SDKVideoView.this) == 3)
            {
                start();
                return;
            }
            if (!isPlaying() && (i != 0 || getCurrentPosition() > 0) && SDKVideoView.access$3(SDKVideoView.this) != null)
            {
                SDKVideoView.access$3(SDKVideoView.this).show(0);
                return;
            }
        }
    }

    ()
    {
        this$0 = SDKVideoView.this;
        super();
    }
}
