// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;

// Referenced classes of package com.inmobi.commons.metric:
//            EventLog

public class Queuer
{

    private StringBuffer a;
    private long b;

    public Queuer()
    {
        a = new StringBuffer();
        b = 0L;
    }

    long a()
    {
        return b;
    }

    public String get()
    {
        Log.internal("[InMobi]-4.4.1", "Reading from queue");
        String s;
        synchronized (a)
        {
            s = a.toString();
        }
        return s;
    }

    public void log(EventLog eventlog)
    {
        synchronized (a)
        {
            a.append(eventlog.toString()).append(',');
            b = 1L + b;
        }
    }

    public void reset()
    {
        Log.internal("[InMobi]-4.4.1", "Resetting queue");
        synchronized (a)
        {
            a = new StringBuffer();
            b = 0L;
        }
    }
}
