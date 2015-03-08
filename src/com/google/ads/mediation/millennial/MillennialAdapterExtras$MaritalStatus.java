// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


public final class description extends Enum
{

    public static final ENUM.VALUES DIVORCED;
    public static final ENUM.VALUES ENGAGED;
    private static final ENUM.VALUES ENUM$VALUES[];
    public static final ENUM.VALUES MARRIED;
    public static final ENUM.VALUES RELATIONSHIP;
    public static final ENUM.VALUES SINGLE;
    private final String description;

    public static description valueOf(String s)
    {
        return (description)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$MaritalStatus, s);
    }

    public static description[] values()
    {
        description adescription[] = ENUM$VALUES;
        int i = adescription.length;
        description adescription1[] = new ENUM.VALUES[i];
        System.arraycopy(adescription, 0, adescription1, 0, i);
        return adescription1;
    }

    public final String getDescription()
    {
        return description;
    }

    static 
    {
        SINGLE = new <init>("SINGLE", 0, "single");
        DIVORCED = new <init>("DIVORCED", 1, "divorced");
        ENGAGED = new <init>("ENGAGED", 2, "engaged");
        RELATIONSHIP = new <init>("RELATIONSHIP", 3, "relationship");
        MARRIED = new <init>("MARRIED", 4, "married");
        description adescription[] = new <init>[5];
        adescription[0] = SINGLE;
        adescription[1] = DIVORCED;
        adescription[2] = ENGAGED;
        adescription[3] = RELATIONSHIP;
        adescription[4] = MARRIED;
        ENUM$VALUES = adescription;
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        description = s1;
    }
}
