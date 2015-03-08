// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

// Referenced classes of package com.inmobi.commons.thinICE.wifi:
//            WifiScanner, WifiScanListener

final class a extends BroadcastReceiver
{

    a()
    {
    }

    public final void onReceive(Context context, Intent intent)
    {
        WifiScanListener wifiscanlistener;
        WifiManager wifimanager;
        try
        {
            wifiscanlistener = WifiScanner.a();
            wifimanager = (WifiManager)WifiScanner.c().getSystemService("wifi");
            WifiScanner.b();
        }
        catch (Exception exception)
        {
            return;
        }
        if (wifiscanlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        wifiscanlistener.onResultsReceived(wifimanager.getScanResults());
    }
}
