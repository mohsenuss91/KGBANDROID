// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class AnalyticsConnectivityReceiver extends BroadcastReceiver
{

    private a a;
    private boolean b;

    public AnalyticsConnectivityReceiver(Context context, a a1)
    {
        a = a1;
        bind(context);
    }

    public final void bind(Context context)
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentfilter);
    }

    public boolean isConnected()
    {
        return b;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getBooleanExtra("noConnectivity", false))
        {
            b = false;
            if (a != null)
            {
                a.a();
            }
        } else
        if (!intent.getBooleanExtra("noConnectivity", false))
        {
            b = true;
            if (a != null)
            {
                a.b();
                return;
            }
        }
    }

    public void unbind(Context context)
    {
        context.unregisterReceiver(this);
    }

    private class a
    {

        public abstract void a();

        public abstract void b();
    }

}
