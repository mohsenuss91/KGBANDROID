// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.adsdk.sdk.mraid:
//            BaseVideoView

class MraidVideoView extends BaseVideoView
{

    public MraidVideoView(Context context, Intent intent, final BaseVideoView.BaseVideoViewListener baseVideoViewListener)
    {
        super(context);
        setOnCompletionListener(new _cls1());
        setOnErrorListener(new _cls2());
        setVideoPath(intent.getStringExtra("video_url"));
    }

    private class _cls1
        implements android.media.MediaPlayer.OnCompletionListener
    {

        final MraidVideoView this$0;
        private final BaseVideoView.BaseVideoViewListener val$baseVideoViewListener;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            if (baseVideoViewListener != null)
            {
                baseVideoViewListener.videoCompleted(true);
            }
        }

        _cls1()
        {
            this$0 = MraidVideoView.this;
            baseVideoViewListener = basevideoviewlistener;
            super();
        }
    }


    private class _cls2
        implements android.media.MediaPlayer.OnErrorListener
    {

        final MraidVideoView this$0;
        private final BaseVideoView.BaseVideoViewListener val$baseVideoViewListener;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            if (baseVideoViewListener != null)
            {
                baseVideoViewListener.videoError(false);
            }
            return false;
        }

        _cls2()
        {
            this$0 = MraidVideoView.this;
            baseVideoViewListener = basevideoviewlistener;
            super();
        }
    }

}
