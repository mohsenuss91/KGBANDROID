// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.manager;


public final class bo extends Enum
{

    public static final bo a;
    public static final bo b;
    public static final bo c;
    public static final bo d;
    private static final bo e[];

    private bo(String s, int i)
    {
        super(s, i);
    }

    public static bo valueOf(String s)
    {
        return (bo)Enum.valueOf(com/appyet/manager/bo, s);
    }

    public static bo[] values()
    {
        return (bo[])e.clone();
    }

    static 
    {
        a = new bo("Offline", 0);
        b = new bo("Wifi", 1);
        c = new bo("Mobile", 2);
        d = new bo("Unknown", 3);
        bo abo[] = new bo[4];
        abo[0] = a;
        abo[1] = b;
        abo[2] = c;
        abo[3] = d;
        e = abo;
    }
}
