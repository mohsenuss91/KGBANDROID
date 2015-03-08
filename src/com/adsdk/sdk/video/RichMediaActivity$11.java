// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData, TrackEvent, TrackerService

class this._cls0
    implements auseListener
{

    final RichMediaActivity this$0;

    public void onVideoUnpause()
    {
        Log.d("###########TRACKING UNPAUSE VIDEO");
        Vector vector = RichMediaActivity.access$1(RichMediaActivity.this).resumeEvents;
        int i = 0;
        do
        {
            if (i >= vector.size())
            {
                return;
            }
            Log.d((new StringBuilder("Track url:")).append((String)vector.get(i)).toString());
            TrackEvent trackevent = new TrackEvent();
            trackevent.url = (String)vector.get(i);
            trackevent.timestamp = System.currentTimeMillis();
            TrackerService.requestTrack(trackevent);
            i++;
        } while (true);
    }

    auseListener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
