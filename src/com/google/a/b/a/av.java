// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

final class av extends ak
{

    av()
    {
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        if (a1.f() == c.f)
        {
            return Boolean.valueOf(Boolean.parseBoolean(a1.h()));
        } else
        {
            return Boolean.valueOf(a1.i());
        }
    }

    public final void a(d d1, Object obj)
    {
        Boolean boolean1 = (Boolean)obj;
        if (boolean1 == null)
        {
            d1.f();
            return;
        } else
        {
            d1.a(boolean1.booleanValue());
            return;
        }
    }
}
