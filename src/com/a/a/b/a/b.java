// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.b.a;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    private static final b f[];

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/a/a/b/a/b, s);
    }

    public static b[] values()
    {
        return (b[])f.clone();
    }

    static 
    {
        a = new b("IO_ERROR", 0);
        b = new b("DECODING_ERROR", 1);
        c = new b("NETWORK_DENIED", 2);
        d = new b("OUT_OF_MEMORY", 3);
        e = new b("UNKNOWN", 4);
        b ab[] = new b[5];
        ab[0] = a;
        ab[1] = b;
        ab[2] = c;
        ab[3] = d;
        ab[4] = e;
        f = ab;
    }
}
