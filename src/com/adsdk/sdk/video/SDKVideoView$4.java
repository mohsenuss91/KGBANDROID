// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            SDKVideoView, MediaController

class this._cls0
    implements android.media.rrorListener
{

    final SDKVideoView this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Log.d((new StringBuilder("Error: ")).append(i).append(",").append(j).toString());
        SDKVideoView.access$0(SDKVideoView.this, -1);
        SDKVideoView.access$8(SDKVideoView.this, -1);
        if (SDKVideoView.access$3(SDKVideoView.this) != null)
        {
            SDKVideoView.access$3(SDKVideoView.this).hide();
        }
        if (SDKVideoView.access$11(SDKVideoView.this) != null)
        {
            if (!SDKVideoView.access$11(SDKVideoView.this).onError(SDKVideoView.access$2(SDKVideoView.this), i, j));
        }
        return true;
    }

    ()
    {
        this$0 = SDKVideoView.this;
        super();
    }
}
