// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            bo

public final class bp extends bw.a
{

    private final Object lq = new Object();
    private br.a ny;
    private bo nz;

    public bp()
    {
    }

    public final void a(bo bo1)
    {
        synchronized (lq)
        {
            nz = bo1;
        }
    }

    public final void a(br.a a1)
    {
        synchronized (lq)
        {
            ny = a1;
        }
    }

    public final void onAdClicked()
    {
        synchronized (lq)
        {
            if (nz != null)
            {
                nz.W();
            }
        }
    }

    public final void onAdClosed()
    {
        synchronized (lq)
        {
            if (nz != null)
            {
                nz.X();
            }
        }
    }

    public final void onAdFailedToLoad(int i)
    {
        Object obj = lq;
        obj;
        JVM INSTR monitorenter ;
        if (ny == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        int j;
        if (i == 3)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        ny.g(j);
        ny = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void onAdLeftApplication()
    {
        synchronized (lq)
        {
            if (nz != null)
            {
                nz.Y();
            }
        }
    }

    public final void onAdLoaded()
    {
label0:
        {
            synchronized (lq)
            {
                if (ny == null)
                {
                    break label0;
                }
                ny.g(0);
                ny = null;
            }
            return;
        }
        if (nz != null)
        {
            nz.aa();
        }
        obj;
        JVM INSTR monitorexit ;
    }

    public final void onAdOpened()
    {
        synchronized (lq)
        {
            if (nz != null)
            {
                nz.Z();
            }
        }
    }
}
