// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.k;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.a.b.a:
//            b, x

public final class a extends ak
{

    public static final al a = new b();
    private final Class b;
    private final ak c;

    public a(k k, ak ak1, Class class1)
    {
        c = new x(k, ak1, class1);
        b = class1;
    }

    public final Object a(com.google.a.d.a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        ArrayList arraylist = new ArrayList();
        a1.a();
        for (; a1.e(); arraylist.add(c.a(a1))) { }
        a1.b();
        Object obj = Array.newInstance(b, arraylist.size());
        for (int i = 0; i < arraylist.size(); i++)
        {
            Array.set(obj, i, arraylist.get(i));
        }

        return obj;
    }

    public final void a(d d1, Object obj)
    {
        if (obj == null)
        {
            d1.f();
            return;
        }
        d1.b();
        int i = 0;
        for (int j = Array.getLength(obj); i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            c.a(d1, obj1);
        }

        d1.c();
    }

}
