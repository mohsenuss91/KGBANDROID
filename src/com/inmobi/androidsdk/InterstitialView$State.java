// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;


public final class  extends Enum
{

    public static final a ACTIVE;
    public static final a INIT;
    public static final a LOADING;
    public static final a READY;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/androidsdk/InterstitialView$State, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        INIT = new <init>("INIT", 0);
        READY = new <init>("READY", 1);
        LOADING = new <init>("LOADING", 2);
        ACTIVE = new <init>("ACTIVE", 3);
        e_3B_.clone aclone[] = new <init>[4];
        aclone[0] = INIT;
        aclone[1] = READY;
        aclone[2] = LOADING;
        aclone[3] = ACTIVE;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
