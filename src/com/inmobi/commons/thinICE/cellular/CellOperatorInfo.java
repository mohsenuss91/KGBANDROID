// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.thinICE.cellular;


public final class CellOperatorInfo
{

    public static final int MCC_NOT_AVAILABLE = -1;
    public static final int MNC_NOT_AVAILABLE = -1;
    public int currentMcc;
    public int currentMnc;
    public int simMcc;
    public int simMnc;

    public CellOperatorInfo()
    {
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getClass().getSimpleName()).append("[");
        stringbuilder.append("currentMcc=").append(currentMcc).append(", ");
        stringbuilder.append("currentMnc=").append(currentMnc).append(", ");
        stringbuilder.append("simMcc=").append(simMcc).append(", ");
        stringbuilder.append("simMnc=").append(simMnc);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
