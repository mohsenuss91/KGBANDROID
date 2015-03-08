// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.os.Handler;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView

class this._cls0
    implements android.media.letionListener
{

    final InlineVideoView this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        inlineParams.isCompleted = true;
        inlineParams.currentPosition = InlineVideoView.access$200(InlineVideoView.this);
        if (inlineParams.currentPosition == -1)
        {
            inlineParams.currentPosition = 0;
        }
        InlineVideoView.access$300(InlineVideoView.this);
    }

    lineParams()
    {
        this$0 = InlineVideoView.this;
        super();
    }
}
