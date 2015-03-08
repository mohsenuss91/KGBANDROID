// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.c.a;
import com.google.a.d.d;
import com.google.a.k;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

// Referenced classes of package com.google.a.b.a:
//            r

final class x extends ak
{

    private final k a;
    private final ak b;
    private final Type c;

    x(k k1, ak ak1, Type type)
    {
        a = k1;
        b = ak1;
        c = type;
    }

    public final Object a(com.google.a.d.a a1)
    {
        return b.a(a1);
    }

    public final void a(d d, Object obj)
    {
        ak ak1 = b;
        Object obj1 = c;
        if (obj != null && (obj1 == java/lang/Object || (obj1 instanceof TypeVariable) || (obj1 instanceof Class)))
        {
            obj1 = obj.getClass();
        }
        ak ak2;
        if (obj1 != c)
        {
            ak2 = a.a(com.google.a.c.a.a(((Type) (obj1))));
            if ((ak2 instanceof r) && !(b instanceof r))
            {
                ak2 = b;
            }
        } else
        {
            ak2 = ak1;
        }
        ak2.a(d, obj);
    }
}
