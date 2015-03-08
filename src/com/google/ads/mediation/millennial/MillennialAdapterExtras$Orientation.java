// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


public final class description extends Enum
{

    public static final ENUM.VALUES BISEXUAL;
    private static final ENUM.VALUES ENUM$VALUES[];
    public static final ENUM.VALUES GAY;
    public static final ENUM.VALUES NOT_SURE;
    public static final ENUM.VALUES STRAIGHT;
    private final String description;

    public static description valueOf(String s)
    {
        return (description)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Orientation, s);
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
        STRAIGHT = new <init>("STRAIGHT", 0, "straight");
        GAY = new <init>("GAY", 1, "gay");
        BISEXUAL = new <init>("BISEXUAL", 2, "bisexual");
        NOT_SURE = new <init>("NOT_SURE", 3, "notsure");
        description adescription[] = new <init>[4];
        adescription[0] = STRAIGHT;
        adescription[1] = GAY;
        adescription[2] = BISEXUAL;
        adescription[3] = NOT_SURE;
        ENUM$VALUES = adescription;
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        description = s1;
    }
}
