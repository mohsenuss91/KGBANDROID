// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.app.Activity;
import com.adsdk.sdk.Log;
import java.util.TimerTask;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

class mActivity extends TimerTask
{

    private final Activity mActivity;
    final RichMediaActivity this$0;

    public void run()
    {
        Log.v("###########TRACKING VIDEO TIMEOUT");
        class _cls1
            implements Runnable
        {

            final RichMediaActivity.VideoTimeoutTask this$1;

            public void run()
            {
                mActivity.finish();
            }

            _cls1()
            {
                this$1 = RichMediaActivity.VideoTimeoutTask.this;
                super();
            }
        }

        mActivity.runOnUiThread(new _cls1());
    }


    public _cls1(Activity activity)
    {
        this$0 = RichMediaActivity.this;
        super();
        mActivity = activity;
    }
}
