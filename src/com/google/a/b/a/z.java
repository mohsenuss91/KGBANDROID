// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

final class z extends ak
{

    z()
    {
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        } else
        {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    public final void a(d d1, Object obj)
    {
        Class class1 = (Class)obj;
        if (class1 == null)
        {
            d1.f();
            return;
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder("Attempted to serialize java.lang.Class: ")).append(class1.getName()).append(". Forgot to register a type adapter?").toString());
        }
    }
}
