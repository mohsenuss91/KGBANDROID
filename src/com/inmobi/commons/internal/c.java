// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEListener;
import java.util.List;

// Referenced classes of package com.inmobi.commons.internal:
//            ThinICE, ActivityRecognitionSampler

final class c
    implements ThinICEListener
{

    c()
    {
    }

    public final void onSamplingTerminated(List list)
    {
        ThinICE.a(list);
        IceDataCollector.stop();
        ActivityRecognitionSampler.stop();
    }
}
