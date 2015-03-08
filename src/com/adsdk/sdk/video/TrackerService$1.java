// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import java.net.URI;
import java.util.Queue;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.adsdk.sdk.video:
//            TrackerService, TrackEvent

class t
    implements Runnable
{

    public void run()
    {
        TrackerService.access$0(false);
_L5:
        if (TrackerService.access$1())
        {
            TrackerService.access$0(false);
            TrackerService.access$7(false);
            TrackerService.access$8(null);
            return;
        }
          goto _L1
_L4:
        TrackEvent trackevent = TrackerService.access$3();
        if (trackevent == null) goto _L1; else goto _L2
_L2:
        DefaultHttpClient defaulthttpclient;
        HttpGet httpget;
        Log.d((new StringBuilder("Sending tracking :")).append(trackevent.url).append(" Time:").append(trackevent.timestamp).append(" Events left:").append(TrackerService.access$4().size()).toString());
        Log.d("Sending conversion Request");
        Log.d((new StringBuilder("Perform tracking HTTP Get Url: ")).append(trackevent.url).toString());
        defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), 10000);
        HttpConnectionParams.setConnectionTimeout(defaulthttpclient.getParams(), 10000);
        httpget = new HttpGet();
        httpget.setHeader("User-Agent", System.getProperty("http.agent"));
        httpget.setURI(new URI(trackevent.url.trim()));
        if (defaulthttpclient.execute(httpget).getStatusLine().getStatusCode() == 200)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        TrackerService.requestRetry(trackevent);
_L1:
        if (TrackerService.access$2() && !TrackerService.access$1()) goto _L4; else goto _L3
_L3:
        if (!TrackerService.access$1() && !TrackerService.access$5().isEmpty())
        {
            Throwable throwable;
            try
            {
                Thread.sleep(30000L);
            }
            catch (Exception exception) { }
            synchronized (TrackerService.access$6())
            {
                TrackerService.access$4().addAll(TrackerService.access$5());
                TrackerService.access$5().clear();
            }
        } else
        {
            TrackerService.access$0(true);
        }
          goto _L5
        try
        {
            Log.d("Tracking OK");
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            TrackerService.requestRetry(trackevent);
        }
          goto _L1
    }

    t()
    {
    }
}
