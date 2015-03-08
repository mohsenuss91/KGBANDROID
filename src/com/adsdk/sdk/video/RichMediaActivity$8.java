// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import android.media.MediaPlayer;
import com.adsdk.sdk.Log;
import java.util.Vector;

// Referenced classes of package com.adsdk.sdk.video:
//            RichMediaActivity, VideoData, TrackEvent, TrackerService

class this._cls0
    implements android.media.tionListener
{

    final RichMediaActivity this$0;

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Log.d("###########TRACKING END VIDEO");
        Vector vector = RichMediaActivity.access$1(RichMediaActivity.this).completeEvents;
        int i = 0;
        do
        {
            if (i >= vector.size())
            {
                RichMediaActivity.access$10(RichMediaActivity.this, true);
                setResult(-1);
                finish();
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

    stener()
    {
        this$0 = RichMediaActivity.this;
        super();
    }
}
