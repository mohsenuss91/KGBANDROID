// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ae;
import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

final class ac extends ak
{

    ac()
    {
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        String s = a1.h();
        if (s.length() != 1)
        {
            throw new ae((new StringBuilder("Expecting character, got: ")).append(s).toString());
        } else
        {
            return Character.valueOf(s.charAt(0));
        }
    }

    public final void a(d d1, Object obj)
    {
        Character character = (Character)obj;
        String s;
        if (character == null)
        {
            s = null;
        } else
        {
            s = String.valueOf(character);
        }
        d1.b(s);
    }
}
