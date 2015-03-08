// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.thinICE.wifi.WifiUtil;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.inmobi.commons.thinICE.icedatacollector:
//            ThinICEConfigSettings, b, a, BuildSettings, 
//            Sample, ThinICEListener

public final class IceDataCollector
{

    public static final String TAG = "IceDataCollector";
    private static Context a = null;
    private static ThinICEConfigSettings b = new ThinICEConfigSettings();
    private static Looper c = null;
    private static Handler d = null;
    private static boolean e = false;
    private static Activity f = null;
    private static Runnable g = new b();
    private static LinkedList h = new LinkedList();
    private static Sample i = null;
    private static final Object j = new Object();
    private static ThinICEListener k = null;
    private static Runnable l = new a();

    public IceDataCollector()
    {
    }

    static Activity a(Activity activity)
    {
        f = activity;
        return activity;
    }

    static Context a(Context context)
    {
        a = context;
        return context;
    }

    static Sample a(Sample sample)
    {
        i = sample;
        return sample;
    }

    static ThinICEListener a(ThinICEListener thinicelistener)
    {
        k = thinicelistener;
        return thinicelistener;
    }

    static boolean a()
    {
        return e;
    }

    private static final boolean a(ThinICEConfigSettings thiniceconfigsettings, ThinICEConfigSettings thiniceconfigsettings1)
    {
        return thiniceconfigsettings.isEnabled() != thiniceconfigsettings1.isEnabled() || thiniceconfigsettings.getSampleInterval() != thiniceconfigsettings1.getSampleInterval();
    }

    static void b()
    {
        n();
    }

    static Looper c()
    {
        return c;
    }

    static Activity d()
    {
        return f;
    }

    static LinkedList e()
    {
        return h;
    }

    static ThinICEListener f()
    {
        return k;
    }

    public static void flush()
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- flush()");
        }
        synchronized (j)
        {
            i = null;
            h = new LinkedList();
        }
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static Runnable g()
    {
        return l;
    }

    public static ThinICEConfigSettings getConfig()
    {
        return new ThinICEConfigSettings(b);
    }

    public static WifiInfo getConnectedWifiInfo(Context context)
    {
        int i1 = b.getWifiFlags();
        boolean flag;
        boolean flag1;
        Exception exception;
        if (!ThinICEConfigSettings.bitTest(i1, 2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = ThinICEConfigSettings.bitTest(i1, 1);
        if (!b.isSampleConnectedWifiEnabled())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (WifiUtil.hasGetConnectedWifiInfoPermission(context))
        {
            return WifiUtil.getConnectedWifiInfo(context, flag, flag1);
        }
        if (BuildSettings.DEBUG)
        {
            Log.w("IceDataCollector", "application does not have permission to access connected wifi ap");
        }
        return null;
        exception;
        if (BuildSettings.DEBUG)
        {
            Log.e("IceDataCollector", "Error getting wifi data", exception);
        }
        return null;
    }

    public static List getData()
    {
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- getData()");
        }
        LinkedList linkedlist;
        synchronized (j)
        {
            linkedlist = h;
            flush();
        }
        return linkedlist;
    }

    public static int getSampleCount()
    {
        int i1;
        synchronized (j)
        {
            i1 = h.size();
        }
        return i1;
    }

    static ThinICEConfigSettings h()
    {
        return b;
    }

    static Handler i()
    {
        return d;
    }

    static Context j()
    {
        return a;
    }

    static Object k()
    {
        return j;
    }

    static Sample l()
    {
        return i;
    }

    private static void m()
    {
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "startSampling()");
        }
        if (c != null)
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "ignoring, already sampling");
            }
        } else
        {
            HandlerThread handlerthread = new HandlerThread("IDC");
            handlerthread.start();
            c = handlerthread.getLooper();
            Handler handler = new Handler(c);
            d = handler;
            handler.postDelayed(l, b.getSampleInterval() / 2L);
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", (new StringBuilder("next sample in ")).append(b.getSampleInterval() / 2L).append(" ms").toString());
                return;
            }
        }
    }

    private static void n()
    {
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "stopSampling()");
        }
        if (c == null)
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "ignoring, not currently sampling");
            }
        } else
        {
            d.removeCallbacks(l);
            d = null;
            c.quit();
            c = null;
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "sampling stopped");
                return;
            }
        }
    }

    public static void setConfig(ThinICEConfigSettings thiniceconfigsettings)
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", (new StringBuilder("-- setConfig(")).append(thiniceconfigsettings).append(")").toString());
        }
        if (thiniceconfigsettings != null) goto _L2; else goto _L1
_L1:
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "aborting, config is null");
        }
_L3:
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
_L2:
        ThinICEConfigSettings thiniceconfigsettings1;
        int i1;
        int j1;
        thiniceconfigsettings1 = b;
        b = thiniceconfigsettings;
        i1 = thiniceconfigsettings1.getSampleHistorySize();
        j1 = b.getSampleHistorySize();
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        synchronized (j)
        {
            if (h.size() > j1)
            {
                if (BuildSettings.DEBUG)
                {
                    Log.d("IceDataCollector", "new sample history size, removing samples from start of list");
                }
                h.subList(0, h.size() - j1).clear();
            }
        }
        if (c != null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "not restarting sampling, not currently sampling");
        }
          goto _L3
        Exception exception;
        exception;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        if (a(thiniceconfigsettings1, b))
        {
            n();
            if (!b.isEnabled())
            {
                break MISSING_BLOCK_LABEL_209;
            }
            m();
        }
          goto _L3
        flush();
        a = null;
        f = null;
        k = null;
          goto _L3
    }

    public static void setListener(ThinICEListener thinicelistener)
    {
        k = thinicelistener;
    }

    public static void start(Context context)
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- start()");
        }
        if (context != null) goto _L2; else goto _L1
_L1:
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "aborting, context is null");
        }
_L3:
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (b.isEnabled())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "ignoring, data collection is disabled in settings");
        }
          goto _L3
        Exception exception;
        exception;
        throw exception;
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                break MISSING_BLOCK_LABEL_114;
            }
            if (context instanceof Activity)
            {
                break label0;
            }
            if (BuildSettings.DEBUG)
            {
                Log.w("IceDataCollector", "aborting, build < 14 and context is not an activity");
            }
        }
          goto _L3
        f = (Activity)context;
        a = context.getApplicationContext();
        m();
        if (e)
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "stop previously requested, clearing request");
            }
            e = false;
            d.removeCallbacks(g);
        }
          goto _L3
    }

    public static void stop()
    {
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorenter ;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- stop()");
        }
        if (c != null) goto _L2; else goto _L1
_L1:
        Log.d("IceDataCollector", "ignoring, not currently running");
_L3:
        com/inmobi/commons/thinICE/icedatacollector/IceDataCollector;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!e)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        Log.d("IceDataCollector", "ignoring, stop already requested");
          goto _L3
        Exception exception;
        exception;
        throw exception;
        e = true;
        d.postDelayed(g, b.getStopRequestTimeout());
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", (new StringBuilder("stop requested, occurring in ")).append(b.getStopRequestTimeout()).append(" ms").toString());
        }
          goto _L3
    }

}
