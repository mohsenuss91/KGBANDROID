// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ae;
import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.math.BigInteger;

final class af extends ak
{

    af()
    {
    }

    private static BigInteger b(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        BigInteger biginteger;
        try
        {
            biginteger = new BigInteger(a1.h());
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new ae(numberformatexception);
        }
        return biginteger;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(d d1, Object obj)
    {
        d1.a((BigInteger)obj);
    }
}
