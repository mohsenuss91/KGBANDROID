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

public class FunctionTagEvent extends AnalyticsFunctions
{

    private Context a;
    private String b;
    private Map c;

    public FunctionTagEvent(Context context, String s, Map map)
    {
        a = context;
        b = s;
        c = map;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(a) != null)
        {
            AnalyticsEvent analyticsevent = new AnalyticsEvent("ce");
            analyticsevent.setEventCustomName(b);
            if (c != null)
            {
                analyticsevent.setEventAttributeMap(AnalyticsUtils.convertToJSON(c));
            }
            analyticsevent.setEventSessionId(SessionInfo.getSessionId(a));
            analyticsevent.setEventSessionTimeStamp(SessionInfo.getSessionTime(a));
            analyticsevent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(analyticsevent);
            return analyticsevent;
        } else
        {
            printWarning("Please call startSession before calling trackEvent");
            return null;
        }
    }

    public AnalyticsEvent processFunction()
    {
        return a();
    }
}
