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

public class FunctionStartSession extends AnalyticsFunctions
{

    private Context a;
    private String b;
    private Map c;

    public FunctionStartSession(Context context, String s, Map map)
    {
        a = context;
        b = s;
        c = map;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(a) == null)
        {
            SessionInfo.storeAppId(a, b);
            SessionInfo.storeSessionId(a);
            SessionInfo.storeFirstTime(a);
            AnalyticsEvent analyticsevent = new AnalyticsEvent("ss");
            if (c != null)
            {
                analyticsevent.setEventAttributeMap(AnalyticsUtils.convertToJSON(c));
            }
            analyticsevent.setEventSessionId(SessionInfo.getSessionId(a));
            analyticsevent.setEventSessionTimeStamp(SessionInfo.getSessionTime(a));
            analyticsevent.setEventTimeStamp(SessionInfo.getSessionTime(a));
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
