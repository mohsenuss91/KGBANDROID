// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.adsdk.sdk.video:
//            MediaController

class mController extends Handler
{

    private final WeakReference mController;

    public void handleMessage(Message message)
    {
        MediaController mediacontroller = (MediaController)mController.get();
        if (mediacontroller != null)
        {
            MediaController.access$1(mediacontroller, message);
        }
    }

    public _cls9(MediaController mediacontroller)
    {
        mController = new WeakReference(mediacontroller);
    }
}
