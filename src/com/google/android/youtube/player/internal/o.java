// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

// Referenced classes of package com.google.android.youtube.player.internal:
//            r, b, ac, l, 
//            i, j, k

public final class o extends r
    implements b
{

    private final String b;
    private final String c;
    private final String d;
    private boolean e;

    public o(Context context, String s, String s1, String s2, t.a a1, t.b b1)
    {
        super(context, a1, b1);
        b = (String)ac.a(s, "developerKey cannot be null");
        c = ac.a(s1, "callingPackage cannot be null or empty");
        d = ac.a(s2, "callingAppVersion cannot be null or empty");
    }

    private final void k()
    {
        i();
        if (e)
        {
            throw new IllegalStateException("Connection client has been released");
        } else
        {
            return;
        }
    }

    public final IBinder a()
    {
        k();
        IBinder ibinder;
        try
        {
            ibinder = ((l)j()).a();
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return ibinder;
    }

    protected final volatile IInterface a(IBinder ibinder)
    {
        return l.a.a(ibinder);
    }

    public final k a(j j)
    {
        k();
        k k1;
        try
        {
            k1 = ((l)j()).a(j);
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return k1;
    }

    protected final void a(i j, r.d d1)
    {
        j.a(d1, 1000, c, d, b, null);
    }

    public final void a(boolean flag)
    {
        if (f())
        {
            try
            {
                ((l)j()).a(flag);
            }
            catch (RemoteException remoteexception) { }
            e = true;
        }
    }

    protected final String b()
    {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    protected final String c()
    {
        return "com.google.android.youtube.api.service.START";
    }

    public final void d()
    {
        if (!e)
        {
            a(true);
        }
        super.d();
    }
}
