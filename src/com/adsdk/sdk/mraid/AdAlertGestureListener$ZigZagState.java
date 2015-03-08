// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


final class  extends Enum
{

    private static final ENUM.VALUES ENUM$VALUES[];
    public static final ENUM.VALUES FAILED;
    public static final ENUM.VALUES FINISHED;
    public static final ENUM.VALUES GOING_LEFT;
    public static final ENUM.VALUES GOING_RIGHT;
    public static final ENUM.VALUES UNSET;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/adsdk/sdk/mraid/AdAlertGestureListener$ZigZagState, s);
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
        UNSET = new <init>("UNSET", 0);
        GOING_RIGHT = new <init>("GOING_RIGHT", 1);
        GOING_LEFT = new <init>("GOING_LEFT", 2);
        FINISHED = new <init>("FINISHED", 3);
        FAILED = new <init>("FAILED", 4);
        ENUM.VALUES avalues[] = new <init>[5];
        avalues[0] = UNSET;
        avalues[1] = GOING_RIGHT;
        avalues[2] = GOING_LEFT;
        avalues[3] = FINISHED;
        avalues[4] = FAILED;
        ENUM$VALUES = avalues;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
