// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.b;
import com.google.ads.mediation.j;
import com.google.android.gms.ads.mediation.MediationAdapter;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ca, by, ev, bv

public final class bt extends bu.a
{

    private Map nO;

    public bt()
    {
    }

    private bv n(String s)
    {
        try
        {
            Class class1 = Class.forName(s, false, com/google/android/gms/internal/bt.getClassLoader());
            if (com/google/ads/mediation/b.isAssignableFrom(class1))
            {
                b b1 = (b)class1.newInstance();
                return new ca(b1, (j)nO.get(b1.getAdditionalParametersType()));
            }
            if (com/google/android/gms/ads/mediation/MediationAdapter.isAssignableFrom(class1))
            {
                return new by((MediationAdapter)class1.newInstance());
            } else
            {
                ev.D((new StringBuilder("Could not instantiate mediation adapter: ")).append(s).append(" (not a valid adapter).").toString());
                throw new RemoteException();
            }
        }
        catch (Throwable throwable)
        {
            ev.D((new StringBuilder("Could not instantiate mediation adapter: ")).append(s).append(". ").append(throwable.getMessage()).toString());
        }
        throw new RemoteException();
    }

    public final void c(Map map)
    {
        nO = map;
    }

    public final bv m(String s)
    {
        return n(s);
    }
}
