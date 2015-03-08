// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.context;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/appyet/context/b, s);
    }

    public static b[] values()
    {
        return (b[])c.clone();
    }

    static 
    {
        a = new b("InstapaperMobilizer", 0);
        b = new b("GoogleMobilizer", 1);
        b ab[] = new b[2];
        ab[0] = a;
        ab[1] = b;
        c = ab;
    }
}
