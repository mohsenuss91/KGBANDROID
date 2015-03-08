// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;


public final class a extends Enum
{

    public static final b DEBUG;
    public static final b INTERNAL;
    public static final b NONE;
    public static final b NOT_SET;
    public static final b VERBOSE;
    private static final b b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/commons/internal/Log$INTERNAL_LOG_LEVEL, s);
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
        NOT_SET = new <init>("NOT_SET", 0, -1);
        NONE = new <init>("NONE", 1, 0);
        DEBUG = new <init>("DEBUG", 2, 1);
        VERBOSE = new <init>("VERBOSE", 3, 2);
        INTERNAL = new <init>("INTERNAL", 4, 3);
        a aa[] = new <init>[5];
        aa[0] = NOT_SET;
        aa[1] = NONE;
        aa[2] = DEBUG;
        aa[3] = VERBOSE;
        aa[4] = INTERNAL;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
