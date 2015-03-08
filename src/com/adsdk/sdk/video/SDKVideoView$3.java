// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;

// Referenced classes of package com.adsdk.sdk.video:
//            SDKVideoView, MediaController

class this._cls0
    implements android.media.ompletionListener
{

    final SDKVideoView this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        SDKVideoView.access$0(SDKVideoView.this, 5);
        SDKVideoView.access$8(SDKVideoView.this, 5);
        if (SDKVideoView.access$3(SDKVideoView.this) != null)
        {
            SDKVideoView.access$3(SDKVideoView.this).show(0);
        }
        if (SDKVideoView.access$9(SDKVideoView.this) != null)
        {
            SDKVideoView.access$9(SDKVideoView.this).onCompletion(SDKVideoView.access$2(SDKVideoView.this));
            SDKVideoView.access$10(SDKVideoView.this, null);
        }
    }

    ()
    {
        this$0 = SDKVideoView.this;
        super();
    }
}
