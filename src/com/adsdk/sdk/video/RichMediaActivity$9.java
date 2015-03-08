// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData, TrackEvent, TrackerService

class this._cls0
    implements Listener
{

    final RichMediaActivity this$0;

    public void onVideoStart()
    {
        Log.d("###########TRACKING START VIDEO");
        Vector vector = RichMediaActivity.access$1(RichMediaActivity.this).startEvents;
        vector.addAll(RichMediaActivity.access$1(RichMediaActivity.this).impressionEvents);
        int i = 0;
        do
        {
            if (i >= vector.size())
            {
                vector.clear();
                RichMediaActivity.access$1(RichMediaActivity.this).impressionEvents.clear();
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

    Listener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
