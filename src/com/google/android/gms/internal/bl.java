// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ev, bn, bm, br, 
//            bq, dt, eu, bu

public final class bl
{

    private final bu kz;
    private final Object lq = new Object();
    private final Context mContext;
    private final dt nc;
    private final bn nd;
    private boolean ne;
    private bq nf;

    public bl(Context context, dt dt1, bu bu, bn bn1)
    {
        ne = false;
        mContext = context;
        nc = dt1;
        kz = bu;
        nd = bn1;
    }

    public final br a(long l, long l1)
    {
        Iterator iterator;
        ev.z("Starting mediation.");
        iterator = nd.np.iterator();
_L4:
        bm bm1;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_244;
        }
        bm1 = (bm)iterator.next();
        ev.B((new StringBuilder("Trying mediation network: ")).append(bm1.nj).toString());
        iterator1 = bm1.nk.iterator();
_L2:
        String s;
label0:
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator1.next();
            br br1;
            synchronized (lq)
            {
                if (!ne)
                {
                    break label0;
                }
                br1 = new br(-1);
            }
            return br1;
        }
        nf = new bq(mContext, s, kz, nd, bm1, nc.pV, nc.kR, nc.kO);
        obj;
        JVM INSTR monitorexit ;
        br br2;
        br2 = nf.b(l, l1);
        if (br2.nJ == 0)
        {
            ev.z("Adapter succeeded.");
            return br2;
        }
        break MISSING_BLOCK_LABEL_216;
        exception;
        throw exception;
        if (br2.nL != null)
        {
            eu.ss.post(new _cls1(br2));
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        return new br(1);
    }

    public final void cancel()
    {
        synchronized (lq)
        {
            ne = true;
            if (nf != null)
            {
                nf.cancel();
            }
        }
    }

    private class _cls1
        implements Runnable
    {

        final br ng;
        final bl nh;

        public void run()
        {
            try
            {
                ng.nL.destroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                ev.c("Could not destroy mediation adapter.", remoteexception);
            }
        }

        _cls1(br br1)
        {
            nh = bl.this;
            ng = br1;
            super();
        }
    }

}
