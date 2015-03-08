// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView

class this._cls0
    implements android.media.aredListener
{

    final InlineVideoView this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        if (inlineParams.autoPlay)
        {
            InlineVideoView.access$400(InlineVideoView.this);
        }
        seekTo(inlineParams.currentPosition);
        if (inlineParams.autoPlay || !inlineParams.isInitialPlayBack)
        {
            getHeight();
        } else
        {
            inlineParams.isInitialPlayBack = false;
        }
        InlineVideoView.access$202(InlineVideoView.this, getDuration());
    }

    lineParams()
    {
        this$0 = InlineVideoView.this;
        super();
    }
}
