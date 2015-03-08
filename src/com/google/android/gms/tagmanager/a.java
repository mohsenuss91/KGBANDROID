// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.internal.ik;
import com.google.android.gms.internal.im;

// Referenced classes of package com.google.android.gms.tagmanager:
//            bh

class a
{

    private static com.google.android.gms.tagmanager.a aee;
    private static Object tn = new Object();
    private volatile long adZ;
    private volatile long aea;
    private volatile long aeb;
    private final ik aec;
    private a aed;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread sc;
    private volatile com.google.android.gms.ads.identifier.AdvertisingIdClient.Info tp;

    private a(Context context)
    {
        this(context, null, im.fW());
    }

    a(Context context, a a1, ik ik1)
    {
        adZ = 0xdbba0L;
        aea = 30000L;
        mClosed = false;
        aed = new _cls1();
        aec = ik1;
        if (context != null)
        {
            mContext = context.getApplicationContext();
        } else
        {
            mContext = context;
        }
        if (a1 != null)
        {
            aed = a1;
        }
        sc = new Thread(new _cls2());
    }

    static a J(Context context)
    {
        if (aee == null)
        {
            synchronized (tn)
            {
                if (aee == null)
                {
                    a a1 = new a(context);
                    aee = a1;
                    a1.start();
                }
            }
        }
        return aee;
    }

    static Context a(a a1)
    {
        return a1.mContext;
    }

    static void b(a a1)
    {
        a1.kZ();
    }

    private void kZ()
    {
        Process.setThreadPriority(10);
        while (!mClosed) 
        {
            try
            {
                tp = aed.lb();
                Thread.sleep(adZ);
            }
            catch (InterruptedException interruptedexception)
            {
                bh.B("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void la()
    {
        if (aec.currentTimeMillis() - aeb < aea)
        {
            return;
        } else
        {
            interrupt();
            aeb = aec.currentTimeMillis();
            return;
        }
    }

    void interrupt()
    {
        sc.interrupt();
    }

    public boolean isLimitAdTrackingEnabled()
    {
        la();
        if (tp == null)
        {
            return true;
        } else
        {
            return tp.isLimitAdTrackingEnabled();
        }
    }

    public String kY()
    {
        la();
        if (tp == null)
        {
            return null;
        } else
        {
            return tp.getId();
        }
    }

    void start()
    {
        sc.start();
    }


    private class _cls1
        implements a
    {

        final com.google.android.gms.tagmanager.a aef;

        public com.google.android.gms.ads.identifier.AdvertisingIdClient.Info lb()
        {
            com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
            try
            {
                info = AdvertisingIdClient.getAdvertisingIdInfo(com.google.android.gms.tagmanager.a.a(aef));
            }
            catch (IllegalStateException illegalstateexception)
            {
                bh.D("IllegalStateException getting Advertising Id Info");
                return null;
            }
            catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
            {
                bh.D("GooglePlayServicesRepairableException getting Advertising Id Info");
                return null;
            }
            catch (IOException ioexception)
            {
                bh.D("IOException getting Ad Id Info");
                return null;
            }
            catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
            {
                bh.D("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                return null;
            }
            catch (Exception exception)
            {
                bh.D("Unknown exception. Could not get the Advertising Id Info.");
                return null;
            }
            return info;
        }

        _cls1()
        {
            aef = a.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final com.google.android.gms.tagmanager.a aef;

        public void run()
        {
            com.google.android.gms.tagmanager.a.b(aef);
        }

        _cls2()
        {
            aef = a.this;
            super();
        }
    }


    private class a
    {

        public abstract com.google.android.gms.ads.identifier.AdvertisingIdClient.Info lb();
    }

}
