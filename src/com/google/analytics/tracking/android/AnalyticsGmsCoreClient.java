// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.analytics.tracking.android:
//            AnalyticsClient, Log

class AnalyticsGmsCoreClient
    implements AnalyticsClient
{

    private static final int BIND_ADJUST_WITH_ACTIVITY = 128;
    public static final int BIND_FAILED = 1;
    public static final String KEY_APP_PACKAGE_NAME = "app_package_name";
    public static final int REMOTE_EXECUTION_FAILED = 2;
    static final String SERVICE_ACTION = "com.google.android.gms.analytics.service.START";
    private static final String SERVICE_DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
    private ServiceConnection mConnection;
    private Context mContext;
    private OnConnectedListener mOnConnectedListener;
    private OnConnectionFailedListener mOnConnectionFailedListener;
    private IAnalyticsService mService;

    public AnalyticsGmsCoreClient(Context context, OnConnectedListener onconnectedlistener, OnConnectionFailedListener onconnectionfailedlistener)
    {
        mContext = context;
        if (onconnectedlistener == null)
        {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        mOnConnectedListener = onconnectedlistener;
        if (onconnectionfailedlistener == null)
        {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        } else
        {
            mOnConnectionFailedListener = onconnectionfailedlistener;
            return;
        }
    }

    private IAnalyticsService getService()
    {
        checkConnected();
        return mService;
    }

    private void onConnectionSuccess()
    {
        mOnConnectedListener.onConnected();
    }

    private void onServiceBound()
    {
        onConnectionSuccess();
    }

    protected void checkConnected()
    {
        if (!isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    public void clearHits()
    {
        try
        {
            getService().clearHits();
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e((new StringBuilder("clear hits failed: ")).append(remoteexception).toString());
        }
    }

    public void connect()
    {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", mContext.getPackageName());
        if (mConnection != null)
        {
            Log.e("Calling connect() while still connected, missing disconnect().");
        } else
        {
            mConnection = new AnalyticsServiceConnection();
            boolean flag = mContext.bindService(intent, mConnection, 129);
            Log.v((new StringBuilder("connect: bindService returned ")).append(flag).append(" for ").append(intent).toString());
            if (!flag)
            {
                mConnection = null;
                mOnConnectionFailedListener.onConnectionFailed(1, null);
                return;
            }
        }
    }

    public void disconnect()
    {
        mService = null;
        if (mConnection != null)
        {
            try
            {
                mContext.unbindService(mConnection);
            }
            catch (IllegalStateException illegalstateexception) { }
            catch (IllegalArgumentException illegalargumentexception) { }
            mConnection = null;
            mOnConnectedListener.onDisconnected();
        }
    }

    public boolean isConnected()
    {
        return mService != null;
    }

    public void sendHit(Map map, long l, String s, List list)
    {
        try
        {
            getService().sendHit(map, l, s, list);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e((new StringBuilder("sendHit failed: ")).append(remoteexception).toString());
        }
    }


/*
    static IAnalyticsService access$002(AnalyticsGmsCoreClient analyticsgmscoreclient, IAnalyticsService ianalyticsservice)
    {
        analyticsgmscoreclient.mService = ianalyticsservice;
        return ianalyticsservice;
    }

*/




/*
    static ServiceConnection access$302(AnalyticsGmsCoreClient analyticsgmscoreclient, ServiceConnection serviceconnection)
    {
        analyticsgmscoreclient.mConnection = serviceconnection;
        return serviceconnection;
    }

*/



    private class OnConnectedListener
    {

        public abstract void onConnected();

        public abstract void onDisconnected();
    }


    private class AnalyticsServiceConnection
        implements ServiceConnection
    {

        final AnalyticsGmsCoreClient this$0;

        public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            Log.v((new StringBuilder("service connected, binder: ")).append(ibinder).toString());
            try
            {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(ibinder.getInterfaceDescriptor()))
                {
                    Log.v("bound to service");
                    mService = com.google.android.gms.analytics.internal.IAnalyticsService.Stub.asInterface(ibinder);
                    onConnectionSuccess();
                    return;
                }
            }
            catch (RemoteException remoteexception) { }
            mContext.unbindService(this);
            mConnection = null;
            mOnConnectionFailedListener.onConnectionFailed(2, null);
        }

        public final void onServiceDisconnected(ComponentName componentname)
        {
            Log.v((new StringBuilder("service disconnected: ")).append(componentname).toString());
            mConnection = null;
            mOnConnectedListener.onDisconnected();
        }

        AnalyticsServiceConnection()
        {
            this$0 = AnalyticsGmsCoreClient.this;
            super();
        }
    }


    private class OnConnectionFailedListener
    {

        public abstract void onConnectionFailed(int i, Intent intent);
    }

}
