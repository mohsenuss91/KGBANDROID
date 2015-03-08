// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            en, dx, ev, dv, 
//            dt

public abstract class dr extends en
{

    private final dt nc;
    private final dq.a pR;

    public dr(dt dt, dq.a a1)
    {
        nc = dt;
        pR = a1;
    }

    private static dv a(dx dx1, dt dt)
    {
        dv dv1;
        try
        {
            dv1 = dx1.b(dt);
        }
        catch (RemoteException remoteexception)
        {
            ev.c("Could not fetch ad response from ad request service.", remoteexception);
            return null;
        }
        catch (NullPointerException nullpointerexception)
        {
            ev.c("Could not fetch ad response from ad request service due to an Exception.", nullpointerexception);
            return null;
        }
        catch (SecurityException securityexception)
        {
            ev.c("Could not fetch ad response from ad request service due to an Exception.", securityexception);
            return null;
        }
        return dv1;
    }

    public final void bc()
    {
        dx dx1 = bo();
        if (dx1 != null) goto _L2; else goto _L1
_L1:
        dv dv1 = new dv(0);
_L4:
        bn();
        pR.a(dv1);
        return;
_L2:
        dv1 = a(dx1, nc);
        if (dv1 != null) goto _L4; else goto _L3
_L3:
        dv1 = new dv(0);
          goto _L4
        Exception exception;
        exception;
        bn();
        throw exception;
    }

    public abstract void bn();

    public abstract dx bo();

    public final void onStop()
    {
        bn();
    }
}
