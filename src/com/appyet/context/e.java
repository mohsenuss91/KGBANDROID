// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appyet.context;


public final class e extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    public static final e f;
    public static final e g;
    private static final e h[];

    private e(String s, int i)
    {
        super(s, i);
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/appyet/context/e, s);
    }

    public static e[] values()
    {
        return (e[])h.clone();
    }

    static 
    {
        a = new e("UnreadFirst", 0);
        b = new e("ReadFirst", 1);
        c = new e("PubDateAscending", 2);
        d = new e("PubDateDescending", 3);
        e = new e("Title", 4);
        f = new e("DownloadDateAscending", 5);
        g = new e("DownloadDateDescending", 6);
        e ae[] = new e[7];
        ae[0] = a;
        ae[1] = b;
        ae[2] = c;
        ae[3] = d;
        ae[4] = e;
        ae[5] = f;
        ae[6] = g;
        h = ae;
    }
}
