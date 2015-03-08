// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package com.adsdk.sdk.video:
//            TrackEvent

public class TrackerService
{

    private static Object sLock = new Object();
    private static Queue sRetryTrackEvents = new LinkedList();
    private static boolean sStopped;
    private static Thread sThread;
    private static boolean sThreadRunning = false;
    private static Queue sTrackEvents = new LinkedList();

    public TrackerService()
    {
    }

    private static TrackEvent getNextUpdate()
    {
        TrackEvent trackevent;
        synchronized (sLock)
        {
            trackevent = (TrackEvent)sTrackEvents.poll();
        }
        return trackevent;
    }

    private static boolean hasMoreUpdates()
    {
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (sTrackEvents.isEmpty())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        Log.d((new StringBuilder("More updates:")).append(flag).append(" size:").append(sTrackEvents.size()).toString());
        obj;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static void release()
    {
        Log.v("release");
        if (sThread != null)
        {
            Log.v("release stopping Tracking events thread");
            sStopped = true;
        }
    }

    public static void requestRetry(TrackEvent trackevent)
    {
        synchronized (sLock)
        {
            if (!sRetryTrackEvents.contains(trackevent))
            {
                trackevent.retries = 1 + trackevent.retries;
                if (trackevent.retries <= 5)
                {
                    sRetryTrackEvents.add(trackevent);
                }
            }
            Log.d((new StringBuilder("Added retry track event:")).append(sRetryTrackEvents.size()).toString());
        }
    }

    public static void requestTrack(TrackEvent trackevent)
    {
        synchronized (sLock)
        {
            if (!sTrackEvents.contains(trackevent))
            {
                sTrackEvents.add(trackevent);
            }
            Log.d((new StringBuilder("Added track event:")).append(sTrackEvents.size()).toString());
        }
        if (!sThreadRunning)
        {
            startTracking();
        }
    }

    public static void requestTrack(TrackEvent atrackevent[])
    {
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        int i = atrackevent.length;
        int j = 0;
_L2:
        if (j < i)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Log.d((new StringBuilder("Added track event:")).append(sTrackEvents.size()).toString());
        obj;
        JVM INSTR monitorexit ;
        if (!sThreadRunning)
        {
            startTracking();
        }
        return;
        TrackEvent trackevent = atrackevent[j];
        if (!sTrackEvents.contains(trackevent))
        {
            sTrackEvents.add(trackevent);
        }
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public static void startTracking()
    {
        synchronized (sLock)
        {
            if (!sThreadRunning)
            {
                sThreadRunning = true;
                Thread thread = new Thread(new _cls1());
                sThread = thread;
                thread.setUncaughtExceptionHandler(new _cls2());
                sThread.start();
            }
        }
    }











    private class _cls1
        implements Runnable
    {

        public void run()
        {
            TrackerService.sStopped = false;
_L5:
            if (TrackerService.sStopped)
            {
                TrackerService.sStopped = false;
                TrackerService.sThreadRunning = false;
                TrackerService.sThread = null;
                return;
            }
              goto _L1
_L4:
            TrackEvent trackevent = TrackerService.getNextUpdate();
            if (trackevent == null) goto _L1; else goto _L2
_L2:
            DefaultHttpClient defaulthttpclient;
            HttpGet httpget;
            Log.d((new StringBuilder("Sending tracking :")).append(trackevent.url).append(" Time:").append(trackevent.timestamp).append(" Events left:").append(TrackerService.sTrackEvents.size()).toString());
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
            if (TrackerService.hasMoreUpdates() && !TrackerService.sStopped) goto _L4; else goto _L3
_L3:
            if (!TrackerService.sStopped && !TrackerService.sRetryTrackEvents.isEmpty())
            {
                Throwable throwable;
                try
                {
                    Thread.sleep(30000L);
                }
                catch (Exception exception) { }
                synchronized (TrackerService.sLock)
                {
                    TrackerService.sTrackEvents.addAll(TrackerService.sRetryTrackEvents);
                    TrackerService.sRetryTrackEvents.clear();
                }
            } else
            {
                TrackerService.sStopped = true;
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

        _cls1()
        {
        }
    }


    private class _cls2
        implements Thread.UncaughtExceptionHandler
    {

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            TrackerService.sThreadRunning = false;
            TrackerService.sThread = null;
            TrackerService.startTracking();
        }

        _cls2()
        {
        }
    }

}
