// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.b.w;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.a.b.a:
//            n, o

public final class m extends ak
{

    public static final al a = new n();
    private final k b;

    private m(k k1)
    {
        b = k1;
    }

    m(k k1, byte byte0)
    {
        this(k1);
    }

    public final Object a(a a1)
    {
        c c1 = a1.f();
        switch (com.google.a.b.a.o.a[c1.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            a1.a();
            for (; a1.e(); arraylist.add(a(a1))) { }
            a1.b();
            return arraylist;

        case 2: // '\002'
            w w1 = new w();
            a1.c();
            for (; a1.e(); w1.put(a1.g(), a(a1))) { }
            a1.d();
            return w1;

        case 3: // '\003'
            return a1.h();

        case 4: // '\004'
            return Double.valueOf(a1.k());

        case 5: // '\005'
            return Boolean.valueOf(a1.i());

        case 6: // '\006'
            a1.j();
            return null;
        }
    }

    public final void a(d d1, Object obj)
    {
        if (obj == null)
        {
            d1.f();
            return;
        }
        ak ak1 = b.a(obj.getClass());
        if (ak1 instanceof m)
        {
            d1.d();
            d1.e();
            return;
        } else
        {
            ak1.a(d1, obj);
            return;
        }
    }

}
