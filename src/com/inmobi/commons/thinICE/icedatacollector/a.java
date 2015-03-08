// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.location.LocationInfo;
import com.inmobi.commons.thinICE.location.LocationUtil;
import com.inmobi.commons.thinICE.wifi.WifiScanner;
import com.inmobi.commons.thinICE.wifi.WifiUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.inmobi.commons.thinICE.icedatacollector:
//            BuildSettings, IceDataCollector, ThinICEListener, ThinICEConfigSettings, 
//            Sample

final class a
    implements Runnable
{

    a()
    {
    }

    public final void run()
    {
        Sample sample;
        Object obj;
        HashMap hashmap;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "** sample runnable");
        }
        if (IceDataCollector.c() == null)
        {
            if (BuildSettings.DEBUG)
            {
                Log.w("IceDataCollector", "sampling when looper is null, exiting");
            }
            return;
        }
        if (android.os.Build.VERSION.SDK_INT < 14 && !IceDataCollector.d().hasWindowFocus())
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "activity no longer has focus, terminating");
            }
            IceDataCollector.b();
            LinkedList linkedlist = IceDataCollector.e();
            IceDataCollector.flush();
            IceDataCollector.a(null);
            IceDataCollector.a(null);
            if (IceDataCollector.f() != null)
            {
                IceDataCollector.f().onSamplingTerminated(linkedlist);
            }
            IceDataCollector.a(null);
            return;
        }
        IceDataCollector.i().postDelayed(IceDataCollector.g(), IceDataCollector.h().getSampleInterval());
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", (new StringBuilder("next sample in ")).append(IceDataCollector.h().getSampleInterval()).append(" ms").toString());
        }
        sample = new Sample();
        int i = IceDataCollector.h().getWifiFlags();
        boolean flag = ThinICEConfigSettings.bitTest(i, 2);
        boolean flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        boolean flag2 = ThinICEConfigSettings.bitTest(i, 1);
        int j = IceDataCollector.h().getCellOpFlags();
        boolean flag3 = ThinICEConfigSettings.bitTest(j, 1);
        boolean flag4 = ThinICEConfigSettings.bitTest(j, 2);
        if (!IceDataCollector.h().isSampleCellOperatorEnabled())
        {
            break MISSING_BLOCK_LABEL_313;
        }
        Exception exception;
        Exception exception2;
        Iterator iterator;
        LocationInfo locationinfo;
        CellOperatorInfo celloperatorinfo;
        try
        {
            celloperatorinfo = CellUtil.getCellNetworkInfo(IceDataCollector.j());
        }
        catch (Exception exception4)
        {
            if (BuildSettings.DEBUG)
            {
                Log.e("IceDataCollector", "Error getting cell operator data", exception4);
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        celloperatorinfo.simMcc = -1;
        celloperatorinfo.simMnc = -1;
        if (!flag4)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        celloperatorinfo.currentMcc = -1;
        celloperatorinfo.currentMnc = -1;
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", (new StringBuilder("-- cell operator: ")).append(celloperatorinfo).toString());
        }
        sample.cellOperator = celloperatorinfo;
_L18:
        if (!IceDataCollector.h().isSampleCellEnabled()) goto _L2; else goto _L1
_L1:
        if (!CellUtil.hasGetCurrentServingCellPermission(IceDataCollector.j())) goto _L4; else goto _L3
_L3:
        sample.connectedCellTowerInfo = CellUtil.getCurrentCellTower(IceDataCollector.j());
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", (new StringBuilder("-- current serving cell: ")).append(sample.connectedCellTowerInfo.id).toString());
        }
_L2:
        sample.connectedWifiAp = IceDataCollector.getConnectedWifiInfo(IceDataCollector.j());
        if (!IceDataCollector.h().isSampleLocationEnabled()) goto _L6; else goto _L5
_L5:
        if (!LocationUtil.hasLocationPermission(IceDataCollector.j())) goto _L8; else goto _L7
