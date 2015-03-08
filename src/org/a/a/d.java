// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a;


public final class d extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    private static final d d[];

    private d(String s, int i)
    {
        super(s, i);
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(org/a/a/d, s);
    }

    public static d[] values()
    {
        return (d[])d.clone();
    }

    static 
    {
        a = new d("PURE_ASCII", 0);
        b = new d("ESC_ASCII", 1);
        c = new d("HIGHBYTE", 2);
        d ad[] = new d[3];
        ad[0] = a;
        ad[1] = b;
        ad[2] = c;
        d = ad;
    }
}
