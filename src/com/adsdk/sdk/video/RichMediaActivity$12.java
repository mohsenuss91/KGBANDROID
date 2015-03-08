// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import java.util.HashMap;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData, TrackEvent, TrackerService

class this._cls0
    implements entListener
{

    final RichMediaActivity this$0;

    public void onTimeEvent(int i)
    {
        Vector vector;
        Log.d((new StringBuilder("###########TRACKING TIME VIDEO:")).append(i).toString());
        vector = (Vector)RichMediaActivity.access$1(RichMediaActivity.this).timeTrackingEvents.get(Integer.valueOf(i));
        if (vector == null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L5:
        if (j < vector.size()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        Log.d((new StringBuilder("Track url:")).append((String)vector.get(j)).toString());
        TrackEvent trackevent = new TrackEvent();
        trackevent.url = (String)vector.get(j);
        trackevent.timestamp = System.currentTimeMillis();
        TrackerService.requestTrack(trackevent);
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    entListener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
