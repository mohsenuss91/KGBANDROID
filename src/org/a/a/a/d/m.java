// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.d;


// Referenced classes of package org.a.a.a.d:
//            k

public abstract class m
{

    protected k a;
    protected int b;
    protected k c;
    protected int d[];
    protected String e;

    public m(k k1, int i, k k2, int ai[], String s)
    {
        a = k1;
        b = i;
        c = k2;
        d = ai;
        e = s;
    }

    public final int a(byte byte0)
    {
        int i = byte0 & 0xff;
        return a.a(i);
    }

    public final int a(int i)
    {
        return d[i];
    }

    public final int a(int i, int j)
    {
        return c.a(i + j * b);
    }

    public final String a()
    {
        return e;
    }
}
