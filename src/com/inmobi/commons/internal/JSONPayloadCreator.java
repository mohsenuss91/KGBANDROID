// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.data.LocationInfo;
import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.cellular.CellUtil;
import com.inmobi.commons.thinICE.icedatacollector.Sample;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import com.inmobi.commons.uid.UIDUtil;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.internal:
//            PayloadCreator, InternalSDKUtil, Log

public class JSONPayloadCreator
    implements PayloadCreator
{

    public JSONPayloadCreator()
    {
    }

    private JSONObject a(ActivityRecognitionSampler.ActivitySample activitysample)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("t", 3);
            jsonobject.put("ts", activitysample.getTimestamp());
            jsonobject.put("a", activitysample.getActivity());
        }
        catch (Exception exception)
        {
            return null;
        }
        return jsonobject;
    }

    private JSONObject a(CellTowerInfo celltowerinfo)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("id", celltowerinfo.id);
            if (celltowerinfo.signalStrength != 0)
            {
                jsonobject.put("ss", celltowerinfo.signalStrength);
            }
        }
        catch (Exception exception)
        {
            return null;
        }
        return jsonobject;
    }

    private JSONObject a(Sample sample, ThinICEConfig thiniceconfig)
    {
        JSONObject jsonobject;
        JSONArray jsonarray;
        Iterator iterator;
        jsonobject = new JSONObject();
        jsonobject.put("t", 1);
        if (thiniceconfig.isConnectedWifiEnabled())
        {
            jsonobject.put("c-ap", a(sample.connectedWifiAp));
        }
        if (thiniceconfig.isCellEnabled())
        {
            jsonobject.put("c-sc", a(sample.connectedCellTowerInfo));
        }
        if (!thiniceconfig.isVisibleWifiEnabled())
        {
            break MISSING_BLOCK_LABEL_153;
        }
        jsonarray = new JSONArray();
        if (sample.visibleWifiAp == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        iterator = sample.visibleWifiAp.iterator();
_L1:
        JSONObject jsonobject1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        jsonobject1 = a((WifiInfo)iterator.next());
        if (jsonobject1 != null)
        {
            try
            {
                jsonarray.put(jsonobject1);
            }
            catch (JSONException jsonexception)
            {
                return null;
            }
        }
          goto _L1
        if (jsonarray.length() > 0)
        {
            jsonobject.put("v-ap", jsonarray);
        }
        if (jsonobject.length() <= 1)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        jsonobject.put("ts", sample.utc);
        return jsonobject;
        return null;
    }

    private JSONObject a(WifiInfo wifiinfo)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("bssid", wifiinfo.bssid);
            jsonobject.put("essid", wifiinfo.ssid);
        }
        catch (Exception exception)
        {
            return null;
        }
        return jsonobject;
    }

    public static String currentLocationStr()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (LocationInfo.isValidGeoInfo())
        {
            stringbuilder.append(LocationInfo.getLat());
            stringbuilder.append(",");
            stringbuilder.append(LocationInfo.getLon());
            stringbuilder.append(",");
            stringbuilder.append((int)LocationInfo.getLocAccuracy());
            return stringbuilder.toString();
        } else
        {
            return "";
        }
    }

    public String toPayloadString(List list, List list1, Context context)
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        ThinICEConfig thiniceconfig = AnalyticsInitializer.getConfigParams().getThinIceConfig();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Sample sample = (Sample)iterator.next();
            if (sample != null)
            {
                JSONObject jsonobject2 = a(sample, thiniceconfig);
                if (jsonobject2 != null)
                {
                    jsonarray.put(jsonobject2);
                }
            }
        } while (true);
        Iterator iterator1 = list1.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            ActivityRecognitionSampler.ActivitySample activitysample = (ActivityRecognitionSampler.ActivitySample)iterator1.next();
            if (activitysample != null)
            {
                JSONObject jsonobject1 = a(activitysample);
                if (jsonobject1 != null)
                {
                    jsonarray.put(jsonobject1);
                }
            }
        } while (true);
        String s;
        Map map;
        try
        {
            if (jsonarray.length() > 0)
            {
                jsonobject.put("payload", jsonarray);
            }
            CellOperatorInfo celloperatorinfo = CellUtil.getCellNetworkInfo(context);
            if (thiniceconfig.isOperatorEnabled())
            {
                if (!ThinICEConfigSettings.bitTest(thiniceconfig.getCellOpsFlag(), 1) && (celloperatorinfo.simMcc != -1 || celloperatorinfo.simMnc != -1))
                {
                    jsonobject.put("s-ho", (new StringBuilder()).append(celloperatorinfo.simMcc).append("_").append(celloperatorinfo.simMnc).toString());
                }
                if (!ThinICEConfigSettings.bitTest(thiniceconfig.getCellOpsFlag(), 2) && (celloperatorinfo.currentMcc != -1 || celloperatorinfo.currentMnc != -1))
                {
                    jsonobject.put("s-co", (new StringBuilder()).append(celloperatorinfo.currentMcc).append("_").append(celloperatorinfo.currentMnc).toString());
                }
            }
            Calendar calendar = Calendar.getInstance();
            System.currentTimeMillis();
            jsonobject.put("tz", calendar.get(15) + calendar.get(16));
            jsonobject.put("ts", calendar.getTimeInMillis());
            jsonobject.put("mk-version", (new StringBuilder("pr-SAND-")).append(InternalSDKUtil.getInMobiInternalVersion("4.4.1")).append("-20140613").toString());
            s = currentLocationStr();
        }
        catch (JSONException jsonexception)
        {
            Log.internal("[InMobi]-4.4.1", "Unable to create payload for sending ThinICE params");
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        if (!"".equals(s))
        {
            jsonobject.put("u-latlong-accu", s);
        }
        map = UIDUtil.getMap(context, null);
        map.remove("ua");
        map.remove("s-ver");
        UIDUtil.bindToEncodedJSON(map, jsonobject);
        return jsonobject.toString();
    }
}
