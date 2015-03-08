// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class ConnBroadcastReciever extends BroadcastReceiver
{

    public ConnBroadcastReciever()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || !InternalSDKUtil.checkNetworkAvailibility(context))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Log.internal("[InMobi]-[Network]-4.4.1", "Received CONNECTIVITY BROADCAST");
        RequestResponseManager requestresponsemanager = new RequestResponseManager();
        requestresponsemanager.init();
        requestresponsemanager.processClick(context.getApplicationContext(), null);
        return;
        Exception exception;
        exception;
        Log.internal("[InMobi]-[Network]-4.4.1", "Connectivity receiver exception", exception);
        return;
    }
}
