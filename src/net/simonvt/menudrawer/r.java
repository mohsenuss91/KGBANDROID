// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.simonvt.menudrawer;


public final class r extends Enum
{

    public static final r a;
    public static final r b;
    public static final r c;
    private static final r d[];

    private r(String s, int i)
    {
        super(s, i);
    }

    public static r valueOf(String s)
    {
        return (r)Enum.valueOf(net/simonvt/menudrawer/r, s);
    }

    public static r[] values()
    {
        return (r[])d.clone();
    }

    static 
    {
        a = new r("BEHIND", 0);
        b = new r("STATIC", 1);
        c = new r("OVERLAY", 2);
        r ar[] = new r[3];
        ar[0] = a;
        ar[1] = b;
        ar[2] = c;
        d = ar;
    }
}
