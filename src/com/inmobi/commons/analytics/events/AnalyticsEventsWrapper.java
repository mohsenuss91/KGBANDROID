// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.events;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.db.AnalyticsEventsQueue;
import com.inmobi.commons.analytics.db.FunctionEndSession;
import com.inmobi.commons.analytics.db.FunctionLevelBegin;
import com.inmobi.commons.analytics.db.FunctionLevelEnd;
import com.inmobi.commons.analytics.db.FunctionStartSession;
import com.inmobi.commons.analytics.db.FunctionTagEvent;
import com.inmobi.commons.analytics.db.FunctionTagTransaction;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public final class AnalyticsEventsWrapper
{

    private static AnalyticsEventsWrapper a;
    private static boolean c = false;
    private AnalyticsEventsQueue b;

    private AnalyticsEventsWrapper()
    {
    }

    private void a(String s)
    {
        Log.debug("[InMobi]-[Analytics]-4.4.1", "IllegalArgumentException", new IllegalArgumentException(s));
    }

    private boolean a()
    {
        if (InternalSDKUtil.getContext() != null && SessionInfo.getSessionId(InternalSDKUtil.getContext()) == null)
        {
            startSession(InMobi.getAppId(), null);
        } else
        if (SessionInfo.getSessionId(InternalSDKUtil.getContext()) == null)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Please call InMobi.initialize or startSession before calling any events API");
            return false;
        }
        return true;
    }

    public static AnalyticsEventsWrapper getInstance()
    {
        com/inmobi/commons/analytics/events/AnalyticsEventsWrapper;
        JVM INSTR monitorenter ;
        AnalyticsEventsWrapper analyticseventswrapper;
        if (AnalyticsUtils.getWebviewUserAgent() == null)
        {
            AnalyticsUtils.setWebviewUserAgent(InternalSDKUtil.getUserAgent(InternalSDKUtil.getContext()));
        }
        if (a == null)
        {
            a = new AnalyticsEventsWrapper();
            AnalyticsUtils.setStartHandle(false);
            AnalyticsNetworkManager.startInstance();
        }
        a.b = AnalyticsEventsQueue.getInstance();
        analyticseventswrapper = a;
        com/inmobi/commons/analytics/events/AnalyticsEventsWrapper;
        JVM INSTR monitorexit ;
        return analyticseventswrapper;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isEventsUser()
    {
        return c;
    }

    public static void setIsEventsUser()
    {
        c = true;
    }

    public final void beginSection(int i, String s, Map map)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        a("arguments cannot be null");
_L4:
        return;
_L2:
        if (!a()) goto _L4; else goto _L3
_L3:
        FunctionLevelBegin functionlevelbegin = new FunctionLevelBegin(InternalSDKUtil.getContext(), i, s, map);
        b.addElement(functionlevelbegin);
        b.processFunctions();
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Begin Section Exception", exception);
        return;
    }

    public final void endSection(int i, String s, Map map)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        a("arguments cannot be null");
_L4:
        return;
_L2:
        if (!a()) goto _L4; else goto _L3
_L3:
        FunctionLevelEnd functionlevelend = new FunctionLevelEnd(InternalSDKUtil.getContext(), i, s, null, map);
        b.addElement(functionlevelend);
        b.processFunctions();
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "End Section Exception", exception);
        return;
    }

    public final void endSession(Map map)
    {
        try
        {
            FunctionEndSession functionendsession = new FunctionEndSession(InternalSDKUtil.getContext(), map);
            b.addElement(functionendsession);
            b.processFunctions();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "End Session Exception", exception);
        }
    }

    public final void startSession(String s, Map map)
    {
        if (s == null || s.trim().equals(""))
        {
            a("appid cannot be null or empty");
            return;
        }
        try
        {
            FunctionStartSession functionstartsession = new FunctionStartSession(InternalSDKUtil.getContext(), s, map);
            b.addElement(functionstartsession);
            b.processFunctions();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[Analytics]-4.4.1", "Init exception", exception);
        }
    }

    public final void tagEvent(String s, Map map)
    {
        if (s != null && !s.trim().equals("")) goto _L2; else goto _L1
_L1:
        a("arguments cannot be null or empty");
_L4:
        return;
_L2:
        if (!a()) goto _L4; else goto _L3
_L3:
        FunctionTagEvent functiontagevent = new FunctionTagEvent(InternalSDKUtil.getContext(), s, map);
        b.addElement(functiontagevent);
        b.processFunctions();
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Tag Event Exception", exception);
        return;
    }

    public final void tagTransactionManually(Intent intent, Bundle bundle)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        a("transaction intent cannot be null or empty");
_L4:
        return;
_L2:
        if (!a()) goto _L4; else goto _L3
_L3:
        FunctionTagTransaction functiontagtransaction = new FunctionTagTransaction(InternalSDKUtil.getContext(), intent, bundle);
        b.addElement(functiontagtransaction);
        b.processFunctions();
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Analytics]-4.4.1", "Tag Transaction Manually Exception", exception);
        return;
    }

}
