// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ae;
import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

final class ba extends ak
{

    ba()
    {
    }

    private static Number b(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        Byte byte1;
        try
        {
            byte1 = Byte.valueOf((byte)a1.m());
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new ae(numberformatexception);
        }
        return byte1;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(d d1, Object obj)
    {
        d1.a((Number)obj);
    }
}
