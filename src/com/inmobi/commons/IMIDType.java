// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class IMIDType extends Enum
{

    public static final IMIDType ID_LOGIN;
    public static final IMIDType ID_SESSION;
    private static final IMIDType a[];

    private IMIDType(String s, int i)
    {
        super(s, i);
    }

    public static IMIDType valueOf(String s)
    {
        return (IMIDType)Enum.valueOf(com/inmobi/commons/IMIDType, s);
    }

    public static IMIDType[] values()
    {
        return (IMIDType[])a.clone();
    }

    static 
    {
        ID_LOGIN = new IMIDType("ID_LOGIN", 0);
        ID_SESSION = new IMIDType("ID_SESSION", 1);
        IMIDType aimidtype[] = new IMIDType[2];
        aimidtype[0] = ID_LOGIN;
        aimidtype[1] = ID_SESSION;
        a = aimidtype;
    }
}
