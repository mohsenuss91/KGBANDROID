// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;


public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    private c(String s, int i)
    {
        super(s, i);
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(org/a/a/a/c, s);
    }

    public static c[] values()
    {
        return (c[])d.clone();
    }

    static 
    {
        a = new c("DETECTING", 0);
        b = new c("FOUND_IT", 1);
        c = new c("NOT_ME", 2);
        c ac[] = new c[3];
        ac[0] = a;
        ac[1] = b;
        ac[2] = c;
        d = ac;
    }
}
