// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            br, bv, ev, bl

class ng
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

    (bl bl, br br1)
    {
        nh = bl;
        ng = br1;
        super();
    }
}
