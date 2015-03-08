// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import android.os.ConditionVariable;
import android.os.Handler;
import android.util.SparseArray;
import com.adsdk.sdk.Log;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            SDKVideoView

class this._cls0
    implements Runnable
{

    final SDKVideoView this$0;

    public void run()
    {
        Log.d("Time Event Thread started");
_L7:
        if (SDKVideoView.access$2(SDKVideoView.this) == null || SDKVideoView.access$20(SDKVideoView.this) != 3) goto _L2; else goto _L1
_L1:
        final int time;
        Vector vector;
        time = SDKVideoView.access$2(SDKVideoView.this).getCurrentPosition() / 1000;
        vector = (Vector)SDKVideoView.access$21(SDKVideoView.this).get(time);
        if (vector == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L8:
        if (i < vector.size()) goto _L5; else goto _L4
_L4:
        vector.clear();
_L2:
        if (!SDKVideoView.access$22(SDKVideoView.this).block(1000L)) goto _L7; else goto _L6
_L6:
        Log.v("Time Event Thread stopped");
        return;
_L5:
        final TimeEventListener l = (TimeEventListener)vector.elementAt(i);
        class _cls1
            implements Runnable
        {

            final SDKVideoView._cls8 this$1;
            private final SDKVideoView.OnTimeEventListener val$l;
            private final int val$time;

            public void run()
            {
                l.onTimeEvent(time);
            }

            _cls1()
            {
                this$1 = SDKVideoView._cls8.this;
                l = ontimeeventlistener;
                time = i;
                super();
            }
        }

        mHandler.post(new _cls1());
        i++;
          goto _L8
        Exception exception;
        exception;
        Log.e((new StringBuilder("Time Event Thread error")).append(exception).toString(), exception);
          goto _L2
    }

    _cls1()
    {
        this$0 = SDKVideoView.this;
        super();
    }
}
