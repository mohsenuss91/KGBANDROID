// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ab;
import com.google.a.ak;
import com.google.a.b.v;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.t;
import com.google.a.w;
import com.google.a.y;
import com.google.a.z;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.a.b.a:
//            ay

final class ar extends ak
{

    ar()
    {
    }

    private void a(d d1, w w1)
    {
        if (w1 == null || w1.j())
        {
            d1.f();
            return;
        }
        if (w1.i())
        {
            ab ab1 = w1.m();
            if (ab1.o())
            {
                d1.a(ab1.a());
                return;
            }
            if (ab1.n())
            {
                d1.a(ab1.f());
                return;
            } else
            {
                d1.b(ab1.b());
                return;
            }
        }
        if (w1.g())
        {
            d1.b();
            for (Iterator iterator1 = w1.l().iterator(); iterator1.hasNext(); a(d1, (w)iterator1.next())) { }
            d1.c();
            return;
        }
        if (w1.h())
        {
            d1.d();
            java.util.Map.Entry entry;
            for (Iterator iterator = w1.k().n().iterator(); iterator.hasNext(); a(d1, (w)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
                d1.a((String)entry.getKey());
            }

            d1.e();
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Couldn't write ")).append(w1.getClass()).toString());
        }
    }

    private w b(a a1)
    {
        z z1;
        switch (com.google.a.b.a.ay.a[a1.f().ordinal()])
        {
        default:
            throw new IllegalArgumentException();

        case 3: // '\003'
            return new ab(a1.h());

        case 1: // '\001'
            return new ab(new v(a1.h()));

        case 2: // '\002'
            return new ab(Boolean.valueOf(a1.i()));

        case 4: // '\004'
            a1.j();
            return y.a;

        case 5: // '\005'
            t t1 = new t();
            a1.a();
            for (; a1.e(); t1.a(b(a1))) { }
            a1.b();
            return t1;

        case 6: // '\006'
            z1 = new z();
            a1.c();
            break;
        }
        for (; a1.e(); z1.a(a1.g(), b(a1))) { }
        a1.d();
        return z1;
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(d d1, Object obj)
    {
        a(d1, (w)obj);
    }
}
