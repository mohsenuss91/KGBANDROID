// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hn;
import java.lang.reflect.Method;

public class ProviderInstaller
{

    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method adX = null;
    private static final Object qm = new Object();

    public ProviderInstaller()
    {
    }

    private static void I(Context context)
    {
        adX = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] {
            android/content/Context
        });
    }

    public static void installIfNeeded(Context context)
    {
        obj;
        JVM INSTR monitorenter ;
        hn.b(context, "Context must not be null");
        GooglePlayServicesUtil.w(context);
        Context context1 = GooglePlayServicesUtil.getRemoteContext(context);
        if (context1 == null)
        {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        Exception exception1;
        synchronized (qm)
        {
            if (adX == null)
            {
                I(context1);
            }
            adX.invoke(null, new Object[] {
                context1
            });
        }
        return;
        exception1;
        Log.e("ProviderInstaller", (new StringBuilder("Failed to install provider: ")).append(exception1.getMessage()).toString());
        throw new GooglePlayServicesNotAvailableException(8);
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerinstalllistener)
    {
        hn.b(context, "Context must not be null");
        hn.b(providerinstalllistener, "Listener must not be null");
        hn.ay("Must be called on the UI thread");
        (new _cls1(context, providerinstalllistener)).execute(new Void[0]);
    }


    private class _cls1 extends AsyncTask
    {

        final ProviderInstallListener adY;
        final Context qr;

        protected final transient Integer b(Void avoid[])
        {
            try
            {
                ProviderInstaller.installIfNeeded(qr);
            }
            catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
            {
                return Integer.valueOf(googleplayservicesrepairableexception.getConnectionStatusCode());
            }
            catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
            {
                return Integer.valueOf(googleplayservicesnotavailableexception.errorCode);
            }
            return Integer.valueOf(0);
        }

        protected final void d(Integer integer)
        {
            if (integer.intValue() == 0)
            {
                adY.onProviderInstalled();
                return;
            } else
            {
                Intent intent = GooglePlayServicesUtil.Z(integer.intValue());
                adY.onProviderInstallFailed(integer.intValue(), intent);
                return;
            }
        }

        protected final Object doInBackground(Object aobj[])
        {
            return b((Void[])aobj);
        }

        protected final void onPostExecute(Object obj)
        {
            d((Integer)obj);
        }

        _cls1(Context context, ProviderInstallListener providerinstalllistener)
        {
            qr = context;
            adY = providerinstalllistener;
            super();
        }

        private class ProviderInstallListener
        {

            public abstract void onProviderInstallFailed(int i, Intent intent);

            public abstract void onProviderInstalled();
        }

    }

}
