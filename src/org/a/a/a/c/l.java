// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.c;


public abstract class l
{

    protected short a[];
    protected byte b[];
    protected float c;
    protected boolean d;
    protected String e;

    public l(short aword0[], byte abyte0[], float f, String s)
    {
        a = aword0;
        b = abyte0;
        c = f;
        d = false;
        e = s;
    }

    public final byte a(int i)
    {
        return b[i];
    }

    public final float a()
    {
        return c;
    }

    public final short a(byte byte0)
    {
        int i = byte0 & 0xff;
        return a[i];
    }

    public final String b()
    {
        return e;
    }
}
