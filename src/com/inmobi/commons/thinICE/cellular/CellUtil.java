// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.cellular;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

// Referenced classes of package com.inmobi.commons.thinICE.cellular:
//            CellOperatorInfo, CellTowerInfo

public final class CellUtil
{

    private static final String a[] = {
        "android.permission.ACCESS_COARSE_LOCATION"
    };

    public CellUtil()
    {
    }

    private static int[] a(String s)
    {
        int ai[] = {
            -1, -1
        };
        if (s == null || s.equals(""))
        {
            return ai;
        }
        try
        {
            int i = Integer.parseInt(s.substring(0, 3));
            int j = Integer.parseInt(s.substring(3));
            ai[0] = i;
            ai[1] = j;
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return ai;
        }
        catch (NumberFormatException numberformatexception)
        {
            return ai;
        }
        return ai;
    }

    public static CellOperatorInfo getCellNetworkInfo(Context context)
    {
        CellOperatorInfo celloperatorinfo = new CellOperatorInfo();
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        int ai[] = a(telephonymanager.getNetworkOperator());
        celloperatorinfo.currentMcc = ai[0];
        celloperatorinfo.currentMnc = ai[1];
        int ai1[] = a(telephonymanager.getSimOperator());
        celloperatorinfo.simMcc = ai1[0];
        celloperatorinfo.simMnc = ai1[1];
        return celloperatorinfo;
    }

    public static CellTowerInfo getCurrentCellTower(Context context)
    {
        android.telephony.CellLocation celllocation;
        CellTowerInfo celltowerinfo;
        String s;
        String s1;
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        int ai[] = a(telephonymanager.getNetworkOperator());
        celllocation = telephonymanager.getCellLocation();
        if (celllocation == null || ai[0] == -1)
        {
            return null;
        }
        celltowerinfo = new CellTowerInfo();
        s = String.valueOf(ai[0]);
        s1 = String.valueOf(ai[1]);
        if (!(celllocation instanceof CdmaCellLocation)) goto _L2; else goto _L1
_L1:
        CdmaCellLocation cdmacelllocation = (CdmaCellLocation)celllocation;
        int k = cdmacelllocation.getNetworkId();
        int l = cdmacelllocation.getBaseStationId();
        int i1 = cdmacelllocation.getSystemId();
        celltowerinfo.signalStrength = a.b(context);
        if (k != -1 && l != -1 && i1 != -1)
        {
            String s4 = Integer.toHexString(k);
            String s5 = Integer.toHexString(l);
            String s6 = Integer.toHexString(i1);
            celltowerinfo.id = (new StringBuilder()).append(s).append("-").append(s1).append("-").append(s4).append("-").append(s5).append("-").append(s6).toString();
        }
_L4:
        return celltowerinfo;
_L2:
        GsmCellLocation gsmcelllocation = (GsmCellLocation)celllocation;
        int i = gsmcelllocation.getCid();
        int j = gsmcelllocation.getLac();
        celltowerinfo.signalStrength = a.a(context);
        if (i != -1 && j != -1)
        {
            String s2 = Integer.toHexString(j);
            String s3 = Integer.toHexString(i);
            celltowerinfo.id = (new StringBuilder()).append(s).append("-").append(s1).append("-").append(s2).append("-").append(s3).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean hasGetCurrentServingCellPermission(Context context)
    {
        String as[] = a;
        int i = as.length;
        for (int j = 0; j < i; j++)
        {
            if (context.checkCallingOrSelfPermission(as[j]) != 0)
            {
                return false;
            }
        }

        return true;
    }


    private class a
    {

        static int a(Context context)
        {
            TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
            ArrayList arraylist = (ArrayList)android/telephony/TelephonyManager.getMethod("getAllCellInfo", null).invoke(telephonymanager, null);
            if (arraylist == null)
            {
                break MISSING_BLOCK_LABEL_104;
            }
            int i;
            Object obj = arraylist.get(0);
            Object obj1 = Class.forName("android.telephony.CellInfoGsm").getMethod("getCellSignalStrength", null).invoke(obj, null);
            i = ((Integer)Class.forName("android.telephony.CellSignalStrengthGsm").getMethod("getDbm", null).invoke(obj1, null)).intValue();
            return i;
            Exception exception;
            exception;
            if (BuildSettings.DEBUG)
            {
                Log.e("IceDataCollector", "Error getting cell tower signal strength", exception);
            }
            return 0;
        }

        static int b(Context context)
        {
            TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
            ArrayList arraylist = (ArrayList)android/telephony/TelephonyManager.getMethod("getAllCellInfo", null).invoke(telephonymanager, null);
            if (arraylist == null)
            {
                break MISSING_BLOCK_LABEL_104;
            }
            int i;
            Object obj = arraylist.get(0);
            Object obj1 = Class.forName("android.telephony.CellInfoCdma").getMethod("getCellSignalStrength", null).invoke(obj, null);
            i = ((Integer)Class.forName("android.telephony.CellSignalStrengthCdma").getMethod("getDbm", null).invoke(obj1, null)).intValue();
            return i;
            Exception exception;
            exception;
            if (BuildSettings.DEBUG)
            {
                Log.e("IceDataCollector", "Error getting cell tower signal strength", exception);
            }
            return 0;
        }

        a()
        {
        }
    }

}
