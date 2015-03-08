// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class MaritalStatus extends Enum
{

    public static final MaritalStatus DIVORCED;
    public static final MaritalStatus ENGAGED;
    public static final MaritalStatus RELATIONSHIP;
    public static final MaritalStatus SINGLE;
    public static final MaritalStatus UNKNOWN;
    private static final MaritalStatus a[];

    private MaritalStatus(String s, int i)
    {
        super(s, i);
    }

    public static MaritalStatus valueOf(String s)
    {
        return (MaritalStatus)Enum.valueOf(com/inmobi/commons/MaritalStatus, s);
    }

    public static MaritalStatus[] values()
    {
        return (MaritalStatus[])a.clone();
    }

    static 
    {
        SINGLE = new MaritalStatus("SINGLE", 0);
        RELATIONSHIP = new MaritalStatus("RELATIONSHIP", 1);
        ENGAGED = new MaritalStatus("ENGAGED", 2);
        DIVORCED = new MaritalStatus("DIVORCED", 3);
        UNKNOWN = new MaritalStatus("UNKNOWN", 4);
        MaritalStatus amaritalstatus[] = new MaritalStatus[5];
        amaritalstatus[0] = SINGLE;
        amaritalstatus[1] = RELATIONSHIP;
        amaritalstatus[2] = ENGAGED;
        amaritalstatus[3] = DIVORCED;
        amaritalstatus[4] = UNKNOWN;
        a = amaritalstatus;
    }
}
