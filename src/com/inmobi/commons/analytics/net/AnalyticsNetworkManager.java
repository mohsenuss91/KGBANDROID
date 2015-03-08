// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import android.os.Handler;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.db.AnalyticsDatabaseManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Random;

// Referenced classes of package com.inmobi.commons.analytics.net:
//            a, AnalyticsCommon, AnalyticsPayload, AnalyticsConnectivityReceiver, 
//            AnalyticsPayloadBuilder

public final class AnalyticsNetworkManager
{

    public static final int MESSAGE_PING = 1001;
    private static Handler a;
    private static AnalyticsNetworkManager b;
    private static AnalyticsConnectivityReceiver.a f = new com.inmobi.commons.analytics.net.a();
    private AnalyticsPayloadBuilder c;
    private AnalyticsConnectivityReceiver d;
    private int e;

    private AnalyticsNetworkManager()
    {
        e = 0;
        (new a()).start();
        Log.debug("[InMobi]-[Analytics]-4.4.1", "NetworkManager-> Constructor ");
    }

    static Handler a()
    {
        return a;
    }

    static Handler a(Handler handler)
    {
        a = handler;
        return handler;
    }

    private String a(String s, String s1, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s2 = Integer.toString((new Random()).nextInt());
        Long long1 = AnalyticsInitializer.getConfigParams().getLTVId();
        if (s != null)
        {
            stringbuilder.append("payload=");
            stringbuilder.append(AnalyticsCommon.getURLEncoded(s));
        }
        if (s1 != null)
        {
            stringbuilder.append("&mk-siteid=");
            stringbuilder.append(s1);
        }
        stringbuilder.append("&c=");
        HashMap hashmap;
        String s3;
        String s4;
        if (flag)
        {
            stringbuilder.append(1);
        } else
        {
            stringbuilder.append(0);
        }
        hashmap = null;
        if (long1 != null)
        {
            hashmap = new HashMap();
            hashmap.put("LTVID", (new StringBuilder()).append(long1).toString());
        }
        s3 = AnalyticsInitializer.getConfigParams().getUID().getUidMap(1, s2, hashmap);
        stringbuilder.append("&u-id-map=");
        stringbuilder.append(AnalyticsCommon.getURLEncoded(s3));
        stringbuilder.append("&u-id-key=");
        stringbuilder.append(s2);
        stringbuilder.append("&u-key-ver=");
        stringbuilder.append(UIDHelper.getRSAKeyVersion());
        s4 = (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion("4.4.1")).append("-20140613").toString();
        stringbuilder.append("&mk-version=");
        stringbuilder.append(s4);
        stringbuilder.append("&u-id-adt=");
        if (InternalSDKUtil.isLimitAdTrackingEnabled())
        {
            stringbuilder.append(1);
        } else
        {
            stringbuilder.append(0);
        }
        return stringbuilder.toString();
    }

    static void a(AnalyticsNetworkManager analyticsnetworkmanager)
    {
        analyticsnetworkmanager.b();
    }

    private void a(AnalyticsPayload analyticspayload, String s)
    {
        String s1;
        int i;
        Log.internal("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Ping URL: ")).append(AnalyticsUtils.getEventUrl()).toString());
        s1 = analyticspayload.getCompletePayload();
        i = AnalyticsInitializer.getConfigParams().getMinEventsToCompress();
        Log.internal("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Post body: ")).append(s1).toString());
        if (analyticspayload.getPayloadSize() < i || android.os.Build.VERSION.SDK_INT < 8) goto _L2; else goto _L1
_L1:
        Log.debug("[InMobi]-[Analytics]-4.4.1", "Compressing the payload");
        boolean flag = true;
        s1 = AnalyticsUtils.compressPayload(s1);
_L5:
        AnalyticsCommon analyticscommon;
        HttpURLConnection httpurlconnection;
        int j = AnalyticsInitializer.getConfigParams().getMaxAppIdLength();
        if (s.length() > j)
        {
            s = s.substring(0, j);
        }
        String s2 = a(s1, s, flag);
        Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Post body: ")).append(s2).toString());
        analyticscommon = new AnalyticsCommon();
        httpurlconnection = analyticscommon.setupConnection(AnalyticsUtils.getEventUrl());
        analyticscommon.postData(httpurlconnection, s2);
        int l = httpurlconnection.getResponseCode();
        int k = l;
