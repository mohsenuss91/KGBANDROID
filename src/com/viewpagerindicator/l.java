// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;


public final class l extends Enum
{

    public static final l a;
    public static final l b;
    public static final l c;
    private static final l e[];
    public final int d;

    private l(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(com/viewpagerindicator/l, s);
    }

    public static l[] values()
    {
        return (l[])e.clone();
    }

    static 
    {
        a = new l("None", 0, 0);
        b = new l("Triangle", 1, 1);
        c = new l("Underline", 2, 2);
        l al[] = new l[3];
        al[0] = a;
        al[1] = b;
        al[2] = c;
        e = al;
    }
}
