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

public class FunctionLevelBegin extends AnalyticsFunctions
{

    private Context a;
    private Map b;
    private int c;
    private String d;

    public FunctionLevelBegin(Context context, int i, String s, Map map)
    {
        a = context;
        b = map;
        c = i;
        d = s;
    }

    private AnalyticsEvent a()
    {
        if (SessionInfo.getSessionId(a) != null)
        {
            AnalyticsEvent analyticsevent = new AnalyticsEvent("lb");
            analyticsevent.setEventLevelId(Integer.toString(c));
            analyticsevent.setEventLevelName(d);
            if (b != null)
            {
                analyticsevent.setEventAttributeMap(AnalyticsUtils.convertToJSON(b));
            }
            analyticsevent.setEventSessionId(SessionInfo.getSessionId(a));
            analyticsevent.setEventSessionTimeStamp(SessionInfo.getSessionTime(a));
            analyticsevent.setEventTimeStamp(System.currentTimeMillis() / 1000L);
            insertInDatabase(analyticsevent);
            return analyticsevent;
        } else
        {
            return null;
        }
    }

    protected Map getLbMap()
    {
        return b;
    }

    protected int getLevelId()
    {
        return c;
    }

    protected String getLevelName()
    {
        return d;
    }

    public AnalyticsEvent processFunction()
    {
        return a();
    }
}
