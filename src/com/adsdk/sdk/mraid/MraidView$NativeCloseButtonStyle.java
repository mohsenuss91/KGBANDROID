// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


public final class  extends Enum
{

    public static final ENUM.VALUES AD_CONTROLLED;
    public static final ENUM.VALUES ALWAYS_HIDDEN;
    public static final ENUM.VALUES ALWAYS_VISIBLE;
    private static final ENUM.VALUES ENUM$VALUES[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/adsdk/sdk/mraid/MraidView$NativeCloseButtonStyle, s);
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
        ALWAYS_VISIBLE = new <init>("ALWAYS_VISIBLE", 0);
        ALWAYS_HIDDEN = new <init>("ALWAYS_HIDDEN", 1);
        AD_CONTROLLED = new <init>("AD_CONTROLLED", 2);
        ENUM.VALUES avalues[] = new <init>[3];
        avalues[0] = ALWAYS_VISIBLE;
        avalues[1] = ALWAYS_HIDDEN;
        avalues[2] = AD_CONTROLLED;
        ENUM$VALUES = avalues;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
