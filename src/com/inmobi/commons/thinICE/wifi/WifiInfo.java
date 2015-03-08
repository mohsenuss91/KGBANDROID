// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.wifi;


public final class WifiInfo
{

    public long bssid;
    public int ip;
    public int rssi;
    public String ssid;

    public WifiInfo()
    {
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        stringbuilder.append("bssid=").append(bssid).append(", ");
        stringbuilder.append("ssid=").append(ssid).append(", ");
        stringbuilder.append("rssi=").append(rssi).append(", ");
        StringBuilder stringbuilder1 = stringbuilder.append("ip=");
        Object aobj[] = new Object[4];
        aobj[0] = Integer.valueOf(0xff & ip);
        aobj[1] = Integer.valueOf(0xff & ip >> 8);
        aobj[2] = Integer.valueOf(0xff & ip >> 16);
        aobj[3] = Integer.valueOf(0xff & ip >> 24);
        stringbuilder1.append(String.format("%d.%d.%d.%d", aobj));
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
