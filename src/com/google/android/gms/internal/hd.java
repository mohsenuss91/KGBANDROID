// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            hn

public final class hd
{

    private final b Gm;
    private final ArrayList Gn = new ArrayList();
    final ArrayList Go = new ArrayList();
    private boolean Gp;
    private final ArrayList Gq = new ArrayList();
    private final Handler mHandler;

    public hd(Context context, Looper looper, b b1)
    {
        Gp = false;
        Gm = b1;
        mHandler = new a(looper);
    }

    static ArrayList a(hd hd1)
    {
        return hd1.Gn;
    }

    static b b(hd hd1)
    {
        return hd1.Gm;
    }

    public final void a(ConnectionResult connectionresult)
    {
        mHandler.removeMessages(1);
        ArrayList arraylist = Gq;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = (new ArrayList(Gq)).iterator();
_L2:
        com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        onconnectionfailedlistener = (com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener)iterator.next();
        if (!Gm.eJ())
        {
            return;
        }
        if (Gq.contains(onconnectionfailedlistener))
        {
            onconnectionfailedlistener.onConnectionFailed(connectionresult);
        }
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public final void ao(int i)
    {
        mHandler.removeMessages(1);
        ArrayList arraylist = Gn;
        arraylist;
        JVM INSTR monitorenter ;
        Gp = true;
        Iterator iterator = (new ArrayList(Gn)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)iterator.next();
            if (!Gm.eJ())
            {
                break;
            }
            if (Gn.contains(connectioncallbacks))
            {
                connectioncallbacks.onConnectionSuspended(i);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_98;
        Exception exception;
        exception;
        throw exception;
        Gp = false;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public final void c(Bundle bundle)
    {
        boolean flag = true;
        ArrayList arraylist = Gn;
        arraylist;
        JVM INSTR monitorenter ;
        boolean flag1;
        if (!Gp)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        hn.A(flag1);
        mHandler.removeMessages(1);
        Gp = true;
        Exception exception;
        Iterator iterator;
        if (Go.size() != 0)
        {
            flag = false;
        }
        hn.A(flag);
        iterator = (new ArrayList(Gn)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks = (com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)iterator.next();
            if (!Gm.eJ() || !Gm.isConnected())
            {
                break;
            }
            if (!Go.contains(connectioncallbacks))
            {
                connectioncallbacks.onConnected(bundle);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_154;
        exception;
        throw exception;
        Go.clear();
        Gp = false;
        arraylist;
        JVM INSTR monitorexit ;
    }

    protected final void ck()
    {
        synchronized (Gn)
        {
            c(Gm.ea());
        }
    }

    public final boolean isConnectionCallbacksRegistered(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        hn.f(connectioncallbacks);
        boolean flag;
        synchronized (Gn)
        {
            flag = Gn.contains(connectioncallbacks);
        }
        return flag;
    }

    public final boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        hn.f(onconnectionfailedlistener);
        boolean flag;
        synchronized (Gq)
        {
            flag = Gq.contains(onconnectionfailedlistener);
        }
        return flag;
    }

    public final void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        hn.f(connectioncallbacks);
        ArrayList arraylist = Gn;
        arraylist;
        JVM INSTR monitorenter ;
        if (!Gn.contains(connectioncallbacks))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionCallbacks(): listener ")).append(connectioncallbacks).append(" is already registered").toString());
_L2:
        if (Gm.isConnected())
        {
            mHandler.sendMessage(mHandler.obtainMessage(1, connectioncallbacks));
        }
        return;
        Gn.add(connectioncallbacks);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        hn.f(onconnectionfailedlistener);
        ArrayList arraylist = Gq;
        arraylist;
        JVM INSTR monitorenter ;
        if (!Gq.contains(onconnectionfailedlistener))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionFailedListener(): listener ")).append(onconnectionfailedlistener).append(" is already registered").toString());
_L2:
        return;
        Gq.add(onconnectionfailedlistener);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final void unregisterConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks)
    {
        hn.f(connectioncallbacks);
        ArrayList arraylist = Gn;
        arraylist;
        JVM INSTR monitorenter ;
        if (Gn == null) goto _L2; else goto _L1
_L1:
        if (Gn.remove(connectioncallbacks)) goto _L4; else goto _L3
_L3:
        Log.w("GmsClientEvents", (new StringBuilder("unregisterConnectionCallbacks(): listener ")).append(connectioncallbacks).append(" not found").toString());
_L2:
        return;
_L4:
        if (Gp)
        {
            Go.add(connectioncallbacks);
        }
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public final void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        hn.f(onconnectionfailedlistener);
        synchronized (Gq)
        {
            if (Gq != null && !Gq.remove(onconnectionfailedlistener))
            {
                Log.w("GmsClientEvents", (new StringBuilder("unregisterConnectionFailedListener(): listener ")).append(onconnectionfailedlistener).append(" not found").toString());
            }
        }
    }

    private class a extends Handler
    {

        final hd Gr;

        public final void handleMessage(Message message)
        {
            if (message.what == 1)
            {
                synchronized (hd.a(Gr))
                {
                    if (hd.b(Gr).eJ() && hd.b(Gr).isConnected() && hd.a(Gr).contains(message.obj))
                    {
                        Bundle bundle = hd.b(Gr).ea();
                        ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks)message.obj).onConnected(bundle);
                    }
                }
                return;
            } else
            {
                Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
                return;
            }
        }

        public a(Looper looper)
        {
            Gr = hd.this;
            super(looper);
        }
    }


    private class b
    {

        public abstract boolean eJ();

        public abstract Bundle ea();

        public abstract boolean isConnected();
    }

}
