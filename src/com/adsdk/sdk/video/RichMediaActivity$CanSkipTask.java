// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import java.util.TimerTask;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

class mActivity extends TimerTask
{

    private final RichMediaActivity mActivity;
    final RichMediaActivity this$0;

    public void run()
    {
        Log.v("###########TRACKING CAN CLOSE INTERSTITIAL");
        RichMediaActivity.access$11(mActivity, true);
        class _cls1
            implements Runnable
        {

            final RichMediaActivity.CanSkipTask this$1;

            public void run()
            {
                RichMediaActivity.access$12(mActivity).setVisibility(0);
            }

            _cls1()
            {
                this$1 = RichMediaActivity.CanSkipTask.this;
                super();
            }
        }

        if (RichMediaActivity.access$12(mActivity) != null)
        {
            mActivity.runOnUiThread(new _cls1());
        }
    }


    public _cls1(RichMediaActivity richmediaactivity1)
    {
        this$0 = RichMediaActivity.this;
        super();
        mActivity = richmediaactivity1;
    }
}
