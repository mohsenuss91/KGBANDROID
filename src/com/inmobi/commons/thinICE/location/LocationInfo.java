// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.location;


public final class LocationInfo
{

    public float accuracy;
    public double latitude;
    public double longitude;
    public String provider;
    public long time;

    public LocationInfo()
    {
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        stringbuilder.append("time=").append(time).append(", ");
        stringbuilder.append("provider=").append(provider).append(", ");
        stringbuilder.append("latitude=").append(latitude).append(", ");
        stringbuilder.append("longitude=").append(longitude).append(", ");
        stringbuilder.append("accuracy=").append(accuracy);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