_L6:
        Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Http Status Code: ")).append(k).toString());
        if (k != 200)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        e = 0;
        AnalyticsDatabaseManager.getInstance().deleteEvents(analyticspayload.getTableIdList());
_L4:
        Exception exception;
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        Exception exception1;
        String s3;
        try
        {
            bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream(), "UTF-8"));
        }
        catch (Exception exception2)
        {
            try
            {
                bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getErrorStream(), "UTF-8"));
            }
            catch (Exception exception3)
            {
                bufferedreader = null;
            }
        }
        stringbuilder = new StringBuilder();
_L3:
        s3 = bufferedreader.readLine();
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        stringbuilder.append(s3).append("\n");
          goto _L3
        e = 1 + e;
        if (e >= AnalyticsUtils.getMaxRetryBeforeDiscard())
        {
            e = 0;
            AnalyticsDatabaseManager.getInstance().deleteEvents(analyticspayload.getTableIdList());
        }
          goto _L4
        try
        {
            String s4 = stringbuilder.toString();
            Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("Ping Response: ")).append(s4).toString());
            httpurlconnection.disconnect();
            analyticscommon.closeResource(bufferedreader);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1)
        {
            try
            {
                Log.internal("[InMobi]-[Analytics]-4.4.1", "Unable to read from stream");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                Log.debug("[InMobi]-[Analytics]-4.4.1", "Exception Pinging", exception);
            }
        }
        e = 1 + e;
        if (e >= AnalyticsUtils.getMaxRetryBeforeDiscard())
        {
            e = 0;
            AnalyticsDatabaseManager.getInstance().deleteEvents(analyticspayload.getTableIdList());
            return;
        } else
        {
            return;
        }
_L2:
        flag = false;
          goto _L5
        IOException ioexception;
        ioexception;
        k = 401;
          goto _L6
    }

    private void b()
    {
        boolean flag = true;
        if (d != null && d.isConnected() && c != null)
        {
            AnalyticsPayload analyticspayload = c.getPayloadList(AnalyticsDatabaseManager.getInstance().getEvents(), InternalSDKUtil.getContext());
            if (analyticspayload.getCompletePayload() != null)
            {
                a(analyticspayload, SessionInfo.getAppId(InternalSDKUtil.getContext()));
                flag = false;
            }
        }
        if (!flag)
        {
            a.sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
            return;
        } else
        {
            AnalyticsUtils.setStartHandle(false);
            return;
        }
    }

    public static Handler getHandler()
    {
        return a;
    }

    public static AnalyticsNetworkManager startInstance()
    {
        com/inmobi/commons/analytics/net/AnalyticsNetworkManager;
        JVM INSTR monitorenter ;
        AnalyticsNetworkManager analyticsnetworkmanager;
        if (b == null)
        {
            b = new AnalyticsNetworkManager();
        }
        if (b.c == null)
        {
            b.c = new AnalyticsPayloadBuilder();
        }
        if (b.d == null)
        {
            b.d = new AnalyticsConnectivityReceiver(InternalSDKUtil.getContext(), f);
        }
        analyticsnetworkmanager = b;
        com/inmobi/commons/analytics/net/AnalyticsNetworkManager;
        JVM INSTR monitorexit ;
        return analyticsnetworkmanager;
        Exception exception;
        exception;
        throw exception;
    }


    private class a extends Thread
    {

        final AnalyticsNetworkManager a;

        public void run()
        {
            Looper.prepare();
            class a
                implements android.os.Handler.Callback
            {

                final a a;

                public boolean handleMessage(Message message)
                {
label0:
                    {
                        Log.debug("[InMobi]-[Analytics]-4.4.1", (new StringBuilder("NetworkManager->handleMessag: msg:")).append(message).toString());
                        if (message.what == 1001)
                        {
                            if (AnalyticsInitializer.getConfigParams().getAutomaticCapture().getAutoSessionCapture() || AnalyticsEventsWrapper.isEventsUser())
                            {
                                break label0;
                            }
                            AnalyticsUtils.setStartHandle(false);
                        }
                        return true;
                    }
                    AnalyticsNetworkManager.a(a.a);
                    return true;
                }

                a()
                {
                    a = a.this;
                    super();
                }
            }

            AnalyticsNetworkManager.a(new Handler(new a()));
            Looper.loop();
        }

        a()
        {
            a = AnalyticsNetworkManager.this;
            super();
        }
    }

}
