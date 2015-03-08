// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.a;


public final class e extends Enum
{

    public static final e a;
    public static final e b;
    private static final e c[];

    private e(String s, int i)
    {
        super(s, i);
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/appyet/a/e, s);
    }

    public static e[] values()
    {
        return (e[])c.clone();
    }

    static 
    {
        a = new e("Get", 0);
        b = new e("Post", 1);
        e ae[] = new e[2];
        ae[0] = a;
        ae[1] = b;
        c = ae;
    }
}
