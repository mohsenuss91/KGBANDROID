// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons;


public final class a extends Enum
{

    public static final b DEBUG;
    public static final b NONE;
    public static final b VERBOSE;
    private static final b b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/InMobi$LOG_LEVEL, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    public final int getValue()
    {
        return a;
    }

    static 
    {
        NONE = new <init>("NONE", 0, 0);
        DEBUG = new <init>("DEBUG", 1, 1);
        VERBOSE = new <init>("VERBOSE", 2, 2);
        a aa[] = new <init>[3];
        aa[0] = NONE;
        aa[1] = DEBUG;
        aa[2] = VERBOSE;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
