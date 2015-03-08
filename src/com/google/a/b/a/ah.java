// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

final class ah extends ak
{

    ah()
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
            return new StringBuffer(a1.h());
        }
    }

    public final void a(d d1, Object obj)
    {
        StringBuffer stringbuffer = (StringBuffer)obj;
        String s;
        if (stringbuffer == null)
        {
            s = null;
        } else
        {
            s = stringbuffer.toString();
        }
        d1.b(s);
    }
}
