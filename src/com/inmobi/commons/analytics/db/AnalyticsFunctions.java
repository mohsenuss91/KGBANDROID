// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.db;

import android.util.Log;

// Referenced classes of package com.inmobi.commons.analytics.db:
//            AnalyticsDatabaseManager, AnalyticsEvent

public abstract class AnalyticsFunctions
{

    private FunctionName a;

    public AnalyticsFunctions()
    {
        a = null;
    }

    public FunctionName getFunctionName()
    {
        return a;
    }

    protected void insertInDatabase(AnalyticsEvent analyticsevent)
    {
        try
        {
            AnalyticsDatabaseManager.getInstance().insertEvents(analyticsevent);
            return;
        }
        catch (Exception exception)
        {
            Log.w("[InMobi]-[Analytics]-4.4.1", exception);
        }
    }

    protected void printWarning(String s)
    {
        Log.d("[InMobi]-[Analytics]-4.4.1", "IllegalStateException", new IllegalStateException(s));
    }

    public abstract AnalyticsEvent processFunction();
}
