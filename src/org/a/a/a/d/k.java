// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.d;


public final class k
{

    private int a;
    private int b;
    private int c;
    private int d;
    private int e[];

    public k(int ai[])
    {
        a = 3;
        b = 7;
        c = 2;
        d = 15;
        e = ai;
    }

    public static int a(int i, int j, int l, int i1, int j1, int k1, int l1, int i2)
    {
        int j2 = i | j << 4;
        int k2 = l | i1 << 4;
        int l2 = j1 | k1 << 4;
        int i3 = l1 | i2 << 4;
        return j2 | k2 << 8 | (l2 | i3 << 8) << 16;
    }

    public final int a(int i)
    {
        return e[i >> a] >> ((i & b) << c) & d;
    }
}
