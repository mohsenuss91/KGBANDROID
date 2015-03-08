// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, SDKVideoView

class this._cls0
    implements Runnable
{

    final RichMediaActivity this$0;

    public void run()
    {
        Log.w("Video playback is being checked");
        if (RichMediaActivity.access$5(RichMediaActivity.this).getCurrentPosition() - mTimeTest <= 1)
        {
            Log.w("Video playback too slow. Ending");
            finish();
            return;
        } else
        {
            Log.w("Video playback has restarted");
            return;
        }
    }

    ()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
