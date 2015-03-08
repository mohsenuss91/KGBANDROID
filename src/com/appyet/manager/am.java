// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;


public final class am extends Enum
{

    public static final am a;
    public static final am b;
    private static final am c[];

    private am(String s, int i)
    {
        super(s, i);
    }

    public static am valueOf(String s)
    {
        return (am)Enum.valueOf(com/appyet/manager/am, s);
    }

    public static am[] values()
    {
        return (am[])c.clone();
    }

    static 
    {
        a = new am("LocalCache", 0);
        b = new am("SDCardCache", 1);
        am aam[] = new am[2];
        aam[0] = a;
        aam[1] = b;
        c = aam;
    }
}
