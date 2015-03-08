// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;

// Referenced classes of package com.adsdk.sdk.video:
//            SDKVideoView

class this._cls0
    implements android.media.ufferingUpdateListener
{

    final SDKVideoView this$0;

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        SDKVideoView.access$13(SDKVideoView.this, i);
    }

    ngUpdateListener()
    {
        this$0 = SDKVideoView.this;
        super();
    }
}
