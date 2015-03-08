// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class SexualOrientation extends Enum
{

    public static final SexualOrientation BISEXUAL;
    public static final SexualOrientation GAY;
    public static final SexualOrientation STRAIGHT;
    public static final SexualOrientation UNKNOWN;
    private static final SexualOrientation a[];

    private SexualOrientation(String s, int i)
    {
        super(s, i);
    }

    public static SexualOrientation valueOf(String s)
    {
        return (SexualOrientation)Enum.valueOf(com/inmobi/commons/SexualOrientation, s);
    }

    public static SexualOrientation[] values()
    {
        return (SexualOrientation[])a.clone();
    }

    static 
    {
        STRAIGHT = new SexualOrientation("STRAIGHT", 0);
        GAY = new SexualOrientation("GAY", 1);
        BISEXUAL = new SexualOrientation("BISEXUAL", 2);
        UNKNOWN = new SexualOrientation("UNKNOWN", 3);
        SexualOrientation asexualorientation[] = new SexualOrientation[4];
        asexualorientation[0] = STRAIGHT;
        asexualorientation[1] = GAY;
        asexualorientation[2] = BISEXUAL;
        asexualorientation[3] = UNKNOWN;
        a = asexualorientation;
    }
}
