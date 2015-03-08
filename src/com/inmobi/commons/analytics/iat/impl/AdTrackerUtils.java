// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl;

import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl:
//            Goal, GoalList

public class AdTrackerUtils
{

    public AdTrackerUtils()
    {
    }

    public static boolean checkDownloadGoalAdded()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Application Context NULL cannot checkStatusUpload");
            return false;
        } else
        {
            return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "insertStatus");
        }
    }

    public static boolean checkDownloadGoalUploaded()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Application Context NULL cannot checkStatusUpload");
            return false;
        } else
        {
            return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus");
        }
    }

    public static String getReferrerFromLogs()
    {
        String as[] = {
            "logcat", "-d", "ActivityManager:I"
        };
        Pattern pattern;
        BufferedReader bufferedreader;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Getting referrer from logs");
        pattern = Pattern.compile(AdTrackerInitializer.getConfigParams().getLogcatPattern());
        bufferedreader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(as).getInputStream()));
        String s = null;
_L1:
        String s1 = bufferedreader.readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        Matcher matcher = pattern.matcher(s1);
        if (matcher.find())
        {
            s = matcher.group(1);
        }
          goto _L1
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Received referrer from logs: ")).append(s).toString());
        return s;
        Exception exception;
        exception;
        Exception exception1;
        s = null;
        exception1 = exception;
_L3:
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Getting referrer from logs failed", exception1);
        return s;
        exception1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static boolean isPermissionGranted(String s)
    {
        int i = InternalSDKUtil.getContext().checkCallingOrSelfPermission(s);
        if (i == 0)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_23;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Cant check permissions", exception);
        return false;
    }

    public static void reportMetric(AdTrackerEventType adtrackereventtype, Goal goal, int i, long l, int j, String s)
    {
        JSONObject jsonobject1;
        try
        {
            if (!AdTrackerNetworkInterface.isMetricSample())
            {
                break MISSING_BLOCK_LABEL_236;
            }
            if (AdTrackerEventType.GOAL_SUCCESS.equals(adtrackereventtype))
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("g", goal.getGoalName());
                jsonobject.put("n", goal.getRetryCount());
                jsonobject.put("t", l);
                jsonobject.put("r", i);
                AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_SUCCESS, jsonobject));
                return;
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Error reporting metric", exception);
            return;
        }
        if (!AdTrackerEventType.GOAL_FAILURE.equals(adtrackereventtype))
        {
            break MISSING_BLOCK_LABEL_185;
        }
        jsonobject1 = new JSONObject();
        jsonobject1.put("g", goal.getGoalName());
        jsonobject1.put("n", goal.getRetryCount());
        jsonobject1.put("e", j);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        jsonobject1.put("m", s);
        AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_FAILURE, jsonobject1));
        return;
        JSONObject jsonobject2 = new JSONObject();
        jsonobject2.put("g", goal.getGoalName());
        jsonobject2.put("n", goal.getRetryCount());
        AdTrackerInitializer.getLogger().logEvent(new EventLog(AdTrackerEventType.GOAL_DUMPED, jsonobject2));
    }

    public static boolean resetStatus()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            return false;
        } else
        {
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", false);
            return true;
        }
    }

    public static boolean sendBroadcastMessage(int i)
    {
        try
        {
            Intent intent = new Intent();
            intent.setAction("action.inmobi.ADTRACKER");
            intent.putExtra("iatError", i);
            InternalSDKUtil.getContext().sendBroadcast(intent);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Cant send test broadcast", exception);
            return false;
        }
        return true;
    }

    public static void setInternalReferrer(Context context, String s)
    {
        String s1;
        if (context == null || s == null)
        {
            try
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Cannot set Market Referrer..Referrer NULL");
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Cannot set referrer", exception);
            }
            break MISSING_BLOCK_LABEL_150;
        }
        if (0L == FileOperations.getLongPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2"))
        {
            FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2", System.currentTimeMillis());
        }
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Saving referrer from broadcast receiver: ")).append(s).toString());
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "referrer", s);
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "rlc", "0");
        s1 = FileOperations.getPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "mk-siteid");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        if (!"".equals(s1.trim()))
        {
            break MISSING_BLOCK_LABEL_151;
        }
        Log.debug("[InMobi]-[AdTracker]-4.4.1", "Initialization incomplete. Please call InMobi initialize with a valid app Id");
        return;
        return;
        if (FileOperations.getBooleanPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "waitForReferrer"))
        {
            InternalSDKUtil.setContext(context);
            AdTrackerNetworkInterface.init();
            AdTrackerNetworkInterface.getGoalList().addGoal("download", 1, 0L, 0, true);
            AdTrackerNetworkInterface.reportToServer(s1);
        }
        AdTrackerNetworkInterface.notifyThread();
        return;
    }

    public static void setReferrerFromLogs(Context context, String s)
    {
        if (context == null || s == null)
        {
            try
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Cannot set Market Referrer from logs..Referrer NULL");
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Cannot set referrer from logs", exception);
            }
            break MISSING_BLOCK_LABEL_88;
        }
        if (0L == FileOperations.getLongPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2"))
        {
            FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "t2", System.currentTimeMillis());
        }
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "referrer", s);
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "rlc", "1");
        return;
    }

    public static boolean updateStatus()
    {
        if (InternalSDKUtil.getContext() == null)
        {
            return false;
        } else
        {
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", true);
            return true;
        }
    }
}
