// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.tagmanager:
//            cn, bh, bg, r

class co
    implements o.e
{

    private String aeM;
    private final String aeq;
    private bg agK;
    private r agL;
    private final ScheduledExecutorService agN;
    private final a agO;
    private ScheduledFuture agP;
    private boolean mClosed;
    private final Context mContext;

    public co(Context context, String s, r r)
    {
        this(context, s, r, null, null);
    }

    co(Context context, String s, r r, b b1, a a1)
    {
        agL = r;
        mContext = context;
        aeq = s;
        if (b1 == null)
        {
            b1 = new _cls1();
        }
        agN = b1.mf();
        if (a1 == null)
        {
            agO = new _cls2();
            return;
        } else
        {
            agO = a1;
            return;
        }
    }

    static Context a(co co1)
    {
        return co1.mContext;
    }

    static String b(co co1)
    {
        return co1.aeq;
    }

    private cn cc(String s)
    {
        cn cn1 = agO.a(agL);
        cn1.a(agK);
        cn1.bM(aeM);
        cn1.cb(s);
        return cn1;
    }

    private void me()
    {
        this;
        JVM INSTR monitorenter ;
        if (mClosed)
        {
            throw new IllegalStateException("called method after closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(bg bg)
    {
        this;
        JVM INSTR monitorenter ;
        me();
        agK = bg;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void bM(String s)
    {
        this;
        JVM INSTR monitorenter ;
        me();
        aeM = s;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void e(long l, String s)
    {
        this;
        JVM INSTR monitorenter ;
        bh.C((new StringBuilder("loadAfterDelay: containerId=")).append(aeq).append(" delay=").append(l).toString());
        me();
        if (agK == null)
        {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        break MISSING_BLOCK_LABEL_61;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (agP != null)
        {
            agP.cancel(false);
        }
        agP = agN.schedule(cc(s), l, TimeUnit.MILLISECONDS);
        this;
        JVM INSTR monitorexit ;
    }

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        me();
        if (agP != null)
        {
            agP.cancel(false);
        }
        agN.shutdown();
        mClosed = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private class _cls1
        implements b
    {

        final co agQ;

        public ScheduledExecutorService mf()
        {
            return Executors.newSingleThreadScheduledExecutor();
        }

        _cls1()
        {
            agQ = co.this;
            super();
        }
    }


    private class b
    {

        public abstract ScheduledExecutorService mf();
    }


    private class _cls2
        implements a
    {

        final co agQ;

        public cn a(r r)
        {
            return new cn(co.a(agQ), co.b(agQ), r);
        }

        _cls2()
        {
            agQ = co.this;
            super();
        }
    }


    private class a
    {

        public abstract cn a(r r);
    }

}