_L7:
        hashmap = LocationUtil.getLastKnownLocations(IceDataCollector.j());
        if (BuildSettings.DEBUG)
        {
            Log.d("IceDataCollector", "-- locations:");
            for (iterator = hashmap.values().iterator(); iterator.hasNext(); Log.d("IceDataCollector", (new StringBuilder("   + ")).append(locationinfo).toString()))
            {
                locationinfo = (LocationInfo)iterator.next();
            }

        }
          goto _L9
_L6:
        if (!IceDataCollector.h().isSampleVisibleWifiEnabled()) goto _L11; else goto _L10
_L10:
        if (!WifiUtil.hasWifiScanPermission(IceDataCollector.j(), false)) goto _L13; else goto _L12
_L12:
        WifiScanner.requestScan(IceDataCollector.j(), new a(flag1, flag2));
_L11:
        obj = IceDataCollector.k();
        obj;
        JVM INSTR monitorenter ;
        IceDataCollector.a(sample);
        if (IceDataCollector.e() != null)
        {
            IceDataCollector.e().add(sample);
            for (; IceDataCollector.e().size() > IceDataCollector.h().getSampleHistorySize(); IceDataCollector.e().removeFirst()) { }
        }
        break MISSING_BLOCK_LABEL_730;
        exception;
        throw exception;
_L4:
        if (!BuildSettings.DEBUG) goto _L2; else goto _L14
_L14:
        Log.w("IceDataCollector", "application does not have permission to access current serving cell");
          goto _L2
        Exception exception3;
        exception3;
        if (BuildSettings.DEBUG)
        {
            Log.e("IceDataCollector", "Error getting cell data", exception3);
        }
          goto _L2
_L9:
        try
        {
            sample.lastKnownLocations = hashmap;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2)
        {
            if (BuildSettings.DEBUG)
            {
                Log.e("IceDataCollector", "Error getting location data", exception2);
            }
        }
          goto _L6
_L8:
        if (!BuildSettings.DEBUG) goto _L6; else goto _L15
_L15:
        Log.w("IceDataCollector", "application does not have permission to access location");
          goto _L6
_L13:
        if (!BuildSettings.DEBUG) goto _L11; else goto _L16
_L16:
        Log.w("IceDataCollector", "application does not have permission to scan for wifi access points");
          goto _L11
        Exception exception1;
        exception1;
        if (BuildSettings.DEBUG)
        {
            Log.e("IceDataCollector", "Error scanning for wifi", exception1);
        }
          goto _L11
        obj;
        JVM INSTR monitorexit ;
        return;
        if (true) goto _L18; else goto _L17
_L17:
    }

    private class a
        implements WifiScanListener
    {

        final boolean a;
        final boolean b;
        final com.inmobi.commons.thinICE.icedatacollector.a c;

        public void onResultsReceived(List list)
        {
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", (new StringBuilder("Received Wi-Fi scan results ")).append(list.size()).toString());
            }
            List list1 = WifiUtil.scanResultsToWifiInfos(list, a, b);
            if (BuildSettings.DEBUG)
            {
                Log.d("IceDataCollector", "-- wifi scan:");
                WifiInfo wifiinfo;
                for (Iterator iterator = list1.iterator(); iterator.hasNext(); Log.d("IceDataCollector", (new StringBuilder("   + ")).append(wifiinfo).toString()))
                {
                    wifiinfo = (WifiInfo)iterator.next();
                }

            }
            synchronized (IceDataCollector.k())
            {
                if (IceDataCollector.l() != null)
                {
                    IceDataCollector.l().visibleWifiAp = list1;
                }
            }
        }

        public void onTimeout()
        {
            if (BuildSettings.DEBUG)
            {
                Log.w("IceDataCollector", "Received Wi-Fi scan timeout");
            }
        }

        a(boolean flag, boolean flag1)
        {
            c = com.inmobi.commons.thinICE.icedatacollector.a.this;
            a = flag;
            b = flag1;
            super();
        }
    }

}
