// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;


public final class Mode extends Enum
{

    public static final Mode AD_NETWORK;
    public static final Mode APP_GALLERY;
    private static final Mode a[];

    private Mode(String s, int i)
    {
        super(s, i);
    }

    public static Mode valueOf(String s)
    {
        return (Mode)Enum.valueOf(com/inmobi/androidsdk/Mode, s);
    }

    public static Mode[] values()
    {
        return (Mode[])a.clone();
    }

    static 
    {
        AD_NETWORK = new Mode("AD_NETWORK", 0);
        APP_GALLERY = new Mode("APP_GALLERY", 1);
        Mode amode[] = new Mode[2];
        amode[0] = AD_NETWORK;
        amode[1] = APP_GALLERY;
        a = amode;
    }
}
