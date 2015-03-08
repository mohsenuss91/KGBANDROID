// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.widget.VideoView;

// Referenced classes of package com.millennialmedia.android:
//            CachedVideoPlayerActivity, VideoAd

class entListener extends entListener
{

    final CachedVideoPlayerActivity this$0;

    public void onPageFinished(String s)
    {
        entListener((new StringBuilder("@@ ON PAGE FINISHED")).append(s).toString());
        if (mVideoView != null && CachedVideoPlayerActivity.access$000(CachedVideoPlayerActivity.this) != null && !mVideoView.isPlaying() && s.equalsIgnoreCase(CachedVideoPlayerActivity.access$000(CachedVideoPlayerActivity.this).webOverlayURL))
        {
            playVideo(0);
        }
    }

    entListener()
    {
        this$0 = CachedVideoPlayerActivity.this;
        super();
    }
}
