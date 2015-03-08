// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


public final class  extends Enum
{

    public static final a AD_NETWORK;
    public static final a APP_GALLERY;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/monetization/IMInterstitial$AdMode, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        AD_NETWORK = new <init>("AD_NETWORK", 0);
        APP_GALLERY = new <init>("APP_GALLERY", 1);
        e_3B_.clone aclone[] = new <init>[2];
        aclone[0] = AD_NETWORK;
        aclone[1] = APP_GALLERY;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
