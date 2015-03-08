// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.icedatacollector;

import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.location.LocationInfo;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class Sample
{

    public CellOperatorInfo cellOperator;
    public CellTowerInfo connectedCellTowerInfo;
    public WifiInfo connectedWifiAp;
    public HashMap lastKnownLocations;
    public long utc;
    public List visibleWifiAp;
    public int zoneOffset;

    Sample()
    {
        Calendar calendar = Calendar.getInstance();
        utc = calendar.getTimeInMillis();
        zoneOffset = calendar.get(15) + calendar.get(16);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[\n");
        stringbuilder.append("-- utc: ").append(utc).append("\n");
        stringbuilder.append("-- zoneOffset: ").append(zoneOffset).append("\n");
        stringbuilder.append("-- cell operator: ").append(cellOperator).append("\n");
        stringbuilder.append("-- connected wifi access point: ").append(connectedWifiAp).append("\n");
        stringbuilder.append("-- last known locations:");
        if (lastKnownLocations == null)
        {
            stringbuilder.append(" null\n");
        } else
        {
            stringbuilder.append("\n");
            Iterator iterator = lastKnownLocations.values().iterator();
            while (iterator.hasNext()) 
            {
                LocationInfo locationinfo = (LocationInfo)iterator.next();
                stringbuilder.append("   + ").append(locationinfo).append("\n");
            }
        }
        stringbuilder.append("-- visible wifi aps:");
        if (visibleWifiAp == null)
        {
            stringbuilder.append(" null\n");
        } else
        {
            stringbuilder.append("\n");
            Iterator iterator1 = visibleWifiAp.iterator();
            while (iterator1.hasNext()) 
            {
                WifiInfo wifiinfo = (WifiInfo)iterator1.next();
                stringbuilder.append("   + ").append(wifiinfo).append("\n");
            }
        }
        stringbuilder.append("-- connected serving cell tower: ").append(connectedCellTowerInfo).append("\n");
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
