// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView, MMLayout

class this._cls0 extends Handler
{

    final InlineVideoView this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 4 5: default 28
    //                   4 29
    //                   5 81;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (isPlaying() && getCurrentPosition() > 0)
        {
            transparentHandler.sendEmptyMessageDelayed(5, 100L);
            return;
        } else
        {
            transparentHandler.sendEmptyMessageDelayed(4, 50L);
            return;
        }
_L3:
        if (isPlaying() && getCurrentPosition() > 0)
        {
            setBackgroundColor(0);
            if (mmLayoutRef != null && mmLayoutRef.get() != null)
            {
                ((MMLayout)mmLayoutRef.get()).removeBlackView();
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    ()
    {
        this$0 = InlineVideoView.this;
        super();
    }
}
