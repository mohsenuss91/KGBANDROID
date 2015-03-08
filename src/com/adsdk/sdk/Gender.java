// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk;


public final class Gender extends Enum
{

    private static final Gender ENUM$VALUES[];
    public static final Gender FEMALE;
    public static final Gender MALE;
    private String param;

    private Gender(String s, int i, String s1)
    {
        super(s, i);
        param = s1;
    }

    public static Gender valueOf(String s)
    {
        return (Gender)Enum.valueOf(com/adsdk/sdk/Gender, s);
    }

    public static Gender[] values()
    {
        Gender agender[] = ENUM$VALUES;
        int i = agender.length;
        Gender agender1[] = new Gender[i];
        System.arraycopy(agender, 0, agender1, 0, i);
        return agender1;
    }

    public final String getServerParam()
    {
        return param;
    }

    static 
    {
        MALE = new Gender("MALE", 0, "m");
        FEMALE = new Gender("FEMALE", 1, "f");
        Gender agender[] = new Gender[2];
        agender[0] = MALE;
        agender[1] = FEMALE;
        ENUM$VALUES = agender;
    }
}
