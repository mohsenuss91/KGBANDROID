// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.analytics.androidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.URLEncoder;

public class IMAdTrackerReceiver extends BroadcastReceiver
{

    public IMAdTrackerReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        Log.debug("[InMobi]-[AdTracker]-4.4.1", "Received INSTALL REFERRER");
        String s = intent.getExtras().getString("referrer");
        Log.debug("[InMobi]-[AdTracker]-4.4.1", (new StringBuilder("Referrer String: ")).append(s).toString());
        FileOperations.setPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "rfs", 1);
        String s1 = URLEncoder.encode(s, "utf-8");
        AdTrackerUtils.setInternalReferrer(context.getApplicationContext(), s1);
_L1:
        return;
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[AdTracker]-4.4.1", "Error install receiver", exception1);
        return;
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && InternalSDKUtil.checkNetworkAvailibility(context))
        {
            try
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Received CONNECTIVITY BROADCAST");
                AdTrackerNetworkInterface.init();
                AdTrackerNetworkInterface.reportToServer(FileOperations.getPreferences(context.getApplicationContext(), "IMAdTrackerStatusUpload", "mk-siteid"));
                return;
            }
            catch (Exception exception)
            {
                Log.internal("[InMobi]-[AdTracker]-4.4.1", "Connectivity receiver exception", exception);
            }
            return;
        }
          goto _L1
    }
}
