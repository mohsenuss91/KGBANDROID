// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


public final class IMErrorCode extends Enum
{

    public static final IMErrorCode DO_MONETIZE;
    public static final IMErrorCode DO_NOTHING;
    public static final IMErrorCode INTERNAL_ERROR;
    public static final IMErrorCode INVALID_REQUEST;
    public static final IMErrorCode NETWORK_ERROR;
    public static final IMErrorCode NO_FILL;
    private static final IMErrorCode b[];
    private String a;

    private IMErrorCode(String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }

    public static IMErrorCode valueOf(String s)
    {
        return (IMErrorCode)Enum.valueOf(com/inmobi/monetization/IMErrorCode, s);
    }

    public static IMErrorCode[] values()
    {
        return (IMErrorCode[])b.clone();
    }

    public final void setMessage(String s)
    {
        a = s;
    }

    public final String toString()
    {
        return a;
    }

    static 
    {
        INVALID_REQUEST = new IMErrorCode("INVALID_REQUEST", 0, "Invalid ad request");
        INTERNAL_ERROR = new IMErrorCode("INTERNAL_ERROR", 1, "An error occurred while fetching the ad");
        NO_FILL = new IMErrorCode("NO_FILL", 2, "The ad request was successful, but no ad was returned");
        DO_MONETIZE = new IMErrorCode("DO_MONETIZE", 3, "Please load a mediation network");
        DO_NOTHING = new IMErrorCode("DO_NOTHING", 4, "No Ads");
        NETWORK_ERROR = new IMErrorCode("NETWORK_ERROR", 5, "Ad network failed to retrieve ad");
        IMErrorCode aimerrorcode[] = new IMErrorCode[6];
        aimerrorcode[0] = INVALID_REQUEST;
        aimerrorcode[1] = INTERNAL_ERROR;
        aimerrorcode[2] = NO_FILL;
        aimerrorcode[3] = DO_MONETIZE;
        aimerrorcode[4] = DO_NOTHING;
        aimerrorcode[5] = NETWORK_ERROR;
        b = aimerrorcode;
    }
}
