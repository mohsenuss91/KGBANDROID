// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.util.UUID;

final class am extends ak
{

    am()
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
            return UUID.fromString(a1.h());
        }
    }

    public final void a(d d1, Object obj)
    {
        UUID uuid = (UUID)obj;
        String s;
        if (uuid == null)
        {
            s = null;
        } else
        {
            s = uuid.toString();
        }
        d1.b(s);
    }
}
