// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


public final class  extends Enum
{

    public static final ENUM.VALUES APP_LAUNCH;
    private static final ENUM.VALUES ENUM$VALUES[];
    public static final ENUM.VALUES TRANSITION;
    public static final ENUM.VALUES UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$InterstitialTime, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        APP_LAUNCH = new <init>("APP_LAUNCH", 1);
        TRANSITION = new <init>("TRANSITION", 2);
        ENUM.VALUES avalues[] = new <init>[3];
        avalues[0] = UNKNOWN;
        avalues[1] = APP_LAUNCH;
        avalues[2] = TRANSITION;
        ENUM$VALUES = avalues;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
