// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerGoalRetryParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.cache.RetryMechanism;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerRequestResponseBuilder, AdTrackerWebViewLoader

public class AdTrackerNetworkInterface
{

    private static GoalList a;
    private static AtomicBoolean b = null;
    private static AtomicBoolean c;
    private static Thread d;
    private static Handler e;
    private static AtomicBoolean f = null;
    private static AtomicBoolean g = null;
    private static AdTrackerWebViewLoader h;
    private static boolean i = false;
    private static int j = 0;
    private static String k = "https://d.appsdt.com/download/tracker/?";
    private static String l = "https://d.appsdt.com/sdkdwnldbeacon.html";
    private static String m = "https://d.appsdt.com/download/tracker/iatsdkconfs?";
    private static Timer n = new Timer();

    public AdTrackerNetworkInterface()
    {
    }

    static String a()
    {
        return k;
    }

    private static void a(Goal goal)
    {
        String s;
        long l1;
        int i1;
        s = goal.getGoalName();
        l1 = goal.getRetryTime();
        i1 = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
        if (!f.get()) goto _L2; else goto _L1
_L1:
        l1 = 0L;
_L4:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Retrying goalname: ")).append(s).append(" after ").append(l1 / 1000L).append(" secs").toString());
        synchronized (d)
        {
            Thread.sleep(l1);
        }
        return;
_L2:
        if (l1 > (long)i1)
        {
            l1 = i1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        exception1;
        thread;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to reduce wait time exception", exception);
        return;
    }

    static void a(String s)
    {
        b(s);
    }

    private static void a(String s, Goal goal)
    {
        boolean flag = goal.isDuplicateGoal();
        int i1 = goal.getGoalCount();
        String s1 = goal.getGoalName();
        Boolean boolean1;
        if (!h())
        {
            boolean1 = Boolean.valueOf(reportUsingWebview(s, goal));
        } else
        {
            boolean1 = Boolean.valueOf(reportUsingNetwork(s, goal));
        }
        if (boolean1.booleanValue())
        {
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "goalPingSuccess", true);
            a.removeGoal(s1, i1);
            if ("download".equals(s1))
            {
                AdTrackerUtils.updateStatus();
            }
            return;
        } else
        {
            a.increaseRetryTime(s1, i1, flag);
            return;
        }
    }

    static String b()
    {
        return l;
    }

