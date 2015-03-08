// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsFunctions, AnalyticsEvent

public class FunctionEndSession extends AnalyticsFunctions
{

    private Context a;
    private Map b;

    public FunctionEndSession(Context context, Map map)
    {
        a = context;
        b = map;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(a) != null)
        {
            AnalyticsEvent analyticsevent = new AnalyticsEvent("es");
            analyticsevent.setEventSessionId(SessionInfo.getSessionId(a));
            analyticsevent.setEventSessionTimeStamp(SessionInfo.getSessionTime(a));
            analyticsevent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            SessionInfo.removeSessionId(a);
            if (b != null)
            {
                analyticsevent.setEventAttributeMap(AnalyticsUtils.convertToJSON(b));
            }
            insertInDatabase(analyticsevent);
            return analyticsevent;
        } else
        {
            return null;
        }
    }

    public AnalyticsEvent processFunction()
    {
        return a();
    }
}
