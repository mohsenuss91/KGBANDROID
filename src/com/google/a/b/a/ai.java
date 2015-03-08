// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import java.net.URL;

final class ai extends ak
{

    ai()
    {
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
        } else
        {
            String s = a1.h();
            if (!"null".equals(s))
            {
                return new URL(s);
            }
        }
        return null;
    }

    public final void a(d d1, Object obj)
    {
        URL url = (URL)obj;
        String s;
        if (url == null)
        {
            s = null;
        } else
        {
            s = url.toExternalForm();
        }
        d1.b(s);
    }
}
