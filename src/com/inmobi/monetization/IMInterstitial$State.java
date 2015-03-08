// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;


public final class  extends Enum
{

    public static final a ACTIVE;
    public static final a INIT;
    public static final a LOADING;
    public static final a READY;
    public static final a UNKNOWN;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/monetization/IMInterstitial$State, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        ACTIVE = new <init>("ACTIVE", 1);
        LOADING = new <init>("LOADING", 2);
        READY = new <init>("READY", 3);
        UNKNOWN = new <init>("UNKNOWN", 4);
        e_3B_.clone aclone[] = new <init>[5];
        aclone[0] = INIT;
        aclone[1] = ACTIVE;
        aclone[2] = LOADING;
        aclone[3] = READY;
        aclone[4] = UNKNOWN;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
