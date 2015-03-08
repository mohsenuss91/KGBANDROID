// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            he

final class mState
{

    private ComponentName GA;
    final he GB;
    private final String Gv;
    private final a Gw = new a();
    private final HashSet Gx = new HashSet();
    private boolean Gy;
    private IBinder Gz;
    private int mState;

    static int a(mState mstate, int i)
    {
        mstate.mState = i;
        return i;
    }

    static ComponentName a(mState mstate, ComponentName componentname)
    {
        mstate.GA = componentname;
        return componentname;
    }

    static IBinder a(GA ga, IBinder ibinder)
    {
        ga.Gz = ibinder;
        return ibinder;
    }

    static HashSet a(Gz gz)
    {
        return gz.Gx;
    }

    public final void B(boolean flag)
    {
        Gy = flag;
    }

    public final void a(Gy gy)
    {
        Gx.add(gy);
    }

    public final void b(Gx gx)
    {
        Gx.remove(gx);
    }

    public final boolean c(Gx gx)
    {
        return Gx.contains(gx);
    }

    public final a fs()
    {
        return Gw;
    }

    public final String ft()
    {
        return Gv;
    }

    public final boolean fu()
    {
        return Gx.isEmpty();
    }

    public final IBinder getBinder()
    {
        return Gz;
    }

    public final ComponentName getComponentName()
    {
        return GA;
    }

    public final int getState()
    {
        return mState;
    }

    public final boolean isBound()
    {
        return Gy;
    }

    public a.GC(he he, String s)
    {
        GB = he;
        super();
        Gv = s;
        class a
            implements ServiceConnection
        {

            final he.a GC;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                java.util.HashMap hashmap = com.google.android.gms.internal.he.a(GC.GB);
                hashmap;
                JVM INSTR monitorenter ;
                he.a.a(GC, ibinder);
                he.a.a(GC, componentname);
                for (Iterator iterator = he.a.a(GC).iterator(); iterator.hasNext(); ((hc.f)iterator.next()).onServiceConnected(componentname, ibinder)) { }
                break MISSING_BLOCK_LABEL_78;
                Exception exception;
                exception;
                throw exception;
                he.a.a(GC, 1);
                hashmap;
                JVM INSTR monitorexit ;
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                java.util.HashMap hashmap = com.google.android.gms.internal.he.a(GC.GB);
                hashmap;
                JVM INSTR monitorenter ;
                he.a.a(GC, null);
                he.a.a(GC, componentname);
                for (Iterator iterator = he.a.a(GC).iterator(); iterator.hasNext(); ((hc.f)iterator.next()).onServiceDisconnected(componentname)) { }
                break MISSING_BLOCK_LABEL_75;
                Exception exception;
                exception;
                throw exception;
                he.a.a(GC, 2);
                hashmap;
                JVM INSTR monitorexit ;
            }

            public a()
            {
                GC = he.a.this;
                super();
            }
        }

        mState = 0;
    }
}
