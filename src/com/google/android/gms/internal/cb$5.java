// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.b;

// Referenced classes of package com.google.android.gms.internal:
//            cb, cc, bw, ev

class nV
    implements Runnable
{

    final cb nU;
    final b nV;

    public void run()
    {
        try
        {
            cb.a(nU).onAdFailedToLoad(cc.a(nV));
            return;
        }
        catch (RemoteException remoteexception)
        {
            ev.c("Could not call onAdFailedToLoad.", remoteexception);
        }
    }

    (cb cb1, b b)
    {
        nU = cb1;
        nV = b;
        super();
    }
}
