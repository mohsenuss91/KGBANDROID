// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity

class richMediaActivity extends Handler
{

    WeakReference richMediaActivity;

    public void handleMessage(Message message)
    {
        RichMediaActivity richmediaactivity = (RichMediaActivity)richMediaActivity.get();
        if (richmediaactivity != null)
        {
            richmediaactivity.handleMessage(message);
        }
    }

    public (RichMediaActivity richmediaactivity)
    {
        richMediaActivity = new WeakReference(richmediaactivity);
    }
}
