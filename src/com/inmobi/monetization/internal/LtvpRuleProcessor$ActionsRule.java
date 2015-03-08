// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization.internal;


public final class a extends Enum
{

    public static final b ACTIONS_ONLY;
    public static final b ACTIONS_TO_MEDIATION;
    public static final b MEDIATION;
    public static final b NO_ADS;
    private static final b b[];
    int a;

    static a a(int i)
    {
        switch (i)
        {
        default:
            return MEDIATION;

        case 1: // '\001'
            return NO_ADS;

        case 2: // '\002'
            return ACTIONS_TO_MEDIATION;

        case 3: // '\003'
            return ACTIONS_ONLY;
        }
    }

    public static ACTIONS_ONLY valueOf(String s)
    {
        return (ACTIONS_ONLY)Enum.valueOf(com/inmobi/monetization/internal/LtvpRuleProcessor$ActionsRule, s);
    }

    public static ACTIONS_ONLY[] values()
    {
        return (ACTIONS_ONLY[])b.clone();
    }

    public final int getValue()
    {
        return a;
    }

    static 
    {
        MEDIATION = new <init>("MEDIATION", 0, 0);
        NO_ADS = new <init>("NO_ADS", 1, 1);
        ACTIONS_TO_MEDIATION = new <init>("ACTIONS_TO_MEDIATION", 2, 2);
        ACTIONS_ONLY = new <init>("ACTIONS_ONLY", 3, 3);
        a aa[] = new <init>[4];
        aa[0] = MEDIATION;
        aa[1] = NO_ADS;
        aa[2] = ACTIONS_TO_MEDIATION;
        aa[3] = ACTIONS_ONLY;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
