// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class GenderType extends Enum
{

    public static final GenderType FEMALE;
    public static final GenderType MALE;
    public static final GenderType UNKNOWN;
    private static final GenderType a[];

    private GenderType(String s, int i)
    {
        super(s, i);
    }

    public static GenderType valueOf(String s)
    {
        return (GenderType)Enum.valueOf(com/inmobi/commons/GenderType, s);
    }

    public static GenderType[] values()
    {
        return (GenderType[])a.clone();
    }

    static 
    {
        UNKNOWN = new GenderType("UNKNOWN", 0);
        MALE = new GenderType("MALE", 1);
        FEMALE = new GenderType("FEMALE", 2);
        GenderType agendertype[] = new GenderType[3];
        agendertype[0] = UNKNOWN;
        agendertype[1] = MALE;
        agendertype[2] = FEMALE;
        a = agendertype;
    }
}
