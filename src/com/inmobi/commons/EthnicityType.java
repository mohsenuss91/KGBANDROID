// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class EthnicityType extends Enum
{

    public static final EthnicityType AFRICANAMERICAN;
    public static final EthnicityType ASIAN;
    public static final EthnicityType CAUCASIAN;
    public static final EthnicityType HISPANIC;
    public static final EthnicityType OTHER;
    public static final EthnicityType UNKNOWN;
    private static final EthnicityType a[];

    private EthnicityType(String s, int i)
    {
        super(s, i);
    }

    public static EthnicityType valueOf(String s)
    {
        return (EthnicityType)Enum.valueOf(com/inmobi/commons/EthnicityType, s);
    }

    public static EthnicityType[] values()
    {
        return (EthnicityType[])a.clone();
    }

    static 
    {
        HISPANIC = new EthnicityType("HISPANIC", 0);
        AFRICANAMERICAN = new EthnicityType("AFRICANAMERICAN", 1);
        ASIAN = new EthnicityType("ASIAN", 2);
        CAUCASIAN = new EthnicityType("CAUCASIAN", 3);
        OTHER = new EthnicityType("OTHER", 4);
        UNKNOWN = new EthnicityType("UNKNOWN", 5);
        EthnicityType aethnicitytype[] = new EthnicityType[6];
        aethnicitytype[0] = HISPANIC;
        aethnicitytype[1] = AFRICANAMERICAN;
        aethnicitytype[2] = ASIAN;
        aethnicitytype[3] = CAUCASIAN;
        aethnicitytype[4] = OTHER;
        aethnicitytype[5] = UNKNOWN;
        a = aethnicitytype;
    }
}