    private static void b(String s)
    {
        Goal goal;
        a.saveGoals();
        i = AdTrackerInitializer.getLogger().startNewSample();
        goal = (Goal)a.get(0);
        if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext()))
        {
            Log.debug("[InMobi]-[AdTracker]-4.4.1", "Network Unavailable");
            j = 1;
            deinit();
            return;
        }
        try
        {
            a(goal);
            g();
            a(s, goal);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer", true);
            j = 0;
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to process IAT goals", exception);
        }
        return;
    }

    static AtomicBoolean c()
    {
        return c;
    }

    static GoalList d()
    {
        return a;
    }

    public static void deinit()
    {
        if (b != null)
        {
            b.set(false);
        }
        if (a != null && !a.isEmpty())
        {
            a.saveGoals();
        }
        c.set(false);
        a = null;
    }

    static AtomicBoolean e()
    {
        return b;
    }

    static void f()
    {
        k();
    }

    private static void g()
    {
        long l1;
        if (i() || l())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Getting wait time for referrer");
        l1 = j();
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Waiting for referrer for ")).append(l1).append("secs").toString());
        if (!i())
        {
            synchronized (d)
            {
                d.wait(l1 * 1000L);
            }
        }
        String s;
        if (i())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        s = AdTrackerUtils.getReferrerFromLogs();
        if (s != null)
        {
            try
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Saving referrer from logs: ")).append(s).toString());
                AdTrackerUtils.setReferrerFromLogs(InternalSDKUtil.getContext(), s);
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to set referrer", exception);
            }
        }
        break MISSING_BLOCK_LABEL_142;
        exception1;
        thread;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public static GoalList getGoalList()
    {
        return a;
    }

    public static Thread getNetworkThread()
    {
        return d;
    }

    public static Handler getUIHandler()
    {
        return e;
    }

    public static AtomicBoolean getWebviewUploadStatus()
    {
        return g;
    }

    private static boolean h()
    {
        String s;
        String s1;
        Calendar calendar;
        s = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive");
        s1 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.getTime().toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        if (s1 == null)
        {
            return false;
        }
        boolean flag;
        Date date = calendar.getTime();
        calendar.add(11, Integer.parseInt(s));
        flag = calendar.getTime().after(date);
        if (flag)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_101;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Error parsing ttl", exception);
        return false;
    }

    private static boolean i()
    {
        return FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer") != null;
    }

    public static void init()
    {
        if (a == null)
        {
            a = GoalList.getLoggedGoals();
        }
        if (b == null)
        {
            b = new AtomicBoolean(false);
        }
        c = new AtomicBoolean(false);
        if (e == null)
        {
            e = new Handler();
        }
        f = new AtomicBoolean(true);
        g = new AtomicBoolean(false);
    }

    public static boolean isMetricSample()
    {
        return i;
    }

    public static boolean isSynced()
    {
        return c.get();
    }

    public static int isUnstableNetwork()
    {
        return j;
    }

    private static long j()
    {
        int k1;
        int i2;
        int i1 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
        int j1 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryInterval();
        k1 = AdTrackerInitializer.getConfigParams().getReferrerWaitTime();
        i2 = (i1 * (0 + i1 * j1)) / 2;
        (new RetryMechanism(i1 - 1, j1, n)).rescheduleTimer(new b());
        synchronized (d)
        {
            d.wait(i2);
        }
        long l2 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime");
        long l1;
        l1 = l2;
        if (0L != l1)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        int j2 = k1 / 1000;
        l1 = j2;
        return l1;
        exception2;
        thread;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception;
        exception;
        Exception exception1;
        l1 = 0L;
        exception1 = exception;
_L2:
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to get wait time", exception1);
        return l1;
        exception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void k()
    {
        DefaultHttpClient defaulthttpclient;
        HttpGet httpget;
        defaulthttpclient = new DefaultHttpClient();
        String s = (new StringBuilder()).append(m).append("t=").append(System.currentTimeMillis()).toString();
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Fetch Wait time URL: ")).append(s).toString());
        httpget = new HttpGet(s);
        HttpResponse httpresponse1 = defaulthttpclient.execute(httpget);
        HttpResponse httpresponse = httpresponse1;
_L1:
label0:
        {
            if (httpresponse.getStatusLine().getStatusCode() != 200)
            {
                break label0;
            }
            Exception exception;
            try
            {
                String s1 = EntityUtils.toString(httpresponse.getEntity());
                Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Wait time received for referrer: ")).append(s1).toString());
                long l1 = (new JSONObject(s1)).getLong("referrerWaitTime");
                FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime", l1);
                return;
            }
            catch (Exception exception1)
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Error fetching wait time for referrer", exception1);
            }
            break MISSING_BLOCK_LABEL_191;
        }
        exception;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Error fetching wait time for referrer", exception);
        httpresponse = null;
          goto _L1
        return;
        throw new CommonsException(-1);
    }

    private static boolean l()
    {
        return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer");
    }

    public static void notifyThread()
    {
        synchronized (d)
        {
            d.notify();
        }
        return;
        exception1;
        thread;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to notify thread", exception);
        return;
    }

    public static com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode reportToServer(String s)
    {
        com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface;
        JVM INSTR monitorenter ;
        com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode statuscode;
        if (b.compareAndSet(false, true))
        {
            Thread thread = new Thread(new a(s));
            d = thread;
            thread.setPriority(1);
            d.start();
        }
        statuscode = com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
        com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface;
        JVM INSTR monitorexit ;
        return statuscode;
        Exception exception;
        exception;
        throw exception;
    }

    protected static boolean reportUsingNetwork(String s, Goal goal)
    {
        String s1 = goal.getGoalName();
        com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode statuscode;
        String s2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
        com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        statuscode = AdTrackerRequestResponseBuilder.sendHTTPRequest(s, goal, s2);
        if (com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS != statuscode) goto _L2; else goto _L1
_L1:
        f.set(true);
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Successfully uploaded goal: ")).append(s1).toString());
_L4:
        return f.get();
_L2:
        Exception exception;
        if (com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.RELOAD_WEBVIEW_ERROR == statuscode)
        {
            f.set(false);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            f.set(false);
            Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Failed to upload goal: ")).append(s1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            f.set(false);
            Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Failed to upload goal: ")).append(s1).toString());
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to report goal: ", exception);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected static boolean reportUsingWebview(String s, Goal goal)
    {
        int i1;
        i1 = AdTrackerInitializer.getConfigParams().getWebviewTimeout();
        h = new AdTrackerWebViewLoader();
        AdTrackerRequestResponseBuilder.saveWebviewRequestParam(s, goal);
        h.loadWebview(goal);
        synchronized (d)
        {
            d.wait(i1);
        }
        if (AdTrackerWebViewLoader.isWebviewLoading())
        {
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, goal, 0, 0L, 408, null);
        }
        if (g.get()) goto _L2; else goto _L1
_L1:
        f.set(false);
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Failed to upload goal: ")).append(goal.getGoalName()).toString());
_L4:
        h.deinit(i1);
_L3:
        return g.get();
        exception1;
        thread;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        f.set(false);
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to load webview Exception", exception);
        if (true) goto _L3; else goto _L2
_L2:
        f.set(true);
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Uploaded goal successfully: ")).append(goal.getGoalName()).toString());
          goto _L4
    }

    public static void setSynced(boolean flag)
    {
        c.set(flag);
    }

    public static void setWebviewUploadStatus(boolean flag)
    {
        g.set(flag);
    }

    public static void waitThread(int i1)
    {
        synchronized (d)
        {
            d.wait(i1);
        }
        return;
        exception1;
        thread;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Failed to notify thread", exception);
        return;
    }


    private class b
        implements com.inmobi.commons.cache.RetryMechanism.RetryRunnable
    {

        public final void completed()
        {
            AdTrackerNetworkInterface.notifyThread();
        }

        public final void run()
        {
            AdTrackerNetworkInterface.f();
        }

        b()
        {
        }
    }


    private class a
        implements Runnable
    {

        final String a;

        public final void run()
        {
_L1:
            if (AdTrackerNetworkInterface.c().get())
            {
                break MISSING_BLOCK_LABEL_92;
            }
            AdTrackerNetworkInterface.d().saveGoals();
            AdTrackerNetworkInterface.c().set(true);
            if (AdTrackerNetworkInterface.d() == null || AdTrackerNetworkInterface.d().isEmpty())
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "GoalList Empty");
                AdTrackerNetworkInterface.deinit();
                return;
            }
            try
            {
                for (; !AdTrackerNetworkInterface.d().isEmpty(); AdTrackerNetworkInterface.a(a)) { }
            }
            catch (Exception exception1)
            {
                try
                {
                    AdTrackerNetworkInterface.deinit();
                    return;
                }
                catch (Exception exception)
                {
                    Log.internal("[InMobi]-[AdTracker]-4.4.1", "Exception reporting goals", exception);
                }
                return;
            }
            AdTrackerNetworkInterface.e().set(false);
              goto _L1
            AdTrackerNetworkInterface.deinit();
            return;
        }

        a(String s)
        {
            a = s;
            super();
        }
    }

}
