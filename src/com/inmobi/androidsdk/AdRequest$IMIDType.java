// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;


public final class  extends Enum
{

    public static final a ID_LOGIN;
    public static final a ID_SESSION;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/androidsdk/AdRequest$IMIDType, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        ID_LOGIN = new <init>("ID_LOGIN", 0);
        ID_SESSION = new <init>("ID_SESSION", 1);
        e_3B_.clone aclone[] = new <init>[2];
        aclone[0] = ID_LOGIN;
        aclone[1] = ID_SESSION;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
