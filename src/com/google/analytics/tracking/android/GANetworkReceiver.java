// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

// Referenced classes of package com.google.analytics.tracking.android:
//            ServiceManager

class GANetworkReceiver extends BroadcastReceiver
{

    static final String SELF_IDENTIFYING_EXTRA = com/google/analytics/tracking/android/GANetworkReceiver.getName();
    private final ServiceManager mManager;

    GANetworkReceiver(ServiceManager servicemanager)
    {
        mManager = servicemanager;
    }

    public static void sendRadioPoweredBroadcast(Context context)
    {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(SELF_IDENTIFYING_EXTRA, true);
        context.sendBroadcast(intent);
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(s))
        {
            boolean flag = intent.getBooleanExtra("noConnectivity", false);
            ServiceManager servicemanager = mManager;
            boolean flag1 = false;
            if (!flag)
            {
                flag1 = true;
            }
            servicemanager.updateConnectivityStatus(flag1);
        } else
        if ("com.google.analytics.RADIO_POWERED".equals(s) && !intent.hasExtra(SELF_IDENTIFYING_EXTRA))
        {
            mManager.onRadioPowered();
            return;
        }
    }

    public void register(Context context)
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentfilter);
        IntentFilter intentfilter1 = new IntentFilter();
        intentfilter1.addAction("com.google.analytics.RADIO_POWERED");
        intentfilter1.addCategory(context.getPackageName());
        context.registerReceiver(this, intentfilter1);
    }

}
