// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.b.a;


public final class v extends Enum
{

    public static final v a;
    public static final v b;
    public static final v c;
    private static final v d[];

    private v(String s, int i)
    {
        super(s, i);
    }

    public static v valueOf(String s)
    {
        return (v)Enum.valueOf(com/appyet/b/a/v, s);
    }

    public static v[] values()
    {
        return (v[])d.clone();
    }

    static 
    {
        a = new v("Success", 0);
        b = new v("Failed", 1);
        c = new v("NoChange", 2);
        v av[] = new v[3];
        av[0] = a;
        av[1] = b;
        av[2] = c;
        d = av;
    }
}
