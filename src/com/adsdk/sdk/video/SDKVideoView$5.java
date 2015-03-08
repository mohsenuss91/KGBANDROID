// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            SDKVideoView

class this._cls0
    implements android.media.nfoListener
{

    final SDKVideoView this$0;

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        Log.d((new StringBuilder("Info/Warning: ")).append(i).append(",").append(j).toString());
        if (SDKVideoView.access$12(SDKVideoView.this) != null)
        {
            if (!SDKVideoView.access$12(SDKVideoView.this).onInfo(SDKVideoView.access$2(SDKVideoView.this), i, j));
        }
        return true;
    }

    tener()
    {
        this$0 = SDKVideoView.this;
        super();
    }
}
