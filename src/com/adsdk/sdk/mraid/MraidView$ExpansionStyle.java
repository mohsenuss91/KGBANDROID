// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


public final class  extends Enum
{

    public static final ENUM.VALUES DISABLED;
    public static final ENUM.VALUES ENABLED;
    private static final ENUM.VALUES ENUM$VALUES[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/adsdk/sdk/mraid/MraidView$ExpansionStyle, s);
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
        ENABLED = new <init>("ENABLED", 0);
        DISABLED = new <init>("DISABLED", 1);
        ENUM.VALUES avalues[] = new <init>[2];
        avalues[0] = ENABLED;
        avalues[1] = DISABLED;
        ENUM$VALUES = avalues;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
