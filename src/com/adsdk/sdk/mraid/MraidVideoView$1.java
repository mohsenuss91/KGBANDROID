// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.media.MediaPlayer;

// Referenced classes of package com.adsdk.sdk.mraid:
//            MraidVideoView

class eVideoViewListener
    implements android.media.pletionListener
{

    final MraidVideoView this$0;
    private final eVideoViewListener val$baseVideoViewListener;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (val$baseVideoViewListener != null)
        {
            val$baseVideoViewListener.videoCompleted(true);
        }
    }

    eVideoViewListener()
    {
        this$0 = final_mraidvideoview;
        val$baseVideoViewListener = eVideoViewListener.this;
        super();
    }
}
