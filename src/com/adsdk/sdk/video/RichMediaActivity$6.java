// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import android.widget.FrameLayout;
import com.adsdk.sdk.Log;
import java.util.Timer;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData, MediaController, SDKVideoView

class this._cls0
    implements android.media.edListener
{

    final RichMediaActivity this$0;

    public void onPrepared(MediaPlayer mediaplayer)
    {
        Log.d("ADSDK", "RichMediaActivity onPrepared MediaPlayer");
        if (RichMediaActivity.access$7(RichMediaActivity.this) != null)
        {
            RichMediaActivity.access$7(RichMediaActivity.this).cancel();
            RichMediaActivity.access$8(RichMediaActivity.this, null);
        }
        if (RichMediaActivity.access$9(RichMediaActivity.this) != null)
        {
            RichMediaActivity.access$9(RichMediaActivity.this).setVisibility(8);
        }
        if (RichMediaActivity.access$1(RichMediaActivity.this).showNavigationBars)
        {
            RichMediaActivity.access$4(RichMediaActivity.this).setVisibility(0);
        }
        RichMediaActivity.access$5(RichMediaActivity.this).requestFocus();
    }

    ener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
