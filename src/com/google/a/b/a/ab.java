// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ae;
import com.google.a.ak;
import com.google.a.b.v;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;

// Referenced classes of package com.google.a.b.a:
//            ay

final class ab extends ak
{

    ab()
    {
    }

    public final Object a(a a1)
    {
        c c1 = a1.f();
        switch (com.google.a.b.a.ay.a[c1.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            throw new ae((new StringBuilder("Expecting number, got: ")).append(c1).toString());

        case 4: // '\004'
            a1.j();
            return null;

        case 1: // '\001'
            return new v(a1.h());
        }
    }

    public final volatile void a(d d1, Object obj)
    {
        d1.a((Number)obj);
    }
}
