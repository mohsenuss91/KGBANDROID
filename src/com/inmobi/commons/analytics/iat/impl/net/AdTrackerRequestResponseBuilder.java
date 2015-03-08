// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.iat.impl.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.analytics.iat.impl.net:
//            AdTrackerNetworkInterface

public class AdTrackerRequestResponseBuilder
{

    private static String a = null;
    private static long b = 0L;

    public AdTrackerRequestResponseBuilder()
    {
    }

    protected static String formHTTPRequest(String s, String s1, int i, boolean flag, String s2)
    {
        LinkedList linkedlist = new LinkedList();
        String s3 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        if (s != null && !s.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("mk-siteid", s));
        }
        String s4 = Integer.toString((new Random()).nextInt());
        String s5 = AdTrackerInitializer.getConfigParams().getUID().getUidMap(1, s4, null);
        String s6;
        String s7;
        String s8;
        if (InternalSDKUtil.isLimitAdTrackingEnabled())
        {
            linkedlist.add(new BasicNameValuePair("u-id-adt", "1"));
        } else
        {
            linkedlist.add(new BasicNameValuePair("u-id-adt", "0"));
        }
        linkedlist.add(new BasicNameValuePair("u-id-map", s5));
        linkedlist.add(new BasicNameValuePair("u-id-key", s4));
        linkedlist.add(new BasicNameValuePair("u-key-ver", UIDHelper.getRSAKeyVersion()));
        if (s1 != null && !s1.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("goalName", s1));
        }
        if (flag)
        {
            linkedlist.add(new BasicNameValuePair("lp", "1"));
        } else
        {
            linkedlist.add(new BasicNameValuePair("lp", "0"));
        }
        linkedlist.add(new BasicNameValuePair("src", "and"));
        if (i > 0)
        {
            linkedlist.add(new BasicNameValuePair("goalCount", Integer.toString(i)));
        }
        s6 = (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion("4.4.1")).append("-20140613").toString();
        linkedlist.add(new BasicNameValuePair("mk-version", s6));
        linkedlist.add(new BasicNameValuePair("mk-rel-version", s6));
        linkedlist.add(new BasicNameValuePair("osV", String.valueOf(android.os.Build.VERSION.SDK_INT)));
        s7 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rlc");
        if (s7 == null)
        {
            s7 = "0";
        }
        linkedlist.add(new BasicNameValuePair("rlc", s7));
        try
        {
            s8 = InternalSDKUtil.getContext().getPackageManager().getPackageInfo(InternalSDKUtil.getContext().getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Cant get appversion", namenotfoundexception);
            s8 = null;
        }
        if (s8 != null && !s8.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("u-appver", s8));
        }
        if (s2 != null && !s2.trim().equals(""))
        {
            linkedlist.add(new BasicNameValuePair("iat_ids", s2));
        }
        if (s3 != null)
        {
            int j = FileOperations.getIntPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rfs");
            long l = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t1");
            long l1 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t2") - l;
            linkedlist.add(new BasicNameValuePair("rfs", Integer.toString(j)));
            linkedlist.add(new BasicNameValuePair("rd", Long.toString(l1)));
        }
        if (1 == AdTrackerNetworkInterface.isUnstableNetwork())
        {
            linkedlist.add(new BasicNameValuePair("nus", Integer.toString(AdTrackerNetworkInterface.isUnstableNetwork())));
        }
        linkedlist.add(new BasicNameValuePair("ts", Long.toString(System.currentTimeMillis())));
        return URLEncodedUtils.format(linkedlist, "utf-8");
    }

    public static String getWebViewRequestParam()
    {
        return a;
    }

    public static void saveWebviewRequestParam(String s, Goal goal)
    {
        a = formHTTPRequest(s, goal.getGoalName(), goal.getGoalCount(), goal.isDuplicateGoal(), null);
    }

    public static com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode sendHTTPRequest(String s, Goal goal, String s1)
    {
        com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode statuscode = com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        DefaultHttpClient defaulthttpclient;
        String s2;
        int i;
        String s4;
        b = System.currentTimeMillis();
        defaulthttpclient = new DefaultHttpClient();
        s2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        String s3 = formHTTPRequest(s, goal.getGoalName(), goal.getGoalCount(), goal.isDuplicateGoal(), s1);
        i = AdTrackerInitializer.getConfigParams().getConnectionTimeout();
        s4 = (new StringBuilder()).append(AdTrackerNetworkInterface.a()).append(s3).toString();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        s4 = (new StringBuilder()).append(s4).append("&referrer=").append(s2).toString();
        HttpResponse httpresponse;
        String s6;
        int j;
        Log.debug("[InMobi]-[AdTracker]-4.4.1", s4);
        HttpGet httpget = new HttpGet(s4);
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, i);
        HttpConnectionParams.setSoTimeout(basichttpparams, i);
        defaulthttpclient.setParams(basichttpparams);
        httpresponse = defaulthttpclient.execute(httpget);
        if (httpresponse.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_380;
        }
        String s5 = EntityUtils.toString(httpresponse.getEntity());
        Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("RESPONSE: ")).append(s5).toString());
        JSONObject jsonobject = new JSONObject(s5);
        s6 = jsonobject.getString("errmsg");
        j = jsonobject.getInt("errcode");
        if (6000 != j) goto _L2; else goto _L1
_L1:
        com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode statuscode1;
        long l = System.currentTimeMillis() - b;
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, goal, 1, l, 0, null);
        statuscode1 = com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
_L4:
        if (6001 != j)
        {
            break MISSING_BLOCK_LABEL_351;
        }
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Error uploading ping ")).append(s6).append("\nReloading webview").toString());
        FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", null);
        if (!AdTrackerNetworkInterface.reportUsingWebview(s, goal))
        {
            break; /* Loop/switch isn't completed */
        }
        statuscode1 = com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
        return statuscode1;
_L2:
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, goal, 1, 0L, j, null);
        statuscode1 = statuscode;
        if (true) goto _L4; else goto _L3
_L3:
        com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode statuscode2 = com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        return statuscode2;
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, goal, 1, 0L, httpresponse.getStatusLine().getStatusCode(), null);
        return statuscode;
        Exception exception;
        exception;
        Exception exception1 = exception;
_L6:
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, goal, 1, 0L, 424, exception1.getMessage());
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Error uploading Goal Ping", exception1);
        return statuscode;
        Exception exception2;
        exception2;
        exception1 = exception2;
        statuscode = statuscode1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static boolean serverReachable(String s)
    {
        int i = (new DefaultHttpClient()).execute(new HttpGet(s)).getStatusLine().getStatusCode();
        if (i == 200)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        Log.debug("[InMobi]-[AdTracker]-4.4.1", "Server not reachable..Logging events");
        return false;
    }

}
