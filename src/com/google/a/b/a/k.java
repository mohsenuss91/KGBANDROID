// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b.a;

import com.google.a.ak;
import com.google.a.al;
import com.google.a.b.b;
import com.google.a.b.f;
import com.google.a.c.a;
import java.util.Map;

// Referenced classes of package com.google.a.b.a:
//            y, l

public final class k
    implements al
{

    final boolean a;
    private final f b;

    public k(f f1, boolean flag)
    {
        b = f1;
        a = flag;
    }

    public final ak a(com.google.a.k k1, a a1)
    {
        java.lang.reflect.Type type = a1.b;
        if (!java/util/Map.isAssignableFrom(a1.a))
        {
            return null;
        }
        java.lang.reflect.Type atype[] = com.google.a.b.b.b(type, com.google.a.b.b.b(type));
        java.lang.reflect.Type type1 = atype[0];
        ak ak;
        ak ak1;
        com.google.a.b.ae ae;
        if (type1 == Boolean.TYPE || type1 == java/lang/Boolean)
        {
            ak = com.google.a.b.a.y.f;
        } else
        {
            ak = k1.a(com.google.a.c.a.a(type1));
        }
        ak1 = k1.a(com.google.a.c.a.a(atype[1]));
        ae = b.a(a1);
        return new l(this, k1, atype[0], ak, atype[1], ak1, ae);
    }
}
