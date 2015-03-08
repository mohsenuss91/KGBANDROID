// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk.impl.net;


public final class  extends Enum
{

    public static final a AdRequest;
    public static final a AdRequest_Interstitial;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/androidsdk/impl/net/RequestResponseManager$ActionType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        AdRequest = new <init>("AdRequest", 0);
        AdRequest_Interstitial = new <init>("AdRequest_Interstitial", 1);
        e_3B_.clone aclone[] = new <init>[2];
        aclone[0] = AdRequest;
        aclone[1] = AdRequest_Interstitial;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
