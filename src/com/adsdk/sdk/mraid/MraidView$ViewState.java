// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adsdk.sdk.mraid;


public final class  extends Enum
{

    public static final ENUM.VALUES DEFAULT;
    private static final ENUM.VALUES ENUM$VALUES[];
    public static final ENUM.VALUES EXPANDED;
    public static final ENUM.VALUES HIDDEN;
    public static final ENUM.VALUES LOADING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/adsdk/sdk/mraid/MraidView$ViewState, s);
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
        LOADING = new <init>("LOADING", 0);
        DEFAULT = new <init>("DEFAULT", 1);
        EXPANDED = new <init>("EXPANDED", 2);
        HIDDEN = new <init>("HIDDEN", 3);
        ENUM.VALUES avalues[] = new <init>[4];
        avalues[0] = LOADING;
        avalues[1] = DEFAULT;
        avalues[2] = EXPANDED;
        avalues[3] = HIDDEN;
        ENUM$VALUES = avalues;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
