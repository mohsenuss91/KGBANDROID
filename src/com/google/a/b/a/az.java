// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

final class az extends ak
{

    az()
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
            return Boolean.valueOf(a1.h());
        }
    }

    public final void a(d d1, Object obj)
    {
        Boolean boolean1 = (Boolean)obj;
        String s;
        if (boolean1 == null)
        {
            s = "null";
        } else
        {
            s = boolean1.toString();
        }
        d1.b(s);
    }
}
