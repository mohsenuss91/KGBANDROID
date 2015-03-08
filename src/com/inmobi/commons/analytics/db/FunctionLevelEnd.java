// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            FunctionLevelBegin, AnalyticsEvent

public class FunctionLevelEnd extends FunctionLevelBegin
{

    private com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus a;
    private Context b;

    public FunctionLevelEnd(Context context, int i, String s, com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus imsectionstatus, Map map)
    {
        super(context, i, s, map);
        b = context;
        a = imsectionstatus;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(b) != null)
        {
            AnalyticsEvent analyticsevent = new AnalyticsEvent("le");
            analyticsevent.setEventLevelId(Integer.toString(getLevelId()));
            analyticsevent.setEventLevelName(getLevelName());
            if (getLbMap() != null)
            {
                analyticsevent.setEventAttributeMap(AnalyticsUtils.convertToJSON(getLbMap()));
            }
            analyticsevent.setEventLevelStatus("1");
            analyticsevent.setEventSessionId(SessionInfo.getSessionId(b));
            analyticsevent.setEventSessionTimeStamp(SessionInfo.getSessionTime(b));
            analyticsevent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(analyticsevent);
            return analyticsevent;
        } else
        {
            printWarning("Please call startSession before calling levelEnd");
            return null;
        }
    }

    protected com.inmobi.commons.analytics.events.AnalyticsEventsWrapper.IMSectionStatus getLevelStatus()
    {
        return a;
    }

    public AnalyticsEvent processFunction()
    {
        return a();
    }
}
