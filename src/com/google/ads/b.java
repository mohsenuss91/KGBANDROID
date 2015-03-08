// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    private static final b f[];
    private final String e;

    private b(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/google/ads/b, s);
    }

    public static b[] values()
    {
        return (b[])f.clone();
    }

    public final String toString()
    {
        return e;
    }

    static 
    {
        a = new b("INVALID_REQUEST", 0, "Invalid Ad request.");
        b = new b("NO_FILL", 1, "Ad request successful, but no ad returned due to lack of ad inventory.");
        c = new b("NETWORK_ERROR", 2, "A network error occurred.");
        d = new b("INTERNAL_ERROR", 3, "There was an internal error.");
        b ab[] = new b[4];
        ab[0] = a;
        ab[1] = b;
        ab[2] = c;
        ab[3] = d;
        f = ab;
    }
}
