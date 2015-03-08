// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;


public final class m extends Enum
{

    public static final m a;
    public static final m b;
    private static final m d[];
    public final int c;

    private m(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/viewpagerindicator/m, s);
    }

    public static m[] values()
    {
        return (m[])d.clone();
    }

    static 
    {
        a = new m("Bottom", 0, 0);
        b = new m("Top", 1, 1);
        m am[] = new m[2];
        am[0] = a;
        am[1] = b;
        d = am;
    }
}
