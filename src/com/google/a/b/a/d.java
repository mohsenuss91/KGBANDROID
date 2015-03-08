// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.b.ae;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.k;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.a.b.a:
//            x

final class d extends ak
{

    private final ak a;
    private final ae b;

    public d(k k, Type type, ak ak1, ae ae1)
    {
        a = new x(k, ak1, type);
        b = ae1;
    }

    public final Object a(a a1)
    {
        if (a1.f() == c.i)
        {
            a1.j();
            return null;
        }
        Collection collection = (Collection)b.a();
        a1.a();
        for (; a1.e(); collection.add(a.a(a1))) { }
        a1.b();
        return collection;
    }

    public final void a(com.google.a.d.d d1, Object obj)
    {
        Collection collection = (Collection)obj;
        if (collection == null)
        {
            d1.f();
            return;
        }
        d1.b();
        Object obj1;
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); a.a(d1, obj1))
        {
            obj1 = iterator.next();
        }

        d1.c();
    }
}
