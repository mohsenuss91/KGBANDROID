// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.cellular;


public final class CellTowerInfo
{

    public String id;
    public int signalStrength;

    public CellTowerInfo()
    {
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        stringbuilder.append("id=").append(id).append(", ");
        stringbuilder.append("ss=").append(signalStrength).append(", ");
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
