// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            hc, hn, gd, hj

public final class gb extends hc
{

    private final String yN;

    public gb(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, String as[])
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, as);
        yN = (String)hn.f(s);
    }

    protected final gd D(IBinder ibinder)
    {
        return gd.a.F(ibinder);
    }

    public final void a(com.google.android.gms.common.api.a.d d)
    {
        try
        {
            ((gd)fo()).a(new c(d));
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void a(com.google.android.gms.common.api.a.d d, int i)
    {
        try
        {
            ((gd)fo()).b(new a(d), i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void a(com.google.android.gms.common.api.a.d d, int i, String s, byte abyte0[])
    {
        try
        {
            ((gd)fo()).a(new e(d), i, s, abyte0);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void a(com.google.android.gms.common.api.a.d d, int i, byte abyte0[])
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L3:
        e e1;
        try
        {
            ((gd)fo()).a(((gc) (obj)), i, abyte0);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
        }
        break MISSING_BLOCK_LABEL_51;
_L2:
        e1 = new e(d);
        obj = e1;
          goto _L3
    }

    protected final void a(hj hj1, hc.e e1)
    {
        hj1.a(e1, 0x4d7808, getContext().getPackageName(), yN, fn());
    }

    public final void b(com.google.android.gms.common.api.a.d d)
    {
        try
        {
            ((gd)fo()).b(new g(d));
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public final void b(com.google.android.gms.common.api.a.d d, int i)
    {
        try
        {
            ((gd)fo()).a(new e(d), i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    protected final transient void b(String as[])
    {
        int i = 0;
        boolean flag = false;
        for (; i < as.length; i++)
        {
            if (as[i].equals("https://www.googleapis.com/auth/appstate"))
            {
                flag = true;
            }
        }

        hn.a(flag, String.format("App State APIs requires %s to function.", new Object[] {
            "https://www.googleapis.com/auth/appstate"
        }));
    }

    protected final String bp()
    {
        return "com.google.android.gms.appstate.service.START";
    }

    protected final String bq()
    {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public final int dP()
    {
        int i;
        try
        {
            i = ((gd)fo()).dP();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    public final int dQ()
    {
        int i;
        try
        {
            i = ((gd)fo()).dQ();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    protected final IInterface x(IBinder ibinder)
    {
        return D(ibinder);
    }

    private class c extends ga
    {

        private final com.google.android.gms.common.api.a.d yO;

        public final void a(DataHolder dataholder)
        {
            yO.a(new d(dataholder));
        }

        public c(com.google.android.gms.common.api.a.d d)
        {
            yO = (com.google.android.gms.common.api.a.d)hn.b(d, "Result holder must not be null");
        }

        private class d extends b
            implements com.google.android.gms.appstate.AppStateManager.StateListResult
        {

            private final AppStateBuffer yQ;

            public final AppStateBuffer getStateBuffer()
            {
                return yQ;
            }

            public d(DataHolder dataholder)
            {
                super(dataholder);
                yQ = new AppStateBuffer(dataholder);
            }
        }

    }


    private class a extends ga
    {

        private final com.google.android.gms.common.api.a.d yO;

        public final void b(int i, int j)
        {
            Status status = new Status(i);
            yO.a(new b(status, j));
        }

        public a(com.google.android.gms.common.api.a.d d)
        {
            yO = (com.google.android.gms.common.api.a.d)hn.b(d, "Result holder must not be null");
        }

        private class b
            implements com.google.android.gms.appstate.AppStateManager.StateDeletedResult
        {

            private final int yP;
            private final Status yw;

            public final int getStateKey()
            {
                return yP;
            }

            public final Status getStatus()
            {
                return yw;
            }

            public b(Status status, int i)
            {
                yw = status;
                yP = i;
            }
        }

    }


    private class e extends ga
    {

        private final com.google.android.gms.common.api.a.d yO;

        public final void a(int i, DataHolder dataholder)
        {
            yO.a(new f(i, dataholder));
        }

        public e(com.google.android.gms.common.api.a.d d)
        {
            yO = (com.google.android.gms.common.api.a.d)hn.b(d, "Result holder must not be null");
        }

        private class f extends com.google.android.gms.common.api.b
            implements com.google.android.gms.appstate.AppStateManager.StateConflictResult, com.google.android.gms.appstate.AppStateManager.StateLoadedResult, com.google.android.gms.appstate.AppStateManager.StateResult
        {

            private final int yP;
            private final AppStateBuffer yQ;

            private boolean dR()
            {
                return yw.getStatusCode() == 2000;
            }

            public final com.google.android.gms.appstate.AppStateManager.StateConflictResult getConflictResult()
            {
                if (dR())
                {
                    return this;
                } else
                {
                    return null;
                }
            }

            public final com.google.android.gms.appstate.AppStateManager.StateLoadedResult getLoadedResult()
            {
                if (dR())
                {
                    this = null;
                }
                return this;
            }

            public final byte[] getLocalData()
            {
                if (yQ.getCount() == 0)
                {
                    return null;
                } else
                {
                    return yQ.get(0).getLocalData();
                }
            }

            public final String getResolvedVersion()
            {
                if (yQ.getCount() == 0)
                {
                    return null;
                } else
                {
                    return yQ.get(0).getConflictVersion();
                }
            }

            public final byte[] getServerData()
            {
                if (yQ.getCount() == 0)
                {
                    return null;
                } else
                {
                    return yQ.get(0).getConflictData();
                }
            }

            public final int getStateKey()
            {
                return yP;
            }

            public final void release()
            {
                yQ.close();
            }

            public f(int i, DataHolder dataholder)
            {
                super(dataholder);
                yP = i;
                yQ = new AppStateBuffer(dataholder);
            }
        }

    }


    private class g extends ga
    {

        private final com.google.android.gms.common.api.a.d yO;

        public final void dO()
        {
            Status status = new Status(0);
            yO.a(status);
        }

        public g(com.google.android.gms.common.api.a.d d)
        {
            yO = (com.google.android.gms.common.api.a.d)hn.b(d, "Holder must not be null");
        }
    }

}
