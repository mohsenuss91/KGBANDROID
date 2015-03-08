// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.context;


public final class d extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    private d(String s, int i)
    {
        super(s, i);
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/appyet/context/d, s);
    }

    public static d[] values()
    {
        return (d[])e.clone();
    }

    static 
    {
        a = new d("Module", 0);
        b = new d("Search", 1);
        c = new d("FeedQuery", 2);
        d = new d("All", 3);
        d ad[] = new d[4];
        ad[0] = a;
        ad[1] = b;
        ad[2] = c;
        ad[3] = d;
        e = ad;
    }
}
