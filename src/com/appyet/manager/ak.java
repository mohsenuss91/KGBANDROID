// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;


public final class ak extends Enum
{

    public static final ak a;
    public static final ak b;
    public static final ak c;
    private static final ak d[];

    private ak(String s, int i)
    {
        super(s, i);
    }

    public static ak valueOf(String s)
    {
        return (ak)Enum.valueOf(com/appyet/manager/ak, s);
    }

    public static ak[] values()
    {
        return (ak[])d.clone();
    }

    static 
    {
        a = new ak("Name", 0);
        b = new ak("Date", 1);
        c = new ak("Size", 2);
        ak aak[] = new ak[3];
        aak[0] = a;
        aak[1] = b;
        aak[2] = c;
        d = aak;
    }
}
