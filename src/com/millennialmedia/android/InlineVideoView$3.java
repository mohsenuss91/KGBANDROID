// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.millennialmedia.android:
//            InlineVideoView

class this._cls0 extends Handler
{

    final InlineVideoView this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 2: // '\002'
            break;
        }
        if (isPlaying())
        {
            InlineVideoView.access$100(InlineVideoView.this);
        }
        videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
    }

    ()
    {
        this$0 = InlineVideoView.this;
        super();
    }
}
