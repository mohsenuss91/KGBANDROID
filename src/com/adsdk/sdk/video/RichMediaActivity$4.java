// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import android.os.Handler;
import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, SDKVideoView

class this._cls0
    implements android.media.stener
{

    final RichMediaActivity this$0;

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        Log.i((new StringBuilder("Info: ")).append(i).append(" Extra: ").append(j).toString());
        if (i == 703)
        {
            mTimeTest = RichMediaActivity.access$5(RichMediaActivity.this).getCurrentPosition();
            (new Handler()).postDelayed(RichMediaActivity.access$6(RichMediaActivity.this), 5000L);
        }
        return false;
    }

    ()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
