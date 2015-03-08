// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;

import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDUtil;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.metric:
//            Queuer, MetricConfigParams, MetricEndPoint

public class Storage
{

    MetricConfigParams a;
    private String b;
    private String c;
    private String d;
    private int e;
    private PreProcessor f;
    private Queuer g;
    private long h;
    private long i;
    private AtomicBoolean j;
    private AtomicBoolean k;
    private Logger.MetricsCallback l;

    public Storage(int i1, String s, Queuer queuer, MetricConfigParams metricconfigparams)
    {
        b = "inmobi.cache.data";
        c = "inmobi.cache.data.events.number";
        d = "inmobi.cache.data.events.timestamp";
        e = 0;
        f = null;
        g = null;
        a = null;
        h = -1L;
        i = -1L;
        j = new AtomicBoolean(false);
        k = new AtomicBoolean(false);
        l = null;
        a = metricconfigparams;
        g = queuer;
        e = i1;
        b = (new StringBuilder()).append(b).append(".").append(s).toString();
        c = (new StringBuilder()).append(c).append(".").append(s).toString();
        d = (new StringBuilder()).append(d).append(".").append(s).toString();
    }

    public Storage(int i1, String s, Queuer queuer, MetricConfigParams metricconfigparams, PreProcessor preprocessor)
    {
        this(i1, s, queuer, metricconfigparams);
        f = preprocessor;
    }

    private void a()
    {
        try
        {
            FileOperations.writeStringToFile(InternalSDKUtil.getContext(), c, (new StringBuilder()).append(h).toString(), false);
            FileOperations.writeStringToFile(InternalSDKUtil.getContext(), d, (new StringBuilder()).append(i).toString(), false);
            return;
        }
        catch (Exception exception)
        {
            h = 0L;
        }
    }

    public long getEvents()
    {
        return h;
    }

    public long getTimestamp()
    {
        return i;
    }

    public String readLocalCache()
    {
        String s;
        try
        {
            s = FileOperations.readFileAsString(InternalSDKUtil.getContext(), b);
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Unable to read metric info.");
            return "null,";
        }
        return s;
    }

    public void readNumberOfEventsAndTimeStampFromPersistent()
    {
        if (h == -1L)
        {
            try
            {
                h = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), c));
                i = Long.parseLong(FileOperations.readFileAsString(InternalSDKUtil.getContext(), d));
            }
            catch (Exception exception)
            {
                h = 0L;
            }
            if (i == -1L)
            {
                i = System.currentTimeMillis() / 1000L;
                a();
                return;
            }
        }
    }

    public void resetFile()
    {
        try
        {
            FileOperations.writeStringToFile(InternalSDKUtil.getContext(), b, "", false);
            h = 0L;
            i = System.currentTimeMillis() / 1000L;
            a();
            return;
        }
        catch (IOException ioexception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Someting went wrong while saving metrics log to persistent storage", ioexception);
        }
    }

    public void saveLocalCache()
    {
        if (!j.compareAndSet(false, true))
        {
            return;
        }
        if (l != null)
        {
            l.movedMetricDataToFileMemory(b);
        }
        Exception exception;
        try
        {
            FileOperations.writeStringToFile(InternalSDKUtil.getContext(), b, g.get(), true);
            h = h + g.a();
            g.reset();
            a();
        }
        catch (IOException ioexception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Someting went wrong while saving metrics log to persistent storage", ioexception);
        }
        j.set(false);
        synchronized (j)
        {
            j.notify();
        }
        return;
        exception1;
        atomicboolean;
        JVM INSTR monitorexit ;
        throw exception1;
        exception;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Error saving local cache", exception);
        return;
    }

    public void saveToLatest()
    {
        saveLocalCache();
    }

    public void sendFile()
    {
        if (!k.compareAndSet(false, true))
        {
            return;
        }
_L2:
        if (j.compareAndSet(false, true))
        {
            break; /* Loop/switch isn't completed */
        }
        synchronized (j)
        {
            j.wait();
        }
        if (true) goto _L2; else goto _L1
        exception4;
        atomicboolean1;
        JVM INSTR monitorexit ;
        throw exception4;
        Exception exception3;
        exception3;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Unable to get lock for reading file before sending metric data");
        return;
_L1:
        if (l != null)
        {
            l.reportingStartedWithRequest(a.getUrl());
        }
        try
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Sending ")).append(h).append(" events to server..").toString());
            String s = readLocalCache();
            JSONObject jsonobject = new JSONObject();
            UIDUtil.bindToEncodedJSON(UIDUtil.getMap(InternalSDKUtil.getContext(), null), jsonobject);
            Calendar calendar = Calendar.getInstance();
            jsonobject.put("tz", calendar.get(15));
            jsonobject.put("ts", calendar.getTimeInMillis());
            jsonobject.put("product", e);
            jsonobject.put("payload", new JSONArray((new StringBuilder("[")).append(s.substring(0, -1 + s.length())).append("]").toString()));
            if (f != null)
            {
                jsonobject = f.process(jsonobject);
            }
            String s1 = jsonobject.toString();
            Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("sending ")).append(s1).append(" to url :").append(a.getUrl()).toString());
            MetricEndPoint.sendData(a.getUrl(), s1);
            Log.internal("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("data sent successfully to url :")).append(a.getUrl()).toString());
            resetFile();
            if (l != null)
            {
                l.reportingSuccess();
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[AdTracker]-4.4.1", "Unable to send data");
            if (l != null)
            {
                l.reportingFailure();
            }
        }
        j.set(false);
        synchronized (j)
        {
            j.notify();
        }
_L4:
        k.set(false);
        return;
        exception2;
        atomicboolean;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Unable to lock file.");
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setCallback(Logger.MetricsCallback metricscallback)
    {
        l = metricscallback;
    }

    public void setPreprocessor(PreProcessor preprocessor)
    {
        f = preprocessor;
    }

    private class PreProcessor
    {

        public abstract JSONObject process(JSONObject jsonobject);
    }

}
